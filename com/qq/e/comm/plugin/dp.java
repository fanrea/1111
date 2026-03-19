package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.w40;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class dp extends zn<fp, ep> {

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public dp a() {
            return new dp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public fp p() {
        return new fp(this, (ep) this.A);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ep b(e8 e8Var) {
        return new ep(e8Var.d());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.comm.plugin.zn, com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        if (super.a(str, cmVar)) {
            return true;
        }
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "alwaysScroll":
                ((ep) this.A).b(cmVar.f(new JSONObject[0]) == 1);
                return false;
            case "14":
                ((fp) this.f).c(v30.c(cmVar));
                return true;
            case "51":
                return true;
            default:
                return false;
        }
    }
}
