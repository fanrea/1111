package com.lingku.xuanshang.tjlib.apploader;

import android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lkxssdk.a.a;
import lkxssdk.a0.b;
import lkxssdk.v.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NonWifiWarnActivity extends Activity {
    public static final /* synthetic */ int a = 0;

    public StateListDrawable a(int i, int[] iArr, int[] iArr2) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        gradientDrawable.setShape(0);
        float f = i;
        gradientDrawable.setCornerRadius(f);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr2);
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(f);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[]{-16842919}, gradientDrawable2);
        return stateListDrawable;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        DisplayMetrics displayMetrics;
        Resources resources = super.getResources();
        float fMin = (Math.min(resources.getDisplayMetrics().widthPixels, resources.getDisplayMetrics().heightPixels) * 72.0f) / 375;
        resources.getDisplayMetrics().xdpi = fMin;
        List<Field> list = a.g;
        if (list == null) {
            a.g = new ArrayList();
            Class<?> superclass = resources.getClass();
            Field[] declaredFields = superclass.getDeclaredFields();
            while (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                        field.setAccessible(true);
                        try {
                            displayMetrics = (DisplayMetrics) field.get(resources);
                        } catch (Exception e) {
                            Log.e("AdaptScreenUtils", "getMetricsFromField: " + e);
                            displayMetrics = null;
                        }
                        if (displayMetrics != null) {
                            a.g.add(field);
                            displayMetrics.xdpi = fMin;
                        }
                    }
                }
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    break;
                }
                declaredFields = superclass.getDeclaredFields();
            }
        } else {
            Iterator<Field> it = list.iterator();
            while (it.hasNext()) {
                try {
                    DisplayMetrics displayMetrics2 = (DisplayMetrics) it.next().get(resources);
                    if (displayMetrics2 != null) {
                        displayMetrics2.xdpi = fMin;
                    }
                } catch (Exception e2) {
                    Log.e("AdaptScreenUtils", "applyMetricsFields: " + e2);
                }
            }
        }
        return resources;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        int iA = a.a(8.0f);
        int iA2 = a.a(290.0f);
        int iA3 = a.a(20.0f);
        int iA4 = a.a(10.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA2, -2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(iA);
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        layoutParams.addRule(13);
        relativeLayout.addView(linearLayout, layoutParams);
        linearLayout.addView(new View(this), new LinearLayout.LayoutParams(-1, iA3));
        TextView textView = new TextView(this);
        textView.setText("当前为移动网络状态，下载将消耗移动网络流量，是否继续下载？");
        textView.setTextColor(Color.parseColor("#333333"));
        textView.setTextSize(3, 16.0f);
        textView.setGravity(17);
        textView.setPadding(iA3, iA3, iA3, iA3);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(iA4, 0, iA4, iA3);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, b.a(60.0f)));
        TextView textView2 = new TextView(this);
        textView2.setGravity(17);
        textView2.setText("取消");
        textView2.setTextSize(3, 14.0f);
        textView2.setTextColor(-1);
        textView2.setBackgroundDrawable(a(iA3, new int[]{Color.parseColor("#786BD8FF"), Color.parseColor("#783AC0FF"), Color.parseColor("#7808A8FF")}, new int[]{Color.parseColor("#6BD8FF"), Color.parseColor("#3AC0FF"), Color.parseColor("#08A8FF")}));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        layoutParams2.leftMargin = iA4;
        layoutParams2.rightMargin = iA4;
        linearLayout2.addView(textView2, layoutParams2);
        textView2.setOnClickListener(new lkxssdk.v.a(this));
        TextView textView3 = new TextView(this);
        textView3.setGravity(17);
        textView3.setText("继续下载");
        textView3.setTextSize(3, 14.0f);
        textView3.setTextColor(-1);
        textView3.setBackgroundDrawable(a(iA3, new int[]{Color.parseColor("#78FFA326"), Color.parseColor("#78FF8327"), Color.parseColor("#78FF6227")}, new int[]{Color.parseColor("#FFA326"), Color.parseColor("#FF8327"), Color.parseColor("#FF6227")}));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.weight = 1.0f;
        layoutParams3.leftMargin = iA4;
        layoutParams3.rightMargin = iA4;
        linearLayout2.addView(textView3, layoutParams3);
        textView3.setOnClickListener(new lkxssdk.v.b(this));
        setContentView(relativeLayout);
        relativeLayout.setOnTouchListener(new c(this));
    }
}
