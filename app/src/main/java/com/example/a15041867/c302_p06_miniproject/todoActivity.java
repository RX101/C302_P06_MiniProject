package com.example.a15041867.c302_p06_miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class todoActivity extends AppCompatActivity {

    private int currentId;
    private ListView lv;


    ArrayList<TODO> todoList = new ArrayList<TODO>();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        lv = (ListView)findViewById(R.id.lvToDO);

        Intent intent = getIntent();
        // getting attached intent data

        currentId = intent.getIntExtra("id",-1);
        // displaying selected product name

        //TODO 5 Define the URL string of your web service, getPhotoStoreByCategory.php?category_id= ???
        //TODO 6 Declare and create a HttpRequest object, with the URL string as the argument
        String url = "http://trytocode.com/c302/todo.json";
        HttpRequest request = new HttpRequest(url);
        request.setMethod("GET");

        //TODO 7 Execute the Http request
        request.execute();

        //TODO 8 Create PhotoStore object and Parse the returned JSON string values into a PhotoStore object
        // Hint:Study the try-catch block in MainActivity
        try {
            String jsonString = request.getResponse();
            JSONArray jsonArray = new JSONArray(jsonString);
            //for each JSONObject in the JSONArray
            //create a new Category object and populate it with values from the JSONObject
            //add the Category object into catList

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                int id = jsonObj.getInt("userId");
                if(id == currentId){
                    TODO todo = new TODO();
                    todo.setUserId(jsonObj.getInt("userId"));
                    todo.setTitle(jsonObj.getString("title"));
                    todo.setCompleted(jsonObj.getBoolean("completed"));
                    todoList.add(todo);
                    adapter.notifyDataSetChanged();
                }

            }


        }catch (Exception e){
            e.printStackTrace();

        }
        //Step 2b: Initialise the ArrayAdapter to link to the ArrayList
        adapter = new ArrayAdapter<TODO>(todoActivity.this,android.R.layout.simple_list_item_1,todoList);



        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
