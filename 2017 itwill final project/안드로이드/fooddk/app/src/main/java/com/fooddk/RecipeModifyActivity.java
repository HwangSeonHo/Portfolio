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

public class RecipeModifyActivity extends AppCompatActivity {

    EditText r_titleET;
    EditText r_contentET;
    EditText c_noET;
    ImageView r_imgIV;

    ConstraintLayout modifyForm;

    Recipe addRecipe= new Recipe();

    String filePath="";
    Bitmap uploadBm;
    String sId;

    private final int REQ_CODE_SELECT_IMAGE = 1002;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_modify);
        modifyForm = (ConstraintLayout) findViewById(R.id.modifyForm);
        r_titleET = (EditText)modifyForm.findViewById(R.id.r_titleET);
        r_contentET = (EditText)modifyForm.findViewById(R.id.r_contentET);
        c_noET = (EditText)modifyForm.findViewById(R.id.c_noET);
        r_imgIV = (ImageView)modifyForm.findViewById(R.id.r_imgIV);

        Intent modifyIntent = getIntent();
        Recipe recipe = (Recipe)modifyIntent.getParcelableExtra("recipe");
        addRecipe.setR_no(recipe.getR_no());
        r_titleET.setText(recipe.getR_title().trim());
        r_contentET.setText(recipe.getR_content().trim());
        c_noET.setText(recipe.getC_no()+"");

        sId = getIntent().getExtras().getString("sId");

    }

    private Handler modifyHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Log.e("Write 후 화면 전환","");
                    setResult(6, new Intent());
                    finish();
                    break;
                case 99:
                    Exception recvException=(Exception) msg.obj;
                    Toast.makeText(getApplicationContext(), recvException.getMessage(), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 선택된 사진을 받아 파일 이름을 저장
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();

                Cursor c = getContentResolver().query(Uri.parse(uri.toString()), null,null,null,null);
                c.moveToNext();
                String absolutePath = c.getString(c.getColumnIndex(MediaStore.MediaColumns.DATA));
                //absolutePath = absolutePath.substring(8);가상폰에서 쓸때

                Log.e("###URI",uri.toString());
                Log.e("###path",absolutePath);
                filePath = absolutePath;
                try {
                    uploadBm = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(uri.toString()));
                    r_imgIV.setImageBitmap(uploadBm);
                }catch (Exception e){
                    Toast.makeText(getApplication(),"사진 업로드 에러",Toast.LENGTH_LONG);
                }

            }
        }
    }

    public void clickModifyB(View v){

        addRecipe.setR_title(r_titleET.getText().toString().trim());
        addRecipe.setR_content(r_contentET.getText().toString().trim());
        if(c_noET.getText().toString().trim()=="한식") {
            addRecipe.setC_no(1);
        }else if(c_noET.getText().toString().trim()=="일식"){
            addRecipe.setC_no(2);
        }else if(c_noET.getText().toString().trim()=="중식"){
            addRecipe.setC_no(3);
        }else if(c_noET.getText().toString().trim()=="양식"){
            addRecipe.setC_no(4);
        }else{
            addRecipe.setC_no(5);
        }
        Log.e("title",addRecipe.getR_title());
        if(uploadBm!=null) {
            addRecipe.setR_img(uploadBm);
        }

        new Thread(){
            @Override
            public void run() {

                try {
                    new Thread(){
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
                            String urlString = "http://192.168.12.17:8084/fooddk/android_modify";
                            Log.e(">>>>>>>>>>>", filePath);

                            try{
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

                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"r_no\"\r\n\r\n" + addRecipe.getR_no());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"r_title\"\r\n\r\n");
                                dos.writeUTF(addRecipe.getR_title());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"r_content\"\r\n\r\n");
                                dos.writeUTF(addRecipe.getR_content());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"c_no\"\r\n\r\n" + addRecipe.getC_no());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"sId\"\r\n\r\n" + sId);

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
                                message.what=1;
                                modifyHandler.sendMessage(message);

                            } catch (IOException ioex) {
                                Log.e("Debug", "error: " + ioex.getMessage(), ioex);
                            }
                        }
                    }.start();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void clickImageB(View v){
        getGallery();
    }

    private void getGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        intent.setType("image/*");
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
    }
    public void clickListB(View v){
        finish();
    }
}