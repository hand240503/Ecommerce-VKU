package com.ndh.paging;


import com.ndh.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	String getCode();

	Sorter getSorter();
}
