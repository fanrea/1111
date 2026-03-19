package com.qq.e.comm.plugin;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.qq.e.comm.plugin.x7;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class pi extends x7.a {
    private final Property<w40, Float> b = new a(Float.class, "height");

    pi() {
    }

    /* compiled from: A */
    class a extends Property<w40, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            if (f != null) {
                w40Var.i(f.intValue());
            }
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            return Float.valueOf(w40Var.A() == null ? 0.0f : r1.getHeight());
        }
    }

    /* compiled from: A */
    private static final class b extends Property<w40, Float> {
        private final boolean a;
        private int b;

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            return null;
        }

        b(boolean z) {
            super(Float.class, "heightP");
            this.a = z;
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            if (this.b <= 0) {
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
                this.b = width;
                if (width <= 0) {
                    return;
                }
            }
            w40Var.i(Float.valueOf(f.floatValue() * this.b).intValue());
        }
    }

    private PropertyValuesHolder a(JSONArray jSONArray) {
        boolean zBooleanValue;
        iz izVarC = t30.c(jSONArray.opt(0)).c(new JSONObject[0]);
        iz izVarC2 = t30.c(jSONArray.opt(1)).c(new JSONObject[0]);
        Boolean boolValueOf = izVarC.c() ? Boolean.valueOf(izVarC.a()) : null;
        Boolean boolValueOf2 = izVarC2.c() ? Boolean.valueOf(izVarC2.a()) : null;
        if (boolValueOf == null && boolValueOf2 == null) {
            return PropertyValuesHolder.ofFloat(this.b, izVarC.e(), izVarC2.e());
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
        return PropertyValuesHolder.ofFloat(new b(zBooleanValue), izVarC.b() / 100.0f, izVarC2.b() / 100.0f);
    }

    @Override // com.qq.e.comm.plugin.x7.a
    PropertyValuesHolder[] a(s2 s2Var) {
        PropertyValuesHolder propertyValuesHolderA;
        JSONArray jSONArray = s2Var.c;
        if (jSONArray.length() == 2 && (propertyValuesHolderA = a(jSONArray)) != null) {
            return new PropertyValuesHolder[]{propertyValuesHolderA};
        }
        return null;
    }
}
