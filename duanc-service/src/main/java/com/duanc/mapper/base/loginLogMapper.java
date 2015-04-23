package com.duanc.mapper.base;

import com.duanc.model.base.BaseloginLog;
import com.duanc.model.base.BaseloginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface loginLogMapper {
    int countByExample(BaseloginLogExample example);

    int deleteByExample(BaseloginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseloginLog record);

    int insertSelective(BaseloginLog record);

    List<BaseloginLog> selectByExample(BaseloginLogExample example);

    BaseloginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseloginLog record, @Param("example") BaseloginLogExample example);

    int updateByExample(@Param("record") BaseloginLog record, @Param("example") BaseloginLogExample example);

    int updateByPrimaryKeySelective(BaseloginLog record);

    int updateByPrimaryKey(BaseloginLog record);
}