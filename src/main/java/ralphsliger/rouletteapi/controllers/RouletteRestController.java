package ralphsliger.rouletteapi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ralphsliger.rouletteapi.models.Bet;
import ralphsliger.rouletteapi.models.Roulette;
import ralphsliger.rouletteapi.response.rest.RouletteRestResponse;
import ralphsliger.rouletteapi.service.impl.RouletteServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class RouletteRestController {

	@Autowired
	private RouletteServiceImpl service;

	@PostMapping("/roulettes")
	public ResponseEntity<RouletteRestResponse> create() {
		ResponseEntity<RouletteRestResponse> response = service.create(new Roulette());
		return response;
	}

	@PutMapping("/roulettes/{id}/openup")
	public ResponseEntity<RouletteRestResponse> openup(@PathVariable(value = "id") String id) {
		ResponseEntity<RouletteRestResponse> response = service.openup(id);
		return response;
	}

	@PostMapping("/roulettes/{id}/bet")
	public ResponseEntity<RouletteRestResponse> betting(@PathVariable(value = "id") String id, @RequestBody Bet bet,
			@RequestHeader(value = "userId") String userId) {
		ResponseEntity<RouletteRestResponse> response = service.betting(id, bet);
		return response;
	}

	@PutMapping("roulettes/{id}/close")
	public ResponseEntity<RouletteRestResponse> close(@PathVariable(value = "id") String id) {
		ResponseEntity<RouletteRestResponse> response = service.close(id);
		return response;
	}

	@GetMapping("/roulettes")
	public ResponseEntity<RouletteRestResponse> findAll() {
		ResponseEntity<RouletteRestResponse> response = service.findAll();
		return response;

	}
	
	@GetMapping("/roulettes/{id}")
	public ResponseEntity<RouletteRestResponse> findById(@PathVariable(value = "id") String id) {
		ResponseEntity<RouletteRestResponse> response = service.findById(id);
		return response;
	}
	

}






