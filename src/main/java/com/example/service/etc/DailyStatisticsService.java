package com.example.service.etc;

import java.util.List;

import com.example.vo.etc.DailyStatisticsVO;

public interface DailyStatisticsService {

	DailyStatisticsVO retrieve(int dailyNo);

	List<DailyStatisticsVO> retrieveList();

	void registerDaily(DailyStatisticsVO dailyVo);

	void modifyDaily(String dailyDate);

}
