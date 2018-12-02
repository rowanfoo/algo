package com.dharma.algo.data.repo;

import com.dharma.algo.data.entity.TechTechstr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface TechStrRepo extends JpaRepository<TechTechstr,Long> , QuerydslPredicateExecutor<TechTechstr> {

}
