package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "讲师管理接口")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    //查询所有的讲师列表
    @ApiOperation("查询所有的讲师列表")
    @GetMapping("findAll")
    public Result findAll(){
        GgktException.cast(500,"异常测试");
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功！");
    }

    //条件查询分页列表
    @ApiOperation("获取分页列表")
    @PostMapping("{current}/{limit}")
    public Result index(@ApiParam(name = "current", value = "当前页码", required = true)
                                            @PathVariable long current,
                                            @ApiParam(name = "limit", value = "每页记录数", required = true)
                                            @PathVariable long limit,
                                            @ApiParam(name = "teacherVo", value = "查询对象", required = false)
                                            @RequestBody(required = false) TeacherQueryVo teacherQueryVo)

    {
        Result result = teacherService.selectPage(current, limit, teacherQueryVo);
        return result;
    }


    //根据id删除讲师的接口
    @ApiOperation("根据id删除讲师")
    @DeleteMapping("remove/{id}")
    public Result deleteById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable long id) {
        boolean remove = teacherService.removeById(id);
        return remove ? Result.ok() : Result.fail();
    }

    //新增讲师
    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        return save?Result.ok():Result.fail();
    }

    //根据id查询讲师
    @ApiOperation(value = "根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable long id){
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    //编写修改方法
    @ApiOperation(value = "根据id修改")
    @PutMapping("update")
    public Result update(@RequestBody Teacher teacher){
        boolean update = teacherService.updateById(teacher);
        return update?Result.ok():Result.fail();
    }

    //批量删除的方法
    @ApiOperation(value = "批量删除数据")
    @PutMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        teacherService.removeBatchByIds(idList);
        return Result.ok();
    }


}
