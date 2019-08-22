package com.sic.apirest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="objetoobj")
public class ObjVO {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codobj;
	
	@NotNull
	@Column(length=150)
	private String desobj;
	
	@NotNull
	@Column(length=30)
	private String catobj;
	
	@NotNull
	private String oriobj;
	
	@NotNull
	@Column(length=150)
	private String doadorobj;
	
	@NotNull
	@Column(length=20)
	private String sitobj;
	
	@ManyToOne
	@JoinColumn(name = "codpes")
	private PesVO pesVO;
	
	public PesVO getPesVO() {
		return pesVO;
	}
	public void setPesVO(PesVO pesVO) {
		this.pesVO = pesVO;
	}
	public Long getCodobj() {
		return codobj;
	}
	public void setCodobj(Long codobj) {
		this.codobj = codobj;
	}
	public String getDesobj() {
		return desobj;
	}
	public void setDesobj(String desobj) {
		this.desobj = desobj;
	}
	public String getOriobj() {
		return oriobj;
	}
	public void setOriobj(String oriobj) {
		this.oriobj = oriobj;
	}
	public String getDoadorobj() {
		return doadorobj;
	}
	public void setDoadorobj(String doadorobj) {
		this.doadorobj = doadorobj;
	}
	public String getSitobj() {
		return sitobj;
	}
	public void setSitobj(String sitobj) {
		this.sitobj = sitobj;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCatobj() {
		return catobj;
	}
	public void setCatobj(String catobj) {
		this.catobj = catobj;
	}
	
	
}
