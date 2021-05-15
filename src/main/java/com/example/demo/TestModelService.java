package com.example.demo;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.TestModel;

@Service
@CacheConfig(cacheNames = { "testmodel" })
public class TestModelService {
	private TestModelMapper mapper;

	public TestModelService(TestModelMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Cacheable()
	public List<TestModel> getRedisCachedModels() {
		return this.mapper.getTestModels();

	}
}
