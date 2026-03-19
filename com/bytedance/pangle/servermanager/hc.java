package com.bytedance.pangle.servermanager;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.b;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static b an;
    private static final Object d = new Object();
    private static final Object hc = new Object();
    private static final Object b = new Object();
    private static final Map<String, Boolean> c = new ConcurrentHashMap();
    private static final Map<String, u> u = new ConcurrentHashMap();

    public static u d(String str) {
        Boolean bool = c.get(str);
        if (bool == null || !bool.booleanValue()) {
            u.remove(str);
        }
        Map<String, u> map = u;
        if (map.get(str) == null) {
            synchronized (hc) {
                u uVar = (u) d("service", str);
                if (uVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, uVar);
            }
        }
        return map.get(str);
    }

    public static b d() {
        Boolean bool = c.get(LiveConfigKey.MAIN);
        if (bool == null || !bool.booleanValue()) {
            an = null;
        }
        if (an == null) {
            synchronized (b) {
                b bVar = (b) d("package", LiveConfigKey.MAIN);
                if (bVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                an = bVar;
            }
        }
        return an;
    }

    private static IBinder d(Uri uri, String str) {
        Bundle bundleCall = Zeus.getAppApplication().getContentResolver().call(uri, "query_binder", str, (Bundle) null);
        if (bundleCall != null) {
            bundleCall.setClassLoader(AbsServerManager.class.getClassLoader());
            d dVar = (d) bundleCall.getParcelable("binder");
            if (dVar != null) {
                return dVar.d();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.os.IInterface d(java.lang.String r5, final java.lang.String r6) throws android.os.RemoteException {
        /*
            boolean r0 = com.bytedance.pangle.Zeus.hasInit()
            if (r0 == 0) goto L91
            java.util.HashMap r0 = com.bytedance.pangle.Zeus.getServerManagerHashMap()
            java.lang.Object r0 = r0.get(r6)
            android.content.pm.ProviderInfo r0 = (android.content.pm.ProviderInfo) r0
            if (r0 == 0) goto L81
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "content://"
            r1.<init>(r2)
            java.lang.String r0 = r0.authority
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.os.IBinder r0 = d(r0, r5)
            if (r0 == 0) goto L7f
            boolean r1 = r0.isBinderAlive()
            if (r1 == 0) goto L7f
            com.bytedance.pangle.servermanager.hc$1 r1 = new com.bytedance.pangle.servermanager.hc$1     // Catch: android.os.RemoteException -> L77
            r1.<init>()     // Catch: android.os.RemoteException -> L77
            r2 = 0
            r0.linkToDeath(r1, r2)     // Catch: android.os.RemoteException -> L77
            java.util.Map<java.lang.String, java.lang.Boolean> r1 = com.bytedance.pangle.servermanager.hc.c     // Catch: android.os.RemoteException -> L77
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: android.os.RemoteException -> L77
            r1.put(r6, r3)     // Catch: android.os.RemoteException -> L77
            r6 = -1
            int r1 = r5.hashCode()     // Catch: android.os.RemoteException -> L77
            r3 = -807062458(0xffffffffcfe53446, float:-7.6908165E9)
            r4 = 1
            if (r1 == r3) goto L5e
            r2 = 1984153269(0x7643c6b5, float:9.927033E32)
            if (r1 == r2) goto L54
            goto L67
        L54:
            java.lang.String r1 = "service"
            boolean r5 = r5.equals(r1)     // Catch: android.os.RemoteException -> L77
            if (r5 == 0) goto L67
            r2 = r4
            goto L68
        L5e:
            java.lang.String r1 = "package"
            boolean r5 = r5.equals(r1)     // Catch: android.os.RemoteException -> L77
            if (r5 == 0) goto L67
            goto L68
        L67:
            r2 = r6
        L68:
            if (r2 == 0) goto L72
            if (r2 == r4) goto L6d
            goto L7f
        L6d:
            com.bytedance.pangle.u r5 = com.bytedance.pangle.u.d.d(r0)     // Catch: android.os.RemoteException -> L77
            return r5
        L72:
            com.bytedance.pangle.b r5 = com.bytedance.pangle.b.d.d(r0)     // Catch: android.os.RemoteException -> L77
            return r5
        L77:
            r5 = move-exception
            java.lang.String r6 = "Zeus/server_pangle"
            java.lang.String r0 = "generateServerManager failed."
            com.bytedance.pangle.log.ZeusLogger.errReport(r6, r0, r5)
        L7f:
            r5 = 0
            return r5
        L81:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "宿主中没有找对对应进程的serverManager "
            java.lang.String r6 = r0.concat(r6)
            r5.<init>(r6)
            throw r5
        L91:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "generateServerManager 请先初始化Zeus, processName:"
            java.lang.String r6 = r0.concat(r6)
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.servermanager.hc.d(java.lang.String, java.lang.String):android.os.IInterface");
    }
}
