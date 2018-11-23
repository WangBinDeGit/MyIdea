package com.kingbin.controller;

import com.kingbin.model.ResultModel;
import com.kingbin.service.TraceabilityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangBin on 2018/11/23
 */

@RestController
@RequestMapping(value = "/traceability")
@Api(description = "九码溯源")
public class TraceabilityController {

    @Autowired
    private TraceabilityService traceabilityService;

    @ApiOperation(value = "查询所有九码溯源数据")
    @RequestMapping(value = "/findTraceabilityByAll", method = RequestMethod.POST)
    public ResultModel findTraceabilityByAll() {
        return traceabilityService.findTraceabilityByAll();
    }

    @ApiOperation(value = "根据设备id查询九码溯源数据")
    @RequestMapping(value = "/findTraceabilityByEquId", method = RequestMethod.POST)
    public ResultModel findTraceabilityByEquId(@RequestParam(value = "equId") String equId) {
        return traceabilityService.findTraceabilityByEquId(equId);
    }
}
