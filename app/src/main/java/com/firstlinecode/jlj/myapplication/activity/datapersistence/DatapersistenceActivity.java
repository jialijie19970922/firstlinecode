package com.firstlinecode.jlj.myapplication.activity.datapersistence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firstlinecode.jlj.myapplication.R;

/**
 * 数据存储-->持久化
 */
public class DatapersistenceActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapersistence);
        initView();
    }

    private void initView() {
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                startActivity(new Intent(this,FileStoreActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this,SharedPreferencesStorageActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this,SQLiteStorageActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this,LietPalStorageActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this,ContentProviderStorageActivity.class));
                break;
        }
    }
}
