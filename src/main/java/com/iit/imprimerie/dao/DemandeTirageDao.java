package com.iit.imprimerie.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iit.imprimerie.entities.DemandeTirage;

import feign.Param;

@Repository
public interface DemandeTirageDao extends JpaRepository<DemandeTirage, Integer> {
	@Query("SELECT u FROM DemandeTirage u WHERE u.id_ens = :id")
	public List<DemandeTirage> getDemandeTirageByEnsignant(@Param("id") int id);

	@Query("SELECT u FROM DemandeTirage u WHERE u.date_demande = :date")
	public List<DemandeTirage> getDemandeTirageByDateDemande(@PathParam("date") Date date);

	@Query("SELECT u FROM DemandeTirage u WHERE u.date_arrive = :date")
	public List<DemandeTirage> getDemandeTirageByDateArrive(@PathParam("date") Date date);

	@Query(value = "SELECT u FROM DemandeTirage u WHERE u.etat_demande = :etat")
	public List<DemandeTirage> getDemandeTirageParEtat(@PathParam("etat") int etat);
	
	@Query(value = "SELECT * FROM demande_tirage WHERE Date(date_arrive) = :date", nativeQuery = true)
	public List<DemandeTirage> getDemandeTirageByDateArriveNative(@PathParam("date") String date);
	
	@Query(value = "SELECT * FROM demande_tirage WHERE Date(date_demande) = :date", nativeQuery = true)
	public List<DemandeTirage> getDemandeTirageByDateDemandeNative(@PathParam("date") String date);

}
