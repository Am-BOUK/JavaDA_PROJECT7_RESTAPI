package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

/**
 * 
 * implementation of business object: Rule Name that will be manipulated by the
 * other layers.
 *
 * the Rule Name has seven attributes : id, name, description, json, template,
 * sqlStr and sqlPart
 */
@Entity
@Table(name = "rulename")
public class RuleName {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 4)
	private Integer id;
	@Column(length = 125)
	private String name;
	@Column(length = 125)
	private String description;
	@Column(length = 125)
	private String json;
	@Column(length = 512)
	private String template;
	@Column(length = 125)
	private String sqlStr;
	@Column(length = 125)
	private String sqlPart;

	public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
		super();
		this.name = name;
		this.description = description;
		this.json = json;
		this.template = template;
		this.sqlStr = sqlStr;
		this.sqlPart = sqlPart;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getSqlStr() {
		return sqlStr;
	}

	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}

	public String getSqlPart() {
		return sqlPart;
	}

	public void setSqlPart(String sqlPart) {
		this.sqlPart = sqlPart;
	}

}
