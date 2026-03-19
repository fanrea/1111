package ms.bz.bd.c.Pgl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class z0 {
    private final Context d;

    public z0(Context context) {
        this.d = context;
    }

    public final String d() throws RemoteException {
        Bundle bundleCall;
        Uri uri = Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "67b91f", new byte[]{36, 58, 31, 89, 11, 127, 33, com.sigmob.sdk.archives.tar.e.P, 124, 38, 36, 59, 95, 67, 27, 115, 60, 23, 125, 96, 35, com.sigmob.sdk.archives.tar.e.H, 31, 89, 7, 101, 44, 89, 58, 109, 34, 59, 5, 68, 26, 104}));
        try {
            int i = Build.VERSION.SDK_INT;
            if (i > 17) {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = this.d.getContentResolver().acquireContentProviderClient(uri);
                bundleCall = contentProviderClientAcquireContentProviderClient.call((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "917490", new byte[]{47, com.sigmob.sdk.archives.tar.e.N, 80, 111, 39, 14, 30}), null, null);
                if (i >= 24) {
                    contentProviderClientAcquireContentProviderClient.close();
                } else {
                    contentProviderClientAcquireContentProviderClient.release();
                }
            } else {
                bundleCall = this.d.getContentResolver().call(uri, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7ccd50", new byte[]{33, 100, 4, Utf8.REPLACEMENT_BYTE, 43, 14, 16}), (String) null, (Bundle) null);
            }
        } catch (Exception unused) {
        }
        if (bundleCall.getInt((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "639cf5", new byte[]{36, 62, 78, 18}), -1) == 0) {
            return bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a5c36", new byte[]{43, com.sigmob.sdk.archives.tar.e.T}));
        }
        bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61451e", new byte[]{42, com.sigmob.sdk.archives.tar.e.N, 84, 82, 15, 117, com.sigmob.sdk.archives.tar.e.H}));
        return null;
    }
}
