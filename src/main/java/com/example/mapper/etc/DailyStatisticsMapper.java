package com.example.mapper.etc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.etc.DailyStatisticsVO;

@Mapper()
public interface DailyStatisticsMapper {

	DailyStatisticsVO selectDaily(int dailyNo);

	List<DailyStatisticsVO> selectList();

	void insertDaily(DailyStatisticsVO dailyVo);

	void updateDaily(String dailyDate);
}
