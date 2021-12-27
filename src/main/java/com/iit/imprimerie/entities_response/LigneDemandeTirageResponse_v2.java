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
	public class LigneDemandeTirageResponse_v2 implements Serializable {
		
		private int id_ligne;
		private int demande;
		private DocumentResponse doc;
		public LigneDemandeTirageResponse_v2(Ligne_Demande l) {
			this.id_ligne=l.getId();
			
		
		}
}
