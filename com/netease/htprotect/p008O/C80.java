package com.netease.htprotect.p008O;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.IOException;

/* renamed from: com.netease.htprotect.〇O.〇8〇0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class C80 {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m683O8oO888(Context context) throws RemoteException, IOException {
        Bundle bundleCall;
        Uri uri = Uri.parse("content://cn.nubia.identity/identity");
        try {
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireContentProviderClient.close();
                } else {
                    contentProviderClientAcquireContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(uri, "getOAID", (String) null, (Bundle) null);
            }
        } catch (Exception unused) {
        }
        if (bundleCall == null) {
            throw new IOException("get oaid failed");
        }
        if (bundleCall.getInt("code", -1) == 0) {
            return bundleCall.getString("id");
        }
        return null;
    }
}
