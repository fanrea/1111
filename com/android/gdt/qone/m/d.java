package com.android.gdt.qone.m;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.alipay.sdk.m.k0.a;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements ServiceConnection {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c aVar;
        synchronized (this) {
            e eVar = this.a;
            int i = b.a;
            if (iBinder == null) {
                aVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0051a.a);
                aVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new a(iBinder) : (c) iInterfaceQueryLocalInterface;
            }
            eVar.e = aVar;
            g gVar = this.a.a;
            if (gVar != null) {
                gVar.f();
            }
            com.android.gdt.qone.af.b.b("SI Service onServiceConnected");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.e = null;
        com.android.gdt.qone.af.b.b("SI Service onServiceDisconnected");
    }
}
