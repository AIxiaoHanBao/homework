package com.hj.homework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hj.homework.mapper.AchievementMapper;
import com.hj.homework.mapper.AdminMapper;
import com.hj.homework.mapper.CourseMapper;
import com.hj.homework.mapper.StudentMapper;
import com.hj.homework.pojo.Achievement;
import com.hj.homework.pojo.Admin;
import com.hj.homework.pojo.Course;
import com.hj.homework.pojo.Student;
import com.hj.homework.service.AdminServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class AdminImpl implements AdminServie {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private AchievementMapper achievementMapper;

    @Override
    public Admin cheackAcount(Admin admin) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();

        wrapper.select("*")
                        .and(i->i.eq("user_account",admin.getUserAccount()).eq("user_password",admin.getUserPassword()));
        Admin ok = adminMapper.selectOne(wrapper);

        return ok;
    }

    @Override
    public List<Student> studentListPage(int start) {
        Page<Student> page = Page.of(start,5);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.select("*");
        Page<Student> adminPage = studentMapper.selectPage(page, wrapper);
        log.info(adminPage.toString());
        return adminPage.getRecords();
    }

    @Override
    public com.hj.homework.pojo.Page initGetPage() {

        Page<Student> page = Page.of(1,5);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.select("*");
        Page<Student> adminPage = studentMapper.selectPage(page, wrapper);
        com.hj.homework.pojo.Page page1 = new com.hj.homework.pojo.Page();
        page1.setPageNum( adminPage.getPages());
        page1.setPageTotal(adminPage.getTotal());
        page1.setPageSize(adminPage.getSize());
        return page1;
    }


    @Override
    public List<HashMap<String, Object>> getStudentCorp(int start) {
        List<HashMap<String ,Object>> list = new ArrayList();
        HashMap<String, Object> map = new HashMap<>();
        Page<Achievement> page = Page.of(start,5);
        QueryWrapper<Achievement> wrapperAchievement=new QueryWrapper<>();
        wrapperAchievement.select("*");
        Page<Achievement> pageAchevement = achievementMapper.selectPage(page, wrapperAchievement);
        for (Achievement record : pageAchevement.getRecords()) {
            map.put("id",record.getId());
            map.put("studentNo",record.getStudentNo());
            map.put("studentScore",record.getStudentScore());
            map.put("studentName",getStudentByNo(record.getStudentNo().toString()).getStudentName());
            map.put("courseName",getCourseById(record.getCourseId()).getCourseName());
            list.add(new HashMap<>(map));
        }

        return list;
    }

    @Override
    public Student getStudentByNo(String no) {
        QueryWrapper<Student> wrapperStudent = new QueryWrapper<>();
        wrapperStudent.select("*")
                .eq("student_no",no);
        Student student = studentMapper.selectOne(wrapperStudent);
        return student;
    }

    @Override
    public Course getCourseById(Integer id) {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.select("*")
                .eq("id",id);
        Course course = courseMapper.selectOne(wrapper);
        return course;
    }

    /**
     * 初始化Achievement的Page信息
     * @return
     */
    @Override
    public com.hj.homework.pojo.Page initAchievementPage() {
        Page<Achievement> page = Page.of(1, 5);
        QueryWrapper<Achievement> wrapperAchievement = new QueryWrapper<>();
        wrapperAchievement.select("*");
        Page<Achievement> page1 = achievementMapper.selectPage(page, wrapperAchievement);
        com.hj.homework.pojo.Page page2 = new com.hj.homework.pojo.Page();
        page2.setPageTotal(page1.getTotal());
        page2.setPageSize(page1.getSize());
        page2.setPageNum(page1.getPages());
        return page2;
    }


    @Override
    public boolean addStudent(Student student) {
        int insert = studentMapper.insert(student);
        return insert>0?true:false;
    }

    @Override
    public boolean upStudent(Student student) {
        int i = studentMapper.updateById(student);
        return i>0?true:false;
    }

    @Override
    public boolean delStudent(Integer id) {
        int i = studentMapper.deleteById(id);
        return i>0?true:false;
    }

    @Override
    public boolean upAchievement(Achievement achievement) {
        int i = achievementMapper.updateById(achievement);
        return i>0?true:false;
    }

    @Override
    public boolean delAchievement(Integer id) {
        int i = achievementMapper.deleteById(id);
        return i>0?true:false;
    }
}


//    QueryWrapper<Department> wrapper1 = new QueryWrapper<>();
//        wrapper1.select("*");
//                departmentMapper.selectList(wrapper1);