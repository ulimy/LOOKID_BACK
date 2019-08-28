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
		// 토큰 자체는 삭제 못하나 destroy한 토큰에 요청이 들어오면 잘못된 접근임을 알수있게 무효화 해주는 destroy메소드 구현
		
		String token = request.getHeader("Authorization"); // HTTP 헤더에 담긴 토큰을 꺼냄 (요청)
		
		try {
			if (token != null && JWTService.isUsable(token)) {

				token = JWTService.detroy(token);
			
				try {
					if (token != null && JWTService.isUsable(token)) {
						System.out.println("토큰이 아직 유효합니다.");
					}
				} catch (Exception e) {
					System.out.println("토큰이 삭제되었습니다. 로그아웃 성공");
					System.out.println(e);
				}

			} else {
				System.out.println("HTTP JWT 파싱 실패");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return;
	}

	// 비밀번호 변경
	@Override
	public SuccessDTO modify_pw(ModifyPwDTO user, HttpServletRequest request) throws Exception {
		
		final String token = request.getHeader("Authorization"); // HTTP 헤더에 담긴 토큰을 꺼냄 (요청)
	
		try {

			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token); // 토큰 user_pid 파싱
				
				ModifyPwDTO mpdto = new ModifyPwDTO();
				mpdto.setUser_pid(user_pid);
				mpdto.setPw(user.getPw());

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

		final String token = request.getHeader("Authorization"); // HTTP 헤더에 담긴 토큰을 꺼냄 (요청)

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
