package com.example.a15041867.c302_p06_miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvUser;
    private ArrayList<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvUser = (ListView)findViewById(R.id.lvUser);

        //TODO 1 & 2
        // Defines the URL string of your web service
        String url = "http://trytocode.com/c302/users.json";
        HttpRequest request = new HttpRequest(url);
        request.setMethod("GET");

        //TODO 3
        request.execute();

        try {


            //TODO 4
            String jsonString = request.getResponse();
//            String jsonString = "[{\"category_id\":\"1\",\"name\":\"Sports\",\"description\":\"Sports photos\"}," +				"{\"category_id\":\"2\",\"name\":\"Family\",\"description\":\"Family photos\"}]";
            System.out.println(">>" + jsonString);
            //create JSONArray with returned json string
            JSONArray jsonArray = new JSONArray(jsonString);
            //for each JSONObject in the JSONArray
            //create a new Category object and populate it with values from the JSONObject
            //add the Category object into catList

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                User user1 = new User();
                user1.setId(jsonObj.getInt("id"));
                user1.setUsername(jsonObj.getString("username"));
                user1.setEmail(jsonObj.getString("email"));
                user1.setPhone(jsonObj.getString("phone"));
                userList.add(user1);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        UserAdapter adapter = new UserAdapter(this,
                R.layout.listview_user, userList);

        lvUser.setAdapter(adapter);

        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = (User) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(), todoActivity.class);
                intent.putExtra("id", user.getId());
                startActivity(intent);
            }
        });



    }
}
