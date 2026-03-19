package com.pangrowth.adclog;

import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class q2 {
    public long a;
    public boolean b;
    public String c;
    public int d = 2;
    public String e = "no error";
    public long f;
    public HashMap<String, String> g;

    public q2(long j, boolean z, String str, HashMap<String, String> map) {
        this.f = 0L;
        this.g = null;
        this.a = j;
        this.b = z;
        this.c = str;
        this.f = System.currentTimeMillis();
        this.g = map;
    }

    public String toString() {
        return "UploadInfo{lastUploadTime=" + this.a + ", isUploading=" + this.b + ", commandId='" + this.c + "', cloudMsgResponseCode=" + this.d + ", errorMsg='" + this.e + "', operateTime=" + this.f + ", specificParams=" + this.g + '}';
    }
}
