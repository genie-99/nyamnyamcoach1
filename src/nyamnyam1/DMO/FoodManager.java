package nyamnyam1.DMO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nyamnyam1.DTO.Food;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FoodManager {

    private Gson gson = new Gson();

    private List<Food> foodList;


    public FoodManager(String jsonFilePath) {
        this.foodList = loadFoodData(jsonFilePath);
    }

    private List<Food> loadFoodData(String jsonFilePath) {
        try (FileReader reader = new FileReader(jsonFilePath)) {
            Type foodListType = new TypeToken<List<Food>>() {
            }.getType();
            return gson.fromJson(reader, foodListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Food> getFoodList() {
        return foodList;
    }


    //입력한 이름과 동일한 음식 가져오기
    public List<String> getFoodNameAll(String foodname) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getFoodName().contains(foodname)) {
                names.add(foodList.get(i).getFoodName());
            }
        }
        return names;
    }

    public static void main(String[] args) {
        FoodManager manager = new FoodManager("data/foodData.json");
        List<Food> foodList = manager.getFoodList();

        System.out.println("로드된 음식 개수: " + foodList.size());
        for (int i = 0; i < 10; i++)
            System.out.println((i + 1) + "번째 음식: " + foodList.get(i).getFoodName());

        System.out.println(manager.getFoodNameAll("국밥"));
        System.out.println(manager.getFoodList());


    }
}
