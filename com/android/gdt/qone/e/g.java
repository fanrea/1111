package com.android.gdt.qone.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.concurrent.CountDownLatch;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class g implements ServiceConnection {
    public d b;
    public c c;
    public final CountDownLatch a = new CountDownLatch(2);
    public final f d = new f(this);
    public final e e = new e(this);

    public final boolean a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return context.bindService(intent, this, 1);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b = new d();
        if (iBinder != null) {
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                if (iInterfaceQueryLocalInterface instanceof c) {
                    this.c = (c) iInterfaceQueryLocalInterface;
                } else {
                    this.c = new c(iBinder);
                }
            } catch (Throwable unused) {
                this.a.countDown();
                this.a.countDown();
                return;
            }
        }
        c cVar = this.c;
        if (cVar == null) {
            return;
        }
        cVar.a(this.e);
        this.c.b(this.d);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.countDown();
        this.a.countDown();
    }
}
