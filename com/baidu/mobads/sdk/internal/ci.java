package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class ci extends j {
    final /* synthetic */ ca.c b;
    final /* synthetic */ Handler c;
    final /* synthetic */ ca d;

    ci(ca caVar, ca.c cVar, Handler handler) {
        this.d = caVar;
        this.b = cVar;
        this.c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    protected Object i() {
        try {
            try {
                synchronized (ca.class) {
                    this.d.b(this.b, this.c);
                }
                SharedPreferences.Editor editorEdit = this.d.m().edit();
                editorEdit.putString(ca.d, this.d.a());
                editorEdit.apply();
                return null;
            } catch (Throwable th) {
                try {
                    this.d.z.a(ca.a, "Load APK Failed: " + th.toString());
                    this.d.b(false);
                    SharedPreferences.Editor editorEdit2 = this.d.m().edit();
                    editorEdit2.putString(ca.d, this.d.a());
                    editorEdit2.apply();
                    return null;
                } catch (Throwable th2) {
                    try {
                        SharedPreferences.Editor editorEdit3 = this.d.m().edit();
                        editorEdit3.putString(ca.d, this.d.a());
                        editorEdit3.apply();
                    } catch (Throwable th3) {
                        this.d.z.a(ca.a, th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            this.d.z.a(ca.a, th4);
            return null;
        }
    }
}
