package com.tk.core.component.text;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.GravityCompat;
import com.kuaishou.tk.api.export.sdk.V8Proxy;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.b;
import com.tk.core.component.text.e;
import com.tk.core.o.ac;
import com.tkruntime.v8.JavaVoidCallback;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class q extends com.tk.core.component.e<android.support.v7.widget.q> {
    public String KE;
    private String Om;
    public final int TYPE_TEXT;
    private String acC;
    private String acD;
    private String acE;
    private e.a acF;
    private String acG;
    private int acH;
    private int acI;
    public Map<String, String> acL;
    public final int afV;
    private final int afW;
    private int afX;
    private int afY;
    private float afZ;
    private float aga;
    private float agb;
    private float agc;
    private String agd;
    private boolean age;
    private boolean agf;
    protected boolean agg;
    public boolean agh;
    private V8Object agi;
    private int agj;
    private int agk;
    private List<JsValueRef> agl;
    private String agm;
    private String agn;
    private boolean ago;
    private boolean agp;
    public boolean agq;
    public Object agr;
    private SpannableString ags;

    @Deprecated
    public String agt;
    public boolean agu;
    private V8Function agv;

    @Override // com.tk.core.component.e
    public final /* synthetic */ View n(Context context) {
        return O(context);
    }

    static /* synthetic */ e.a a(q qVar, e.a aVar) {
        qVar.acF = null;
        return null;
    }

    public final void ax(boolean z) {
        this.agh = z;
        int i = this.afY;
        float f = i == 0 ? 14.0f : i;
        if (z) {
            getView().setTextSize(2, f);
        } else {
            getView().setTextSize(1, f);
        }
    }

    public q(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.TYPE_TEXT = 0;
        this.afV = 1;
        this.afW = 2;
        this.afX = 0;
        this.afZ = -1.0f;
        this.age = false;
        this.agf = false;
        this.agg = false;
        this.agj = 0;
        this.agk = 0;
        this.ago = false;
        this.agp = false;
        this.agq = false;
    }

    public q(NativeModuleInitParams nativeModuleInitParams, boolean z) {
        super(nativeModuleInitParams, true);
        this.TYPE_TEXT = 0;
        this.afV = 1;
        this.afW = 2;
        this.afX = 0;
        this.afZ = -1.0f;
        this.age = false;
        this.agf = false;
        this.agg = false;
        this.agj = 0;
        this.agk = 0;
        this.ago = false;
        this.agp = false;
        this.agq = false;
    }

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return com.tk.core.component.e.qv() || Build.VERSION.SDK_INT > 25;
    }

    @Override // com.tk.core.component.e
    public final boolean qr() {
        return !com.tk.core.component.e.qv();
    }

    private static android.support.v7.widget.q O(Context context) {
        android.support.v7.widget.q qVar = new android.support.v7.widget.q(context);
        if (Build.VERSION.SDK_INT >= 28) {
            qVar.setFallbackLineSpacing(false);
        }
        return qVar;
    }

    @Override // com.tk.core.component.e
    public final void a(HashMap map) {
        f(map);
        super.a(map);
    }

    public final void setText(String str) {
        if (str == null || !str.equals(this.KE) || this.age) {
            this.afX = 0;
            this.KE = str;
            this.agr = null;
            this.ago = false;
            this.agp = false;
            this.agq = false;
            if (pR().getYogaNode() == null) {
                return;
            }
            pR().getYogaNode().dirty();
            if (this.aga != 0.0f) {
                getView().setText(a(str, (SpannableString) null));
            } else {
                getView().setText(str);
            }
        }
    }

    @Deprecated
    public final void e(String str, V8Object v8Object) {
        o oVar = (o) getNativeModule(v8Object);
        if (oVar == null) {
            return;
        }
        this.afX = 1;
        this.KE = str;
        if (this.agi == v8Object) {
            oVar.rp();
        }
        this.agi = v8Object;
        pR().getYogaNode().dirty();
        getView().setText(a(str, (SpannableString) oVar.a(str, getView())));
    }

    public final void H(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof String) {
            setText((String) obj);
            return;
        }
        this.KE = null;
        this.afX = 2;
        this.agr = obj;
        com.tk.core.component.text.a.f.a(this, obj, new com.tk.core.component.text.a.e() { // from class: com.tk.core.component.text.q.1
            @Override // com.tk.core.component.text.a.e
            public final void c(SpannableString spannableString) {
                q.this.ags = spannableString;
                q.this.a(spannableString);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableString spannableString) {
        if (!TextUtils.isEmpty(this.KE)) {
            a(this.KE, (SpannableString) null);
            return;
        }
        pR().getYogaNode().dirty();
        if (this.aga != 0.0f) {
            b(spannableString);
        }
        getView().setText(spannableString);
    }

    public final void a(String str, V8Array v8Array) {
        int length;
        List<i> listZ;
        if (TextUtils.isEmpty(str)) {
            setText("");
            return;
        }
        if (v8Array != null && (length = v8Array.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                Object obj = v8Array.get(i);
                if ((obj instanceof V8Object) && (listZ = i.z((V8Object) obj)) != null) {
                    arrayList.addAll(listZ);
                }
            }
            if (arrayList.size() <= 0) {
                return;
            }
            k kVar = new k(getContext(), pn(), pq(), getVersionCode());
            kVar.n(arrayList);
            this.KE = str;
            pR().getYogaNode().dirty();
            getView().setText(a(str, (SpannableString) kVar.a(str, getView(), pO())));
        }
    }

    private SpannableString a(String str, SpannableString spannableString) {
        if (this.aga != 0.0f && !TextUtils.isEmpty(str)) {
            if (spannableString == null) {
                spannableString = new SpannableString(str);
            }
            spannableString.setSpan(new b(this.aga), 0, str.length(), 17);
        }
        return spannableString;
    }

    private SpannableString b(SpannableString spannableString) {
        float f = this.aga;
        if (f != 0.0f && spannableString != null) {
            spannableString.setSpan(new b(f), 0, spannableString.length(), 17);
        }
        return spannableString;
    }

    public final Map a(CharSequence charSequence, float f, int i) {
        int i2;
        StaticLayout staticLayout;
        int lineEnd;
        float f2;
        int i3 = i;
        int i4 = 0;
        if (TextUtils.isEmpty(charSequence) || f <= 0.0f) {
            HashMap map = new HashMap();
            map.put("height", 0);
            map.put("width", 0);
            map.put("startIndex", 0);
            map.put("endIndex", 0);
            map.put("lineCount", 0);
            return map;
        }
        android.support.v7.widget.q view = getView();
        int iP = com.tk.core.o.o.P(f);
        if (Build.VERSION.SDK_INT >= 23) {
            StaticLayout.Builder maxLines = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), view.getPaint(), iP).setAlignment(rq()).setTextDirection(TextDirectionHeuristics.LTR).setLineSpacing(view.getLineSpacingExtra(), view.getLineSpacingMultiplier()).setIncludePad(view.getIncludeFontPadding()).setBreakStrategy(view.getBreakStrategy()).setHyphenationFrequency(view.getHyphenationFrequency()).setMaxLines(i3 > 0 ? i3 : Integer.MAX_VALUE);
            if (Build.VERSION.SDK_INT >= 26) {
                maxLines = maxLines.setJustificationMode(view.getJustificationMode());
            }
            staticLayout = maxLines.build();
            i2 = iP;
        } else {
            i2 = iP;
            staticLayout = new StaticLayout(charSequence, view.getPaint(), iP, rq(), view.getLineSpacingMultiplier(), view.getLineSpacingExtra(), view.getIncludeFontPadding());
        }
        int lineCount = staticLayout.getLineCount();
        if (i3 <= 0 || i3 > lineCount) {
            i3 = lineCount;
        }
        float fMax = 0.0f;
        for (int i5 = 0; i5 < i3; i5++) {
            fMax = Math.max(fMax, staticLayout.getLineWidth(i5));
        }
        if (i3 > 0) {
            int i6 = i3 - 1;
            float lineBottom = staticLayout.getLineBottom(i6);
            int lineStart = staticLayout.getLineStart(i6);
            lineEnd = staticLayout.getLineEnd(i6);
            f2 = lineBottom;
            i4 = lineStart;
        } else {
            lineEnd = 0;
            f2 = 0.0f;
        }
        float fMin = Math.min(i2, fMax);
        HashMap map2 = new HashMap();
        map2.put("height", Float.valueOf(com.tk.core.o.o.R(f2)));
        map2.put("width", Float.valueOf(com.tk.core.o.o.R(fMin)));
        map2.put("startIndex", Integer.valueOf(i4));
        map2.put("endIndex", Integer.valueOf(lineEnd));
        map2.put("lineCount", Integer.valueOf(i3));
        return map2;
    }

    public final Map b(float f, int i) {
        return a(this.agg ? getView().getEditableText() : getView().getText(), f, i);
    }

    public final void cr(String str) {
        this.agt = str;
        getView().setText(fromHtml(this.agt));
    }

    private static Spanned fromHtml(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }

    public final void aj(String str) {
        this.agf = false;
        this.Om = str;
        int iA = com.tk.core.o.r.a(str, pP());
        if (!TextUtils.isEmpty(this.agd)) {
            this.agd = null;
            getView().getPaint().setShader(null);
        }
        getView().setTextColor(iA);
    }

    public final void al(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -1364013995) {
            if (iHashCode != 3317767) {
                if (iHashCode == 108511772 && str.equals(com.baidu.mobads.container.util.animation.j.e)) {
                    c = 2;
                }
            } else if (str.equals(com.baidu.mobads.container.util.animation.j.d)) {
                c = 1;
            }
        } else if (str.equals("center")) {
            c = 0;
        }
        if (c == 0) {
            getView().setGravity(17);
            this.agj = 17;
        } else if (c == 1) {
            getView().setGravity(3);
            this.agj = 8388627;
        } else if (c == 2) {
            getView().setGravity(5);
            this.agj = 8388629;
        }
        if (this.agk != 0) {
            getView().setGravity(this.agj | this.agk);
        }
    }

    public final void cs(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        char c = 65535;
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -1383228885) {
            if (iHashCode != -1364013995) {
                if (iHashCode == 115029 && lowerCase.equals(com.baidu.mobads.container.util.animation.j.f)) {
                    c = 2;
                }
            } else if (lowerCase.equals("center")) {
                c = 0;
            }
        } else if (lowerCase.equals(com.baidu.mobads.container.util.animation.j.g)) {
            c = 3;
        }
        if (c == 2) {
            getView().setGravity(48);
            this.agk = 48;
        } else if (c != 3) {
            getView().setGravity(16);
            this.agk = 16;
        } else {
            getView().setGravity(80);
            this.agk = 80;
        }
        if (this.agj != 0) {
            getView().setGravity(this.agj | this.agk);
        }
    }

    private Layout.Alignment rq() {
        int gravity = getView().getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (gravity == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (gravity == 3) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Layout.Alignment.ALIGN_LEFT;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (gravity == 5) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Layout.Alignment.ALIGN_RIGHT;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (gravity == 8388611) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (gravity == 8388613) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public final void setIncludeFontPadding(boolean z) {
        getView().setIncludeFontPadding(z);
    }

    public final void ct(String str) {
        if (this.ago) {
            return;
        }
        this.agn = str;
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -1171789332) {
            if (iHashCode != -1026963764) {
                if (iHashCode == 3387192 && str.equals("none")) {
                    c = 0;
                }
            } else if (str.equals("underline")) {
                c = 1;
            }
        } else if (str.equals("line-through")) {
            c = 2;
        }
        if (c == 0) {
            getView().getPaint().setFlags(getView().getPaintFlags() & (-9) & (-17));
        } else if (c == 1) {
            getView().getPaint().setFlags(9);
        } else if (c == 2) {
            getView().getPaint().setFlags(17);
        }
        getView().invalidate();
    }

    public final void ak(String str) {
        String str2 = this.acC;
        if (str2 == null || !str2.equals(str)) {
            this.acH++;
            this.acC = str;
            bV(str);
        }
    }

    public final void dF(int i) {
        if (this.afY == i) {
            return;
        }
        this.afY = i;
        pR().getYogaNode().dirty();
        if (this.agh) {
            getView().setTextSize(2, i);
        } else {
            getView().setTextSize(1, i);
        }
        O(this.afZ);
        float f = this.agb;
        if (f != 0.0f) {
            d(Float.valueOf(f));
        }
        Object obj = this.agr;
        if (obj != null) {
            H(obj);
        }
    }

    public final void bS(String str) {
        String str2 = this.acD;
        if (str2 == null || !str2.equals(str)) {
            this.acD = str;
            bV(this.acC);
        }
    }

    public final void bT(String str) {
        String str2 = this.acE;
        if (str2 == null || !str2.equals(str)) {
            this.acE = str;
            bV(this.acC);
        }
    }

    public final void bU(String str) {
        if ("clip".equalsIgnoreCase(str)) {
            getView().setEllipsize(null);
            return;
        }
        if ("ellipsis".equalsIgnoreCase(str)) {
            getView().setEllipsize(TextUtils.TruncateAt.END);
        } else if ("head".equalsIgnoreCase(str)) {
            getView().setEllipsize(TextUtils.TruncateAt.START);
        } else if ("middle".equalsIgnoreCase(str)) {
            getView().setEllipsize(TextUtils.TruncateAt.MIDDLE);
        }
    }

    public final void dD(int i) {
        pR().getYogaNode().dirty();
        android.support.v7.widget.q view = getView();
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        view.setMaxLines(i);
    }

    public final void dE(int i) {
        dD(i);
    }

    public final void a(Number number) {
        if (number != null) {
            pR().getYogaNode().dirty();
            getView().setLineSpacing(com.tk.core.o.o.P(number.floatValue()), 1.0f);
        }
    }

    @Deprecated
    public final void b(Number number) {
        if (number != null) {
            getView().setLineHeight(com.tk.core.o.o.P(number.floatValue()));
        }
    }

    public final void c(Number number) {
        if (number != null) {
            N(com.tk.core.o.o.P(number.floatValue()));
        }
    }

    public final void d(Number number) {
        if (number == null) {
            return;
        }
        com.tk.core.f.a aVar = (com.tk.core.f.a) pO().getGlobalNativeObject("KDSFeature");
        if (aVar != null && (aVar.ahX || aVar.cz("lineHeightFactor"))) {
            float fFloatValue = number.floatValue();
            this.agb = fFloatValue;
            N(fFloatValue * com.tk.core.o.o.P(this.afY == 0 ? 14.0f : r0));
            return;
        }
        c(number);
    }

    private void N(float f) {
        if (this.aga == f) {
            return;
        }
        this.aga = f;
        if (TextUtils.isEmpty(this.KE) && this.agr == null) {
            return;
        }
        this.age = true;
        int i = this.afX;
        if (1 == i) {
            e(this.KE, this.agi);
        } else if (2 == i) {
            a(this.ags);
        } else {
            setText(this.KE);
        }
        this.age = false;
    }

    public final void e(Number number) {
        if (number != null) {
            float fFloatValue = number.floatValue();
            if (this.agc == fFloatValue) {
                return;
            }
            this.agc = fFloatValue;
            int i = this.afY;
            getView().setLetterSpacing(fFloatValue / (i == 0 ? 14.0f : i));
        }
    }

    public final void setLetterSpacing(float f) {
        e(Float.valueOf(f));
    }

    public final void O(float f) {
        if (this.afZ == f) {
            return;
        }
        this.afZ = f;
        if (f < 0.0f || f >= 1.0f) {
            return;
        }
        if (f == 0.0f) {
            f = 0.1f;
        }
        int i = this.afY;
        float f2 = i == 0 ? 14.0f : i;
        getView().setAutoSizeTextTypeUniformWithConfiguration((int) (f * f2), (int) f2, 1, 1);
    }

    @Override // com.tk.core.component.e
    public final void bz(String str) {
        c(str, false);
    }

    public final void cu(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("none".equals(str) && !TextUtils.isEmpty(this.agm)) {
            c(this.agm, true);
        } else {
            c(str, false);
        }
        this.agm = str;
    }

    private void c(String str, boolean z) {
        String[] strArrSplit = str.split(" ");
        if (strArrSplit.length != 4) {
            com.tk.core.exception.a.b(new Exception("text shadow is error " + str), pP().pg());
            return;
        }
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            if (strArrSplit[i].toLowerCase().contains("px")) {
                fArr[i] = Float.parseFloat(strArrSplit[i].replace("px", ""));
            } else {
                fArr[i] = com.tk.core.o.o.P(Float.parseFloat(strArrSplit[i]));
            }
        }
        Integer numValueOf = Integer.valueOf(com.tk.core.o.r.a(strArrSplit[3], pP()));
        if (numValueOf == null) {
            return;
        }
        if (z) {
            fArr[2] = 0.0f;
        }
        getView().setShadowLayer(fArr[2], fArr[0], fArr[1], numValueOf.intValue());
    }

    public final void cv(final String str) {
        this.agf = true;
        String str2 = this.agd;
        if (str2 == null || !str2.equals(str)) {
            this.agd = str;
            if (getView().getWidth() == 0) {
                getView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tk.core.component.text.q.2
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        q.this.getView().removeOnLayoutChangeListener(this);
                        q.this.a(str, new Rect(0, 0, i3 - i, i4 - i2));
                    }
                });
            } else {
                a(str, new Rect(0, 0, getView().getWidth(), getView().getHeight()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Rect rect) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length < 3) {
            return;
        }
        try {
            int iIntValue = Double.valueOf(strArrSplit[0].trim()).intValue();
            int[] iArr = new int[strArrSplit.length - 1];
            float[] fArr = new float[strArrSplit.length - 1];
            boolean z = false;
            for (int i = 1; i < strArrSplit.length; i++) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.contains(" ")) {
                    String[] strArrSplit2 = strTrim.split(" ");
                    int i2 = i - 1;
                    iArr[i2] = com.tk.core.o.r.a(strArrSplit2[0].trim(), pP());
                    fArr[i2] = Float.parseFloat(strArrSplit2[1]);
                    z = true;
                } else {
                    iArr[i - 1] = com.tk.core.o.r.a(strTrim, pP());
                }
            }
            float[] fArrA = com.tk.core.component.view.b.a(iIntValue, rect);
            LinearGradient linearGradient = new LinearGradient(fArrA[0], fArrA[1], fArrA[2], fArrA[3], iArr, z ? fArr : null, Shader.TileMode.CLAMP);
            try {
                if (TextUtils.isEmpty(this.Om)) {
                    getView().setTextColor(-1);
                }
                getView().getPaint().setShader(linearGradient);
                getView().invalidate();
            } catch (Exception e) {
                e = e;
                com.tk.core.exception.a.a(e, pP().pg());
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.tk.core.component.e
    public final boolean bH(String str) {
        int length = str.length();
        if (length == 5) {
            return this.agf && TypedValues.Custom.S_COLOR.equals(str);
        }
        if (length != 17) {
            return super.bH(str);
        }
        return !this.agf && "gradientTextColor".equals(str);
    }

    public final void ay(boolean z) {
        this.agu = z;
        V8Function v8Function = this.agv;
        if (v8Function != null) {
            j("longPress", v8Function);
        }
        if (!z || dz(bB("longPress")) || pP().pi() == null) {
            return;
        }
        this.agv = new V8Function(pP().pi(), new JavaVoidCallback() { // from class: com.tk.core.component.text.q.3
            @Override // com.tkruntime.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, Object[] objArr) {
            }
        });
        addEventListener("longPress", this.agv, false);
    }

    public final void l(JsValueRef jsValueRef) {
        if (jsValueRef != null) {
            if (this.agl == null) {
                this.agl = new ArrayList();
            }
            this.agl.add(jsValueRef);
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        List<JsValueRef> list = this.agl;
        if (list != null && list.size() > 0) {
            Iterator<JsValueRef> it = this.agl.iterator();
            while (it.hasNext()) {
                V8Proxy.unRetainJsValue(it.next());
            }
            this.agl.clear();
        }
        if (V8Proxy.isV8Valid(this.agv)) {
            this.agv.setWeak();
        }
    }

    public final int rr() {
        return this.afY;
    }

    public final String rs() {
        return this.agn;
    }

    public final void i(Map<String, String> map) {
        if (map == null || map.isEmpty() || this.agp) {
            return;
        }
        this.acI++;
        this.acL = map;
        String str = map.get("src");
        final String str2 = map.get("fileName");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = this.acC;
        if (str3 == null || !str3.equals(str2)) {
            this.acC = str2;
            this.acG = str2;
            if (f.rh().a(str2, 0, pq(), getVersionCode()) != null) {
                bW(str2);
                return;
            }
            e.a aVar = this.acF;
            if (aVar != null) {
                e.a(this.acG, aVar);
            }
            this.acF = new e.a() { // from class: com.tk.core.component.text.q.4
                @Override // com.tk.core.component.text.e.a
                public final void a(Typeface typeface, boolean z, int i) {
                    q.a(q.this, (e.a) null);
                    if (q.this.agp || q.this.acI != i) {
                        return;
                    }
                    q.this.bW(str2);
                }
            };
            e.a(pq(), getContext(), str, str2, getVersionCode(), this.acI, this.acF);
        }
    }

    public final void az(boolean z) {
        this.ago = z;
    }

    public final void aA(boolean z) {
        this.agp = z;
    }

    public final void aB(boolean z) {
        this.agq = z;
        if (z) {
            qm();
        }
    }

    public final e.a rt() {
        return this.acF;
    }

    public final String ru() {
        return this.acG;
    }

    public final void a(e.a aVar) {
        this.acF = aVar;
    }

    public final void cw(String str) {
        this.acG = str;
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(final TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            qU();
        } else {
            ac.c(new Runnable() { // from class: com.tk.core.component.text.q.5
                @Override // java.lang.Runnable
                public final void run() {
                    q qVar = q.this;
                    TKBaseNativeModule.DestroyReason destroyReason2 = destroyReason;
                    qVar.qU();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qU() {
        e.a aVar = this.acF;
        if (aVar != null) {
            e.a(this.acG, aVar);
        }
    }

    private void bV(String str) {
        com.tk.core.component.b.a(getView(), str, this.acD, this.acE, pn(), pR().getYogaNode(), pq(), getVersionCode(), this.acH, new b.a() { // from class: com.tk.core.component.text.q.6
            @Override // com.tk.core.component.b.a
            public final void a(Typeface typeface, int i, int i2) {
                if (q.this.pN() || q.this.acH != i2) {
                    return;
                }
                q.this.getView().setTypeface(typeface, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(String str) {
        com.tk.core.component.b.a(getView(), str, this.acD, this.acE, pn(), pR().getYogaNode(), pq(), getVersionCode(), this.acI, new b.a() { // from class: com.tk.core.component.text.q.7
            @Override // com.tk.core.component.b.a
            public final void a(Typeface typeface, int i, int i2) {
                if (q.this.pN() || q.this.acI != i2) {
                    return;
                }
                q.this.getView().setTypeface(typeface, i);
            }
        });
    }
}
