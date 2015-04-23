package com.duanc.mapper.base;

import com.duanc.model.base.BaseErrorLog;
import com.duanc.model.base.BaseErrorLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErrorLogMapper {
    int countByExample(BaseErrorLogExample example);

    int deleteByExample(BaseErrorLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseErrorLog record);

    int insertSelective(BaseErrorLog record);

    List<BaseErrorLog> selectByExample(BaseErrorLogExample example);

    BaseErrorLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseErrorLog record, @Param("example") BaseErrorLogExample example);

    int updateByExample(@Param("record") BaseErrorLog record, @Param("example") BaseErrorLogExample example);

    int updateByPrimaryKeySelective(BaseErrorLog record);

    int updateByPrimaryKey(BaseErrorLog record);
}