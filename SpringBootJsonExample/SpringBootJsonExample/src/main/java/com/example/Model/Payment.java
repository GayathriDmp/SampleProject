package com.example.Model;


import java.time.LocalDate;

import java.util.Arrays;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Payment {
			
	@JsonProperty("PAYMNT_TYPE")
	private String paymentType;
	@JsonProperty("PAYER_SORT_CODE")
	private String payerSortCode;
	@JsonProperty("PAYER_ACCOUNT_NUMBER")
	private String payerAccountNumber;
	@JsonProperty("BENE_SORT_CODE")
	private String beneSortCode;
	@JsonProperty("BENE_ACCOUNT_NUMBER")
	private String beneAccountNumber;
	@JsonProperty("PAYER_IBAN")
	private String payerIBAN;
	@JsonProperty("BENE_IBAN")
	private String beneIBAN;
	@JsonProperty("SPL_PAYMNT_TYPE")
	private String splPaymentType;
	@JsonProperty("PAYMNT_AMOUNT")
	private double paymentAmount;
	@JsonProperty("PROCESS_CODE")
	private int processCode;
	@JsonProperty("PMT_ID")
	private String pmtId;
	@JsonProperty("PAY_TYPE")
	private String payType;
	@JsonProperty("PAYMNT_CURRENCY")
	private String paymentCurrency;  
	@JsonProperty("PAYMNT_SUB_TYPE")
	private String paymentSubType;
	@JsonProperty("PAYMNT_SENT_DATE")
	private String paymentSentDate; 
	@JsonProperty("TRAN_REF_NO")
	private String tranRefNo;
	@JsonProperty("SETTLMNT_DATE")
	private String settlemntDate;
	@JsonProperty("SETTLMNT_CYCLE_ID")
	private int settlemntCycleId;
	@JsonProperty("SUBMITTING_MEMBER")
	private String submittingMember;
	@JsonProperty("RECEIVING_MEMBER")
	private String receivingMember;
	@JsonProperty("PAYMNT_TIMESTMP")
	private String paymentTimestamp;
	@JsonProperty("BENE_CUST_ACCT_NAME")
	private String beneCustAcctName;
	@JsonProperty("BENE_REFERENCE_INFO")
	private String beneReferenceInfo;
	@JsonProperty("EXCHG_RATE")
	private double exchangeRate;
	@JsonProperty("NUMERIC_REFERENCE")
	private double numericrefernce;
	@JsonProperty("ORIG_AMOUNT")
	private double origAmount; 
	@JsonProperty("ORIG_CURR")
	private String origCurrency;
	@JsonProperty("PAYER_ACCT_NAME")
	private String payerAcctName;
	@JsonProperty("PAYER_ACCT_ADDRESS")
	private String payerAcctAddress;
	@JsonProperty("PMT_RETN_CODE")
	private String pmtRetnCode;
	@JsonProperty("RETN_PMT_ID")
	private String retnPmtId;
	@JsonProperty("PAYER_REFERENCE_INFO")
	private String payerReferenceInfo;
	@JsonProperty("BRAND")
	private String brand;
	@JsonProperty("BENE_CUSTOMER_ID")
	private String[] beneCustomerId; 
	@JsonProperty("TENANT_ID")
	private String tenantId;
	@JsonProperty("BENE_BANKLINE_CUSTOMER_ID")
	private int beneBanklineCustomerId;
	@JsonProperty("BANKID")
	private String bankId; 
	@JsonProperty("ARIC_MODE")
	private String aricMode;
	@JsonProperty("edi_business_day")
	private String ediBusinessDay;
	@JsonProperty("src_sys_inst_id")
	private String srcSysInstId;
	
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPayerSortCode() {
		return payerSortCode;
	}
	public void setPayerSortCode(String payerSortCode) {
		this.payerSortCode = payerSortCode;
	}
	public String getPayerAccountNumber() {
		return payerAccountNumber;
	}
	public void setPayerAccountNumber(String payerAccountNumber) {
		this.payerAccountNumber = payerAccountNumber;
	}
	public String getBeneSortCode() {
		return beneSortCode;
	}
	public void setBeneSortCode(String beneSortCode) {
		this.beneSortCode = beneSortCode;
	}
	public String getBeneAccountNumber() {
		return beneAccountNumber;
	}
	public void setBeneAccountNumber(String beneAccountNumber) {
		this.beneAccountNumber = beneAccountNumber;
	}
	public String getPayerIBAN() {
		return payerIBAN;
	}
	public void setPayerIBAN(String payerIBAN) {
		this.payerIBAN = payerIBAN;
	}
	public String getBeneIBAN() {
		return beneIBAN;
	}
	public void setBeneIBAN(String beneIBAN) {
		this.beneIBAN = beneIBAN;
	}
	public String getSplPaymentType() {
		return splPaymentType;
	}
	public void setSplPaymentType(String splPaymentType) {
		this.splPaymentType = splPaymentType;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public int getProcessCode() {
		return processCode;
	}
	public void setProcessCode(int processCode) {
		this.processCode = processCode;
	}
	public String getPmtId() {
		return pmtId;
	}
	public void setPmtId(String pmtId) {
		this.pmtId = pmtId;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPaymentCurrency() {
		return paymentCurrency;
	}
	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}
	public String getPaymentSubType() {
		return paymentSubType;
	}
	public void setPaymentSubType(String paymentSubType) {
		this.paymentSubType = paymentSubType;
	}
	public String getPaymentSentDate() {
		return paymentSentDate;
	}
	public void setPaymentSentDate(String paymentSentDate) {
		this.paymentSentDate = paymentSentDate;
	}
	public String getTranRefNo() {
		return tranRefNo;
	}
	public void setTranRefNo(String tranRefNo) {
		this.tranRefNo = tranRefNo;
	}
	public String getSettlemntDate() {
		return settlemntDate;
	}
	public void setSettlemntDate(String settlemntDate) {
		this.settlemntDate = settlemntDate;
	}
	public int getSettlemntCycleId() {
		return settlemntCycleId;
	}
	public void setSettlemntCycleId(int settlemntCycleId) {
		this.settlemntCycleId = settlemntCycleId;
	}
	public String getSubmittingMember() {
		return submittingMember;
	}
	public void setSubmittingMember(String submittingMember) {
		this.submittingMember = submittingMember;
	}
	public String getReceivingMember() {
		return receivingMember;
	}
	public void setReceivingMember(String receivingMember) {
		this.receivingMember = receivingMember;
	}
	public String getPaymentTimestamp() {
		return paymentTimestamp;
	}
	public void setPaymentTimestamp(String paymentTimestamp) {
		this.paymentTimestamp = paymentTimestamp;
	}
	public String getBeneCustAcctName() {
		return beneCustAcctName;
	}
	public void setBeneCustAcctName(String beneCustAcctName) {
		this.beneCustAcctName = beneCustAcctName;
	}
	public String getBeneReferenceInfo() {
		return beneReferenceInfo;
	}
	public void setBeneReferenceInfo(String beneReferenceInfo) {
		this.beneReferenceInfo = beneReferenceInfo;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public double getNumericrefernce() {
		return numericrefernce;
	}
	public void setNumericrefernce(double numericrefernce) {
		this.numericrefernce = numericrefernce;
	}
	public double getOrigAmount() {
		return origAmount;
	}
	public void setOrigAmount(double origAmount) {
		this.origAmount = origAmount;
	}
	public String getOrigCurrency() {
		return origCurrency;
	}
	public void setOrigCurrency(String origCurrency) {
		this.origCurrency = origCurrency;
	}
	public String getPayerAcctName() {
		return payerAcctName;
	}
	public void setPayerAcctName(String payerAcctName) {
		this.payerAcctName = payerAcctName;
	}
	public String getPayerAcctAddress() {
		return payerAcctAddress;
	}
	public void setPayerAcctAddress(String payerAcctAddress) {
		this.payerAcctAddress = payerAcctAddress;
	}
	public String getPmtRetnCode() {
		return pmtRetnCode;
	}
	public void setPmtRetnCode(String pmtRetnCode) {
		this.pmtRetnCode = pmtRetnCode;
	}
	public String getRetnPmtId() {
		return retnPmtId;
	}
	public void setRetnPmtId(String retnPmtId) {
		this.retnPmtId = retnPmtId;
	}
	public String getPayerReferenceInfo() {
		return payerReferenceInfo;
	}
	public void setPayerReferenceInfo(String payerReferenceInfo) {
		this.payerReferenceInfo = payerReferenceInfo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String[] getBeneCustomerId() {
		return beneCustomerId;
	}
	public void setBeneCustomerId(String[] beneCustomerId) {
		this.beneCustomerId = beneCustomerId;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public int getBeneBanklineCustomerId() {
		return beneBanklineCustomerId;
	}
	public void setBeneBanklineCustomerId(int beneBanklineCustomerId) {
		this.beneBanklineCustomerId = beneBanklineCustomerId;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getAricMode() {
		return aricMode;
	}
	public void setAricMode(String aricMode) {
		this.aricMode = aricMode;
	}
	public String getEdiBusinessDay() {
		return ediBusinessDay;
	}
	public void setEdiBusinessDay(String ediBusinessDay) {
		this.ediBusinessDay = ediBusinessDay;
	}
	public String getSrcSysInstId() {
		return srcSysInstId;
	}
	public void setSrcSysInstId(String srcSysInstId) {
		this.srcSysInstId = srcSysInstId;
	}
	
	
	@Override
	public String toString() {
		return "Payment [paymentType=" + paymentType + ", payerSortCode=" + payerSortCode + ", payerAccountNumber="
				+ payerAccountNumber + ", beneSortCode=" + beneSortCode + ", beneAccountNumber=" + beneAccountNumber
				+ ", payerIBAN=" + payerIBAN + ", beneIBAN=" + beneIBAN + ", splPaymentType=" + splPaymentType
				+ ", paymentAmount=" + paymentAmount + ", processCode=" + processCode + ", pmtId=" + pmtId
				+ ", payType=" + payType + ", paymentCurrency=" + paymentCurrency + ", paymentSubType=" + paymentSubType
				+ ", paymentSentDate=" + paymentSentDate + ", tranRefNo=" + tranRefNo + ", settlemntDate="
				+ settlemntDate + ", settlemntCycleId=" + settlemntCycleId + ", submittingMember=" + submittingMember
				+ ", receivingMember=" + receivingMember + ", paymentTimestamp=" + paymentTimestamp
				+ ", beneCustAcctName=" + beneCustAcctName + ", beneReferenceInfo=" + beneReferenceInfo
				+ ", exchangeRate=" + exchangeRate + ", numericrefernce=" + numericrefernce + ", origAmount="
				+ origAmount + ", origCurrency=" + origCurrency + ", payerAcctName=" + payerAcctName
				+ ", payerAcctAddress=" + payerAcctAddress + ", pmtRetnCode=" + pmtRetnCode + ", retnPmtId=" + retnPmtId
				+ ", payerReferenceInfo=" + payerReferenceInfo + ", brand=" + brand + ", beneCustomerId="
				+ Arrays.toString(beneCustomerId) + ", tenantId=" + tenantId + ", beneBanklineCustomerId="
				+ beneBanklineCustomerId + ", bankId=" + bankId + ", aricMode=" + aricMode + ", ediBusinessDay=" + ediBusinessDay
				+ ", srcSysInstId=" + srcSysInstId  + "]";
	}
	
	
	
	
	
}
