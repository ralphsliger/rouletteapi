package ralphsliger.rouletteapi.dao;

import java.util.List;
import ralphsliger.rouletteapi.models.Roulette;

public interface RouletteDao {
	Roulette create(Roulette roulette);

	Roulette findById(String id);

	List<Roulette> findAll();
}
