package com.example.codestudy.mapper;

import com.example.codestudy.model.BasicModelConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BasicModelConfigMapper {

    int insert(BasicModelConfig config);

    BasicModelConfig selectById(@Param("id") Long id);

    BasicModelConfig selectByModelId(@Param("modelId") Long modelId);

    List<BasicModelConfig> selectAll();

    int update(BasicModelConfig config);

    int deleteById(@Param("id") Long id);
}
