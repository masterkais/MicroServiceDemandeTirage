package com.iit.imprimerie.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.iit.imprimerie.entities_response.EnseignantResponse;
import com.iit.imprimerie.entities_response.MatiereResponse;

@FeignClient(name = "service-administration", url = "localhost:8081")
public interface MicroServiceEnseignantProxy {
	@GetMapping("/Enseignant/{id}")
	public EnseignantResponse getEnsById(@PathVariable int id);
	@GetMapping("/Matiere/{id}")
	public MatiereResponse getMatById(@PathVariable int id);
	}

