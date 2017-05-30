package com.example.a15041867.c302_p06_miniproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15041867 on 30/5/2017.
 */

public class UserAdapter extends ArrayAdapter<User> {

    Context context;
    int layoutResourceId;
    ArrayList<User> userList ;

    public UserAdapter(Context context, int layoutResourceId, ArrayList<User> userList) {
        super(context, layoutResourceId, userList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.userList = userList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CategoryHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new CategoryHolder();
            holder.tvUsername = (TextView)row.findViewById(R.id.textViewUsername);
            holder.tvEmail = (TextView)row.findViewById(R.id.textViewEmail);
            holder.tvPhone = (TextView)row.findViewById(R.id.textViewPhone);

            row.setTag(holder);
        }
        else
        {
            holder = (CategoryHolder)row.getTag();
        }

        User user = userList.get(position);
        holder.tvUsername.setText(user.getUsername());
        holder.tvEmail.setText(user.getEmail());
        holder.tvPhone.setText(user.getPhone());

        return row;
    }

    static class CategoryHolder
    {
        TextView tvUsername, tvEmail, tvPhone;
    }
}
