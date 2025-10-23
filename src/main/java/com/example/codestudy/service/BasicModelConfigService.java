package com.example.codestudy.service;

import com.example.codestudy.model.BasicModelConfig;

import java.util.List;
import java.util.Optional;

public interface BasicModelConfigService {

    BasicModelConfig create(BasicModelConfig config);

    Optional<BasicModelConfig> getById(Long id);

    Optional<BasicModelConfig> getByModelId(Long modelId);

    List<BasicModelConfig> listAll();

    Optional<BasicModelConfig> update(Long id, BasicModelConfig config);

    boolean delete(Long id);
}
