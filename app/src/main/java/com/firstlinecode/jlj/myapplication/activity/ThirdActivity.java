package com.firstlinecode.jlj.myapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firstlinecode.jlj.myapplication.R;
import com.firstlinecode.jlj.myapplication.base.BaseActivity;
import com.firstlinecode.jlj.myapplication.utli.ActivityCollector;

public class ThirdActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:10086")));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序
//        ActivityCollector.finishAll();
    }
}
