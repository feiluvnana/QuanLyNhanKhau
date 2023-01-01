package handler;

import java.text.*;
import java.util.*;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "dd/MM/yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern, Locale.ENGLISH);

    @Override
    public Object stringToValue(String text) throws ParseException {
        if(text.length()==10) {
            return dateFormatter.parseObject(text);
        }
        return null;
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}