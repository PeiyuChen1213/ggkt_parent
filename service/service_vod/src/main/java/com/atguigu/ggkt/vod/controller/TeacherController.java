package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Chen Peiyu
 * @since 2023-01-19
 */
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //查询所有的讲师列表
    @GetMapping("findAll")
    public List<Teacher> findAll(){
        List<Teacher> list = teacherService.list();
        return list;
    }

}


