package com.kwad.tachikoma.m;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.os.Build;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.tachikoma.o.e;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private KsNotificationCompat.Builder En;
    private String Eo;
    private String Ep;
    private String Eq;
    private String Er;
    private int aV;
    private final NotificationManager m;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Eq = "download_channel";
        this.Er = "ksad";
        if (nativeModuleInitParams.args != null && nativeModuleInitParams.args.length > 0) {
            Object obj = nativeModuleInitParams.args[0];
            if (obj instanceof String) {
                this.Eq = (String) obj;
            }
        }
        this.En = new KsNotificationCompat.Builder(getContext(), this.Eq);
        this.En.setSmallIcon(OfflineHostProvider.getApi().getAppIconId(getContext()));
        this.m = (NotificationManager) getContext().getSystemService("notification");
    }

    public final void w(String str) {
        this.En.setChannelId(str);
    }

    public final String getChannelId() {
        return this.Eq;
    }

    public final void setPriority(int i) {
        this.aV = i;
        this.En.setPriority(i);
    }

    public final int getPriority() {
        return this.aV;
    }

    public final void x(String str) {
        this.Eo = str;
        this.En.setContentText(str);
    }

    public final String iO() {
        return this.Eo;
    }

    public final void y(String str) {
        this.Ep = str;
        this.En.setContentTitle(str);
    }

    public final String iP() {
        return this.Ep;
    }

    public final void k(V8Object v8Object) {
        e eVar = (e) getNativeModule(v8Object);
        if (eVar == null) {
            return;
        }
        this.En.setContentIntent(eVar.getPendingIntent());
    }

    public final void z(String str) {
        this.En.setTicker(str);
    }

    public final void k(long j) {
        this.En.setWhen(j);
    }

    public final void L(boolean z) {
        this.En.setShowWhen(z);
    }

    public final void l(V8Object v8Object) {
        c cVar = (c) getNativeModule(v8Object);
        if (cVar == null) {
            return;
        }
        this.En.setCustomBigContentView(cVar.iS());
    }

    public final void m(V8Object v8Object) {
        Bitmap bitmap;
        com.kwad.tachikoma.b.a aVar = (com.kwad.tachikoma.b.a) getNativeModule(v8Object);
        if (aVar == null || (bitmap = aVar.getBitmap()) == null) {
            return;
        }
        this.En.setLargeIcon(bitmap);
    }

    public final void f(int i, int i2, boolean z) {
        this.En.setProgress(i, i2, z);
    }

    public final void n(V8Object v8Object) {
        c cVar = (c) getNativeModule(v8Object);
        if (cVar == null) {
            return;
        }
        this.En.setContent(cVar.iS());
    }

    public final void iQ() {
        this.En.setDecoratedCustomStyle();
    }

    public final void o(V8Object v8Object) {
        c cVar = (c) getNativeModule(v8Object);
        if (cVar == null) {
            return;
        }
        this.En.setCustomContentView(cVar.iS());
    }

    public final void setAutoCancel(boolean z) {
        this.En.setAutoCancel(z);
    }

    public final void A(String str) {
        this.Er = str;
    }

    public final boolean iR() {
        return android.support.v4.app.b.a(getContext()).areNotificationsEnabled();
    }

    public final void cg(int i) {
        if (iR()) {
            try {
                Notification notificationBuild = this.En.build();
                if (Build.VERSION.SDK_INT >= 26) {
                    this.m.createNotificationChannel(new NotificationChannel(this.Eq, this.Er, this.aV));
                }
                this.m.notify(i, notificationBuild);
            } catch (Exception e) {
                com.kwad.tachikoma.e.log().printStackTraceOnly(e);
            }
        }
    }

    public final void cancel(int i) {
        try {
            this.m.cancel(i);
        } catch (Exception e) {
            com.kwad.tachikoma.e.log().printStackTraceOnly(e);
        }
    }
}
