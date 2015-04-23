package com.duanc.mapper.base;

import com.duanc.model.base.Basephone;
import com.duanc.model.base.BasephoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface phoneMapper {
    int countByExample(BasephoneExample example);

    int deleteByExample(BasephoneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Basephone record);

    int insertSelective(Basephone record);

    List<Basephone> selectByExample(BasephoneExample example);

    Basephone selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Basephone record, @Param("example") BasephoneExample example);

    int updateByExample(@Param("record") Basephone record, @Param("example") BasephoneExample example);

    int updateByPrimaryKeySelective(Basephone record);

    int updateByPrimaryKey(Basephone record);
}