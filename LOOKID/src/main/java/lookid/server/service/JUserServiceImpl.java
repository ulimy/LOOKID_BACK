package lookid.server.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lookid.server.dao.JUserDAO;
import lookid.server.dto.ModifyPwDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

@Service("JUserService")
public class JUserServiceImpl implements JUserService {

	@Autowired
	private JUserDAO jdao;

	@Autowired
	@Qualifier("JWTService")
	private JWTService JWTService;

	private final SuccessDTO success = new SuccessDTO(true);
	private final SuccessDTO fail = new SuccessDTO(false);

	// 로그아웃
	@Override
	public void signout(HttpServletRequest request) throws Exception {
		// destroy 메소드를 통해 토큰 무효화
		// destroy 메소드 구현
		// 토큰 자체는 삭제 못하나 destroy한 토큰에 요청이 들어오면 잘못된 접근임을 알수있게 무효화 해주는 destroy메소드 구현
		
		//HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		final String token = request.getHeader("Authorization");
		System.out.println(token); // 헤더에서 꺼낸 토큰 콘솔 출력
		
		// String token = "";
		try {
			if (token != null && JWTService.isUsable(token)) {

				JWTService.detroy(token);

				if (token != null && JWTService.isUsable(token)) {
					System.out.println("아직유효");
				} else {
					System.out.println("삭제완료");
				}

			} else {
				System.out.println("jwt 파싱 실패");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return;
	}

	// 비밀번호 변경
	@Override
	public SuccessDTO modify_pw(String pw, HttpServletRequest request) throws Exception {
		
		// http에서 토큰 파싱만 되면 modify_pw 구현완료
		final String token = request.getHeader("Authorization");
		System.out.println(token);


		//String token = "";
		try {

			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token); // 토큰 user_pid 파싱

				ModifyPwDTO mpdto = new ModifyPwDTO(user_pid, pw);

				jdao.modify_pw(mpdto);

				return success;
			} else {
				return fail;
			}

		} catch (Exception e) {
			return fail;
		}

	}

	// 내 정보 수정
	@Override
	public SuccessDTO modify(UserVO user, HttpServletRequest request) throws Exception {

		// http에서 토큰 파싱만 되면 modify 구현완료 
		final String token = request.getHeader("Authorization");
		System.out.println(token);

		
		//String token = "";
		try {

			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token); // 토큰 user_pid 파싱
				user.setUser_pid(user_pid); // 헤더에서 꺼낸 토큰에서 파싱된 user_pid를 where 조건으로 사용하기위해 set

				jdao.modify(user);
				return success;
			} else {
				return fail;
			}

		} catch (Exception e) {
			return fail;
		}
	}

}
