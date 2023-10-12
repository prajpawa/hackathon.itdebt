package com.capgemini.lern2shan.itdebt.Exception;

public class ResourceNotFoundException extends RuntimeException {

	private static long serialVersionUID = 1L;

	public ResourceNotFoundException(String message)

	{
		super(message);
	}
}
