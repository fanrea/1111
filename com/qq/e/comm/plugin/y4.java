package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.v30;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class y4 extends w40<er, dr> {
    private boolean G = false;

    protected abstract void a(CharSequence charSequence);

    protected abstract void b(boolean z);

    protected abstract void c(boolean z);

    protected abstract boolean c(int[] iArr);

    protected abstract void m(int i);

    protected abstract void n(int i);

    protected abstract void o(int i);

    protected abstract void p(int i);

    protected abstract void q(int i);

    @Override // com.qq.e.comm.plugin.w40
    public boolean a(String str, cm cmVar) {
        return c(str, cmVar) || super.a(str, cmVar);
    }

    private boolean c(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "14":
                m(v30.c(cmVar));
                return true;
            case "70":
                if (!this.G) {
                    b((cmVar.f(new JSONObject[0]) & 1) == 1);
                }
                return true;
            case "71":
                rk rkVar = this.p;
                if (rkVar instanceof i8) {
                    ((i8) rkVar).r();
                }
                a(cmVar.toString());
                return true;
            case "72":
                p(cmVar.f(new JSONObject[0]));
                return true;
            case "73":
                v30.a(cmVar, c().f(), new a());
                return true;
            case "74":
                q(cmVar.f(new JSONObject[0]));
                return true;
            case "75":
                n(cmVar.f(new JSONObject[0]));
                return true;
            case "80":
                this.G = c(v30.a(cmVar));
                return true;
            case "enableMarquee":
                c(cmVar.f(new JSONObject[0]) == 1);
                return true;
            default:
                return false;
        }
    }

    /* compiled from: A */
    class a implements v30.c {
        a() {
        }

        @Override // com.qq.e.comm.plugin.v30.c
        public void a(int i) {
            y4.this.o(i);
        }
    }
}
