package com.iit.imprimerie.entities_response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class DemandeTirageResponse implements Serializable {
	private int id_demande;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date_demande;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date_arrive;
	private int nbr_copie; // limiter par nbr de classe
	private int type_tirage; // presentielle (reservation place pour turage) ou bien envoie pdf a distant
	private int etat_demande; // 1 si la demande et préparé si non 0
	private List<Ligne_DemandeResponse> lc;
	private EnseignantResponse ens;

	public DemandeTirageResponse(DemandeTirage d) {
		this.id_demande = d.getId_demande();
		this.date_demande = d.getDate_demande();
		this.date_arrive = d.getDate_arrive();
		this.nbr_copie = d.getNbr_copie(); // limiter par nbr de classe
		this.type_tirage = d.getType_tirage(); // presentielle (reservation place pour turage) ou bien envoie pdf a
												// distant
		this.etat_demande = d.getEtat_demande(); // 1 si la demande et préparé si non 0
	}

	public DemandeTirageResponse(DemandeTirage d, EnseignantResponse ens) {
		this.id_demande = d.getId_demande();
		this.date_demande = d.getDate_demande();
		this.date_arrive = d.getDate_arrive();
		this.nbr_copie = d.getNbr_copie(); // limiter par nbr de classe
		this.type_tirage = d.getType_tirage(); // presentielle (reservation place pour turage) ou bien envoie pdf a
												// distant
		this.etat_demande = d.getEtat_demande(); // 1 si la demande et préparé si non 0
		this.ens = ens;
	}

	public DemandeTirageResponse(int id) {
		this.id_demande = id;
	}
}
