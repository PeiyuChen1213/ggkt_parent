package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Chen Peiyu
 * @since 2023-01-19
 */
public interface TeacherService extends IService<Teacher> {
    public Result selectPage(long current, long limit, TeacherQueryVo teacherQueryVo);
}
