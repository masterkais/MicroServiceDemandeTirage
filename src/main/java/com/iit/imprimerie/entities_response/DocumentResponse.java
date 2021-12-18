package com.iit.imprimerie.entities_response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentResponse implements Serializable {
private int id_document;
private String path;
private String type; //pdf or image or world
@JsonIgnore
private EnseignantResponse ens;
@JsonIgnore
private List<Ligne_DemandeResponse> lignedemande=new ArrayList<Ligne_DemandeResponse>();
@JsonIgnore
private MatiereResponse mat;
/*public DocumentResponse(Document d) {
	super();
	this.id_document = d.getId_document();
	this.path = d.getPath();
	this.type = d.getPath();

}
*/


}
