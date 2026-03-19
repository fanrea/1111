package com.tachikoma.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    private final List<String> KT;
    private e KU;

    public d(String... strArr) {
        this.KT = Arrays.asList(strArr);
    }

    private d(d dVar) {
        this.KT = new ArrayList(dVar.KT);
        this.KU = dVar.KU;
    }

    public final d ad(String str) {
        d dVar = new d(this);
        dVar.KT.add(str);
        return dVar;
    }

    public final d a(e eVar) {
        d dVar = new d(this);
        dVar.KU = eVar;
        return dVar;
    }

    public final e ky() {
        return this.KU;
    }

    public final boolean j(String str, int i) {
        if (ae(str)) {
            return true;
        }
        if (i >= this.KT.size()) {
            return false;
        }
        return this.KT.get(i).equals(str) || this.KT.get(i).equals("**") || this.KT.get(i).equals("*");
    }

    public final int k(String str, int i) {
        if (ae(str)) {
            return 0;
        }
        if (this.KT.get(i).equals("**")) {
            return (i != this.KT.size() - 1 && this.KT.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean l(String str, int i) {
        if (i >= this.KT.size()) {
            return false;
        }
        boolean z = i == this.KT.size() - 1;
        String str2 = this.KT.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.KT.size() + (-2) && kz())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.KT.get(i + 1).equals(str)) {
            return i == this.KT.size() + (-2) || (i == this.KT.size() + (-3) && kz());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.KT.size() - 1) {
            return false;
        }
        return this.KT.get(i2).equals(str);
    }

    public final boolean m(String str, int i) {
        return "__container".equals(str) || i < this.KT.size() - 1 || this.KT.get(i).equals("**");
    }

    private static boolean ae(String str) {
        return "__container".equals(str);
    }

    private boolean kz() {
        return this.KT.get(r0.size() - 1).equals("**");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("KeyPath{keys=");
        sb.append(this.KT);
        sb.append(",resolved=");
        sb.append(this.KU != null);
        sb.append('}');
        return sb.toString();
    }
}
