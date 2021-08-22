package ralphsliger.rouletteapi.service;

import org.springframework.http.ResponseEntity;

import ralphsliger.rouletteapi.models.Bet;
import ralphsliger.rouletteapi.response.rest.BetRestResponse;

public interface BetService  {
	
	ResponseEntity<BetRestResponse> create(Bet bet);

}
