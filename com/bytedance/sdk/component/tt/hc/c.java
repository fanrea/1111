package com.bytedance.sdk.component.tt.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class c {
    protected mq b;
    private Map<String, Object> d;
    private Object hc;
    protected String c = null;
    protected final Map<String, String> u = new HashMap();
    protected String an = null;
    protected boolean h = false;

    public abstract com.bytedance.sdk.component.tt.hc d();

    public c(mq mqVar) {
        this.b = mqVar;
        hc(UUID.randomUUID().toString());
    }

    public void d(String str) {
        this.an = str;
    }

    public void hc(String str, String str2) {
        this.u.put(str, str2);
    }

    public void c(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.u.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void hc(String str) {
        this.c = str;
    }

    public String hc() {
        return this.c;
    }

    public Map<String, Object> b() {
        return this.d;
    }

    public void u(Map<String, Object> map) {
        this.d = map;
    }

    public Object c() {
        return this.hc;
    }

    protected void d(k.d dVar) {
        if (dVar != null && this.u.size() > 0) {
            for (Map.Entry<String, String> entry : this.u.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    dVar.hc(key, value);
                }
            }
        }
    }

    public void d(boolean z) {
        this.h = z;
    }
}
