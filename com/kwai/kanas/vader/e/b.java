package com.kwai.kanas.vader.e;

import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class b extends d {
    private final int a;
    private final int b;
    private final int c;
    private final long d;

    b(int i, int i2, int i3, long j) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
    }

    @Override // com.kwai.kanas.vader.e.d
    public final int a() {
        return this.a;
    }

    @Override // com.kwai.kanas.vader.e.d
    public final int b() {
        return this.b;
    }

    @Override // com.kwai.kanas.vader.e.d
    public final int c() {
        return this.c;
    }

    @Override // com.kwai.kanas.vader.e.d
    public final long d() {
        return this.d;
    }

    public final String toString() {
        return "SeqIdWrapper{seqId=" + this.a + ", channelSeqId=" + this.b + ", customSeqId=" + this.c + ", clientTimestamp=" + this.d + i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a == dVar.a() && this.b == dVar.b() && this.c == dVar.c() && this.d == dVar.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003;
        long j = this.d;
        return i ^ ((int) (j ^ (j >>> 32)));
    }
}
