package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.model.TestModel;

@Mapper
public interface TestModelMapper {

	@Select("select * from TestModel")
	public List<TestModel> getTestModels();

}
