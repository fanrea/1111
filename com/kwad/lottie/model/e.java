package com.kwad.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private final List<String> bnj;
    private f bnk;

    public e(String... strArr) {
        this.bnj = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.bnj = new ArrayList(eVar.bnj);
        this.bnk = eVar.bnk;
    }

    public final e dp(String str) {
        e eVar = new e(this);
        eVar.bnj.add(str);
        return eVar;
    }

    public final e a(f fVar) {
        e eVar = new e(this);
        eVar.bnk = fVar;
        return eVar;
    }

    public final f Rg() {
        return this.bnk;
    }

    public final boolean q(String str, int i) {
        if (dq(str)) {
            return true;
        }
        if (i >= this.bnj.size()) {
            return false;
        }
        return this.bnj.get(i).equals(str) || this.bnj.get(i).equals("**") || this.bnj.get(i).equals("*");
    }

    public final int r(String str, int i) {
        if (dq(str)) {
            return 0;
        }
        if (this.bnj.get(i).equals("**")) {
            return (i != this.bnj.size() - 1 && this.bnj.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean s(String str, int i) {
        if (i >= this.bnj.size()) {
            return false;
        }
        boolean z = i == this.bnj.size() - 1;
        String str2 = this.bnj.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.bnj.size() + (-2) && Rh())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.bnj.get(i + 1).equals(str)) {
            return i == this.bnj.size() + (-2) || (i == this.bnj.size() + (-3) && Rh());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.bnj.size() - 1) {
            return false;
        }
        return this.bnj.get(i2).equals(str);
    }

    public final boolean t(String str, int i) {
        return str.equals("__container") || i < this.bnj.size() - 1 || this.bnj.get(i).equals("**");
    }

    private static boolean dq(String str) {
        return str.equals("__container");
    }

    private boolean Rh() {
        return this.bnj.get(r0.size() - 1).equals("**");
    }

    public final String toString() {
        return "KeyPath{keys=" + this.bnj + ",resolved=" + (this.bnk != null) + '}';
    }
}
