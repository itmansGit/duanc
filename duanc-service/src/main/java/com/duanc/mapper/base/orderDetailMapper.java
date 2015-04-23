package com.duanc.mapper.base;

import com.duanc.model.base.BaseorderDetail;
import com.duanc.model.base.BaseorderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface orderDetailMapper {
    int countByExample(BaseorderDetailExample example);

    int deleteByExample(BaseorderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseorderDetail record);

    int insertSelective(BaseorderDetail record);

    List<BaseorderDetail> selectByExample(BaseorderDetailExample example);

    BaseorderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseorderDetail record, @Param("example") BaseorderDetailExample example);

    int updateByExample(@Param("record") BaseorderDetail record, @Param("example") BaseorderDetailExample example);

    int updateByPrimaryKeySelective(BaseorderDetail record);

    int updateByPrimaryKey(BaseorderDetail record);
}