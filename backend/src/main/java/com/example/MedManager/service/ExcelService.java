package com.example.MedManager.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.MedManager.helper.ExcepHelper;
import com.example.MedManager.model.Dataset;
import com.example.MedManager.repository.DatasetRepository;

@Service
public class ExcelService {
    @Autowired
    DatasetRepository repository;
    public void save(MultipartFile file) {
        try {
            List<Dataset> tutorials = ExcepHelper.excelToDatasets(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Dataset> getAllTutorials() {
        return repository.findAll();
    }
}
