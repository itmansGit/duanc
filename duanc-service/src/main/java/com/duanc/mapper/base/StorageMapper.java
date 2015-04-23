package com.duanc.mapper.base;

import com.duanc.model.base.BaseStorage;
import com.duanc.model.base.BaseStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    int countByExample(BaseStorageExample example);

    int deleteByExample(BaseStorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseStorage record);

    int insertSelective(BaseStorage record);

    List<BaseStorage> selectByExample(BaseStorageExample example);

    BaseStorage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseStorage record, @Param("example") BaseStorageExample example);

    int updateByExample(@Param("record") BaseStorage record, @Param("example") BaseStorageExample example);

    int updateByPrimaryKeySelective(BaseStorage record);

    int updateByPrimaryKey(BaseStorage record);
}