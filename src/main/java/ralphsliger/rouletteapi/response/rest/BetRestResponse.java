package ralphsliger.rouletteapi.response.rest;

import ralphsliger.rouletteapi.response.BetResponse;
import ralphsliger.rouletteapi.response.Response;

public class BetRestResponse extends Response {

	BetResponse betResponse = new BetResponse();

	public BetResponse getBetResponse() {
		return betResponse;
	}

	public void setBetResponse(BetResponse betResponse) {
		this.betResponse = betResponse;
	}

	public void setMetadata(String statusCode, String message) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
