package com.tk.component.a;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.o;
import com.tk.core.o.r;
import com.tkruntime.v8.V8Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends TKBaseNativeModule {
    private volatile boolean NZ;
    private String OA;
    private int OB;
    private List<Number> OC;
    private float OD;
    private DashPathEffect OE;
    private Shader OF;
    private LinearGradient OG;
    private float OH;
    private float OI;
    private float OJ;
    private float OK;
    private List<Number> OL;
    private List<String> OM;
    private RadialGradient ON;
    private float OO;
    private float OP;
    private float OQ;
    private List<Number> OR;
    private List<String> OS;
    private float OT;
    private float OU;
    private float OV;
    private String OW;
    private String Om;
    private int On;
    private float Oo;
    private int Op;
    private int Oq;
    private int Or;
    private float Os;
    private float Ot;
    private String Ou;
    private boolean Ov;
    private boolean Ow;
    private boolean Ox;
    private float Oy;
    private float Oz;
    private float mAlpha;
    private final Paint mPaint;

    public e(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.mPaint = new Paint(1);
        this.On = 255;
        this.mAlpha = 1.0f;
        this.Oo = 1.0f;
        this.Op = 0;
        this.Oq = 0;
        this.Or = 0;
        this.Os = 4.0f;
        this.Ot = 12.0f;
        this.Oy = 0.0f;
        this.Oz = 0.0f;
        this.OB = -1;
        this.mPaint.setTextSize(o.eb(12));
        this.mPaint.setStrokeWidth(o.eb(1));
    }

    public final void aj(String str) {
        if (this.NZ || TextUtils.equals(this.Om, str)) {
            return;
        }
        this.Om = str;
        int color = r.parseColor(str);
        this.On = Color.alpha(color);
        this.mPaint.setColor(color);
        this.mPaint.setAlpha((int) (this.On * this.mAlpha));
    }

    private void mn() {
        this.Om = null;
        this.On = 255;
    }

    public final void setAlpha(float f) {
        if (this.NZ || this.mAlpha == f) {
            return;
        }
        this.mAlpha = f;
        this.mPaint.setAlpha((int) (this.On * this.mAlpha));
    }

    private void mo() {
        this.mAlpha = 1.0f;
    }

    public final void setStrokeWidth(float f) {
        if (this.NZ || this.Oo == f) {
            return;
        }
        this.Oo = f;
        this.mPaint.setStrokeWidth(o.P(f));
    }

    private void mp() {
        this.Oo = 1.0f;
    }

    public final void cA(int i) {
        if (this.NZ || this.Op == i) {
            return;
        }
        this.Op = i;
        this.mPaint.setStyle(com.tk.component.a.a.a.cF(i));
    }

    private void mq() {
        this.Op = 0;
    }

    public final void cB(int i) {
        if (this.NZ || this.Oq == i) {
            return;
        }
        this.Oq = i;
        this.mPaint.setStrokeCap(com.tk.component.a.a.a.cG(i));
    }

    private void mr() {
        this.Oq = 0;
    }

    public final void cC(int i) {
        if (this.NZ || this.Or == i) {
            return;
        }
        this.Or = i;
        this.mPaint.setStrokeJoin(com.tk.component.a.a.a.cH(i));
    }

    private void ms() {
        this.Or = 0;
    }

    public final void o(float f) {
        if (this.NZ || this.Os == f) {
            return;
        }
        this.Os = f;
        this.mPaint.setStrokeMiter(f);
    }

    private void mt() {
        this.Os = 4.0f;
    }

    public final void setTextSize(float f) {
        if (this.NZ || this.Ot == f) {
            return;
        }
        this.Ot = f;
        this.mPaint.setTextSize(o.P(f));
    }

    private void mu() {
        this.Ot = 12.0f;
    }

    public final void ak(String str) {
        if (this.NZ || TextUtils.equals(str, this.Ou)) {
            return;
        }
        this.Ou = str;
        this.mPaint.setTypeface(com.tk.core.component.b.a(getContext(), str, 0, pn(), pq(), getVersionCode()));
    }

    private void mv() {
        this.Ou = null;
    }

    public final void V(boolean z) {
        if (this.NZ || this.Ov == z) {
            return;
        }
        this.Ov = z;
        this.mPaint.setFakeBoldText(z);
    }

    private void mw() {
        this.Ov = false;
    }

    public final void setStrikeThruText(boolean z) {
        if (this.NZ || this.Ow == z) {
            return;
        }
        this.Ow = z;
        this.mPaint.setStrikeThruText(z);
    }

    private void mx() {
        this.Ow = false;
    }

    public final void setUnderlineText(boolean z) {
        if (this.NZ || this.Ox == z) {
            return;
        }
        this.Ox = z;
        this.mPaint.setUnderlineText(z);
    }

    private void my() {
        this.Ox = false;
    }

    public final void setTextSkewX(float f) {
        if (this.NZ || this.Oy == f) {
            return;
        }
        this.Oy = f;
        this.mPaint.setTextSkewX(f);
    }

    private void mz() {
        this.Oy = 0.0f;
    }

    public final void setLetterSpacing(float f) {
        if (this.NZ || this.Oz == f) {
            return;
        }
        this.Oz = f;
        if (Build.VERSION.SDK_INT >= 21) {
            this.mPaint.setLetterSpacing(f);
        }
    }

    private void mA() {
        this.Oz = 0.0f;
    }

    public final void al(String str) {
        if (this.NZ || TextUtils.equals(this.OA, str)) {
            return;
        }
        this.OA = str;
        this.mPaint.setTextAlign(com.tk.component.a.a.a.an(str));
    }

    private void mB() {
        this.OA = null;
    }

    public final void cD(int i) {
        if (this.NZ || this.OB == i) {
            return;
        }
        this.OB = i;
        PorterDuff.Mode modeCI = com.tk.component.a.a.a.cI(i);
        if (modeCI != null) {
            this.mPaint.setXfermode(new PorterDuffXfermode(modeCI));
        } else {
            this.mPaint.setXfermode(null);
        }
    }

    private void mC() {
        this.OB = -1;
    }

    public final void a(V8Array v8Array, float f) {
        if (this.NZ) {
            return;
        }
        DashPathEffect dashPathEffect = null;
        if (v8Array == null) {
            this.OC = null;
            this.OD = f;
        } else {
            List<Number> list = v8Array.getList();
            if (this.OD != f || !list.equals(this.OC)) {
                if (list.size() < 2) {
                    this.OC = list;
                } else {
                    float[] fArr = new float[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        fArr[i] = o.P(list.get(i).floatValue());
                    }
                    DashPathEffect dashPathEffect2 = new DashPathEffect(fArr, o.P(f));
                    this.OC = list;
                    dashPathEffect = dashPathEffect2;
                }
                this.OD = f;
            } else {
                dashPathEffect = this.OE;
            }
        }
        this.OE = dashPathEffect;
        if (dashPathEffect == this.mPaint.getPathEffect()) {
            return;
        }
        this.mPaint.setPathEffect(dashPathEffect);
    }

    public final void mD() {
        this.mPaint.setPathEffect(null);
        mE();
    }

    private void mE() {
        this.OE = null;
        this.OC = null;
        this.OD = 0.0f;
    }

    public final void a(float f, float f2, float f3, float f4, V8Array v8Array, V8Array v8Array2) {
        boolean zEquals;
        if (this.NZ) {
            return;
        }
        List<String> list = v8Array.getList();
        float[] fArr = null;
        List<Number> list2 = v8Array2 != null ? v8Array2.getList() : null;
        if (list2 == null) {
            zEquals = this.OL == null;
        } else {
            zEquals = list2.equals(this.OL);
        }
        if (this.OG == null || this.OH != f || this.OI != f2 || this.OJ != f3 || this.OK != f4 || !zEquals || !list.equals(this.OM)) {
            if (list2 != null) {
                fArr = new float[list2.size()];
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    fArr[i] = list2.get(i).floatValue();
                }
            }
            float[] fArr2 = fArr;
            int[] iArr = new int[list.size()];
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                iArr[i2] = r.parseColor(list.get(i2));
            }
            this.OG = new LinearGradient(o.P(f), o.P(f2), o.P(f3), o.P(f4), iArr, fArr2, Shader.TileMode.CLAMP);
            this.OH = f;
            this.OI = f2;
            this.OJ = f3;
            this.OK = f4;
            this.OL = list2;
            this.OM = list;
        }
        a(this.OG);
    }

    public final void a(float f, float f2, float f3, V8Array v8Array, V8Array v8Array2) {
        boolean zEquals;
        if (this.NZ) {
            return;
        }
        List<String> list = v8Array.getList();
        float[] fArr = null;
        List<Number> list2 = v8Array2 != null ? v8Array2.getList() : null;
        if (list2 == null) {
            zEquals = this.OR == null;
        } else {
            zEquals = list2.equals(this.OR);
        }
        if (this.ON == null || this.OO != f || this.OP != f2 || this.OQ != f3 || !zEquals || !list.equals(this.OS)) {
            if (list2 != null) {
                fArr = new float[list2.size()];
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    fArr[i] = list2.get(i).floatValue();
                }
            }
            float[] fArr2 = fArr;
            int[] iArr = new int[list.size()];
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                iArr[i2] = r.parseColor(list.get(i2));
            }
            this.ON = new RadialGradient(o.P(f), o.P(f2), o.P(f3), iArr, fArr2, Shader.TileMode.CLAMP);
            this.OO = f;
            this.OP = f2;
            this.OQ = f3;
            this.OR = list2;
            this.OS = list;
        }
        a(this.ON);
    }

    public final void mF() {
        a(null);
    }

    private void a(Shader shader) {
        if (this.NZ || shader == this.OF) {
            return;
        }
        this.OF = shader;
        this.mPaint.setShader(shader);
    }

    private void mG() {
        this.OF = null;
    }

    public final void a(float f, float f2, float f3, String str) {
        if (this.NZ) {
            return;
        }
        if (this.OT == f && this.OU == f2 && this.OV == f3 && TextUtils.equals(this.OW, str)) {
            return;
        }
        this.OT = f;
        this.OU = f2;
        this.OV = f3;
        this.OW = str;
        this.mPaint.setShadowLayer(o.P(f), o.P(f2), o.P(f3), r.parseColor(str));
    }

    public final void clearShadowLayer() {
        a(0.0f, 0.0f, 0.0f, null);
    }

    private void mH() {
        this.OT = 0.0f;
        this.OU = 0.0f;
        this.OV = 0.0f;
        this.OW = null;
    }

    public final Map am(String str) {
        float fAbs;
        if (this.NZ) {
            return null;
        }
        HashMap map = new HashMap();
        float fMeasureText = this.mPaint.measureText(str);
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        float fAbs2 = 0.0f;
        if (fontMetrics != null) {
            fAbs2 = Math.abs(fontMetrics.leading) + Math.abs(fontMetrics.ascent);
            fAbs = Math.abs(fontMetrics.descent) + fAbs2;
        } else {
            fAbs = 0.0f;
        }
        map.put("height", Float.valueOf(o.R(fAbs)));
        map.put("width", Float.valueOf(o.R(fMeasureText)));
        map.put("baseLineY", Float.valueOf(o.R(fAbs2)));
        return map;
    }

    public final void reset() {
        if (this.NZ) {
            return;
        }
        this.mPaint.reset();
        this.mPaint.setFlags(1);
        this.mPaint.setTextSize(o.eb(12));
        this.mPaint.setStrokeWidth(o.eb(1));
        mn();
        mo();
        mr();
        ms();
        mq();
        mp();
        mt();
        mw();
        mv();
        mA();
        mx();
        my();
        mu();
        mz();
        mB();
        mC();
        mG();
        mE();
        mH();
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        this.NZ = true;
    }
}
