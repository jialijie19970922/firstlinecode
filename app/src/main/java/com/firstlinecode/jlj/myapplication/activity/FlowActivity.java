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

public class FlowActivity extends AppCompatActivity {

    private FlowLayout flowLayout;
    ArrayList<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        flowLayout = findViewById(R.id.fly);

        initData();

        for (int i = 0; i < datas.size(); i++) {
            View view = View.inflate(this, R.layout.flow_itme_view, null);
            final LinearLayout lineatLayout = view.findViewById(R.id.flow_lin);
            final ImageView imgView = view.findViewById(R.id.flow_img);
            final TextView textView = view.findViewById(R.id.flow_tv);
            imgView.setId(i);
            lineatLayout.setOrientation(LinearLayout.HORIZONTAL);
            textView.setText(datas.get(i));
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
            lineatLayout.setPadding(10, 5, 10, 5);
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
                    FlowUtils.showToast(FlowActivity.this, view.getId() + "");
                }
            });

            flowLayout.addView(view);
        }
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            datas.add("QQ");
            datas.add("暴风影音");
            datas.add("王者农药");
            datas.add("名字非常的长,特别的长");
            datas.add("携程");
            datas.add("微信");
        }
    }
}
