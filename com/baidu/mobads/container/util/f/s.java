package com.baidu.mobads.container.util.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s extends com.baidu.mobads.container.d.a {
    final /* synthetic */ Context a;

    s(Context context) {
        this.a = context;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        Bundle bundleCall;
        String string;
        try {
            z.a(this.a, "nubia-start", "");
            Uri uri = Uri.parse("content://cn.nubia.identity/identity");
            if (com.baidu.mobads.container.util.x.a(null).a() > 17) {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(uri);
                if (contentProviderClientAcquireContentProviderClient == null) {
                    bundleCall = null;
                } else {
                    bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                    if (com.baidu.mobads.container.util.x.a(null).a() >= 24) {
                        contentProviderClientAcquireContentProviderClient.release();
                    } else {
                        contentProviderClientAcquireContentProviderClient.release();
                    }
                }
            } else {
                bundleCall = this.a.getContentResolver().call(uri, "getOAID", (String) null, (Bundle) null);
            }
            if (bundleCall != null && bundleCall.getInt("code", -1) == 0) {
                string = bundleCall.getString("id");
            } else {
                string = null;
            }
            if (TextUtils.isEmpty(string)) {
                z.a(this.a, "nubia-empty", "");
            } else {
                z.a(string);
                z.a(2592000000L, string);
            }
        } catch (Throwable th) {
        }
        return null;
    }
}
