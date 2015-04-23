package com.duanc.mapper.base;

import com.duanc.model.base.Basecart;
import com.duanc.model.base.BasecartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cartMapper {
    int countByExample(BasecartExample example);

    int deleteByExample(BasecartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Basecart record);

    int insertSelective(Basecart record);

    List<Basecart> selectByExample(BasecartExample example);

    Basecart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Basecart record, @Param("example") BasecartExample example);

    int updateByExample(@Param("record") Basecart record, @Param("example") BasecartExample example);

    int updateByPrimaryKeySelective(Basecart record);

    int updateByPrimaryKey(Basecart record);
}