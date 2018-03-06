package com.example.upday.newscore.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by tej on 20/2/18.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> extends ResourceSupport{  
	
    private T data;
    private ErrorDetails error;
    boolean success=true;
       
    public ApiResponse() {
        super();
    }

    public ApiResponse(T data) {
    	super();
        this.data = data;
    }

    
    public ApiResponse(ErrorDetails error) {
    	this.error=error;  
    	success=false;
    }
   
	public ErrorDetails getError() {
		return error;
	}
	public void setError(ErrorDetails error) {
		success=false;
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
    
    
    
}
