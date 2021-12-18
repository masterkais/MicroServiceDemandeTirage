package com.iit.imprimerie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iit.imprimerie.entities.Ligne_Demande;
import com.iit.imprimerie.entities_response.Ligne_DemandeResponse;

@Repository
public interface LigneDemandeDao extends JpaRepository <Ligne_Demande, Integer>{
	@Query(value = "SELECT * FROM ligne_demande u WHERE u.id_demande = :id", nativeQuery = true)
	public List<Ligne_Demande> getLdByIdDemande(@Param("id") int id);
}
