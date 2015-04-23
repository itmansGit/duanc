package com.duanc.mapper.base;

import com.duanc.model.base.BaseUserAddress;
import com.duanc.model.base.BaseUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAddressMapper {
    int countByExample(BaseUserAddressExample example);

    int deleteByExample(BaseUserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserAddress record);

    int insertSelective(BaseUserAddress record);

    List<BaseUserAddress> selectByExample(BaseUserAddressExample example);

    BaseUserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseUserAddress record, @Param("example") BaseUserAddressExample example);

    int updateByExample(@Param("record") BaseUserAddress record, @Param("example") BaseUserAddressExample example);

    int updateByPrimaryKeySelective(BaseUserAddress record);

    int updateByPrimaryKey(BaseUserAddress record);
}