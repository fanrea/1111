package com.qq.e.comm.plugin;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.qq.e.comm.plugin.x7;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class w20 extends x7.a {
    private final Property<w40, Float> b = new a(Float.class, "translationX");
    private final Property<w40, Float> c = new b(Float.class, "translationY");

    w20() {
    }

    /* compiled from: A */
    class a extends Property<w40, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            w40Var.b(f, (Float) null);
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            View viewA = w40Var.A();
            return Float.valueOf(viewA == null ? 0.0f : viewA.getTranslationX());
        }
    }

    /* compiled from: A */
    class b extends Property<w40, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            w40Var.b((Float) null, f);
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            View viewA = w40Var.A();
            return Float.valueOf(viewA == null ? 0.0f : viewA.getTranslationY());
        }
    }

    /* compiled from: A */
    private static final class c extends Property<w40, Float> {
        private final boolean a;
        private final boolean b;
        private int c;

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            return null;
        }

        c(boolean z, boolean z2) {
            super(Float.class, "translation");
            this.b = z;
            this.a = z2;
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            if (this.c <= 0) {
                View viewA = w40Var.A();
                if (viewA == null) {
                    return;
                }
                Object parent = viewA.getParent();
                if (!(parent instanceof View)) {
                    return;
                }
                View view = (View) parent;
                int width = this.a ? view.getWidth() : view.getHeight();
                this.c = width;
                if (width <= 0) {
                    return;
                }
            }
            Float fValueOf = Float.valueOf(f.floatValue() * this.c);
            if (this.b) {
                w40Var.b(fValueOf, (Float) null);
            } else {
                w40Var.b((Float) null, fValueOf);
            }
        }
    }

    private PropertyValuesHolder a(boolean z, JSONArray jSONArray) {
        boolean zBooleanValue;
        int i = z ? 0 : 2;
        if (jSONArray.length() <= i) {
            return null;
        }
        iz izVarC = t30.c(jSONArray.opt(i)).c(new JSONObject[0]);
        iz izVarC2 = t30.c(jSONArray.opt(i + 1)).c(new JSONObject[0]);
        Boolean boolValueOf = (izVarC.c() || izVarC.d()) ? Boolean.valueOf(izVarC.a()) : null;
        Boolean boolValueOf2 = (izVarC2.c() || izVarC2.d()) ? Boolean.valueOf(izVarC2.a()) : null;
        if (boolValueOf == null && boolValueOf2 == null) {
            return PropertyValuesHolder.ofFloat(z ? this.b : this.c, izVarC.e(), izVarC2.e());
        }
        if (boolValueOf == null) {
            if (izVarC.b() != 0.0f) {
                return null;
            }
            zBooleanValue = boolValueOf2.booleanValue();
        } else if (boolValueOf2 == null) {
            if (izVarC2.b() != 0.0f) {
                return null;
            }
            zBooleanValue = boolValueOf.booleanValue();
        } else {
            if (boolValueOf != boolValueOf2) {
                return null;
            }
            zBooleanValue = boolValueOf.booleanValue();
        }
        return PropertyValuesHolder.ofFloat(new c(z, zBooleanValue), izVarC.b() / 100.0f, izVarC2.b() / 100.0f);
    }

    @Override // com.qq.e.comm.plugin.x7.a
    PropertyValuesHolder[] a(s2 s2Var) {
        JSONArray jSONArray = s2Var.c;
        if (jSONArray.length() < 2) {
            return null;
        }
        PropertyValuesHolder propertyValuesHolderA = a(true, jSONArray);
        PropertyValuesHolder propertyValuesHolderA2 = a(false, jSONArray);
        if (propertyValuesHolderA == null && propertyValuesHolderA2 == null) {
            return null;
        }
        return (propertyValuesHolderA == null || propertyValuesHolderA2 == null) ? propertyValuesHolderA != null ? new PropertyValuesHolder[]{propertyValuesHolderA} : new PropertyValuesHolder[]{propertyValuesHolderA2} : new PropertyValuesHolder[]{propertyValuesHolderA, propertyValuesHolderA2};
    }
}
