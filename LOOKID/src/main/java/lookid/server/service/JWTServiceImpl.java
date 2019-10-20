package lookid.server.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lookid.server.exception.UnauthorizedException;

@Service("JWTService")
public class JWTServiceImpl implements JWTService {

	private static final String SALT = "UserSecret";
	
	// 토큰 생성
	@Override
	public <T> String create(String key, T data) { // 토큰만료시간을 설정하면 토큰이 로그인 할 때 마다 바뀜
		String jwt = Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.claim(key, data)
				.signWith(SignatureAlgorithm.HS256, this.generateKey())
				.compact(); // 직렬화
		return jwt;
	}

	// 키
	@Override
	public byte[] generateKey() {

		byte[] key = null;
		try {
			key = SALT.getBytes("UTF-8"); // getBytes() 메소드는 인코딩/디코딩 과정에 필요한 바이트 배열을 만드는 메소드
											// "UTF-8" 바이트 배열로 변환하지 않는다면 테이블에 저장 시 정보가 손실될수 있음
		} catch (UnsupportedEncodingException e) {
			System.out.println("generateKey error");
		}

		return key;
	}

	// 토큰 유효성 검사
	@Override
	public boolean isUsable(String jwt) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
			return true;

		} catch (Exception e) {
			throw new UnauthorizedException();
		}
	}

	// 토큰에서 user_pid 파싱
	@Override
	public int getUser_pid(String jwt) throws RuntimeException {
		
		Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
		int user_pid = (Integer) claims.getBody().get("user_pid");
			
		return user_pid;
	}
	
	
	// 토큰 무효화
	@Override
	public void destroy(String token, HttpServletResponse response) {
		// 토큰 자체는 삭제 못하나 destroy한 토큰에 요청이 들어오면 잘못된 접근임을 알수있게 무효화
		// 추가기능으로 Spring Security OAuth JWT invalidate 구현
		
//		Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(token);
//		
//		System.out.println(claims.getBody().getExpiration());
//		claims.getBody().setExpiration(new Date(System.currentTimeMillis()));		
//		System.out.println(claims.getBody().getExpiration());
		
	}
}
