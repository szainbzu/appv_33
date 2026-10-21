package com.example.appv_33;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnClick;
    private TextView txtName;
    private Spinner spnLanguages;
    private EditText edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpViews();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edtName.getText().toString();
                String str = "";
                if(!txt.isEmpty()){
                    str = "Welcome "+ txt;
                }
                String s = spnLanguages.getSelectedItem().toString();
                str+= ", " + s;

                txtName.setText(str);
            }
        });
    }
    private void setUpViews(){
        btnClick = findViewById(R.id.btnClick);
        txtName = findViewById(R.id.txtName);
        edtName = findViewById(R.id.edtName);
        spnLanguages = findViewById(R.id.spnLanguages);
        ArrayList<String> items = new ArrayList<>();

        items.add("Java");
        items.add("Dart");
        items.add("C#");
        items.add("Python");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item, items);
        spnLanguages.setAdapter(adapter);

    }
}