package ralphsliger.rouletteapi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import ralphsliger.rouletteapi.dao.BetDao;
import ralphsliger.rouletteapi.models.Bet;

@Repository
public class BetDaoImpl implements BetDao {
	
    private final MongoTemplate mongoTemplate;
      
    @Autowired
	public BetDaoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate= mongoTemplate;
	}

	@Override
	public Bet create(Bet bet) {
		return mongoTemplate.save(bet);
	}

}
