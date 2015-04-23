package com.duanc.mapper.base;

import com.duanc.model.base.BasePhone;
import com.duanc.model.base.BasePhoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhoneMapper {
    int countByExample(BasePhoneExample example);

    int deleteByExample(BasePhoneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BasePhone record);

    int insertSelective(BasePhone record);

    List<BasePhone> selectByExample(BasePhoneExample example);

    BasePhone selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BasePhone record, @Param("example") BasePhoneExample example);

    int updateByExample(@Param("record") BasePhone record, @Param("example") BasePhoneExample example);

    int updateByPrimaryKeySelective(BasePhone record);

    int updateByPrimaryKey(BasePhone record);
}