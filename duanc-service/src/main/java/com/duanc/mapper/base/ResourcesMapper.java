package com.duanc.mapper.base;

import com.duanc.model.base.BaseResources;
import com.duanc.model.base.BaseResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourcesMapper {
    int countByExample(BaseResourcesExample example);

    int deleteByExample(BaseResourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseResources record);

    int insertSelective(BaseResources record);

    List<BaseResources> selectByExample(BaseResourcesExample example);

    BaseResources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseResources record, @Param("example") BaseResourcesExample example);

    int updateByExample(@Param("record") BaseResources record, @Param("example") BaseResourcesExample example);

    int updateByPrimaryKeySelective(BaseResources record);

    int updateByPrimaryKey(BaseResources record);
}