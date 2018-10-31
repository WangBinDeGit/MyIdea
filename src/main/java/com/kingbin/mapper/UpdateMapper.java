package com.kingbin.mapper;

import com.kingbin.model.UpdateModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WangBin on 2018/10/31
 */
@Repository
@Component
public interface UpdateMapper {

    /*******判断是否有更新********/
    List<UpdateModel> findUpdate();
}
