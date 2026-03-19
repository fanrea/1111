package lk.repeackage;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.lk.oaid.ErrorCode;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class s implements d {
    public final Context a;

    public s(Context context) {
        this.a = context;
    }

    @Override // lk.repeackage.d
    public void a(c cVar) throws RemoteException {
        if (cVar == null) {
            return;
        }
        if (this.a == null) {
            cVar.onOAIDGetError(ErrorCode.STATE_CALL_PARAM, new e("context is null !!!"));
            return;
        }
        if (!a()) {
            f.a("Nubia Only supports Android 10.0 and above for Nubia");
            cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("Nubia Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                cVar.onOAIDGetError(ErrorCode.STATE_GET_FAIL, new e("providerClient is null"));
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.close();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
            if (bundleCall == null) {
                cVar.onOAIDGetError(ErrorCode.STATE_GET_FAIL, new e("OAID query failed: bundle is null"));
            } else {
                cVar.onOAIDGetComplete(bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null);
            }
        } catch (Exception e) {
            f.a(e);
            cVar.onOAIDGetError(ErrorCode.STATE_OCCUR_EXCEPTION, e);
        }
    }

    @Override // lk.repeackage.d
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
