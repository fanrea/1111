package com.tk.core.component.text.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kuaishou.tk.api.export.sdk.Callback;
import com.kuaishou.tk.api.export.sdk.V8Proxy;
import com.luck.picture.lib.config.CustomIntentKey;
import com.tk.core.component.text.e;
import com.tk.core.component.text.q;
import com.tk.core.o.o;
import com.tk.core.o.r;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class f {
    private static final float afJ = Resources.getSystem().getDisplayMetrics().density;
    private static final float agD = Resources.getSystem().getDisplayMetrics().scaledDensity;
    private static float agE;
    private static boolean agF;
    private static int agG;

    public static void ae() {
    }

    public static class a {
        public String KE;
        public String KS;
        public Map<String, String> acL;
        public String aei;
        public String aej;
        public int afC;
        public int afD;
        public float afE;
        public float afF;
        public float afG;
        public int agP;
        public String agQ;
        public String agR;
        public String agS;
        public String agT;
        public String agU;
        public String agV;
        public JsValueRef<V8Function> agW;
        public String agX;
        public String agY;
        public float agZ;
        private int aha;
        private int ahb;

        static /* synthetic */ int a(a aVar) {
            int i = aVar.aha;
            aVar.aha = i + 1;
            return i;
        }

        static /* synthetic */ int b(a aVar) {
            int i = aVar.ahb;
            aVar.ahb = i + 1;
            return i;
        }

        static /* synthetic */ int d(a aVar) {
            int i = aVar.aha;
            aVar.aha = i - 1;
            return i;
        }

        static /* synthetic */ int f(a aVar) {
            int i = aVar.ahb;
            aVar.ahb = i - 1;
            return i;
        }

        public a() {
            this.KE = "";
            this.agV = "#0000EE";
            this.aha = 0;
            this.ahb = 0;
        }

        public a(String str) {
            this.KE = "";
            this.agV = "#0000EE";
            this.aha = 0;
            this.ahb = 0;
            this.KE = str;
        }
    }

    public static void a(q qVar, Object obj, e eVar) {
        d(qVar);
        agG++;
        if (obj instanceof Map) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a(qVar, (Map) obj));
            a(qVar, (List<a>) arrayList, eVar);
        } else if (obj instanceof List) {
            a(qVar, a(qVar, (List) obj), eVar);
        }
    }

    private static void d(q qVar) {
        agF = false;
        agE = 0.0f;
        if (qVar != null) {
            qVar.az(false);
            qVar.aA(false);
            qVar.aB(false);
        }
    }

    private static a a(q qVar, Map map) {
        Object obj = map.get("text");
        Object obj2 = map.get(TypedValues.Custom.S_COLOR);
        Object obj3 = map.get(com.baidu.mobads.container.n.f.T);
        Object obj4 = map.get("fontFamily");
        Object obj5 = map.get("fontFace");
        Object obj6 = map.get("fontSize");
        Object obj7 = map.get("fontWeight");
        Object obj8 = map.get("fontStyle");
        Object obj9 = map.get("textDecoration");
        Object obj10 = map.get("image");
        Object obj11 = map.get(CustomIntentKey.EXTRA_IMAGE_WIDTH);
        Object obj12 = map.get(CustomIntentKey.EXTRA_IMAGE_HEIGHT);
        Object obj13 = map.get("marginRight");
        Object obj14 = map.get("marginLeft");
        Object obj15 = map.get(CustomIntentKey.EXTRA_OFFSET_Y);
        Object obj16 = map.get("href");
        Object obj17 = map.get("hrefColor");
        Object obj18 = map.get("onclick");
        Object obj19 = map.get("textShadow");
        Object obj20 = map.get("verticalAlign");
        Object obj21 = map.get("letterSpacing");
        a aVar = new a();
        if (obj instanceof String) {
            aVar.KE = (String) obj;
        }
        if (obj2 instanceof String) {
            aVar.aei = (String) obj2;
        }
        if (obj3 instanceof String) {
            aVar.aej = (String) obj3;
        }
        if (obj4 instanceof String) {
            aVar.KS = (String) obj4;
        }
        if (obj5 instanceof Map) {
            aVar.acL = (Map) obj5;
        }
        if (obj7 instanceof String) {
            aVar.agQ = (String) obj7;
        }
        if (obj8 instanceof String) {
            aVar.agR = (String) obj8;
        }
        if (obj9 instanceof String) {
            aVar.agS = (String) obj9;
            if (!TextUtils.isEmpty(aVar.agS)) {
                agF = true;
            }
        }
        aVar.agP = 0;
        if (obj6 instanceof Number) {
            aVar.agP = ((Number) obj6).intValue();
        }
        if (obj10 instanceof String) {
            aVar.agT = (String) obj10;
        }
        if (obj11 instanceof Number) {
            aVar.afC = ((Number) obj11).intValue();
        }
        if (obj12 instanceof Number) {
            aVar.afD = ((Number) obj12).intValue();
        }
        if (obj13 instanceof Number) {
            aVar.afG = ((Number) obj13).floatValue();
        }
        if (obj14 instanceof Number) {
            aVar.afF = ((Number) obj14).floatValue();
        }
        if (obj15 instanceof Number) {
            aVar.afE = ((Number) obj15).floatValue();
        }
        if (obj16 instanceof String) {
            aVar.agU = (String) obj16;
        }
        if (obj17 instanceof String) {
            aVar.agV = (String) obj17;
        }
        if (obj18 instanceof V8Function) {
            V8Proxy.unRetainJsValue(aVar.agW);
            aVar.agW = V8Proxy.retainJsValue((V8Function) obj18, f.class);
            qVar.l(aVar.agW);
        }
        if (obj19 instanceof String) {
            aVar.agX = (String) obj19;
        }
        if (obj20 instanceof String) {
            aVar.agY = (String) obj20;
        }
        if (obj21 instanceof Number) {
            aVar.agZ = ((Number) obj21).floatValue();
        }
        return aVar;
    }

    private static List<a> a(q qVar, List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof String) {
                arrayList.add(new a((String) obj));
            } else if (obj instanceof Map) {
                arrayList.add(a(qVar, (Map) obj));
            }
        }
        return arrayList;
    }

    private static void a(q qVar, List<a> list, e eVar) {
        if (list == null || list.isEmpty()) {
            if (eVar != null) {
                eVar.c(new SpannableString(""));
                return;
            }
            return;
        }
        if (agF) {
            qVar.az(true);
            if (!TextUtils.isEmpty(qVar.rs())) {
                qVar.getView().getPaint().setFlags(qVar.getView().getPaintFlags() & (-9) & (-17));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (a aVar : list) {
            if (TextUtils.isEmpty(aVar.agT) || (!TextUtils.isEmpty(aVar.agT) && !TextUtils.isEmpty(aVar.KE))) {
                if (aVar.agP > 0) {
                    if (aVar.agP > agE) {
                        agE = aVar.agP;
                    }
                } else if (qVar.rr() <= 0) {
                    float fR = o.R(qVar.getView().getTextSize());
                    if (agE < fR) {
                        agE = fR;
                    }
                } else if (qVar.rr() > agE) {
                    agE = qVar.rr();
                }
            }
            if (agF && TextUtils.isEmpty(aVar.agS) && !TextUtils.isEmpty(qVar.rs())) {
                aVar.agS = qVar.rs();
            }
            if (TextUtils.isEmpty(aVar.KE) && aVar.agU != null) {
                aVar.KE = aVar.agU;
            }
            if (!TextUtils.isEmpty(aVar.agT) && TextUtils.isEmpty(aVar.KE)) {
                aVar.KE = " ";
            }
            if (TextUtils.isEmpty(aVar.agT) && aVar.afF != 0.0f) {
                aVar.KE = " " + aVar.KE;
                a.a(aVar);
            }
            if (TextUtils.isEmpty(aVar.agT) && aVar.afG != 0.0f) {
                aVar.KE += " ";
                a.b(aVar);
            }
            sb.append(aVar.KE);
        }
        int i = 0;
        SpannableString spannableString = new SpannableString(sb);
        for (a aVar2 : list) {
            int length = aVar2.KE.length();
            if (!TextUtils.isEmpty(aVar2.agU)) {
                a(qVar, spannableString, aVar2, i, i + length);
            } else if (aVar2.agW != null) {
                b(qVar, spannableString, aVar2, i, i + length);
            }
            if (!TextUtils.isEmpty(aVar2.agT)) {
                a(qVar, spannableString, aVar2, i, i + length, eVar);
            }
            int i2 = length + i;
            b(qVar, spannableString, aVar2, i, i2, eVar);
            i = i2;
        }
        if (eVar != null) {
            eVar.c(spannableString);
        }
    }

    private static void a(q qVar, SpannableString spannableString, a aVar, int i, int i2) {
        if (aVar.agU != null) {
            qVar.aB(true);
            spannableString.setSpan(new i(aVar.agU), i, i2, 17);
            spannableString.setSpan(new UnderlineSpan(), i, i2, 17);
            if (aVar.agV != null) {
                spannableString.setSpan(new ForegroundColorSpan(r.parseColor(aVar.agV)), i, i2, 17);
            }
        }
    }

    private static void b(final q qVar, SpannableString spannableString, final a aVar, int i, int i2) {
        if (aVar.agU != null) {
            return;
        }
        qVar.aB(true);
        spannableString.setSpan(new ClickableSpan() { // from class: com.tk.core.component.text.a.f.1
            @Override // android.text.style.ClickableSpan
            public final void onClick(View view) {
                JsValueRef<V8Function> jsValueRef = aVar.agW;
                if (jsValueRef == null) {
                    return;
                }
                V8Function v8Function = jsValueRef.get();
                if (V8Proxy.isV8Valid(v8Function)) {
                    HashMap map = new HashMap();
                    MotionEvent motionEventQu = qVar.qu();
                    if (motionEventQu != null) {
                        map.put("x", Float.valueOf(o.R(motionEventQu.getX())));
                        map.put("y", Float.valueOf(o.R(motionEventQu.getY())));
                        map.put("rawX", Float.valueOf(o.R(motionEventQu.getRawX())));
                        map.put("rawY", Float.valueOf(o.R(motionEventQu.getRawY())));
                        PointF pointFJ = qVar.j(motionEventQu);
                        if (pointFJ != null) {
                            map.put("rootX", Float.valueOf(o.R(pointFJ.x)));
                            map.put("rootY", Float.valueOf(o.R(pointFJ.y)));
                        } else {
                            map.put("rootX", Float.valueOf(0.0f));
                            map.put("rootY", Float.valueOf(0.0f));
                        }
                    }
                    try {
                        v8Function.call(null, map);
                    } catch (Throwable th) {
                        com.tk.core.exception.a.a(qVar.pO(), th);
                    }
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (aVar.aei != null) {
                    textPaint.setColor(Color.parseColor(aVar.aei));
                } else {
                    textPaint.setColor(qVar.getView().getCurrentTextColor());
                }
                if (f.agF) {
                    if ("underline".equals(aVar.agS)) {
                        return;
                    }
                    textPaint.setUnderlineText(false);
                } else {
                    if ("underline".equals(qVar.rs())) {
                        return;
                    }
                    textPaint.setUnderlineText(false);
                }
            }
        }, i, i2, 17);
    }

    private static void a(final q qVar, final SpannableString spannableString, final a aVar, final int i, final int i2, final e eVar) {
        final float f = agE;
        a(qVar, aVar, agG, new com.tk.core.a.c() { // from class: com.tk.core.component.text.a.f.2
            @Override // com.tk.core.a.c
            public final void b(Drawable drawable, int i3) {
                Drawable cVar;
                if (com.tk.core.component.b.pJ() || f.agG == i3) {
                    int iEb = aVar.afC > 0 ? o.eb(aVar.afC) : drawable.getIntrinsicWidth();
                    int iEb2 = aVar.afD > 0 ? o.eb(aVar.afD) : drawable.getIntrinsicHeight();
                    int iP = o.P(aVar.afE * 2.0f);
                    drawable.setBounds(0, 0, iEb, iEb2);
                    if (aVar.afE == 0.0f) {
                        cVar = drawable;
                    } else {
                        int i4 = iP > 0 ? iP : -iP;
                        int i5 = iEb2 + i4;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(qVar.getContext().getResources(), Bitmap.createBitmap(iEb, i5, Bitmap.Config.ARGB_8888));
                        if (iP > 0) {
                            cVar = new c(bitmapDrawable, drawable, iEb, i5, 0, 0);
                        } else {
                            cVar = new c(bitmapDrawable, drawable, iEb, i5, 0, i4);
                        }
                    }
                    com.tk.core.component.text.a.a aVar2 = new com.tk.core.component.text.a.a(cVar, "");
                    aVar2.M(o.P(f));
                    aVar2.aQ(iEb, iP > 0 ? iEb2 + iP : iEb2 - iP).J(o.P(aVar.afF)).K(o.P(aVar.afG)).L(iP);
                    spannableString.setSpan(aVar2, i, i2, 17);
                    e eVar2 = eVar;
                    if (eVar2 != null) {
                        eVar2.c(spannableString);
                    }
                }
            }
        });
    }

    private static void b(q qVar, SpannableString spannableString, a aVar, int i, int i2, e eVar) {
        a(qVar, aVar, spannableString, i, i2);
        b(qVar, aVar, spannableString, i, i2);
        if (aVar.aei != null && (aVar.agU == null || aVar.agV == null)) {
            spannableString.setSpan(new ForegroundColorSpan(r.parseColor(aVar.aei)), i, i2, 17);
        }
        if (aVar.aej != null) {
            spannableString.setSpan(new BackgroundColorSpan(r.parseColor(aVar.aej)), i, i2, 17);
        }
        a(qVar, aVar, spannableString, i, i2, eVar);
        b(qVar, aVar, spannableString, i, i2, eVar);
        int iRr = aVar.agP > 0 ? aVar.agP : qVar.rr();
        if (iRr > 0) {
            spannableString.setSpan(new AbsoluteSizeSpan((int) (iRr * (qVar.agh ? agD : afJ))), i, i2, 17);
        }
        a(aVar, spannableString, i, i2);
        b(aVar, spannableString, i, i2);
        c(aVar, spannableString, i, i2);
        if (TextUtils.isEmpty(aVar.agT) && aVar.afE != 0.0f) {
            spannableString.setSpan(new d(o.P(aVar.afE)), i, i2, 17);
        }
        c(qVar, aVar, spannableString, i, i2);
    }

    private static void a(q qVar, a aVar, SpannableString spannableString, int i, int i2) {
        if (com.baidu.mobads.container.util.animation.j.f.equals(aVar.agY) || "middle".equals(aVar.agY)) {
            int iEb = o.eb(aVar.agP);
            if (iEb <= 0 && (iEb = o.eb(qVar.rr())) <= 0) {
                iEb = (int) qVar.getView().getTextSize();
            }
            spannableString.setSpan(new j(o.P(agE), iEb, aVar.agY), i, i2, 17);
        }
    }

    private static void b(q qVar, a aVar, SpannableString spannableString, int i, int i2) {
        if (TextUtils.isEmpty(aVar.agX)) {
            return;
        }
        String[] strArrSplit = aVar.agX.split(" ");
        if (strArrSplit.length != 4) {
            com.tk.core.exception.a.a(qVar.pO(), new Exception("text shadow is error " + aVar.agX));
            return;
        }
        float[] fArr = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            if (strArrSplit[i3].toLowerCase().contains("px")) {
                fArr[i3] = Float.parseFloat(strArrSplit[i3].replace("px", ""));
            } else {
                fArr[i3] = o.P(Float.parseFloat(strArrSplit[i3]));
            }
        }
        spannableString.setSpan(new g(fArr[2], fArr[0], fArr[1], r.a(strArrSplit[3], qVar.pP())), i, i2, 17);
    }

    private static void a(a aVar, SpannableString spannableString, int i, int i2) {
        boolean z = false;
        boolean z2 = (!TextUtils.isEmpty(aVar.agQ) ? bj(aVar.agQ) : -1) >= 500 || "bold".equals(aVar.agQ);
        if (!TextUtils.isEmpty(aVar.agR) && aVar.agR.equalsIgnoreCase("italic")) {
            z = true;
        }
        if (z2 && z) {
            spannableString.setSpan(new StyleSpan(3), i, i2, 17);
        } else if (z2) {
            spannableString.setSpan(new StyleSpan(1), i, i2, 17);
        } else if (z) {
            spannableString.setSpan(new StyleSpan(2), i, i2, 17);
        }
    }

    private static void b(a aVar, SpannableString spannableString, int i, int i2) {
        if (TextUtils.isEmpty(aVar.agS)) {
            return;
        }
        String str = aVar.agS;
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -1171789332) {
            if (iHashCode != -1026963764) {
                if (iHashCode == 3387192 && str.equals("none")) {
                    c = 2;
                }
            } else if (str.equals("underline")) {
                c = 0;
            }
        } else if (str.equals("line-through")) {
            c = 1;
        }
        if (c == 0) {
            b(spannableString, i, i2);
            spannableString.setSpan(new UnderlineSpan(), i, i2, 17);
        } else if (c == 1) {
            a(spannableString, i, i2);
            spannableString.setSpan(new StrikethroughSpan(), i, i2, 17);
        } else {
            if (c != 2) {
                return;
            }
            b(spannableString, i, i2);
            a(spannableString, i, i2);
        }
    }

    private static void a(SpannableString spannableString, int i, int i2) {
        spannableString.setSpan(new UnderlineSpan() { // from class: com.tk.core.component.text.a.f.3
            @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, i, i2, 17);
    }

    private static void b(SpannableString spannableString, int i, int i2) {
        spannableString.setSpan(new StrikethroughSpan() { // from class: com.tk.core.component.text.a.f.4
            @Override // android.text.style.StrikethroughSpan, android.text.style.CharacterStyle
            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setStrikeThruText(false);
            }
        }, i, i2, 17);
    }

    private static void c(a aVar, SpannableString spannableString, int i, int i2) {
        if (TextUtils.isEmpty(aVar.agT) && aVar.afF != 0.0f && aVar.aha > 0) {
            int i3 = (i + aVar.aha) - 1;
            spannableString.setSpan(new h(o.P(aVar.afF)), i3, i3 + 1, 17);
            a.d(aVar);
        }
        if (!TextUtils.isEmpty(aVar.agT) || aVar.afG == 0.0f || aVar.ahb <= 0) {
            return;
        }
        int i4 = i2 - aVar.ahb;
        spannableString.setSpan(new h(o.P(aVar.afG)), i4, i4 + 1, 17);
        a.f(aVar);
    }

    private static int bj(String str) {
        if (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') {
            return -1;
        }
        return (str.charAt(0) - '0') * 100;
    }

    private static void a(final q qVar, final a aVar, final int i, final com.tk.core.a.c cVar) {
        com.tk.core.o.h.a(qVar.getContext(), aVar.agT, qVar.pO().pq(), qVar.pn(), 0, 0, new Callback<Bitmap>() { // from class: com.tk.core.component.text.a.f.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kuaishou.tk.api.export.sdk.Callback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void callback(Bitmap bitmap) {
                if (bitmap == null || bitmap.isRecycled() || qVar.pN()) {
                    return;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(qVar.getContext().getResources(), bitmap);
                com.tk.core.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.b(bitmapDrawable, i);
                }
            }

            @Override // com.kuaishou.tk.api.export.sdk.Callback
            public final void error(Throwable th) {
                com.tk.core.i.a.a("RichTextHelper", "richText loadDrawable request exception, image: " + aVar.agT, th);
            }
        });
    }

    private static void a(final q qVar, a aVar, final SpannableString spannableString, final int i, final int i2, final e eVar) {
        if (com.tk.core.component.b.pJ()) {
            Typeface typefaceA = com.tk.core.component.b.a(qVar.getContext(), aVar.KS, 0, qVar.pn(), qVar.pq(), qVar.getVersionCode());
            if (typefaceA == null || qVar.pN()) {
                return;
            }
            spannableString.setSpan(new com.tk.core.component.text.c(null, typefaceA), i, i2, 17);
            return;
        }
        if (TextUtils.isEmpty(aVar.KS) || TextUtils.isEmpty(qVar.pn())) {
            return;
        }
        com.tk.core.component.b.a(qVar.getContext(), aVar.KS, 0, qVar.pn(), qVar.pq(), qVar.getVersionCode(), agG, new e.a() { // from class: com.tk.core.component.text.a.f.6
            @Override // com.tk.core.component.text.e.a
            public final void a(Typeface typeface, boolean z, int i3) {
                e eVar2;
                if (typeface == null || qVar.pN() || f.agG != i3) {
                    return;
                }
                spannableString.setSpan(new com.tk.core.component.text.c(null, typeface), i, i2, 17);
                if (z || (eVar2 = eVar) == null) {
                    return;
                }
                eVar2.c(spannableString);
            }
        });
    }

    private static void b(final q qVar, a aVar, final SpannableString spannableString, final int i, final int i2, final e eVar) {
        if (aVar.acL == null || aVar.acL.isEmpty()) {
            return;
        }
        String str = aVar.acL.get("src");
        String str2 = aVar.acL.get("fileName");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        qVar.aA(true);
        Typeface typefaceA = com.tk.core.component.text.f.rh().a(str2, 0, qVar.pq(), qVar.getVersionCode());
        if (typefaceA != null) {
            spannableString.setSpan(new com.tk.core.component.text.c(null, typefaceA), i, i2, 17);
            return;
        }
        com.tk.core.component.text.e.a(qVar.ru(), qVar.rt());
        e.a aVar2 = new e.a() { // from class: com.tk.core.component.text.a.f.7
            @Override // com.tk.core.component.text.e.a
            public final void a(Typeface typeface, boolean z, int i3) {
                if (qVar.pN()) {
                    return;
                }
                if (com.tk.core.component.b.pJ() || f.agG == i3) {
                    qVar.a((e.a) null);
                    if (typeface != null) {
                        spannableString.setSpan(new com.tk.core.component.text.c(null, typeface), i, i2, 17);
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            eVar2.c(spannableString);
                        }
                    }
                }
            }
        };
        qVar.a(aVar2);
        qVar.cw(str2);
        com.tk.core.component.text.e.a(qVar.pq(), qVar.getContext(), str, str2, qVar.getVersionCode(), agG, aVar2);
    }

    private static void c(q qVar, a aVar, SpannableString spannableString, int i, int i2) {
        if (aVar.agZ == 0.0f || !TextUtils.isEmpty(aVar.agT)) {
            return;
        }
        int iRr = aVar.agP;
        if (iRr <= 0 && (iRr = qVar.rr()) <= 0) {
            iRr = o.Q(qVar.getView().getTextSize());
        }
        spannableString.setSpan(new b(aVar.agZ / iRr), i, i2, 17);
    }
}
