package com.fls.animecommunity.animesanctuary.model.category.dto;

import lombok.Getter;

/*
 * Category의 requset가 성공했을 경우 
 * response하는 응답객체
 */


@Getter
public class SuccessResponseDto {
	private boolean success;
	
	public SuccessResponseDto(boolean success) {
        this.success = success;
    }
}
