package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.w40;
import com.sigmob.sdk.base.mta.PointType;
import io.netty.util.internal.StringUtil;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class fg extends u4<c> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c b(e8 e8Var) {
        c cVar = new c(e8Var.d());
        cVar.setVisibility(8);
        cVar.c(0);
        cVar.b(0);
        return cVar;
    }

    private fg() {
    }

    @Override // com.qq.e.comm.plugin.w40
    public void I() {
        super.I();
        this.p.a("3", t30.c((Object) (-2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.w40, com.qq.e.comm.plugin.fm
    public void a(String str, JSONObject jSONObject) {
        super.a(str, jSONObject);
        str.hashCode();
        if ((str.equals("closeVideo") || str.equals("closeVideoAuto")) && A() != 0) {
            ((c) A()).setVisibility(8);
        }
    }

    /* compiled from: A */
    static class c extends l20 implements dl<fg> {
        private r6 f;
        private fg g;
        private int h;
        private boolean i;

        public c(Context context) {
            super(context);
            this.h = -1;
            this.i = false;
        }

        void e(int i) {
            r6 r6Var = this.f;
            if (r6Var == null || r6Var.b()) {
                return;
            }
            this.f.b(i);
        }

        void a(h4 h4Var) {
            e2 e2VarK;
            if (this.f != null || h4Var == null || (e2VarK = h4Var.k()) == null) {
                return;
            }
            if (e2VarK.k()) {
                if (h4Var.p0() != null && h4Var.p0().F()) {
                    this.f = new is(this, h4Var);
                    return;
                } else {
                    this.f = new sw(this, h4Var);
                    return;
                }
            }
            if (h4Var.w1()) {
                this.f = new cn(this, h4Var);
            } else if (e2VarK.h()) {
                this.f = new bn(this, h4Var);
            }
        }

        @Override // com.qq.e.comm.plugin.l20
        public void d(int i) {
            this.h = i;
            if (this.i) {
                super.d(i);
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            fg fgVar = this.g;
            if (fgVar != null) {
                fgVar.a(view, i);
            }
        }

        public void a(boolean z) {
            int i;
            this.i = z;
            if (!z || (i = this.h) <= 0) {
                return;
            }
            super.d(i);
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(fg fgVar) {
            this.g = fgVar;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1169023802:
                if (str.equals("adModel")) {
                    c2 = 0;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1567:
                if (str.equals(PointType.SIGMOB_APP)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1576:
                if (str.equals("19")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1755:
                if (str.equals("72")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1756:
                if (str.equals("73")) {
                    c2 = 11;
                    break;
                }
                break;
            case 492578599:
                if (str.equals("supportTextColor")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1611883964:
                if (str.equals("videoPlayTime")) {
                    c2 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((c) this.A).a((h4) cmVar.e(new JSONObject[0]));
                return true;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            case 6:
                ((c) this.A).setBackgroundColor(v30.b(cmVar));
                return true;
            case 7:
                ((c) this.A).c(cmVar.c(new JSONObject[0]).a(this.p.i()));
                return true;
            case '\b':
                ((c) this.A).a(v30.b(cmVar));
                return true;
            case '\t':
                ((c) this.A).b(cmVar.c(new JSONObject[0]).a(this.p.i()));
                return true;
            case '\n':
                ((c) this.A).a(0, cmVar.c(new JSONObject[0]).e());
                return true;
            case 11:
                ((c) this.A).d(v30.b(cmVar));
                return true;
            case '\f':
                ((c) this.A).a(cmVar.f(new JSONObject[0]) > 0);
                return true;
            case '\r':
                rk rkVar = this.p;
                if (rkVar instanceof i8) {
                    ((i8) rkVar).r();
                }
                ((c) this.A).e(cmVar.f(new JSONObject[0]));
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    /* compiled from: A */
    static class b implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new fg();
        }

        b() {
        }
    }
}
