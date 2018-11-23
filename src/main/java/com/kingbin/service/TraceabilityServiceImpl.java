package com.kingbin.service;

import com.kingbin.mapper.TracebilityMapper;
import com.kingbin.model.ResultModel;
import com.kingbin.model.ResultTools;
import com.kingbin.model.TraceabilityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by WangBin on 2018/11/23
 */
@Component
public class TraceabilityServiceImpl implements TraceabilityService {

    @Autowired
    private TracebilityMapper tracebilityMapper;

    @Override
    public ResultModel findTraceabilityByAll() {
        try {
            Iterable<TraceabilityModel> users = tracebilityMapper.findTraceabilityByAll();
            return ResultTools.result(200, "", users);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel findTraceabilityByEquId( String equId) {
        try {
            TraceabilityModel traceabilityModel = tracebilityMapper.findTraceabilityByEquId(equId);
            return ResultTools.result(200, "", traceabilityModel);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }
}
