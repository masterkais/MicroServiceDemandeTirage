package com.iit.imprimerie.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.iit.imprimerie.entities_response.DocumentResponse;
import com.iit.imprimerie.entities_response.EnseignantResponse;

@FeignClient(name = "microservice-document")
//supprimer l ',url="http://localhost:9994"
@RibbonClient(name = "microservice-document")
public interface MicroServiceDocumentProxy {
	@GetMapping("/Document/{id}")
	public DocumentResponse getDocById(@PathVariable int id);
	}

