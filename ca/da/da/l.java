package ca.da.da;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import ca.da.da.n;
import com.baidu.mobads.container.util.cm;
import com.bytedance.apm.common.utility.Logger;

/* compiled from: NubiaOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class l implements n {
    @Override // ca.da.da.n
    public n.a a(Context context) throws RemoteException {
        Bundle bundleCall;
        Uri uri = Uri.parse("content://cn.nubia.identity/identity");
        try {
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                if (contentProviderClientAcquireContentProviderClient == null) {
                    return null;
                }
                bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireContentProviderClient.close();
                } else {
                    contentProviderClientAcquireContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(uri, "getOAID", (String) null, (Bundle) null);
            }
            if (bundleCall == null) {
                return null;
            }
            if (bundleCall.getInt("code", -1) == 0) {
                n.a aVar = new n.a();
                aVar.a = bundleCall.getString("id");
                return aVar;
            }
            String string = bundleCall.getString(cm.V);
            if (!TextUtils.isEmpty(string)) {
                Logger.e(string);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // ca.da.da.n
    public boolean b(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }
}
