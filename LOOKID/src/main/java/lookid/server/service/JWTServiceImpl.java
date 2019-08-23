package lookid.server.service;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
	public <T> String create(String key, T data) {
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

	// jwt에서 user_pid 파싱
	@Override
	public String getUser_pid(String jwt) throws RuntimeException {
		Jws claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
		return (String) claims.getBody().toString();
	}

	// 토큰 삭제
	@Override
	public void detroy(String jwt) {
		// TODO Auto-generated method stub

	}

}
