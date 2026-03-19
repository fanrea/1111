package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.ic;
import com.bytedance.embedapplog.tc;
import com.bytedance.embedapplog.zk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class rs implements ic {
    private static final gv<Boolean> hc = new gv<Boolean>() { // from class: com.bytedance.embedapplog.rs.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.gv
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean d(Object... objArr) {
            return Boolean.valueOf(oc.d((Context) objArr[0]));
        }
    };
    private String d;

    rs() {
    }

    private boolean u(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.d = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.d = "com.huawei.hwid.tv";
            } else {
                this.d = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return hc.hc(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.ic
    public boolean d(Context context) {
        return u(context);
    }

    @Override // com.bytedance.embedapplog.ic
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d hc(Context context) {
        d dVar = new d();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    dVar.hc = string;
                    dVar.b = Boolean.parseBoolean(string2);
                    dVar.d = 202003021704L;
                    return dVar;
                }
            } catch (Throwable th) {
                um.d(th);
            }
        }
        Pair<String, Boolean> pairAn = an(context);
        if (pairAn != null) {
            dVar.hc = (String) pairAn.first;
            dVar.b = ((Boolean) pairAn.second).booleanValue();
            dVar.d = d(context, this.d);
        }
        return dVar;
    }

    private static int d(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            um.d(e);
            return 0;
        }
    }

    private Pair<String, Boolean> an(Context context) {
        if (TextUtils.isEmpty(this.d)) {
            return null;
        }
        return (Pair) new tc(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.d), new tc.hc<zk, Pair<String, Boolean>>() { // from class: com.bytedance.embedapplog.rs.2
            @Override // com.bytedance.embedapplog.tc.hc
            /* renamed from: hc, reason: merged with bridge method [inline-methods] */
            public zk d(IBinder iBinder) {
                return zk.d.d(iBinder);
            }

            @Override // com.bytedance.embedapplog.tc.hc
            public Pair<String, Boolean> d(zk zkVar) {
                if (zkVar == null) {
                    return null;
                }
                return new Pair<>(zkVar.d(), Boolean.valueOf(zkVar.hc()));
            }
        }).d();
    }

    static class d extends ic.d {
        long d = 0;

        d() {
        }
    }
}
