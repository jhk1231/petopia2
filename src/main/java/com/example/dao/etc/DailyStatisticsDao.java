package com.example.dao.etc;

import java.util.ArrayList;

import com.example.vo.etc.DailyStatisticsVO;

public interface DailyStatisticsDao {

	DailyStatisticsVO selectDaily();

	ArrayList<DailyStatisticsVO> selectList();

	void insertAndupdateDaily();

}
