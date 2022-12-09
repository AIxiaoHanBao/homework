package com.hj.homework.service;

import com.hj.homework.pojo.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface AdminServie {


    /**
     * 用于检测登录是否对
     * @param admin
     * @return
     */
    Admin cheackAcount(Admin admin);

    /**
     * 学生listPage
     * @param start
     * @return
     */
    List<Student> studentListPage(int start);

    /**
     * 初始化学生信息的Page信息
     * @return
     */
    Page initGetPage();

    /**
     * 通过学号获取学生
     * @param no
     * @return
     */
    Student getStudentByNo(String no);

    /**
     * 通过课程号获取课程
     * @param id
     * @return
     */
    Course getCourseById(Integer id);

    /**
     * 初始化AchievementPage信息
     * @return
     */
    Page initAchievementPage();

    /**
     * 获取学生成绩的方法
     * @param start
     * @return
     */
    List<HashMap<String,Object>> getStudentCorp(int start);

    /**
     * 添加用户
     * @param student
     * @return
     */
    boolean addStudent(Student student);

    /**
     * 更新用户
     * @param student
     * @return
     */
    boolean upStudent(Student student);

    /**
     * 删除学生
     * @param id
     * @return
     */
    boolean delStudent(Integer id);

    /**
     * 录入成绩
     * @param achievement
     * @return
     */
    boolean upAchievement(Achievement achievement);

    /**
     * 删除成绩
     * @param
     * @return
     */
    boolean delAchievement(Integer id);


}
