package com.bytedance.sdk.component.d;

import android.net.Uri;
import com.bytedance.sdk.component.d.de;
import com.bytedance.sdk.component.d.mk;
import com.bytedance.sdk.component.d.sy;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class jh {
    private final de b = w.d;
    private final sy c;
    private final Set<String> d;
    private final Set<String> hc;
    private mk.hc u;

    jh(sy syVar, Set<String> set, Set<String> set2) {
        this.c = syVar;
        if (set == null || set.isEmpty()) {
            this.d = new LinkedHashSet();
        } else {
            this.d = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.hc = new LinkedHashSet();
        } else {
            this.hc = new LinkedHashSet(set2);
        }
    }

    final synchronized v d(boolean z, String str, hc hcVar) throws sy.d {
        v vVarHc;
        mk.hc hcVar2;
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        v vVar = this.hc.contains(hcVar.d()) ? v.PUBLIC : null;
        for (String str2 : this.d) {
            if (uri.getHost().equals(str2) || host.endsWith(".".concat(String.valueOf(str2)))) {
                vVar = v.PRIVATE;
                break;
            }
        }
        if (vVar == null && (hcVar2 = this.u) != null && hcVar2.d(str)) {
            if (this.u.d(str, hcVar.d())) {
                return null;
            }
            vVar = v.PRIVATE;
        }
        if (z) {
            vVarHc = d(str, hcVar);
        } else {
            vVarHc = hc(str, hcVar);
        }
        return vVarHc != null ? vVarHc : vVar;
    }

    final synchronized v d(String str, hc hcVar) throws sy.d {
        return d(str, hcVar, true);
    }

    final synchronized v hc(String str, hc hcVar) {
        return d(str, hcVar, false);
    }

    void d(mk.hc hcVar) {
        this.u = hcVar;
    }

    void d(de.d dVar) {
        de deVar = this.b;
        if (deVar != null) {
            deVar.d(dVar);
        }
    }

    void hc(de.d dVar) {
        de deVar = this.b;
        if (deVar != null) {
            deVar.hc(dVar);
        }
    }

    private v d(String str, hc hcVar, boolean z) {
        sy syVar;
        if (!z || (syVar = this.c) == null) {
            return null;
        }
        sy.b bVarD = syVar.d(str, this.d);
        if (bVarD.b.contains(hcVar.d())) {
            return null;
        }
        if (bVarD.hc.contains(hcVar.d())) {
            return v.PRIVATE;
        }
        if (bVarD.d.compareTo(hcVar.hc()) < 0) {
            return null;
        }
        return bVarD.d;
    }
}
