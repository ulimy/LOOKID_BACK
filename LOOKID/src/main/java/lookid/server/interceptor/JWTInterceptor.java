package lookid.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lookid.server.exception.UnauthorizedException;
import lookid.server.service.JWTService;

@Component
public class JWTInterceptor implements HandlerInterceptor {
	// jwt인터셉터를 이용하여 컨트롤러로 들어오는 요청에 앞서 전처리해주어 토큰의 유효성과 user_pid를 파싱해준다. 단 모든 메소드가아닌
	// 필요한 메소드의 url만 지정.

	private static final String HEADER_AUTH = "Authorization";

	@Autowired
	private JWTService jwtService;

//	public String getJWTToken(HttpServletRequest request) {
//		
//		final String token = request.getHeader(HEADER_AUTH); // HTTP 헤더에 담긴 토큰을 꺼낸다. (요청)
//
//		if (token != null && jwtService.isUsable(token)) {
//			return token; // 토큰이 존재하며 유효할 시 true를 리턴
//		} else {
//			throw new UnauthorizedException(); // 그렇지 않으면 예외발생
//		}
//	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		final String token = request.getHeader(HEADER_AUTH); // HTTP 헤더에 담긴 토큰을 꺼낸다. (요청)

		if (token != null && jwtService.isUsable(token)) {
			return true; // 토큰이 존재하며 유효할 시 true를 리턴
		} else {
			throw new UnauthorizedException(); // 그렇지 않으면 예외발생
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}