package com.ciabp.models;

import java.io.Serializable;

import com.ciabp.utils.TimeIdGenerator;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public abstract class ModelBase implements Serializable, Comparable<ModelBase> {
	
	private static final long serialVersionUID = 3152932638963402579L;
	
	private long id;
	
	public boolean equals(Object obj){
		if(obj==null || !(obj instanceof ModelBase))return false;
		ModelBase target = (ModelBase)obj;
		return this.getId()==target.getId();
	}
	
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
	
	public int compareTo(ModelBase mb){
		if(mb!=null)return (int) (this.id-mb.getId());
		else return 1;
	}
	
	
	//setters & getters
	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
}