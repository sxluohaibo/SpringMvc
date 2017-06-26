package com.luohaibo.service.impl;

import com.luohaibo.entity.Employee;
import com.luohaibo.repository.company.ComRepository;
import com.luohaibo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luohaibo on 2017/6/20.
 */
@Service
public class EmployeeServiceImpl implements CompanyService{

    @Autowired
    private ComRepository comRepository;

    public Employee findEmployeeByName(String name) {
        return comRepository.findEmployeeByName(name);
    }
}
