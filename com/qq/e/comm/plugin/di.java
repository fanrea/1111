package com.qq.e.comm.plugin;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import com.qq.e.comm.plugin.v30;
import com.qq.e.comm.plugin.x7;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class di extends x7.a {
    di() {
    }

    @Override // com.qq.e.comm.plugin.x7.a
    PropertyValuesHolder[] a(s2 s2Var) {
        Object objOpt;
        if (s2Var == null) {
            return null;
        }
        a aVar = new a(Float.class, "backgroundGradient");
        aVar.a = s2Var;
        JSONArray jSONArray = s2Var.c;
        if (jSONArray == null || jSONArray.length() != 2 || (objOpt = jSONArray.opt(1)) == null) {
            return null;
        }
        aVar.b = Integer.parseInt(objOpt.toString()) == 0;
        return new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(aVar, 0.0f, 1.0f)};
    }

    /* compiled from: A */
    static class a extends Property<w40, Float> {
        private s2 a;
        private boolean b;

        public a(Class<Float> cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            JSONArray jSONArrayB;
            if (this.a == null || w40Var == null) {
                return;
            }
            if (x9.c()) {
                jSONArrayB = this.a.a();
            } else {
                jSONArrayB = w40Var.b(this.a);
            }
            if (jSONArrayB == null || jSONArrayB.length() <= 0) {
                return;
            }
            v30.a(t30.c(jSONArrayB.opt(0)), w40Var.c().f(), new C0707a(f, w40Var));
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.di$a$a, reason: collision with other inner class name */
        class C0707a implements v30.d {
            final /* synthetic */ Float a;
            final /* synthetic */ w40 b;

            C0707a(Float f, w40 w40Var) {
                this.a = f;
                this.b = w40Var;
            }

            @Override // com.qq.e.comm.plugin.v30.d
            public void a(Object[] objArr) {
                int[] iArr = (int[]) objArr[0];
                float[] fArr = (float[]) objArr[2];
                if (fArr == null) {
                    fArr = new float[]{0.0f, 1.0f};
                }
                int[] iArr2 = new int[4];
                float[] fArr2 = new float[4];
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = f2 - f;
                if (a.this.b) {
                    iArr2[0] = iArr[0];
                    iArr2[1] = iArr[0];
                    int i = iArr[1];
                    iArr2[2] = i;
                    iArr2[3] = i;
                    fArr2[0] = f;
                    if (this.a.floatValue() <= 0.5d) {
                        fArr2[1] = f;
                        fArr2[2] = (this.a.floatValue() * 2.0f * f3) + f;
                    } else {
                        fArr2[1] = ((this.a.floatValue() - 0.5f) * 2.0f * f3) + f;
                        fArr2[2] = f2;
                    }
                    fArr2[3] = f2;
                } else {
                    iArr2[0] = iArr[0];
                    iArr2[1] = iArr[0];
                    int i2 = iArr[1];
                    iArr2[2] = i2;
                    iArr2[3] = i2;
                    fArr2[0] = f;
                    if (this.a.floatValue() <= 0.5f) {
                        fArr2[1] = f2 - ((this.a.floatValue() * 2.0f) * f3);
                        fArr2[2] = f2;
                    } else {
                        fArr2[1] = f;
                        fArr2[2] = f2 - (((this.a.floatValue() - 0.5f) * 2.0f) * f3);
                    }
                    fArr2[3] = f2;
                }
                objArr[0] = iArr2;
                objArr[2] = fArr2;
                this.b.a(objArr);
            }
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            return Float.valueOf(0.0f);
        }
    }
}
