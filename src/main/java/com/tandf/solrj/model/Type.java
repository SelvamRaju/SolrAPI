package com.tandf.solrj.model;

public class Type {

	private String text;

	private String sortOrder;

    private String prefix;

    private String code;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    
    
}
