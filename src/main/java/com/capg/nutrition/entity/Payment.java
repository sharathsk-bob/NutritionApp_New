package com.capg.nutrition.entity;

import java.util.Date;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.capg.nutrition.dto.PaymentDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Payment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private long planId;
        private float payment;
        private float discount;
        private Date created_At;
        private Date updated_At;
		public Payment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Payment(int id, long planId, float payment, float discount, Date created_At, Date updated_At) {
			super();
			this.id = id;
			this.planId = planId;
			this.payment = payment;
			this.discount = discount;
			this.created_At = created_At;
			this.updated_At = updated_At;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getPlanId() {
			return planId;
		}
		public void setPlanId(long planId) {
			this.planId = planId;
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
		@Override
		public String toString() {
			return "Payment [id=" + id + ", planId=" + planId + ", payment=" + payment + ", discount=" + discount
					+ ", created_At=" + created_At + ", updated_At=" + updated_At + "]";
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
			Payment other = (Payment) obj;
			return Objects.equals(created_At, other.created_At)
					&& Float.floatToIntBits(discount) == Float.floatToIntBits(other.discount) && id == other.id
					&& Float.floatToIntBits(payment) == Float.floatToIntBits(other.payment) && planId == other.planId
					&& Objects.equals(updated_At, other.updated_At);
		}
		public PaymentDTO toPaymentDTO() {
			PaymentDTO paymentDTO = new PaymentDTO();
			paymentDTO.setId(this.getId());
			paymentDTO.setPayment(this.getPayment());
			paymentDTO.setDiscount(this.getDiscount());
			paymentDTO.setCreated_At(this.getCreated_At());
			paymentDTO.setUpdated_At(this.getUpdated_At());
			paymentDTO.setPlanId(this.getPlanId());	
			return paymentDTO;
		}
}