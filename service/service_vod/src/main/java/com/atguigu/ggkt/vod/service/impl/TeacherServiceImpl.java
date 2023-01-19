package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.mapper.TeacherMapper;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Chen Peiyu
 * @since 2023-01-19
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public Result selectPage(long current, long limit, TeacherQueryVo teacherQueryVo) {
        Page<Teacher> teacherPage = new Page<>(current, limit);
        LambdaQueryWrapper<Teacher> teacherLambdaQueryWrapper = new LambdaQueryWrapper<>();
        teacherLambdaQueryWrapper.orderByAsc(Teacher::getSort);
        Page<Teacher> resultPage = new Page<>();
        //当查询条件为空
        if (teacherQueryVo == null) {
            resultPage = this.page(teacherPage);
        } else {
            //封装查询条件
            teacherLambdaQueryWrapper.like(!StringUtils.isEmpty(teacherQueryVo.getName()), Teacher::getName, teacherQueryVo.getName())
                    .eq(!StringUtils.isEmpty(teacherQueryVo.getLevel()), Teacher::getLevel, teacherQueryVo.getName())
                    .ge(!StringUtils.isEmpty(teacherQueryVo.getJoinDateBegin()), Teacher::getCreateTime, teacherQueryVo.getJoinDateBegin())
                    .le(!StringUtils.isEmpty(teacherQueryVo.getJoinDateEnd()), Teacher::getCreateTime, teacherQueryVo.getJoinDateEnd());
            resultPage = this.page(teacherPage, teacherLambdaQueryWrapper);

        }
        return Result.ok(resultPage.getRecords());
    }
}
