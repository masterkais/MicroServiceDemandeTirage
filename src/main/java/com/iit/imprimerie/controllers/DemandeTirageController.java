package com.iit.imprimerie.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iit.imprimerie.entities.DemandeTirage;
import com.iit.imprimerie.entities.Ligne_Demande;
import com.iit.imprimerie.entities_response.DemandeTirageResponse;
import com.iit.imprimerie.entities_response.Ligne_DemandeResponse;
import com.iit.imprimerie.services.DemandeTirageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("ApiDemandeTirage")
public class DemandeTirageController {
	@Autowired
	DemandeTirageService dto;

	@ApiOperation(value = "passer demande", notes = "cette methode permet au enseignant de passer une demande de tirage ", response = DemandeTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet demande est ajouter"),
			@ApiResponse(code = 400, message = "l'objet demande n'est pas valide") })
	@PostMapping("/DemandeTirage")
	public void AjouterNDemandeTirage(@RequestBody DemandeTirage m) {
		dto.AjouterNDemandeTirage(m);
	}

	@ApiOperation(value = "Ajouter ligne demande", notes = "cette methode permet d'ajouter ligne demande ", response = Ligne_Demande.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet ligne est ajouter"),
			@ApiResponse(code = 400, message = "l'objet ligne n'est pas valide") })
	@PostMapping("/LigneDemandeTirage")
	public void AjouterLigneDemande(@RequestBody Ligne_Demande l) {
		dto.AjouterLigneDemande(l);
	}

	@ApiOperation(value = "supprimer demande", notes = "cette methode permet de supprimer un objet par son id qui existe dans le base de donnée", response = DemandeTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est supprimer"),
			@ApiResponse(code = 204, message = "l'objet est supprimer avec sucée"),
			@ApiResponse(code = 401, message = "requée necessite le client doit identifier"),
			@ApiResponse(code = 403, message = "le serveur n'est pas autorisé pour cette requéte") })

	@DeleteMapping("/DemandeTirage/{id}")
	public void supprimerDemandeTirage(@PathVariable int id) {
		dto.supprimerDemandeTirage(id);
	}

	@ApiOperation(value = "Modifier objet demande", notes = "cette methode permet de modifier un objet demande ", response = DemandeTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est modifer "),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PutMapping("/DemandeTirage")
	public void modifierDemandeTirage(@RequestBody DemandeTirage m) {
		dto.modifierDemandeTirage(m);
	}

	@ApiOperation(value = "chercher un objet demande ", notes = "cette methode permet de chercher un objet demande par son id qui existe dans le base de donnée", response = DemandeTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est trouvée"),
			@ApiResponse(code = 404, message = "aucun objet existe dans la base avec ce id"),
			@ApiResponse(code = 500, message = "aucun objet existe dans la base de donnée avec ce id") })
	@GetMapping("/DemandeTirage/{id}")
	public DemandeTirageResponse getDemandeTirage(@PathVariable int id) {
		DemandeTirageResponse m = dto.getDemandeTirage(id);
		return m;
	}

	@ApiOperation(value = "renvoie la liste des objets demandes", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/GetAllDemandeTirage")
	public List<DemandeTirageResponse> getAllDemandeTirage() {
		return dto.getAllDemandeTirage();
	}

	@ApiOperation(value = "renvoie la liste de tous les ligne demande", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/GetAllLigneDemandeTirage")
	public List<Ligne_DemandeResponse> getAllLigneDemandeTirage() {
		return dto.getAllLigneDemandeTirage();
	}

	

	@ApiOperation(value = "renvoie la liste des objets par date arriver exemple: localhost:8084/DemandeTirageByDAN?date=2022/12/17", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/DemandeTirageByDA")
	public List<DemandeTirageResponse> getDemandeTirageByDateArriveNative(@RequestParam Date date) throws ParseException  {
		System.out.println("getDemandeTirageByDateArriveNative controller date = "+date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String s=sdf.format(date);
		return dto.getDemandeTirageByDateArriveNative(s);
	}
	
	@ApiOperation(value = "renvoie la liste des objets par date demande localhost:8084/DemandeTirageByDD?date=2022/12/17", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/DemandeTirageByDD")
	public List<DemandeTirageResponse> getDemandeTirageByDateDemande(@RequestParam Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String s=sdf.format(date);
		return dto.getDemandeTirageByDateDemande(s);
	}

	

	@ApiOperation(value = "renvoie la liste des demande avec son etat ", notes = "cette methode permet de renvoyer la liste des demande realisé qui existe dans le base de donnée : '0'=>non realiser '1'=>realise", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/DemandeTirageEtat/{etat}")
	public List<DemandeTirageResponse> getDemandeTirageParSontEtat(@PathVariable int etat) {
		return dto.getDemandeTirageParSontEtat(etat);
	}

	@ApiOperation(value = "renvoie la liste des objets par enseignant", notes = "cette methode permet de renvoyer la liste des demande par id enseignant qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/DemandeTirageByEns/{id}")
	public List<DemandeTirageResponse> getDemandeTirageByEns(@PathVariable int id) {
		return dto.getDemandeTirageByEns(id);
	}

	@ApiOperation(value = "renvoie ligne demande par sont id", notes = "cette methode permet de renvoyer ligne demande qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ligne demande / une liste vide"), })
	@GetMapping("/LigneDemandeTirage/{id}")
	public Ligne_DemandeResponse getLigneDemandeById(@PathVariable int id) {
		return dto.getLigneDemandeById(id);
	}
	
	@ApiOperation(value = "Realiser demande", notes = "cette methode permet au agent imprimerie de realiser une demande de tirage", response = DemandeTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "demande a eté realisé avec sucée"), })
	@PostMapping("/RealiserDemande/{id}")
	public void RealiserDemande(@PathVariable int id) {
		dto.RealiserDemande(id);
	}

}
