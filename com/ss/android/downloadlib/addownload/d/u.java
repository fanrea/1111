package com.ss.android.downloadlib.addownload.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.downloadlib.h.uo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u extends Dialog {
    private String an;
    private boolean b;
    private boolean c;
    private c d;
    private String gb;
    private String h;
    private b hc;
    private String tt;
    private Activity u;

    public u(Activity activity, String str, String str2, String str3, String str4, boolean z, c cVar, b bVar) {
        super(activity);
        this.u = activity;
        this.d = cVar;
        this.an = str;
        this.h = str2;
        this.gb = str3;
        this.tt = str4;
        this.hc = bVar;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(z);
        d(this.u);
    }

    private void d(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d(context, 290), -2);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setBackground(d(context, "#ffffff", 4));
        linearLayout2.setOrientation(1);
        int iD = d(context, 16);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setText("是否在WiFi环境下恢复下载？");
        textView.setTextColor(Color.parseColor("#222222"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(iD, iD, iD, iD);
        textView.setLayoutParams(layoutParams3);
        if (!TextUtils.isEmpty(this.an)) {
            textView.setText(this.an);
        }
        linearLayout2.addView(textView);
        LinearLayout linearLayout3 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = d(context, 26);
        layoutParams4.bottomMargin = iD;
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(layoutParams4);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(d(context, 70), d(context, 33)));
        textView2.setText("管理");
        textView2.setTextColor(Color.parseColor("#CFCFCF"));
        textView2.setTextSize(2, 13.0f);
        textView2.setGravity(17);
        if (!TextUtils.isEmpty(this.tt)) {
            textView2.setText(this.tt);
            linearLayout3.addView(textView2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.d.u.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    u.this.delete();
                }
            });
        }
        LinearLayout linearLayout4 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout4.setOrientation(0);
        layoutParams5.rightMargin = d(context, 16);
        linearLayout4.setGravity(5);
        linearLayout4.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(context);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(d(context, 70), d(context, 33)));
        textView3.setTextColor(Color.parseColor("#CFCFCF"));
        textView3.setText("不，谢谢");
        textView3.setTextSize(2, 13.0f);
        textView3.setGravity(17);
        if (!TextUtils.isEmpty(this.gb)) {
            textView3.setText(this.gb);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.d.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u.this.hc();
            }
        });
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(d(context, 70), d(context, 33));
        layoutParams6.leftMargin = d(context, 8);
        layoutParams6.gravity = 5;
        textView4.setLayoutParams(layoutParams6);
        textView4.setTextColor(Color.parseColor("#ffffff"));
        textView4.setTextSize(2, 13.0f);
        textView4.setText("好的");
        textView4.setGravity(17);
        if (!TextUtils.isEmpty(this.h)) {
            textView4.setText(this.h);
        }
        textView4.setBackground(d(context, "#2A90D7", 2));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.d.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u.this.d();
            }
        });
        linearLayout4.addView(textView4);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    private static GradientDrawable d(Context context, String str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(d(context, i));
        return gradientDrawable;
    }

    private static int d(Context context, int i) {
        return uo.d(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.b = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.c = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.u.isFinishing()) {
            this.u.finish();
        }
        if (this.b) {
            this.d.d();
        } else if (this.c) {
            this.hc.delete();
        } else {
            this.d.hc();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public static class d {
        private boolean an;
        private String b;
        private String c;
        private Activity d;
        private b gb;
        private c h;
        private String hc;
        private String u;

        public d(Activity activity) {
            this.d = activity;
        }

        public d d(String str) {
            this.hc = str;
            return this;
        }

        public d hc(String str) {
            this.b = str;
            return this;
        }

        public d b(String str) {
            this.c = str;
            return this;
        }

        public d c(String str) {
            this.u = str;
            return this;
        }

        public d d(boolean z) {
            this.an = z;
            return this;
        }

        public d d(c cVar) {
            this.h = cVar;
            return this;
        }

        public d d(b bVar) {
            this.gb = bVar;
            return this;
        }

        public u d() {
            return new u(this.d, this.hc, this.b, this.c, this.u, this.an, this.h, this.gb);
        }
    }
}
