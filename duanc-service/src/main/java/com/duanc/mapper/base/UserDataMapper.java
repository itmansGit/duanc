package com.duanc.mapper.base;

import com.duanc.model.base.BaseUserData;
import com.duanc.model.base.BaseUserDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDataMapper {
    int countByExample(BaseUserDataExample example);

    int deleteByExample(BaseUserDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserData record);

    int insertSelective(BaseUserData record);

    List<BaseUserData> selectByExample(BaseUserDataExample example);

    BaseUserData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseUserData record, @Param("example") BaseUserDataExample example);

    int updateByExample(@Param("record") BaseUserData record, @Param("example") BaseUserDataExample example);

    int updateByPrimaryKeySelective(BaseUserData record);

    int updateByPrimaryKey(BaseUserData record);
}