package com.duanc.mapper.base;

import com.duanc.model.base.Basebrand;
import com.duanc.model.base.BasebrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface brandMapper {
    int countByExample(BasebrandExample example);

    int deleteByExample(BasebrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Basebrand record);

    int insertSelective(Basebrand record);

    List<Basebrand> selectByExample(BasebrandExample example);

    Basebrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Basebrand record, @Param("example") BasebrandExample example);

    int updateByExample(@Param("record") Basebrand record, @Param("example") BasebrandExample example);

    int updateByPrimaryKeySelective(Basebrand record);

    int updateByPrimaryKey(Basebrand record);
}