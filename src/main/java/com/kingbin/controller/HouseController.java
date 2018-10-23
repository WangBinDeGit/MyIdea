package com.kingbin.controller;

import com.kingbin.mapper.HouseMapper;
import com.kingbin.model.HouseBean;
import com.kingbin.model.ResultModel;
import com.kingbin.model.ResultTools;
import com.kingbin.tools.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangBin on 2018/4/12.
 * name
 */
@RestController
@RequestMapping(value = "/house")
@Api(description = "查询房屋")
public class HouseController {

    @Autowired
    private HouseMapper houseMapper;

    @ApiOperation(value = "查询所有房源")
    @RequestMapping(value = "/findHouseByAll", method = RequestMethod.GET)
    public ResultModel findHouseByAll() {
        try {
            Iterable<HouseBean> houseList = houseMapper.findHouseByAll();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", houseList);
            return ResultTools.result(0, "", map);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @ApiOperation(value = "查找用户的房源")
    @RequestMapping(value = "/findHouseByUserId", method = RequestMethod.POST)
    public ResultModel findHouse(@RequestParam(value = "userId") Long userId) {
        try {
            if (ObjectUtils.isEmpty(userId)) return ResultTools.result(1001, "", null);
            Iterable<HouseBean> houseList = houseMapper.findHouseByUserId(userId);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", houseList);
            return ResultTools.result(0, "", map);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @ApiOperation(value = "根据用户名查找房源")
    @RequestMapping(value = "/findHouseByUserName", method = RequestMethod.POST)
    public ResultModel findHouseByUserName(@RequestParam(value = "userName") String userName) {
        try {
            if (ObjectUtils.isEmpty(userName)) return ResultTools.result(1001, "", null);
            Iterable<HouseBean> houseList = houseMapper.findHouseByUserName(userName);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", houseList);
            return ResultTools.result(0, "", map);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }
}
