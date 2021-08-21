package ralphsliger.rouletteapi.models;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;


@Document(collection = "Roulettes")
public class Roulette {
	@Id
    private String id;
	private Boolean status;
	private List<Bet> bets = new ArrayList<>();
		
	public Roulette() {
	}
	
	public Roulette(String id, Boolean status, List<Bet> bets) {
		super();
		this.id = id;
		this.status = status;
		this.bets = bets;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public List<Bet> getBets() {
		return bets;
	}
	
	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}
	
	

}
