package com.hj.homework.controller;


import com.hj.homework.pojo.Achievement;
import com.hj.homework.pojo.Admin;
import com.hj.homework.pojo.Page;
import com.hj.homework.pojo.Student;
import com.hj.homework.service.AdminServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminController {

    private AdminServie adminServie;

    @Autowired(required = false)
    public void setAdminmapper(AdminServie adminServie) {
        this.adminServie = adminServie;
    }


    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody Admin admin,HttpSession session){
        Admin ad= adminServie.cheackAcount(admin);
        if (ad!=null){
            //跳转主页
            session.setAttribute("loginUser",ad);
            return true;
        }
        else {
            return false;
        }



    }

    @GetMapping("/getListPage")
    @ResponseBody
    public List<Student> getListPage( Integer start){
        System.out.println("进来了");
        System.out.println(start);
        return adminServie.studentListPage(start);
    }

    @PostMapping("/getInitPage")
    @ResponseBody
    public Page getInitPage(){
        return adminServie.initGetPage();
    }

    @GetMapping("/getAchievementPage")
    @ResponseBody
    public List<HashMap<String,Object>> getAchievementPage(Integer start){
        return adminServie.getStudentCorp(start);
    }
    @PostMapping("/getInitAchevementPage")
    @ResponseBody
    public Page getInitAchevementPage(){
        return adminServie.initAchievementPage();
    }

    @PostMapping("/upStudengt")
    @ResponseBody
    public boolean upStudengt(@RequestBody Student student){
        return adminServie.upStudent(student);
    }

    @PostMapping("/inStudent")
    @ResponseBody
    public boolean inStudent(@RequestBody Student student){
        return adminServie.addStudent(student);
    }

    @GetMapping("/delStudent")
    @ResponseBody
    public boolean delStudent( Integer id){
        return adminServie.delStudent(id);
    }

    @PostMapping("/upAchievement")
    @ResponseBody
    public boolean upAchievement(@RequestBody Achievement achievement){
        return adminServie.upAchievement(achievement);
    }

    @GetMapping("/delAchievement")
    @ResponseBody
    public boolean delAchievement( Integer id){
        return adminServie.delAchievement(id);
    }









    @RequestMapping("/toStudent")
    public String toStudent(){
        return "student";
    }
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

}
