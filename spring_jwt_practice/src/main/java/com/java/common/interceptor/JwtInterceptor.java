package com.java.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.java.common.exception.UnauthorizedException;
import com.java.common.service.JwtService;

/*
 * HTTP 통신 시 인터셉터를 활용하여 유효한 토큰인지 확인하는 코드. 유효성검사.
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

	private static final String HEADER_AUTH = "Authorization";

	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		final String token = request.getHeader(HEADER_AUTH); // HTTP 헤더에 담긴 토큰을 꺼낸다. (요청)

		if (token != null && jwtService.isUsable(token)) {
			return true; //토큰이 존재하며 유효할 시 true를 리턴
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
