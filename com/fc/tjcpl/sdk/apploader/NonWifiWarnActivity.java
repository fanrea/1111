package com.fc.tjcpl.sdk.apploader;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fc.tjcpl.sdk.b.a;
import com.fc.tjcpl.sdk.b.b;
import com.fc.tjcpl.sdk.b.c;
import com.fc.tjcpl.sdk.g.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class NonWifiWarnActivity extends Activity {
    public static final /* synthetic */ int a = 0;

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a.a(30.0f), 0, a.a(30.0f), 0);
        int iA = a.a(5.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(iA);
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        relativeLayout.addView(linearLayout, layoutParams);
        TextView textView = new TextView(this);
        textView.setText("当前为移动网络状态，下载将消耗移动网络流量，是否继续下载？");
        textView.setTextColor(Color.parseColor("#333333"));
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        textView.setMinHeight(a.a(90.0f));
        textView.setPadding(a.a(15.0f), 0, a.a(15.0f), 0);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(0, a.a(0.5f), 0, 0);
        float fA = a.a(5.0f);
        float[] fArr = new float[8];
        fArr[0] = 0.0f;
        fArr[0] = 0.0f;
        fArr[0] = 0.0f;
        fArr[0] = 0.0f;
        fArr[4] = fA;
        fArr[5] = fA;
        fArr[6] = fA;
        fArr[7] = fA;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadii(fArr);
        gradientDrawable2.setColor(Color.parseColor("#ebebeb"));
        linearLayout2.setBackgroundDrawable(gradientDrawable2);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, a.a(40.0f)));
        Button button = new Button(this);
        button.setGravity(17);
        button.setText("取消");
        button.setTextSize(13.0f);
        button.setTextColor(Color.parseColor("#999999"));
        float[] fArr2 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        fArr2[4] = 0.0f;
        fArr2[5] = 0.0f;
        fArr2[6] = fA;
        fArr2[7] = fA;
        button.setBackgroundDrawable(d.a(fArr2, "#F7F7F7", "#FFFFFF"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        linearLayout2.addView(button, layoutParams2);
        button.setOnClickListener(new b(this));
        Button button2 = new Button(this);
        button2.setGravity(17);
        button2.setText("继续下载");
        button2.setTextSize(13.0f);
        button2.setTextColor(Color.parseColor("#079AFF"));
        float[] fArr3 = new float[8];
        fArr3[0] = 0.0f;
        fArr3[0] = 0.0f;
        fArr3[0] = 0.0f;
        fArr3[0] = 0.0f;
        fArr3[4] = fA;
        fArr3[5] = fA;
        fArr3[6] = 0.0f;
        fArr3[7] = 0.0f;
        button2.setBackgroundDrawable(d.a(fArr3, "#F7F7F7", "#FFFFFF"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.weight = 1.0f;
        layoutParams3.setMargins(a.a(0.5f), 0, 0, 0);
        linearLayout2.addView(button2, layoutParams3);
        button2.setOnClickListener(new c(this));
        setContentView(relativeLayout);
        relativeLayout.setOnTouchListener(new com.fc.tjcpl.sdk.b.d(this));
    }
}
