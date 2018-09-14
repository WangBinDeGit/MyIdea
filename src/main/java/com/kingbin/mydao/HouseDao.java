package com.kingbin.mydao;

import com.kingbin.bean.HouseBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WangBin on 2018/4/11.
 * name
 */
@Repository
public interface HouseDao extends JpaRepository<HouseBean, Long> {

    List<HouseBean> findById(Long id);

}