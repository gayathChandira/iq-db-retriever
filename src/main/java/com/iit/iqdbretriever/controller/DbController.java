package com.iit.iqdbretriever.controller;


import com.iit.iqdbretriever.dao.IqStore;
import com.iit.iqdbretriever.repository.MetricRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1")
public class DbController {
@Autowired
    MetricRepository metricRepository;

    @PostMapping("/save") // Replace with the actual endpoint
    public void receiveDataFromDeveloperIq(@RequestBody IqStore iqStore) {
        metricRepository.save(iqStore);

    }
}
