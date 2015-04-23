package com.duanc.mapper.base;

import com.duanc.model.base.Basemodel;
import com.duanc.model.base.BasemodelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface modelMapper {
    int countByExample(BasemodelExample example);

    int deleteByExample(BasemodelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Basemodel record);

    int insertSelective(Basemodel record);

    List<Basemodel> selectByExample(BasemodelExample example);

    Basemodel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Basemodel record, @Param("example") BasemodelExample example);

    int updateByExample(@Param("record") Basemodel record, @Param("example") BasemodelExample example);

    int updateByPrimaryKeySelective(Basemodel record);

    int updateByPrimaryKey(Basemodel record);
}