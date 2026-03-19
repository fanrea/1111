package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.w40;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class uq extends zn<co, vq> {

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public uq a() {
            return new uq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public co p() {
        return new co(this, (vq) this.A);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public vq b(e8 e8Var) {
        return new vq(e8Var.d());
    }

    @Override // com.qq.e.comm.plugin.zn, com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        if (super.a(str, cmVar)) {
            return true;
        }
        str.hashCode();
        if (str.equals("14")) {
            ((co) this.f).c(v30.c(cmVar));
            return true;
        }
        if (!str.equals("51")) {
            return false;
        }
        ((co) this.f).d(cmVar.f(new JSONObject[0]));
        return true;
    }
}
