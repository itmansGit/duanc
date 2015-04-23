package com.duanc.mapper.base;

import com.duanc.model.base.Baseuser;
import com.duanc.model.base.BaseuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userMapper {
    int countByExample(BaseuserExample example);

    int deleteByExample(BaseuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Baseuser record);

    int insertSelective(Baseuser record);

    List<Baseuser> selectByExample(BaseuserExample example);

    Baseuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Baseuser record, @Param("example") BaseuserExample example);

    int updateByExample(@Param("record") Baseuser record, @Param("example") BaseuserExample example);

    int updateByPrimaryKeySelective(Baseuser record);

    int updateByPrimaryKey(Baseuser record);
}