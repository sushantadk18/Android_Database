package com.example.android_database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txt_id,txt_name,txt_marks;
    Button btn_insertData,btn_viewData,btn_editData,btn_deleteData;
    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txt_id=findViewById(R.id.editId);
        txt_name=findViewById(R.id.editMarks);
        txt_marks=findViewById(R.id.editMarks);
        btn_insertData=findViewById(R.id.btn_insert);
        btn_viewData=findViewById(R.id.btn_view);
        btn_editData=findViewById(R.id.btn_edit);
        btn_deleteData=findViewById(R.id.btn_delete);
        myDB=new DatabaseHelper(this);
        btn_insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean inserted =myDB.insertData(txt_id.getText().toString().trim(),
                        txt_name.getText().toString().trim(),
                        txt_marks.getText().toString().trim());
                if (inserted==true){
                    Toast.makeText(MainActivity.this,"data has beeen insertted",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Something error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}