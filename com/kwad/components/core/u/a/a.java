package com.kwad.components.core.u.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public final boolean abd;
    public final boolean abe;
    public final String name;

    public a(String str, boolean z) {
        this(str, z, false);
    }

    public a(String str, boolean z, boolean z2) {
        this.name = str;
        this.abd = z;
        this.abe = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.abd == aVar.abd && this.abe == aVar.abe) {
            return this.name.equals(aVar.name);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.name.hashCode() * 31) + (this.abd ? 1 : 0)) * 31) + (this.abe ? 1 : 0);
    }

    public final String toString() {
        return "Permission{name='" + this.name + "', granted=" + this.abd + ", shouldShowRequestPermissionRationale=" + this.abe + '}';
    }
}
