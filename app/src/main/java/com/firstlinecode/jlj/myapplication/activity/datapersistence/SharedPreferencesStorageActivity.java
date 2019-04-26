package com.firstlinecode.jlj.myapplication.activity.datapersistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firstlinecode.jlj.myapplication.R;

public class SharedPreferencesStorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_storage);
        Toast.makeText(this,"后续加入，请耐心等待...",Toast.LENGTH_SHORT).show();
    }
}
