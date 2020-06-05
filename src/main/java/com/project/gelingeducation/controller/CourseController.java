package com.project.gelingeducation.controller;


import com.project.gelingeducation.common.dto.JsonData;
import com.project.gelingeducation.domain.Course;
import com.project.gelingeducation.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

/**
 * 视频课程的controller
 */
@RequestMapping("/api/course")
@RestController
@Slf4j
public class CourseController {

    @Autowired
    private ICourseService courseService;

    /**
     * 获取所有课程
     *
     * @return
     */
    @RequestMapping(value = "/lists")
    public Object lists(Integer currentPage, Integer pageSize) {
        return JsonData.buildSuccess(courseService.getLists(currentPage, pageSize));
    }


    @RequestMapping(value = "/findall")
    public Object findAll() throws Exception {
        return JsonData.buildSuccess(courseService.findAll());
    }

    @RequestMapping(value = "/findbyid", method = RequestMethod.POST)
    public Object findById(Long id) throws Exception {
        return JsonData.buildSuccess(courseService.findById(id));
    }

    /**
     * 添加
     *
     * @param course
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody Course course) {
        courseService.insert(course);
        return JsonData.buildSuccess();
    }

    @RequestMapping(value = "/delect")
    public Object delect(Long id) {
        courseService.delect(id);
        return JsonData.buildSuccess();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(@RequestBody Course course) throws InvocationTargetException, IllegalAccessException {
        courseService.update(course);
        return JsonData.buildSuccess();
    }

    /**
     * 批量删除课程
     */
    @RequiresPermissions("user:root")
    @RequestMapping(value = "/batches_deletes")
    public Object delMore(String ids) {
        courseService.batchesDeletes(ids);
        return JsonData.buildSuccess();
    }

    /**
     * 按名字搜索
     */
    @RequestMapping(value = "/sel_by_name_or_status_price_teacher")
    public Object selByNameOrStatusOrPriceOrTeacher(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false)Integer status,
                                                    @RequestParam(required = false)Double startPrice,
                                                    @RequestParam(required = false)Double endPrice,
                                                    @RequestParam(required = false)Long teacherId,
                                                    Integer currentPage, Integer pageSize) {
        return JsonData.buildSuccess(courseService.selByNameOrStatusOrPriceOrTeacher(name, status, startPrice,
                endPrice, teacherId, currentPage, pageSize));
    }

}
