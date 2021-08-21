package ralphsliger.rouletteapi.models;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Bets")
public class Bet {

	@Id
	private String id;
	
	private String Type;
	
	@Min(value = 0)
	@Max(value = 36)
	private int number;
	
	@Min(value = 0)
	@Max(value = 10000)
	private double moneyInGame;

	private String color;
	
	public Bet() {
	}

	public Bet(String id, String type, @Min(0) @Max(36) int number, @Min(0) @Max(10000) double moneyInGame,
			String color) {
		this.id = id;
		Type = type;
		this.number = number;
		this.moneyInGame = moneyInGame;
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getMoneyInGame() {
		return moneyInGame;
	}

	public void setMoneyInGame(double moneyInGame) {
		this.moneyInGame = moneyInGame;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
