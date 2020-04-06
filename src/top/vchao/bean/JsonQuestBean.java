package top.vchao.bean;

import java.util.ArrayList;

public class JsonQuestBean {
	
	private String status;
	private String code;
	private ArrayList<QuestBean> messages;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<QuestBean> getQuestbeans() {
		return messages;
	}
	public void setQuestbeans(ArrayList<QuestBean> questbeans) {
		this.messages = questbeans;
	}
	
}
