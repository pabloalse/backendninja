package com.udemy.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.services.EjercicioServicio;

@Service("EjercicioServico")
public class EjercicioServicioImpl implements EjercicioServicio{

	private final static Log LOG = LogFactory.getLog(EjercicioServicioImpl.class);
	
	public void getLoggs(){
		
		LOG.info("Ejercicio");
	}
	
}
