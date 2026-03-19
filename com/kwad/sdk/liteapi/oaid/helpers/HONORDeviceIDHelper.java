package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.sdk.m.u.b;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.helpers.HONORProxy;
import com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HONORDeviceIDHelper {
    private static final String TAG = "HONORDeviceIDHelper";
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.HONORDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                LiteApiLogger.d(HONORDeviceIDHelper.TAG, "onServiceConnected ： " + iBinder);
                HONORDeviceIDHelper.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                LiteApiLogger.d(HONORDeviceIDHelper.TAG, e);
            }
        }
    };

    public HONORDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public HONORProxy.c getAdInfo() {
        Context context;
        ServiceConnection serviceConnection;
        HONORProxy hONORProxy = new HONORProxy();
        hONORProxy.mContext = this.mContext;
        try {
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (hONORProxy.isAdvertisingIdAvailable(this.mContext) && this.mContext.bindService(intent, this.serviceConnection, 1)) {
                try {
                    try {
                        hONORProxy.info = new HONORProxy.c();
                        HONORInterface.a aVar = new HONORInterface.a(this.mLinkedBlockingQueue.take());
                        aVar.getIDs(hONORProxy.mBinderOne);
                        aVar.getBoos(hONORProxy.mBinderTwo);
                        hONORProxy.mCountDownLatch.await(b.a, TimeUnit.MICROSECONDS);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    } catch (Exception e) {
                        LiteApiLogger.d(TAG, e);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    }
                    context.unbindService(serviceConnection);
                } catch (Throwable th) {
                    this.mContext.unbindService(this.serviceConnection);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            LiteApiLogger.d(TAG, "getOAID honor service not found" + th2);
        }
        return hONORProxy.info;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getOAID() {
        /*
            r6 = this;
            java.lang.String r0 = ""
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L40
            r2 = 17
            java.lang.String r3 = "oaid"
            if (r1 < r2) goto L15
            android.content.Context r1 = r6.mContext     // Catch: java.lang.Throwable -> L40
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = android.provider.Settings.Global.getString(r1, r3)     // Catch: java.lang.Throwable -> L40
            goto L16
        L15:
            r1 = r0
        L16:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L26
            android.content.Context r2 = r6.mContext     // Catch: java.lang.Throwable -> L3b
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r1 = android.provider.Settings.Secure.getString(r2, r3)     // Catch: java.lang.Throwable -> L3b
        L26:
            java.lang.String r2 = "HONORDeviceIDHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "getOAID secure: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3b
            com.kwad.sdk.liteapi.LiteApiLogger.i(r2, r3)     // Catch: java.lang.Throwable -> L3b
            goto L46
        L3b:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L42
        L40:
            r1 = move-exception
            r2 = r0
        L42:
            com.kwad.sdk.liteapi.LiteApiLogger.printStackTrace(r1)
            r1 = r2
        L46:
            if (r1 == 0) goto L4f
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L4f
            return r1
        L4f:
            com.kwad.sdk.liteapi.oaid.helpers.HONORProxy$c r1 = r6.getAdInfo()
            if (r1 == 0) goto L57
            java.lang.String r0 = r1.id
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.liteapi.oaid.helpers.HONORDeviceIDHelper.getOAID():java.lang.String");
    }
}
