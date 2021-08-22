package ralphsliger.rouletteapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ralphsliger.rouletteapi.dao.impl.BetDaoImpl;
import ralphsliger.rouletteapi.models.Bet;
import ralphsliger.rouletteapi.response.rest.BetRestResponse;
import ralphsliger.rouletteapi.service.BetService;

@Service
public class BetServiceImpl implements BetService {

	@Autowired
	BetDaoImpl repository;

	@Override
	public ResponseEntity<BetRestResponse> create(Bet bet) {
		BetRestResponse response = new BetRestResponse();
		List<Bet> listBets = new ArrayList<>();
		try {
			Bet betToSave = repository.create(bet);
			if(betToSave != null) {
				listBets.add(betToSave);
				response.getBetResponse().setBet(listBets);
				response.setMetadata("201", "Created");
			}else {
				response.setMetadata("204", "No Content");
				return new ResponseEntity<BetRestResponse>(response, HttpStatus.NO_CONTENT);
			}
		
		}catch(Exception e) {
			response.setMetadata("500", e.getMessage());
			return new ResponseEntity<BetRestResponse>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BetRestResponse>(response, HttpStatus.CREATED);
	}

}
