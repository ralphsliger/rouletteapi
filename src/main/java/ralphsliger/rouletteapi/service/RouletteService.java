package ralphsliger.rouletteapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import ralphsliger.rouletteapi.models.Roulette;
import ralphsliger.rouletteapi.response.rest.RouletteRestResponse;

public interface RouletteService {
	
	ResponseEntity<RouletteRestResponse> findAll();
	ResponseEntity<RouletteRestResponse> findById(String id);
	ResponseEntity<RouletteRestResponse> create(Roulette roulette);
	
	
	
}


