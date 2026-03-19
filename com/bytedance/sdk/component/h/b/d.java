package com.bytedance.sdk.component.h.b;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.h.d, com.bytedance.sdk.component.h.hc {
    private final com.bytedance.sdk.component.c.d.d d;
    private final boolean hc = false;

    public d(com.bytedance.sdk.component.c.d.d dVar) {
        this.d = dVar;
    }

    @Override // com.bytedance.sdk.component.h.d
    public Map<String, Object> d(File file) {
        if (file.getName().endsWith(".prop")) {
            return new hc(this.d, this.hc).d(file);
        }
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            return new hc(this.d, this.hc).d(file2);
        }
        if (file.getName().endsWith("xml")) {
            if (u.d()) {
                return new u(this.d, this.hc).d(file);
            }
            return new an(this.d, this.hc).d(file);
        }
        return new ConcurrentHashMap();
    }

    @Override // com.bytedance.sdk.component.h.hc
    public void d(Map<String, Object> map, File file) throws Throwable {
        if (!file.getName().endsWith(".prop")) {
            file = new File(file.getParent(), file.getName() + ".prop");
        }
        file.setReadable(true, false);
        new hc(this.d, this.hc).d(map, file);
    }
}
