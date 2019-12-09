package com.hui.controller;

import com.hui.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "CLOUD-DEPT-SERVER")
@FeignClient(value = "CLOUD-DEPT-SERVER", fallbackFactory = DeptClientFallbackFactory.class)
public interface FeignInter {

    @GetMapping("/dept/{deptno}")
    Dept getDept(@PathVariable("deptno") String deptno);

}
