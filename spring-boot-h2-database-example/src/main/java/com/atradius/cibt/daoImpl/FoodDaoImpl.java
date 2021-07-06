package com.atradius.cibt.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.atradius.cibt.dao.FoodDao;
import com.atradius.cibt.entity.FoodEntity;
import com.atradius.cibt.repository.FoodRepository;

@Component
public class FoodDaoImpl implements FoodDao {

	@Autowired
	private FoodRepository foodRepository;

	
	@Override
	@Cacheable(value = "food", key = "#id")
	public List<FoodEntity> getFoods() {
		return foodRepository.findAll();
	}

	@Override
	public Boolean addFood(FoodEntity food) {
		foodRepository.save(food);
		return true;
	}

	@Override
	public Boolean removeFood(Long foodId) {
		if (foodRepository.existsById(foodId)) {
			foodRepository.deleteById(foodId);
			return true;
		} else {
			return false;
		}
	}
}
