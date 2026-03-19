package com.kwai.kanas.vader.f;

import com.kuaishou.socket.nano.SocketMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class c extends h {
    private final boolean a;
    private final long b;

    c(boolean z, long j) {
        this.a = z;
        this.b = j;
    }

    @Override // com.kwai.kanas.vader.f.h
    public final boolean a() {
        return this.a;
    }

    @Override // com.kwai.kanas.vader.f.h
    public final long b() {
        return this.b;
    }

    public final String toString() {
        return "UploadResult{success=" + this.a + ", nextRequestIntervalMs=" + this.b + com.alipay.sdk.m.u.i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.a == hVar.a() && this.b == hVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.a ? SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION : SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO;
        long j = this.b;
        return ((i ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }
}
