package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.cb;
import com.bytedance.embedapplog.ic;
import com.bytedance.embedapplog.tc;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class ed implements ic {
    private final ic d;
    private gv<Boolean> hc;

    ed() {
        this(null);
    }

    ed(ic icVar) {
        this.hc = new gv<Boolean>() { // from class: com.bytedance.embedapplog.ed.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.embedapplog.gv
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean d(Object... objArr) {
                long longVersionCode;
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        longVersionCode = packageInfo.getLongVersionCode();
                    } else {
                        longVersionCode = packageInfo.versionCode;
                    }
                    return Boolean.valueOf(longVersionCode >= 1);
                } catch (PackageManager.NameNotFoundException unused) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    um.d(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.d = icVar;
    }

    @Override // com.bytedance.embedapplog.ic
    public boolean d(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolHc = this.hc.hc(context);
        if (this.d != null && !boolHc.booleanValue()) {
            return this.d.d(context);
        }
        return boolHc.booleanValue();
    }

    @Override // com.bytedance.embedapplog.ic
    public ic.d hc(final Context context) {
        if (this.d != null && !this.hc.hc(new Object[0]).booleanValue()) {
            return this.d.hc(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new tc(context, intent, new tc.hc<cb, String>() { // from class: com.bytedance.embedapplog.ed.2
            @Override // com.bytedance.embedapplog.tc.hc
            /* renamed from: hc, reason: merged with bridge method [inline-methods] */
            public cb d(IBinder iBinder) {
                return cb.d.d(iBinder);
            }

            @Override // com.bytedance.embedapplog.tc.hc
            public String d(cb cbVar) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
                if (cbVar == null) {
                    return null;
                }
                String strB = ed.this.b(context);
                if (TextUtils.isEmpty(strB)) {
                    return null;
                }
                return cbVar.d(context.getPackageName(), strB, "OUID");
            }
        }).d();
        ic.d dVar = new ic.d();
        dVar.hc = str;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Context context) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Exception e) {
            um.d(e);
        }
        Signature[] signatureArr = packageInfo != null ? packageInfo.signatures : null;
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    return sb.toString();
                }
            } catch (Exception e2) {
                um.d(e2);
            }
        }
        return null;
    }
}
