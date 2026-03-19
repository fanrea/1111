package com.alliance.ssp.ad.g0;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;
import java.util.Objects;

/* compiled from: OAIDService.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class m implements ServiceConnection {
    public final Context a;
    public final com.alliance.ssp.ad.f0.b b;
    public final a c;

    /* compiled from: OAIDService.java */
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder);
    }

    public m(Context context, com.alliance.ssp.ad.f0.b bVar, a aVar) {
        if (context instanceof Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
        this.b = bVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, com.alliance.ssp.ad.f0.b bVar, a aVar) {
        m mVar = new m(context, bVar, aVar);
        try {
            if (!mVar.a.bindService(intent, mVar, 1)) {
                throw new YTOAIDException("Service binding failed");
            }
            Objects.toString(intent);
        } catch (Exception e) {
            mVar.b.a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String strA;
        componentName.getClassName();
        try {
            try {
                try {
                    strA = this.c.a(iBinder);
                } catch (Exception e) {
                    this.b.a(e);
                    this.a.unbindService(this);
                }
                if (strA == null || strA.length() == 0) {
                    throw new YTOAIDException("OAID/AAID acquire failed");
                }
                this.b.a(strA);
                this.a.unbindService(this);
                componentName.getClassName();
            } catch (Throwable th) {
                try {
                    this.a.unbindService(this);
                    componentName.getClassName();
                } catch (Exception unused) {
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        componentName.getClassName();
    }
}
