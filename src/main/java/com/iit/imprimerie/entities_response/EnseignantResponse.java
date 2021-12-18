package com.iit.imprimerie.entities_response;

import java.io.Serializable;
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
import javax.persistence.OneToOne;

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
public class EnseignantResponse implements Serializable {
private int id;
private String cin;
private String prenom;
private String nom;
private String adress;
private String email;
private String phone;
private String login;
private String password;
@JsonIgnore
private List<MatiereResponse> lm;
@JsonIgnore
private List<DemandeTirageResponse> ld;
@JsonIgnore
private DepartementResponse dep;
@JsonIgnore
private List<DocumentResponse> ldoc;


}
