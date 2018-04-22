package com.example0122.demo0122.mapper;

import com.example0122.demo0122.entity.Info;

import java.util.List;

public interface SelectInfoMapper {
    //查询所有
    List<Info> selectInfo();
    //根据id查询
    Info selectInfoById(Integer infoid);
}
