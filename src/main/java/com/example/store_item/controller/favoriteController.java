package com.example.store_item.controller;

import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.Favorites;
import com.example.store_item.service.FavoriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/favorite")
@Slf4j
public class favoriteController {
    @Autowired
    private FavoriteService favoriteService;
    
    @PostMapping("/insertfavorite")
    public JsonResult insertFavorite(Integer id, HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        log.info(uid.toString());
        String username = (String) session.getAttribute("username");
        favoriteService.insertFavorite(id,uid,username);
        return new JsonResult(200);
    }   
    
    @GetMapping("/findfavorite")
    public JsonResult findFavorite(HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        List<Favorites> favorites = favoriteService.selectAll(uid);
        return new JsonResult(200,favorites);
    }
}
