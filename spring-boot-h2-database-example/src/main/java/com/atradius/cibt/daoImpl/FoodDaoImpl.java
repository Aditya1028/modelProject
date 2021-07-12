package com.atradius.cibt.daoImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atradius.cibt.dao.FoodDao;
import com.atradius.cibt.entity.FoodEntity;
import com.atradius.cibt.repository.FoodRepository;

@Component
public class FoodDaoImpl implements FoodDao {

	@Autowired
	private FoodRepository foodRepository;

	private static final Logger LOGGER = LogManager.getLogger(FoodDaoImpl.class);
	
	@Override
	public List<FoodEntity> getFoods() {
		LOGGER.info("Inside getFoods Dao");
		return foodRepository.findAll();	
	}

	@Override
	public Boolean addFood(FoodEntity food) {
		LOGGER.info("Inside addFood Dao");
		foodRepository.save(food);
		return true;
	}

	@Override
	public Boolean removeFood(Long foodId) {
		LOGGER.info("Inside removeFood Dao");
		if (foodRepository.existsById(foodId)) {
			foodRepository.deleteById(foodId);
			return true;
		} else {
			return false;
		}
	}
}
