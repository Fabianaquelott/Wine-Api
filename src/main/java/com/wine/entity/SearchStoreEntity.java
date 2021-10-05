package com.wine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="CEP")
public class SearchStoreEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "CODIGO_LOJA")
	private String storeId;
	
	@Column(name = "FAIXA_INICIO", unique = true)
	private Integer initialZipCode;

	@Column(name = "FAIXA_FIM", unique = true)
	private Integer finalZipCode;
}
