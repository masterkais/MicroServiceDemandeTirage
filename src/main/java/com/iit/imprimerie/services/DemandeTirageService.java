package com.iit.imprimerie.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.DemandeTirageDao;
import com.iit.imprimerie.dao.LigneDemandeDao;
import com.iit.imprimerie.entities.DemandeTirage;
import com.iit.imprimerie.entities.Ligne_Demande;
import com.iit.imprimerie.entities_response.DemandeTirageResponse;
import com.iit.imprimerie.entities_response.DocumentResponse;
import com.iit.imprimerie.entities_response.EnseignantResponse;
import com.iit.imprimerie.entities_response.Ligne_DemandeResponse;
import com.iit.imprimerie.exception.NoException;
import com.iit.imprimerie.exception.NotFoundException;
import com.iit.imprimerie.proxies.MicroServiceDocumentProxy;
import com.iit.imprimerie.proxies.MicroServiceEnseignantProxy;

@Service
public class DemandeTirageService {
	@Autowired
	DemandeTirageDao dto;
	@Autowired
	MicroServiceDocumentProxy md;
	@Autowired
	MicroServiceEnseignantProxy me;
	@Autowired
	LigneDemandeDao ldo;

	public void AjouterNDemandeTirage(DemandeTirage m) {
		m.setEtat_demande(0);
		// verif ens exise ou non
		EnseignantResponse e = getEnsById(m.getId_ens());
		dto.saveAndFlush(m);
		List<Ligne_Demande> l = m.getLc();
		for (int i = 0; i < l.size(); i++) {
			// verif Doc existe ou non
			DocumentResponse g = getDocById(l.get(i).getId_document());

			l.get(i).setDemande(m);

			AjouterLigneDemande(l.get(i));

		}
	}

	public void AjouterLigneDemande(Ligne_Demande l) {
		// verif document existe ou non
		DocumentResponse d = getDocById(l.getId_document());
		DemandeTirage dd = getDemandeById(l.getDemande().getId_demande());
		l.setDemande(dd);
		ldo.saveAndFlush(l);
		throw new NoException("demande tirage est passée avec succée ");
	}

	public void verifDocEtAjoutLigneC(List<Ligne_Demande> ld) {
		for (int i = 0; i < ld.size(); i++) {
			Ligne_DemandeResponse d = new Ligne_DemandeResponse(ld.get(i));

			d.setDemande(getDemandeTirage(ld.get(i).getId()));
			d.setDoc(getDocById(ld.get(i).getId_document()));

			ldo.saveAndFlush(ld.get(i));
		}
	}

	public void supprimerDemandeTirage(int id) {

		try {
			dto.deleteById(id);
			throw new NoException("suppression avec succée");
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod demande with the id " + id + " was found in daabase ");

		}
	}

	public void modifierDemandeTirage(DemandeTirage m) {
		// verif ens exise ou non
		EnseignantResponse e = getEnsById(m.getId_ens());
		dto.saveAndFlush(m);
		List<Ligne_Demande> l = m.getLc();
		for (int i = 0; i < l.size(); i++) {
			// verif Doc existe ou non
			DocumentResponse g = getDocById(l.get(i).getId_document());

			l.get(i).setDemande(m);

			AjouterLigneDemande(l.get(i));

		}
		throw new NoException("modifaction objet demande  avec succée");
	}

	public DemandeTirageResponse getDemandeTirage(int id) {
		// verif m existe ou non
		DemandeTirage m = getDemandeById(id);
		DemandeTirageResponse mm = new DemandeTirageResponse(m);
		EnseignantResponse e = getEnsById(m.getId_ens());
		List<Ligne_DemandeResponse> d = getLdByIdDemande(mm.getId_demande());
		mm.setEns(e);
		mm.setLc(d);
		return mm;

	}

	public List<DemandeTirageResponse> getAllDemandeTirage() {
		List<DemandeTirage> l = dto.findAll();
		List<DemandeTirageResponse> ld = new ArrayList<DemandeTirageResponse>();
		for (int i = 0; i < l.size(); i++) {
			DemandeTirageResponse d = new DemandeTirageResponse(l.get(i));
			d.setEns(getEnsById(l.get(i).getId_ens()));
			List<Ligne_DemandeResponse> mm = getLdByIdDemande(l.get(i).getId_demande());
			d.setLc(mm);
			ld.add(d);
		}
		return ld;
	}

	public List<Ligne_DemandeResponse> getAllLigneDemandeTirage() {
		List<Ligne_Demande> l = ldo.findAll();
		List<Ligne_DemandeResponse> ll = new ArrayList<Ligne_DemandeResponse>();
		for (int i = 0; i < l.size(); i++) {
			Ligne_DemandeResponse lll = new Ligne_DemandeResponse(l.get(i));
			lll.setDemande(getDemandeRById(l.get(i).getDemande().getId_demande()));
			lll.setDoc(getDocById(l.get(i).getId_document()));
			ll.add(lll);
		}

		return ll;
	}

	public List<DemandeTirageResponse> getDemandeTirageByDateArrive(String date) throws ParseException {
		
		List<DemandeTirage> l = dto.getDemandeTirageByDateArriveNative(date);
		List<DemandeTirageResponse> ld = new ArrayList<DemandeTirageResponse>();
		for (int i = 0; i < l.size(); i++) {
			DemandeTirageResponse d = new DemandeTirageResponse(l.get(i));
			d.setEns(getEnsById(l.get(i).getId_ens()));
			List<Ligne_DemandeResponse> mm = getLdByIdDemande(l.get(i).getId_demande());

			d.setLc(mm);
			ld.add(d);
		}
		return ld;
	}
	
	public List<DemandeTirageResponse> getDemandeTirageByDateArriveNative(String date)  {
		List<DemandeTirage> l = dto.getDemandeTirageByDateArriveNative(date);
		List<DemandeTirageResponse> ld = new ArrayList<DemandeTirageResponse>();
		for (int i = 0; i < l.size(); i++) {
			DemandeTirageResponse d = new DemandeTirageResponse(l.get(i));
			d.setEns(getEnsById(l.get(i).getId_ens()));
			List<Ligne_DemandeResponse> mm = getLdByIdDemande(l.get(i).getId_demande());

			d.setLc(mm);
			ld.add(d);
		}
		return ld;
	}
	

	public List<DemandeTirageResponse> getDemandeTirageByDateDemande(String date) {

		List<DemandeTirage> l = dto.getDemandeTirageByDateDemandeNative(date);
		List<DemandeTirageResponse> ld = new ArrayList<DemandeTirageResponse>();
		for (int i = 0; i < l.size(); i++) {
			DemandeTirageResponse d = new DemandeTirageResponse(l.get(i));
			d.setEns(getEnsById(l.get(i).getId_ens()));
			List<Ligne_DemandeResponse> mm = getLdByIdDemande(l.get(i).getId_demande());

			d.setLc(mm);
			ld.add(d);
		}
		return ld;
	}

	public List<DemandeTirageResponse> getDemandeTirageByEns(int id) {
		// verif ens exist
		EnseignantResponse ee = getEnsById(id);
		List<DemandeTirage> l = dto.getDemandeTirageByEnsignant(id);
		List<DemandeTirageResponse> ld = new ArrayList<DemandeTirageResponse>();
		for (int i = 0; i < l.size(); i++) {
			DemandeTirageResponse d = new DemandeTirageResponse(l.get(i));
			d.setEns(getEnsById(id));
			List<Ligne_DemandeResponse> mm = getLdByIdDemande(l.get(i).getId_demande());

			d.setLc(mm);
			ld.add(d);
		}
		return ld;
	}

	public EnseignantResponse getEnsById(int id) {

		try {

			return me.getEnsById(id);
		} catch (Exception e) {
			throw new NotFoundException("l'objet enseignant avec id =" + id + " not found");
		}
	}

	public DocumentResponse getDocById(int id) {

		try {

			return md.getDocById(id);
		} catch (Exception e) {
			throw new NotFoundException("l'objet document avec id =" + id + " not found");
		}

	}

	public DemandeTirageResponse getDemandeRById(int id) {
		DemandeTirageResponse r = new DemandeTirageResponse(getDemandeById(id));
		DemandeTirage d = getDemandeById(id);
		List<Ligne_DemandeResponse> ll = getLdByIdDemande(id);
		r.setLc(ll);
		EnseignantResponse ee = getEnsById(d.getId_ens());
		r.setEns(ee);
		return r;
	}

	public List<Ligne_DemandeResponse> getLdByIdDemande(int id) {
		List<Ligne_Demande> ls = ldo.getLdByIdDemande(id);
		List<Ligne_DemandeResponse> lsd = new ArrayList<Ligne_DemandeResponse>();
		for (int i = 0; i < ls.size(); i++) {
			Ligne_Demande l = ls.get(i);
			Ligne_DemandeResponse ll = new Ligne_DemandeResponse(l);
			EnseignantResponse ee = getEnsById(getDemandeById(id).getId_ens());
			DemandeTirageResponse r = new DemandeTirageResponse(getDemandeById(id), ee);
			ll.setDemande(r);
			// verif doc exist
			ll.setDoc(getDocById(l.getId_document()));
			lsd.add(ll);
		}
		return lsd;
	}

	public DemandeTirage getDemandeById(int id) {
		try {
			return dto.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod demande with the id" + id + " was found in database ");
		}
	}

	public Ligne_DemandeResponse getLigneDemandeById(int id) {
		Ligne_Demande l = ldo.findById(id).get();
		Ligne_DemandeResponse ll = new Ligne_DemandeResponse(l);
		DemandeTirageResponse dd = getDemandeRById(l.getDemande().getId_demande());
		ll.setDemande(dd);
		ll.setDoc(getDocById(l.getId_document()));

		return ll;
	}
	
	public List<DemandeTirageResponse> getDemandeTirageParSontEtat(int etat) {
		List<DemandeTirage> l = dto.getDemandeTirageParEtat(etat);
		List<DemandeTirageResponse> ld = new ArrayList<DemandeTirageResponse>();
		for (int i = 0; i < l.size(); i++) {
			DemandeTirageResponse d = new DemandeTirageResponse(l.get(i));
			d.setEns(getEnsById(l.get(i).getId_ens()));
			List<Ligne_DemandeResponse> mm = getLdByIdDemande(l.get(i).getId_demande());

			d.setLc(mm);
			ld.add(d);
		}
		if (ld==null) throw new  NotFoundException("la liste de demande tirage est vide ");
		return ld;
	}

	public void RealiserDemande(int id) {
		// TODO Auto-generated method stub
		DemandeTirage d=getDemandeById(id);
		d.setEtat_demande(1);
		dto.saveAndFlush(d);
	}



	
	
	

}
