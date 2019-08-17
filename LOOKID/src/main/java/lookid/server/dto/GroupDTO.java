package lookid.server.dto;

// 그룹 정보
public class GroupDTO {

	private String g_name;
	// 기기 개수 (== 피보호자 수)
	private int count;

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "GroupDTO [g_name=" + g_name + ", count=" + count + "]";
	}

}
