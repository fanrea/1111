package com.android.gdt.qone.a;

import com.android.gdt.qone.sdk.IAsyncQoneListener;
import com.android.gdt.qone.sdk.Qone;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements com.android.gdt.qone.ak.a {
    public final /* synthetic */ IAsyncQoneListener a;
    public final /* synthetic */ String b;

    public d(IAsyncQoneListener iAsyncQoneListener, String str) {
        this.a = iAsyncQoneListener;
        this.b = str;
    }

    @Override // com.android.gdt.qone.ak.a
    public final void a(com.android.gdt.qone.ak.b bVar) {
        this.a.onQoneDispatch(new Qone(bVar.b(), this.b));
    }
}
