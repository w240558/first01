package com.ssm.dao;

import com.ssm.domain.Student;
import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**登录
     * */
    Student loginUser(@Param("name") String name,@Param("password") String password);

//    注册
    int insertStudent(Student student);
}