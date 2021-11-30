package com.example.service.etc;

import java.util.ArrayList;

import com.example.vo.etc.DailyStatisticsVO;

public interface DailyStatisticsService {

	DailyStatisticsVO retrieve();

	ArrayList<DailyStatisticsVO> retrieveList();

	void registerAndmodifyDaily();


}
