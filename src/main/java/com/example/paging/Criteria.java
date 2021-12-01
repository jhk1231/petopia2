package com.example.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	// 현재 페이지 번호
	private int currentPageNo;
	// 페이지당 출력할 데이터 개수
	private int dataPerPage;
	// 출력할 페이지 사이즈
	private int pageSize;
	
	public Criteria() {
		this.currentPageNo = 1;
		this.dataPerPage = 3;
		this.pageSize = 3;
	}
	
	public int getStartPage() {
		return (currentPageNo - 1) * dataPerPage;
	}
}
