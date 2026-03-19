package com.kwai.kanas.vader.e;

import com.alipay.sdk.m.u.i;
import com.kwai.kanas.vader.Channel;
import com.kwai.kanas.vader.e.g;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class c extends g {
    private final h<Integer> a;
    private final h<Integer> b;
    private final Map<Channel, h<Integer>> c;
    private final Map<Channel, h<Integer>> d;
    private final Map<String, h<Integer>> e;
    private final Map<String, h<Integer>> f;
    private final int g;
    private final int h;
    private final int i;

    private c(h<Integer> hVar, h<Integer> hVar2, Map<Channel, h<Integer>> map, Map<Channel, h<Integer>> map2, Map<String, h<Integer>> map3, Map<String, h<Integer>> map4, int i, int i2, int i3) {
        this.a = hVar;
        this.b = hVar2;
        this.c = map;
        this.d = map2;
        this.e = map3;
        this.f = map4;
        this.g = i;
        this.h = i2;
        this.i = i3;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final h<Integer> a() {
        return this.a;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final h<Integer> b() {
        return this.b;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final Map<Channel, h<Integer>> c() {
        return this.c;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final Map<Channel, h<Integer>> d() {
        return this.d;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final Map<String, h<Integer>> e() {
        return this.e;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final Map<String, h<Integer>> f() {
        return this.f;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final int g() {
        return this.g;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final int h() {
        return this.h;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final int i() {
        return this.i;
    }

    public final String toString() {
        return "SequenceIdStat{seqId=" + this.a + ", seqDbId=" + this.b + ", channelId=" + this.c + ", channelDbId=" + this.d + ", customId=" + this.e + ", customDbId=" + this.f + ", generatedIdCount=" + this.g + ", commitCount=" + this.h + ", failedCommitCount=" + this.i + i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.a.equals(gVar.a()) && this.b.equals(gVar.b()) && this.c.equals(gVar.c()) && this.d.equals(gVar.d()) && this.e.equals(gVar.e()) && this.f.equals(gVar.f()) && this.g == gVar.g() && this.h == gVar.h() && this.i == gVar.i()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g) * 1000003) ^ this.h) * 1000003) ^ this.i;
    }

    @Override // com.kwai.kanas.vader.e.g
    public final g.a j() {
        return new a(this);
    }

    static final class a extends g.a {
        private h<Integer> a;
        private h<Integer> b;
        private Map<Channel, h<Integer>> c;
        private Map<Channel, h<Integer>> d;
        private Map<String, h<Integer>> e;
        private Map<String, h<Integer>> f;
        private Integer g;
        private Integer h;
        private Integer i;

        a() {
        }

        private a(g gVar) {
            this.a = gVar.a();
            this.b = gVar.b();
            this.c = gVar.c();
            this.d = gVar.d();
            this.e = gVar.e();
            this.f = gVar.f();
            this.g = Integer.valueOf(gVar.g());
            this.h = Integer.valueOf(gVar.h());
            this.i = Integer.valueOf(gVar.i());
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g.a a(h<Integer> hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null seqId");
            }
            this.a = hVar;
            return this;
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g.a b(h<Integer> hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null seqDbId");
            }
            this.b = hVar;
            return this;
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g.a a(Map<Channel, h<Integer>> map) {
            if (map == null) {
                throw new NullPointerException("Null channelId");
            }
            this.c = map;
            return this;
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g.a b(Map<Channel, h<Integer>> map) {
            if (map == null) {
                throw new NullPointerException("Null channelDbId");
            }
            this.d = map;
            return this;
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g.a c(Map<String, h<Integer>> map) {
            if (map == null) {
                throw new NullPointerException("Null customId");
            }
            this.e = map;
            return this;
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g.a d(Map<String, h<Integer>> map) {
            if (map == null) {
                throw new NullPointerException("Null customDbId");
            }
            this.f = map;
            return this;
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g.a a(int i) {
            this.g = Integer.valueOf(i);
            return this;
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g.a b(int i) {
            this.h = Integer.valueOf(i);
            return this;
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g.a c(int i) {
            this.i = Integer.valueOf(i);
            return this;
        }

        @Override // com.kwai.kanas.vader.e.g.a
        public final g a() {
            String str = "";
            if (this.a == null) {
                str = " seqId";
            }
            if (this.b == null) {
                str = str + " seqDbId";
            }
            if (this.c == null) {
                str = str + " channelId";
            }
            if (this.d == null) {
                str = str + " channelDbId";
            }
            if (this.e == null) {
                str = str + " customId";
            }
            if (this.f == null) {
                str = str + " customDbId";
            }
            if (this.g == null) {
                str = str + " generatedIdCount";
            }
            if (this.h == null) {
                str = str + " commitCount";
            }
            if (this.i == null) {
                str = str + " failedCommitCount";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g.intValue(), this.h.intValue(), this.i.intValue());
        }
    }
}
