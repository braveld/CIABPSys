package com.ciabp.services;

import java.io.Serializable;

import com.ciabp.utils.ServiceResult;

public class ServiceBase implements Serializable {

	private static final long serialVersionUID = -7808015568690610669L;

	protected ServiceResult getSuccessResult(String info){
		ServiceResult sr = new ServiceResult();
		sr.setCode(ServiceResult.SUCCESS);
		sr.setInfo(info);
		return sr;
	}
	protected ServiceResult getExceptionResult(String info){
		ServiceResult sr = new ServiceResult();
		sr.setCode(ServiceResult.EXCEPTION);
		sr.setInfo(info);
		return sr;
	}
	protected ServiceResult getErrorResult(String info){
		ServiceResult sr = new ServiceResult();
		sr.setCode(ServiceResult.ERROR);
		sr.setInfo(info);
		return sr;
	}
	protected ServiceResult getEmptyResult(){
		return new ServiceResult();
	}
	
}
