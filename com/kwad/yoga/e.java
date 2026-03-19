package com.kwad.yoga;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e {
    static final e Gd = new e(Float.NaN, YogaUnit.UNDEFINED);
    static final e Ge = new e(0.0f, YogaUnit.POINT);
    static final e Gf = new e(Float.NaN, YogaUnit.AUTO);
    public final YogaUnit Gg;
    public final float value;

    public e(float f, YogaUnit yogaUnit) {
        this.value = f;
        this.Gg = yogaUnit;
    }

    e(float f, int i) {
        this(f, YogaUnit.fromInt(i));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            YogaUnit yogaUnit = this.Gg;
            if (yogaUnit == eVar.Gg) {
                return yogaUnit == YogaUnit.UNDEFINED || this.Gg == YogaUnit.AUTO || Float.compare(this.value, eVar.value) == 0;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.value) + this.Gg.intValue();
    }

    /* renamed from: com.kwad.yoga.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Gh = new int[YogaUnit.values().length];

        static {
            try {
                Gh[YogaUnit.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Gh[YogaUnit.POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Gh[YogaUnit.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Gh[YogaUnit.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public final String toString() {
        int i = AnonymousClass1.Gh[this.Gg.ordinal()];
        if (i == 1) {
            return "undefined";
        }
        if (i == 2) {
            return Float.toString(this.value);
        }
        if (i != 3) {
            if (i == 4) {
                return "auto";
            }
            throw new IllegalStateException();
        }
        return this.value + "%";
    }
}
