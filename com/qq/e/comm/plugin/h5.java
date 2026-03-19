package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qq.e.comm.pi.ACTD;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h5 implements ACTD {
    private static String b;
    private final Activity a;

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    public h5(Activity activity) {
        this.a = activity;
        if (b == null) {
            b = r1.d().f().b("skfwstr", "网络异常");
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(this.a);
        TextView textView = new TextView(this.a);
        textView.setText(b);
        textView.setTextSize(1, 24.0f);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#CCCCCC"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int iA = yu.a((Context) this.a, 40);
        layoutParams.leftMargin = iA;
        layoutParams.rightMargin = iA;
        textView.setLayoutParams(layoutParams);
        frameLayout.addView(textView);
        TextView textView2 = new TextView(this.a);
        textView2.setText("返回");
        textView2.setBackgroundColor(Color.parseColor("#3185FC"));
        textView2.setTextColor(Color.parseColor("#FFFFFF"));
        textView2.setTextSize(1, 18.0f);
        textView2.setGravity(17);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(yu.a((Context) this.a, 136), yu.a((Context) this.a, 40));
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = yu.a((Context) this.a, 90);
        textView2.setLayoutParams(layoutParams2);
        frameLayout.addView(textView2);
        textView2.setOnClickListener(new a());
        this.a.setContentView(frameLayout);
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h5.this.a.finish();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        this.a.finish();
    }
}
