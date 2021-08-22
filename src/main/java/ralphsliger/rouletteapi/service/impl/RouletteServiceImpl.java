package ralphsliger.rouletteapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ralphsliger.rouletteapi.dao.impl.RouletteDaoImpl;
import ralphsliger.rouletteapi.models.Roulette;
import ralphsliger.rouletteapi.response.rest.RouletteRestResponse;
import ralphsliger.rouletteapi.service.RouletteService;

@Service
public class RouletteServiceImpl implements RouletteService {

	@Autowired
	RouletteDaoImpl repository;

	@Override
	public ResponseEntity<RouletteRestResponse> findAll() {
		RouletteRestResponse response = new RouletteRestResponse();
		try {
			List<Roulette> roulettes = (List<Roulette>) repository.findAll();
			response.getRouletteResponse().setRoulette(roulettes);
			response.setMetadata("200", "OK");
		} catch (Exception e) {
			response.setMetadata("500", e.getMessage());
			return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<RouletteRestResponse> findById(String id) {
		RouletteRestResponse response = new RouletteRestResponse();
		List<Roulette> roulettes = new ArrayList<>();
		try {
			Roulette rouletteToFind = repository.findById(id);
			if(rouletteToFind!= null) {
				roulettes.add(rouletteToFind);
				response.getRouletteResponse().setRoulette(roulettes);
				response.setMetadata("200","OK");
			}
		} catch (Exception e) {
			response.setMetadata("500", e.getMessage());
			return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RouletteRestResponse> create(Roulette roulette) {
		RouletteRestResponse response = new RouletteRestResponse();
		List<Roulette> roulettes = new ArrayList<>();
		try {
			Roulette roulleteToSave = repository.create(roulette);
			if(roulleteToSave != null) {
				roulettes.add(roulleteToSave);
				response.getRouletteResponse().setRoulette(roulettes);
				response.setMetadata("201","Created "+ "El codigo de la ruleta es: " + roulleteToSave.getId());
			}else {
				response.setMetadata("204", "No Content");
				return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			response.setMetadata("500", e.getMessage());
			return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.CREATED);
	}

}
