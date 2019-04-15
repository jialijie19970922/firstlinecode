package com.firstlinecode.jlj.myapplication.utli;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.Random;

public class FlowUtils {

    private static Toast toast;

    /**
     * 拿到一个随机颜色
     */
    public static int createRandomColor() {
        Random random = new Random();
        return random.nextInt(180);

    }

    //在屏幕适配时候使用,让代码中使用dip属性
    public static int getDimens(Context context, int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }
    public static void showToast(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);//如果不为空，则直接改变当前toast的文本
        }
        toast.show();
    }
}
