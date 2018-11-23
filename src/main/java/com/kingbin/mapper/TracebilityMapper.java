package com.kingbin.mapper;

import com.kingbin.model.TraceabilityModel;
import com.kingbin.model.UserBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WangBin on 2018/11/23
 */

@Repository
@Component
public interface TracebilityMapper {

    /*******查询所有九码溯源数据********/
    List<TraceabilityModel> findTraceabilityByAll();

    /*******根据设备id查询九码溯源数据********/
    TraceabilityModel findTraceabilityByEquId(String equId);

}
