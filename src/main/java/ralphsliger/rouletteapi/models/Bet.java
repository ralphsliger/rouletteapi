package ralphsliger.rouletteapi.models;
import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "Bets")
public class Bet implements Serializable{



	@MongoId(targetType = FieldType.OBJECT_ID)
	private String id;
	
	private String status;
	
	@Min(value = 0)
	@Max(value = 36)
	private Integer number;
	
	@Min(value = 0)
	@Max(value = 10000)
	private double moneyInGame;
	
	private double moneyWon;

	private String color;
	
	public Bet() {
	}
	
	public Bet(String id, String status, @Min(0) @Max(36) Integer number, @Min(0) @Max(10000) double moneyInGame,
			double moneyWon, String color) {
		this.id = id;
		this.status = status;
		this.number = number;
		this.moneyInGame = moneyInGame;
		this.moneyWon = moneyWon;
		this.color = color;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getMoneyWon() {
		return moneyWon;
	}

	public void setMoneyWon(double moneyWon) {
		this.moneyWon = moneyWon;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5920114748851637414L;
	

}
