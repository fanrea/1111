package com.android.gdt.qone.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a implements ServiceConnection {
    public final /* synthetic */ g a;
    public final /* synthetic */ b b;

    public a(b bVar, g gVar) {
        this.b = bVar;
        this.a = gVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e cVar;
        synchronized (this) {
            b bVar = this.b;
            int i = d.a;
            if (iBinder == null) {
                cVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                cVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new c(iBinder) : (e) iInterfaceQueryLocalInterface;
            }
            bVar.d = cVar;
            g gVar = this.a;
            if (gVar != null) {
                gVar.e();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.b.d = null;
    }
}
