package com.qq.e.comm.plugin;

import android.content.Context;
import android.widget.ImageView;
import com.qq.e.comm.plugin.w40;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class tf extends u4<c> {
    private h4 G;
    private int H;
    private boolean I;
    private List<h8> J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f783K;

    /* compiled from: A */
    public static class b implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c b(e8 e8Var) {
        return new c(e8Var.d());
    }

    private tf() {
        this.f783K = true;
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "adModel":
                this.G = (h4) cmVar.e(new JSONObject[0]);
                return true;
            case "iconType":
                this.H = cmVar.f(new JSONObject[0]);
                return true;
            case "fw":
                this.I = cmVar.f(new JSONObject[0]) == 1;
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void M() throws JSONException {
        super.M();
        if (this.G == null) {
            return;
        }
        List<h8> listT = t();
        if (this.J == null && listT.size() > 0) {
            this.J = new ArrayList(listT);
            Iterator<h8> it = listT.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if ("adClick".equals(it.next().b)) {
                    this.f783K = false;
                    break;
                }
            }
        }
        boolean z = !this.I && q1.a(this.G);
        q1.a((ImageView) this.A, this.H, this.I, z);
        boolean zF = ro.b().f();
        if (z || zF) {
            if (zF) {
                if (z) {
                    listT.add(0, new h8(1, "adLogoClick"));
                } else if (this.f783K) {
                    listT.add(new h8(1, "adClick"));
                }
                listT.add(0, new h8(1, "userEyes", new jn().a(com.kuaishou.weapon.p0.t.v, 1).a("imnd", ro.b().c()).a()));
                return;
            }
            listT.add(0, new h8(1, "adLogoClick"));
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        List<h8> listT = t();
        if (listT != null && listT.size() > 0) {
            listT.clear();
            List<h8> list = this.J;
            if (list != null) {
                listT.addAll(list);
            }
        }
        super.clear();
        this.G = null;
        this.I = false;
        this.H = 0;
    }

    /* compiled from: A */
    static class c extends ImageView implements dl {
        @Override // com.qq.e.comm.plugin.dl
        public void a(w40 w40Var) {
        }

        public c(Context context) {
            super(context);
        }
    }
}
