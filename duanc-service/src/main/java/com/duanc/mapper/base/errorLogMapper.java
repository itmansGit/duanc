package com.duanc.mapper.base;

import com.duanc.model.base.BaseerrorLog;
import com.duanc.model.base.BaseerrorLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface errorLogMapper {
    int countByExample(BaseerrorLogExample example);

    int deleteByExample(BaseerrorLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseerrorLog record);

    int insertSelective(BaseerrorLog record);

    List<BaseerrorLog> selectByExample(BaseerrorLogExample example);

    BaseerrorLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseerrorLog record, @Param("example") BaseerrorLogExample example);

    int updateByExample(@Param("record") BaseerrorLog record, @Param("example") BaseerrorLogExample example);

    int updateByPrimaryKeySelective(BaseerrorLog record);

    int updateByPrimaryKey(BaseerrorLog record);
}