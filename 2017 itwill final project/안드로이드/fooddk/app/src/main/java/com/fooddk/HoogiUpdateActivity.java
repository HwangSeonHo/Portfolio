package com.fooddk;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HoogiUpdateActivity extends AppCompatActivity {
    //private final int REQ_CODE_SELECT_IMG = 1001;

    //필요한 객체생성
    EditText h_title;
    EditText c_no;
    EditText h_content;

    String filePath = "";
    Bitmap uploadBm;

    ImageView h_img;
    int h_no;
    Hoogi updatehoogi;
    ConstraintLayout cl_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoogi_update);


        Intent intent_1=getIntent();
        //id값 불러와서 생성
        cl_2=(ConstraintLayout)findViewById(R.id.cl_2);
        h_title = (EditText) cl_2.findViewById(R.id.h_title);
        c_no = (EditText) cl_2.findViewById(R.id.c_no);
        h_content = (EditText) cl_2.findViewById(R.id.h_content);
        h_img = (ImageView) cl_2.findViewById(R.id.h_img);


        Hoogi hoogi = getIntent().getParcelableExtra("hoogi");
        h_no=hoogi.getH_no();
        h_title.setText(hoogi.getH_title());
        c_no.setText(hoogi.getC_no()+"");//번호 -> 스트링
        h_content.setText(hoogi.getH_content());

    }

    /*public void clickWriteB(View v){
        Intent dataIntent = new Intent();
        Tasty tasty = new Tasty(
                titleET.getText().toString(),
                contentET.getText().toString(),
                "img",
                phoneET.getText().toString(),
                timeET.getText().toString(),
                addressET.getText().toString(),
                Integer.parseInt(cnoET.getText().toString()));
        dataIntent.putExtra("tasty", tasty);
        setResult(RESULT_OK, dataIntent);
        finish();
    }*/
    private Handler writeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Log.e("Write 후 화면 전환", "");
                    setResult(2);
                    finish();
                    break;
                case 99:
                    Exception recvException = (Exception) msg.obj;
                    Toast.makeText(getApplicationContext(), recvException.getMessage(), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 선택된 사진을 받아 파일 이름을 저장
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                Log.e("uri", uri + "");
                Cursor c = getContentResolver().query(Uri.parse(uri.toString()), null, null, null, null);
                c.moveToNext();
                String absolutePath = c.getString(c.getColumnIndex(MediaStore.MediaColumns.DATA));
                //absolutePath = absolutePath.substring(8);

                Log.e("###URI", uri.toString());
                Log.e("###path", absolutePath);
                filePath = absolutePath;
                try {
                    uploadBm = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(uri.toString()));
                    Log.e("###uploadeBm", uploadBm + "");
                    h_img.setImageBitmap(uploadBm);
                } catch (Exception e) {
                    Toast.makeText(getApplication(), "사진 업로드 에러", Toast.LENGTH_LONG);
                }

            }
        }
    }
    //update 클릭했을 때
    public void update_click(View v) {

        //필요한 데이터값불러오기
        updatehoogi = new Hoogi(h_no,h_title.getText().toString().trim(), h_content.getText().toString().trim(), Integer.parseInt(c_no.getText().toString()));
        Log.e("##",updatehoogi.toString());

        new

                Thread() {
                    @Override
                    public void run() {

                        try {
                            new Thread() {
                                @Override
                                public void run() {
                                    HttpURLConnection conn = null;
                                    DataOutputStream dos = null;
                                    DataInputStream inStream = null;
                                    String existingFileName = filePath;
                                    String lineEnd = "\r\n";
                                    String twoHyphens = "--";
                                    String boundary = "*****";
                                    int bytesRead, bytesAvailable, bufferSize;
                                    byte[] buffer;
                                    int maxBufferSize = 1 * 1024 * 1024;
                                    String responseFromServer = "";
                                    String urlString = "http://192.168.12.17:8084/fooddk/HoogiUpdateAction_2";

                                    try {
                                        //------------------ CLIENT REQUEST
                                        FileInputStream fileInputStream;
                                        try {
                                            fileInputStream = new FileInputStream(new File(existingFileName));
                                        }catch(Exception e){
                                            fileInputStream=null;
                                        }
                                        // open a URL connection to the Servlet
                                        URL url = new URL(urlString);
                                        // Open a HTTP connection to the URL
                                        conn = (HttpURLConnection) url.openConnection();
                                        // Allow Inputs
                                        conn.setDoInput(true);
                                        // Allow Outputs
                                        conn.setDoOutput(true);
                                        // Don't use a cached copy.
                                        conn.setUseCaches(false);
                                        // Use a post method.
                                        conn.setRequestMethod("POST");
                                        conn.setRequestProperty("Connection", "Keep-Alive");
                                        conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                                        dos = new DataOutputStream(conn.getOutputStream());

                                        dos.writeBytes(twoHyphens + boundary + lineEnd);
                                        dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + existingFileName + "\"" + lineEnd);
                                        dos.writeBytes(lineEnd);

                                        if(fileInputStream!=null) {
                                            // create a buffer of maximum size
                                            bytesAvailable = fileInputStream.available();
                                            bufferSize = Math.min(bytesAvailable, maxBufferSize);
                                            buffer = new byte[bufferSize];
                                            // read file and write it into form...
                                            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

                                            while (bytesRead > 0) {

                                                dos.write(buffer, 0, bufferSize);
                                                bytesAvailable = fileInputStream.available();
                                                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                                                bytesRead = fileInputStream.read(buffer, 0, bufferSize);

                                            }
                                        }
                                /*String paramters =
                                        "r_title=" + addRecipe.getR_title() +
                                                "&r_content=" + addRecipe.getR_content() +
                                                "&c_no=" + addRecipe.getC_no() +
                                                "&sId=" + "sun";
                                dos.write(paramters.getBytes());*/

                              /*  "t_title=" + tasty_title + "&" +
                                        "t_content=" + tasty_content + "&" +
                                        "t_time=" + tasty_time + "&" +
                                        "t_img=" + tasty_img + "&" +
                                        "t_phone=" + tasty_phone + "&" +
                                        "t_address=" + tasty_address + "&" +
                                        "c_no=" + tasty_cno;*/
                                        dos.writeBytes("\r\n--" + boundary + "\r\n");
                                        dos.writeBytes("Content-Disposition: form-data; name=\"h_no\"\r\n\r\n" + updatehoogi.getH_no());

                                        /*
                                        dos.writeBytes("\r\n--" + boundary + "\r\n");
                                        dos.writeBytes("Content-Disposition: form-data; name=\"t_no\"\r\n\r\n" + updatehoogi.getT_no());
                                        dos.writeBytes("\r\n--" + boundary + "\r\n");
                                        dos.writeBytes("Content-Disposition: form-data; name=\"m_no\"\r\n\r\n" + updatehoogi.getM_no());
*/
                                        dos.writeBytes("\r\n--" + boundary + "\r\n");
                                        dos.writeBytes("Content-Disposition: form-data; name=\"h_title\"\r\n\r\n");
                                        dos.writeUTF(updatehoogi.getH_title());
                                        dos.writeBytes("\r\n--" + boundary + "\r\n");
                                        dos.writeBytes("Content-Disposition: form-data; name=\"h_content\"\r\n\r\n");
                                        dos.writeUTF(updatehoogi.getH_content());

                                        dos.writeBytes("\r\n--" + boundary + "\r\n");
                                        dos.writeBytes("Content-Disposition: form-data; name=\"h_img\"\r\n\r\n" + updatehoogi.getH_img());


                                        dos.writeBytes("\r\n--" + boundary + "\r\n");
                                        dos.writeBytes("Content-Disposition: form-data; name=\"c_no\"\r\n\r\n" + updatehoogi.getC_no());
                                /*dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"sId\"\r\n\r\n" + "sun");*/

                                        // send multipart form data necesssary after file data...
                                        dos.writeBytes(lineEnd);
                                        dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

                                        // close streams
                                        Log.e("Debug", "File is written");
                                        if(fileInputStream!=null) {
                                            fileInputStream.close();
                                        }
                                        dos.flush();
                                        dos.close();

                                    } catch (MalformedURLException ex) {
                                        Log.e("Debug", "error: " + ex.getMessage(), ex);
                                    } catch (IOException ioe) {
                                        Log.e("Debug", "error: " + ioe.getMessage(), ioe);
                                    }

                                    //------------------ read the SERVER RESPONSE
                                    try {
                                        inStream = new DataInputStream(conn.getInputStream());
                                        String str;

                                        while ((str = inStream.readLine()) != null) {
                                            Log.e("Debug", "Server Response " + str);
                                        }
                                        inStream.close();

                                        Message message = new Message();
                                        message.what = 1;
                                        writeHandler.sendMessage(message);

                                    } catch (IOException ioex) {
                                        Log.e("Debug", "error: " + ioex.getMessage(), ioex);
                                    }
                                }
                            }.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

    }

    public void menuclick(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    //파일업로드
    public void uploadClick(View v) {
        getGallery();
    }

    private void getGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Log.e("getGallery", "1  ");
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    /*public void joinclick(View v){
      *//*  Intent intent = new Intent();
        intent.setClass(getApplicationContext(),MainActivity.class);
        startActivityForResult(intent,1);*//*
      finish();
    }*/
}
