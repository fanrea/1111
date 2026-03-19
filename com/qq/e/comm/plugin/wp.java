package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wp extends TextView {
    private final h4 a;
    private final b b;

    /* compiled from: A */
    public interface b {
        public static final Map<String, WeakReference<b>> l = new HashMap();

        void d();

        void k();
    }

    public wp(Context context, h4 h4Var, b bVar) {
        super(context);
        this.a = h4Var;
        this.b = bVar;
        a();
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        final /* synthetic */ i3 a;

        a(i3 i3Var) {
            this.a = i3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            wp.this.getVisibility();
            if (this.a != null) {
                vp.a(wp.this.a, wp.this.b);
            } else {
                n20.g("获取不到应用信息，无法显示");
            }
        }
    }

    private void a() {
        setTextSize(2, 9.0f);
        setEllipsize(TextUtils.TruncateAt.END);
        l3 l3VarO = this.a.o();
        i3 i3VarB = l3VarO == null ? null : l3VarO.b();
        if (i3VarB == null) {
            b10.a(9130070, f5.a(this.a), 1);
            return;
        }
        setBackgroundColor(0);
        setTextColor(-1);
        setText(vp.a(this.a));
        setOnClickListener(new a(i3VarB));
    }

    public static View a(Context context) {
        View view = new View(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setColors(new int[]{0, 2130706432});
        } else {
            gradientDrawable.setColor(2130706432);
        }
        view.setBackgroundDrawable(gradientDrawable);
        return view;
    }

    /* compiled from: A */
    public static class c extends c30 {
        private h4 a;

        @Override // com.qq.e.comm.plugin.c30
        public String a() {
            return "clickMIITInfo";
        }

        public c(h4 h4Var) {
            this.a = h4Var;
        }

        @Override // com.qq.e.comm.plugin.c30
        public void a(jm jmVar, ug ugVar) {
            h4 h4Var = this.a;
            if (h4Var == null || h4Var.o() == null || this.a.o().b() == null) {
                return;
            }
            vp.a(this.a, null);
        }
    }
}
