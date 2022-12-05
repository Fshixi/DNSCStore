package com.example.store_item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.User;

public interface UserService extends IService<User> {
    User login(User user);
    JsonResult insertuser(User user);

    User getByUid(Integer uid);

    void updateUserInfo(User user);
    
    Boolean updatePassword(Integer uid,String oldPassword,String newPassword);
    
    void updateAvatarByUid(Integer uid,String username,String avatar);
}
