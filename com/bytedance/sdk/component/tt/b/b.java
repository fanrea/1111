package com.bytedance.sdk.component.tt.b;

import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    public boolean d = false;
    public boolean hc = true;
    public Map<String, Integer> b = null;
    public Map<String, String> c = null;
    public int u = 10;
    public int an = 1;
    public int h = 1;
    public int gb = 10;
    public int tt = 1;
    public int tc = 1;
    public int mk = 900;
    public int mq = 120;
    public String uo = null;
    public int k = 0;
    public long e = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ").append(this.d);
        sb.append(" probeEnable: ").append(this.hc);
        StringBuilder sbAppend = sb.append(" hostFilter: ");
        Map<String, Integer> map = this.b;
        sbAppend.append(map != null ? map.size() : 0);
        StringBuilder sbAppend2 = sb.append(" hostMap: ");
        Map<String, String> map2 = this.c;
        sbAppend2.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ").append(this.u).append("#").append(this.an).append("#").append(this.h);
        sb.append(" reqErr: ").append(this.gb).append("#").append(this.tt).append("#").append(this.tc);
        sb.append(" updateInterval: ").append(this.mk);
        sb.append(" updateRandom: ").append(this.mq);
        sb.append(" httpBlack: ").append(this.uo);
        return sb.toString();
    }
}
