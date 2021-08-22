package ralphsliger.rouletteapi.response;

import java.util.ArrayList;
import java.util.HashMap;

public class Response {
	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}

	public void setMetadata(String StatusCode, String message) {
		HashMap<String, String> mapa = new HashMap<>();
		mapa.put("Status Code", StatusCode);
		mapa.put("Message", message);
		metadata.add(mapa);	}
	
	
}
