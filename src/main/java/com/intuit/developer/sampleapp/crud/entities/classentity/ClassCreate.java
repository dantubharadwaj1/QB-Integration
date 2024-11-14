package com.intuit.developer.sampleapp.crud.entities.classentity;

import java.util.List;

import com.intuit.developer.sampleapp.crud.helper.ClassHelper;
import com.intuit.developer.sampleapp.crud.qbo.DataServiceFactory;
import com.intuit.ipp.data.Class;
import com.intuit.ipp.data.Error;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.util.Logger;

/**
 * Demonstrates methods to create class
 * 
 * @author dderose
 *
 */
public class ClassCreate {

	private static final org.slf4j.Logger LOG = Logger.getLogger();
	
	public static void main(String[] args) {
		try {
			createClass();
		} catch (Exception e) {
			LOG.error("Error during CRUD", e.getCause());
		}
	}
	
	public static void createClass() throws Exception {
		
		try {
			
			DataService service = DataServiceFactory.getDataService();
			
			// add class
			Class classObj = ClassHelper.getClassFields();
			Class savedClass = service.add(classObj);
			LOG.info("Class created: " + savedClass.getId());
						
		} catch (FMSException e) {
			List<Error> list = e.getErrorList();
			list.forEach(error -> LOG.error("Error while calling entity add:: " + error.getMessage()));			
		}
		
	}
}
