package com.luohaibo.controller;

import com.luohaibo.entity.Employee;
import com.luohaibo.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohaibo on 2017/6/12.
 */

@Controller
public class MyFirstController {


    private static final Logger vrlogger = LoggerFactory.getLogger(MyFirstController.class);


    @Autowired
    private CompanyService companyService;

    @RequestMapping("/first")
    @ResponseBody
    public Employee myfirst(){
        ModelMap modelMap=new ModelMap();
        Employee employee = companyService.findEmployeeByName("小明");
        List<Employee> list = new ArrayList();
        list.add(employee);
        modelMap.addAttribute("object",employee);
        return employee;
    }

    @RequestMapping("/second")
    public String hello( Model model){

        vrlogger.info("hello world+++3");
        model.addAttribute("message","hello world"+"123");
        return "hello";
    }



//    @ExceptionHandler
//    public String exceptionHandler(Exception ex){
//        System.out.println("xxxxx error");
//        return "error";
//    }


}
