package com.kks.springboot.thymeleaf.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kks.springboot.thymeleaf.models.Student;


@Controller
public class HelloControllers {
        
    
    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @RequestMapping(value = "/sendData")
    public ModelAndView sendData() {
        ModelAndView mv = new ModelAndView("data");
        mv.addObject("message", "KKS");
        return mv;
    }

    @RequestMapping(value = "/bacha")
    public ModelAndView sendObject() {
        ModelAndView mv = new ModelAndView("object");
        Student student = new Student();
        student.setName("KKS");
        student.setMarks(100);
        mv.addObject("student", student);
        return mv;
    }

    @RequestMapping(value = "/bache")
    public ModelAndView sendObjects() {
        ModelAndView mv = new ModelAndView("studentList");
        Student student1 = new Student();
        student1.setName("KKS");
        student1.setMarks(100);
        

        Student student2 = new Student();
        student2.setName("RKS");
        student2.setMarks(98);

        List<Student> students = Arrays.asList(student1, student2);
        mv.addObject("students", students);
        return mv;
    }


    @RequestMapping(value = "/studentForm")   
    public ModelAndView sendStudentForm() {
        ModelAndView mv = new ModelAndView("studentForm");
        Student student = new Student();
        student.setName("KKS");
        student.setMarks(100);
        mv.addObject("student", student);
        return mv;


    }

    @RequestMapping(value = "/saveStudent")   
    public ModelAndView saveStudent(@ModelAttribute    Student student) {
        ModelAndView mv = new ModelAndView("result");
        System.out.println(student.getName());
        System.out.println(student.getMarks());
        return mv;

        
    }
}
