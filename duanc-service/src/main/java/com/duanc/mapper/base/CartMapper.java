package com.duanc.mapper.base;

import com.duanc.model.base.BaseCart;
import com.duanc.model.base.BaseCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    int countByExample(BaseCartExample example);

    int deleteByExample(BaseCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseCart record);

    int insertSelective(BaseCart record);

    List<BaseCart> selectByExample(BaseCartExample example);

    BaseCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseCart record, @Param("example") BaseCartExample example);

    int updateByExample(@Param("record") BaseCart record, @Param("example") BaseCartExample example);

    int updateByPrimaryKeySelective(BaseCart record);

    int updateByPrimaryKey(BaseCart record);
}