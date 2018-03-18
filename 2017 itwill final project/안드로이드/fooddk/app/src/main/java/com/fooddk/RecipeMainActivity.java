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

public class RecipeMainActivity extends AppCompatActivity {

    Recipe recipe = new Recipe();
    ArrayList<Recipe> globalRecipeList = new ArrayList<Recipe>();
    RecipeAdapter recipeAdapter;
    ListView recipeListView;
    TextView noTV;
    TextView titleTV;
    TextView name_dateTV;
    String sId;

    /*****************************************/
    public class RecipeAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return globalRecipeList.size();
        }

        @Override
        public Recipe getItem(int position) {
            return globalRecipeList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.guest_item,null);
            Recipe recipe = this.getItem(position);

            TextView noTV=(TextView)view.findViewById(R.id.noTV);
            TextView titleTV=(TextView)view.findViewById(R.id.titleTV);
            TextView name_dateTV=(TextView)view.findViewById(R.id.name_dateTV);

            noTV.setText(recipe.getR_no()+"");
            titleTV.setText(recipe.getR_title());
            name_dateTV.setText(recipe.getR_content()+"["+recipe.getR_count()+"]");
            return view;
        }
    }

    /*****************************************/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_main);
        sId = getIntent().getExtras().getString("sId");

        recipeAdapter =new RecipeAdapter();
        recipeListView =(ListView)findViewById(R.id.recipeListView);
        recipeListView.setAdapter(recipeAdapter);

        new Thread(){
            @Override
            public void run() {
                //getXMLGuestList();
                getJSONGuestList();
            }
        }.start();

        recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                recipe = ((Recipe)(recipeListView.getItemAtPosition(position)));

                Intent recipeIntent = new Intent();
                recipeIntent.setClass(getApplicationContext(),RecipeViewActivity.class);
                //recipeIntent.setClass(getApplicationContext(),Recipe_modify.class);
                recipeIntent.putExtra("recipe", recipe);
                recipeIntent.putExtra("sId", sId);
                startActivityForResult(recipeIntent, 3);

            }
        });
    }
    private Handler recipeHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    ArrayList<Recipe> recvGuestList2 = (ArrayList<Recipe>)msg.obj;
                    globalRecipeList =recvGuestList2;
                    recipeAdapter.notifyDataSetChanged(); //adapter에서 데이터가 바뀌었다고 알려줘야한다.
                    setTitle("JSON DATA");
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
        //if(requestCode==3){
        //  if(resultCode==4&&requestCode==7){
        Log.e(">>>>>>>>>>>>>>","main");
        new Thread(){
            @Override
            public void run() {
                //getXMLGuestList();
                getJSONGuestList();
            }
        }.start();
        recipeAdapter.notifyDataSetChanged();
    }


    // }
    // }

    private void getJSONGuestList(){
        ArrayList<Recipe> locatRecipeList = new ArrayList<Recipe>();


        try {
            String recipe_list_urlStr = "http://192.168.12.17:8084/fooddk/recipe_list_json";
            URL recipe_list_url = new URL(recipe_list_urlStr);
            HttpURLConnection httpConnection = (HttpURLConnection) recipe_list_url.openConnection();//UrlConnection이 나옴, openconnection하면 get방식이다.
            httpConnection.setRequestMethod("GET");
            InputStream in = httpConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));//한라인씩 읽기 위해서, xml파일이 들어온다.

            String jsonStr = "";
            while(true){
                String readLine = br.readLine();
                if(readLine==null)break;
                jsonStr+=readLine+"\n";
            }
            Log.e("jsonStr", jsonStr);
            /*
            [
                {
                    guest_no: "84",
                    guest_name: "ㄹㅇㅇㅇㅇ",
                    guest_date: "2017-06-17 14:55:42",
                    guest_email: "ㅇㅇㄹㅇㄴㄹ",
                    guest_title: "ㅇㅇ ㅇㄴㄹ",
                    guest_content: "ㅇㅇㅇㅇㄴㄹㅇㄴㄹㅇㄴ"
                },
                ....
            ]
             */
            JSONArray recipeJsonArray = new JSONArray(jsonStr);

            for (int i=0; i<recipeJsonArray.length(); i++){
                JSONObject recipeJsonObject = recipeJsonArray.getJSONObject(i);
                String recipe_noStr = recipeJsonObject.getString("r_no");
                String recipe_title = recipeJsonObject.getString("r_title");
                String recipe_mno = recipeJsonObject.getString("m_no");
                String recipe_content = recipeJsonObject.getString("r_content");
                String recipe_date = recipeJsonObject.get("r_date").toString();
                String recipe_count = recipeJsonObject.getString("r_count");
                String recipe_cno = recipeJsonObject.getString("c_no");

                URL imageUrl;
                Bitmap recipe_img;
                Bitmap imagebitmap;
                try {
                    imageUrl = new URL("http://192.168.12.17:8084/fooddk/"+recipeJsonObject.getString("r_img"));
                    InputStream imageInputStream = imageUrl.openStream();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 4;
                    imagebitmap=BitmapFactory.decodeStream(imageInputStream,null,options);
                    recipe_img = imagebitmap;
                }catch (Exception e) {

                    imageUrl = new URL("http://192.168.12.17:8084/fooddk/images/default.jpg");
                    InputStream imageInputStream = imageUrl.openStream();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 4;
                    imagebitmap=BitmapFactory.decodeStream(imageInputStream,null,options);
                    recipe_img=imagebitmap;

                }



                locatRecipeList.add(new Recipe(Integer.parseInt(recipe_noStr), recipe_title, Integer.parseInt(recipe_mno),recipe_content, recipe_date,
                        recipe_img, Integer.parseInt(recipe_cno), Integer.parseInt(recipe_count)));
            }//for end
            Message message = new Message();
            message.what=1;
            message.obj=locatRecipeList;
            recipeHandler.sendMessage(message);

        }catch (Exception e){
            Message message = new Message();
            message.what=99;
            message.obj=e;
            recipeHandler.sendMessage(message);
            e.printStackTrace();
        }
    }//end getJSONGuestList() method end



}//end class