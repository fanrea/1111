package com.baidu.mobads.container.landingpage;

import android.content.Context;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.sdk.internal.cm;
import com.baidu.mobstat.forbes.Config;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class aq {
    public static final String b = "adt";
    public long c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    protected Context n;

    protected abstract HashMap<String, String> a();

    public aq(XAdRemoteCommandExtraInfo xAdRemoteCommandExtraInfo) {
        this(xAdRemoteCommandExtraInfo.a().getAdId(), xAdRemoteCommandExtraInfo.a().getQueryKey(), xAdRemoteCommandExtraInfo.a, xAdRemoteCommandExtraInfo.g, xAdRemoteCommandExtraInfo.f);
    }

    @Deprecated
    public aq(String str, String str2, String str3, String str4, String str5) {
        this.d = "-1";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.l = "";
        this.m = "";
        this.n = com.baidu.mobads.container.f.b();
        this.c = System.currentTimeMillis();
        this.d = str;
        this.e = str2;
        this.g = str5;
        if (this.n != null) {
            this.f = this.n.getPackageName();
        }
        this.h = str4;
        this.j = DeviceUtils.getInstance().f(this.n);
        this.k = "android";
        this.i = "android_" + com.baidu.mobads.container.j.b() + Config.replace + cm.f;
        this.l = str3;
        this.m = com.baidu.mobads.container.util.u.a(IDManager.getInstance().a(this.n));
    }

    protected HashMap<String, String> b() {
        HashMap<String, String> map = new HashMap<>();
        map.put("adid", this.d);
        map.put(a.j, this.g);
        map.put("appsid", this.h);
        map.put("pack", this.f);
        map.put("qk", this.e);
        map.put("sn", this.j);
        map.put(com.baidu.mobads.container.components.command.j.s, "" + this.c);
        map.put("v", this.i);
        map.put("os", this.k);
        map.put("prod", this.l);
        map.put("cuid", this.m);
        map.put("p_ver", com.baidu.mobads.container.f.c());
        return map;
    }

    public HashMap<String, String> c() {
        HashMap<String, String> mapB = b();
        HashMap<String, String> mapA = a();
        if (mapA != null) {
            mapB.putAll(mapA);
        }
        return mapB;
    }

    public String toString() {
        return a(c());
    }

    protected String a(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        try {
            StringBuilder sb2 = new StringBuilder();
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (str != null && str2 != null) {
                    String strA = a(str);
                    String strA2 = a(str2);
                    sb.append(strA).append("=").append(strA2).append(com.alipay.sdk.m.s.a.n);
                    sb2.append(strA2).append(",");
                }
            }
            sb2.append(com.baidu.mobads.container.h.s);
            sb.append("vd=").append(com.baidu.mobads.container.util.ap.a(sb2.toString())).append(com.alipay.sdk.m.s.a.n);
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    protected String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
        } catch (Exception e) {
            return str;
        }
    }
}
