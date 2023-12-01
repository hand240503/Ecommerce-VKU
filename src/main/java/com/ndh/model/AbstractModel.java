package com.ndh.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AbstractModel<T> {

	private Long id;
	private String sortName;
	private String sortBy;
	private List<T> listResult = new ArrayList<>();

}
