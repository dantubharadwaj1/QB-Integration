package com.intuit.developer.sampleapp.crud.helper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import com.intuit.ipp.data.*;
import org.apache.commons.lang.RandomStringUtils;

import com.intuit.developer.sampleapp.crud.helper.Address;
import com.intuit.developer.sampleapp.crud.helper.Email;
import com.intuit.developer.sampleapp.crud.helper.Job;
import com.intuit.developer.sampleapp.crud.helper.Telephone;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.util.DateUtils;

/**
 * @author dderose
 *
 */
public final class CustomerHelper {
	
	private CustomerHelper() {
		
	}

	public static Customer getCustomer(DataService service) throws FMSException, ParseException {
		List<Customer> customers = (List<Customer>) service.findAll(new Customer());
		if (!customers.isEmpty()) {
			return customers.get(0);
		}
		return createCustomer(service);
	}

	private static Customer createCustomer(DataService service) throws FMSException, ParseException {
		return service.add(getCustomerWithAllFields());
	}

	public static ReferenceType getCustomerRef(Customer customer) {
		ReferenceType customerRef = new ReferenceType();
		customerRef.setName(customer.getDisplayName());
		customerRef.setValue(customer.getId());
		return customerRef;
	}

	public static Customer getCustomerWithMandatoryFields() throws FMSException {

		PhysicalAddress physicalAddress = new PhysicalAddress();
		physicalAddress.setCity("Hyderabad");
		physicalAddress.setCountry("India");
		physicalAddress.setLine1("SGITS-Global, Prashant Hills");
		physicalAddress.setLine2("Khajaguda, Raidurg");
		physicalAddress.setCountryCode("IN");
		physicalAddress.setPostalCode("500032");
		physicalAddress.setLat("17.420275006758008");
		physicalAddress.setLong("78.38033480316356");
		Customer customer = new Customer();
		customer.setDisplayName("Vijay Cherukumudi");
		customer.setAcctNum("1231231");
		customer.setBalance(BigDecimal.valueOf(10000));
		customer.setContactName("Vijay Cherukumudi");
		customer.setBillAddr(physicalAddress);
		customer.setBillAddr(physicalAddress);
		customer.setAltContactName("Vijay");
		customer.setGSTIN("12312312311");

		// Mandatory Fields
		//customer.setDisplayName(RandomStringUtils.randomAlphanumeric(6));
		return customer;

	}

	public static Customer getCustomerWithAllFields() throws FMSException, ParseException {
		Customer customer = new Customer();
		// Mandatory Fields
		customer.setDisplayName("Vijay Cherukumudi");
		customer.setTitle("CEO");
		customer.setGivenName("Vijay");
		customer.setMiddleName("Kumar");
		customer.setFamilyName("Cherukumudi");

		// Optional Fields
		customer.setOrganization(false);
		customer.setSuffix("Sr.");
		customer.setCompanyName("SGITS-Global");
		customer.setPrintOnCheckName("SGITS");
		customer.setActive(true);

		TelephoneNumber telephoneNumber = new TelephoneNumber();
		telephoneNumber.setDeviceType("Mobile");
		telephoneNumber.setFreeFormNumber("913-226-8598");


		customer.setPrimaryPhone(telephoneNumber);
		customer.setAlternatePhone(telephoneNumber);
		customer.setMobile(telephoneNumber);
		//customer.setFax(Telephone.getFax());

		EmailAddress emailAddress = new EmailAddress();
		emailAddress.setAddress("vijay@sharpgurus-usa.com");


		customer.setPrimaryEmailAddr(emailAddress);

		customer.setContactName("Vijay Kumar Cherukumudi");
		customer.setAltContactName("Vijay");
		//customer.setNotes("Testing Notes");
		customer.setBalance(new BigDecimal("10000"));
		customer.setOpenBalanceDate(DateUtils.getCurrentDateTime());
		customer.setBalanceWithJobs(new BigDecimal("5000"));
		customer.setCreditLimit(new BigDecimal("20000"));
		customer.setAcctNum("1231231231");
		customer.setResaleNum("40");
		customer.setJob(false);
		customer.setPrimaryTaxIdentifier("1111111");


		customer.setJobInfo(Job.getJobInfo());

		PhysicalAddress physicalAddress = new PhysicalAddress();
		physicalAddress.setCity("Hyderabad");
		physicalAddress.setCountry("India");
		physicalAddress.setLine1("SGITS-Global, Prashant Hills");
		physicalAddress.setLine2("Khajaguda, Raidurg");
		physicalAddress.setCountryCode("IN");
		physicalAddress.setPostalCode("500032");
		physicalAddress.setLat("17.420275006758008");
		physicalAddress.setLong("78.38033480316356");

		customer.setBillAddr(physicalAddress);
		customer.setShipAddr(physicalAddress);

		return customer;

	}

}
