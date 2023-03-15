package com.example.atv2Dac.dao;

import com.example.atv2Dac.model.UFC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UFCDAO extends JpaRepository<UFC, Long> {

}
