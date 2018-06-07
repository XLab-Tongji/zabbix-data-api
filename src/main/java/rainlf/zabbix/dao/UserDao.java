package rainlf.zabbix.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import rainlf.zabbix.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM User WHERE username = #{username}")
    User findByName(@Param("username")String username);


    @Select("SELECT * FROM User WHERE password = #{password}")
    User findByPassword(@Param("password")String password);
}
