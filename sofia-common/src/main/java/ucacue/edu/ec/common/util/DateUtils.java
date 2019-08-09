package ucacue.edu.ec.common.util;

 import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ucacue.edu.ec.common.exception.SofiaException;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final Logger logger = LogManager.getLogger(DateUtils.class);

	/**
	 * Utility classes should not have a public constructor.
	 */
	private DateUtils() {
	}

	public static String convertirGreggorianToDDMMYYYY(String fecha) throws SofiaException {
		try {
			Date date = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			date = sdf.parse(fecha);
			DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			fecha = formatoFecha.format(date);
			return fecha;
		} catch (ParseException e) {
			logger.error("convertirGreggorianToDDMMYYYY", e);
			throw new SofiaException(e.getMessage());
		}
	}

	public static String convertirTimestampToDate(Timestamp timestamp) {
		Date date = new Date(timestamp.getTime());
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatoFecha.format(date);
	}

	public static Date getFechaFromStringddMMyyyy(String fecha) throws SofiaException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse(fecha);
			return date;
		} catch (ParseException e) {
			logger.error("getFechaFromStringddMMyyyy", e);
			throw new SofiaException(e.getMessage());
		}
	}

}