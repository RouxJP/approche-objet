package fr.diginamic.fichiers.recensement.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exceptions.FonctionnalException;
import fr.diginamic.fichiers.rescencement.Application;

public class BadFormatNumberException extends FonctionnalException {
	private static final Logger LOG = LoggerFactory.getLogger( Application.class);

	public BadFormatNumberException() {
		// TODO Auto-generated constructor stub
	}

	public BadFormatNumberException(String message) {
		super(message);
		LOG.error(message);
		// TODO Auto-generated constructor stub
	}

	public BadFormatNumberException(Throwable cause) {
		super(cause);
		LOG.error( cause.getMessage());
		// TODO Auto-generated constructor stub
	}

	public BadFormatNumberException(String message, Throwable cause) {
		super(message, cause);
		LOG.error(message);
	}

	public BadFormatNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		LOG.error(message);
	}

}
