package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.wd;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class so implements wd.b {
    private final Activity a;
    private e b;
    private final String c;
    private String[] d;
    private f e;
    private Dialog f;
    private DialogInterface.OnDismissListener g;
    private final h4 h;

    /* compiled from: A */
    public interface f {
        void onComplainSuccess();
    }

    private TextView d() {
        TextView textView = new TextView(this.a);
        textView.setTextColor(-13421773);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        textView.setHeight(yu.a((Context) this.a, 57));
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return textView;
    }

    public so(Activity activity, h4 h4Var) {
        this.a = activity;
        this.h = h4Var;
        this.c = h4Var.y();
        if (activity == null) {
            return;
        }
        h();
        g();
    }

    private void h() {
        try {
            this.d = r1.d().f().b("lcpi", "了解广告平台,https://e.qq.com/dev/index.html").split(",");
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    protected void g() {
        e eVar = new e(this.a, this);
        this.b = eVar;
        eVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        c();
        b();
        a();
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            wd.a().a(so.this.c, so.this);
            so.this.f();
            o5.a(so.this.h, so.this.c);
        }
    }

    public so(Context context, h4 h4Var) {
        this(c1.a(context), h4Var);
    }

    /* compiled from: A */
    class b implements View.OnClickListener {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            so.this.f();
            o5.a(this.a);
        }
    }

    private void b() {
        TextView textViewD = d();
        textViewD.setText("投诉此广告");
        String[] strArr = this.d;
        if (strArr != null && strArr.length >= 2) {
            textViewD.setBackgroundColor(-1);
        } else {
            textViewD.setBackgroundDrawable(e());
        }
        this.b.addView(textViewD);
        textViewD.setOnClickListener(new a());
    }

    private ShapeDrawable e() {
        float fA = yu.a((Context) this.a, 12);
        return gx.a(fA, fA, 0.0f, 0.0f, -1, 255);
    }

    private void c() {
        String[] strArr = this.d;
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        for (int i = 1; i < length; i += 2) {
            String[] strArr2 = this.d;
            String str = strArr2[i - 1];
            String str2 = strArr2[i];
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                TextView textViewD = d();
                if (i == 1) {
                    textViewD.setBackgroundDrawable(e());
                } else {
                    textViewD.setBackgroundColor(-1);
                }
                textViewD.setText(str);
                textViewD.setOnClickListener(new b(str2));
                this.b.addView(textViewD);
                this.b.addView(a(2));
            }
        }
    }

    /* compiled from: A */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            so.this.f();
        }
    }

    public so(View view, h4 h4Var) {
        this(c1.a(view), h4Var);
    }

    public void f() {
        try {
            Dialog dialog = this.f;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f.dismiss();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void a() {
        View viewA = a(yu.a((Context) this.a, 8));
        viewA.setBackgroundColor(-526345);
        this.b.addView(viewA);
        TextView textViewD = d();
        textViewD.setText("取消");
        textViewD.setBackgroundColor(-1);
        this.b.addView(textViewD);
        textViewD.setOnClickListener(new c());
    }

    public void j() {
        if (this.a == null) {
            return;
        }
        Dialog dialog = new Dialog(this.a);
        this.f = dialog;
        dialog.setContentView(this.b);
        this.f.setOnDismissListener(new d());
        Window window = this.f.getWindow();
        if (window == null) {
            return;
        }
        window.setWindowAnimations(0);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(80);
        window.setLayout(-1, -2);
        try {
            this.f.show();
            k();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* compiled from: A */
    class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (so.this.g != null) {
                so.this.g.onDismiss(dialogInterface);
            }
        }
    }

    private void k() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setDuration(200L);
        e eVar = this.b;
        if (eVar != null) {
            eVar.startAnimation(translateAnimation);
        }
    }

    /* compiled from: A */
    private static class e extends LinearLayout {
        private final so a;

        public e(Context context, so soVar) {
            super(context);
            this.a = soVar;
            setOrientation(1);
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            this.a.f();
        }
    }

    public boolean i() {
        Dialog dialog = this.f;
        if (dialog == null) {
            return false;
        }
        return dialog.isShowing();
    }

    @Override // com.qq.e.comm.plugin.wd.b
    public void a(String str, int i, Object obj) {
        f fVar = this.e;
        if (fVar != null && i == 10016) {
            fVar.onComplainSuccess();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.g = onDismissListener;
    }

    public void a(f fVar) {
        this.e = fVar;
    }

    private View a(int i) {
        View view = new View(this.a);
        view.setBackgroundColor(-1513240);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        return view;
    }
}
