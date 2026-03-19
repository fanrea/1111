package com.tencent.turingfd.sdk.ams.au;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Sculptor implements Aquila {
    @Override // com.tencent.turingfd.sdk.ams.au.Aquila
    public void a(Context context) {
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Aquila
    public Pyxis b(Context context) throws RemoteException {
        Uri uri = Uri.parse(Cfinally.a(Cfinally.x0));
        String strA = Cfinally.a(Cfinally.a);
        int i = Build.VERSION.SDK_INT;
        Bundle bundleCall = null;
        if (i >= 17) {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
            try {
                bundleCall = contentProviderClientAcquireContentProviderClient.call(strA, null, null);
            } catch (Throwable unused) {
                if (contentProviderClientAcquireContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                    }
                }
            }
            if (i >= 24) {
                contentProviderClientAcquireContentProviderClient.release();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
        } else {
            bundleCall = context.getContentResolver().call(uri, strA, (String) null, (Bundle) null);
        }
        return bundleCall == null ? Pyxis.a(-1) : bundleCall.getInt(Cfinally.a(Cfinally.y0), -1) != 0 ? Pyxis.a(-2) : new Pyxis(bundleCall.getString(Cfinally.a(Cfinally.z0)), 0);
    }
}
