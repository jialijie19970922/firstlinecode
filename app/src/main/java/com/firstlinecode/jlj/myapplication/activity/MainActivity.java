package com.firstlinecode.jlj.myapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firstlinecode.jlj.myapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("myMessage","MainActivity");
        Log.d("myMessage","MainActivity");
        Log.i("myMessage","MainActivity");
        Log.w("myMessage","MainActivity");
        Log.e("myMessage","MainActivity");
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_itme:
                Toast.makeText(this,"additem",Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_itme:
                Toast.makeText(this,"removeitem",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
//        startActivity(new Intent(this,SecondActivity.class));// 显示intent
//        startActivity(new Intent("com.firstlinecode.jlj.myapplication"));// 隐式intent
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.baidu.com")));// 跳转至网页显示
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
