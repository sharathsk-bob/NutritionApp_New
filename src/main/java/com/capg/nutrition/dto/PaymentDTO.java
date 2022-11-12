package com.capg.nutrition.dto;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.capg.nutrition.entity.Payment;

public class PaymentDTO {
	// Data Fields
	
	private int id;
	@NotNull(message="payment should not be empty")
    private float payment;
	@NotNull(message="discount should not be empty")
    private float discount;
	@NotNull(message="Creation date should not be empty")
    private Date created_At;
	@NotNull(message="Update date should not be empty")
    private Date updated_At;
	//relationships
    private long planId;
    
	// Constructors
    public PaymentDTO() {
    	super();
    }

	public PaymentDTO(int id, @NotNull(message = "payment should not be empty") float payment,
			@NotNull(message = "discount should not be empty") float discount,
			@NotNull(message = "Creation date should not be empty") Date created_At,
			@NotNull(message = "Update date should not be empty") Date updated_At, long planId) {
		super();
		this.id = id;
		this.payment = payment;
		this.discount = discount;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.planId = planId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPayment() {
		return payment;
	}

	public void setPayment(float payment) {
		this.payment = payment;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "PaymentDTO [id=" + id + ", payment=" + payment + ", discount=" + discount + ", created_At=" + created_At
				+ ", updated_At=" + updated_At + ", planId=" + planId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(created_At, discount, id, payment, planId, updated_At);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentDTO other = (PaymentDTO) obj;
		return Objects.equals(created_At, other.created_At)
				&& Float.floatToIntBits(discount) == Float.floatToIntBits(other.discount) && id == other.id
				&& Float.floatToIntBits(payment) == Float.floatToIntBits(other.payment) && planId == other.planId
				&& Objects.equals(updated_At, other.updated_At);
	}
	public Payment toPayment() {
		Payment payment = new Payment();
		payment.setId(this.getId());
		payment.setPayment(this.getPayment());
		payment.setDiscount(this.getDiscount());
		payment.setCreated_At(this.getCreated_At());
		payment.setUpdated_At(this.getUpdated_At());
		payment.setPlanId(this.getPlanId());
		return payment;
	}


    
    
}