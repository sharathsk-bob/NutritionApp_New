package com.capg.nutrition.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
//@Table(name="nutrition_plan")
public class NutritionPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String planDescription;
    private LocalDate created_At;
    private LocalDate updated_At;
    private double price;

    // Constructors	
    public NutritionPlan() {
    	super();
    }

	public NutritionPlan(int id, String name, String planDescription, LocalDate created_At, LocalDate updated_At,
			double price) {
		super();
		this.id = id;
		this.name = name;
		this.planDescription = planDescription;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public LocalDate getCreated_At() {
		return created_At;
	}

	public void setCreated_At(LocalDate created_At) {
		this.created_At = created_At;
	}

	public LocalDate getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(LocalDate updated_At) {
		this.updated_At = updated_At;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NutritionPlan [id=" + id + ", name=" + name + ", planDescription=" + planDescription + ", created_At="
				+ created_At + ", updated_At=" + updated_At + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(created_At, id, name, planDescription, price, updated_At);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NutritionPlan other = (NutritionPlan) obj;
		return Objects.equals(created_At, other.created_At) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(planDescription, other.planDescription)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(updated_At, other.updated_At);
	}
	

    
}