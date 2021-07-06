package com.atradius.cibt.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atradius.cibt.dao.FoodDao;
import com.atradius.cibt.entity.FoodEntity;
import com.atradius.cibt.model.Food;
import com.atradius.cibt.service.FoodManagementService;
import com.google.common.reflect.TypeToken;

@Component
public class FoodManagementServiceImpl implements FoodManagementService {


	 private static final Logger LOGGER = LogManager.getLogger(FoodManagementServiceImpl.class); 
	 
	 @Autowired
	 FoodDao foodDao;
	
	@Override
	public Boolean addFood(Food food) {
		ModelMapper mapper = new ModelMapper();
		FoodEntity foodEntity = mapper.map(food, FoodEntity.class);
		Boolean result = foodDao.addFood(foodEntity);
		return result;
	}
	
	@Override
	public List<Food> getFoods() {
		LOGGER.info("Inside getFoods method");
		ModelMapper mapper = new ModelMapper();
		List<FoodEntity> foodsEntities = new ArrayList<>();
		List<Food> foods = new ArrayList<>();
		foodsEntities = foodDao.getFoods();
		foods = mapper.map(foodsEntities, new TypeToken<List<Food>>() {}.getType());
		return foods;
	}
	

	@Override
	public Boolean removeFood(Long foodId) {
		return foodDao.removeFood(foodId);
	}
	
}
