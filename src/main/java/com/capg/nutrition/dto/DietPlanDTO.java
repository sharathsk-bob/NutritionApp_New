package com.capg.nutrition.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class DietPlanDTO {
	// Data Fields
    private int id;
//    @NotNull(message="userID should not be empty")
//    private String  userId;
    @NotNull(message="Slots should not be empty")
    private String slots;
    @NotNull(message="FoodType should not be empty")
    private String foodType;
    @NotNull(message="ProteinRatio should not be empty")
    private String proteinRatio;
    @NotNull(message="FatRatio should not be empty")
    private String fatRatio;
    @NotNull(message="CarbsRatio should not be empty")
    private String carbsRatio;
    @NotNull(message="Total should not be empty")
    private String total;
	public DietPlanDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DietPlanDTO(int id, @NotNull(message = "Slots should not be empty") String slots,
			@NotNull(message = "FoodType should not be empty") String foodType,
			@NotNull(message = "ProteinRatio should not be empty") String proteinRatio,
			@NotNull(message = "FatRatio should not be empty") String fatRatio,
			@NotNull(message = "CarbsRatio should not be empty") String carbsRatio,
			@NotNull(message = "Total should not be empty") String total) {
		super();
		this.id = id;
		this.slots = slots;
		this.foodType = foodType;
		this.proteinRatio = proteinRatio;
		this.fatRatio = fatRatio;
		this.carbsRatio = carbsRatio;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getProteinRatio() {
		return proteinRatio;
	}
	public void setProteinRatio(String proteinRatio) {
		this.proteinRatio = proteinRatio;
	}
	public String getFatRatio() {
		return fatRatio;
	}
	public void setFatRatio(String fatRatio) {
		this.fatRatio = fatRatio;
	}
	public String getCarbsRatio() {
		return carbsRatio;
	}
	public void setCarbsRatio(String carbsRatio) {
		this.carbsRatio = carbsRatio;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "DietPlanDTO [id=" + id + ", slots=" + slots + ", foodType=" + foodType + ", proteinRatio="
				+ proteinRatio + ", fatRatio=" + fatRatio + ", carbsRatio=" + carbsRatio + ", total=" + total + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(carbsRatio, fatRatio, foodType, id, proteinRatio, slots, total);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DietPlanDTO other = (DietPlanDTO) obj;
		return Objects.equals(carbsRatio, other.carbsRatio) && Objects.equals(fatRatio, other.fatRatio)
				&& Objects.equals(foodType, other.foodType) && id == other.id
				&& Objects.equals(proteinRatio, other.proteinRatio) && Objects.equals(slots, other.slots)
				&& Objects.equals(total, other.total);
	}

    
}