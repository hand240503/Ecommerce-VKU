package com.ndh.paging;

import com.ndh.sorter.Sorter;

import java.util.List;

public class PageRequest implements Pageble {

	private Integer page;
	private Integer maxPageItem;
	private String code;
	private Sorter sorter;

	private List<String> brands;

	public PageRequest(Integer page, Integer maxPageItem, String code,Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.code = code;
		this.sorter = sorter;
	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if (this.page != null && this.maxPageItem != null) {
			return (this.page - 1) * this.maxPageItem;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxPageItem;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public Sorter getSorter() {
		if (this.sorter != null) {
			return this.sorter;
		}
		return null;
	}


}
