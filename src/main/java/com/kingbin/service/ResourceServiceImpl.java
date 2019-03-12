package com.kingbin.service;

import com.kingbin.mapper.ResourceMapper;
import com.kingbin.model.ResourceModel;
import com.kingbin.model.ResultModel;
import com.kingbin.model.ResultTools;
import com.kingbin.tools.TreeUtil;
import com.kingbin.tools.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
            List<ResourceModel> resourceModels = resourceMapper.findResourceByAll();
            List<ResourceModel> resources = TreeUtils.buildByRecursive(resourceModels,"-1");
            return ResultTools.result(200, "", resources);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }
}
