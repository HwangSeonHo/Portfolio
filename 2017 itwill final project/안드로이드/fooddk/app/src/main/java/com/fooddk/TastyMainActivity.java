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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
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

public class TastyMainActivity extends AppCompatActivity {

    public static final String INSERT_ACTION_URL=
            "http://192.168.12.17:8084/fooddk/a_TastyWriteAction";
    public static final String LIST_URL=
            "http://192.168.12.17:8084/fooddk/a_TastyList";
    public static final String DELETE_URL=
            "http://192.168.12.17:8084/fooddk/a_TastyRemove";
    public static final String UPDATE_ACTION_URL=
            "http://192.168.12.17:8084/fooddk/a_TastyUpdateAction";
    ArrayList<Tasty> tastyList=new ArrayList<Tasty>();
    ListAdapter listAdapter;
    Tasty tasty;
    Tasty updateTasty;
    int tastyPos;
    boolean isDelete = false;

    FrameLayout frameLayout;
    ListView listView;
    TextView noTV;
    TextView titleTV;
    TextView name_dateTV;

    String sId;

    Button listB;
    Button insertB;
    Button deleteB;
    Button updateB;
    /**************************/
    public class ListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return tastyList.size();
        }

        @Override
        public Tasty getItem(int position) {
            return tastyList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.guest_item,null);
            TextView noTV = (TextView) view.findViewById(R.id.noTV);
            TextView titleTV = (TextView) view.findViewById(R.id.titleTV);
            TextView name_dateTV = (TextView) view.findViewById(R.id.name_dateTV);
            Tasty tasty = this.getItem(position);

            noTV.setText(tasty.getT_no()+"");
            titleTV.setText(tasty.getT_title());
            name_dateTV.setText("["+tasty.getT_date()+"]");

            return view;
        }
    }
    /**************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasty_main);
        noTV = (TextView) findViewById(R.id.noTV);
        titleTV = (TextView)findViewById(R.id.titleTV);
        name_dateTV = (TextView)findViewById(R.id.name_dateTV);
        listAdapter = new ListAdapter();
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(listAdapter);
        tastyList = new ArrayList<>();

        sId = getIntent().getExtras().getString("sId");

        frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        getLayoutInflater().inflate(R.layout.activity_tasty_detail,frameLayout);

        new Thread(){
            @Override
            public void run() {
                getJSONGuestList();
            }
        }.start();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tasty = ((Tasty)(listView.getItemAtPosition(position)));
                tastyPos = position;
                Log.e("selected tasty : ",tasty.getT_title());
                listView.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                ((ImageView)frameLayout.findViewById(R.id.view_img)).setImageBitmap(tasty.getT_img());
                ((TextView)frameLayout.findViewById(R.id.view_title)).setText(tasty.getT_title());
                ((TextView)frameLayout.findViewById(R.id.view_address)).setText(tasty.getT_address());
                ((TextView)frameLayout.findViewById(R.id.view_date)).setText(tasty.getT_date());
                ((TextView)frameLayout.findViewById(R.id.view_time)).setText(tasty.getT_time());
                ((TextView)frameLayout.findViewById(R.id.view_phone)).setText(tasty.getT_phone());
                ((TextView)frameLayout.findViewById(R.id.view_content)).setText(tasty.getT_content());
            }
        });


    }

    private Handler guestHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    ArrayList<Tasty> recvGuestList2 = (ArrayList<Tasty>) msg.obj;
                    tastyList = recvGuestList2;
                    listAdapter.notifyDataSetChanged();    //데이터바뀐거알려주기
                    setTitle("JSON DATA");
                    break;
                case 99:
                    Exception recvException = (Exception)msg.obj;
                    Toast.makeText(getApplicationContext(),"메세지99",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    private void getJSONGuestList(){
        /*
        JSON(JavaScript Object Notation)
         */
        ArrayList<Tasty> localGuestList = new ArrayList<Tasty>();
        try {
            String guest_list_urlStr = LIST_URL;
            URL guest_list_url = new URL(guest_list_urlStr);
            HttpURLConnection httpConnection = (HttpURLConnection) guest_list_url.openConnection();
            httpConnection.setRequestMethod("GET");
            InputStream in = httpConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String jsonStr="";
            while(true){
                String readLine = br.readLine();
                if(readLine==null)break;
                jsonStr+=readLine+"\n";
            }
            Log.e("###jsonStr",jsonStr);

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
            JSONArray guestJsonArray = new JSONArray(jsonStr);
            for (int i=0; i<guestJsonArray.length();i++){
                JSONObject tastyJsonObject = guestJsonArray.getJSONObject(i);
                String t_no = tastyJsonObject.getString("t_no");
                String t_title = tastyJsonObject.getString("t_title");
                String t_content = tastyJsonObject.getString("t_content");
                String t_date = tastyJsonObject.getString("t_date");
                String t_count = tastyJsonObject.getString("t_count");
                String t_phone = tastyJsonObject.getString("t_phone");
                String t_time = tastyJsonObject.getString("t_time");
                String t_address = tastyJsonObject.getString("t_address");
                String t_location = tastyJsonObject.getString("t_location");
                String c_no = tastyJsonObject.getString("c_no");
                //  String t_no = tastyJsonObject.getString("t_no");
                // String m_no = tastyJsonObject.getString("m_no");
                /*int t_no = tastyJsonObject.getInt("t_no");
                int m_no = tastyJsonObject.getInt("m_no");*/


                URL imageUrl;
                Bitmap t_img;
                Bitmap imagebitmap;
                try {
                    imageUrl = new URL("http://192.168.12.17:8084/fooddk/"+tastyJsonObject.getString("t_img"));
                    InputStream imageInputStream = imageUrl.openStream();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    imagebitmap= BitmapFactory.decodeStream(imageInputStream,null,options);
                    t_img = imagebitmap;
                }catch (Exception e) {
                    imageUrl = new URL("http://192.168.12.17:8084/fooddk/images/default.jpg");
                    InputStream imageInputStream = imageUrl.openStream();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    imagebitmap=BitmapFactory.decodeStream(imageInputStream,null,options);
                    t_img = imagebitmap;

                }


                localGuestList.add(new Tasty(Integer.parseInt(t_no),t_title,t_content,t_date,
                        t_img,t_phone,t_time,t_address,t_location, Integer.parseInt(t_count),Integer.parseInt(c_no)));

            }//end for

            Message message = new Message();
            message.what=1;
            message.obj=localGuestList;
            guestHandler.sendMessage(message);


        }catch (Exception e){
            Message message = new Message();
            message.what=99;
            message.obj=e;
            guestHandler.sendMessage(message);
            e.getStackTrace();
        }
    }//end getJSONGuestList method


    /**********************************************************************************/
    public void buttonClick(View v){
        Log.d("tag","buttonclick");
        int id=v.getId();
        Log.e("id",id+"");
        if(id==R.id.insertB){
            Toast.makeText(getApplicationContext(),"insertIntent",Toast.LENGTH_LONG);
            setTitle("INSERT");
            tasty=null;
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(),TastyWriteActivity.class);
            intent.putExtra("insertUrl",INSERT_ACTION_URL);
            intent.putExtra("sId", sId);
            startActivityForResult(intent,0);
        }else if(id==R.id.listB){
            setTitle("LIST");
            tasty=null;
            new Thread(){
                @Override
                public void run() {
                    getJSONGuestList();
                }
            }.start();
            listAdapter.notifyDataSetChanged();
            frameLayout.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.VISIBLE);
        }else if(id==R.id.deleteB) {
            setTitle("DELETE");
            new Thread() {
                @Override
                public void run() {
                    try {
                        if (tasty == null)
                            throw new Exception("tasty 눌러라");
                        String parameter = "?t_no=" + tasty.getT_no();
                        URL url = new URL(DELETE_URL + parameter);
                        Log.e("url",url+"");
                        HttpURLConnection httpURLConnection =
                                (HttpURLConnection) url.openConnection();
                        /*
                        1.요청방식설정(GET,POST)
                         */
                        httpURLConnection.setRequestMethod("GET");
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
                        message.what = 3;
                        message.obj = tastyPos;
                        handler.sendMessage(message);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            isDelete=false;

        }else if(id==R.id.updateB){
            setTitle("UPDATE");
            Intent intent = new Intent();
            Log.e("###update tasty in Main",tasty.toString());
            intent.putExtra("tasty",tasty);
            intent.putExtra("updateUrl",UPDATE_ACTION_URL);
            intent.putExtra("sId", sId);
            intent.setClass(getApplicationContext(),TastyModifyActivity.class);
            startActivityForResult(intent,1);
        }
    }

    /**************************************************************************************************/
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            /*if(msg.what==0){        //insert
                String recvData=(String)msg.obj;
                if(!(recvData.trim().equals("0"))){
                    new Thread() {
                        @Override
                        public void run() {
                            getJSONGuestList();
                        }
                    }.start();
                    listAdapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(
                            getApplicationContext(),
                            "등록 실패",Toast.LENGTH_LONG).show();
                }
                //resultTV.setText(recvData.trim());
            }else*/ if(msg.what==1){      //list
                tastyList=(ArrayList<Tasty>)msg.obj;
                listAdapter.notifyDataSetChanged();

            }else if(msg.what==2){     //detail
                listView.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
            }else if(msg.what==3){  //delete
                int removePos;
                removePos = (Integer)msg.obj;
                tastyList.remove(removePos);
                listAdapter.notifyDataSetChanged();
                buttonClick(findViewById(R.id.listB));
            }else if(msg.what==4){  //update
                String recvData=(String)msg.obj;
                Log.e("recvData",recvData);
                if(recvData.trim().equals("1")){
                    buttonClick(findViewById(R.id.listB));
                }else {
                    Toast.makeText(
                            getApplicationContext(),
                            "갱신 실패",Toast.LENGTH_LONG).show();
                }
            }
        }
    };

    /************************************************************************************************/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        buttonClick(findViewById(R.id.listB));
    }
}//end class





/*

package com.itwill.httpgetxmljsonparsing;

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

public class RecipeView extends AppCompatActivity {
    TextView r_titleTV;
    TextView m_noTV;
    TextView c_noTV;
    TextView r_contentTV;
    ImageView r_imgIV;
    ConstraintLayout viewForm;
    Recipe recipe;

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

        Intent recipeViewIntent = getIntent();
        recipe = (Recipe)recipeViewIntent.getParcelableExtra("recipe");
        r_no = recipe.getR_no();
        r_titleTV.setText(recipe.getR_title());
        m_noTV.setText(recipe.getM_no()+"");
        c_noTV.setText(recipe.getC_no()+"");
        r_contentTV.setText(recipe.getR_content());
        r_imgIV.setImageBitmap(recipe.getR_img());


    }

    public void clickListB(View v){
        finish();
    }
    public void clickModifyB(View v){
        Intent modifyintent = new Intent();
        modifyintent.setClass(getApplicationContext(),Recipe_modify.class);
        modifyintent.putExtra("recipe", recipe);
        startActivity(modifyintent);

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
           if(msg.what==1){
               setResult(4, new Intent());

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
                        */
/*
                        1.요청방식설정(GET,POST)
                         *//*

                        httpURLConnection.setRequestMethod("POST");

                        */
/*
                        2.요청헤더값을설정
                         *//*

                                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                         */
/*
                        3.서버로데이타를 전송설정(파라메타)
                          서버로부터오는 데이타수신설정
                         *//*

                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setDoInput(true);
                                String parameter = "r_no=" + r_no;

                                   */
/*
                        5.서버전송출력스트림생성 파라메타전송
                        *//*

                                OutputStream out =
                                httpURLConnection.getOutputStream();
                        */
/*
                        6.요청시바디전송
                         *//*

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
        intent.setClass(getApplicationContext(), recipe_write.class);
        startActivity(intent);

        }
        }
 */
