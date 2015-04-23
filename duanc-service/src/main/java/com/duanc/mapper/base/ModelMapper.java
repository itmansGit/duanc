package com.duanc.mapper.base;

import com.duanc.model.base.BaseModel;
import com.duanc.model.base.BaseModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelMapper {
    int countByExample(BaseModelExample example);

    int deleteByExample(BaseModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseModel record);

    int insertSelective(BaseModel record);

    List<BaseModel> selectByExample(BaseModelExample example);

    BaseModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseModel record, @Param("example") BaseModelExample example);

    int updateByExample(@Param("record") BaseModel record, @Param("example") BaseModelExample example);

    int updateByPrimaryKeySelective(BaseModel record);

    int updateByPrimaryKey(BaseModel record);
}