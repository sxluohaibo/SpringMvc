package com.luohaibo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;

/**
 * Created by luohaibo on 2017/6/20.
 */
@Entity
@Table
@Data
public class Department {


    @Id
    private Long id;

    @Transient
    private Set<Employee> set;

}
