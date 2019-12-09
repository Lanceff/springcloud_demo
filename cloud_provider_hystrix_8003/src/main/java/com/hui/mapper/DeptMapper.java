package com.hui.mapper;

import com.hui.entity.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DeptMapper {

    @Select("select * from dept where deptno=#{deptno}")
    Dept selectById(Integer deptno);

    @Update("update dept set deptname=#{deptName},data_source=#{dataSource} where deptno=#{deptNo}")
    int updateDept(Dept dept);

    @Delete("delete from dept where deptno=#{deptno}")
    int deleteDeptById(Integer deptno);


    @Insert("insert into dept (deptname,data_source) values (#{deptName},#{dataSource})")
    int addDept(Dept dept);

}
