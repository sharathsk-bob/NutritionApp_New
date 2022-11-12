package com.capg.nutrition.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Objects;


public class NutritionPlanDTO {
    private int id;
    @NotNull(message = "{customer.name.absent}")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{customer.name.invalid}")
    private String name;
    @NotEmpty(message = "planDescription should not be empty")
    private String planDescription;
    //@PastOrPresent(message = "customer.created.invalid")
    private LocalDate created_At;
    //@PastOrPresent(message = "customer.updated.invalid")
    private LocalDate updated_At;
    @NotNull(message = "Price > 0 ")
    private double price;
    
    
	public NutritionPlanDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NutritionPlanDTO(int id,
			@NotNull(message = "{customer.name.absent}") @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{customer.name.invalid}") String name,
			@NotEmpty(message = "planDescription should not be empty") String planDescription, LocalDate created_At,
			LocalDate updated_At, @NotNull(message = "Price > 0 ") double price) {
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
		return "NutritionPlanDTO [id=" + id + ", name=" + name + ", planDescription=" + planDescription
				+ ", created_At=" + created_At + ", updated_At=" + updated_At + ", price=" + price + "]";
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
		NutritionPlanDTO other = (NutritionPlanDTO) obj;
		return Objects.equals(created_At, other.created_At) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(planDescription, other.planDescription)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(updated_At, other.updated_At);
	}
	
	
    
}