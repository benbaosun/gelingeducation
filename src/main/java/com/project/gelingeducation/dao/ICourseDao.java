package com.project.gelingeducation.dao;

import com.project.gelingeducation.common.dto.PageResult;
import com.project.gelingeducation.domain.Course;

import java.util.List;
import java.util.Map;

public interface ICourseDao {
    PageResult findAll();

    Course findById(long id);

    long insert(Course video);

    void delect(long id);

    void update(Course video);

    void update(Long id, Map<String,String> data);

    PageResult getLists(int currentPage, int pageSize);

    void delSel(long[] ids);

    PageResult selByNameOrStatusOrPriceOrTeacher(String name, int status, double startPrice,
                                                 double endPrice, long teacherId,
                                                 int currentPage, int pageSize);
}