package com.example.store_item.controller;

import com.example.store_item.common.JsonResult;
import com.example.store_item.controller.ex.FileEmptyException;
import com.example.store_item.controller.ex.FileUploadException;
import com.example.store_item.controller.ex.FileUploadIOException;
import com.example.store_item.entity.User;
import com.example.store_item.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Slf4j
public class userController {
    
    @Autowired
    private UserService userService;
    //登录
    @PostMapping("/login")
    public JsonResult login(User user, HttpSession session){
        System.out.println(user);
        User login = userService.login(user);
        session.setAttribute("uid",login.getUid());
        session.setAttribute("username",login.getUsername());
        Object uid = session.getAttribute("uid");
        System.out.println("========================================================");
        System.out.println(login);
        System.out.println(uid);
        if (login!=null){
            return new JsonResult(200,user);
        }
        return new JsonResult(100,user);
    }
    
    //创建用户
    @PostMapping("/insertuser")
    public JsonResult insertuser(User user){
        System.out.println(user);
        JsonResult jsonResult = userService.insertuser(user);
        return jsonResult;
    }
    //退出
    @RequestMapping("/exit")
    public void exit(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/web/login.html");
    }
    //获取id信息
    @GetMapping("/getbyuid")
    public JsonResult getByUid(HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        User user = userService.getByUid(uid);
        return new JsonResult(200,user);
    }
    //修改资料
    @GetMapping("/updateuserinfo")
    public JsonResult updateUserInfo(User user,HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        user.setUid(uid);
        log.info(user.toString());
        userService.updateUserInfo(user) ;
        return new JsonResult(200);
    }
    //修改密码
    @PostMapping("/update")
    public JsonResult update(String oldPassword,String newPassword,HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        Boolean index = userService.updatePassword(uid, oldPassword, newPassword);
        if (index){
            return new JsonResult(200);
        }
        return new JsonResult(100);
    }
    //上传头像
    @PostMapping("/updateAvatarByUid")
    public JsonResult updateAvatarByUid(HttpSession session,MultipartFile file){
        if (file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        //将要保存的头像放到parent目录总，parent目录为项目路径+upload
        String parent = session.getServletContext().getRealPath("upload");
        File dir=new File(parent);
        if (!dir.exists()){
            dir.mkdir();
        }
        log.info(parent);
        String originalFilename = file.getOriginalFilename();
        int index=originalFilename.lastIndexOf(".");
        String substring = originalFilename.substring(index);
        String filename= UUID.randomUUID().toString().toUpperCase()+substring;
        File dest=new File(dir,filename);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写时发生异常");
        }
        Integer uid = (Integer) session.getAttribute("uid");
        String username= (String) session.getAttribute("username");
        String avatar="/upload/"+filename;
        userService.updateAvatarByUid(uid,username,avatar);
        return new JsonResult(200,avatar);     
    }
}
