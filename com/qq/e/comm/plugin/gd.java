package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.l6;
import com.qq.e.comm.plugin.z0;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gd {
    private final dd a;
    private final ed b;
    private final Context c;
    private final qs d;
    private ADListener e;
    private String f;

    private boolean a(int i) {
        return i == 1 || i == 2 || i == 3;
    }

    public gd(Context context, dd ddVar, ed edVar) {
        this.c = context;
        this.a = ddVar;
        this.b = edVar;
        a aVar = new a(context, ddVar);
        aVar.a(edVar);
        this.d = aVar;
    }

    /* compiled from: A */
    class a extends cz {
        private boolean f;
        private final z0.a g;

        a(Context context, m mVar) {
            super(context, mVar);
            this.g = new C0709a();
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.gd$a$a, reason: collision with other inner class name */
        class C0709a implements z0.a {
            C0709a() {
            }

            @Override // com.qq.e.comm.plugin.z0.a
            public void a() {
                if (gd.this.e != null) {
                    if (a.this.f) {
                        a.this.a(302);
                    }
                    a.this.a(1003);
                }
            }
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public boolean b(String str, h4 h4Var) {
            boolean zB = super.b(str, h4Var);
            if (zB) {
                a(1002);
                this.f = false;
                z0.a(this.g);
            }
            return zB;
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public void g() {
            super.g();
            a(1007);
        }

        /* compiled from: A */
        class b implements Runnable {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (gd.this.e != null) {
                    gd.this.e.onADEvent(new ADEvent(this.a, new Object[0]));
                }
            }
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public void a(boolean z) {
            super.a(z);
            if (z) {
                a(303);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            xo.a((Runnable) new b(i));
        }
    }

    void a(i6 i6Var) {
        this.a.a(200);
        dd ddVar = this.a;
        if (ddVar.h == null) {
            qm$h$$ExternalSyntheticBackport0.m(this.a.h);
            return;
        }
        ddVar.a((View) null);
        String str = i6Var.b;
        l6 l6VarA = new l6.b(this.b).a(str).a(i6Var).a();
        if (a(i6Var.f)) {
            j6.b(l6VarA, this.d);
        } else {
            j6.a(l6VarA, this.d);
        }
        zv.a(this.a.j(), this.b, str);
        this.a.a(105, new Object[0]);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            dd ddVar = this.a;
            if (ddVar.h != null) {
                ddVar.a((View) null);
                u2.a().a(this.a.j(), this.b, str);
                r5 r5VarD = u2.a().d(this.a.j());
                i6 i6Var = new i6(this.b);
                if (r5VarD != null) {
                    r5VarD.a(i6Var);
                }
                this.f = u2.a().a(this.a.j());
                j6.a(new l6.b(this.b).a(this.f).a(i6Var).a(), this.d);
                zv.a(this.a.j(), this.b, this.f);
                this.a.a(105, new Object[0]);
                return;
            }
        }
        qm$h$$ExternalSyntheticBackport0.m(this.a.h);
    }

    void a(ADListener aDListener) {
        this.e = aDListener;
    }
}
