package com.dhylive.app.net;

import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class HashMapNonNull extends HashMap<String, Object> {
    public HashMapNonNull() {
    }

    public HashMapNonNull(HashMapNonNull hashMapNonNull) {
        super(hashMapNonNull);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(String str, Object obj) {
        return obj != null ? super.put((HashMapNonNull) str, (String) obj) : "";
    }
}
