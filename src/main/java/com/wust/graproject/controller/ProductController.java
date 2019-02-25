package com.wust.graproject.controller;

import com.github.pagehelper.PageInfo;
import com.wust.graproject.entity.Product;
import com.wust.graproject.global.ResultDataDto;
import com.wust.graproject.service.IProductService;
import com.wust.graproject.util.RedisPrefixKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProduceController
 * @Description TODO
 * @Author leis
 * @Date 2019/2/20 10:36
 * @Version 1.0
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(path = "/indexTV")
    public ResultDataDto getIndexTV() {
        Object o = redisTemplate.opsForValue().get(RedisPrefixKeyUtil.INDEX_TV);
        PageInfo<Product> pageInfo = null;
        if (o != null) {
            pageInfo = (PageInfo<Product>) o;
        } else {
            pageInfo = productService.selectTelevision();
        }
        return ResultDataDto.operationSuccess().setData(pageInfo);
    }

    @GetMapping(path = "/indexBook")
    public ResultDataDto getIndexBook() {
        Object o = redisTemplate.opsForValue().get(RedisPrefixKeyUtil.INDEX_BOOK);
        PageInfo<Product> pageInfo = null;
        if (o != null) {
            pageInfo = (PageInfo<Product>) o;
        } else {
            pageInfo = productService.selectBook();
        }
        return ResultDataDto.operationSuccess().setData(pageInfo);
    }

    @GetMapping(path = "/indexLipstick")
    public ResultDataDto getIndexLipstick() {
        Object o = redisTemplate.opsForValue().get(RedisPrefixKeyUtil.INDEX_LIPSTICK);
        PageInfo<Product> pageInfo = null;
        if (o != null) {
            pageInfo = (PageInfo<Product>) o;
        } else {
            pageInfo = productService.selectLipstick();
        }
        return ResultDataDto.operationSuccess().setData(pageInfo);
    }

    public ResultDataDto list() {
        return null;
    }

    public ResultDataDto detail() {
        return null;
    }


}