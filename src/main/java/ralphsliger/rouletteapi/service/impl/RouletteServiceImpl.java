package ralphsliger.rouletteapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ralphsliger.rouletteapi.dao.RouletteRepository;
import ralphsliger.rouletteapi.dao.impl.BetDaoImpl;
import ralphsliger.rouletteapi.dao.impl.RouletteDaoImpl;
import ralphsliger.rouletteapi.models.Bet;
import ralphsliger.rouletteapi.models.Roulette;
import ralphsliger.rouletteapi.response.rest.RouletteRestResponse;
import ralphsliger.rouletteapi.service.RouletteService;

@Service
public class RouletteServiceImpl implements RouletteService {

	@Autowired
	RouletteDaoImpl repository;
	@Autowired
	BetDaoImpl betRepository;
	@Autowired
	RouletteRepository rRepository;

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
			Optional<Roulette> rouletteToFind = rRepository.findById(id);
			if (rouletteToFind.isPresent()) {
				roulettes.add(rouletteToFind.get());
				response.getRouletteResponse().setRoulette(roulettes);
				response.setMetadata("200", "OK");
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
			if (roulleteToSave != null) {
				roulettes.add(roulleteToSave);
				response.getRouletteResponse().setRoulette(roulettes);
				response.setMetadata("201", "Created " + "El codigo de la ruleta es: " + roulleteToSave.getId());
			} else {
				response.setMetadata("204", "No Content");
				return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			response.setMetadata("500", e.getMessage());
			return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<RouletteRestResponse> openup(String id) {
		RouletteRestResponse response = new RouletteRestResponse();
		List<Roulette> roulettes = new ArrayList<>();
		try {
			Optional<Roulette> rouletteToFind = rRepository.findById(id);
			if (rouletteToFind.isPresent()) {
				rouletteToFind.get().setStatus(true);
				repository.create(rouletteToFind.get());
				roulettes.add(rouletteToFind.get());
				response.getRouletteResponse().setRoulette(roulettes);
				response.setMetadata("201",
						"Created " + "Roulette with code: " + rouletteToFind.get().getId() + " has been initialized");

			} else {
				response.setMetadata("204", "No Content");
				return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			response.setMetadata("500", e.getMessage());
			return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<RouletteRestResponse> betting(String id, Bet bet) {
		RouletteRestResponse response = new RouletteRestResponse();
		List<Roulette> roulettes = new ArrayList<>();
		Optional<Roulette> rouletteToFind = rRepository.findById(id);
		try {
			if (rouletteToFind.isPresent()) {
				Bet betToCreate = betRepository.create(bet);
				rouletteToFind.get().getBets().add(betToCreate);
				repository.create(rouletteToFind.get());
				roulettes.add(rouletteToFind.get());
				response.getRouletteResponse().setRoulette(roulettes);
				response.setMetadata("201",
						"Created " + "A Bet has been created in Roulette with code: " + rouletteToFind.get().getId());

			} else {
				response.setMetadata("405", "Method Not Allowed " + "Sorry, This roullete is closed at this moment. "
						+ rouletteToFind.get().getId());
				return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.METHOD_NOT_ALLOWED);
			}
		} catch (Exception e) {
			response.setMetadata("500", e.getMessage());
			return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<RouletteRestResponse> close(String id) {
		RouletteRestResponse response = new RouletteRestResponse();
		List<Roulette> roulettes = new ArrayList<>();
		Optional<Roulette> rouletteToFind = rRepository.findById(id);
		try {
			if (rouletteToFind.isPresent()) {
				if (rouletteToFind.get().getStatus().equals(true)) {
					rouletteToFind.get().setStatus(false);
					List<Bet> bets = winningbets(id);
					rouletteToFind.get().setBets(bets);
					roulettes.add(rouletteToFind.get());
					response.getRouletteResponse().setRoulette(roulettes);
					response.setMetadata("200",
							"OK " + "Roulette with" + rouletteToFind.get().getId() + "has been closed");
				} else {
					response.setMetadata("204", "No Content");
					return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.NO_CONTENT);
				}
			}
		} catch (Exception e) {
			response.setMetadata("500", e.getMessage());
			return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<RouletteRestResponse>(response, HttpStatus.OK);
	}

	@Override
	public List<Bet> winningbets(String id) {
		Optional<Roulette> rouletteToFind = rRepository.findById(id);
		Random random = new Random(System.currentTimeMillis());
		Integer WinnnerNumber = random.nextInt(36);
		rouletteToFind.get().setWinnerNumber(WinnnerNumber);
		Boolean match = false;
		String betWinnerId = null;
		if (rouletteToFind.isPresent()) {
			for (Bet bet : rouletteToFind.get().getBets()) {
				if (bet.getNumber() != null) {
					if (bet.getNumber() == rouletteToFind.get().getWinnerNumber()) {
						bet.setMoneyWon(bet.getMoneyWon() * 5);
						bet.setMoneyInGame(0);
						bet.setStatus("winner");
						betWinnerId = bet.getId();
						match = true;
						break;
					} else {
						if (rouletteToFind.get().getWinnerNumber() % 2 == 0) {
							if (bet.getColor() != null) {
								if (bet.getColor().contains("R")) {
									bet.setMoneyWon(bet.getMoneyInGame() * 1.8);
									bet.setStatus("winner");
									bet.setMoneyInGame(0);
								} else {
									bet.setMoneyWon(0);
									bet.setStatus("defeated");
									bet.setMoneyInGame(0);
								}
							}
						} else if (rouletteToFind.get().getWinnerNumber() % 2 != 0) {
							if (bet.getColor() != null) {
								if (bet.getColor().contains("B")) {
									bet.setMoneyWon(bet.getMoneyInGame() * 1.8);
									bet.setStatus("winner");
									bet.setMoneyInGame(0);

								} else {
									bet.setMoneyWon(0);
									bet.setStatus("defeated");
									bet.setMoneyInGame(0);

								}
							}
						}
					}

				}
			}
		}
		if (match == true) {
			for (Bet b : rouletteToFind.get().getBets()) {
				if (!b.getId().equals(betWinnerId)) {
					b.setMoneyInGame(0);
					b.setMoneyWon(0);
					b.setStatus("defeated");
				}
			}
		}
		return rouletteToFind.get().getBets();
	}
}
