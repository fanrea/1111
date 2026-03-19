package com.qq.e.comm.plugin;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class n50 extends i0 implements sh {
    private final Context d;
    private final String e;
    private ViewGroup f;
    private jm g;
    private ProgressBar h;
    private Button i;
    private boolean j;

    private FrameLayout g() {
        FrameLayout frameLayout = new FrameLayout(this.d);
        this.f = l();
        frameLayout.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        this.f.setVisibility(8);
        ProgressBar progressBar = new ProgressBar(this.d);
        this.h = progressBar;
        progressBar.setIndeterminate(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(this.h, layoutParams);
        Button button = new Button(this.d);
        this.i = button;
        button.setText("重新加载");
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.i.setVisibility(8);
        frameLayout.addView(this.i, layoutParams2);
        return frameLayout;
    }

    private View h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.d);
        TextView textView = new TextView(this.d);
        textView.setText("应用详情");
        textView.setTextSize(18.0f);
        textView.setTextColor(-16777216);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        this.a = new ImageView(this.d);
        int iA = yu.a(this.d, 15);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams2.addRule(21);
        layoutParams2.addRule(15);
        relativeLayout.addView(this.a, layoutParams2);
        this.a.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAABkAAAAZCAYAAADE6YVjAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAGaADAAQAAAABAAAAGQAAAABY85deAAABiklEQVRIDa2WwW2DMBSGsZtTB0AMkEP36A1YoO2tirJO71HFreoCwK0bMEAOGQB1h0D/37JRQjB+hFoiD+L/fx9+2GDVNM1j27Z7pdRvmqbfiH20svV9r+q6fkGMkyQ5bAjAxQeOqKqqZ8TdGhD8Cnk+Ed95r8gfaY7A3Tg7rEC5/5bEMYBe5te2RIVLdi/IAyhMfib3CbIsE5Uu5B/KEhK6kY6jxDdA7hmRBMC8V5AlIClgEiIBLQF4IQHQHtP8AJBZByaJUsXcJLkpF02uTd0x+k44tk6DdTALoG4WQoEHxC4utCDA6Iw68APQQ1mWR8iGEeD8lOf5E0DngD3SIYEdyWEEoG1rn02wGrMQT6n4TExDv+hd54VMAfgMbIkWvesmIT6AnaZnG8Wgm3oGAMMHTapjXa8gS4w0S/UDRGpg8ssm8RmIRHiZeHwe8quQYJzQdz2bBwvqteu6L2eWviqc/jJOgbTWbxodsROuATAH/P3E9I433Bdx2wLBv+y7CELbYd/1wwEw/x/EKvlUxiHD9QAAAABJRU5ErkJggg=="));
        return relativeLayout;
    }

    private ViewGroup l() {
        LinearLayout linearLayout = new LinearLayout(this.d);
        linearLayout.setOrientation(1);
        jm jmVarA = new qh(this.d).a();
        this.g = jmVarA;
        jmVarA.a(this);
        this.g.b().a("download_confirm_service", new a());
        View viewA = this.g.a();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, yu.a(this.d, 12));
        layoutParams.weight = 1.0f;
        linearLayout.addView(viewA, layoutParams);
        int iA = yu.a(this.d, 44);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, iA);
        layoutParams2.weight = 0.0f;
        c(iA);
        linearLayout.addView(this.b, layoutParams2);
        return linearLayout;
    }

    @Override // com.qq.e.comm.plugin.sh
    public void a(int i) {
    }

    @Override // com.qq.e.comm.plugin.sh
    public void a(String str, Bitmap bitmap) {
    }

    @Override // com.qq.e.comm.plugin.sh
    public boolean a(ValueCallback<Uri[]> valueCallback, Intent intent) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.sh
    public void b(ValueCallback<Uri> valueCallback, Intent intent) {
    }

    @Override // com.qq.e.comm.plugin.sh
    public void b(String str) {
    }

    @Override // com.qq.e.comm.plugin.sh
    public void c() {
    }

    @Override // com.qq.e.comm.plugin.sh
    public void d(String str) {
    }

    public n50(Context context, sp spVar, String str) {
        super(context, spVar);
        this.j = false;
        this.d = context;
        this.e = str;
        j();
    }

    private void j() {
        int iA = yu.a(this.d, 20);
        setPadding(iA, yu.a(this.d, 16), iA, yu.a(this.d, 15));
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 0.0f;
        addView(h(), layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.setMargins(0, yu.a(this.d, 20), 0, 0);
        addView(g(), layoutParams2);
    }

    /* compiled from: A */
    class a extends e30 {
        a() {
        }

        @Override // com.qq.e.comm.plugin.e30
        public ih<String> a(jm jmVar, ug ugVar) {
            JSONObject jSONObjectD = ugVar.d();
            qm$h$$ExternalSyntheticBackport0.m(jSONObjectD);
            if (jmVar.a() != null && jSONObjectD != null) {
                if ("download_confirm_action".equals(ugVar.a())) {
                    n50.this.p();
                    return new ih<>("");
                }
                return new ih<>(null);
            }
            return new ih<>(null);
        }
    }

    private void c(int i) {
        Button button = new Button(this.d, null, R.attr.borderlessButtonStyle);
        this.b = button;
        button.setTextSize(16.0f);
        this.b.setTextColor(-1);
        this.b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i / 2);
        gradientDrawable.setColor(-13531652);
        this.b.setBackgroundDrawable(gradientDrawable);
    }

    void m() {
        if (TextUtils.isEmpty(this.e)) {
            this.h.setVisibility(8);
            this.f.setVisibility(8);
            this.i.setVisibility(0);
            this.i.setText("抱歉，应用信息获取失败");
            this.i.setEnabled(false);
            return;
        }
        this.j = false;
        this.g.loadUrl(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.j = true;
        this.h.setVisibility(8);
        this.f.setVisibility(8);
        this.i.setVisibility(0);
        this.i.setText("重新加载");
        this.i.setEnabled(true);
    }

    @Override // com.qq.e.comm.plugin.i0
    void e() {
        m();
    }

    @Override // com.qq.e.comm.plugin.sh
    public void a(int i, String str, String str2) {
        p();
    }

    @Override // com.qq.e.comm.plugin.sh
    public void c(String str) {
        if (this.j) {
            return;
        }
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.f.setVisibility(0);
    }

    @Override // com.qq.e.comm.plugin.i0
    void a(View view) {
        if (view == this.i) {
            m();
        }
    }

    @Override // com.qq.e.comm.plugin.i0
    void a(View.OnClickListener onClickListener) {
        super.a(onClickListener);
        this.i.setOnClickListener(onClickListener);
    }
}
