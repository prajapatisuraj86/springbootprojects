package com.suraj.jpaintegration.response;

public class CustomResponse {
	private String strMessage;
	private Object resObject;
	private String responseStatus;
	
	public CustomResponse(String strMessage, Object resObject, String responseStatus) {
		this.strMessage = strMessage;
		this.resObject = resObject;
		this.responseStatus = responseStatus;
	}
	public String getStrMessage() {
		return strMessage;
	}
	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}
	public Object getResObject() {
		return resObject;
	}
	public void setResObject(Object resObject) {
		this.resObject = resObject;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	@Override
	public String toString() {
		return "CustomResponse [strErrorMessage=" + strMessage + ", resObject=" + resObject + ", responseStatus="
				+ responseStatus + "]";
	}

}
