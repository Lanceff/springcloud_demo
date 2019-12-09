package com.hui.controller;

import com.hui.entity.Dept;
import com.hui.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProviderController{

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public String add(@RequestBody Dept dept) {
        deptService.add(dept);
        return "add success";
    }

    @GetMapping("/dept/{deptno}")
    public Dept get(@PathVariable String deptno) {
        return deptService.get(Integer.parseInt(deptno));
    }

}
