package com.alliance.ssp.ad.g0;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;
import com.baidu.mobads.container.util.cm;

/* compiled from: NubiaImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class k implements com.alliance.ssp.ad.f0.c {
    public final Context a;

    public k(Context context) {
        this.a = context;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) throws RemoteException {
        if (this.a == null || bVar == null) {
            return;
        }
        if (!a()) {
            bVar.a(new YTOAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.close();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
            if (bundleCall == null) {
                throw new YTOAIDException("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new YTOAIDException("OAID query failed: " + bundleCall.getString(cm.V));
            }
            bVar.a(string);
        } catch (Exception e) {
            bVar.a(e);
        }
    }
}
