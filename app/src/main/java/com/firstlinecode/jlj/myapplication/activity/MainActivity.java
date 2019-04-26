package com.firstlinecode.jlj.myapplication.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firstlinecode.jlj.myapplication.R;
import com.firstlinecode.jlj.myapplication.activity.datapersistence.DatapersistenceActivity;
import com.firstlinecode.jlj.myapplication.base.BaseActivity;
import com.firstlinecode.jlj.myapplication.broadcasts.NetworkChangeReceiver;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    /**
     * 知识点：1.activity各种跳转方式
     *        2.打开网页的方式
     *        3.布局中的各种属性使用与记录
     *        4.recycleview的使用
     *        5.广播-->接收器/发送者
     *
     * @param savedInstanceState
     */

    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkChangeReceiver = new NetworkChangeReceiver();
        logs();
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(networkChangeReceiver,intentFilter);
    }

    private void logs() {
        Log.v("myMessage", "MainActivity");
        Log.d("myMessage", "MainActivity");
        Log.i("myMessage", "MainActivity");
        Log.w("myMessage", "MainActivity");
        Log.e("myMessage", "MainActivity");
    }

    private void initView() {
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_itme:
                Toast.makeText(this, "additem", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_itme:
                Toast.makeText(this, "removeitem", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, SecondActivity.class));// 显示intent
                break;
            case R.id.button2:
                startActivity(new Intent("com.firstlinecode.jlj.myapplication"));// 隐式intent
                break;
            case R.id.button3:
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.baidu.com")));// 跳转至网页显示与选择跳转至ACTION_VIEW界面
                break;
            case R.id.button4:

                break;
            case R.id.button5:

                break;
            case R.id.button6:
                startActivity(new Intent(this, TwoLevelListActivity.class));
                break;
            case R.id.button7:
                startActivity(new Intent(this, FlowActivity.class));
                break;
            case R.id.button8:// 发送一条广播检测当前网络
                Intent intent = new Intent("com.firstlinecode.jlj.myapplication.broadcasts.NetworkChangeReceiver");
                sendBroadcast(intent);
                break;
            case R.id.button9:
                startActivity(new Intent(this, DatapersistenceActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
}
