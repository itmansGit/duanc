package com.duanc.mapper.base;

import com.duanc.model.base.BaseRoleResourcesExample;
import com.duanc.model.base.RoleResourcesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourcesMapper {
    int countByExample(BaseRoleResourcesExample example);

    int deleteByExample(BaseRoleResourcesExample example);

    int deleteByPrimaryKey(RoleResourcesKey key);

    int insert(RoleResourcesKey record);

    int insertSelective(RoleResourcesKey record);

    List<RoleResourcesKey> selectByExample(BaseRoleResourcesExample example);

    int updateByExampleSelective(@Param("record") RoleResourcesKey record, @Param("example") BaseRoleResourcesExample example);

    int updateByExample(@Param("record") RoleResourcesKey record, @Param("example") BaseRoleResourcesExample example);
}