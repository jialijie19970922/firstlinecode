package com.firstlinecode.jlj.myapplication.activity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firstlinecode.jlj.myapplication.R;
import com.firstlinecode.jlj.myapplication.utli.FlowUtils;
import com.firstlinecode.jlj.myapplication.view.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class FlowActivity extends AppCompatActivity {

    private FlowLayout flowLayout_01;
    private FlowLayout flowLayout_02;
    List<String> datas01 = new ArrayList<>();
    List<String> datas02 = new ArrayList<>();
    // 各自状态值，是否是第一次加载，如果不是，那就可以改变当前值
    private boolean flowboolean01 = true;
    private boolean flowboolean02 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        flowLayout_01 = findViewById(R.id.fly_01);
        flowLayout_02 = findViewById(R.id.fly_02);

        initData01();
        initData02();

        flowView01();
        flowView02();
    }

    private void flowView01() {

        if (!flowboolean01) {
            flowLayout_01.removeAllViews();
        }

        // 因为ScrollView中子布局中有布局因没有数据而不显示时，其后边所有布局都不会正常显示
        if (datas01.size() == 0) {
            flowLayout_01.setVisibility(View.GONE);
        } else {
            flowLayout_01.setVisibility(View.VISIBLE);
            for (int i = 0; i < datas01.size(); i++) {
                View view = View.inflate(this, R.layout.flow_itme_view, null);
                final LinearLayout lineatLayout = view.findViewById(R.id.flow_lin);
                final ImageView imgView = view.findViewById(R.id.flow_img);
                final TextView textView = view.findViewById(R.id.flow_tv);
                imgView.setId(i);
                lineatLayout.setOrientation(LinearLayout.HORIZONTAL);
                textView.setText(datas01.get(i));
                imgView.setImageResource(R.drawable.ic_launcher_background);

                //背景图片
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);
                int dp5 = FlowUtils.getDimens(FlowActivity.this, R.dimen.dp5);
                gradientDrawable.setCornerRadius(dp5);
                gradientDrawable.setColor(
                        Color.rgb(FlowUtils.createRandomColor(), FlowUtils.createRandomColor(), FlowUtils.createRandomColor()));

                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(GradientDrawable.RECTANGLE);

                gradientDrawable2.setCornerRadius(dp5);
                gradientDrawable2.setColor(
                        Color.rgb(FlowUtils.createRandomColor(), FlowUtils.createRandomColor(), FlowUtils.createRandomColor()));

                textView.setTextColor(Color.WHITE);
                textView.setTextSize(16);
                lineatLayout.setPadding(0, 5, 10, 5);
                lineatLayout.setGravity(Gravity.CENTER);

                //设置点击效果
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
                stateListDrawable.addState(new int[]{}, gradientDrawable2);
                lineatLayout.setBackgroundDrawable(stateListDrawable);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FlowUtils.showToast(FlowActivity.this, textView.getText().toString());
                    }
                });

                imgView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        flowboolean02 = false;
                        flowboolean01 = false;
                        FlowUtils.showToast(FlowActivity.this, view.getId() + "");
                        flowLayout_01.removeAllViews();
                        datas02.add(datas01.get(view.getId()));
                        datas01.remove(view.getId());
                        flowView01();
                        flowView02();
                    }
                });

                flowLayout_01.addView(view);
            }
        }
    }

    private void flowView02() {
        if (!flowboolean02) {
            flowLayout_02.removeAllViews();
        }
        for (int i = 0; i < datas02.size(); i++) {
            View view = View.inflate(this, R.layout.flow_itme_view, null);
            final LinearLayout lineatLayout = view.findViewById(R.id.flow_lin);
            final ImageView imgView = view.findViewById(R.id.flow_img);
            final TextView textView = view.findViewById(R.id.flow_tv);
            imgView.setId(i);
            lineatLayout.setOrientation(LinearLayout.HORIZONTAL);
            textView.setText(datas02.get(i));
            imgView.setImageResource(R.drawable.ic_launcher_background);

            //背景图片
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            int dp5 = FlowUtils.getDimens(FlowActivity.this, R.dimen.dp5);
            gradientDrawable.setCornerRadius(dp5);
            gradientDrawable.setColor(
                    Color.rgb(FlowUtils.createRandomColor(), FlowUtils.createRandomColor(), FlowUtils.createRandomColor()));

            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(GradientDrawable.RECTANGLE);

            gradientDrawable2.setCornerRadius(dp5);
            gradientDrawable2.setColor(
                    Color.rgb(FlowUtils.createRandomColor(), FlowUtils.createRandomColor(), FlowUtils.createRandomColor()));

            textView.setTextColor(Color.WHITE);
            textView.setTextSize(16);
            lineatLayout.setPadding(0, 5, 10, 5);
            lineatLayout.setGravity(Gravity.CENTER);

            //设置点击效果
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
            stateListDrawable.addState(new int[]{}, gradientDrawable2);
            lineatLayout.setBackgroundDrawable(stateListDrawable);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FlowUtils.showToast(FlowActivity.this, textView.getText().toString());
                }
            });

            imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    flowboolean02 = false;
                    flowboolean01 = false;
                    FlowUtils.showToast(FlowActivity.this, view.getId() + "");
                    flowLayout_02.removeAllViews();
                    datas01.add(datas02.get(view.getId()));
                    datas02.remove(view.getId());
                    flowView01();
                    flowView02();
                }
            });

            flowLayout_02.addView(view);
        }
    }

    private void initData01() {
        for (int i = 0; i < 1; i++) {
            datas01.add("QQ");
            datas01.add("暴风影音");
            datas01.add("王者农药");
            datas01.add("名字非常的长,特别的长");
            datas01.add("携程");
            datas01.add("微信");
        }
    }

    private void initData02() {
        for (int i = 0; i < 1; i++) {
            datas02.add("QQ");
            datas02.add("暴风影音");
            datas02.add("王者农药");
            datas02.add("名字非常的长,特别的长");
            datas02.add("携程");
            datas02.add("微信");
        }
    }
}
