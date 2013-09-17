package com.clearprecision.parser.api;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.clearprecision.parser.jaxb.MeasCollecFile;

public class MeasurementFactory {
	/**
	 * 
	 * @param file
	 * @return
	 */
	public static MeasCollecFile build(String file) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(MeasCollecFile.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (MeasCollecFile) unmarshaller.unmarshal(new File(file));
	}
}
