package com.example.codestudy.service.impl;

import com.example.codestudy.mapper.BasicModelConfigMapper;
import com.example.codestudy.model.BasicModelConfig;
import com.example.codestudy.service.BasicModelConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BasicModelConfigServiceImpl implements BasicModelConfigService {

    private final BasicModelConfigMapper mapper;

    public BasicModelConfigServiceImpl(BasicModelConfigMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public BasicModelConfig create(BasicModelConfig config) {
        mapper.insert(config);
        return config;
    }

    @Override
    public Optional<BasicModelConfig> getById(Long id) {
        return Optional.ofNullable(mapper.selectById(id));
    }

    @Override
    public Optional<BasicModelConfig> getByModelId(Long modelId) {
        return Optional.ofNullable(mapper.selectByModelId(modelId));
    }

    @Override
    public List<BasicModelConfig> listAll() {
        return mapper.selectAll();
    }

    @Override
    @Transactional
    public Optional<BasicModelConfig> update(Long id, BasicModelConfig config) {
        return Optional.ofNullable(mapper.selectById(id))
                .map(existing -> {
                    config.setId(id);
                    mapper.update(config);
                    return mapper.selectById(id);
                });
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}
