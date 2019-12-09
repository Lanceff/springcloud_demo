package com.hui.controller;

import com.hui.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

//降级服务(客户端)
@Component
public class DeptClientFallbackFactory implements FallbackFactory<FeignInter> {

    @Override
    public FeignInter create(Throwable throwable) {
        return new FeignInter() {
            @Override
            public Dept getDept(String deptno) {
                return new Dept().setDeptNo(Integer.parseInt(deptno)).setDeptName("服务降级");
            }
        };
    }
}
