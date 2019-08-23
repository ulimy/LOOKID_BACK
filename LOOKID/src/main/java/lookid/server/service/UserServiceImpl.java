package lookid.server.service;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lookid.server.dao.UserDAO;
import lookid.server.dto.FindAdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.FindPwDTO;
import lookid.server.dto.ModifyTempPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.dto.UserDTO;
import lookid.server.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	@Qualifier("JWTService")
	private JWTService JWTService;

	private final SuccessDTO success = new SuccessDTO(true);
	private final SuccessDTO fail = new SuccessDTO(false);

	// 아이디 중복확인
	@Override
	public SuccessDTO checkId(String id) throws Exception {
		try {
			if (dao.checkId(id) != 0) {
				return success;
			} else {
				return null;
			}
		} catch (Exception e) {
			return fail;
		}

	}

	// 회원가입
	@Override
	public SuccessDTO signup(UserVO user) throws Exception {

		// phone이 중복되어 insert 안 됐을 시 fail 리턴 예외처리
		int beforeInsert, afterInsert;

		try {
			beforeInsert = count();
			dao.signup(user);
			afterInsert = count();

			if (beforeInsert == afterInsert) { // phone 중복으로 튜플이 늘어나지 않았을 때 fail을 리턴
				return fail;
			} else { // phone이 중복되지 않아 정상적으로 회원가입 완료
				return success;
			}

		} catch (Exception e) {
			return fail;
		}

	}

	// 로그인
	@Override
	public UserDTO signin(SigninDTO user, HttpServletResponse response) throws Exception {
		// jwt토큰 생성
		// user_pid는 토큰에, 나머지정보는 UserDTO에 담기

		int user_pid; // user_pid jwt생성에 이용

		UserVO uvo = dao.signin(user);

		user_pid = uvo.getUser_pid();
		UserDTO udto = new UserDTO(uvo.getId(), uvo.getPw(), uvo.getName(), uvo.getPhone(), uvo.getMail(),
				uvo.getAddress(), uvo.getBank_name(), uvo.getBank_num(), uvo.getBank_holder());

		String token = JWTService.create("user_pid", user_pid); // 토큰 생성

		if (JWTService.isUsable(token)) {
			response.setHeader("Authorization", token); // http 헤더에 토큰 담기

			System.out.println("token : ");
			System.out.println("[ " + token + " ]"); //jwt 콘솔 출력

		}

		/*
		 * 파싱 테스트
		 */
		int u_pid = JWTService.getUser_pid(token); // 토큰 user_pid 파싱
		System.out.println(u_pid);
	
		return udto; // 안드로이드에게 userDTO정보를 넘겨줌.
	}

	// 아이디 찾기
	@Override
	public FindIdDTO find_id(FindIdDTO user) throws Exception {

		return dao.find_id(user);
	}

	// 비밀번호 찾기
	@Override
	public SuccessDTO find_pw(FindPwDTO user) throws FileNotFoundException, URISyntaxException, Exception {
		// find_pw 랜덤스트링 mail전송, 기존 pw를 랜덤스트링으로 db수정

		String mail = dao.find_pw(user); // 임시비밀번호가 보내질 회원의 mail
		String temp_pw; // 임시비밀번호

		/*
		 * 랜덤스트링 임시비밀번호 생성
		 */
		if (mail != null) {
			Random rnd = new Random();
			StringBuffer buf = new StringBuffer();

			for (int i = 0; i < 10; i++) { // 10자리 랜덤스트링 생성
				// rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤한
				// 숫자를 StringBuffer에 append.
				if (rnd.nextBoolean()) {
					buf.append((char) ((int) (rnd.nextInt(26)) + 97));
				} else {
					buf.append((rnd.nextInt(10)));
				}
			}
			temp_pw = buf.toString();

			String subject = "루키드 LOOKID 임시 비밀번호 발급입니다."; // 메일 제목
			String text = "회원님의 임시 비밀번호가 발급되었습니다." + "\n\n" + "임시 비밀번호로 로그인하여 '내 정보 수정' -> '비밀번호 변경' 을 해주세요." + "\n\n"
					+ "임시 비밀번호 : " + temp_pw; // 메일 내용

			/*
			 * 메일 전송 api
			 * 
			 */
			try {

				MimeMessage message = mailSender.createMimeMessage();
				message.setFrom(new InternetAddress("smulookid@gmail.com"));
				message.addRecipient(RecipientType.TO, new InternetAddress(mail));
				message.setSubject(subject);
				message.setText(text, "utf-8", "html");
				mailSender.send(message);
			} catch (Exception e) {
				e.printStackTrace();
				return fail;
			}

			/*
			 * db 임시비밀번호로 수정
			 */
			ModifyTempPwDTO mtp = new ModifyTempPwDTO();
			mtp.setMail(mail);
			mtp.setPw(temp_pw);
			mtp.setId(user.getId()); // mail과함께 입력한 id 까지 where 조건으로 들어가야 동일 이메일 전부다 임시비밀번호로 바뀌는 오류 방지

			dao.modify_temp_pw(mtp);

			return success;
		} else {
			return fail;
		}
	}

	// 관리자 검색
	@Override
	public FindAdminDTO find_admin(String id) throws Exception {
		return dao.find_admin(id);
	}

	@Override
	public int count() throws Exception {
		return dao.count();
	}

}
