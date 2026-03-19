package com.qq.e.comm.plugin;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.qq.e.comm.plugin.x7;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ex extends x7.a {
    static final Property<w40, Float> c = new a(Float.class, "rotation");
    static final Property<w40, Float> d = new b(Float.class, "rotationX");
    static final Property<w40, Float> e = new c(Float.class, "rotationY");
    private final Property<w40, Float> b;

    /* compiled from: A */
    class a extends Property<w40, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            w40Var.b(f.floatValue());
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            View viewA = w40Var.A();
            return Float.valueOf(viewA == null ? 0.0f : viewA.getRotation());
        }
    }

    /* compiled from: A */
    class b extends Property<w40, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            View viewA = w40Var.A();
            return Float.valueOf(viewA == null ? 0.0f : viewA.getRotationX());
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            w40Var.c(f.floatValue());
        }
    }

    /* compiled from: A */
    class c extends Property<w40, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            View viewA = w40Var.A();
            return Float.valueOf(viewA == null ? 0.0f : viewA.getRotationY());
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            w40Var.d(f.floatValue());
        }
    }

    ex(Property<w40, Float> property) {
        this.b = property;
    }

    @Override // com.qq.e.comm.plugin.x7.a
    PropertyValuesHolder[] a(s2 s2Var) {
        if (s2Var.c.length() < 2) {
            return null;
        }
        return new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(this.b, s2Var.c.optInt(0), s2Var.c.optInt(1))};
    }
}
