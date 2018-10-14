package com.dashboard.spring.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the MASTER_ITEM_CATEGORY database table.
 * 
 */
@Entity
@Table(name="MASTER_ITEM_CATEGORY")
@NamedQuery(name="MasterItemCategory.findAll", query="SELECT m FROM MasterItemCategory m")
public class MasterItemCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MASTER_ITEM_CATEGORY_CATEGORYID_GENERATOR", sequenceName="SEQ_MASTERITEMCATEGORY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MASTER_ITEM_CATEGORY_CATEGORYID_GENERATOR")
	@Column(name="CATEGORY_ID")
	private long categoryId;

	@Column(name="CAT_DESCRIPTION")
	private String catDescription;

	@Column(name="CATEGORY_NAME")
	private String categoryName;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	public MasterItemCategory() {
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCatDescription() {
		return this.catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}