package ca.da.ca.fa;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.bytedance.apm.common.utility.PackageUtils;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SigHashLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class t extends c {
    public final Context e;

    public t(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) throws JSONException, NoSuchAlgorithmException {
        PackageInfo packageSignature;
        Signature[] signatureArr;
        Signature signature;
        String strA = null;
        try {
            Context context = this.e;
            packageSignature = PackageUtils.getPackageSignature(context, context.getPackageName());
        } catch (Throwable th) {
            ca.da.ca.ja.r.a(th);
            packageSignature = null;
        }
        if (packageSignature != null && (signatureArr = packageSignature.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            strA = ca.da.ca.ja.g.a(signature.toByteArray());
        }
        if (strA == null) {
            return true;
        }
        jSONObject.put("sig_hash", strA);
        return true;
    }
}
