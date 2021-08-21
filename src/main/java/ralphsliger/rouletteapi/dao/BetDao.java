package ralphsliger.rouletteapi.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import ralphsliger.rouletteapi.models.Bet;

public interface BetDao extends MongoRepository<Bet, String> {

}
