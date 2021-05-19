package com.example.demo.mapper;

import com.example.demo.model.DemoUserModel;
import com.example.demo.vo.RegisterVo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

// TODO : XML 방식으로 변경!

@Mapper
public interface DemoUserMapper {

    @Select("select * from demouser where id = ${uid}")
    @Results(id = "userMap", value = { @Result(property = "email", column = "user_email"),
            @Result(property = "name", column = "user_name"),
            @Result(property = "password", column = "user_password") })
    public DemoUserModel findUserOneById(int uid);

    @Select("select * from demouser where user_email = #{email}")
    @ResultMap("userMap")
    public DemoUserModel findUserOneByEmail(String email);

    @Insert("insert into demouser(user_email, user_name, user_password) values( #{vo.email} , #{vo.name}, #{vo.password} )")
    public int registerUser(@Param("vo") RegisterVo vo);

    @Update("update demouser set user_password = #{newPassword} where id = #{uid}")
    public int updatePassword(@Param("uid") int uid, @Param("newPassword") String newPassword);

    @Delete("delete from demouser where id = #{uid}")
    public int deleteUser(@Param("uid") int uid);

}
