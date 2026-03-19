package com.kwai.kanas.vader.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class d extends i {
    private final String a;
    private final f b;
    private final f c;
    private final f d;
    private final com.kwai.kanas.vader.b e;

    d(String str, f fVar, f fVar2, f fVar3, com.kwai.kanas.vader.b bVar) {
        if (str == null) {
            throw new NullPointerException("Null databaseName");
        }
        this.a = str;
        if (fVar == null) {
            throw new NullPointerException("Null realtimeUploader");
        }
        this.b = fVar;
        if (fVar2 == null) {
            throw new NullPointerException("Null highFreqUploader");
        }
        this.c = fVar2;
        if (fVar3 == null) {
            throw new NullPointerException("Null normalUploader");
        }
        this.d = fVar3;
        if (bVar == null) {
            throw new NullPointerException("Null logger");
        }
        this.e = bVar;
    }

    @Override // com.kwai.kanas.vader.f.i
    public final String a() {
        return this.a;
    }

    @Override // com.kwai.kanas.vader.f.i
    public final f b() {
        return this.b;
    }

    @Override // com.kwai.kanas.vader.f.i
    public final f c() {
        return this.c;
    }

    @Override // com.kwai.kanas.vader.f.i
    public final f d() {
        return this.d;
    }

    @Override // com.kwai.kanas.vader.f.i
    public final com.kwai.kanas.vader.b e() {
        return this.e;
    }

    public final String toString() {
        return "VaderConfig{databaseName=" + this.a + ", realtimeUploader=" + this.b + ", highFreqUploader=" + this.c + ", normalUploader=" + this.d + ", logger=" + this.e + com.alipay.sdk.m.u.i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a.equals(iVar.a()) && this.b.equals(iVar.b()) && this.c.equals(iVar.c()) && this.d.equals(iVar.d()) && this.e.equals(iVar.e())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
    }
}
