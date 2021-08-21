package ralphsliger.rouletteapi.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import ralphsliger.rouletteapi.models.Roulette;

public interface RouletteDao extends MongoRepository<String, Roulette>{

}
