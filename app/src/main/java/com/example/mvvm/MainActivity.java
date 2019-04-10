package com.example.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.mvvm.Demo.*;

public class MainActivity extends AppCompatActivity {
    EditText editText, editText1, editText2, editText3;
    String name, email, pass, phone, device = "android", id = "123";
private ViewModelDemo viewModelDemo;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.email);
        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.pass);
        editText3 = findViewById(R.id.phone);
        viewModelDemo= ViewModelProviders.of(this).get(ViewModelDemo.class);

button=findViewById(R.id.signup_button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        name = editText.getText().toString();
        email = editText1.getText().toString();
        pass = editText2.getText().toString();
        phone = editText3.getText().toString();
        viewModelDemo.UserRegister(MainActivity.this,name,email,phone,pass,device,id).observe(MainActivity.this, new Observer<UserRegisterModel>() {
            @Override
            public void onChanged(@Nullable UserRegisterModel userRegisterModel) {
                if(userRegisterModel.getSuccess().equalsIgnoreCase("1"))
                {
                    Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"not",Toast.LENGTH_SHORT).show();
            }
        });
    }
});
    }



}


