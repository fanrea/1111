package com.qq.e.comm.plugin;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b2 {
    public static final b2 d;
    public static final b2 e;
    private static final /* synthetic */ b2[] f;
    private e2 a;
    private int b;
    private int c;

    static {
        e2 e2Var = e2.SPLASH;
        d = new b2("SPLASH_320", 0, e2Var, 320, 480);
        e = new b2("SPLASH_640", 1, e2Var, 640, 960);
        f = a();
    }

    private static /* synthetic */ b2[] a() {
        return new b2[]{d, e};
    }

    private b2(String str, int i, e2 e2Var, int i2, int i3) {
        this.a = e2Var;
        this.b = i2;
        this.c = i3;
    }

    public int c() {
        return this.b;
    }

    public int b() {
        return this.c;
    }
}
