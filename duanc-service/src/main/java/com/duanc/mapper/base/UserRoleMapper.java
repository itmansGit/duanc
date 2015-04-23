package com.duanc.mapper.base;

import com.duanc.model.base.BaseUserRoleExample;
import com.duanc.model.base.UserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int countByExample(BaseUserRoleExample example);

    int deleteByExample(BaseUserRoleExample example);

    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    List<UserRoleKey> selectByExample(BaseUserRoleExample example);

    int updateByExampleSelective(@Param("record") UserRoleKey record, @Param("example") BaseUserRoleExample example);

    int updateByExample(@Param("record") UserRoleKey record, @Param("example") BaseUserRoleExample example);
}