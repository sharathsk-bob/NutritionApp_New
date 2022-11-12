package com.capg.nutrition.services;

import java.util.List;

import com.capg.nutrition.exceptions.InvalidDataException;
import com.capg.nutrition.dto.PaymentDTO;


/**
 * The Interface IPaymentService.
 */

public interface PaymentService {
	
	/**
	 * Adds the payment.
	 * @param payment the payment
	 * @return the payment DTO
	 */
	public PaymentDTO pay(PaymentDTO paymentDTO) throws InvalidDataException ;
	
	/**
	 * Adds offers to payment details.
	 *
	 * @return the all payment details
	 */
	public PaymentDTO addOffer(PaymentDTO paymentDTO,float discount) throws InvalidDataException ;
	
	/**
	 * Gets the all payment details.
	 *
	 * @return the all payment details
	 */
	public List<PaymentDTO> showAllPayments() throws InvalidDataException ;
	
	/**
	 * Update payment.
	 *
	 * @param id the id ??
	 * @param payment the payment
	 * @return the payment DTO
	 * @throws PaymentException the payment exception
	 */
	public PaymentDTO updatePayment(PaymentDTO paymentDTO) throws InvalidDataException ;

}