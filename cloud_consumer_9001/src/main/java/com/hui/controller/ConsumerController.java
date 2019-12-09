package com.hui.controller;


import com.hui.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    public static final String PERFIX = "http://CLOUD-DEPT-SERVER";
//
//
//    @GetMapping("/dept/{deptno}")
//    public Dept getDept(@PathVariable int deptno) {
//        String url = PERFIX + "/dept/" + deptno;
//        Dept dept = restTemplate.getForObject(url, Dept.class);
//        return dept;
//    }

    @Autowired
    private FeignInter feignInter;

    @GetMapping("/dept/{deptno}")
    public Dept getDept(@PathVariable("deptno") String deptno) {
        return feignInter.getDept(deptno);
    }
}
