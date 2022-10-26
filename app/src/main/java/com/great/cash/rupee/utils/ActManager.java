package com.great.cash.rupee.utils;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;

/**
 * Date: 2020/7/9 下午4:52
 * Author: kay lau
 * Description:
 */
public class ActManager {

    /**
     * 堆栈管理对象
     */
    private static final ActivityStack STACK = new ActivityStack();
    /**
     * 当前显示的Activity
     */
    private static WeakReference<Activity> topActivity;

    /**
     * push this activity to stack
     */
    public static void push(Activity activity) {
        STACK.pushToStack(activity);
    }

    /**
     * pop top activity from stack
     */
    public static void pop() {
        Activity activity = STACK.popFromStack();
        activity.finish();
    }

    /**
     * remove this activity from stack, maybe is null
     */
    public static void remove(Activity activity) {
        STACK.removeFromStack(activity);
    }

    /**
     * finish the top activity
     */
    public static void finish() {
        if (null != topActivity && null != topActivity.get()) {
            finish(topActivity.get());
        }
    }

    /**
     * finish the activity
     */
    private static void finish(Activity activity) {
        if (null != activity) {
            activity.finish();
        }
    }

    /**
     * 当APP退出的时候，结束所有Activity
     */
    public static void finishAll() {
        while (!STACK.isEmpty()) {
            final Activity activity = STACK.popFromStack();
            if (activity != null) {
                activity.finish();
                }
            }

    }

    /**
     * activity堆栈，用以管理APP中的所有activity
     */
    private static class ActivityStack {
        // activity堆对象
        private final Stack<WeakReference<Activity>> activityStack = new Stack<>();

        /**
         * 堆是否为空
         */
        public boolean isEmpty() {
            return activityStack.isEmpty();
        }

        /**
         * 向堆中push此activity
         */
        public void pushToStack(Activity activity) {
            activityStack.push(new WeakReference<>(activity));
        }

        /**
         * 从堆栈中pop出一个activity对象
         */
        public Activity popFromStack() {
            while (!activityStack.isEmpty()) {
                final WeakReference<Activity> weak = activityStack.pop();
                final Activity activity = weak.get();
                if (activity != null) {
                    return activity;
                }
            }
            return null;
        }

        /**
         * 从堆栈中查看一个对象，且不会pop
         */
        public Activity peekFromStack() {
            while (!activityStack.isEmpty()) {
                final WeakReference<Activity> weak = activityStack.peek();
                final Activity activity = weak.get();
                if (activity != null) {
                    return activity;
                } else {
                    activityStack.pop();
                }
            }
            return null;
        }

        /**
         * 从堆栈中删除指定对象
         */
        public boolean removeFromStack(Activity activity) {
            for (WeakReference<Activity> weak : activityStack) {
                final Activity act = weak.get();
                if (act == activity) {
                    return activityStack.remove(weak);
                }
            }
            return false;
        }
    }

}
