package com.fooddk;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by STU on 2017-09-01.
 */

public class Tasty implements Parcelable{
    private int t_no;
    private String t_title;
    private String t_content;
    private String t_date;
    private Bitmap t_img;
    private String t_phone;
    private String t_time;
    private String t_address;
    private String t_location;
    private int t_count;
    private int c_no;
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.t_no);
        dest.writeString(this.t_title);
        dest.writeString(this.t_content);
        dest.writeString(this.t_date);
        dest.writeParcelable(this.t_img, flags);
        dest.writeString(this.t_phone);
        dest.writeString(this.t_time);
        dest.writeString(this.t_address);
        dest.writeString(this.t_location);
        dest.writeInt(this.t_count);
        dest.writeInt(this.c_no);
    }

    protected Tasty(Parcel in){
        this.t_no = in.readInt();
        this.t_title = in.readString();
        this.t_content = in.readString();
        this.t_date = in.readString();
        this.t_img = in.readParcelable(Bitmap.class.getClassLoader());
        this.t_phone = in.readString();
        this.t_time = in.readString();
        this.t_address = in.readString();
        this.t_location = in.readString();
        this.t_count = in.readInt();
        this.c_no = in.readInt();
    }


    public static final Creator<Tasty> CREATOR = new Creator<Tasty>() {
        @Override
        public Tasty createFromParcel(Parcel in) {
            return new Tasty(in);
        }
        @Override
        public Tasty[] newArray(int size) {
            return new Tasty[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    public Tasty() {
        // TODO Auto-generated constructor stub
    }

    public Tasty(int t_no, String t_title, String t_content, String t_date, Bitmap t_img, String t_phone, String t_time,
                 String t_address, String t_location, int t_count, int c_no) {
        super();
        this.t_no = t_no;
        this.t_title = t_title;
        this.t_content = t_content;
        this.t_date = t_date;
        this.t_img = t_img;
        this.t_phone = t_phone;
        this.t_time = t_time;
        this.t_address = t_address;
        this.t_location = t_location;
        this.t_count = t_count;
        this.c_no = c_no;
    }
    public Tasty(int t_no, String t_title, String t_content,  String t_phone, String t_time,
                 String t_address,int c_no ) {
        super();
        this.t_no = t_no;
        this.t_title = t_title;
        this.t_content = t_content;
        this.t_phone = t_phone;
        this.t_time = t_time;
        this.t_address = t_address;
        this.c_no = c_no;
    }




    public Tasty(String t_title, String t_content, Bitmap t_img, String t_phone, String t_time, String t_address,
                 int c_no) {
        super();
        this.t_title = t_title;
        this.t_content = t_content;
        this.t_img = t_img;
        this.t_phone = t_phone;
        this.t_time = t_time;
        this.t_address = t_address;
        this.c_no = c_no;
    }
    public Tasty(String t_title, String t_content, String t_phone, String t_time, String t_address,
                 int c_no) {
        super();
        this.t_title = t_title;
        this.t_content = t_content;
        this.t_phone = t_phone;
        this.t_time = t_time;
        this.t_address = t_address;
        this.c_no = c_no;
    }
    public Tasty(int t_no,String t_title, String t_content, Bitmap t_img, String t_phone, String t_time, String t_address,
                 String t_location,int c_no) {
        super();
        this.t_no = t_no;
        this.t_title = t_title;
        this.t_content = t_content;
        this.t_img = t_img;
        this.t_phone = t_phone;
        this.t_time = t_time;
        this.t_address = t_address;
        this.t_location = t_location;
        this.c_no = c_no;
    }
    public Tasty(int t_no,String t_title, String t_content,String t_date, Bitmap t_img, int t_count) {
        super();
        this.t_no = t_no;
        this.t_title = t_title;
        this.t_content = t_content;
        this.t_img = t_img;
        this.t_date = t_date;
        this.t_count = t_count;
    }
    public Tasty(int t_no, String t_title, String t_content,  Bitmap t_img, String t_phone, String t_time,
                 String t_address) {
        super();
        this.t_no = t_no;
        this.t_title = t_title;
        this.t_content = t_content;
        this.t_img = t_img;
        this.t_phone = t_phone;
        this.t_time = t_time;
        this.t_address = t_address;
    }

    public int getT_no() {
        return t_no;
    }

    public void setT_no(int t_no) {
        this.t_no = t_no;
    }

    public String getT_title() {
        return t_title;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getT_date() {
        return t_date;
    }

    public void setT_date(String t_date) {
        this.t_date = t_date;
    }

    public Bitmap getT_img() {
        return t_img;
    }

    public void setT_img(Bitmap t_img) {
        this.t_img = t_img;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_time() {
        return t_time;
    }

    public void setT_time(String t_time) {
        this.t_time = t_time;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public String getT_location() {
        return t_location;
    }

    public void setT_location(String t_location) {
        this.t_location = t_location;
    }

    public int getT_count() {
        return t_count;
    }

    public void setT_count(int t_count) {
        this.t_count = t_count;
    }

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
    }

    @Override
    public String toString() {
        return this.t_no +"  "+ this.t_title+"  "+this.t_content+"  "+this.t_date+"  "+this.t_img+"  "+this.t_phone+"  "+this.t_time+"  "+this.t_address + "  "+this.t_count+"  "+this.c_no;
    }

}