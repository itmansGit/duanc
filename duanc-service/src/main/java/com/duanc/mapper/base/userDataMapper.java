package com.duanc.mapper.base;

import com.duanc.model.base.BaseuserData;
import com.duanc.model.base.BaseuserDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userDataMapper {
    int countByExample(BaseuserDataExample example);

    int deleteByExample(BaseuserDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseuserData record);

    int insertSelective(BaseuserData record);

    List<BaseuserData> selectByExample(BaseuserDataExample example);

    BaseuserData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseuserData record, @Param("example") BaseuserDataExample example);

    int updateByExample(@Param("record") BaseuserData record, @Param("example") BaseuserDataExample example);

    int updateByPrimaryKeySelective(BaseuserData record);

    int updateByPrimaryKey(BaseuserData record);
}