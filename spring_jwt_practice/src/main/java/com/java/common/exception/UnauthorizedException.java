package com.java.common.exception;

public class UnauthorizedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnauthorizedException() {
		super("토큰이 유효하지 않습니다.(계정 권한 invalid)\n다시 로그인 해주세요.\n");
	}
	
}
