package nyamnyam1.DMO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nyamnyam1.DTO.Food;
import nyamnyam1.DTO.MealPlanFood;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PlanManager {

	private Gson gson = new Gson();

	private List<Food> foodList;
	public List<Food> getFoodList() {
		return foodList;
	}

	private List<MealPlanFood> foods;
	public List<MealPlanFood> getFoods() {
		return foods;
	}

	public PlanManager(String mealPlanJsonPath, String foodJsonPath) {
		this.foods = loadMealPlanData(mealPlanJsonPath);
		this.foodList = loadFoodData(foodJsonPath);
	}

	private List<Food> loadFoodData(String jsonFilePath) {
		try (FileReader rdf = new FileReader(jsonFilePath)) {
			Type foodListType = new TypeToken<List<Food>>() {}.getType();
			return gson.fromJson(rdf, foodListType);
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	private List<MealPlanFood> loadMealPlanData(String jsonFilePath) {
		try (FileReader rdp = new FileReader(jsonFilePath)) {
			Type planListType = new TypeToken<List<MealPlanFood>>() {}.getType();
			return gson.fromJson(rdp, planListType);
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}


	public static void main(String[] args) {
		PlanManager manager = new PlanManager("data/mealPlanFood.json", "data/foodData.json");

		List<MealPlanFood> foods = manager.getFoods();
		List<Food> foodList = manager.getFoodList();

		System.out.println("오늘 먹은 음식 개수: " + foods.size());

		for(int i = 0; i <foods.size(); i++){
			System.out.println((i+1) + "번째 식단 음식: " + foods.get(i).getFoodName()
					+ ", 섭취량: " + foods.get(i).getAmount() + "g"
					+ ", 칼로리: " + foods.get(i).getTotalKcal());
		}
		}

	}