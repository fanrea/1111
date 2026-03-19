package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class p3 {
    private static final String a = "p3";

    static /* synthetic */ String a() {
        return (String) pro.getobjresult(77, 1, new Object[0]);
    }

    private JSONObject a(PackageInfo packageInfo) {
        return (JSONObject) pro.getobjresult(78, 0, this, packageInfo);
    }

    private JSONObject a(String str) {
        return (JSONObject) pro.getobjresult(79, 0, this, str);
    }

    private void a(int i, int i2, int i3) {
        pro.getVresult(80, 0, this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private void a(Context context, int i, boolean z) {
        pro.getVresult(81, 0, this, context, Integer.valueOf(i), Boolean.valueOf(z));
    }

    private void a(Context context, JSONArray jSONArray, int i) {
        pro.getVresult(82, 0, this, context, jSONArray, Integer.valueOf(i));
    }

    private boolean a(PackageInfo packageInfo, boolean z) {
        return pro.getZresult(83, 0, this, packageInfo, Boolean.valueOf(z));
    }

    private boolean a(String str, String[] strArr, boolean z) {
        return pro.getZresult(84, 0, this, str, strArr, Boolean.valueOf(z));
    }

    private List<ResolveInfo> b() {
        return (List) pro.getobjresult(85, 0, this);
    }

    private boolean c() {
        return pro.getZresult(86, 0, this);
    }

    boolean a(Context context) {
        return pro.getZresult(87, 0, this, context);
    }

    void d() {
        pro.getVresult(88, 0, this);
    }

    p3() {
    }

    /* compiled from: A */
    class a extends hz {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) {
            p3.a();
            b10.a(9200004, null, Integer.valueOf(this.a), Integer.valueOf(i), null);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
            p3.a();
            yy.b("alt_report_time", System.currentTimeMillis());
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Object objOpt = GlobalSetting.getSettings().opt("ecais");
            b10.a(1130038, null, Integer.valueOf((objOpt == null || !(objOpt instanceof Boolean)) ? -1 : ((Boolean) objOpt).booleanValue() ? 1 : 0));
        }

        b() {
        }
    }
}
