package com.example.database_with_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_with_sql_3 extends AppCompatActivity {

    EditText fName,lName;
    Button  btnUpdate,btnDelete;
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_sql3);
        btnUpdate=findViewById(R.id.btn_update_sql);
        btnDelete=findViewById(R.id.btn_delete_sql);
        fName=findViewById(R.id.first_name_sql);
        lName=findViewById(R.id.last_name_sql);

        databaseHandler=new DatabaseHandler(this);
        Intent intent=getIntent();
        String fName1=intent.getStringExtra("firstName");
        String lName1=intent.getStringExtra("lastName");
        final String strId=intent.getStringExtra("ID_GET");
        fName.setText(fName1);
        lName.setText(lName1);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fnameStr=fName.getText().toString();
                String lnameStr=lName.getText().toString();
                ContactModel contactModel=new ContactModel();
                contactModel.setID(strId);
                contactModel.setFirstName(fnameStr);
                contactModel.setLastName(lnameStr);
                databaseHandler.updateRecord(contactModel);

                Intent intent1=new Intent(Login_with_sql_3.this,Login_with_sql_2.class);
                startActivity(intent1);

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactModel contactModel=new ContactModel();
                contactModel.setID(strId);
                databaseHandler.deleteRecord(contactModel);
                Intent i=new Intent(Login_with_sql_3.this,Login_with_sql_2.class);
                startActivity(i);
            }
        });




    }
}