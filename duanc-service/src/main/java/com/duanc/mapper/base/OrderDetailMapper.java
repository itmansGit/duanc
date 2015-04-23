package com.duanc.mapper.base;

import com.duanc.model.base.BaseOrderDetail;
import com.duanc.model.base.BaseOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    int countByExample(BaseOrderDetailExample example);

    int deleteByExample(BaseOrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseOrderDetail record);

    int insertSelective(BaseOrderDetail record);

    List<BaseOrderDetail> selectByExample(BaseOrderDetailExample example);

    BaseOrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseOrderDetail record, @Param("example") BaseOrderDetailExample example);

    int updateByExample(@Param("record") BaseOrderDetail record, @Param("example") BaseOrderDetailExample example);

    int updateByPrimaryKeySelective(BaseOrderDetail record);

    int updateByPrimaryKey(BaseOrderDetail record);
}