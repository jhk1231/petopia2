package com.example.dao.etc;

import java.util.List;

import com.example.vo.etc.DailyStatisticsVO;

public interface DailyStatisticsDao {

	DailyStatisticsVO selectDaily(int dailyNo);

	List<DailyStatisticsVO> selectList();

	void insertDaily(DailyStatisticsVO dailyVo);

	void updateDaily(String dailyDate);

}
