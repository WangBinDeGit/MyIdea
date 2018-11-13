package com.kingbin.service;

import com.kingbin.mapper.HouseMapper;
import com.kingbin.model.HouseBean;
import com.kingbin.model.ResultModel;
import com.kingbin.model.ResultTools;
import com.kingbin.tools.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by WangBin on 2018/10/23
 */
@Component
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public ResultModel findHouseByAll() {
        try {
            Iterable<HouseBean> houseList = houseMapper.findHouseByAll();
            return ResultTools.result(200, "", houseList);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel findHouseByUserId(Long userId) {
        try {
            if (ObjectUtils.isEmpty(userId)) return ResultTools.result(1001, "", null);
            Iterable<HouseBean> houseList = houseMapper.findHouseByUserId(userId);
            return ResultTools.result(200, "", houseList);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel findHouseByUserName(String userName) {
        try {
            if (ObjectUtils.isEmpty(userName)) return ResultTools.result(1001, "", null);
            Iterable<HouseBean> houseList = houseMapper.findHouseByUserName(userName);
            return ResultTools.result(200, "", houseList);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }

    @Override
    public ResultModel updateHouse(HouseBean houseBean) {
        try {
            if (ObjectUtils.isEmpty(houseBean) || ObjectUtils.isEmpty(houseBean.getHouseId()) ||
                    (ObjectUtils.isEmpty(houseBean.getHouseTitle()) && ObjectUtils.isEmpty(houseBean.getHouseContent())
                            && ObjectUtils.isEmpty(houseBean.getUserId())))
                return ResultTools.result(1001, "", null);
            int code = houseMapper.updateHouse(houseBean);
            if (1 == code) return ResultTools.result(200, "修改成功", null);
            HouseBean userBean = houseMapper.findHouseById(houseBean.getHouseId());
            if (ObjectUtils.isEmpty(userBean))
                return ResultTools.result(1002, "未查询到该房屋", null);
            return ResultTools.result(404, "修改失败", null);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }
}
