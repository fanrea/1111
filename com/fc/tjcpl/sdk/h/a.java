package com.fc.tjcpl.sdk.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a implements b {
    public String a;
    public int b;
    public String c;
    public int d;

    /* renamed from: com.fc.tjcpl.sdk.h.a$a, reason: collision with other inner class name */
    public static final class C0361a {
        public String a;
        public int b;
        public String c;
        public int d;
    }

    public a(C0361a c0361a) {
        this.b = c0361a.b;
        this.a = c0361a.a;
        this.c = c0361a.c;
        this.d = c0361a.d;
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public String a() {
        return "https://stat.91taojin.com.cn/app/startCpl";
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public boolean b() {
        return true;
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public void c() {
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public String d() {
        return "Token=" + this.c + "&PlatformType=" + this.d + "&IDTask=" + this.a + "&ActType=200" + this.b;
    }

    @Override // com.fc.tjcpl.sdk.h.b
    public boolean e() {
        return false;
    }
}
