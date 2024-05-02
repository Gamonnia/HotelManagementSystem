package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.CheckOutRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckOutRecordMapper {
    int deleteByPrimaryKey(Integer checkOutRecordID);

    int insert(CheckOutRecord record);

    int insertSelective(CheckOutRecord record);

    CheckOutRecord selectByPrimaryKey(Integer checkOutRecordID);

    int updateByPrimaryKeySelective(CheckOutRecord record);

    int updateByPrimaryKey(CheckOutRecord record);

    List<CheckOutRecord> selectAll();

    int alterTable();
}