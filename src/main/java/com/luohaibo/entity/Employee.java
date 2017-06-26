package com.luohaibo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by luohaibo on 2017/6/19.
 */
//希望把对象变成表
@Entity
@Table
@Data
public class Employee {

    //配置主键
    @Id
    //主键生成策略
    @GeneratedValue(strategy = GenerationType.AUTO)
    //修改数据库列名
    @Column(name="e_id")
    private Long id;


    private String name;


    private String passworld;
}
