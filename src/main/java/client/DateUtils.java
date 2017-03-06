package client;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class DateUtils {
	public static void main(String[] args) throws Exception {
		Date date = new Date();
		Date to = new SimpleDateFormat("yyyy-MM-dd").parse("2018-02-20");
		System.out.println(getMonths(date, to));
	}

	public static void string(Date d) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d));
	}

	public static int getMonths(Date from, Date to) {
		if (from == null || to == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Date f = new Date(from.getTime());
		int month = 0;
		while (!isSameMonth(f, to)) {
			f = DateUtils.addMonths(f, 1);
			month++;
		}

		return month;
	}

	public static boolean isSameMonth(Date from, Date to) {
		if (from == null || to == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(from);
		Calendar calTo = Calendar.getInstance();
		calTo.setTime(to);

		return calFrom.get(Calendar.ERA) == calTo.get(Calendar.ERA)
				&& calFrom.get(Calendar.MONTH) == calTo.get(Calendar.MONTH);
	}
}
