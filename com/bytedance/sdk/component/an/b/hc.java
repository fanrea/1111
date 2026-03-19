package com.bytedance.sdk.component.an.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.an.b.b;
import com.bytedance.sdk.component.an.e;
import com.bytedance.sdk.component.an.rf;
import com.bytedance.sdk.component.an.tc;
import com.bytedance.sdk.component.an.uo;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;

@ATS(single = true, value = {"img_service"})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements e {
    private volatile an d;

    private hc() {
    }

    public static e d(Context context, uo uoVar) {
        hc hcVar = new hc();
        hcVar.hc(context, uoVar);
        return hcVar;
    }

    private void hc(Context context, uo uoVar) {
        if (this.d != null) {
            mq.hc("ImageLoader", "already init!");
        }
        if (uoVar == null) {
            uoVar = u.d(context);
        }
        this.d = new an(context, uoVar);
    }

    @Override // com.bytedance.sdk.component.an.e
    @ATSMethod(1)
    public tc d(String str) {
        return new b.hc(this.d).d(str);
    }

    @Override // com.bytedance.sdk.component.an.e
    @ATSMethod(2)
    public void d(double d) {
        hc(d);
        b(d);
    }

    @Override // com.bytedance.sdk.component.an.e
    @ATSMethod(3)
    public void hc(double d) {
        if (this.d != null) {
            d(this.d.d(), d);
            d(this.d.hc(), d);
        }
    }

    @Override // com.bytedance.sdk.component.an.e
    @ATSMethod(4)
    public void b(double d) {
        if (this.d != null) {
            d(this.d.b(), d);
        }
    }

    private void d(Collection<? extends com.bytedance.sdk.component.an.d> collection, double d) {
        if (collection == null) {
            return;
        }
        Iterator<? extends com.bytedance.sdk.component.an.d> it = collection.iterator();
        while (it.hasNext()) {
            it.next().d(d);
        }
    }

    @Override // com.bytedance.sdk.component.an.e
    @ATSMethod(5)
    public void d() {
        b(0.0d);
        hc(0.0d);
    }

    @Override // com.bytedance.sdk.component.an.e
    @ATSMethod(6)
    public InputStream d(String str, String str2) throws NoSuchAlgorithmException {
        if (this.d != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.an.b.b.b.d(str);
            }
            Collection<rf> collectionHc = this.d.hc();
            if (collectionHc != null) {
                Iterator<rf> it = collectionHc.iterator();
                while (it.hasNext()) {
                    byte[] bArrD = it.next().d((rf) str2);
                    if (bArrD != null) {
                        return new ByteArrayInputStream(bArrD);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.an.b> collectionB = this.d.b();
            if (collectionB != null) {
                Iterator<com.bytedance.sdk.component.an.b> it2 = collectionB.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamD = it2.next().d(str2);
                    if (inputStreamD != null) {
                        return inputStreamD;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.an.e
    @ATSMethod(7)
    public InputStream d(String str, String str2, String str3) throws NoSuchAlgorithmException {
        if (this.d == null || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str2 = com.bytedance.sdk.component.an.b.b.b.d(str);
        }
        com.bytedance.sdk.component.an.b bVarD = this.d.d(str3);
        if (bVarD != null) {
            return bVarD.d(str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.an.e
    @ATSMethod(8)
    public boolean hc(String str, String str2, String str3) throws NoSuchAlgorithmException {
        if (this.d == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.an.b.b.b.d(str);
        }
        com.bytedance.sdk.component.an.b bVarD = this.d.d(str3);
        if (bVarD != null) {
            return bVarD.hc(str2);
        }
        return false;
    }
}
