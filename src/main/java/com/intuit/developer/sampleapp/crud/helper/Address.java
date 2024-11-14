package com.intuit.developer.sampleapp.crud.helper;

import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.WebSiteAddress;

/**
 * @author dderose
 *
 */
public final class Address {
	
	private Address() {
		
	}

	public static PhysicalAddress getPhysicalAddress() {
		PhysicalAddress physicalAddress = new PhysicalAddress();
		/*billingAdd.setLine1("123 Main St");
		billingAdd.setCity("Mountain View");
		billingAdd.setCountry("United States");
		billingAdd.setCountrySubDivisionCode("CA");
		billingAdd.setPostalCode("94043");*/

		physicalAddress.setCity("Hyderabad");
		physicalAddress.setCountry("India");
		physicalAddress.setLine1("SGITS-Global, Prashant Hills");
		physicalAddress.setLine2("Khajaguda, Raidurg");
		physicalAddress.setCountryCode("IN");
		physicalAddress.setPostalCode("500032");
		physicalAddress.setLat("17.420275006758008");
		physicalAddress.setLong("78.38033480316356");
		return physicalAddress;
	}
	
	public static WebSiteAddress getWebSiteAddress() {
		WebSiteAddress webSite = new WebSiteAddress();
		webSite.setURI("http://sgits.com");
		webSite.setDefault(true);
		webSite.setTag("Business");
		return webSite;
	}
	
	public static PhysicalAddress getAddressForAST() {
		PhysicalAddress billingAdd = new PhysicalAddress();
		billingAdd.setLine1("SGITS-Global, Prashant Hills");
		billingAdd.setLine2("Khajaguda, Raidurg, Hyderabad 500032");
		return billingAdd;
	}

}
