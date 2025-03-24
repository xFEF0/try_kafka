package com.xfef0.springboot.repository;

import com.xfef0.springboot.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {

}
