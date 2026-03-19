package com.bytedance.bdtracker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class f2 extends l1 {
    public final Context e;
    public final d f;

    public f2(d dVar, Context context) {
        super(true, false);
        this.f = dVar;
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "SigHash";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) throws JSONException, NoSuchAlgorithmException {
        PackageInfo packageInfoA;
        Signature[] signatureArr;
        Signature signature;
        String strA = null;
        try {
            Context context = this.e;
            packageInfoA = t4.a(context, context.getPackageName(), 64);
        } catch (Throwable th) {
            this.f.D.error("Get package info failed", th, new Object[0]);
            packageInfoA = null;
        }
        if (packageInfoA != null && (signatureArr = packageInfoA.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            strA = n4.a(signature.toByteArray());
        }
        if (strA == null) {
            return true;
        }
        jSONObject.put("sig_hash", strA);
        return true;
    }
}
