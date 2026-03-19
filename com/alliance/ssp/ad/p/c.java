package com.alliance.ssp.ad.p;

import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.o0.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: HttpRequest.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    public String a;
    public String[] b;
    public int c;
    public BaseNetAction.Method d;

    public c(String str, BaseNetAction.Method method, Map<String, Object> map, int i, boolean z) throws UnsupportedEncodingException {
        new HashMap();
        this.d = method;
        this.c = i;
        if (map == null || map.isEmpty()) {
            this.a = str;
            if (z) {
                this.a += "&isshakeclick=1";
                int i2 = l.a;
                return;
            }
            return;
        }
        if (method == BaseNetAction.Method.GET) {
            String strA = a(map);
            Objects.toString(map.get("sposid"));
            int i3 = l.a;
            String strA2 = com.alliance.ssp.ad.o.e.a(strA);
            strA2 = map.containsKey("sposid") ? strA2 + com.alipay.sdk.m.s.a.n + "sposid=" + map.get("sposid") : strA2;
            this.a = str.indexOf("?") > 0 ? str + com.alipay.sdk.m.s.a.n + strA2 : str + "?" + strA2;
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                if (sb.length() > 0) {
                    sb.append(com.alipay.sdk.m.s.a.n);
                }
                String strTrim = entry.getValue().toString().trim();
                try {
                    strTrim = URLEncoder.encode(strTrim, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.getMessage();
                    int i4 = l.a;
                }
                sb.append(entry.getKey().trim()).append("=").append(strTrim);
            }
        }
        this.b = com.alliance.ssp.ad.o.e.b(sb.toString());
        this.a = str;
    }

    public static String a(Map<String, Object> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null && !"sposid".equals(entry.getKey())) {
                if (sb.length() > 0) {
                    sb.append(com.alipay.sdk.m.s.a.n);
                }
                String strTrim = entry.getValue().toString().trim();
                try {
                    strTrim = URLEncoder.encode(strTrim, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append(entry.getKey().trim()).append("=").append(strTrim);
            }
        }
        return sb.toString();
    }
}
