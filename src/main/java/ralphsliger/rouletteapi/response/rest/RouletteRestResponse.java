package ralphsliger.rouletteapi.response.rest;

import ralphsliger.rouletteapi.response.Response;
import ralphsliger.rouletteapi.response.RouletteResponse;

public class RouletteRestResponse extends Response {
	private RouletteResponse rouletteResponse = new RouletteResponse();

	public RouletteResponse getRouletteResponse() {
		return rouletteResponse;
	}

	public void setRouletteResponse(RouletteResponse rouletteResponse) {
		this.rouletteResponse = rouletteResponse;
	}
	

}
