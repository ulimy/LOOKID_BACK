package lookid.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lookid.server.exception.UnauthorizedException;
import lookid.server.service.JWTService;

@Component
public class JWTInterceptor extends HandlerInterceptorAdapter {
	// jwt인터셉터를 이용하여 컨트롤러로 들어오는 요청에 앞서 전처리해주어 토큰의 유효성과 user_pid를 파싱해준다.

	private static final String HEADER_AUTH = "Authorization";

	@Autowired
	private JWTService jwtService;

	// 전처리기는 클라이언트에서 컨트롤러로 요청할 때, 컨트롤러가 호출되기 전에 실행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		final String token = request.getHeader(HEADER_AUTH); // HTTP 헤더에 담긴 토큰을 꺼냄 (요청)
		System.out.println("꺼내온 토큰 : " + " [ " + token + " ] ");

		System.out.println("Interceptor preHandled access of Controller");
		
		try {
			if (token != null && jwtService.isUsable(token)) { // 토큰이 존재하며 유효할 시 true를 리턴
				return true;
			} else { // 그렇지 않으면 예외발생
				throw new UnauthorizedException(); 
			}	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	// 후처리기는 컨트롤러에서 클라이언트로 요청할 때, 컨트롤러가 호출되고 난 후에 실행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	// 컨트롤러의 처리가 끝나고 화면처리까지 모두 끝나면 실행되는 메서드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

}