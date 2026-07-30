package nyamnyam1.DMO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nyamnyam1.DTO.Food;
import nyamnyam1.DTO.MealPlan;
import nyamnyam1.DTO.MealPlanFood;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
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

    public void saveData(String jsonFilePath) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jsonFilePath)))) {
            bw.write(gson.toJson(eatenfoods));
            System.out.println("저장완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<MealPlanFood> addFoodAtPlan(String input, int amount) {
        for (Food food : foodList) {
            if (food.getFoodName().equals(input)) {
                double ratio = amount / 100.0;

                double kcal = (food.getEnergyKcal() != null) ? food.getEnergyKcal() : 0.0;
                double fat = (food.getFat() != null) ? food.getFat() : 0.0;
                double protein = (food.getProtein() != null) ? food.getProtein() : 0.0;
                double carbo = (food.getCarbo() != null) ? food.getCarbo() : 0.0;

                MealPlanFood newFood = new MealPlanFood(
                        "MPF" + (eatenfoods.size() + 1),
                        "TEMP_PLAN_ID",
                        food.getFoodCode(),
                        food.getFoodName(),
                        amount,
                        kcal * ratio,
                        fat * ratio,
                        protein * ratio,
                        carbo * ratio
                );
                eatenfoods.add(newFood);
            }
        }
        saveData("data/mealPlanFood.json");
        return eatenfoods;
    }


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
        manager.addFoodAtPlan("김밥_날치알", 3);



    }
}





