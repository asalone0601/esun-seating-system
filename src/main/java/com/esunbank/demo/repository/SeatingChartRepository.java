package com.esunbank.demo.repository;

import com.esunbank.demo.entity.SeatingChart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatingChartRepository extends JpaRepository<SeatingChart, Integer> {
}
