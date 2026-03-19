package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.w40;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class zf extends u4<c> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c b(e8 e8Var) {
        return new c(e8Var.d());
    }

    private zf() {
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "adModel":
                ((c) this.A).a((h4) cmVar.e(new JSONObject[0]));
            case "3":
            case "4":
            case "9":
            case "10":
            case "11":
            case "12":
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void I() {
        super.I();
        this.p.a("3", t30.c((Object) 124));
        this.p.a("4", t30.c((Object) 40));
    }

    /* compiled from: A */
    static class c extends ia implements dl {
        private w40 m;

        public c(Context context) {
            super(context);
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(w40 w40Var) {
            this.m = w40Var;
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            w40 w40Var = this.m;
            if (w40Var != null) {
                w40Var.a(view, i);
            }
        }
    }

    /* compiled from: A */
    static class b implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new zf();
        }

        b() {
        }
    }
}
