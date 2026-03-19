package com.android.gdt.qone.k;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.baidu.mobads.container.util.cm;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class b {
    public static final Uri a = Uri.parse("content://cn.nubia.identity/identity");

    public static String a(Context context, String str) throws RemoteException {
        Bundle bundleCall;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("getAAID", str, null);
                if (i >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(a, "getAAID", str, (Bundle) null);
            }
            if (bundleCall.getInt("code", -1) == 0) {
                String string = bundleCall.getString("id");
                com.android.gdt.qone.af.b.b("NubiaLog succeed:" + string);
                return string;
            }
            String string2 = bundleCall.getString(cm.V);
            com.android.gdt.qone.af.b.b("NubiaLog failed:" + string2);
            return string2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) throws RemoteException {
        Bundle bundleCall;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("getOAID", null, null);
                if (i >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(a, "getOAID", (String) null, (Bundle) null);
            }
            if (bundleCall.getInt("code", -1) == 0) {
                String string = bundleCall.getString("id");
                com.android.gdt.qone.af.b.b("NubiaLog succeed:" + string);
                return string;
            }
            String string2 = bundleCall.getString(cm.V);
            com.android.gdt.qone.af.b.b("NubiaLog failed:" + string2);
            return string2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context) throws RemoteException {
        Bundle bundleCall;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("isSupport", null, null);
                if (i >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(a, "isSupport", (String) null, (Bundle) null);
            }
            if (bundleCall.getInt("code", -1) == 0) {
                com.android.gdt.qone.af.b.b("NubiaLog succeed");
                return bundleCall.getBoolean("issupport", true);
            }
            com.android.gdt.qone.af.b.b("NubiaLog failed:" + bundleCall.getString(cm.V));
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
