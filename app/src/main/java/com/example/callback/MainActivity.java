package com.example.callback;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewInterface{

    Button btn_callback;

    Button btn_show;

    TextView tv_show;

    NewClass newClass;

    Context context;

    Data st;

    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getBaseContext();

        arrayList = new ArrayList();


        btn_callback = (Button) findViewById(R.id.btn_callback);
        btn_show = (Button) findViewById(R.id.btn_show);
        tv_show = (TextView) findViewById(R.id.tv_show);

        btn_callback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity myApplication = new MainActivity();

                myApplication.doSomething();


            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showData();
            }
        });
    }

    private void doSomething(){
        newClass = new NewClass(this);
        newClass.calledFromMain();
    }

    @Override
    public void callback(Data s) {
        st = s;
        Log.e("callback ", st.getData());

    }


    public void showData() {

        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.saved_high_score);
        String highScore = sharedPref.getString(getString(R.string.saved_high_score), defaultValue);

        Log.e("showData_start ", highScore);

        tv_show.setText(highScore);

        Log.e("showData_end", highScore);
    }
}
