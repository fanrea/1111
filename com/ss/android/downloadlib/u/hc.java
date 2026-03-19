package com.ss.android.downloadlib.u;

import android.text.TextUtils;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {

    public interface d<T> {
        T hc();
    }

    public static <T> T d(boolean z, String str, d<T> dVar) throws JSONException {
        try {
            return dVar.hc();
        } catch (Throwable th) {
            if (th instanceof com.ss.android.downloadlib.u.d) {
                throw th;
            }
            b.d().d(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T d(d<T> dVar) {
        return (T) d(true, null, dVar);
    }

    public static void d(final Runnable runnable) {
        d(new d<Void>() { // from class: com.ss.android.downloadlib.u.hc.1
            @Override // com.ss.android.downloadlib.u.hc.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Void hc() {
                runnable.run();
                return null;
            }
        });
    }
}
