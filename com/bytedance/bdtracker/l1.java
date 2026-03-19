package com.bytedance.bdtracker;

import java.util.Objects;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class l1 {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public l1(boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
        this.d = false;
    }

    public l1(boolean z, boolean z2, boolean z3) {
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public abstract String a();

    public abstract boolean a(JSONObject jSONObject);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l1) {
            return Objects.equals(a(), ((l1) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }
}
