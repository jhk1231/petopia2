package com.example.mapper.etc;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.etc.DailyStatisticsVO;

@Mapper()
public interface DailyStatisticsMapper {

	DailyStatisticsVO selectDaily();

	ArrayList<DailyStatisticsVO> selectList();

	void insertAndupdateDaily();
}
