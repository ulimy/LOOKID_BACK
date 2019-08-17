package lookid.server.dao;

import org.apache.ibatis.annotations.Param;

public interface Mapper {
	public int login(@Param("id")String id, @Param("password")String password);
}
