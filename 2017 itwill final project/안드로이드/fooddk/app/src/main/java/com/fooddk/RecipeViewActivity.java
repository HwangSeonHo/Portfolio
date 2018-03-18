package com.fooddk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RecipeViewActivity extends AppCompatActivity {
    TextView r_titleTV;
    TextView m_noTV;
    TextView c_noTV;
    TextView r_contentTV;
    ImageView r_imgIV;
    ConstraintLayout viewForm;
    Recipe recipe;
    String sId;

    int r_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);
        viewForm = (ConstraintLayout)findViewById(R.id.viewForm);
        r_titleTV = (TextView)viewForm.findViewById(R.id.r_titleTV);
        m_noTV = (TextView)viewForm.findViewById(R.id.m_noTV);
        c_noTV = (TextView)viewForm.findViewById(R.id.c_noTV);
        r_contentTV = (TextView)viewForm.findViewById(R.id.r_contentTV);
        r_imgIV = (ImageView)viewForm.findViewById(R.id.r_imgIV);
        sId = getIntent().getExtras().getString("sId");

        Intent recipeViewIntent = getIntent();
        recipe = (Recipe)recipeViewIntent.getParcelableExtra("recipe");
        r_no = recipe.getR_no();
        r_titleTV.setText(recipe.getR_title());
        m_noTV.setText(recipe.getM_no()+"");

        if(recipe.getC_no()==1) {
            c_noTV.setText("한식");
        }else if(recipe.getC_no()==2){
            c_noTV.setText("일식");
        }else if(recipe.getC_no()==3){
            c_noTV.setText("중식");
        }else if(recipe.getC_no()==4){
            c_noTV.setText("양식");
        }else{
            c_noTV.setText("기타");
        }

        r_contentTV.setText(recipe.getR_content());
        r_imgIV.setImageBitmap(recipe.getR_img());


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==3){
            if(resultCode==4) {
                Log.e(">>>>>>>>>>>>>>","view");
                setResult(4, new Intent());
                finish();
            }
            if(resultCode==6){
                setResult(7, new Intent());
                finish();

            }      }
    }

    public void clickListB(View v){
        setResult(3, new Intent());
        finish();
    }
    public void clickModifyB(View v){
        Intent modifyintent = new Intent();
        modifyintent.setClass(getApplicationContext(),RecipeModifyActivity.class);
        modifyintent.putExtra("recipe", recipe);
        modifyintent.putExtra("sId", sId);
        startActivityForResult(modifyintent, 3);

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
    public void clickDeleteB(View v){


        new Thread() {
            @Override
            public void run() {

                URL url = null;
                try {
                    url = new URL("http://192.168.12.17:8084/fooddk/recipe_remove_action");

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        /*
                        1.요청방식설정(GET,POST)
                         */
                    httpURLConnection.setRequestMethod("POST");

                        /*
                        2.요청헤더값을설정
                         */
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                         /*
                        3.서버로데이타를 전송설정(파라메타)
                          서버로부터오는 데이타수신설정
                         */
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    String parameter = "r_no=" + r_no;

                                   /*
                        5.서버전송출력스트림생성 파라메타전송
                        */
                    OutputStream out =
                            httpURLConnection.getOutputStream();
                        /*
                        6.요청시바디전송
                         */
                    out.write(parameter.getBytes());
                    out.close();

                    InputStream in = httpURLConnection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    StringBuffer stringBuffer = new StringBuffer();
                    while(true){
                        String readLine = br.readLine();
                        if(readLine==null)break;
                        stringBuffer.append(readLine + "\n");

                    }
                    Message message = new Message();
                    message.what=1;
                    handler.sendMessage(message);

                    Log.e("url:",url.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Message message = new Message();
                    message.what=99;
                }
            }

        }.start();

    }



    public void clickWriteB(View v){
        Intent intent = new Intent();
        intent.putExtra("sId", sId);
        intent.setClass(getApplicationContext(), RecipeWriteActivity.class);
        startActivityForResult(intent, 3);

    }
}
