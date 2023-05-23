package com.example.MedManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.MedManager.model.Dataset;
public interface DatasetRepository extends JpaRepository<Dataset, Long> {

}
