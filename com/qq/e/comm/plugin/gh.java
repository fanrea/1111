package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class gh {
    private Map<String, Object> a = new HashMap();

    public String c(String str) {
        Object obj;
        if (TextUtils.isEmpty(str) || (obj = this.a.get(str)) == null) {
            return null;
        }
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public int b(String str) {
        Object obj;
        if (TextUtils.isEmpty(str) || (obj = this.a.get(str)) == null) {
            return 0;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return 0;
        }
    }

    private void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.a.put(str, obj);
    }

    public boolean a(String str) {
        Object obj;
        if (TextUtils.isEmpty(str) || (obj = this.a.get(str)) == null) {
            return false;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public void a(String str, int i) {
        a(str, Integer.valueOf(i));
    }

    public void a(String str, String str2) {
        a(str, (Object) str2);
    }

    public void a(String str, boolean z) {
        a(str, Boolean.valueOf(z));
    }
}
