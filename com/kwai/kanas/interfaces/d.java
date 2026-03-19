package com.kwai.kanas.interfaces;

import com.kuaishou.socket.nano.SocketMessages;
import com.kwai.kanas.interfaces.KanasConfig;
import com.kwai.kanas.location.Location;
import com.kwai.middleware.azeroth.function.Supplier;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class d extends KanasConfig {
    private final int a;
    private final String b;
    private final Supplier<String> c;
    private final Supplier<Location> d;
    private final KanasLogger e;
    private final List<String> f;
    private final long g;
    private final boolean h;

    private d(int i, String str, Supplier<String> supplier, Supplier<Location> supplier2, KanasLogger kanasLogger, List<String> list, long j, boolean z) {
        this.a = i;
        this.b = str;
        this.c = supplier;
        this.d = supplier2;
        this.e = kanasLogger;
        this.f = list;
        this.g = j;
        this.h = z;
    }

    @Override // com.kwai.kanas.interfaces.KanasConfig
    public final int platform() {
        return this.a;
    }

    @Override // com.kwai.kanas.interfaces.KanasConfig
    public final String deviceId() {
        return this.b;
    }

    @Override // com.kwai.kanas.interfaces.KanasConfig
    public final Supplier<String> oaid() {
        return this.c;
    }

    @Override // com.kwai.kanas.interfaces.KanasConfig
    public final Supplier<Location> location() {
        return this.d;
    }

    @Override // com.kwai.kanas.interfaces.KanasConfig
    public final KanasLogger logger() {
        return this.e;
    }

    @Override // com.kwai.kanas.interfaces.KanasConfig
    public final List<String> hosts() {
        return this.f;
    }

    @Override // com.kwai.kanas.interfaces.KanasConfig
    public final long newSessionBkgIntervalMs() {
        return this.g;
    }

    @Override // com.kwai.kanas.interfaces.KanasConfig
    public final boolean useRealMetrics() {
        return this.h;
    }

    public final String toString() {
        return "KanasConfig{platform=" + this.a + ", deviceId=" + this.b + ", oaid=" + this.c + ", location=" + this.d + ", logger=" + this.e + ", hosts=" + this.f + ", newSessionBkgIntervalMs=" + this.g + ", useRealMetrics=" + this.h + ", }";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof KanasConfig) {
            KanasConfig kanasConfig = (KanasConfig) obj;
            if (this.a == kanasConfig.platform() && this.b.equals(kanasConfig.deviceId()) && this.c.equals(kanasConfig.oaid()) && this.d.equals(kanasConfig.location()) && this.e.equals(kanasConfig.logger()) && this.f.equals(kanasConfig.hosts()) && this.g == kanasConfig.newSessionBkgIntervalMs() && this.h == kanasConfig.useRealMetrics()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003;
        long j = this.g;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ (this.h ? SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION : SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO);
    }

    @Override // com.kwai.kanas.interfaces.KanasConfig
    public final KanasConfig.Builder toBuilder() {
        return new a(this);
    }

    static final class a extends KanasConfig.Builder {
        private Integer a;
        private String b;
        private Supplier<String> c;
        private Supplier<Location> d;
        private KanasLogger e;
        private List<String> f;
        private Long g;
        private Boolean h;

        a() {
        }

        private a(KanasConfig kanasConfig) {
            this.a = Integer.valueOf(kanasConfig.platform());
            this.b = kanasConfig.deviceId();
            this.c = kanasConfig.oaid();
            this.e = kanasConfig.logger();
            this.f = kanasConfig.hosts();
            this.g = Long.valueOf(kanasConfig.newSessionBkgIntervalMs());
            this.h = Boolean.valueOf(kanasConfig.useRealMetrics());
        }

        @Override // com.kwai.kanas.interfaces.KanasConfig.Builder
        public final KanasConfig.Builder platform(int i) {
            this.a = Integer.valueOf(i);
            return this;
        }

        @Override // com.kwai.kanas.interfaces.KanasConfig.Builder
        public final KanasConfig.Builder deviceId(String str) {
            if (str == null) {
                throw new NullPointerException("Null deviceId");
            }
            this.b = str;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.KanasConfig.Builder
        public final KanasConfig.Builder oaid(Supplier<String> supplier) {
            if (supplier == null) {
                throw new NullPointerException("Null oaid");
            }
            this.c = supplier;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.KanasConfig.Builder
        public final KanasConfig.Builder location(Supplier<Location> supplier) {
            this.d = supplier;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.KanasConfig.Builder
        public final KanasConfig.Builder logger(KanasLogger kanasLogger) {
            if (kanasLogger == null) {
                throw new NullPointerException("Null logger");
            }
            this.e = kanasLogger;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.KanasConfig.Builder
        public final KanasConfig.Builder hosts(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null hosts");
            }
            this.f = list;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.KanasConfig.Builder
        public final KanasConfig.Builder newSessionBkgIntervalMs(long j) {
            this.g = Long.valueOf(j);
            return this;
        }

        @Override // com.kwai.kanas.interfaces.KanasConfig.Builder
        public final KanasConfig.Builder useRealMetrics(boolean z) {
            this.h = Boolean.valueOf(z);
            return this;
        }

        @Override // com.kwai.kanas.interfaces.KanasConfig.Builder
        final KanasConfig a() {
            String str = "";
            if (this.a == null) {
                str = " platform";
            }
            if (this.b == null) {
                str = str + " deviceId";
            }
            if (this.c == null) {
                str = str + " oaid";
            }
            if (this.e == null) {
                str = str + " logger";
            }
            if (this.f == null) {
                str = str + " hosts";
            }
            if (this.g == null) {
                str = str + " newSessionBkgIntervalMs";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new d(this.a.intValue(), this.b, this.c, this.d, this.e, this.f, this.g.longValue(), this.h.booleanValue());
        }
    }
}
