package com.bytedance.bdtracker;

import java.util.HashMap;
import java.util.HashSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c1 extends b1 {
    public c1(HashSet<String> hashSet, HashMap<String, HashSet<String>> map) {
        super(hashSet, map);
    }

    @Override // com.bytedance.bdtracker.b1
    public boolean a(String str) {
        return !this.a.contains(str);
    }

    @Override // com.bytedance.bdtracker.b1
    public boolean a(HashSet<String> hashSet, String str) {
        return !hashSet.contains(str);
    }
}
