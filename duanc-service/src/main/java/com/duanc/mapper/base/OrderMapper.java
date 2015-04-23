package com.duanc.mapper.base;

import com.duanc.model.base.BaseOrder;
import com.duanc.model.base.BaseOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int countByExample(BaseOrderExample example);

    int deleteByExample(BaseOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseOrder record);

    int insertSelective(BaseOrder record);

    List<BaseOrder> selectByExample(BaseOrderExample example);

    BaseOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseOrder record, @Param("example") BaseOrderExample example);

    int updateByExample(@Param("record") BaseOrder record, @Param("example") BaseOrderExample example);

    int updateByPrimaryKeySelective(BaseOrder record);

    int updateByPrimaryKey(BaseOrder record);
}