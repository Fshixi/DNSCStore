package com.example.store_item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.User;
import com.example.store_item.mapper.UserMapper;
import com.example.store_item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class userServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserService userService;
    @Override
    public User login(User user) {
        
            String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getUsername,user.getUsername()).eq(User::getPassword,password);
            User one = userService.getOne(queryWrapper);
            if (one==null){
                return null;
            }
            return one;
            
    }

    @Override
    public JsonResult insertuser(User user) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User getUser = userService.getOne(queryWrapper);
        if (getUser!=null){
            return new JsonResult(100);
        }
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);
        userService.save(user);
        return new JsonResult(200);
    }

    @Override
    public User getByUid(Integer uid) {
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper();
        wrapper.eq(User::getUid,uid);
        User user = userService.getOne(wrapper);
        return user;
    }

    @Override
    public void updateUserInfo(User user) {
        Integer uid = user.getUid();
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(User::getUid,uid);
        userService.update(user,wrapper);
    }

    @Override
    public Boolean updatePassword(Integer uid, String oldPassword, String newPassword) {
        oldPassword=DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(User::getUid,uid).eq(User::getPassword,oldPassword);
        User user = userService.getOne(wrapper);
        if (user!=null){
            newPassword=DigestUtils.md5DigestAsHex(newPassword.getBytes());
            user.setPassword(newPassword);
            LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getUid,uid);
            userService.update(user,queryWrapper);
            return true;
        }
        return false;
    }
    
    @Override
    public void updateAvatarByUid(Integer uid, String username, String avatar) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUid,uid);
        User user = userService.getOne(queryWrapper);
        user.setAvatar(avatar);
        user.setModifiedUser(username);
        userService.update(user,queryWrapper);

    }


}
