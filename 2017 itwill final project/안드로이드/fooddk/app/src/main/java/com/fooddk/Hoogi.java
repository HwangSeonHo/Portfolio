package com.fooddk;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by STU on 2017-09-02.
 */

public class Hoogi implements Parcelable {

    private int h_no;
    private String h_title;
    private String h_content;
    private String h_date;
    private Bitmap h_img;
    private int h_count;

    private int t_no;
    private int c_no;
    private int m_no;


    public Hoogi(int h_no, String h_title, String h_content, String h_date, Bitmap h_img, int h_count, int t_no, int c_no,
                 int m_no) {
        super();
        this.h_no = h_no;
        this.h_title = h_title;
        this.h_content = h_content;
        this.h_date = h_date;
        this.h_img = h_img;
        this.h_count = h_count;
        this.t_no = t_no;
        this.c_no = c_no;
        this.m_no = m_no;
    }


    public Hoogi() {
        // 디폴트생성자
    }

    // 전체 생성자
    public Hoogi(int h_no, String h_title, String h_content, String h_date, Bitmap h_img, int h_count) {
        super();
        this.h_no = h_no;
        this.h_title = h_title;
        this.h_content = h_content;
        this.h_date = h_date;
        this.h_img = h_img;
        this.h_count = h_count;
    }

    public Hoogi(int h_no, String h_title, String h_content, Bitmap h_img, int h_count) {
        super();
        this.h_no = h_no;
        this.h_title = h_title;
        this.h_content = h_content;
        // this.h_date = h_date;
        this.h_img = h_img;
        this.h_count = h_count;
    }

    public Hoogi(int h_no, String h_title, String h_content, Bitmap h_img, int h_count, int c_no) {
        super();
        this.h_no = h_no;
        this.h_title = h_title;
        this.h_content = h_content;
        // this.h_date = h_date;
        this.h_img = h_img;
        this.h_count = h_count;
        this.c_no = c_no;
    }
    public Hoogi(int h_no, String h_title, String h_content, int c_no) {
        super();
        this.h_no = h_no;
        this.h_title = h_title;
        this.h_content = h_content;
        // this.h_date = h_date;
        // this.h_img = h_img;
        // this.h_count = h_count;
        this.c_no = c_no;
    }






    // insert 일단지움
/*    public Hoogi(String h_title, String h_content, Bitmap h_img, int h_count) {
        super();

        this.h_title = h_title;
        this.h_content = h_content;
        //this.h_date = h_date;
        this.h_img = h_img;
        this.h_count = h_count;
    }*/

    public Hoogi(String h_title, String h_content, Bitmap h_img, int c_no) {
        super();

        this.h_title = h_title;
        this.h_content = h_content;

        this.h_img = h_img;
        this.c_no=c_no;

    }


    public Hoogi(String h_title, String h_content,int c_no) {
        super();

        this.h_title = h_title;
        this.h_content = h_content;


        this.c_no=c_no;

    }


    public Hoogi(String h_title, String h_content, String h_date, Bitmap h_img, int h_count, int c_no) {
        super();

        this.h_title = h_title;
        this.h_content = h_content;
        this.h_date = h_date;
        this.h_img = h_img;
        this.h_count = h_count;
        this.c_no = c_no;
    }

    public Hoogi(String h_title, String h_content, Bitmap h_img) {
        super();

        this.h_title = h_title;
        this.h_content = h_content;
        // this.h_date = h_date;
        this.h_img = h_img;
        // this.h_count = h_count;
    }



    // update
    public Hoogi(String h_title, String h_content, Bitmap h_img, int h_count, int h_no) {
        super();

        this.h_title = h_title;
        this.h_content = h_content;

        this.h_img = h_img;
        this.h_count = h_count;
        this.h_no = h_no;
    }


    protected Hoogi(Parcel in) {
        this.h_no = in.readInt();
        this.h_title = in.readString();
        this.m_no = in.readInt();
        this.h_content = in.readString();
        this.h_date = in.readString();
        this.h_img = in.readParcelable(Bitmap.class.getClassLoader());
        this.c_no = in.readInt();
        this.h_count = in.readInt();
    }

    public static final Creator<Hoogi> CREATOR = new Creator<Hoogi>() {
        @Override
        public Hoogi createFromParcel(Parcel in) {
            return new Hoogi(in);
        }

        @Override
        public Hoogi[] newArray(int size) {
            return new Hoogi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.h_no);
        dest.writeString(this.h_title);
        dest.writeInt(this.m_no);
        dest.writeString(this.h_content);
        dest.writeString(this.h_date);
        dest.writeParcelable(this.h_img, flags);
        dest.writeInt(this.c_no);
        dest.writeInt(this.h_count);
    }

    public int getH_no() {
        return h_no;
    }

    public void setH_no(int h_no) {
        this.h_no = h_no;
    }

    public String getH_title() {
        return h_title;
    }

    public void setH_title(String h_title) {
        this.h_title = h_title;
    }

    public String getH_content() {
        return h_content;
    }

    public void setH_content(String h_content) {
        this.h_content = h_content;
    }

    public String getH_date() {
        return h_date;
    }

    public void setH_date(String h_date) {
        this.h_date = h_date;
    }

    public Bitmap getH_img() {
        return h_img;
    }

    public void setH_img(Bitmap h_img) {
        this.h_img = h_img;
    }

    public int getH_count() {
        return h_count;
    }

    public void setH_count(int h_count) {
        this.h_count = h_count;
    }

    public int getT_no() {
        return t_no;
    }

    public void setT_no(int t_no) {
        this.t_no = t_no;
    }

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
    }

    public int getM_no() {
        return m_no;
    }

    public void setM_no(int m_no) {
        this.m_no = m_no;
    }

    @Override
    public String toString() {
        // System.out.println(h_no+"/t"+h_title+"/t"+h_content+"/t"+h_date+"+"+h_img+"/t"+h_count);
        return h_no + "\t" + h_title + "\t" + h_content + "\t" + h_date + "\t" + h_img + "\t" + h_count;
    }

}
