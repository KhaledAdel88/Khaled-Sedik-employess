package com.sirma.employees.service;

import com.sirma.employees.entity.OldestEmployees;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {

    public List<OldestEmployees> readFileAndFillEmployeeMap(MultipartFile file);
}
