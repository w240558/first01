package com.ssm.controller;

import com.ssm.dao.StudentMapper;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import com.ssm.utils.MapUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: SSM_zuoye
 * @description:
 * @author: wen
 * @create: 2021-12-08 16:18
 * @version:1.0
 **/
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/login.do")
    public ModelAndView loginUserName(@RequestParam("name") String name,@RequestParam("password") String password){
        ModelAndView mv=new ModelAndView();
        SqlSession session=MapUtil.getSqlSession();
//        StudentMapper studentMapper=session.getMapper(StudentMapper.class);

        Student student = studentService.loginUser(name, password);

        if(student!=null){
            mv.addObject("msg",name);
            mv.setViewName("success");
        }
        else{
            mv.setViewName("error");
        }
        MapUtil.close(session);
        return mv;
    }

    @RequestMapping("/zhuce.do")
    public ModelAndView zhuceUserName(@RequestParam("name") String name,@RequestParam("password") String password) {
        ModelAndView mv=new ModelAndView();
        SqlSession session=MapUtil.getSqlSession();
//        StudentMapper studentMapper=session.getMapper(StudentMapper.class);
        Student student=new Student();
        student.setName(name);
        student.setPassword(password);
        int i=studentService.insertStudent(student);
        if(i>0){
            mv.setViewName("redirect:/index.jsp");
        }
        else{
            mv.setViewName("error");
        }
        MapUtil.close(session);
        return mv;
    }


}