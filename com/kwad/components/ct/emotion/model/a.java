package com.kwad.components.ct.emotion.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private String aCk;

    /* synthetic */ a(byte b) {
        this();
    }

    /* synthetic */ a(String str, byte b) {
        this(str);
    }

    private a(String str) {
        this.aCk = str;
    }

    private a() {
    }

    /* renamed from: com.kwad.components.ct.emotion.model.a$a, reason: collision with other inner class name */
    public static class C0512a {
        private final a aCl;

        /* synthetic */ C0512a(byte b) {
            this();
        }

        private C0512a() {
            this.aCl = new a((byte) 0);
        }

        public final C0512a bH(String str) {
            this.aCl.aCk = str;
            return this;
        }

        public final a DM() {
            return new a(this.aCl.aCk, (byte) 0);
        }
    }

    public static C0512a DK() {
        return new C0512a((byte) 0);
    }

    public final String DL() {
        return this.aCk;
    }
}
