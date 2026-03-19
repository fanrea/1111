package com.baidu.mobads.container.util;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class br {
    public boolean a() {
        return b() || c();
    }

    public boolean b() {
        String strG = x.a(null).g();
        if (strG != null && strG.contains("test-keys")) {
            return true;
        }
        return false;
    }

    public boolean c() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
