package com.example.store_item.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMeteObjectHandle implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createdTime", LocalDateTime.now());
//        metaObject.setValue("createdUser", "admin");
        try{
            metaObject.setValue("modifiedTime", LocalDateTime.now());
//            metaObject.setValue("modifiedUser", "admin");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    

    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("createdTime", LocalDateTime.now());
        metaObject.setValue("createdUser", "admin");
        try{
            metaObject.setValue("modifiedTime", LocalDateTime.now());
            metaObject.setValue("modifiedUser", "admin");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
