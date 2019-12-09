package lookid.server.dto;

public class ChildDTO {
	String c_name;

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	@Override
	public String toString() {
		return "ChildDTO [c_name=" + c_name + "]";
	}

}
