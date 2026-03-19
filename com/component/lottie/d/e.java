package com.component.lottie.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    public static final e a = new e("COMPOSITION");
    private final List<String> b;
    private f c;

    public e(String... strArr) {
        this.b = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.b = new ArrayList(eVar.b);
        this.c = eVar.c;
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.b.add(str);
        return eVar;
    }

    public e a(f fVar) {
        e eVar = new e(this);
        eVar.c = fVar;
        return eVar;
    }

    public f a() {
        return this.c;
    }

    public boolean a(String str, int i) {
        if (b(str)) {
            return true;
        }
        if (i >= this.b.size()) {
            return false;
        }
        return this.b.get(i).equals(str) || this.b.get(i).equals("**") || this.b.get(i).equals("*");
    }

    public int b(String str, int i) {
        if (b(str)) {
            return 0;
        }
        if (this.b.get(i).equals("**")) {
            return (i != this.b.size() - 1 && this.b.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean c(String str, int i) {
        if (i >= this.b.size()) {
            return false;
        }
        boolean z = i == this.b.size() - 1;
        String str2 = this.b.get(i);
        if (!TextUtils.equals(str2, "**")) {
            return (z || (i == this.b.size() + (-2) && c())) && (TextUtils.equals(str2, str) || TextUtils.equals(str2, "*"));
        }
        if (!z && this.b.get(i + 1).equals(str)) {
            return i == this.b.size() + (-2) || (i == this.b.size() + (-3) && c());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.b.size() - 1) {
            return false;
        }
        return this.b.get(i2).equals(str);
    }

    public boolean d(String str, int i) {
        return "__container".equals(str) || i < this.b.size() - 1 || this.b.get(i).equals("**");
    }

    private boolean b(String str) {
        return "__container".equals(str);
    }

    private boolean c() {
        return this.b.get(this.b.size() - 1).equals("**");
    }

    public String b() {
        return this.b.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.b.equals(eVar.b)) {
            return this.c != null ? this.c.equals(eVar.c) : eVar.c == null;
        }
        return false;
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + (this.c != null ? this.c.hashCode() : 0);
    }

    public String toString() {
        return "KeyPath{keys=" + this.b + ",resolved=" + (this.c != null) + '}';
    }
}
