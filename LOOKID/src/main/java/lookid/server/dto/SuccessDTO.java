package lookid.server.dto;

// true or false 를 리턴해주는 DTO
public class SuccessDTO {
	boolean success;

	public SuccessDTO(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "SuccessDTO [success=" + success + "]";
	}

}
