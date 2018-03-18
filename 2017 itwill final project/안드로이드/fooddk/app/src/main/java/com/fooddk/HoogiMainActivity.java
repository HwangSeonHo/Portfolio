package com.fooddk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HoogiMainActivity extends AppCompatActivity {
    ArrayList<Hoogi> globalHoogiList = new ArrayList<Hoogi>();
    HoogiAdapter hoogiAdapter;
    ListView hoogiListView;
    TextView h_no;
    TextView h_title;
    TextView h_count;
    TextView c_no;

    String sId;

    /**************************/
    public class HoogiAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return globalHoogiList.size();
        }

        @Override
        public Hoogi getItem(int position) {
            return globalHoogiList.get(position);
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //뷰 후기리스트 받아오기
            View view = getLayoutInflater().inflate(R.layout.activity_hoogi_list_child, null);
            //필요한 객체선언, 값 찾아 넣어주기
            //먼저 디자인에 있는 ID값 넣어주고 하기
            TextView h_no = (TextView) view.findViewById(R.id.h_no);
            TextView h_title = (TextView) view.findViewById(R.id.h_title);
            TextView h_count = (TextView) view.findViewById(R.id.h_count);
            TextView c_no = (TextView) view.findViewById(R.id.c_no);
            Hoogi hoogi = this.getItem(position);

            h_no.setText(hoogi.getH_no() + "");
            h_title.setText(hoogi.getH_title());
            h_count.setText("[" + hoogi.getH_count() + "]");
            c_no.setText("[" + hoogi.getC_no() + "]");

            return view;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == 3){
            new Thread(){
                @Override
                public void run() {
                    //getXMLGuestList();
                    getJSONHoogiList();
                }
            }.start();
            hoogiAdapter.notifyDataSetChanged();
        }
    }

    /**************************/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoogi_main);
        h_no = (TextView) findViewById(R.id.h_no);
        h_title = (TextView) findViewById(R.id.h_title);
        h_count = (TextView) findViewById(R.id.h_count);
        c_no = (TextView) findViewById(R.id.c_no);
        hoogiAdapter = new HoogiAdapter();
        hoogiListView = (ListView) findViewById(R.id.hoogiListView);
        hoogiListView.setAdapter(hoogiAdapter);
        sId = getIntent().getExtras().getString("sId");

        hoogiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //리스트뷰 클릭되었을 때 발생하는 이벤트
                Hoogi hoogi_view =
                        (Hoogi) hoogiListView.getItemAtPosition(position);
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), HoogiViewActivity.class);
                intent.putExtra("hoogi", hoogi_view);
                intent.putExtra("sId", sId);
                startActivityForResult(intent,0);

            }
        });
        //쓰레드 주기
        new Thread() {
            @Override
            public void run() {
                getJSONHoogiList();
            }
        }.start();
    }

    private Handler hoogiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    ArrayList<Hoogi> recvHoogiList1 = (ArrayList<Hoogi>) msg.obj;
                    globalHoogiList = recvHoogiList1;
                    hoogiAdapter.notifyDataSetChanged();    //데이터바뀐거알려주기
                    setTitle("XML DATA");
                    break;
                case 1:
                    ArrayList<Hoogi> recvHoogiList2 = (ArrayList<Hoogi>) msg.obj;
                    globalHoogiList = recvHoogiList2;
                    hoogiAdapter.notifyDataSetChanged();    //데이터바뀐거알려주기
                    setTitle("JSON DATA");
                    break;
                case 99:
                    Exception recvException = (Exception) msg.obj;
                    Toast.makeText(getApplicationContext(), recvException.getMessage(), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    private void getJSONHoogiList() {
        /*
        JSON(JavaScript Object Notation)
         */
        //제이슨 형식으로 뿌리기
        ArrayList<Hoogi> localHoogiList = new ArrayList<Hoogi>();
        try {
            String hoogi_list_urlStr = "http://192.168.12.17:8084/fooddk/HoogiList_2";
            URL hoogi_list_url = new URL(hoogi_list_urlStr);
            //Connection 걸어서 열기
            HttpURLConnection httpConnection = (HttpURLConnection) hoogi_list_url.openConnection();
            httpConnection.setRequestMethod("GET");
            InputStream in = httpConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String jsonStr = "";
            while (true) {
                String readLine = br.readLine();
                if (readLine == null) break;
                jsonStr += readLine + "\n";
            }
            Log.e("jsonStr", jsonStr);

            /*
            [                           array
                {                       object
                    "guest_no": "84",
                    "guest_name": "ㄹㅇㅇㅇㅇ",
                    "guest_date": "2017-06-17",
                    "guest_email": "ㅇㅇㄹㅇㄴㄹ",
                    "guest_title": "ㅇㅇ ㅇㄴㄹ",
                    "guest_content": "ㅇㅇㅇㅇㄴㄹㅇㄴㄹㅇㄴ"
                }
            ]
             */
            JSONArray hoogiJsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < hoogiJsonArray.length(); i++) {
                JSONObject hoogiJsonObject = hoogiJsonArray.getJSONObject(i);
                String h_no = hoogiJsonObject.getString("h_no");
                String h_title = hoogiJsonObject.getString("h_title");
                String h_content = hoogiJsonObject.getString("h_content");
                //String h_date = guestJsonObject.getString("h_date");
                //  String h_img = hoogiJsonObject.getString("h_img");
                String h_count = hoogiJsonObject.getString("h_count");
                String c_no = hoogiJsonObject.getString("c_no");
                //  String t_no = guestJsonObject.getString("t_no");
                // String m_no = guestJsonObject.getString("m_no");
                /*int t_no = guestJsonObject.getInt("t_no");
                int m_no = guestJsonObject.getInt("m_no");*/
                //String h_img=);
                String image_urlStr = "http://192.168.12.17:8084/fooddk/"+hoogiJsonObject.getString("h_img");
                // String image_urlStr = "http://192.168.12.17:8084/fooddk/images/ball.jpg";
                // String image_urlStr = "http://192.168.12.17:8084/fooddk/images/" + hoogiJsonObject.getString("h_img");
               // HttpURLConnection hoogiUrlConnection = (HttpURLConnection) hoogiUrl.openConnection();
                URL hoogiUrl;
                Bitmap imagebitmap;
                Bitmap h_img;

                try {
                    hoogiUrl = new URL("http://192.168.12.17:8084/fooddk/"+hoogiJsonObject.getString("h_img"));
                    InputStream imageInputStream = hoogiUrl.openStream();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    // 1/N
                    options.inSampleSize = 4;
                    imagebitmap= BitmapFactory.decodeStream(imageInputStream,null,options);
                    h_img = imagebitmap;
                }catch (Exception e) {
                    hoogiUrl = new URL("http://192.168.12.17:8084/fooddk/images/default.jpg");
                    InputStream imageInputStream = hoogiUrl.openStream();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    // 1/N
                    options.inSampleSize = 4;
                    imagebitmap=BitmapFactory.decodeStream(imageInputStream,null,options);
                    h_img = imagebitmap;

                }


                localHoogiList.add(new Hoogi(Integer.parseInt(h_no), h_title, h_content,
                        h_img, Integer.parseInt(h_count), Integer.parseInt(c_no)));
            }//end for

            Message message = new Message();
            message.what = 1;
            message.obj = localHoogiList;
            hoogiHandler.sendMessage(message);


        } catch (Exception e) {
            Message message = new Message();
            message.what = 99;
            message.obj = e;
            hoogiHandler.sendMessage(message);
            e.getStackTrace();
        }
    }


        /*//인텐트 주어서 다음값받아오게 하기

        public void buttonClick(View v) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), activity_hoogi_view.class);
*/

}


//end class


//end getJSONGuestList method

    /*private void getXMLGuestList(){
        ArrayList<Guest> localGuestList = new ArrayList<Guest>();
        try {
            String guest_list_urlStr = "http://210.16.214.203/guest_android/guest_list_xml.jsp";
            URL guest_list_url = new URL(guest_list_urlStr);
            HttpURLConnection httpConnection = (HttpURLConnection) guest_list_url.openConnection();
            httpConnection.setRequestMethod("GET");
            InputStream in = httpConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            *//*
            1.DOM Parser 객체 생성
             *//*
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder domParser = documentBuilderFactory.newDocumentBuilder();
            *//*
            2.DOM Tree 생성
             *//*
            //Document document = domParser.parse(in);    //in을 써도 넘어가나 한글 인코딩이 안됨
            InputSource inputSource = new InputSource(br);
            Document document = domParser.parse(inputSource);
            *//*
            <guest_list>
                <guest>
                    <guest_no>84</guest_no>
                    <guest_name>ㄹㅇㅇㅇㅇ</guest_name>
                    <guest_date>2017-06-17 14:55:42</guest_date>
                    <guest_email>ㅇㅇㄹㅇㄴㄹ</guest_email>
                    <guest_homepage>ㅇㅇㄹㅇㄴㄹ</guest_homepage>
                    <guest_title>ㅇㅇ ㅇㄴㄹ</guest_title>
                    <guest_content>ㅇㅇㅇㅇㄴㄹㅇㄴㄹㅇㄴ</guest_content>
                </guest>
            </guest_list>
            *//*
            NodeList guestNL = document.getElementsByTagName("guest");
            for(int i=0; i<guestNL.getLength();i++){
                Element guestE = (Element)guestNL.item(i);
                *//*
                엘레멘트 속성 얻기
                <guest no="34">
                String attr_data = guestE.getAttribute("guest_no");
                *//*
                NodeList guest_noNL = guestE.getElementsByTagName("guest_no");
                Element guest_noE = (Element)guest_noNL.item(0);
                Text guest_noT = (Text) guest_noE.getFirstChild();
                String guest_noStr = guest_noT.getNodeValue();

                String guest_nameStr = guestE.getElementsByTagName("guest_name").item(0).getFirstChild().getNodeValue();
                String guest_dateStr = guestE.getElementsByTagName("guest_date").item(0).getFirstChild().getNodeValue();
                String guest_titleStr = guestE.getElementsByTagName("guest_title").item(0).getFirstChild().getNodeValue();
                Log.e("guest_no : ",guest_noStr);
                Log.e("guest_name : ",guest_nameStr);
                Log.e("guest_date : ",guest_dateStr);
                Log.e("guest_title : ",guest_titleStr);
                localGuestList.add(new Guest(Integer.parseInt(guest_noStr),guest_nameStr,guest_dateStr
                        ,null,null,guest_titleStr,null));
            }//end for

            Message message = new Message();
            message.what=0;
            message.obj=localGuestList;
            guestHandler.sendMessage(message);


        }catch (Exception e){
            e.getStackTrace();
        }
    }*/
