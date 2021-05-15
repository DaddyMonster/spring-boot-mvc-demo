package com.example.demo.mapper;

import com.example.demo.dto.RegisterDto;
import com.example.demo.model.DemoUserModel;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DemoUserMapper {

    @Select("select * from demouser where id = ${uid}")
    @Results(id = "userMap", value = { @Result(property = "user_email", column = "email"),
            @Result(property = "user_name", column = "name"), @Result(property = "user_email", column = "email") })
    public DemoUserModel findUserOneById(int uid);

    @Select("select * from demouser where user_email = #{email}")
    @ResultMap("userMap")
    public DemoUserModel findUserOneByEmail(String email);

    @Insert("insert into demouser(user_email, user_name, user_password) values( #{dto.email} , #{dto.name}, #{dto.password} )")
    public int registerUser(@Param("dto") RegisterDto dto);

    @Update("update demouser set user_password = #{newPassword} where id = #{uid}")
    public int updatePassword(@Param("uid") int uid, @Param("newPassword") String newPassword);

    @Delete("delete from demouser where id = #{uid}")
    public int deleteUser(@Param("uid") int uid);

}
