package ca.da.ca.ea;

import java.util.HashMap;
import java.util.HashSet;

/* compiled from: AllowEventFilter.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends a {
    public b(HashSet<String> hashSet, HashMap<String, HashSet<String>> map) {
        super(hashSet, map);
    }

    @Override // ca.da.ca.ea.a
    public boolean a(String str) {
        return !this.a.contains(str);
    }

    @Override // ca.da.ca.ea.a
    public boolean a(HashSet<String> hashSet, String str) {
        return !hashSet.contains(str);
    }
}
