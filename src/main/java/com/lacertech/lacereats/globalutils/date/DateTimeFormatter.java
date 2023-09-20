package com.lacertech.lacereats.globalutils.date;

import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateTimeFormatter {

    private final SimpleDateFormat dateFormatter;

    public DateTimeFormatter() {
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    }

    public String formatDate(Date data) {
        return dateFormatter.format(data);
    }

    public Date parseDate(String dataString) throws ParseException {
        return dateFormatter.parse(dataString);
    }
}
