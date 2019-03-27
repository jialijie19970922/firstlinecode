package com.firstlinecode.jlj.myapplication.utli;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/26/026.
 * 活动管理器
 *
 * 此工具类的作用：随时随地退出程序
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
        // killProcess方法用于杀掉一个进程，它接收一个进程id参数，我们可以通过myPid()方法来获取当前程序的进程id
        android.os.Process.killProcess(android.os.Process.myPid());// 杀掉进程
    }
}
