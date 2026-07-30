package nyamnyam1.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MealPlan implements Serializable {

    private String mealPlanId;  // 식단코드, 사용자 +날짜 형식??
    private String userId;          // 사용자 //나중에 수정 필요
    private LocalDate mealDate;     // 식단 날짜
    private String mealType;        // 아점저
    private List<MealPlanFood> foods;        // 해당식단에 담기는 음식


    public MealPlan() {
    }


    public MealPlan(String mealPlanId, String userId, LocalDate mealDate, String mealType, List<MealPlanFood> foods) {
        this.mealPlanId = mealPlanId;
        this.userId = userId;
        this.mealDate = mealDate;
        this.mealType = mealType;
        this.foods = foods;
    }

    public String getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(String mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getMealDate() {
        return mealDate;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public List<MealPlanFood> getFoods() {
        return foods;
    }

    public void setFoods(List<MealPlanFood> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "mealPlanId='" + mealPlanId + '\'' +
                ", userId='" + userId + '\'' +
                ", mealDate=" + mealDate +
                ", mealType='" + mealType + '\'' +
                ", foods=" + foods +
                '}';
    }



}