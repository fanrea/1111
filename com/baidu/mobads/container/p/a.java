package com.baidu.mobads.container.p;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobstat.forbes.Config;
import com.component.c.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static final String a = a.class.getSimpleName();
    private Context d;
    private String e;
    private String f;
    private String g;
    private final bq b = bq.a();
    private boolean c = true;
    private boolean h = true;

    public interface b {
        void a(j jVar, Boolean bool, Boolean bool2);
    }

    public a(Context context, String str, String str2, String str3) {
        this.d = context;
        this.e = str;
        this.g = str2;
        this.f = str3;
    }

    public void a(boolean z) {
        this.h = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x019e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x020b A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x034c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0184  */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.baidu.mobads.container.adrequest.j r33, com.baidu.mobads.container.p.a.b r34) {
        /*
            Method dump skipped, instructions count: 941
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.p.a.a(com.baidu.mobads.container.adrequest.j, com.baidu.mobads.container.p.a$b):void");
    }

    public boolean a(long j, boolean z, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!z) {
            if (jCurrentTimeMillis - j < i) {
                return false;
            }
            return true;
        }
        long jA = new com.baidu.mobads.container.p.b().a(0);
        if (jA <= j && j <= jA + 86400000) {
            return false;
        }
        return true;
    }

    protected C0130a a(j jVar) {
        return new C0130a(this.d).a(jVar);
    }

    /* renamed from: com.baidu.mobads.container.p.a$a, reason: collision with other inner class name */
    protected static class C0130a {
        Context a;
        List<ResolveInfo> b = new ArrayList();
        List<ResolveInfo> c = new ArrayList();
        boolean d = false;
        Uri e;
        String f;

        C0130a(Context context) {
            this.a = context;
        }

        public C0130a a(j jVar) {
            int i;
            int i2;
            if (jVar == null) {
                return this;
            }
            try {
                JSONObject jSONObject = new JSONObject(jVar.getAppOpenStrs());
                String strOptString = jSONObject.optString("page", "");
                int iOptInt = jSONObject.optInt(Config.INPUT_DEF_VERSION, 0);
                this.e = Uri.parse(strOptString);
                Intent intent = new Intent("android.intent.action.VIEW", this.e);
                intent.addFlags(268435456);
                this.b = new d(this.a).a(intent, 65536);
                for (ResolveInfo resolveInfo : this.b) {
                    if (TextUtils.equals(resolveInfo.activityInfo.packageName, jVar.getAppPackageName())) {
                        this.d = true;
                        if (iOptInt > 0) {
                            PackageInfo packageInfoA = bk.a(this.a, resolveInfo.activityInfo.packageName, 0);
                            if (packageInfoA == null) {
                                i2 = 0;
                            } else {
                                i2 = packageInfoA.versionCode;
                            }
                            if (i2 < iOptInt) {
                                this.d = false;
                            }
                        }
                    } else if (resolveInfo.activityInfo.packageName.startsWith(jVar.getAppPackageName())) {
                        PackageInfo packageInfoA2 = bk.a(this.a, resolveInfo.activityInfo.packageName, 0);
                        if (packageInfoA2 == null) {
                            i = 0;
                        } else {
                            i = packageInfoA2.versionCode;
                        }
                        if (iOptInt <= i) {
                            this.c.add(resolveInfo);
                        }
                    }
                }
                this.f = jVar.getAppPackageName();
            } catch (Exception e) {
                this.b = null;
                this.e = null;
                this.d = false;
            }
            return this;
        }

        public int a(boolean z) {
            if (z) {
                return this.d ? 1 : 0;
            }
            if (this.b == null) {
                return 0;
            }
            return this.b.size();
        }

        public Uri a() {
            return this.e;
        }

        public String b() {
            return this.f;
        }

        public String c() {
            if (this.c == null || this.c.size() == 0) {
                return "";
            }
            try {
                return this.c.get(0).activityInfo.packageName;
            } catch (Throwable th) {
                return "";
            }
        }
    }
}
