package nyamnyam1.DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class MealPlanFood implements Serializable {

    private String mealPlanFoodId; //pk
    private String mealPlanId;  // 식단코드, 사용자 +날짜 형식??
    private String foodCode;        // 음식 (fk - Food.foodCode)
    private String foodName;        //
    private int amount;             // 섭취량
    private Double totalKcal;       // 실제 섭취 열량
    private Double totalFat;        // 섭취 지방량
    private Double totalProtein;    // 섭취 단백질량
    private Double getTotalCarbo;    // 섭취 탄수량


    public MealPlanFood() {
    }

    public MealPlanFood(String mealPlanFoodId, String mealPlanId, String foodCode, String foodName, int amount, Double totalKcal, Double totalFat, Double totalProtein, Double getTotalCarbo) {
        this.mealPlanFoodId = mealPlanFoodId;
        this.mealPlanId = mealPlanId;
        this.foodCode = foodCode;
        this.foodName = foodName;
        this.amount = amount;
        this.totalKcal = totalKcal;
        this.totalFat = totalFat;
        this.totalProtein = totalProtein;
        this.getTotalCarbo = getTotalCarbo;
    }


    public String getMealPlanFoodId() {
        return mealPlanFoodId;
    }

    public void setMealPlanFoodId(String mealPlanFoodId) {
        this.mealPlanFoodId = mealPlanFoodId;
    }

    public String getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(String mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(Double totalKcal) {
        this.totalKcal = totalKcal;
    }

    public Double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(Double totalFat) {
        this.totalFat = totalFat;
    }

    public Double getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(Double totalProtein) {
        this.totalProtein = totalProtein;
    }

    public Double getGetTotalCarbo() {
        return getTotalCarbo;
    }

    public void setGetTotalCarbo(Double getTotalCarbo) {
        this.getTotalCarbo = getTotalCarbo;
    }

    @Override
    public String toString() {
        return "MealPlanFood{" +
                "mealPlanFoodId='" + mealPlanFoodId + '\'' +
                ", mealPlanId='" + mealPlanId + '\'' +
                ", foodCode='" + foodCode + '\'' +
                ", foodName='" + foodName + '\'' +
                ", amount=" + amount +
                ", totalKcal=" + totalKcal +
                ", totalFat=" + totalFat +
                ", totalProtein=" + totalProtein +
                ", getTotalCarbo=" + getTotalCarbo +
                '}';
    }
}