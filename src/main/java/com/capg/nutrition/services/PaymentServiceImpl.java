package com.capg.nutrition.services;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.nutrition.dto.PaymentDTO;
import com.capg.nutrition.entity.Payment;
import com.capg.nutrition.exceptions.InvalidDataException;
import com.capg.nutrition.repository.PaymentRepository;
//import java.util.Optional;

/**
 * The Class PaymentServiceImpl.
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	/** The payment repository. */ 
	@Autowired
	private PaymentRepository paymentRepository;
    
    @Override
    public PaymentDTO pay(PaymentDTO paymentDTO) throws InvalidDataException{
    	Payment payment = paymentDTO.toPayment();
		Payment savedPayment = paymentRepository.save(payment);
		return savedPayment.toPaymentDTO();
	}

	@Override
	public PaymentDTO addOffer(PaymentDTO paymentDTO,float discount) throws InvalidDataException {
		
		//logger.info("addOffer method initiated");
		Payment Discountedvalue = paymentRepository.findById(paymentDTO.getId()).
                orElseThrow(()->new InvalidDataException("Payment with id "+
                paymentDTO.getId() +" does not exist."));
		if(Discountedvalue.getDiscount()!= 0f) {
			throw new InvalidDataException("Discount already exist");
		}
		else {
			Discountedvalue.setDiscount(discount);
		}		
		//mapToEntity(paymentDto);
		//logger.info("addOffer method executed");
		return Discountedvalue.toPaymentDTO();
	}
	
    @Override
    public List<PaymentDTO> showAllPayments() throws InvalidDataException  {    	
    	Iterable<Payment> payment = paymentRepository.findAll();
		List<PaymentDTO> paymentDtolist = new ArrayList<>();
		for(Payment p : payment) {
			PaymentDTO paymentDto = p.toPaymentDTO();
			paymentDtolist.add(paymentDto);
		}
		return paymentDtolist; 
    	}

	@Override
	public PaymentDTO updatePayment(PaymentDTO paymentDTO) throws InvalidDataException {
		Optional<Payment> optionalPayment = paymentRepository.findById(paymentDTO.getId());
		Payment payment = optionalPayment.orElseThrow(()->new InvalidDataException("Payment with this id does not exist."));	
//		if(paymentDTO.getPayment() != null)
//			payment.setPayment(paymentDTO.getPayment());
//		if(paymentDTO.getDiscount() != null)
//			payment.setDiscount(paymentDTO.getDiscount());
		if(paymentDTO.getCreated_At() != null)
			payment.setDiscount(paymentDTO.getDiscount());
		if(paymentDTO.getUpdated_At() != null)
			payment.setDiscount(paymentDTO.getDiscount());
		return payment.toPaymentDTO();
	}



}