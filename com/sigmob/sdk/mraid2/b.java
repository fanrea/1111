package com.sigmob.sdk.mraid2;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static final b b = new b();
    private final HashMap<String, d> a = new HashMap<>();

    private b() {
    }

    public static b a() {
        return b;
    }

    public d a(String uuid) {
        if (TextUtils.isEmpty(uuid)) {
            return null;
        }
        d dVar = this.a.get(uuid);
        this.a.remove(uuid);
        return dVar;
    }

    public void a(String uuid, d value) {
        if (TextUtils.isEmpty(uuid)) {
            return;
        }
        this.a.put(uuid, value);
    }

    public d b(String uuid) {
        if (TextUtils.isEmpty(uuid)) {
            return null;
        }
        return this.a.get(uuid);
    }
}
