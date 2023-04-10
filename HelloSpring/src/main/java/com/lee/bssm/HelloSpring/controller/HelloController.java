package com.lee.bssm.HelloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/hi/data")
    public String hiData(Model model)
    {
        model.addAttribute("data", "mr.Lee");
        return "hiData";
    }

    @GetMapping("/hi/param")
    public String hiParam(@RequestParam("data") String data, Model model){
        model.addAttribute("data",data);
        return "hiData";
    }

    @GetMapping("/hello/param")
    @ResponseBody
    public String helloParam(@RequestParam("data")String data) {
        return "hello " + data;
    }

    @GetMapping("/hello/api")
    @ResponseBody
    public Student helloApi(@RequestParam("data") String data){
        return new Student(123L, data);
    }

    static class Student{
        private Long id;
        private String name;

        public Student(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
