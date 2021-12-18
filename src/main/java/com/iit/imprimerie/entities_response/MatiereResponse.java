package com.iit.imprimerie.entities_response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MatiereResponse implements Serializable {
	private int id_mat;
	private String lib;

	@JsonIgnore
	private EnseignantResponse ens;
	@JsonIgnore
	private NiveauResponse niv;
	@JsonIgnore
	private DepartementResponse dep;
	@JsonIgnore
	private List<DocumentResponse> docs = new ArrayList<DocumentResponse>();

}
