package com.sirma.employees.service;

import com.sirma.employees.entity.Employee;
import com.sirma.employees.entity.OldestEmployees;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Override
    public List<OldestEmployees> readFileAndFillEmployeeMap(MultipartFile file) {

        Map<String, List<Employee>> employeesMap = new HashMap<>();

        try {
            String line;
            InputStream is = file.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(inputStreamReader);
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String employeeId = split[0];
                String projectId = split[1];
                LocalDate dateFrom = convertStringToDate(split[2]);
                LocalDate dateTo = convertStringToDate(split[3]);
                Long numberOfDays = calculateNumberOfDaysBetweenTwoDates(dateFrom, dateTo);
                Employee employee = new Employee(employeeId, numberOfDays);
                List<Employee> employeesList = employeesMap.get(projectId);
                if (employeesList != null) {
                    employeesList.add(employee);
                } else {
                    employeesList = new ArrayList<>();
                    employeesList.add(employee);
                    employeesMap.put(projectId, employeesList);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return checkWhoIsTheOldestPair(employeesMap);

    }

    private Long calculateNumberOfDaysBetweenTwoDates(LocalDate dateFrom, LocalDate dateTo) {

        return DAYS.between(dateFrom, dateTo);
    }

    private List<OldestEmployees> checkWhoIsTheOldestPair(Map<String, List<Employee>> employeesMap) {
        List<OldestEmployees> oldestEmployeesList = new ArrayList<>();
        Set<String> keySet = employeesMap.keySet();
        for (String key : keySet) {
            List<Employee> employees = employeesMap.get(key);
            employees.sort(Comparator.comparing(Employee::getDaysWorked).reversed());
            if (employees.size() > 1) {
                OldestEmployees oldestEmployees = new OldestEmployees();
                oldestEmployees.setEmployee1(employees.get(0).getEmployeeId());
                oldestEmployees.setEmployee2(employees.get(1).getEmployeeId());
                oldestEmployees.setProjectId(key);
                oldestEmployees.setTotalWorkingDays(employees.get(0).getDaysWorked() + employees.get(1).getDaysWorked());
                oldestEmployeesList.add(oldestEmployees);

            }

        }
        oldestEmployeesList.sort(Comparator.comparing(OldestEmployees::getTotalWorkingDays).reversed());
        return oldestEmployeesList;

    }


    private LocalDate convertStringToDate(String date) {
        if (date == null || date.equalsIgnoreCase("NULL")) {
            return LocalDate.now();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(date, formatter);
            return localDate;
        }
    }
}
