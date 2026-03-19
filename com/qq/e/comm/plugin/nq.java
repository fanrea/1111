package com.qq.e.comm.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.w40;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class nq extends zn<ue, oq> {

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public nq a() {
            return new nq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public ue p() {
        return new ue(this, (oq) this.A);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public oq b(e8 e8Var) {
        oq oqVar = new oq(e8Var.d());
        zn znVar = this.o;
        if (znVar == null) {
            oqVar.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        } else if (!(znVar instanceof nq)) {
            oqVar.setLayoutParams(((u40) znVar.v()).j());
        }
        return oqVar;
    }

    @Override // com.qq.e.comm.plugin.w40
    protected rk a(View view) {
        if (this.o instanceof nq) {
            return super.a(view);
        }
        return ((ue) this.f).a(view);
    }

    @Override // com.qq.e.comm.plugin.w40
    public void I() {
        super.I();
        ((oq) this.A).a(((i8) this.p).s());
    }
}
