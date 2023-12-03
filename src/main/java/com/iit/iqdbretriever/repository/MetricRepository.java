package com.iit.iqdbretriever.repository;


import com.iit.iqdbretriever.dao.IqStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<IqStore,Long> {

    IqStore findByUserName(String userName);
}
