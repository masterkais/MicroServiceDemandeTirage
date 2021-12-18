package com.iit.imprimerie.entities;

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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DemandeTirage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_demande;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date_demande;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date_arrive;
	private int nbr_copie;   //limiter par nbr de classe
	private int type_tirage; // presentielle (reservation place pour turage) ou bien envoie pdf a distant
	private int etat_demande; //1 si la demande et préparé si non 0
//	@JsonIgnore
	@OneToMany(mappedBy = "demande", fetch = FetchType.LAZY)
	private List<Ligne_Demande> lc;
	private int id_ens;
	public DemandeTirage(Date date_demande, Date date_arrive, int nbr_copie, int type_tirage, int etat_demande,
			List<Ligne_Demande> lc, int id_ens) {
		super();
		this.date_demande = date_demande;
		this.date_arrive = date_arrive;
		this.nbr_copie = nbr_copie;
		this.type_tirage = type_tirage;
		this.etat_demande = etat_demande;
		this.lc = lc;
		this.id_ens = id_ens;
	}

	}
