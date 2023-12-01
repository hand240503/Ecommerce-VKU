package com.ndh.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageModel extends AbstractModel<ImageModel> {

	private Long idProduct;
	
	private String pathImageProduct;

	private String desImage;


}
