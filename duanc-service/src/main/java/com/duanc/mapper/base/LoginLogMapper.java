package com.duanc.mapper.base;

import com.duanc.model.base.BaseLoginLog;
import com.duanc.model.base.BaseLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginLogMapper {
    int countByExample(BaseLoginLogExample example);

    int deleteByExample(BaseLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseLoginLog record);

    int insertSelective(BaseLoginLog record);

    List<BaseLoginLog> selectByExample(BaseLoginLogExample example);

    BaseLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseLoginLog record, @Param("example") BaseLoginLogExample example);

    int updateByExample(@Param("record") BaseLoginLog record, @Param("example") BaseLoginLogExample example);

    int updateByPrimaryKeySelective(BaseLoginLog record);

    int updateByPrimaryKey(BaseLoginLog record);
}