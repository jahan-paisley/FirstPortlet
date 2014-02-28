	package com.captechventures.java.spring3.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Entity
//could be an entity
public class ToDo {

	@Size(min = 1, max = 50)
	private String title;

	private String description;

	//@Future
	@NotNull
	private String due;

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
