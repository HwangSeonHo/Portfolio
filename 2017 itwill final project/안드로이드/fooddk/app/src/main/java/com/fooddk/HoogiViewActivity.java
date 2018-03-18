package com.fooddk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HoogiViewActivity extends AppCompatActivity {

    public static final String HOOGI_REMOVE_URL="http://192.168.12.17:8084/fooddk/HoogiRemoveAction_2";

    ImageView h_img;
    TextView h_no;
    TextView h_title;
    TextView h_count;
    TextView c_no;
    ConstraintLayout cl;

    Intent recvIntent;
    Hoogi hoogiIntent;

    String sId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoogi_view);
        cl=(ConstraintLayout)findViewById(R.id.view_form);
        h_img=(ImageView)cl.findViewById(R.id.h_img);
        h_no=(TextView)cl.findViewById(R.id.h_no);
        h_title=(TextView)cl.findViewById(R.id.h_title);
        h_count=(TextView)cl.findViewById(R.id.h_count);
        c_no=(TextView)cl.findViewById(R.id.c_no);

        sId = getIntent().getExtras().getString("sId");

        //인텐트 받아오기
        recvIntent = getIntent();
        hoogiIntent = recvIntent.getParcelableExtra("hoogi");

        //Log.e("sssssssssssss",hoogiIntent.getH_title());
        //int값은 ""필요
        h_no.setText(hoogiIntent.getH_no()+"");
        h_title.setText(hoogiIntent.getH_title());
        h_count.setText(hoogiIntent.getH_count()+"");
        c_no.setText(hoogiIntent.getC_no()+"");
        h_img.setImageBitmap(hoogiIntent.getH_img());
        // processIntent(recvIntent);
    }



    //리스트뒤로가기
    public void Listbuttonclick(View v){
      /*  Intent intent = new Intent();
        intent.setClass(getApplicationContext(), MainActivity.class);*/
        setResult(3);
        finish();
        //startActivityForResult(intent,R.layout.activity_hoogi_list_child);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==2){
            setResult(3);
            finish();
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                setResult(3, new Intent());
                finish();
            }else if(msg.what==99){

            }
        }

    };

    //글쓰기
    public void writeclick(View v){
        Intent intent = new Intent();
        intent.putExtra("sId",sId);
        intent.setClass(getApplicationContext(), HoogiWriteActivity.class);
        startActivityForResult(intent,1);
    }

    ///수정
    public void updateclick(View v){

        /*Hoogi activity_hoogi_view =
                (Hoogi) hoogiListView.getItemAtPosition(position);
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), activity_hoogi_view.class);
        intent.putExtra("hoogi", activity_hoogi_view);
        startActivityForResult(intent,0);
*/


        Intent intent_1 = new Intent();
        intent_1.setClass(getApplicationContext(), HoogiUpdateActivity.class);
        intent_1.putExtra("hoogi",hoogiIntent);
        intent_1.putExtra("sId",sId);

        startActivityForResult(intent_1,1);
    }



    //삭제버튼 누르면 컨트롤러 -> 처리


    public void buttonClick(View v){
        int id =v.getId();
        Log.e("id",id+"");
        //closeButton.setOnClickListener(this);


        if(id==R.id.closeButton){
            setTitle("REMOVE");

            new Thread(){
                @Override
                public void run() {
                    try {
                        if (hoogiIntent == null)
                            throw new Exception("hoogi 눌러라");
                        String parameter = "?h_no=" + hoogiIntent.getH_no();
                        URL url = new URL(HOOGI_REMOVE_URL + parameter);
                        Log.e("url",url+"");
                        HttpURLConnection httpURLConnection =
                                (HttpURLConnection) url.openConnection();
                        /*
                        1.요청방식설정(GET,POST)
                         */
                        httpURLConnection.setRequestMethod("POST");
                        /*
                        2.요청헤더값을설정
                         */
                        httpURLConnection
                                .setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        /*
                        3.서버로데이타를 전송설정(파라메타)
                          서버로부터오는 데이타수신설정
                         */
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        /*
                        7.서버응답데이타읽기
                         */
                        InputStream in =
                                httpURLConnection.getInputStream();
                        BufferedReader br =
                                new BufferedReader(
                                        new InputStreamReader(in, "EUC-KR"));
                        StringBuffer stringBuffer =
                                new StringBuffer();
                        while (true) {
                            String readLine = br.readLine();
                            if (readLine == null) break;
                            stringBuffer.append(readLine + "\n");
                        }

                        Message message = new Message();

                        message.what = 1;
                        handler.sendMessage(message);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }.start();
            // finish();
            //setContentView(R);


        }


    }



}