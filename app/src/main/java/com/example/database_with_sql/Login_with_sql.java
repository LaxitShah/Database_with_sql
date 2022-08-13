package com.example.database_with_sql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Login_with_sql extends AppCompatActivity {
    Button addData,displayData;
    EditText firstName,lastName;
    private ListView listView;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_sql);

        firstName=(EditText)findViewById(R.id.first_name_sql);
        lastName=(EditText) findViewById(R.id.last_name_sql);

        addData=(Button)findViewById(R.id.btn_add_sql);
        displayData=(Button) findViewById(R.id.btn_display_sql);
//        DatabaseHandler db=new DatabaseHandler(this);
//        ArrayList<ContactModel> contacts=db.getAllRecords();
//        DataAdapter myBaseAdapter=new DataAdapter(this,contacts);
//        listView.setAdapter(myBaseAdapter);
         db=new DatabaseHandler(this);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strfn=firstName.getText().toString();
                String strln=lastName.getText().toString();

                ContactModel contact=new ContactModel();
                contact.setFirstName(strfn);
                contact.setLastName(strln);

                db.insertRecord(contact);
                firstName.setText("");
                lastName.setText("");
            }
        });
       displayData.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login_with_sql.this,Login_with_sql_2.class);
                startActivity(intent);

            }
        });
    }
}