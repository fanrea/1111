package com.kwai.kanas.vader.f;

import com.kuaishou.socket.nano.SocketMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class b extends g {
    private final boolean a;

    b(boolean z) {
        this.a = z;
    }

    @Override // com.kwai.kanas.vader.f.g
    public final boolean a() {
        return this.a;
    }

    public final String toString() {
        return "UploadInfo{degrade=" + this.a + com.alipay.sdk.m.u.i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof g) && this.a == ((g) obj).a();
    }

    public final int hashCode() {
        return (this.a ? SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION : SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO) ^ 1000003;
    }
}
