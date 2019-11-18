package com.yanglijing.controller;

import com.yanglijing.pojo.BackPrice;
import com.yanglijing.service.ProductService;
import com.yanglijing.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ProductController
 * @Description: TODO
 * @Author :yanglijing
 * @Date 2019/11/18
 * @Version V1.0
 **/
@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public Object list(ProductVo productVo){
        return productService.selectList(productVo);
    }

    @GetMapping("/deleteById")
    public void deleteById(Integer backId){
        productService.deleteById(backId);
    }

    @PostMapping("/deleteByIds")
    public void deleteById(@RequestBody List<BackPrice> backPrice){
        System.out.println("===================="+backPrice);
        productService.deleteByIds(backPrice);
    }

    @PostMapping("/save")
    public void save(@RequestBody BackPrice backPrice){
        System.out.println("===================="+backPrice);
        productService.save(backPrice);
    }

    @GetMapping("/selectById")
    public Object selectById(Integer backId){
        return productService.selectById(backId);
    }

    @GetMapping("/update")
    public Object update(BackPrice backPrice){
        return productService.update(backPrice);
    }
}
