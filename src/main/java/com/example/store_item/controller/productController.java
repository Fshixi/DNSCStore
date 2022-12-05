package com.example.store_item.controller;

import com.example.store_item.common.JsonResult;
import com.example.store_item.entity.Product;
import com.example.store_item.mapper.ProductMapper;
import com.example.store_item.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class productController {
    @Autowired
    private ProductService productService;
    
    
    @GetMapping("/newdetails")
    public JsonResult getNewStore(){
        List<Product> newStore = productService.getNewStore();
        return new JsonResult(200,newStore);


    }
    @GetMapping("/details")
    public JsonResult getHostStore(){
        List<Product> details = productService.getHostStore();
        return new JsonResult(200,details);
    }
    @GetMapping("/{id}/good")
    public JsonResult selectGood(@PathVariable Long id){
        Product product = productService.selectGood(id);
        return new JsonResult(200,product);

    }
    
}
