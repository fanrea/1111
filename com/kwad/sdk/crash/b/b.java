package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private Set<String> bNz = new HashSet();
    private Set<String> bNA = new HashSet();

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.bNz.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.bNA.add(str2);
                }
            }
        }
    }

    public final synchronized String[] aes() {
        Set<String> set;
        set = this.bNz;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized String[] aeh() {
        Set<String> set;
        set = this.bNA;
        return (String[]) set.toArray(new String[set.size()]);
    }
}
