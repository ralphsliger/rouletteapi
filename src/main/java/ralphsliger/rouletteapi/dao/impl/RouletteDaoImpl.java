package ralphsliger.rouletteapi.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import ralphsliger.rouletteapi.dao.RouletteDao;
import ralphsliger.rouletteapi.models.Roulette;

@Repository
public class RouletteDaoImpl implements RouletteDao {
	@Autowired
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public RouletteDaoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Roulette create(Roulette roulette) {
		return mongoTemplate.save(roulette);
	}

	@Override
	public Roulette findById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return (Roulette) mongoTemplate.find(query, Roulette.class);
	}

	@Override
	public List<Roulette> findAll() {
		return mongoTemplate.findAll(Roulette.class, "Roulettes");
	}

}
