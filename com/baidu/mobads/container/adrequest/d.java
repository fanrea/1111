package com.baidu.mobads.container.adrequest;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.components.command.OtherDLInfoManager;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.az;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.bw;
import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d implements g {
    public HashMap<String, String> mAdditionalParameters;
    public Context mCxt;
    public String mPrefixOfV = "android";

    public d(Context context) {
        this.mCxt = context;
    }

    protected HashMap<String, String> fixedParameters2HashMap() {
        HashMap<String, String> map = new HashMap<>();
        try {
            map.put(g.l, "133");
            map.put("appid", DeviceUtils.getInstance().l(this.mCxt));
            map.put("act", getAct());
            map.put(g.p, "" + System.currentTimeMillis());
            map.put(g.q, DeviceUtils.getInstance().l(this.mCxt) + "_cpr");
            map.put("pk", com.baidu.mobads.container.util.t.f(this.mCxt));
            map.put(g.s, DeviceUtils.getInstance().g(this.mCxt));
            map.put("g", DeviceUtils.getInstance().d(this.mCxt));
            map.put(g.v, DeviceUtils.getInstance().n(this.mCxt));
            map.put(g.z, IDManager.getInstance().c(this.mCxt));
            map.put(g.B, DeviceUtils.getInstance().j(this.mCxt));
            map.put("sn", DeviceUtils.getInstance().b(this.mCxt));
            map.put("cuid", IDManager.getInstance().a(this.mCxt));
            map.put(g.E, IDManager.getInstance().b(this.mCxt));
            map.put("oaid", com.baidu.mobads.container.util.f.z.a(this.mCxt));
            map.put(g.I, com.baidu.mobads.container.util.b.a().b(this.mCxt));
            map.put(g.J, com.baidu.mobads.container.util.f.a().a(this.mCxt));
            map.put(g.f719K, "" + bv.b(this.mCxt));
            map.put("sh", "" + bv.c(this.mCxt));
            map.put(g.O, "" + bv.e(this.mCxt));
            map.put("bdr", "" + com.baidu.mobads.container.util.x.a(this.mCxt).a());
            map.put("os", "android");
            map.put(g.R, com.baidu.mobads.container.util.x.a(this.mCxt).d());
            map.put("osv", com.baidu.mobads.container.util.x.a(this.mCxt).c());
            map.put(g.T, DeviceUtils.getInstance().b());
            map.put(g.aj, DeviceUtils.getInstance().d());
            map.put(g.ak, DeviceUtils.getInstance().e());
            if ("harmony".equals(DeviceUtils.getInstance().d())) {
                map.put(g.al, String.valueOf(DeviceUtils.getInstance().q(this.mCxt)));
            }
            String str = "1";
            map.put(g.U, DeviceUtils.getInstance().a(this.mCxt) ? "1" : "0");
            map.put(g.V, bw.a(this.mCxt) + "," + bw.b(this.mCxt));
            map.put(g.X, "sdk_9.40");
            map.put("v", this.mPrefixOfV + Config.replace + com.baidu.mobads.container.j.b() + Config.replace + com.baidu.mobads.container.j.a());
            map.put("p_ver", com.baidu.mobads.container.config.b.a().j());
            map.put("net", "" + com.baidu.mobads.container.util.e.a.h(this.mCxt));
            map.put(g.ab, "" + (com.baidu.mobads.container.util.e.a.i(this.mCxt).booleanValue() ? 1 : 0));
            map.put(g.ac, "" + (com.baidu.mobads.container.h.a.a().e() ? 2 : 1));
            map.put(g.ad, com.baidu.mobads.container.util.e.a.a(this.mCxt));
            map.put(g.ae, com.baidu.mobads.container.config.b.a().h());
            map.put(g.A, IDManager.getInstance().d(this.mCxt));
            map.put(g.am, "" + com.baidu.mobads.container.util.x.a(this.mCxt).i());
            map.put(g.an, "" + com.baidu.mobads.container.util.x.a(this.mCxt).h());
            if (com.baidu.mobads.container.h.a.a().h()) {
                map.put("sp_shake", "2");
            }
            if (!az.a(this.mCxt)) {
                str = "0";
            }
            map.put(g.ai, str);
            if (!TextUtils.isEmpty(com.baidu.mobads.container.config.a.a().g())) {
                map.put(g.ao, "" + com.baidu.mobads.container.config.a.a().g());
            }
            OtherDLInfoManager.getInstance().a(this.mCxt);
            String strB = com.baidu.mobads.container.components.h.a.a.a().b();
            if (!TextUtils.isEmpty(strB)) {
                map.put(g.ap, strB);
            }
            map.put(g.aq, DeviceUtils.getInstance().r(this.mCxt));
            map.put(g.ar, com.baidu.mobads.container.o.c.a().a(this.mCxt));
            map.put(g.as, com.baidu.mobads.container.o.c.a().b(this.mCxt));
            return map;
        } catch (Throwable th) {
            th.printStackTrace();
            return map;
        }
    }

    private String getAct() {
        if (com.baidu.mobads.container.util.t.b(this.mCxt)) {
            return "NA,LP,DL,APO";
        }
        return "NA,LP,APO";
    }

    public String toFullURL() {
        HashMap<String, String> mapFixedParameters2HashMap = fixedParameters2HashMap();
        mapFixedParameters2HashMap.putAll(additionalParameters2HashMap());
        return com.baidu.mobads.container.util.o.a(com.baidu.mobads.container.util.o.e(h.a), mapFixedParameters2HashMap);
    }

    public String getRequestToken() {
        HashMap<String, String> mapFixedParameters2HashMap = fixedParameters2HashMap();
        mapFixedParameters2HashMap.putAll(additionalParameters2HashMap());
        return "code2=" + com.baidu.mobads.container.util.o.a(mapFixedParameters2HashMap);
    }

    public HashMap<String, String> additionalParameters2HashMap() {
        HashMap<String, String> map = new HashMap<>();
        if (this.mAdditionalParameters != null && this.mAdditionalParameters.size() > 0) {
            for (String str : this.mAdditionalParameters.keySet()) {
                String strValueOf = this.mAdditionalParameters.get(str);
                try {
                    if (g.l.equals(str) && com.baidu.mobads.container.util.ab.b()) {
                        strValueOf = String.valueOf(Integer.parseInt(strValueOf) + 2048 + 8192);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                map.put(str, strValueOf);
            }
        }
        return map;
    }
}
