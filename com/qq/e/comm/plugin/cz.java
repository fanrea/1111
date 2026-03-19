package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cz implements qs {
    protected WeakReference<Context> a;
    protected WeakReference<m> b;
    private f c;
    protected at d;
    protected DialogStateCallback e;

    /* compiled from: A */
    private interface f {
        void a();

        void b();
    }

    @Override // com.qq.e.comm.plugin.qs
    public void g() {
    }

    @Override // com.qq.e.comm.plugin.qs
    public void i() {
        n20.g("未知异常，稍后重试");
    }

    public cz(Context context) {
        this(context, null);
    }

    @Override // com.qq.e.comm.plugin.qs
    public boolean b(String str, h4 h4Var) {
        if (h4Var == null) {
            return false;
        }
        return o5.a(str, h4Var);
    }

    /* compiled from: A */
    class a implements rs {
        final /* synthetic */ rs a;

        a(rs rsVar) {
            this.a = rsVar;
        }

        @Override // com.qq.e.comm.plugin.rs
        public void onCancel() {
            this.a.onCancel();
        }

        @Override // com.qq.e.comm.plugin.rs
        public boolean a(JSONObject jSONObject) {
            return this.a.a(jSONObject);
        }

        @Override // com.qq.e.comm.plugin.rs
        public void b(boolean z) {
            DialogStateCallback dialogStateCallback = cz.this.e;
            if (dialogStateCallback != null) {
                dialogStateCallback.i().b(4);
            }
            this.a.b(z);
        }

        @Override // com.qq.e.comm.plugin.rs
        public void a(boolean z) {
            DialogStateCallback dialogStateCallback = cz.this.e;
            if (dialogStateCallback != null) {
                dialogStateCallback.j().b(4);
            }
            this.a.a(z);
        }
    }

    public cz(Context context, m mVar) {
        this.a = new WeakReference<>(context);
        this.b = new WeakReference<>(mVar);
    }

    @Override // com.qq.e.comm.plugin.qs
    public void b(String str) {
        Context context = this.a.get();
        if (context instanceof Activity) {
            new we(context).b(str);
        }
    }

    /* compiled from: A */
    class b implements DownloadConfirmCallBack {
        final /* synthetic */ rs a;

        b(rs rsVar) {
            this.a = rsVar;
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onConfirm() {
            rs rsVar = this.a;
            if (rsVar != null) {
                rsVar.a((JSONObject) null);
            }
            if (cz.this.c != null) {
                cz.this.c.b();
            }
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onCancel() {
            rs rsVar = this.a;
            if (rsVar != null) {
                rsVar.onCancel();
            }
            if (cz.this.c != null) {
                cz.this.c.b();
            }
        }
    }

    /* compiled from: A */
    class c implements rs {
        final /* synthetic */ rs a;

        c(rs rsVar) {
            this.a = rsVar;
        }

        @Override // com.qq.e.comm.plugin.rs
        public void onCancel() {
            rs rsVar = this.a;
            if (rsVar != null) {
                rsVar.onCancel();
            }
        }

        @Override // com.qq.e.comm.plugin.rs
        public boolean a(JSONObject jSONObject) {
            rs rsVar = this.a;
            if (rsVar != null) {
                return rsVar.a((JSONObject) null);
            }
            return true;
        }

        @Override // com.qq.e.comm.plugin.rs
        public void b(boolean z) {
            rs rsVar = this.a;
            if (rsVar != null) {
                rsVar.b(z);
            }
            if (cz.this.c != null) {
                cz.this.c.b();
            }
        }

        @Override // com.qq.e.comm.plugin.rs
        public void a(boolean z) {
            rs rsVar = this.a;
            if (rsVar != null) {
                rsVar.a(z);
            }
            if (cz.this.c == null || !z) {
                return;
            }
            cz.this.c.a();
        }
    }

    /* compiled from: A */
    class d implements rs {
        final /* synthetic */ rs a;

        d(rs rsVar) {
            this.a = rsVar;
        }

        @Override // com.qq.e.comm.plugin.rs
        public void onCancel() {
            this.a.onCancel();
        }

        @Override // com.qq.e.comm.plugin.rs
        public boolean a(JSONObject jSONObject) {
            return this.a.a(jSONObject);
        }

        @Override // com.qq.e.comm.plugin.rs
        public void b(boolean z) {
            DialogStateCallback dialogStateCallback = cz.this.e;
            if (dialogStateCallback != null) {
                dialogStateCallback.i().b(5);
            }
            this.a.b(z);
        }

        @Override // com.qq.e.comm.plugin.rs
        public void a(boolean z) {
            DialogStateCallback dialogStateCallback = cz.this.e;
            if (dialogStateCallback != null) {
                dialogStateCallback.j().b(5);
            }
            this.a.a(z);
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public m h() {
        return this.b.get();
    }

    /* compiled from: A */
    class e implements f {
        e() {
        }

        @Override // com.qq.e.comm.plugin.cz.f
        public void a() {
            cz.this.e.j().b(3);
        }

        @Override // com.qq.e.comm.plugin.cz.f
        public void b() {
            cz.this.e.i().b(3);
        }
    }

    public void a(h4 h4Var) {
        if (h4Var == null) {
            return;
        }
        if (this.e == null) {
            this.e = (DialogStateCallback) x5.b(h4Var.s0(), DialogStateCallback.class);
        }
        if (this.e != null) {
            this.c = new e();
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(boolean z) {
        if (z) {
            return;
        }
        n20.g("跳转失败，可能未安装应用。");
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(String str) {
        Context context = this.a.get();
        if (context == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(l3 l3Var) {
        if (l3Var == null) {
            return;
        }
        String strA = l3Var.a();
        int iJ = l3Var.j();
        if (h10.e(iJ)) {
            n20.g("正在努力下载，请耐心等待");
            return;
        }
        if (h10.d(iJ)) {
            n20.g("开始安装" + strA);
        } else if (iJ == 0) {
            n20.g("开始下载" + strA);
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(h4 h4Var, DownloadConfirmListener downloadConfirmListener, rs rsVar, int i) {
        Activity activityB = c1.b(this.a.get());
        if (activityB == null) {
            if (rsVar != null) {
                rsVar.a(false);
            }
        } else {
            if (downloadConfirmListener != null) {
                int i2 = h10.d(i) ? 257 : 1;
                if (rsVar != null) {
                    rsVar.a(true);
                }
                downloadConfirmListener.onDownloadConfirm(activityB, i2, h4Var.p(), new b(rsVar));
                f fVar = this.c;
                if (fVar != null) {
                    fVar.a();
                    return;
                }
                return;
            }
            vp.a(activityB, h4Var, new c(rsVar), i);
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(String str, h4 h4Var) {
        o5.b(str, h4Var);
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(String str, rs rsVar) {
        Activity activityB = c1.b(this.a.get());
        if (activityB != null) {
            at atVar = new at(activityB, str, new a(rsVar));
            this.d = atVar;
            atVar.c();
        }
    }

    @Override // com.qq.e.comm.plugin.qs
    public void a(h4 h4Var, rs rsVar) {
        Activity activityB = c1.b(this.a.get());
        if (activityB == null) {
            rsVar.a(false);
        } else {
            g9.a(activityB, h4Var, new d(rsVar));
        }
    }
}
