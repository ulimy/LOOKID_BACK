package lookid.server.service;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

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

	@Override
	public SuccessDTO checkId(String id) throws Exception {

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

	@Override
	public SuccessDTO signup(UserVO user) throws Exception {

		int beforeInsert, afterInsert;

		try {
			beforeInsert = count();
			dao.signup(user);
			afterInsert = count();

			if (beforeInsert == afterInsert) {
				return fail;
			} else {
				return success;
			}

		} catch (Exception e) {
			return fail;
		}

	}

	@Override
	public FindIdDTO find_id(FindIdDTO user) throws Exception {

		try {
			dao.find_id(user).getId();
			return dao.find_id(user);

		} catch (NullPointerException e) {
			FindIdDTO fdto = new FindIdDTO();
			return fdto;
		}

	}

	@Override
	public SuccessDTO find_pw(FindPwDTO user) throws FileNotFoundException, URISyntaxException, Exception {

		try {
			String mail = dao.find_pw(user);
			String temp_pw;

			if (mail != null) {
				Random rnd = new Random();
				StringBuffer buf = new StringBuffer();

				for (int i = 0; i < 10; i++) {

					if (rnd.nextBoolean()) {
						buf.append((char) ((int) (rnd.nextInt(26)) + 97));
					} else {
						buf.append((rnd.nextInt(10)));
					}
				}
				temp_pw = buf.toString();

				String subject = "루키드 LOOKID 임시 비밀번호 발급입니다.";
				String text = "안녕하세요. LOOKID 입니다.<br><br>회원님의 LOOKID 임시 비밀번호가 발급되었습니다." + "<br><br>"
						+ "임시 비밀번호로 로그인하여 '내 정보 수정' -> '비밀번호 변경' 을 해주세요." + "<br><br>" + "임시 비밀번호 : " + temp_pw
						+ "<br><br>LOOKID를 이용하여 주셔서 감사합니다.";

				try {

					MimeMessage message = mailSender.createMimeMessage();
					message.setFrom(new InternetAddress("smulookid@gmail.com"));
					message.addRecipient(RecipientType.TO, new InternetAddress(mail));
					message.setSubject(subject);
					message.setText(text, "utf-8", "html");
					mailSender.send(message);
				} catch (Exception e) {
					return fail;
				}

				ModifyTempPwDTO mtp = new ModifyTempPwDTO();
				mtp.setMail(mail);
				mtp.setPw(temp_pw);
				mtp.setId(user.getId());

				dao.modify_temp_pw(mtp);

				return success;
			} else {
				return fail;
			}
		} catch (Exception e) {
			return fail;
		}
	}

	@Override
	public AdminDTO find_admin(String id) throws Exception {

		try {
			dao.find_admin(id).getName();
			return dao.find_admin(id);

		} catch (NullPointerException e) {
			AdminDTO fdto = new AdminDTO();
			return fdto;
		}
	}

	@Override
	public int count() throws Exception {
		return dao.count();
	}

}
