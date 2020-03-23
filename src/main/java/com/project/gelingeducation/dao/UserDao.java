package com.project.gelingeducation.dao;

import com.project.gelingeducation.domain.User;
import com.project.gelingeducation.dto.PageResult;

public interface UserDao {
    PageResult getLists(int currentPage, int pageSize);

    User findById(long id);

    User findByPhone(String account);

    User insert(User user);

    void delect(long id);

    void delSel(long[] ids);

    void update(User user);

    void updateCoverImg(long id, String coverImg);

    PageResult selbyname(String name,int currentPage, int pageSize);
}