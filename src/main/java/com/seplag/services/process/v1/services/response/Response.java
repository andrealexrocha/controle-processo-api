package com.seplag.services.process.v1.services.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Response<T> {

	private T data;
}
