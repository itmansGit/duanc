package com.duanc.mapper.base;

import com.duanc.model.base.BaseroleResourcesExample;
import com.duanc.model.base.roleResourcesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface roleResourcesMapper {
    int countByExample(BaseroleResourcesExample example);

    int deleteByExample(BaseroleResourcesExample example);

    int deleteByPrimaryKey(roleResourcesKey key);

    int insert(roleResourcesKey record);

    int insertSelective(roleResourcesKey record);

    List<roleResourcesKey> selectByExample(BaseroleResourcesExample example);

    int updateByExampleSelective(@Param("record") roleResourcesKey record, @Param("example") BaseroleResourcesExample example);

    int updateByExample(@Param("record") roleResourcesKey record, @Param("example") BaseroleResourcesExample example);
}