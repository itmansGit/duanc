package com.duanc.mapper.base;

import com.duanc.model.base.Baseorder;
import com.duanc.model.base.BaseorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface orderMapper {
    int countByExample(BaseorderExample example);

    int deleteByExample(BaseorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Baseorder record);

    int insertSelective(Baseorder record);

    List<Baseorder> selectByExample(BaseorderExample example);

    Baseorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Baseorder record, @Param("example") BaseorderExample example);

    int updateByExample(@Param("record") Baseorder record, @Param("example") BaseorderExample example);

    int updateByPrimaryKeySelective(Baseorder record);

    int updateByPrimaryKey(Baseorder record);
}