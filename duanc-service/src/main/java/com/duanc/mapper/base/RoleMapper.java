package com.duanc.mapper.base;

import com.duanc.model.base.BaseRole;
import com.duanc.model.base.BaseRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(BaseRoleExample example);

    int deleteByExample(BaseRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseRole record);

    int insertSelective(BaseRole record);

    List<BaseRole> selectByExample(BaseRoleExample example);

    BaseRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseRole record, @Param("example") BaseRoleExample example);

    int updateByExample(@Param("record") BaseRole record, @Param("example") BaseRoleExample example);

    int updateByPrimaryKeySelective(BaseRole record);

    int updateByPrimaryKey(BaseRole record);
}