package com.bytedance.bdtracker;

import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.widget.Toast;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.sdk.internal.ca;
import com.bytedance.applog.IPicker;
import com.bytedance.applog.simulate.SimulateLaunchActivity;
import com.bytedance.bdtracker.l0;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.github.lzyzsd.library.BuildConfig;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class r3 extends AsyncTask<Void, Void, JSONObject> {
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public final d g;

    public static void a(d dVar) {
        new r3(dVar).execute(new Void[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b9 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject doInBackground(java.lang.Void[] r30) throws org.json.JSONException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.r3.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        int iIndexOf;
        JSONObject jSONObject2 = jSONObject;
        this.g.D.debug(Collections.singletonList("SimulateLoginTask"), "Simulate login with response: {}", jSONObject2);
        if (jSONObject2 == null) {
            Toast.makeText(this.g.n, "启动埋点验证|圈选失败，服务端无响应", 1).show();
            return;
        }
        String strOptString = jSONObject2.optString(cm.V);
        String strOptString2 = jSONObject2.optString("Set-Cookie");
        int iOptInt = jSONObject2.optInt("status");
        if (l0.b.d(strOptString2) && (iIndexOf = strOptString2.indexOf(com.alipay.sdk.m.u.i.b)) >= 0) {
            strOptString2 = strOptString2.substring(0, iIndexOf);
        }
        if (SimulateLaunchActivity.entryMode == 1 && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("data")) != null) {
            this.f = jSONObjectOptJSONObject.optString(ILogConst.Keys.KEY_MODE, "").equals(com.baidu.mobads.container.components.j.a.b) ? SimulateLaunchActivity.DEBUG_LOG : SimulateLaunchActivity.BIND_QUERY;
        }
        if (iOptInt != 0 || !ca.k.equals(strOptString)) {
            if (iOptInt == 0 || !l0.b.d(jSONObject2.optString(cm.V))) {
                this.g.D.warn(Collections.singletonList("SimulateLoginTask"), "Start simulator failed, please check server response: {}", jSONObject2);
                return;
            } else {
                Toast.makeText(this.g.n, a.a("启动埋点验证|圈选失败: ").append(jSONObject2.optString(cm.V)).toString(), 1).show();
                return;
            }
        }
        if (SimulateLaunchActivity.DEBUG_LOG.equals(this.f)) {
            this.g.setRangersEventVerifyEnable(true, strOptString2);
            return;
        }
        IPicker picker = null;
        if (this.g.getInitConfig() != null && this.g.getInitConfig().getPicker() != null) {
            picker = this.g.getInitConfig().getPicker();
        }
        if (picker != null) {
            picker.setMarqueeCookie(strOptString2);
        }
        this.g.startSimulator(strOptString2);
    }

    public r3(d dVar) {
        this.g = dVar;
        dVar.k.a = SimulateLaunchActivity.entryUrlPrefix;
        this.f = SimulateLaunchActivity.entryType;
        this.c = SimulateLaunchActivity.entryQrParam;
        this.e = dVar.getDid();
        String str = (String) dVar.getHeaderValue("resolution", null, String.class);
        if (l0.b.d(str)) {
            String[] strArrSplit = str.split("x");
            this.b = Integer.parseInt(strArrSplit[0]);
            this.a = Integer.parseInt(strArrSplit[1]);
        }
        PackageInfo packageInfoA = t4.a(dVar.n, dVar.n.getApplicationInfo().packageName, 0);
        this.d = packageInfoA != null ? packageInfoA.versionName : BuildConfig.VERSION_NAME;
        dVar.D.debug(Collections.singletonList("SimulateLoginTask"), "Simulate task init success", new Object[0]);
    }
}
