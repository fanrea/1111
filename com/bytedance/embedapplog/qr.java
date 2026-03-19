package com.bytedance.embedapplog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class qr implements b {
    private static volatile qr d;
    private final CopyOnWriteArraySet<b> hc = new CopyOnWriteArraySet<>();

    public static qr d() {
        if (d == null) {
            synchronized (qr.class) {
                if (d == null) {
                    d = new qr();
                }
            }
        }
        return d;
    }

    private qr() {
    }

    @Override // com.bytedance.embedapplog.b
    public void d(String str, String str2, String str3) {
        Iterator<b> it = this.hc.iterator();
        while (it.hasNext()) {
            it.next().d(str, str2, str3);
        }
    }

    @Override // com.bytedance.embedapplog.b
    public void d(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<b> it = this.hc.iterator();
        while (it.hasNext()) {
            it.next().d(z, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.bytedance.embedapplog.b
    public void d(boolean z, JSONObject jSONObject) {
        Iterator<b> it = this.hc.iterator();
        while (it.hasNext()) {
            it.next().d(z, jSONObject);
        }
    }

    @Override // com.bytedance.embedapplog.b
    public void hc(boolean z, JSONObject jSONObject) {
        Iterator<b> it = this.hc.iterator();
        while (it.hasNext()) {
            it.next().hc(z, jSONObject);
        }
    }
}
