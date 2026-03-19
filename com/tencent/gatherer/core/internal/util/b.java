package com.tencent.gatherer.core.internal.util;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b {
    private final boolean a;
    private final boolean b;

    /* compiled from: A */
    /* renamed from: com.tencent.gatherer.core.internal.util.b$b, reason: collision with other inner class name */
    public static final class C0800b {
        private boolean a = true;
        private boolean b = true;

        public C0800b a(boolean z) {
            this.b = z;
            return this;
        }

        public C0800b b(boolean z) {
            this.a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.a;
    }

    private b(C0800b c0800b) {
        this.a = c0800b.a;
        this.b = c0800b.b;
    }
}
