package com.kingbin.service;

import com.kingbin.mapper.ResourceMapper;
import com.kingbin.model.ResourceModel;
import com.kingbin.model.ResultModel;
import com.kingbin.model.ResultTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by WangBin on 2018/11/23
 */
@Component
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public ResultModel findResourceByAll() {
        try {
            Iterable<ResourceModel> users = resourceMapper.findResourceByAll();
            return ResultTools.result(200, "", users);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }
}
