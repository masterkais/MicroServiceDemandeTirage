package com.iit.imprimerie.entities_response;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.iit.imprimerie.entities.DemandeTirage;
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
public class Ligne_DemandeResponse implements Serializable {
	
	private int id_ligne;
	private DemandeTirageResponse demande;
	private DocumentResponse doc;
	public Ligne_DemandeResponse(Ligne_Demande l) {
		this.id_ligne=l.getId();
		
	
	}
}

