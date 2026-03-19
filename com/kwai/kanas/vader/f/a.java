package com.kwai.kanas.vader.f;

import com.kwai.kanas.vader.Channel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class a extends e {
    private final Channel a;
    private final int b;
    private final int c;

    a(Channel channel, int i, int i2) {
        if (channel == null) {
            throw new NullPointerException("Null channel");
        }
        this.a = channel;
        this.b = i;
        this.c = i2;
    }

    @Override // com.kwai.kanas.vader.f.e
    public final Channel a() {
        return this.a;
    }

    @Override // com.kwai.kanas.vader.f.e
    public final int b() {
        return this.b;
    }

    @Override // com.kwai.kanas.vader.f.e
    public final int c() {
        return this.c;
    }

    public final String toString() {
        return "ChannelLogRange{channel=" + this.a + ", lowerBound=" + this.b + ", upperBound=" + this.c + com.alipay.sdk.m.u.i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a.equals(eVar.a()) && this.b == eVar.b() && this.c == eVar.c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }
}
