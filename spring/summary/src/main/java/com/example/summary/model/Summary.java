package com.example.summary.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "summary")
public class Summary {
	public Summary() {}
	public Summary(String key,String desc)
	{
		this.key=key;
		this.desc=desc;
	}
	@Id
	private String key;
	
	private String desc;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString()
	{
		return "Summary [ key="+key+", desc"+desc + " ]";
	}
}
