package com.iit.iqdbretriever.service;

import com.iit.iqdbretriever.dao.IqStore;
import com.iit.iqdbretriever.repository.MetricRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbServiceImpl {

    MetricRepository metricRepository;

    public DbServiceImpl(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    public void storeInDB(IqStore iqStore){
        // Check if the user already exists in the database
        Optional<IqStore> existingIqStore = Optional.ofNullable(metricRepository.findByUserName(iqStore.getUserName()));

        if (existingIqStore.isPresent()) {
            // Update the existing entry
            IqStore iqStoreToUpdate = existingIqStore.get();
            iqStoreToUpdate.setAvgCommit(iqStore.getAvgCommit());
            iqStoreToUpdate.setFollowersCount(iqStore.getFollowersCount());
            iqStoreToUpdate.setPullCount(iqStore.getPullCount());
            iqStoreToUpdate.setIq(iqStore.getIq());
            metricRepository.save(iqStoreToUpdate);
        } else {
            // Insert a new entry
            IqStore newIqStore = new IqStore();
            newIqStore.setUserName(iqStore.getUserName());
            newIqStore.setAvgCommit(iqStore.getAvgCommit());
            newIqStore.setPullCount(iqStore.getPullCount());
            newIqStore.setFollowersCount(iqStore.getFollowersCount());
            newIqStore.setIq(iqStore.getIq());
            metricRepository.save(newIqStore);
        }
    }
}
