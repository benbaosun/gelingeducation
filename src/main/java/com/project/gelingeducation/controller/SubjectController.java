package com.project.gelingeducation.controller;

import com.project.gelingeducation.common.annotation.Log;
import com.project.gelingeducation.common.dto.JsonResult;
import com.project.gelingeducation.entity.Subject;
import com.project.gelingeducation.service.ISubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: LL
 * @Description: 课程专题的Controller
 */
@RequestMapping("/api/subject")
@RestController
@Slf4j
public class SubjectController {

    /**
     * 专题的service
     */
    @Autowired
    private ISubjectService subjectService;

    /**
     * 获取专题的lists
     * <p>
     * 如果currentPage为空
     *
     * @param currentPage
     * @param pageSize
     * @return subject实体类的lists
     */
    @Log("获取专题")
    @RequestMapping(value = "/lists")
    public Object lists(@RequestParam(required = false) Integer currentPage,
                        @RequestParam(required = false) Integer pageSize) {
        return JsonResult.buildSuccess(subjectService.queryAll(currentPage, pageSize));
    }

    /**
     * 通过id获取专题
     *
     * @param id 专题id
     * @return subject实体类
     */
    @Log("通过id获取专题")
    @RequestMapping(value = "/find_by_id")
    public Object findById(Long id) {
        return JsonResult.buildSuccess(subjectService.findById(id));
    }

    /**
     * 添加专题
     *
     * @param subject
     * @return /
     */
    @Log("添加专题")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody Subject subject) {
        subjectService.insert(subject);
        return JsonResult.buildSuccess();
    }

    /**
     * 删除专题
     *
     * @param id
     * @return /
     */
    @Log("删除专题")
    @RequestMapping(value = "/delete")
    public Object delete(Long id) {
        subjectService.delete(id);
        return JsonResult.buildSuccess();
    }

    /**
     * 更新专题
     *
     * @param subject
     * @return /
     */
    @Log("更新专题")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(@RequestBody Subject subject) {
        subjectService.update(subject);
        return JsonResult.buildSuccess();
    }

    /**
     * 批量删除专题
     *
     * @param ids 1,2,3 格式的专题id
     * @return
     */
    @Log("批量删除专题")
    @RequestMapping(value = "/batches_deletes", method = RequestMethod.GET)
    public Object batchesDeletes(String ids) {
        subjectService.delMore(ids);
        return JsonResult.buildSuccess();
    }

    /**
     * 条件搜索
     *
     * @param name        专题名称
     * @param courseIds   1,2,3 格式的字符串id
     * @param currentPage 页码
     * @param pageSize    页数
     * @return 分页实体类
     */
    @Log("条件搜索")
    @RequestMapping(value = "/search_criteria", method = RequestMethod.GET)
    public Object searchCriteria(String name, String courseIds, Integer currentPage,
                                 Integer pageSize) {
        return JsonResult.buildSuccess(subjectService.searchCriteria(name, courseIds,
                currentPage, pageSize));
    }
}
