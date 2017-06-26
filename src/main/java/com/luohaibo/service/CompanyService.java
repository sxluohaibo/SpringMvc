package com.luohaibo.service;

import com.luohaibo.entity.Employee;

/**
 * Created by luohaibo on 2017/6/20.
 */
public interface CompanyService {

    public Employee findEmployeeByName(String name);
}
