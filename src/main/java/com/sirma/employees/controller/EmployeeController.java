package com.sirma.employees.controller;

import com.sirma.employees.entity.OldestEmployees;
import com.sirma.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/submit-file")
    public String greetingForm(Model model) {
        return "file_chooser";
    }

    @PostMapping("/submit-file")
    public String fileSubmit(@RequestBody() MultipartFile file, Model model) {

        List<OldestEmployees> oldestEmployeesList = employeeService.readFileAndFillEmployeeMap(file);

        model.addAttribute("oldestPairList", oldestEmployeesList);
        return "oldest_pair";
    }


}
