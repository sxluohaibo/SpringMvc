package com.luohaibo.repository.company;

import com.luohaibo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by luohaibo on 2017/6/20.
 */
@Repository
public interface ComRepository extends JpaRepository<Employee,Integer> {

    Employee findEmployeeByName(String name);
    
     
}
