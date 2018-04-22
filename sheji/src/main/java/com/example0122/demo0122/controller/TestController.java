package com.example0122.demo0122.controller;

import com.example0122.demo0122.entity.Info;
import com.example0122.demo0122.mapper.SelectInfoMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qxf
 * */

@RestController
public class TestController {
	
	@Resource
	public SelectInfoMapper selectInfoMapper;

	@RequestMapping("/selectInfo")
	public List<Info> hello() {
		List<Info> list = new ArrayList<>();
		list = selectInfoMapper.selectInfo();
		return list;
	}

	@RequestMapping("/selectInfoById")
	public Info selectInfoById(@RequestParam(value = "id") Integer id){
		Info info = new Info();
		info = selectInfoMapper.selectInfoById(id);
		return info;
	}

	@RequestMapping("/updateInfo")
	public String updateInfo(@RequestParam(value = "userid") Integer id){
		return "";
	}



}
