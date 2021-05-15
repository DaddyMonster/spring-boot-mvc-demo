package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestAppController {

	private TestModelMapper mapper;

	public TestAppController(TestModelMapper mapper, TestModelService srv) {
		super();
		this.mapper = mapper;

	}

	@GetMapping("/")
	public ModelAndView serverUpTest() {
		ModelAndView mv = new ModelAndView("index");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("Welcome");
		mv.addObject("name", "Daniel");
		mv.addObject("list", list);
		return mv;
	}

	@GetMapping("/board")
	public ModelAndView showBoard() {
		ModelAndView mv = new ModelAndView("board");
		List<TestModel> models = mapper.getTestModels();
		mv.addObject("models", models);
		return mv;
	}

}
