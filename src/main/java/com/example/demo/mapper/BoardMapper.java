package com.example.demo.mapper;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.RegisterBoardDto;
import com.example.demo.model.BoardModel;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

// TODO : XML 방식으로 변경!

@Mapper
public interface BoardMapper {
    @Select("select * from board where id = #{boardId}")
    public BoardModel findBoardById(int boardId);

    @Select("select * from board order by createdAt limit #{pageStart}, #{pageLimit}")
    public List<BoardModel> getBoardList(int pageStart, int pageLimit);

    @Select("select count(*) from board")
    public Integer boardCount();

    @Insert("insert into board (title, description,issuerId) values (#{dto.title}, #{dto.description}, #{issuerId});")
    public int registerBoard(RegisterBoardDto dto, int issuerId);

    @Update("update board set title=#{dto.title}, description=#{dto.description} , updatedAt=#{now} where id=#{boardId}")
    public int updateBoard(int boardId, RegisterBoardDto dto, Date now);

    @Delete("delete from board where id = #{boardId}")
    public int deleteBoard(int boardId);
}
