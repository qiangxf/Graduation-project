package com.example0122.demo0122.mapper;

import com.example0122.demo0122.entity.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectInfoMapper {
    //查询所有
    List<Info> selectInfo();
    //根据id查询
    Info selectInfoById(Integer infoid);
    //更新操作
    Integer updateInfo(@Param("info") Info info);
    //新增操作
    Integer addInfo(@Param("info") Info info);
    //删除操作
    Integer delInfoById(Integer infoid);
}
