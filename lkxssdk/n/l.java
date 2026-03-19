package lkxssdk.n;

import io.netty.util.internal.StringUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class l {
    public final float a;
    public final float b;

    public l(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public static float a(l lVar, l lVar2) {
        float f = lVar.a;
        float f2 = lVar.b;
        double d = f - lVar2.a;
        double d2 = f2 - lVar2.b;
        return (float) Math.sqrt((d * d) + (d2 * d2));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.a == lVar.a && this.b == lVar.b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.a + StringUtil.COMMA + this.b + ')';
    }
}
