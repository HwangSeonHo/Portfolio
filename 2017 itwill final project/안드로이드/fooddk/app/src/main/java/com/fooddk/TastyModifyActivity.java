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
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TastyModifyActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private final int REQ_CODE_SELECT_IMAGE = 1001;
    EditText phoneET;
    EditText contentET;
    EditText addressET;
    EditText timeET;
    EditText titleET;
    RadioGroup cnoRG;
    ImageView imgIV;
    String filePath="";
    Bitmap uploadBm;
    Tasty updatetasty;
    Tasty tasty;
    int cno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasty_modify);
        ScrollView writeLayout = (ScrollView) findViewById(R.id.writeLayout);
        phoneET = ((EditText)writeLayout.findViewById(R.id.insert_phoneET));
        contentET = ((EditText)writeLayout.findViewById(R.id.insert_contentET));
        addressET =  ((EditText)writeLayout.findViewById(R.id.insert_addressET));
        timeET =  ((EditText)writeLayout.findViewById(R.id.insert_timeET));
        titleET =  ((EditText)writeLayout.findViewById(R.id.insert_titleET));
        cnoRG = ((RadioGroup)writeLayout.findViewById(R.id.insert_cno));
        imgIV = ((ImageView)writeLayout.findViewById(R.id.imgIV));


        tasty = getIntent().getParcelableExtra("tasty");
        Log.e("###tasty",tasty.toString());
        phoneET.setText(tasty.getT_title());
        contentET.setText(tasty.getT_content());
        addressET.setText(tasty.getT_address());
        timeET.setText(tasty.getT_time());
        titleET.setText(tasty.getT_title());
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if(cnoRG.getCheckedRadioButtonId() == R.id.insert_cno1){
            cno = 1;
        }else if(cnoRG.getCheckedRadioButtonId() == R.id.insert_cno2){
            cno = 2;
        }else if(cnoRG.getCheckedRadioButtonId() == R.id.insert_cno3){
            cno = 3;
        }else if(cnoRG.getCheckedRadioButtonId() == R.id.insert_cno4){
            cno = 4;
        }
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
    private Handler writeHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Log.e("Write 후 화면 전환","");
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
            if (resultCode == Activity.RESULT_OK){
                Uri uri = data.getData();
                Log.e("uri",uri+"");
                Cursor c = getContentResolver().query(Uri.parse(uri.toString()), null,null,null,null);
                c.moveToNext();
                String absolutePath = c.getString(c.getColumnIndex(MediaStore.MediaColumns.DATA));
                //absolutePath = absolutePath.substring(8);

                Log.e("###URI",uri.toString());
                Log.e("###path",absolutePath);
                filePath = absolutePath;
                try {
                    uploadBm = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(uri.toString()));
                    Log.e("###uploadeBm",uploadBm+"");
                    imgIV.setImageBitmap(uploadBm);
                }catch (Exception e){
                    Toast.makeText(getApplication(),"사진 업로드 에러",Toast.LENGTH_LONG);
                }

            }
        }
    }
    public void clickWriteB(View v){
        updatetasty = new Tasty(
                tasty.getT_no(),
                titleET.getText().toString().trim(),
                contentET.getText().toString().trim(),
                phoneET.getText().toString().trim(),
                timeET.getText().toString().trim(),
                addressET.getText().toString().trim(),
                cno);
        Log.e("###updateTasty",updatetasty.toString());
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
                            String urlString = getIntent().getStringExtra("updateUrl");

                            try{
                                //------------------ CLIENT REQUEST
                                FileInputStream fileInputStream = new FileInputStream(new File(existingFileName));
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
                                dos.writeBytes("Content-Disposition: form-data; name=\"t_no\"\r\n\r\n" + updatetasty.getT_no());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"t_title\"\r\n\r\n");
                                dos.writeUTF(updatetasty.getT_title());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"t_content\"\r\n\r\n");
                                dos.writeUTF(updatetasty.getT_content());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"t_time\"\r\n\r\n" );
                                dos.writeUTF(updatetasty.getT_time());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"t_img\"\r\n\r\n" + updatetasty.getT_img());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"t_phone\"\r\n\r\n" + updatetasty.getT_phone());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"t_address\"\r\n\r\n");
                                dos.writeUTF(updatetasty.getT_address());
                                dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"t_address\"\r\n\r\n" + updatetasty.getC_no());
                                /*dos.writeBytes("\r\n--" + boundary + "\r\n");
                                dos.writeBytes("Content-Disposition: form-data; name=\"sId\"\r\n\r\n" + "sun");*/

                                // send multipart form data necesssary after file data...
                                dos.writeBytes(lineEnd);
                                dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

                                // close streams
                                Log.e("Debug", "File is written");
                                fileInputStream.close();
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
                                writeHandler.sendMessage(message);

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

    public void clickCancelB(View v){
        finish();
    }
    public void clickImageB(View v){
        getGallery();
    }
    private void getGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
    }
}