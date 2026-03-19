package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bj;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class bm implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ bj.a b;

    bm(bj.a aVar, IOAdEvent iOAdEvent) {
        this.b = aVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap map;
        String str;
        String str2;
        IOAdEvent iOAdEvent = this.a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.a.getType();
        if (z.I.equals(type)) {
            bj.this.a(this.a);
            return;
        }
        if (z.L.equals(type)) {
            bj.this.p = this.a.getMessage();
            bj.this.q();
            return;
        }
        if (z.M.equals(type)) {
            bj.this.e(this.a);
            return;
        }
        if (z.N.equals(type)) {
            bj.this.f(this.a);
            return;
        }
        if (z.V.equals(type)) {
            bj.this.g(this.a);
            return;
        }
        String str3 = "";
        int iIntValue = 0;
        int iIntValue2 = 0;
        zEquals = false;
        boolean zEquals = false;
        if (z.q.equals(type)) {
            HashMap map2 = (HashMap) this.a.getData();
            if (map2 != null) {
                str3 = (String) map2.get("error_message");
                Object obj = map2.get("error_code");
                Object obj2 = obj;
                if (obj == null) {
                    obj2 = 0;
                }
                iIntValue = ((Integer) obj2).intValue();
                bj.this.j = (String) map2.get("error_uniqueid");
                str2 = bj.this.j;
            } else {
                str2 = "";
            }
            bj.this.a(str3, iIntValue, str2);
            return;
        }
        if (z.f748K.equals(type)) {
            HashMap map3 = (HashMap) this.a.getData();
            if (map3 != null) {
                str3 = (String) map3.get("error_message");
                Object obj3 = map3.get("error_code");
                Object obj4 = obj3;
                if (obj3 == null) {
                    obj4 = 0;
                }
                iIntValue2 = ((Integer) obj4).intValue();
                bj.this.j = (String) map3.get("error_uniqueid");
                str = bj.this.j;
            } else {
                str = "";
            }
            bj.this.a(iIntValue2, str3, str);
            return;
        }
        if (z.G.equals(type)) {
            bj.this.h(this.a);
            return;
        }
        if (z.W.equals(type)) {
            bj.this.d();
            return;
        }
        if (z.X.equals(type)) {
            bj.this.d(this.a);
            return;
        }
        if (z.Z.equals(type)) {
            bj.this.s();
            return;
        }
        if (z.aa.equals(type)) {
            IOAdEvent iOAdEvent2 = this.a;
            if (iOAdEvent2 != null && (map = (HashMap) iOAdEvent2.getData()) != null) {
                zEquals = "1".equals((String) map.get("serverVerify"));
            }
            bj.this.b(zEquals);
            return;
        }
        if (z.ab.equals(type)) {
            bj.this.b();
            return;
        }
        if (z.ac.equals(type)) {
            bj.this.c();
            return;
        }
        if (z.ad.equals(type)) {
            bj.this.c();
            return;
        }
        if (z.J.equals(type)) {
            bj.this.b(this.a);
            return;
        }
        if (z.ae.equals(type)) {
            bj.this.a(this.a.getMessage(), 1 == this.a.getCode());
            return;
        }
        if (z.af.equals(type)) {
            bj.this.e(this.a.getMessage());
            return;
        }
        if (z.ag.equals(type)) {
            bj.this.f(this.a.getMessage());
            return;
        }
        if (z.ah.equals(type)) {
            bj.this.d(this.a.getMessage());
            return;
        }
        if (z.C.equals(type)) {
            bj.this.g(this.a.getMessage());
            return;
        }
        if (z.Y.equals(type)) {
            bj.this.t();
            return;
        }
        if (z.ai.equals(type)) {
            bj.this.b(this.a.getMessage(), 1 == this.a.getCode());
            return;
        }
        if (z.al.equals(type)) {
            bj.this.c(this.a);
            return;
        }
        if (z.aj.equals(type)) {
            bj.this.u();
            return;
        }
        if (z.ak.equals(type)) {
            bj.this.v();
            return;
        }
        if (z.an.equals(type)) {
            bj.this.i(this.a);
        } else if (z.ao.equals(type)) {
            bj.this.j(this.a);
        } else if (z.am.equals(type)) {
            bj.this.k(this.a);
        }
    }
}
