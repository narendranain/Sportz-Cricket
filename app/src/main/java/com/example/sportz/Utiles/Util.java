package com.example.sportz.Utiles;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.ExifInterface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableCompat;


import com.example.sportz.R;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class Util extends Activity{

    public static ProgressDialog sProgressDialog;
    //public static Ringtone ringtone;
    public static void showProgressDialog(Context context)
    {
        sProgressDialog = new ProgressDialog(context, R.style.ProgressDialogTheme);
        sProgressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        sProgressDialog.setCancelable(false);
        try {
            sProgressDialog.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void dismissProgressDialog() {
        if (sProgressDialog != null && sProgressDialog.isShowing()) {
            sProgressDialog.dismiss();
        }
    }

    public static boolean IsValidUrl(String urlString) {

        boolean isValid = false;
        String expression ="((?:http|https)://)?(?:www\\.)?[\\w\\d\\-_]+\\.\\w{2,3}(\\.\\w{2})?(/(?<=/)(?:[\\w\\d\\-./_]+)?)?";
        CharSequence inputStr = urlString;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches())
        {
            isValid = true;
        }
        return isValid;
    }



    public static boolean checkStringIsNull(String value) {
        if (value == null) {
            return false;
        }
        if (value.isEmpty()) {
            return false;
        }
        return true;
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public static void showMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static String formatDate(String date) {
        try {
            String[] splitDate = date.split("");
            Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);

            DateFormat format2=new SimpleDateFormat("dd");
            int finalDay=Integer.parseInt(format2.format(date1));
            String dayNumberSuffix = getDayNumberSuffix(finalDay);

            DateFormat targetFormat1 = new SimpleDateFormat("MMMM "+ "d'" + dayNumberSuffix + "' ''yy, hh:mm a");
            return (targetFormat1.format(date1));
            //"2018-08-30T18:30:00-04:00"

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String formatDateForCalender(String date) {
        try {
            String[] splitDate = date.split("");
            Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);

            DateFormat format2=new SimpleDateFormat("dd");
            int finalDay=Integer.parseInt(format2.format(date1));
            String dayNumberSuffix = getDayNumberSuffix(finalDay);

            DateFormat targetFormat1 = new SimpleDateFormat("MMMM "+ "d'" + dayNumberSuffix + "' ''yyyy EEEE");
            return (targetFormat1.format(date1));
            //"2018-08-30T18:30:00-04:00"

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDayNumberSuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "<sup>th</sup>";
        }
        switch (day % 10) {
            case 1:
                return "<sup><small>st</small></sup>";
            case 2:
                return "<sup><small>nd</small></sup>";
            case 3:
                return "<sup><small>rd</small></sup>";
            default:
                return "<sup><small>th</small></sup>";

        }
    }
    public static String showTime(int hour, int min) {
        String format;
        if (hour == 0) {
            hour += 12;
            return format = "AM";
        } else if (hour == 12) {
            return format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            return format = "PM";
        } else {
            return format = "AM";
        }
    }
    public static String Convert12HRTo24(String time){

        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
        Date date = null;
        try {
            date = parseFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  displayFormat.format(date);
    }
    public static String Convert24HRTo12(String time){

        SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = parseFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  displayFormat.format(date);
    }




}
