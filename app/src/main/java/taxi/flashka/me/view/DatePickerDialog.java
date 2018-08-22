package taxi.flashka.me.view;

import android.content.Context;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import taxi.flashka.me.interfaces.IDateSetListener;

public class DatePickerDialog implements android.app.DatePickerDialog.OnDateSetListener {

    private IDateSetListener dateSetListener;

    private Calendar calendar = Calendar.getInstance();

    public DatePickerDialog(Context context, IDateSetListener dateSetListener) {
        this.dateSetListener = dateSetListener;
        new android.app.DatePickerDialog( context, this
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(year, month, dayOfMonth);
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        dateSetListener.onDateSet(simpleDateFormat.format(calendar.getTime()));
    }
}
