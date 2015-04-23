package com.duanc.mapper.base;

import com.duanc.model.base.Baserole;
import com.duanc.model.base.BaseroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface roleMapper {
    int countByExample(BaseroleExample example);

    int deleteByExample(BaseroleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Baserole record);

    int insertSelective(Baserole record);

    List<Baserole> selectByExample(BaseroleExample example);

    Baserole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Baserole record, @Param("example") BaseroleExample example);

    int updateByExample(@Param("record") Baserole record, @Param("example") BaseroleExample example);

    int updateByPrimaryKeySelective(Baserole record);

    int updateByPrimaryKey(Baserole record);
}