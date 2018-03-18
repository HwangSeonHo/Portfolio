package com.fooddk;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by STU on 2017-09-01.
 */

public class Recipe implements Parcelable {
    private int r_no;
    private String r_title;
    private int m_no;
    private String r_content;
    private String r_date;
    private Bitmap r_img;
    private int c_no;
    private int r_count;

    public  Recipe(){

    }
    public Recipe(int r_no, String r_title, int m_no, String r_content, String r_date, Bitmap r_img, int c_no, int r_count) {
        this.r_no = r_no;
        this.r_title = r_title;
        this.m_no = m_no;
        this.r_content = r_content;
        this.r_date = r_date;
        this.r_img = r_img;
        this.c_no = c_no;
        this.r_count = r_count;
    }

    protected Recipe(Parcel in){
        this.r_no = in.readInt();
        this.r_title = in.readString();
        this.m_no = in.readInt();
        this.r_content = in.readString();
        this.r_date = in.readString();
        this.r_img = in.readParcelable(Bitmap.class.getClassLoader());
        this.c_no =in.readInt();
        this.r_count =in.readInt();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }
        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt( this.r_no);
        dest.writeString(this.r_title);
        dest.writeInt( this.m_no);
        dest.writeString(this.r_content);
        dest.writeString( this.r_date);
        dest.writeParcelable(this.r_img, flags);
        dest.writeInt(this.c_no);
        dest.writeInt( this.r_count);
    }

    public int getR_no() {
        return r_no;
    }

    public void setR_no(int r_no) {
        this.r_no = r_no;
    }

    public String getR_title() {
        return r_title;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

    public int getM_no() {
        return m_no;
    }

    public void setM_no(int m_no) {
        this.m_no = m_no;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
    }

    public String getR_date() {
        return r_date;
    }

    public void setR_date(String r_date) {
        this.r_date = r_date;
    }

    public Bitmap getR_img() {
        return r_img;
    }

    public void setR_img(Bitmap r_img) {
        this.r_img = r_img;
    }

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
    }

    public int getR_count() {
        return r_count;
    }

    public void setR_count(int r_count) {
        this.r_count = r_count;
    }
}
