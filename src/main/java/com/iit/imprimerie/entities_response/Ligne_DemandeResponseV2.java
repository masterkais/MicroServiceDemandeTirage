package com.iit.imprimerie.entities_response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.iit.imprimerie.entities.Ligne_Demande;

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
public class Ligne_DemandeResponseV2 implements Serializable {
	private int id_ligne;
	private int id_demande;
	private DocumentResponse doc;
	public Ligne_DemandeResponseV2(Ligne_Demande l) {
		this.id_ligne=l.getId();
		this.id_demande=l.getDemande().getId_demande();
	}
	
	public Ligne_DemandeResponseV2(int id) {
		super();
		this.id_ligne = id;
	
	}
	
	
	
}

