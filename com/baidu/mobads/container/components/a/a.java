package com.baidu.mobads.container.components.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.bv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends RelativeLayout {
    private static final int c = 100000;
    private static final int d = 100001;
    private static final int e = 100002;
    Context a;
    k b;

    public a(Context context, boolean z, int i, String str, k kVar) {
        super(context);
        this.a = context;
        this.b = kVar;
        if (z) {
            setBackgroundColor(Color.parseColor("#64000000"));
        } else {
            setBackgroundColor(Color.parseColor("#00000000"));
        }
        setOnClickListener(new b(this));
        a(i, str);
    }

    public void a(int i, String str) {
        switch (i) {
            case 201:
                a("确定要放弃下载吗", "", "立即下载", "放弃");
                break;
            case 202:
                a("点击下载立即体验", "", "立即下载", "取消");
                break;
            case 203:
                a("您下载的“" + str + "”未下载完成，要继续下载吗？", "", "继续下载", "取消");
                break;
            case 204:
                a("已下载完成", "“" + str + "”已下载完成，是否现在安装？", "现在安装", "以后再说");
                break;
            case 205:
            case 206:
                a("已安装完成", "“" + str + "”已安装完成，是否现在打开？", "现在打开", "以后再说");
                break;
            default:
                a("未知弹窗", "", "取消", "取消");
                break;
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.a);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius(bv.a(this.a, 18.0f));
            relativeLayout.setBackground(gradientDrawable);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            layoutParams.rightMargin = bv.a(this.a, 34.0f);
            layoutParams.leftMargin = bv.a(this.a, 34.0f);
            addView(relativeLayout, layoutParams);
            RelativeLayout relativeLayout2 = new RelativeLayout(this.a);
            relativeLayout2.setId(100000);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(14);
            layoutParams2.topMargin = bv.a(this.a, 27.0f);
            layoutParams2.bottomMargin = bv.a(this.a, 28.0f);
            layoutParams2.leftMargin = bv.a(this.a, 26.0f);
            layoutParams2.rightMargin = bv.a(this.a, 26.0f);
            relativeLayout.addView(relativeLayout2, layoutParams2);
            TextView textView = new TextView(this.a);
            textView.setId(100001);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextSize(18.0f);
            textView.setTypeface(null, 1);
            textView.setTextColor(-16777216);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(14);
            relativeLayout2.addView(textView, layoutParams3);
            if (!TextUtils.isEmpty(str2)) {
                TextView textView2 = new TextView(this.a);
                textView2.setText(str2);
                textView2.setTextSize(12.0f);
                textView2.setGravity(17);
                textView2.setTextColor(Color.parseColor("#333333"));
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.addRule(3, 100001);
                layoutParams4.addRule(14);
                layoutParams4.topMargin = bv.a(this.a, 11.0f);
                relativeLayout2.addView(textView2, layoutParams4);
            }
            View view = new View(this.a);
            view.setBackgroundColor(Color.parseColor("#0a000000"));
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, bv.a(this.a, 1.0f));
            layoutParams5.addRule(3, 100000);
            relativeLayout.addView(view, layoutParams5);
            TextView textView3 = new TextView(this.a);
            textView3.setId(e);
            textView3.setText(str3);
            textView3.setTypeface(null, 1);
            textView3.setOnClickListener(new c(this));
            textView3.setTextSize(16.0f);
            textView3.setTextColor(Color.parseColor("#3789FD"));
            textView3.setPadding(0, bv.a(this.a, 14.0f), 0, bv.a(this.a, 14.0f));
            textView3.setGravity(17);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams6.addRule(3, 100000);
            layoutParams6.topMargin = bv.a(this.a, 1.0f);
            relativeLayout.addView(textView3, layoutParams6);
            View view2 = new View(this.a);
            view2.setBackgroundColor(Color.parseColor("#0a000000"));
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, bv.a(this.a, 1.0f));
            layoutParams7.addRule(3, e);
            relativeLayout.addView(view2, layoutParams7);
            TextView textView4 = new TextView(this.a);
            textView4.setText(str4);
            textView4.setTypeface(null, 1);
            textView4.setTextSize(16.0f);
            textView4.setOnClickListener(new d(this));
            textView4.setTextColor(Color.parseColor("#999999"));
            textView4.setPadding(0, bv.a(this.a, 14.0f), 0, bv.a(this.a, 14.0f));
            textView4.setGravity(17);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams8.addRule(3, e);
            layoutParams8.topMargin = bv.a(this.a, 1.0f);
            relativeLayout.addView(textView4, layoutParams8);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
