package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class fq extends FrameLayout implements al {
    private ek a;
    private ek b;
    private final ek c;
    private final Context d;
    private final h4 e;
    private dk f;
    private a g;

    /* compiled from: A */
    public interface a {
        void a(View view, String str);

        void b();
    }

    @Override // com.qq.e.comm.plugin.al
    public View a() {
        return this;
    }

    public fq(Context context, h4 h4Var) {
        super(context);
        this.d = context;
        this.e = h4Var;
        this.c = new gq(context, h4Var);
        b();
    }

    private void b() {
        ek ekVar = this.b;
        if (ekVar != null) {
            ekVar.destroy();
            removeView(this.b.a());
        }
        this.f = new fc(new ec(this.e));
        try {
            hc hcVar = new hc(this.f, new qh(this.d, this.e, true).a());
            this.b = hcVar;
            hcVar.a(this.g);
            this.f.a(this.b);
            addView(this.b.a());
            this.a = this.b;
        } catch (Exception unused) {
            this.a = this.c;
        }
    }

    @Override // com.qq.e.comm.plugin.al
    public void a(a aVar) {
        this.g = aVar;
        ek ekVar = this.b;
        if (ekVar != null) {
            ekVar.a(aVar);
        }
        this.c.a(aVar);
    }

    @Override // com.qq.e.comm.plugin.al
    public void show() {
        ek ekVar = this.b;
        if (ekVar == null || !ekVar.show()) {
            b();
            View viewA = this.c.a();
            b50.a(viewA);
            addView(viewA);
            this.c.show();
            this.a = this.c;
        }
    }

    @Override // com.qq.e.comm.plugin.al
    public void destroy() {
        ek ekVar = this.b;
        if (ekVar != null) {
            ekVar.destroy();
        }
        this.c.destroy();
    }

    @Override // com.qq.e.comm.plugin.al
    public void c() {
        this.a.dismiss();
        ek ekVar = this.a;
        ek ekVar2 = this.c;
        if (ekVar == ekVar2) {
            removeView(ekVar2.a());
            b();
        }
        this.f.c();
    }
}
