package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vd extends p6 {

    /* compiled from: A */
    public interface c {
        void a();

        void b();
    }

    public vd(Context context) {
        super(context);
        setCancelable(false);
    }

    public void a(Activity activity, h4 h4Var, sd sdVar, String str, String str2, String str3, c cVar) {
        if (!isShowing()) {
            boolean zA = ua.a(h4Var);
            ua.d(activity, zA);
            show();
            ua.b(activity, zA, false);
            ua.a(activity, zA);
        }
        LinearLayout linearLayoutA = a(activity, sdVar.i(), str, str2, str3);
        setContentView(linearLayoutA);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            linearLayoutA.measure(0, 0);
            attributes.width = linearLayoutA.getMeasuredWidth();
            attributes.height = linearLayoutA.getMeasuredHeight();
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setBackgroundDrawable(gx.a(yu.a((Context) activity, 10), -1, 255));
        }
        a().setOnClickListener(new a(cVar));
        b().setOnClickListener(new b(cVar));
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.b();
            vd.this.cancel();
        }
    }

    /* compiled from: A */
    class b implements View.OnClickListener {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.a();
            vd.this.cancel();
        }
    }
}
