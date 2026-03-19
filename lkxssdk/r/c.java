package lkxssdk.r;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public abstract class c {
    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final /* synthetic */ c[] i;

    public enum a extends c {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // lkxssdk.r.c
        public boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        a = aVar;
        c cVar = new c("DATA_MASK_001", 1) { // from class: lkxssdk.r.c.b
            {
                a aVar2 = null;
            }

            @Override // lkxssdk.r.c
            public boolean a(int i2, int i3) {
                return (i2 & 1) == 0;
            }
        };
        b = cVar;
        c cVar2 = new c("DATA_MASK_010", 2) { // from class: lkxssdk.r.c.c
            {
                a aVar2 = null;
            }

            @Override // lkxssdk.r.c
            public boolean a(int i2, int i3) {
                return i3 % 3 == 0;
            }
        };
        c = cVar2;
        c cVar3 = new c("DATA_MASK_011", 3) { // from class: lkxssdk.r.c.d
            {
                a aVar2 = null;
            }

            @Override // lkxssdk.r.c
            public boolean a(int i2, int i3) {
                return (i2 + i3) % 3 == 0;
            }
        };
        d = cVar3;
        c cVar4 = new c("DATA_MASK_100", 4) { // from class: lkxssdk.r.c.e
            {
                a aVar2 = null;
            }

            @Override // lkxssdk.r.c
            public boolean a(int i2, int i3) {
                return (((i2 / 2) + (i3 / 3)) & 1) == 0;
            }
        };
        e = cVar4;
        c cVar5 = new c("DATA_MASK_101", 5) { // from class: lkxssdk.r.c.f
            {
                a aVar2 = null;
            }

            @Override // lkxssdk.r.c
            public boolean a(int i2, int i3) {
                return (i2 * i3) % 6 == 0;
            }
        };
        f = cVar5;
        c cVar6 = new c("DATA_MASK_110", 6) { // from class: lkxssdk.r.c.g
            {
                a aVar2 = null;
            }

            @Override // lkxssdk.r.c
            public boolean a(int i2, int i3) {
                return (i2 * i3) % 6 < 3;
            }
        };
        g = cVar6;
        c cVar7 = new c("DATA_MASK_111", 7) { // from class: lkxssdk.r.c.h
            {
                a aVar2 = null;
            }

            @Override // lkxssdk.r.c
            public boolean a(int i2, int i3) {
                return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
            }
        };
        h = cVar7;
        i = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7};
    }

    public c(String str, int i2) {
    }

    public /* synthetic */ c(String str, int i2, a aVar) {
        this(str, i2);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) i.clone();
    }

    public final void a(lkxssdk.o.a aVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    aVar.a(i4, i3);
                }
            }
        }
    }

    public abstract boolean a(int i2, int i3);
}
