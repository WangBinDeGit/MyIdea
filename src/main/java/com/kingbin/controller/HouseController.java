package com.kingbin.controller;

import com.kingbin.bean.HouseBean;
import com.kingbin.mydao.HouseDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by WangBin on 2018/4/12.
 * name
 */
@RestController
@RequestMapping(value = "/house")
@Api(description = "查询房屋")
public class HouseController {

    @Resource
    HouseDao houseDao;

    @ApiOperation(value = "查找用户的房源")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "long")
    @RequestMapping(value = "/findHouse", method = RequestMethod.POST)
    public List findHouse(@RequestParam(value = "id") long id) {

        List<HouseBean> houseList = houseDao.findById(id);

        return houseList;
    }

}
