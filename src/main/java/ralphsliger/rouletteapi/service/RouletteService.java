package ralphsliger.rouletteapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ralphsliger.rouletteapi.models.Bet;
import ralphsliger.rouletteapi.models.Roulette;
import ralphsliger.rouletteapi.response.rest.RouletteRestResponse;

public interface RouletteService {
	
	ResponseEntity<RouletteRestResponse> findAll();
	ResponseEntity<RouletteRestResponse> findById(String id);
	ResponseEntity<RouletteRestResponse> create(Roulette roulette);
	ResponseEntity<RouletteRestResponse> openup(String id);
	ResponseEntity<RouletteRestResponse> betting(String id, Bet bet);
	ResponseEntity<RouletteRestResponse> close(String id);
	List<Bet> winningbets(String id);
	
	
}


