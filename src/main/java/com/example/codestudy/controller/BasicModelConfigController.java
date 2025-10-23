package com.example.codestudy.controller;

import com.example.codestudy.model.BasicModelConfig;
import com.example.codestudy.service.BasicModelConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/basic-model-configs")
public class BasicModelConfigController {

    private final BasicModelConfigService service;

    public BasicModelConfigController(BasicModelConfigService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BasicModelConfig> create(@RequestBody BasicModelConfig config) {
        BasicModelConfig saved = service.create(config);
        return ResponseEntity.created(URI.create("/api/basic-model-configs/" + saved.getId())).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BasicModelConfig> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-model/{modelId}")
    public ResponseEntity<BasicModelConfig> getByModelId(@PathVariable Long modelId) {
        return service.getByModelId(modelId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<BasicModelConfig> listAll() {
        return service.listAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BasicModelConfig> update(@PathVariable Long id, @RequestBody BasicModelConfig config) {
        return service.update(id, config)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
