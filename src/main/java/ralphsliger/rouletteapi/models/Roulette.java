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
	private Integer winnerNumber;
		
	public Roulette() {
	}
		
	public Roulette(String id, Boolean status, List<Bet> bets, Integer winnerNumber) {
		this.id = id;
		this.status = status;
		this.bets = bets;
		this.winnerNumber = winnerNumber;
	}

	public Integer getWinnerNumber() {
		return winnerNumber;
	}


	public void setWinnerNumber(Integer winnerNumber) {
		this.winnerNumber = winnerNumber;
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
