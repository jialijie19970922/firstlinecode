package com.firstlinecode.jlj.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firstlinecode.jlj.myapplication.R;
import com.firstlinecode.jlj.myapplication.adapter.TowLevelListAdapter;
import com.firstlinecode.jlj.myapplication.adapter.multipleitem.TwoListMultipleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 张玉瑾需求，未完成！
 */
public class TwoLevelListActivity extends AppCompatActivity {

    private RecyclerView rc_jlj_list;
    private TowLevelListAdapter adapter;
    private List<TwoListMultipleItem> list = new ArrayList();
    private boolean sign;
    private int potion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_level_list);
        rc_jlj_list = findViewById(R.id.rc_jlj_list);

        // 创建布局管理
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 1 : 2;
            }
        });

        rc_jlj_list.setLayoutManager(layoutManager);

        // 初始化數據
        initData();

        // 创建适配器
        adapter = new TowLevelListAdapter(list);
        rc_jlj_list.setAdapter(adapter);
        rc_jlj_list.smoothScrollBy(0,2000);
//        rc_jlj_list.smoothScrollToPosition(5);
    }

    private void initData() {
        for (int i = 0; i < 16; i++) {
            if (sign != false) {
                TwoListMultipleItem twoLevelListBean = new TwoListMultipleItem(TwoListMultipleItem.TEXT);
                twoLevelListBean.setName("賈立杰" + i);
                list.add(twoLevelListBean);
            } else {
                if (potion != i) {
                    TwoListMultipleItem twoLevelListBean = new TwoListMultipleItem(TwoListMultipleItem.TEXT);
                    twoLevelListBean.setName("賈立杰" + i);
                    list.add(twoLevelListBean);
                } else {
                    TwoListMultipleItem twoLevelListBean = new TwoListMultipleItem(TwoListMultipleItem.IMG);
                    twoLevelListBean.setName("賈立杰" + i);
                    list.add(twoLevelListBean);
                }
            }
        }
    }
}
