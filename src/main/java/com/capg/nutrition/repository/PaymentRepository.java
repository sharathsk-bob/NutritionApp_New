package com.capg.nutrition.repository;

import com.capg.nutrition.entity.NutritionPlan;
import com.capg.nutrition.entity.Payment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;


//import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    //@Query("SELECT p FROM Payment p WHERE p.userId = ?1")
    //Optional<PaymentDTO> findPaymentByUserId(String userId);
}
