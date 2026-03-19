package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.u6;
import com.qq.e.comm.plugin.v30;
import com.qq.e.comm.plugin.w40;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class eg extends u4<e> {
    private eg() {
    }

    /* synthetic */ eg(a aVar) {
        this();
    }

    /* compiled from: A */
    class a implements v30.d {
        a() {
        }

        @Override // com.qq.e.comm.plugin.v30.d
        public void a(Object[] objArr) {
            ((e) eg.this.A).a(objArr);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "barColor":
                c(cmVar);
                return true;
            case "progress":
                ((e) this.A).a(cmVar.f(new JSONObject[0]));
                return true;
            case "progressf":
                ((e) this.A).b(cmVar.b(new JSONObject[0]));
                return true;
            case "progressGradient":
                v30.a(cmVar, c().f(), new a());
                return true;
            case "barBgRadius":
                ((e) this.A).a(cmVar.c(new JSONObject[0]).e());
                return true;
            case "barRoundEnable":
                ((e) this.A).a(cmVar.f(new JSONObject[0]) > 0);
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    /* compiled from: A */
    class b implements v30.c {
        b() {
        }

        @Override // com.qq.e.comm.plugin.v30.c
        public void a(int i) {
            ((e) eg.this.A).b(i);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void f(int i) {
        ((e) this.A).setBackgroundColor(i);
    }

    /* compiled from: A */
    class c implements u6.b {
        c() {
        }

        @Override // com.qq.e.comm.plugin.u6.b
        public void a(int i) {
            if (eg.this.A != null) {
                ((e) eg.this.A).b(i);
            }
        }
    }

    protected void c(cm cmVar) {
        v30.a(cmVar, c().f(), new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e b(e8 e8Var) {
        e eVar = new e(e8Var.d());
        eVar.c(100);
        eVar.b(v30.b(t30.c((Object) "#66FFFFFF")));
        eVar.setBackgroundColor(v30.b(t30.c((Object) "#33FFFFFF")));
        return eVar;
    }

    /* compiled from: A */
    static class e extends Cdo implements dl<eg> {
        private eg m;

        public e(Context context) {
            super(context);
            a(true);
        }

        void b(float f) {
            super.a((int) (f * 100.0f));
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(eg egVar) {
            this.m = egVar;
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            eg egVar = this.m;
            if (egVar != null) {
                egVar.a(view, i);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u6.a(c().f(), str, new c());
    }

    /* compiled from: A */
    static class d implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new eg(null);
        }

        d() {
        }
    }
}
