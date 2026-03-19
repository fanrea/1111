package com.bytedance.pangle.c;

import com.bytedance.sdk.openadsdk.api.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static String an = "7z_unzip_start";
    public static String b = "download_finish";
    public static String c = "install_start";
    public static String d = "request_finish";
    public static String gb = "load_start";
    public static String h = "7z_unzip_finish";
    public static String hc = "download_start";
    private static volatile hc mk = null;
    public static String tc = "rm_entry_finish";
    public static String tt = "load_finish";
    public static String u = "install_finish";
    private final List<com.bytedance.pangle.c.d> mq = new ArrayList();

    public static class d {
        public static int an = 12001;
        public static int b = -1;
        public static int ba = 50004;
        public static int c = -2;
        public static int cb = 22002;
        public static int d = 1;
        public static int de = 32002;
        public static int e = 22001;
        public static int fs = 50000;
        public static int gb = 12003;
        public static int h = 12002;
        public static int hc = 2;
        public static int he = 32006;
        public static int j = 32999;
        public static int jh = 32000;
        public static int k = 22000;
        public static int mk = 21000;
        public static int mq = 21001;
        public static int np = 32004;
        public static int rf = 31000;
        public static int s = 40000;
        public static int sy = 32001;
        public static int tc = 20000;
        public static int tt = 12004;
        public static int u = 12000;
        public static int uo = 21002;
        public static int us = 41000;
        public static int v = 32003;
        public static int vv = 32007;
        public static int w = 22999;
        public static int yi = 32005;
        public static int yo = 30000;
        public static int z = 42000;
        public static int zw = 32008;
    }

    public static hc d() {
        if (mk == null) {
            synchronized (hc.class) {
                mk = new hc();
            }
        }
        return mk;
    }

    private hc() {
    }

    public void d(com.bytedance.pangle.c.d dVar) {
        synchronized (this.mq) {
            this.mq.add(dVar);
        }
    }

    public void d(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.mq) {
            Iterator<com.bytedance.pangle.c.d> it = this.mq.iterator();
            while (it.hasNext()) {
                try {
                    it.next().d(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    an.d(th);
                }
            }
        }
    }
}
