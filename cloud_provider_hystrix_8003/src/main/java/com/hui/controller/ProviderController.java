package com.hui.controller;

import com.hui.entity.Dept;
import com.hui.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProviderController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public String add(@RequestBody Dept dept) {
        deptService.add(dept);
        return "add success";
    }

    @HystrixCommand(fallbackMethod = "dealNullDept")
    @GetMapping("/dept/{deptno}")
    public Dept get(@PathVariable String deptno) {
        Dept dept = deptService.get(Integer.parseInt(deptno));
        if(dept==null) {
            throw new RuntimeException("查询结果为空");
        }
        return dept;
    }

    public Dept dealNullDept(@PathVariable("deptno") String deptno) {
        return new Dept().setDeptName("空对象").setDeptNo(Integer.parseInt(deptno));
    }

}
