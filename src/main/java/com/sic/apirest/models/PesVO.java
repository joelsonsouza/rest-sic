package com.sic.apirest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pessoapes")
public class PesVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codpes;
	
	@NotNull
	@Column(length=50)
	private String nomepes;
	
	@NotNull
	@Column(length=20)
	private String tipopes;
	
	@NotNull
	@Column(length=1)
	private String sexopes;
	
	@Column(length=15)
	private String telrespes;
	
	@Column(length=15)
	private String celularpes;
	
	@Column(length=150)
	private String enderecopes;
	
	private Integer numendpes;
	
	@Column(length=70)
	private String complpes;
	
	@Column(length=30)
	private String bairropes;

	private Integer ceppes;
	
	@Column(length=30)
	private String cidadepes;
	
	@Column(length=2)
	private String ufpes;
	
	private String emailpes;
	
	@NotNull
	private Boolean ativopes;
	
	
	public Long getCodpes() {
		return codpes;
	}
	public void setCodpes(Long codpes) {
		this.codpes = codpes;
	}
	public String getNomepes() {
		return nomepes;
	}
	public void setNomepes(String nomepes) {
		this.nomepes = nomepes;
	}
	public String getTipopes() {
		return tipopes;
	}
	public void setTipopes(String tipopes) {
		this.tipopes = tipopes;
	}
	public String getSexopes() {
		return sexopes;
	}
	public void setSexopes(String sexopes) {
		this.sexopes = sexopes;
	}
	public String getTelrespes() {
		return telrespes;
	}
	public void setTelrespes(String telrespes) {
		this.telrespes = telrespes;
	}
	public String getCelularpes() {
		return celularpes;
	}
	public void setCelularpes(String celularpes) {
		this.celularpes = celularpes;
	}
	public String getEnderecopes() {
		return enderecopes;
	}
	public void setEnderecopes(String enderecopes) {
		this.enderecopes = enderecopes;
	}
	public Integer getNumendpes() {
		return numendpes;
	}
	public void setNumendpes(Integer numendpes) {
		this.numendpes = numendpes;
	}
	public String getComplpes() {
		return complpes;
	}
	public void setComplpes(String complpes) {
		this.complpes = complpes;
	}
	public String getBairropes() {
		return bairropes;
	}
	public void setBairropes(String bairropes) {
		this.bairropes = bairropes;
	}
	public Integer getCeppes() {
		return ceppes;
	}
	public void setCeppes(Integer ceppes) {
		this.ceppes = ceppes;
	}
	public String getCidadepes() {
		return cidadepes;
	}
	public void setCidadepes(String cidadepes) {
		this.cidadepes = cidadepes;
	}
	public String getUfpes() {
		return ufpes;
	}
	public void setUfpes(String ufpes) {
		this.ufpes = ufpes;
	}
	public String getEmailpes() {
		return emailpes;
	}
	public void setEmailpes(String emailpes) {
		this.emailpes = emailpes;
	}
	public Boolean getAtivopes() {
		return ativopes;
	}
	public void setAtivopes(Boolean ativopes) {
		this.ativopes = ativopes;
	}
	
	
	
}
