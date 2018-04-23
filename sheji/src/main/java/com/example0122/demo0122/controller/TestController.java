package com.example0122.demo0122.controller;

import com.example0122.demo0122.entity.Info;
import com.example0122.demo0122.mapper.SelectInfoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qxf
 * */

@Controller
public class TestController {

	@Resource
	public SelectInfoMapper selectInfoMapper;

	//查询所有农家乐信息
	@ResponseBody
	@RequestMapping("/selectInfo")
	public List<Info> hello() {
		List<Info> list = new ArrayList<>();
		list = selectInfoMapper.selectInfo();
		return list;
	}

	//根据id查询农家乐信息
	@ResponseBody
	@RequestMapping("/selectInfoById")
	public Info selectInfoById(@RequestParam(value = "id") Integer id){
		Info info = new Info();
		info = selectInfoMapper.selectInfoById(id);
		return info;
	}

	//更新农家乐信息
	@ResponseBody
	@RequestMapping("/updateInfo")
	public String updateInfo(@RequestParam(value = "userid") Integer id,
							 @RequestParam("name") String name,
							 @RequestParam("location") String location,
							 @RequestParam("keyword") String keyword,
							 @RequestParam("type") String type,
							 @RequestParam("distance") String distance,
							 @RequestParam("product") String product,
							 @RequestParam("picture") String picture){
		Info info = new Info();
		info.setInfoid(id);
		info.setName(name);
		info.setLocation(location);
		info.setKeyword(keyword);
		info.setType(type);
		info.setDistance(distance);
		info.setProduct(product);
		info.setPicture(picture);
		Integer i = selectInfoMapper.updateInfo(info);
		if (i>0){
			return "1";
		}else {
			return "0";
		}
	}

	//新增农家乐信息
	@ResponseBody
	@RequestMapping(value = "/addInfo",method = RequestMethod.POST)
	public String addInfo(@RequestParam("name") String name,
						  @RequestParam("location") String location,
						  @RequestParam("keyword") String keyword,
						  @RequestParam("type") String type,
						  @RequestParam("distance") String distance,
						  @RequestParam("product") String product,
						  @RequestParam("picture") MultipartFile file
						  ){
		String picture = "null";
		if(!file.isEmpty()){
			try {
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
//						new File("/Users/qxf/IdeaProjects/Graduation-project/sheji/src/main/resources/"+name+".jpg")
						new File("/root/sheji/"+name+".jpg")
				));
				out.write(file.getBytes());
				out.flush();
				out.close();
				String filename = name+".jpg";
				picture = filename;

			}catch (Exception e){
				e.printStackTrace();
			}
		}
		Info info = new Info();
		info.setName(name);
		info.setLocation(location);
		info.setKeyword(keyword);
		info.setType(type);
		info.setDistance(distance);
		info.setProduct(product);
		info.setPicture(picture);
		Integer i = selectInfoMapper.addInfo(info);
		if (i>0){
			return "1";
		}else {
			return "0";
		}
	}
	//删除农家乐信息
	@ResponseBody
	@RequestMapping("/delInfoById")
	public String delInfoById(@RequestParam(value = "id") String id){
		Integer infoid = Integer.parseInt(id);
		Integer i = selectInfoMapper.delInfoById(infoid);
		if (i>0){
			return "1";
		}else {
			return "0";
		}
	}



}
