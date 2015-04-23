package com.duanc.mapper.base;

import com.duanc.model.base.Baseresources;
import com.duanc.model.base.BaseresourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface resourcesMapper {
    int countByExample(BaseresourcesExample example);

    int deleteByExample(BaseresourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Baseresources record);

    int insertSelective(Baseresources record);

    List<Baseresources> selectByExample(BaseresourcesExample example);

    Baseresources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Baseresources record, @Param("example") BaseresourcesExample example);

    int updateByExample(@Param("record") Baseresources record, @Param("example") BaseresourcesExample example);

    int updateByPrimaryKeySelective(Baseresources record);

    int updateByPrimaryKey(Baseresources record);
}