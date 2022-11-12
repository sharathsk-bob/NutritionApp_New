package com.capg.nutrition.entity;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    private String slots;
 
    private String foodType;
    
    private String proteinRatio;
    
    private String fatRatio;
  
    private String carbsRatio;
 
    private String total;

	public DietPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DietPlan(int id, String slots, String foodType, String proteinRatio, String fatRatio, String carbsRatio,
			String total) {
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
		return "DietPlan [id=" + id + ", slots=" + slots + ", foodType=" + foodType + ", proteinRatio=" + proteinRatio
				+ ", fatRatio=" + fatRatio + ", carbsRatio=" + carbsRatio + ", total=" + total + "]";
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
		DietPlan other = (DietPlan) obj;
		return Objects.equals(carbsRatio, other.carbsRatio) && Objects.equals(fatRatio, other.fatRatio)
				&& Objects.equals(foodType, other.foodType) && id == other.id
				&& Objects.equals(proteinRatio, other.proteinRatio) && Objects.equals(slots, other.slots)
				&& Objects.equals(total, other.total);
	}
	
	
}