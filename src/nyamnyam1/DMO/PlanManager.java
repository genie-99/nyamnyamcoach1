package nyamnyam1.DMO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nyamnyam1.DTO.Food;
import nyamnyam1.DTO.MealPlan;
import nyamnyam1.DTO.MealPlanFood;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PlanManager {

    private Gson gson = new Gson();

    private List<Food> foodList;
    private List<MealPlanFood> eatenfoods;



    public PlanManager(String mealPlanJsonPath, String foodJsonPath) {
        this.eatenfoods = loadMealPlanData(mealPlanJsonPath);
        this.foodList = loadFoodData(foodJsonPath);
    }
    private List<Food> loadFoodData(String jsonFilePath) {
        try (FileReader rdf = new FileReader(jsonFilePath)) {
            Type foodListType = new TypeToken<List<Food>>() {
            }.getType();
            return gson.fromJson(rdf, foodListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<MealPlanFood> loadMealPlanData(String jsonFilePath) {
        try (FileReader rdp = new FileReader(jsonFilePath)) {
            Type planListType = new TypeToken<List<MealPlanFood>>() {
            }.getType();
            return gson.fromJson(rdp, planListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public List<MealPlanFood> getEatenFoodList() {
        return eatenfoods;
    }


//    public List<MealPlanFood> addFoodAtPlan() {
//        for (Food food : foodList) {
//            if (food.getFoodName().equals("카레라이스")) {
//                MealPlanFood newFood = new MealPlanFood(
//
//                );
//                eatenfoods.add(newFood);
//            }
//        }
//        return eatenfoods;
//    }


    public static void main(String[] args) {
        PlanManager manager = new PlanManager("data/mealPlanFood.json", "data/foodData.json");

        List<MealPlanFood> eatenFoods = manager.getEatenFoodList();
        List<Food> foodList = manager.getFoodList();

        System.out.println("식단에 있는 음식 개수: " + eatenFoods.size());
        System.out.println("전체 음식 개수: " + foodList.size());

        for (int i = 0; i < eatenFoods.size(); i++) {
            System.out.println((i + 1) + "번째 식단 음식: " + eatenFoods.get(i).getFoodName()
                    + ", 섭취량: " + eatenFoods.get(i).getAmount() + "g"
                    + ", 칼로리: " + eatenFoods.get(i).getTotalKcal());

        }
        System.out.println(foodList);



    }
}





