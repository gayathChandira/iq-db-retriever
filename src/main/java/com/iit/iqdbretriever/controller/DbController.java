package com.iit.iqdbretriever.controller;


import com.iit.iqdbretriever.dao.IqStore;
import com.iit.iqdbretriever.repository.MetricRepository;
import com.iit.iqdbretriever.service.DbServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1")
public class DbController {
    MetricRepository metricRepository;
    DbServiceImpl dbService;
    public DbController(MetricRepository metricRepository, DbServiceImpl dbService) {
        this.metricRepository = metricRepository;
        this.dbService = dbService;
    }

    @PostMapping("/save")
    public void receiveDataFromDeveloperIq(@RequestBody IqStore iqStore) {
        dbService.storeInDB(iqStore);
    }
}
