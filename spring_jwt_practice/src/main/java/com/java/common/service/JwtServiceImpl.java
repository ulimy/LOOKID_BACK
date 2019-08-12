package com.java.common.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.java.common.exception.UnauthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("jwtService")
public class JwtServiceImpl implements JwtService{

	private static final String SALT = "UserSecret";
	
	private static final long EXPIRATION_TIME = 1 * (1000 * 60 * 60 * 24); // 하루의 만료시간.
	private static final long EXPIRATION_TIME_TEN_SECONDS = 1 * (1000 * 10); // 10초
	
	
	@Override
	public <T> String create(String key, T data, String subject, String issuer) { //토큰만료시간이 지난 이후에 isUsable() 메소드 실행 시 토큰이 유효하지 않다는 예외발생.
		String jwt = Jwts.builder() //JWT - header.payload.signature
				 .setHeaderParam("typ", "JWT") //토큰타입 : JWT (헤더)
				 //.setHeaderParam("regDate", System.currentTimeMillis())
				 .setSubject(subject) // 토큰의 재목 (페이로드)
				 .setIssuer(issuer) //토큰 발행자 (페이로드)
				 .claim(key, data) // key : userId , data : UserVO (페이로드)
				 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 토큰만료시간 필수->만료시간을 추가하지않으면 토큰이 만료되어 Controller의 isUsable()에서 UnauthorizedException()이 실행됨. 커렌트타임밀스(밀리세컨즈) + (1 * (1000 * 60 * 60 * 24)) 즉 하루의 만료시간이 주어짐. (페이로드)
				 .signWith(SignatureAlgorithm.HS256, this.generateKey()) // 토큰의 무결성 검증을 위한 signature 해싱알고리즘 (시그니쳐) "alg" : "HS256" 헤더로 전달됨.
				 .compact(); //직렬화
		
		return jwt;
	}

	@Override
	public byte[] generateKey() {
		
		byte[] key = null;
		try {
			key = SALT.getBytes("UTF-8"); //getBytes() 메소드는 인코딩/디코딩 과정에 필요한 바이트 배열을 만드는 메소드
										  //"UTF-8" 바이트 배열로 변환하지 않는다면 테이블에 저장 시 정보가 손실될수 있다.
		} catch (UnsupportedEncodingException e) {
			System.out.println("generateKey error");
		}
		
		return key;
	}

	@Override
	public boolean isUsable(String jwt) {
		
		try{
			Jws<Claims> claims = Jwts.parser()
					  .setSigningKey(this.generateKey())
					  .parseClaimsJws(jwt);
			return true;
			
		}catch (Exception e) {
			throw new UnauthorizedException();
		}
	}

	@Override
	public Map<String, Object> get(String key) {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String jwt = request.getHeader("Authorization"); //HTTP Authorization 헤더에 담긴 토큰을 요청.
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser()
						 .setSigningKey(SALT.getBytes("UTF-8"))
						 .parseClaimsJws(jwt);
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> value = (LinkedHashMap<String, Object>)claims.getBody().get(key);
		return value;
	}

}
