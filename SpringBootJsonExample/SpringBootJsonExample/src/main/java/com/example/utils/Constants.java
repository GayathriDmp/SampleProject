package com.example.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Constants {
	
	public final String PAYER_ID = "payer_id";
	public final String PAYER_NAME = "payerName";
	public final String PAYMENT_TYPE = "payment_type";
	public final String PAYER_ACCOUNT_NUMBER = "payerAccountNumber";
	public final List<String> MANDATORY_PROPS_LIST = Arrays.asList("payer_id","payerName","payment_type","payerAccountNumber");
	

}
