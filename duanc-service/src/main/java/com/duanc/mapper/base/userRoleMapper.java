package com.duanc.mapper.base;

import com.duanc.model.base.BaseuserRoleExample;
import com.duanc.model.base.userRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userRoleMapper {
    int countByExample(BaseuserRoleExample example);

    int deleteByExample(BaseuserRoleExample example);

    int deleteByPrimaryKey(userRoleKey key);

    int insert(userRoleKey record);

    int insertSelective(userRoleKey record);

    List<userRoleKey> selectByExample(BaseuserRoleExample example);

    int updateByExampleSelective(@Param("record") userRoleKey record, @Param("example") BaseuserRoleExample example);

    int updateByExample(@Param("record") userRoleKey record, @Param("example") BaseuserRoleExample example);
}