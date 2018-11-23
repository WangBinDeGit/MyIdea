package com.kingbin.controller;

import com.kingbin.model.ResultModel;
import com.kingbin.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangBin on 2018/11/23
 * <p>
 * 1、从数据库中查询sys_resource表数据，返回树形结构数据
 * 2、在第一题基础上，封装树形结构处理公共类，要求能处理项目中所有list -> tree 的转换
 */
@RestController
@RequestMapping(value = "/resource")
@Api(description = "返回树形结构数据")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "查询返回树形结构数据")
    @RequestMapping(value = "/findResourceByAll", method = RequestMethod.POST)
    public ResultModel findResourceByAll() {
        return resourceService.findResourceByAll();
    }

}
