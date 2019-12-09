package com.hui.service;

import com.hui.entity.Dept;
import com.hui.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public Dept get(Integer deptno){
        return deptMapper.selectById(deptno);
    }

    public int delete(Integer deptno) {
        return  deptMapper.deleteDeptById(deptno);
    }

    public int add (Dept dept) {
        return deptMapper.addDept(dept);
    }
}
