package nyamnyam1.DTO;

import java.io.Serializable;

public class Food implements Serializable, Comparable<Food> {

    private String foodCode;   //식품코드
    private String foodName;   //식품명
    private Double energyKcal;   //에너지
    private Double protein;      //단백질
    private Double fat;          //지방
    private Double carbo; //탄수화물
    private Double glucide;      //당류

    public Food() {
    }

    public Food(String foodCode, String foodName, Double energyKcal, Double protein, Double fat, Double carbo, Double glucide) {
        this.foodCode = foodCode;
        this.foodName = foodName;
        this.energyKcal = energyKcal;
        this.protein = protein;
        this.fat = fat;
        this.carbo = carbo;
        this.glucide = glucide;
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

    public Double getEnergyKcal() {
        return energyKcal;
    }

    public void setEnergyKcal(Double energyKcal) {
        this.energyKcal = energyKcal;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbo() {
        return carbo;
    }

    public void setCarbo(Double carbo) {
        this.carbo = carbo;
    }

    public Double getGlucide() {
        return glucide;
    }

    public void setGlucide(Double glucide) {
        this.glucide = glucide;
    }


    @Override
    public String toString() {
        return "Food{" +
                "foodCode='" + foodCode + '\'' +
                ", foodName='" + foodName + '\'' +
                ", energyKcal=" + energyKcal +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbo=" + carbo +
                ", glucide=" + glucide +
                '}';
    }


    @Override
    public int compareTo(Food o) {
        return this.foodCode.compareTo(o.foodCode);
    }
}


