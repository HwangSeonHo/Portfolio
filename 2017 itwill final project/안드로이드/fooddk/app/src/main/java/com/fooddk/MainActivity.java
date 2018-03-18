package com.fooddk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText idET;
    EditText passET;
    Button loginB;
    Button cancelB;
    String loginId="";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"맛집");
        menu.add(0,2,0,"후기");
        menu.add(0,3,0,"레시피");
        menu.add(0,4,0,"내정보");
        menu.add(0,99,0,"종료");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();

        if(itemID == 99)
            finish();

        if(loginId == null || loginId.equals("")) {
            Toast.makeText(getApplicationContext(),"로그인이 필요한 기능입니다.", Toast.LENGTH_LONG).show();
            return false;
        }

        switch (itemID){
            case 1:
                Intent tastyIntent = new Intent();
                tastyIntent.setClass(getApplicationContext(),TastyMainActivity.class);
                tastyIntent.putExtra("sId",loginId);
                startActivity(tastyIntent);
                break;
            case 2:
                Intent hoogiIntent = new Intent();
                hoogiIntent.setClass(getApplicationContext(),HoogiMainActivity.class);
                hoogiIntent.putExtra("sId",loginId);
                startActivity(hoogiIntent);
                break;
            case 3:
                Intent recipeIntent = new Intent();
                recipeIntent.setClass(getApplicationContext(),RecipeMainActivity.class);
                Log.e("MainsId:",loginId);
                recipeIntent.putExtra("sId",loginId);
                startActivity(recipeIntent);
                break;
            case 4:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idET = (EditText)findViewById(R.id.idET);
        passET = (EditText)findViewById(R.id.passET);
        loginB = (Button)findViewById(R.id.loginB);
        cancelB = (Button)findViewById(R.id.cancelB);

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            if(msg.what==0) {               //login
                String loginMsg = (String) msg.obj;
                Log.e("loginMsg.obj",loginMsg);
                if (loginMsg.trim().equals("success")) {
                    loginId = idET.getText().toString();
                    Toast.makeText(getApplicationContext(),"로그인 성공 : "+loginId, Toast.LENGTH_LONG).show();
                    idET.setVisibility(View.INVISIBLE);
                    passET.setVisibility(View.INVISIBLE);
                    loginB.setVisibility(View.INVISIBLE);
                    cancelB.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(),"로그인 실패, 웹사이트에서 ID를 찾아 주세요", Toast.LENGTH_LONG).show();
                }
            }
        }
    };

    public void clickLoginB(View v){

        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.12.17:8084/fooddk/login_action_android");
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
                        4.파라메타설정
                         */
                    String id = idET.getText().toString();
                    String pass = passET.getText().toString();
                    Log.e("id",id);
                    Log.e("pass",pass);

                    String paramters =
                            "id=" +id+ "&pass=" +pass;
                        /*
                        5.서버전송출력스트림생성 파라메타전송
                        */
                    OutputStream out =
                            httpURLConnection.getOutputStream();
                        /*
                        6.요청시바디전송
                         */
                    out.write(paramters.getBytes());
                    out.close();
                        /*
                        7.서버응답데이타읽기
                         */
                    InputStream in =
                            httpURLConnection.getInputStream();
                    BufferedReader br =
                            new BufferedReader(
                                    new InputStreamReader(in));
                    StringBuffer stringBuffer =
                            new StringBuffer();
                    while (true) {
                        String readLine = br.readLine();
                        if (readLine == null) break;
                        stringBuffer.append(readLine + "\n");
                    }
                    Message message = new Message();
                    message.what = 0;
                    message.obj = stringBuffer.toString();
                    Log.e("response",stringBuffer.toString());
                    handler.sendMessage(message);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void clickCancelB(View v){
        idET.setText("");
        passET.setText("");
    }

}
