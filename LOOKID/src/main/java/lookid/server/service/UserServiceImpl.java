package lookid.server.service;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lookid.server.dao.UserDAO;
import lookid.server.dto.AdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.FindPwDTO;
import lookid.server.dto.ModifyTempPwDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Autowired
	private JavaMailSender mailSender;

	private final SuccessDTO success = new SuccessDTO(true);
	private final SuccessDTO fail = new SuccessDTO(false);

	// 아이디 중복확인
	@Override
	public SuccessDTO checkId(String id) throws Exception {
		// 아이디가 이미 존재하면 false 존재하지 않으면 true 리턴
		try {
			if (dao.checkId(id) != 0) {
				return fail;
			} else {
				return null;
			}
		} catch (Exception e) {
			return success;
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
			} else { // phone이 중복되지 않아 튜플이 늘어났을 때 정상적으로 회원가입 완료
				return success;
			}

		} catch (Exception e) {
			return fail;
		}

	}

	// 아이디 찾기
	@Override
	public FindIdDTO find_id(FindIdDTO user) throws Exception{

		try {
			dao.find_id(user).getId(); // NullPointerException 발생 시 catch문으로 이동시킴
			return dao.find_id(user);
			
		} catch (NullPointerException e) {
			FindIdDTO fdto = new FindIdDTO();
			return fdto; // 찾는 id 가 존재하지 않을 시 속성들을 null 값으로 리턴
		}
		
	}

	// 비밀번호 찾기
	@Override
	public SuccessDTO find_pw(FindPwDTO user) throws FileNotFoundException, URISyntaxException, Exception {
		// 랜덤스트링을 생성하여 mail전송, 기존 pw를 생성된 랜덤스트링으로 db수정

		try {
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
						buf.append((char) ((int) (rnd.nextInt(26)) + 97)); // 소문자
					} else {
						buf.append((rnd.nextInt(10))); // 0~9 정수
					}
				}
				temp_pw = buf.toString();

				/*
				 * 메일 전송 api
				 * 
				 */
				
				String subject = "루키드 LOOKID 임시 비밀번호 발급입니다."; // 메일 제목
				String text = "안녕하세요. LOOKID 입니다.<br><br>회원님의 LOOKID 임시 비밀번호가 발급되었습니다." + "<br><br>" + "임시 비밀번호로 로그인하여 '내 정보 수정' -> '비밀번호 변경' 을 해주세요."
						+ "<br><br>" + "임시 비밀번호 : " + temp_pw + "<br><br>LOOKID를 이용하여 주셔서 감사합니다."; // 메일 내용

				try {

					MimeMessage message = mailSender.createMimeMessage();
					message.setFrom(new InternetAddress("smulookid@gmail.com")); // 발신자
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
				mtp.setId(user.getId()); // mail과함께 입력한 id 까지 where 조건으로 들어가야 동일 이메일 전부다 같은 임시비밀번호로 바뀌는 오류 방지할 수 있음

				dao.modify_temp_pw(mtp);

				return success;
			} else {
				return fail;
			}
		} catch (Exception e) {
			return fail;
		}
	}

	// 관리자 검색
	@Override
	public AdminDTO find_admin(String id) throws Exception {
		
		try {
			dao.find_admin(id).getName(); // NullPointerException 발생 시 catch문으로 이동시킴
			return dao.find_admin(id);
			
		} catch (NullPointerException e) {
			AdminDTO fdto = new AdminDTO();
			return fdto; // 관리자 id 가 존재하지 않을 시 속성들을 null 값으로 리턴
		}
	}

	// user 테이블 튜플 카운트
	@Override
	public int count() throws Exception {
		return dao.count();
	}

}
