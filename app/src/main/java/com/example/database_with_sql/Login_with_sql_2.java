package com.example.database_with_sql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Login_with_sql_2 extends AppCompatActivity {
    ListView listView;

    String firstName[]={"abc","def","ghi","jkl"};
    String lastName[]={"mno","pqr","stu","xyz"};
    ArrayList<ContactModel> contactModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_sql2);

        listView = findViewById(R.id.list_view_sql);

        DatabaseHandler databaseHandler=new DatabaseHandler(this);
        contactModelArrayList=databaseHandler.getAllRecords();

        DataAdapter dataAdapter = new DataAdapter(this,contactModelArrayList );
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ContactModel contactModel=contactModelArrayList.get(position);
                Intent intent = new Intent(Login_with_sql_2.this, Login_with_sql_3.class);
                intent.putExtra("ID_GET",contactModel.getID());
                intent.putExtra("firstName",contactModel.getFirstName());
                intent.putExtra("lastName",contactModel.getLastName());
                startActivity(intent);
            }
        });

    }
}