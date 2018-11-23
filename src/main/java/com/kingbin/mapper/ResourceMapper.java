package com.kingbin.mapper;

import com.kingbin.model.ResourceModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WangBin on 2018/11/23
 */
@Repository
@Component
public interface ResourceMapper {
    /*******查询所有九码溯源数据********/
    List<ResourceModel> findResourceByAll();
}
