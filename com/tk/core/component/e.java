package com.tk.core.component;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.container.util.animation.j;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.framework.tachikoma.a;
import com.kwad.yoga.YogaEdge;
import com.kwad.yoga.YogaUnit;
import com.tk.core.bridge.b;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.a.c;
import com.tk.core.component.text.q;
import com.tk.core.component.view.TKView;
import com.tk.core.component.view.TKViewBackgroundDrawable;
import com.tk.core.e.b;
import com.tk.core.e.b.l;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tk.core.o.r;
import com.tk.core.o.s;
import com.tkruntime.v8.DomExecutor;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class e<T extends View> extends TKBaseNativeModule implements DomExecutor {
    private static volatile Boolean ZY;
    private static final float ZZ = (float) Math.sqrt(5.0d);
    private static int[] aaa;
    private static Boolean aac;
    com.tk.core.component.a aaA;
    private float aaB;
    private float aaC;
    private HashMap<Integer, Object> aaD;
    private HashMap aaE;
    private int aaF;
    public String aaG;
    public V8Function aaH;
    public JsValueRef<V8Function> aaI;

    @Deprecated
    public V8Function aaJ;
    public JsValueRef<V8Function> aaK;
    public JsValueRef<V8Object> aaL;
    public boolean aaM;
    public boolean aaN;
    private boolean aaO;
    private String aaP;
    public HashMap aaQ;
    private float aaR;
    private float aaS;
    private boolean aaT;
    private JsValueRef<V8Function> aaU;
    protected a aaV;
    public boolean aaW;
    private PointF aab;
    private final com.tk.core.h.a<T> aad;
    private com.tk.core.component.view.d aae;
    private GestureDetector aaf;
    private ScaleGestureDetector aag;
    private MotionEvent aah;
    private boolean aai;
    private final HashMap<String, List<JsValueRef<V8Function>>> aaj;
    private int aak;
    private boolean aal;
    private boolean aam;
    private boolean aan;
    protected TKView aao;
    protected e aap;
    public String aaq;
    public double aar;
    private boolean aas;
    private boolean aat;
    private final Map<String, com.tk.core.component.a.c> aau;
    private final HashMap<String, HashMap<Float, HashMap<String, Object>>> aav;
    private Map<String, HashMap> aaw;
    float aax;
    int aay;
    int aaz;
    public boolean enabled;
    private float mBorderRadius;
    public HashMap style;
    private T uS;

    public interface a {
        Object onJSInvokeNativeWithJSONString(String str, String str2, V8Function v8Function);
    }

    private static float v(float f) {
        if (f >= -3.4028235E38f && f <= Float.MAX_VALUE) {
            return f;
        }
        if (f < -3.4028235E38f || f == Float.NEGATIVE_INFINITY) {
            return -3.4028235E38f;
        }
        return (f > Float.MAX_VALUE || f == Float.POSITIVE_INFINITY) ? Float.MAX_VALUE : 0.0f;
    }

    @Override // com.tkruntime.v8.DomExecutor
    public boolean hasRemainRunner() {
        return false;
    }

    public boolean mJ() {
        return false;
    }

    protected abstract T n(Context context);

    public void nQ() {
    }

    public boolean qr() {
        return true;
    }

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.aaT = false;
        return false;
    }

    public static <T extends View> e<T> aN(View view) {
        return (e) view.getTag(a.b.tk_node);
    }

    public e(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.aaj = new HashMap<>();
        this.aak = 0;
        this.aal = false;
        this.aam = false;
        this.aan = false;
        this.aas = false;
        this.aat = false;
        this.aau = new HashMap();
        this.aav = new LinkedHashMap();
        this.aaw = new HashMap();
        this.aax = 0.0f;
        this.aay = 0;
        this.aaz = 0;
        this.aaC = 0.0f;
        this.style = new HashMap();
        this.aaD = new HashMap<>();
        this.aaE = new HashMap();
        this.aaO = false;
        this.aaQ = new HashMap();
        this.aaR = 0.5f;
        this.aaS = 0.5f;
        this.aaW = false;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String originClzzName = nativeModuleInitParams.v8This instanceof V8ObjectProxy ? ((V8ObjectProxy) nativeModuleInitParams.v8This).getOriginClzzName() : "TKBaseView";
            com.tk.core.exception.a.a(pO(), new Throwable("create " + originClzzName + " on subThread"));
        }
        this.aad = com.tk.core.h.a.q(this);
        this.aaG = pR().aib;
        this.aap = this;
    }

    public e(NativeModuleInitParams nativeModuleInitParams, boolean z) {
        super(nativeModuleInitParams);
        this.aaj = new HashMap<>();
        this.aak = 0;
        this.aal = false;
        this.aam = false;
        this.aan = false;
        this.aas = false;
        this.aat = false;
        this.aau = new HashMap();
        this.aav = new LinkedHashMap();
        this.aaw = new HashMap();
        this.aax = 0.0f;
        this.aay = 0;
        this.aaz = 0;
        this.aaC = 0.0f;
        this.style = new HashMap();
        this.aaD = new HashMap<>();
        this.aaE = new HashMap();
        this.aaO = false;
        this.aaQ = new HashMap();
        this.aaR = 0.5f;
        this.aaS = 0.5f;
        this.aaW = false;
        this.aan = z;
        com.tk.core.k.a.t(this);
        this.aad = com.tk.core.h.a.q(this);
        this.aaG = pR().aib;
        this.aap = this;
    }

    public final void a(TKView tKView) {
        TKView tKView2 = this.aao;
        if (tKView2 != null && tKView2 != tKView) {
            throw new RuntimeException("TKBaseView is already attach to parent");
        }
        this.aao = tKView;
        qd();
        if (this.aaO) {
            qp();
        }
    }

    public final void b(TKView tKView) {
        if (this.aao != tKView) {
            throw new RuntimeException("TKBaseView is not attach to current parent");
        }
        this.aao = null;
    }

    public final T getView() {
        if (this.uS == null) {
            this.uS = (T) I(getTKContext().getContext());
            this.uS.setTag(a.b.tk_node, this);
            this.aad.bg(this.uS);
        }
        return this.uS;
    }

    public final boolean pQ() {
        return this.uS != null;
    }

    public final com.tk.core.h.a<T> pR() {
        if (this.aad.getYogaNode() == null) {
            getView();
        }
        return this.aad;
    }

    public void a(HashMap map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (!(getJsObj() instanceof V8ObjectProxy)) {
            com.tk.core.i.a.a("TKBaseView", "setStyle jsObject is invalid: " + getClass().getName(), null);
            return;
        }
        this.aaD.clear();
        this.aaE.clear();
        for (Map.Entry entry : map.entrySet()) {
            String string = entry.getKey().toString();
            Object value = entry.getValue();
            Object obj = this.style.get(string);
            if (value != null && (!value.equals(obj) || bH(string))) {
                this.style.put(string, value);
                com.tk.core.h.b.rU();
                int iCL = com.tk.core.h.b.cL(string);
                if (iCL == Integer.MAX_VALUE) {
                    this.aaE.put(string, value);
                } else {
                    this.aaD.put(Integer.valueOf(iCL), value);
                }
            }
        }
        if (!this.aaD.isEmpty()) {
            pR().q(this.aaD);
        }
        if (!this.aaE.isEmpty()) {
            a(this.aaE, ((V8ObjectProxy) getJsObj()).getOriginClzzName());
        }
        Object obj2 = map.get("transform");
        if (obj2 instanceof Map) {
            g((Map) obj2);
        }
    }

    public final HashMap<String, HashMap<Float, HashMap<String, Object>>> pS() {
        return this.aav;
    }

    public final void bk(String str) {
        if (str == null) {
            return;
        }
        String str2 = this.aaG;
        this.aaG = str;
        pR().aib = str;
        getView().setContentDescription(str);
        TKView tKView = this.aao;
        if (tKView != null) {
            tKView.u(str2, this.aaG);
        }
    }

    public final String pT() {
        return pR().aib;
    }

    public final void aG(V8Function v8Function) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.aaI);
        if (jsValueRefRetainJsValue == null || !ad.isV8Valid(jsValueRefRetainJsValue.get())) {
            this.aaI = null;
            this.aaH = null;
            j("tap", null);
        } else {
            this.aaI = jsValueRefRetainJsValue;
            this.aaH = this.aaI.get();
            addEventListener("tap", jsValueRefRetainJsValue.get(), false);
        }
    }

    public final void aH(V8Function v8Function) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.aaK);
        if (jsValueRefRetainJsValue == null || !ad.isV8Valid(jsValueRefRetainJsValue.get())) {
            this.aaK = null;
            this.aaJ = null;
            j("longPress", null);
        } else {
            this.aaK = jsValueRefRetainJsValue;
            this.aaJ = this.aaK.get();
            addEventListener("longPress", jsValueRefRetainJsValue.get(), false);
        }
    }

    public final void y(V8Object v8Object) {
        JsValueRef<V8Object> jsValueRefRetainJsValue = ad.retainJsValue(v8Object, this);
        ad.unRetainJsValue(this.aaL);
        this.aaL = jsValueRefRetainJsValue;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
        getView().setEnabled(this.enabled);
    }

    public final void ao(boolean z) {
        this.enabled = !z;
        getView().setEnabled(this.enabled);
    }

    public final void ap(boolean z) {
        this.aaN = z;
        ViewParent parent = getView().getParent();
        if (parent == null) {
            com.tk.core.i.a.y("TKBaseView", "setDisallowParentInterceptTouchEvent: parent is null");
        } else {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void addEventListener(String str, V8Function v8Function, boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        JsValueRef<V8Function> jsValueRefRetainJsValue;
        if (v8Function == null || TextUtils.isEmpty(str) || (jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this)) == null) {
            return;
        }
        List<JsValueRef<V8Function>> arrayList = this.aaj.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.aaj.put(str, arrayList);
        }
        if (!z) {
            for (JsValueRef<V8Function> jsValueRef : arrayList) {
                if (jsValueRef != null) {
                    ad.unRetainJsValue(jsValueRef);
                }
            }
            arrayList.clear();
        } else {
            for (JsValueRef<V8Function> jsValueRef2 : arrayList) {
                if (jsValueRef2 != null && jsValueRef2.get() == v8Function) {
                    ad.unRetainJsValue(jsValueRefRetainJsValue);
                    return;
                }
            }
        }
        dA(bB(str));
        arrayList.add(jsValueRefRetainJsValue);
        bC(str);
    }

    public final void j(String str, V8Function v8Function) {
        List<JsValueRef<V8Function>> list;
        if (TextUtils.isEmpty(str) || (list = this.aaj.get(str)) == null || list.isEmpty()) {
            return;
        }
        if (v8Function == null) {
            for (JsValueRef<V8Function> jsValueRef : list) {
                if (jsValueRef != null) {
                    ad.unRetainJsValue(jsValueRef);
                }
            }
            list.clear();
            dB(bB(str));
            return;
        }
        JsValueRef<V8Function> jsValueRef2 = null;
        Iterator<JsValueRef<V8Function>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JsValueRef<V8Function> next = it.next();
            if (next != null && next.get() != null && next.get().getHandle() == v8Function.getHandle()) {
                jsValueRef2 = next;
                break;
            }
        }
        if (jsValueRef2 != null) {
            ad.unRetainJsValue(jsValueRef2);
            list.remove(jsValueRef2);
        }
        if (list.isEmpty()) {
            dB(bB(str));
        }
    }

    public final void b(V8Object v8Object, String str) {
        com.tk.core.component.a.c cVar;
        com.tk.core.component.a.c cVar2 = (com.tk.core.component.a.c) getNativeModule(v8Object);
        if (cVar2 == null) {
            return;
        }
        cVar2.pL();
        if (this.aau.containsKey(str) && (cVar = this.aau.get(str)) != null) {
            cVar.bR(str);
            cVar.pM();
        }
        if (getView() == null) {
            com.tk.core.i.a.a("TKBaseView", "addAnimation", new IllegalStateException("targetView is null!!!"));
            return;
        }
        cVar2.p(this);
        a(cVar2, str);
        cVar2.bQ(str);
        this.aau.put(str, cVar2);
    }

    private void u(float f) {
        if (this.aaB == f) {
            return;
        }
        if (f == 0.0f && this.aaC != 0.0f) {
            getView().setCameraDistance(this.aaC);
            return;
        }
        if (this.aaC == 0.0f) {
            this.aaC = getView().getCameraDistance();
        }
        this.aaB = f;
        float f2 = s.getContext().getResources().getDisplayMetrics().density;
        getView().setCameraDistance(v(f2 * f2 * this.aaB * ZZ));
    }

    private void a(final com.tk.core.component.a.c cVar, final String str) {
        if (cVar.qI()) {
            aO(getView());
            this.aav.remove(str);
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.aav.put(str, linkedHashMap);
            linkedHashMap.put(Float.valueOf(0.0f), qh());
            c.a aVar = new c.a() { // from class: com.tk.core.component.e.1
                @Override // com.tk.core.component.a.c.a
                public final void B(float f) {
                    e.this.aap.pR().rR();
                    linkedHashMap.put(Float.valueOf(f), e.this.qh());
                }

                @Override // com.tk.core.component.a.c.a
                public final void c(int i, float f, int i2) {
                    e.this.aap.pR().rR();
                    linkedHashMap.put(Float.valueOf(f), e.this.qh());
                    if (f == 0.0f) {
                        com.tk.core.component.a.c cVar2 = cVar;
                        if (cVar2 instanceof com.tk.core.component.a.e) {
                            ((com.tk.core.component.a.e) cVar2).qO();
                        }
                    }
                    if (f > e.this.aax) {
                        e eVar = e.this;
                        eVar.aay = i;
                        eVar.aax = f;
                        eVar.aaz = i2;
                        HashMap map = new HashMap();
                        map.putAll(e.this.style);
                        e.this.aaw.put(str, map);
                    }
                }
            };
            if (cVar instanceof com.tk.core.component.a.e) {
                com.tk.core.component.a.e eVar = (com.tk.core.component.a.e) cVar;
                eVar.qO();
                eVar.c(aVar);
                if (this.aay != this.aaz - 1) {
                    a(this.aaw.get(str));
                    this.aap.pR().rR();
                }
                if (this.aax != 1.0f) {
                    linkedHashMap.put(Float.valueOf(1.0f), qh());
                    return;
                }
                return;
            }
            cVar.a(aVar);
            cVar.b(aVar);
        }
    }

    public final void bl(String str) {
        com.tk.core.component.a.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = this.aau.get(str)) == null) {
            return;
        }
        cVar.bR(str);
        this.aau.remove(str);
        this.aav.remove(str);
        cVar.pM();
    }

    public final void pU() {
        if (this.aau.isEmpty()) {
            return;
        }
        for (Map.Entry<String, com.tk.core.component.a.c> entry : this.aau.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                entry.getValue().bN(entry.getKey());
            }
        }
    }

    public final void pV() {
        if (this.aau.isEmpty()) {
            return;
        }
        for (Map.Entry<String, com.tk.core.component.a.c> entry : this.aau.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                entry.getValue().bO(entry.getKey());
            }
        }
    }

    public final void pW() {
        try {
            Iterator<Map.Entry<String, com.tk.core.component.a.c>> it = this.aau.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, com.tk.core.component.a.c> next = it.next();
                com.tk.core.component.a.c value = next.getValue();
                value.bR(next.getKey());
                this.aav.remove(next.getKey());
                value.pM();
                it.remove();
            }
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    public final void a(String str, int i, float f, float f2) {
        new com.tk.core.component.a.b(this, str, i, f, f2).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void bm(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1217487446(0xffffffffb76e9daa, float:-1.42226145E-5)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1b
            r1 = 3178655(0x30809f, float:4.454244E-39)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "gone"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 1
            goto L26
        L1b:
            java.lang.String r0 = "hidden"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 0
            goto L26
        L25:
            r5 = -1
        L26:
            if (r5 == 0) goto L36
            if (r5 == r3) goto L32
            android.view.View r5 = r4.getView()
            r5.setVisibility(r2)
            return
        L32:
            r4.pZ()
            return
        L36:
            android.view.View r5 = r4.getView()
            r0 = 4
            r5.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.e.bm(java.lang.String):void");
    }

    public void A(Object obj) {
        Integer numValueOf;
        this.aam = false;
        if ((obj instanceof String) && (numValueOf = Integer.valueOf(r.a((String) obj, pP()))) != null) {
            qa().setBackgroundColor(numValueOf.intValue());
        }
    }

    public final void du(int i) {
        qa().setBackgroundColor(i);
    }

    public final void bn(String str) {
        String[] strArrSplit;
        this.aam = true;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split(",")) == null || strArrSplit.length < 3) {
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
                    iArr[i2] = r.a(strArrSplit2[0].trim(), pP());
                    fArr[i2] = Float.parseFloat(strArrSplit2[1]);
                    z = true;
                } else {
                    iArr[i - 1] = r.a(strTrim, pP());
                }
            }
            if (z) {
                qa().setBackgroundGradientColor(iIntValue, iArr, fArr);
            } else {
                qa().setBackgroundGradientColor(iIntValue, iArr, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void bo(String str) {
        this.aam = true;
        if (TextUtils.isEmpty(str) || !str.startsWith("linear-gradient")) {
            return;
        }
        try {
            String strTrim = str.replace("linear-gradient(", "").replace("deg", "").replace(")", "").trim();
            if (TextUtils.isEmpty(strTrim)) {
                return;
            }
            String[] strArrSplit = strTrim.split(",");
            if (strArrSplit.length >= 3) {
                int iIntValue = Double.valueOf(strArrSplit[0].trim()).intValue() % 360;
                int i = (iIntValue < 0 || iIntValue > 90) ? 450 - iIntValue : 90 - iIntValue;
                int[] iArr = new int[strArrSplit.length - 1];
                float[] fArr = new float[strArrSplit.length - 1];
                boolean z = false;
                for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                    String strTrim2 = strArrSplit[i2].trim();
                    if (strTrim2.contains(" ")) {
                        String[] strArrSplit2 = strTrim2.split(" ");
                        int i3 = i2 - 1;
                        iArr[i3] = r.a(strArrSplit2[0].trim(), pP());
                        fArr[i3] = Float.parseFloat(strArrSplit2[1].replace("%", "")) / 100.0f;
                        z = true;
                    } else {
                        int i4 = i2 - 1;
                        iArr[i4] = r.a(strTrim2, pP());
                        if (i2 == strArrSplit.length - 1) {
                            fArr[i4] = 1.0f;
                        } else {
                            fArr[i4] = 0.0f;
                        }
                    }
                }
                if (z) {
                    qa().setBackgroundGradientColor(i, iArr, fArr);
                } else {
                    qa().setBackgroundGradientColor(i, iArr, null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void w(float f) {
        getView().setRotationX(f);
    }

    public final void x(float f) {
        getView().setRotationY(f);
    }

    public final void setRotate(float f) {
        getView().setRotation(f);
    }

    public final void y(float f) {
        getView().setTranslationX(f);
    }

    public final void z(float f) {
        getView().setTranslationY(f);
    }

    public final void setScaleX(float f) {
        getView().setScaleX(f);
    }

    public final void setScaleY(float f) {
        getView().setScaleY(f);
    }

    public final void bf(String str) {
        qs().bf(str);
    }

    public final void bg(String str) {
        qs().bg(str);
    }

    public final void bp(String str) {
        com.tk.core.component.a aVarQs = qs();
        getJsObj();
        aVarQs.bh(str);
    }

    public void a(double d) {
        this.aar = d;
        int iP = o.P((float) d);
        if (qw()) {
            pR().getYogaNode().setBorder(YogaEdge.ALL, iP);
        }
        qa().setBorderWidth(8, iP);
    }

    public final void d(double d) {
        int iP = o.P((float) d);
        if (qw()) {
            pR().getYogaNode().setBorder(YogaEdge.LEFT, iP);
        }
        qa().setBorderWidth(0, iP);
    }

    public final void e(double d) {
        int iP = o.P((float) d);
        if (qw()) {
            pR().getYogaNode().setBorder(YogaEdge.TOP, iP);
        }
        qa().setBorderWidth(1, iP);
    }

    public final void f(double d) {
        int iP = o.P((float) d);
        if (qw()) {
            pR().getYogaNode().setBorder(YogaEdge.RIGHT, iP);
        }
        qa().setBorderWidth(2, iP);
    }

    public final void g(double d) {
        int iP = o.P((float) d);
        if (qw()) {
            pR().getYogaNode().setBorder(YogaEdge.BOTTOM, iP);
        }
        qa().setBorderWidth(3, iP);
    }

    public void aB(String str) {
        this.aaq = str;
        qa().setBorderColor(8, r.a(str, pP()));
    }

    public final void bq(String str) {
        qa().setBorderColor(0, r.a(str, pP()));
    }

    public final void br(String str) {
        qa().setBorderColor(1, r.a(str, pP()));
    }

    public final void bs(String str) {
        qa().setBorderColor(2, r.a(str, pP()));
    }

    public final void bt(String str) {
        qa().setBorderColor(3, r.a(str, pP()));
    }

    public void bY(int i) {
        this.mBorderRadius = o.eb(i);
        qa().setBorderRadius(this.mBorderRadius);
    }

    public void bZ(int i) {
        qa().c(o.eb(i), TKViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT.ordinal());
    }

    public final void dv(int i) {
        bZ(i);
    }

    public void ca(int i) {
        qa().c(o.eb(i), TKViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT.ordinal());
    }

    public final void dw(int i) {
        ca(i);
    }

    public void cc(int i) {
        qa().c(o.eb(i), TKViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT.ordinal());
    }

    public final void dx(int i) {
        cc(i);
    }

    public void cb(int i) {
        qa().c(o.eb(i), TKViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT.ordinal());
    }

    public final void dy(int i) {
        cb(i);
    }

    public final void bu(String str) {
        if (str == null) {
            return;
        }
        qa().setBorderStyle(8, str);
    }

    public final void bv(String str) {
        if (str == null) {
            return;
        }
        qa().setBorderStyle(0, str);
    }

    public final void bw(String str) {
        if (str == null) {
            return;
        }
        qa().setBorderStyle(1, str);
    }

    public final void bx(String str) {
        if (str == null) {
            return;
        }
        qa().setBorderStyle(2, str);
    }

    public final void by(String str) {
        if (str == null) {
            return;
        }
        qa().setBorderStyle(3, str);
    }

    public void bz(String str) {
        b(str, false);
    }

    public final void bA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("none".equals(str) && !TextUtils.isEmpty(this.aaP)) {
            b(this.aaP, true);
        } else {
            b(str, false);
        }
        this.aaP = str;
    }

    private void b(String str, boolean z) {
        String[] strArrSplit = str.split(" ");
        if (strArrSplit.length != 4) {
            this.aaO = false;
            return;
        }
        this.aaO = true;
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            if (strArrSplit[i].toLowerCase().contains("px")) {
                fArr[i] = Float.parseFloat(strArrSplit[i].replace("px", ""));
            } else {
                fArr[i] = o.P(Float.parseFloat(strArrSplit[i]));
            }
        }
        Integer numValueOf = Integer.valueOf(r.a(strArrSplit[3], pP()));
        if (numValueOf == null) {
            this.aaO = false;
            return;
        }
        int iIntValue = numValueOf.intValue();
        if (z) {
            fArr[2] = 0.0f;
        }
        qa().setShadow(fArr[2], fArr[0], fArr[1], iIntValue);
        qc();
    }

    public final void h(double d) {
        getView().setAlpha((float) d);
    }

    public final void e(HashMap map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.aaQ = map;
        float fFloatValue = this.aaR;
        float fFloatValue2 = this.aaS;
        Object obj = map.get("x");
        if (obj instanceof Number) {
            fFloatValue = ((Number) obj).floatValue();
        }
        Object obj2 = map.get("y");
        if (obj2 instanceof Number) {
            fFloatValue2 = ((Number) obj2).floatValue();
        }
        if (this.aaR == fFloatValue && this.aaS == fFloatValue2) {
            return;
        }
        this.aaR = fFloatValue;
        this.aaS = fFloatValue2;
        if (getView().getWidth() == 0 && getView().getHeight() == 0) {
            getView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tk.core.component.e.2
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    e.this.getView().removeOnLayoutChangeListener(this);
                    e.this.getView().setPivotX(e.this.aaR * (i3 - i));
                    e.this.getView().setPivotY(e.this.aaS * (i4 - i2));
                }
            });
        } else {
            getView().setPivotX(this.aaR * getView().getWidth());
            getView().setPivotY(this.aaS * getView().getHeight());
        }
    }

    public final Map<String, Object> pX() {
        HashMap map = new HashMap();
        map.put("x", Integer.valueOf(o.Q(getView().getX())));
        map.put("y", Integer.valueOf(o.Q(getView().getY())));
        return map;
    }

    public final Map<String, Object> pY() {
        getView().getLocationOnScreen(new int[2]);
        HashMap map = new HashMap();
        map.put("x", Float.valueOf(o.R(r0[0])));
        map.put("y", Float.valueOf(o.R(r0[1])));
        return map;
    }

    public final Map<String, Object> mM() {
        HashMap map = new HashMap();
        map.put("width", Integer.valueOf(o.ec(getView().getWidth())));
        map.put("height", Integer.valueOf(o.ec(getView().getHeight())));
        return map;
    }

    public final void pZ() {
        if (this.aao instanceof TKView) {
            try {
                this.aao.e(getJsObj());
            } finally {
                pM();
            }
        }
    }

    public final void a(V8Function v8Function, final boolean z) {
        if (v8Function == null) {
            return;
        }
        this.aaU = ad.retainJsValue(v8Function, this);
        if (this.aaU == null || this.aaT) {
            return;
        }
        this.aaT = true;
        getView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tk.core.component.e.3
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, final int i, final int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                e.this.getView().removeOnLayoutChangeListener(this);
                e.a(e.this, false);
                if (e.this.aaU == null || !ad.isV8Valid((V8Object) e.this.aaU.get())) {
                    return;
                }
                final int i9 = i3 - i;
                final int i10 = i4 - i2;
                if (z) {
                    e.this.getView().post(new Runnable() { // from class: com.tk.core.component.e.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (e.this.aaU == null || !ad.isV8Valid((V8Object) e.this.aaU.get()) || e.this.pN()) {
                                return;
                            }
                            try {
                                ((V8Function) e.this.aaU.get()).call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)), Integer.valueOf(o.ec(i9)), Integer.valueOf(o.ec(i10)));
                            } catch (Throwable th) {
                                com.tk.core.exception.a.a(e.this.pO(), th);
                            }
                            ad.unRetainJsValue(e.this.aaU);
                        }
                    });
                    return;
                }
                try {
                    ((V8Function) e.this.aaU.get()).call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)), Integer.valueOf(o.ec(i9)), Integer.valueOf(o.ec(i10)));
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(e.this.pO(), th);
                }
                ad.unRetainJsValue(e.this.aaU);
            }
        });
    }

    public final com.tk.core.component.view.d qa() {
        if (this.aae == null) {
            this.aae = new com.tk.core.component.view.d(getView(), pO());
        }
        return this.aae;
    }

    public final View qb() {
        Application application = com.tk.core.a.Yb;
        if (application == null) {
            return null;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        return n(application);
    }

    private T H(Context context) {
        Object objU;
        try {
            if (mJ() && (objU = com.tk.core.k.a.u(this)) != null) {
                return (T) objU;
            }
            return (T) n(context);
        } catch (Throwable th) {
            if (!this.aan) {
                com.tk.core.exception.a.a(pO(), th);
                return null;
            }
            com.tk.core.i.a.a("TKBaseView", "preload create component error", th);
            return null;
        }
    }

    private void qc() {
        qp();
    }

    private void qd() {
        qp();
    }

    protected final void f(HashMap map) {
        int paddingLeft;
        int paddingTop;
        int paddingRight;
        int paddingBottom;
        if (map == null || map.isEmpty()) {
            return;
        }
        boolean zContainsKey = map.containsKey("paddingLeft");
        boolean zContainsKey2 = map.containsKey("paddingTop");
        boolean zContainsKey3 = map.containsKey("paddingRight");
        boolean zContainsKey4 = map.containsKey("paddingBottom");
        if (zContainsKey || zContainsKey2 || zContainsKey3 || zContainsKey4) {
            if (zContainsKey) {
                paddingLeft = b(map, "paddingLeft");
            } else {
                paddingLeft = getView().getPaddingLeft();
            }
            if (zContainsKey2) {
                paddingTop = b(map, "paddingTop");
            } else {
                paddingTop = getView().getPaddingTop();
            }
            if (zContainsKey3) {
                paddingRight = b(map, "paddingRight");
            } else {
                paddingRight = getView().getPaddingRight();
            }
            if (zContainsKey4) {
                paddingBottom = b(map, "paddingBottom");
            } else {
                paddingBottom = getView().getPaddingBottom();
            }
            getView().setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            map.remove("paddingLeft");
            map.remove("paddingRight");
            map.remove("paddingTop");
            map.remove("paddingBottom");
        }
    }

    protected final boolean dz(int i) {
        int i2 = this.aak;
        return (i2 == 0 || (i & i2) == 0) ? false : true;
    }

    protected final boolean qe() {
        if (qf()) {
            return false;
        }
        return dz(2) || dz(1) || dz(32) || dz(64) || dz(8) || dz(4) || dz(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qf() {
        return this.aak == 2;
    }

    private void dA(int i) {
        this.aak = i | this.aak;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static int bB(java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            r0 = -1
            int r2 = r6.hashCode()
            r3 = 4
            r4 = 1
            r5 = 2
            switch(r2) {
                case 3739: goto L50;
                case 110749: goto L46;
                case 114595: goto L3c;
                case 3089570: goto L32;
                case 106671290: goto L28;
                case 109854522: goto L1e;
                case 114203431: goto L14;
                default: goto L13;
            }
        L13:
            goto L5a
        L14:
            java.lang.String r2 = "longPress"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L5a
            r6 = 1
            goto L5b
        L1e:
            java.lang.String r2 = "swipe"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L5a
            r6 = 6
            goto L5b
        L28:
            java.lang.String r2 = "pinch"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L5a
            r6 = 5
            goto L5b
        L32:
            java.lang.String r2 = "down"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L5a
            r6 = 2
            goto L5b
        L3c:
            java.lang.String r2 = "tap"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L5a
            r6 = 0
            goto L5b
        L46:
            java.lang.String r2 = "pan"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L5a
            r6 = 4
            goto L5b
        L50:
            java.lang.String r2 = "up"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L5a
            r6 = 3
            goto L5b
        L5a:
            r6 = -1
        L5b:
            switch(r6) {
                case 0: goto L6d;
                case 1: goto L6c;
                case 2: goto L69;
                case 3: goto L66;
                case 4: goto L63;
                case 5: goto L62;
                case 6: goto L5f;
                default: goto L5e;
            }
        L5e:
            return r1
        L5f:
            r6 = 16
            return r6
        L62:
            return r3
        L63:
            r6 = 8
            return r6
        L66:
            r6 = 64
            return r6
        L69:
            r6 = 32
            return r6
        L6c:
            return r4
        L6d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.e.bB(java.lang.String):int");
    }

    private void dB(int i) {
        this.aak &= i ^ (-1);
        if (i == 2) {
            getView().setOnClickListener(null);
            this.aal = false;
        } else if (i == 1 && this.aaf != null && qx()) {
            this.aaf.setIsLongpressEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qg() {
        if (this.aat) {
            return true;
        }
        return (this.aak == 0 || qf()) ? false : true;
    }

    public final void a(String str, b.a aVar) {
        List<JsValueRef<V8Function>> list = this.aaj.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        com.tk.core.e.b.a(list, str, pP(), aVar);
    }

    public final boolean b(String str, b.a aVar) {
        List<JsValueRef<V8Function>> list = this.aaj.get(str);
        if (list != null && !list.isEmpty()) {
            com.tk.core.e.b.a(list, str, pO().pj(), aVar);
        }
        return true;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    protected void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            nj();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.core.component.e.4
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.nj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj() {
        this.aaj.clear();
        this.aak = 0;
        this.aai = false;
        this.aaf = null;
        this.aag = null;
        pW();
        this.aad.reset();
        HashMap map = this.style;
        if (map != null) {
            map.clear();
        }
        HashMap<Integer, Object> map2 = this.aaD;
        if (map2 != null) {
            map2.clear();
        }
        HashMap map3 = this.aaE;
        if (map3 != null) {
            map3.clear();
        }
        this.aaL = null;
        com.tk.core.component.view.d dVar = this.aae;
        if (dVar != null) {
            dVar.destroy();
        }
        com.tk.core.component.a aVar = this.aaA;
        if (aVar != null) {
            getJsObj();
            aVar.pI();
            this.aaA = null;
        }
        HashMap map4 = this.aaQ;
        if (map4 != null) {
            map4.clear();
        }
        T t = this.uS;
        if ((t instanceof ListView) || t == null) {
            return;
        }
        t.setOnClickListener(null);
        this.uS.setTag(null);
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public void ih() {
        super.ih();
        Iterator<Map.Entry<String, List<JsValueRef<V8Function>>>> it = this.aaj.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<JsValueRef<V8Function>> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                ad.unRetainJsValue(it2.next());
            }
        }
        ad.unRetainJsValue(this.aaL);
        ad.unRetainJsValue(this.aaI);
        ad.unRetainJsValue(this.aaK);
        ad.unRetainJsValue(this.aaU);
    }

    private T I(Context context) {
        return (T) H(context);
    }

    private void g(Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        Object obj = map.get("scale");
        if (obj instanceof Map) {
            Map map2 = (Map) obj;
            Object obj2 = map2.get("x");
            if (obj2 instanceof Number) {
                setScaleX(((Number) obj2).floatValue());
            }
            Object obj3 = map2.get("y");
            if (obj3 instanceof Number) {
                setScaleY(((Number) obj3).floatValue());
            }
        } else if (obj instanceof Number) {
            Number number = (Number) obj;
            setScaleX(number.floatValue());
            setScaleY(number.floatValue());
        }
        Object obj4 = map.get(j.a);
        if (obj4 instanceof Map) {
            Map map3 = (Map) obj4;
            if (map3.get("x") instanceof Number) {
                y(o.P(((Number) r1).floatValue()));
            }
            if (map3.get("y") instanceof Number) {
                z(o.P(((Number) r0).floatValue()));
            }
        } else if (obj4 instanceof Number) {
            float fP = o.P(((Number) obj4).floatValue());
            y(fP);
            z(fP);
        }
        Object obj5 = map.get("rotate");
        if (obj5 instanceof Map) {
            Map map4 = (Map) obj5;
            Object obj6 = map4.get("x");
            if (obj6 instanceof Number) {
                w(((Number) obj6).floatValue());
            }
            Object obj7 = map4.get("y");
            if (obj7 instanceof Number) {
                x(((Number) obj7).floatValue());
            }
            Object obj8 = map4.get("z");
            if (obj8 instanceof Number) {
                setRotate(((Number) obj8).floatValue());
            }
        } else if (obj5 instanceof Number) {
            setRotate(((Number) obj5).floatValue());
        }
        Object obj9 = map.get("perspective");
        if (obj9 instanceof Number) {
            u(((Number) obj9).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> qh() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("translationX", Float.valueOf(this.uS.getTranslationX()));
        map.put("translationY", Float.valueOf(this.uS.getTranslationY()));
        map.put("scaleX", Float.valueOf(this.uS.getScaleX()));
        map.put("scaleY", Float.valueOf(this.uS.getScaleY()));
        map.put("rotationX", Float.valueOf(this.uS.getRotationX()));
        map.put("rotationY", Float.valueOf(this.uS.getRotationY()));
        map.put("rotation", Float.valueOf(this.uS.getRotation()));
        map.put("alpha", Float.valueOf(qi()));
        Drawable background = this.uS.getBackground();
        if (background instanceof TKViewBackgroundDrawable) {
            map.put(com.baidu.mobads.container.n.f.T, Integer.valueOf(((TKViewBackgroundDrawable) background).getColor()));
        } else if (background instanceof ColorDrawable) {
            map.put(com.baidu.mobads.container.n.f.T, Integer.valueOf(((ColorDrawable) background).getColor()));
        }
        if (pR().getYogaNode() != null) {
            map.put("width", pR().getYogaNode().getWidth());
            map.put("height", pR().getYogaNode().getHeight());
            map.put("margin", Float.valueOf(a("margin", YogaEdge.ALL)));
            map.put("marginLeft", Float.valueOf(a("marginLeft", YogaEdge.LEFT)));
            map.put("marginRight", Float.valueOf(a("marginRight", YogaEdge.RIGHT)));
            map.put("marginTop", Float.valueOf(a("marginTop", YogaEdge.TOP)));
            map.put("marginBottom", Float.valueOf(a("marginBottom", YogaEdge.BOTTOM)));
            map.put("padding", Float.valueOf(a("padding", YogaEdge.ALL)));
            map.put("paddingLeft", Float.valueOf(a("paddingLeft", YogaEdge.LEFT)));
            map.put("paddingRight", Float.valueOf(a("paddingRight", YogaEdge.RIGHT)));
            map.put("paddingTop", Float.valueOf(a("paddingTop", YogaEdge.TOP)));
            map.put("paddingBottom", Float.valueOf(a("paddingBottom", YogaEdge.BOTTOM)));
            map.put("paddingStart", Float.valueOf(a("paddingStart", YogaEdge.START)));
            map.put("paddingEnd", Float.valueOf(a("paddingEnd", YogaEdge.END)));
            map.put("paddingVertical", Float.valueOf(a("paddingVertical", YogaEdge.VERTICAL)));
            map.put("paddingHorizontal", Float.valueOf(a("paddingHorizontal", YogaEdge.HORIZONTAL)));
            map.put(j.d, Float.valueOf(a(j.d, YogaEdge.LEFT)));
            map.put(j.f, Float.valueOf(a(j.f, YogaEdge.TOP)));
        }
        return map;
    }

    private float qi() {
        if (this.style.containsKey("opacity")) {
            Object obj = this.style.get("opacity");
            if (obj instanceof Number) {
                return ((Number) obj).floatValue();
            }
        }
        return this.uS.getAlpha();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private float a(String str, YogaEdge yogaEdge) {
        if (this.style.containsKey(str)) {
            if (this.style.get(str) instanceof Number) {
                return o.P(((Number) r0).floatValue());
            }
        }
        com.kwad.yoga.e margin = null;
        char c = 65535;
        switch (str.hashCode()) {
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c = 6;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    c = 0;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    c = 2;
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    c = 5;
                    break;
                }
                break;
            case -359890155:
                if (str.equals("paddingHorizontal")) {
                    c = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    c = 4;
                    break;
                }
                break;
            case 115029:
                if (str.equals(j.f)) {
                    c = 15;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(j.d)) {
                    c = 14;
                    break;
                }
                break;
            case 90115850:
                if (str.equals("paddingEnd")) {
                    c = 11;
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c = '\b';
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c = '\t';
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c = 7;
                    break;
                }
                break;
            case 715094737:
                if (str.equals("paddingStart")) {
                    c = '\n';
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    c = 3;
                    break;
                }
                break;
            case 1343645351:
                if (str.equals("paddingVertical")) {
                    c = '\f';
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                margin = pR().getYogaNode().getMargin(yogaEdge);
                break;
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
                margin = pR().getYogaNode().getPadding(yogaEdge);
                break;
            case 14:
            case 15:
                margin = pR().getYogaNode().getPosition(yogaEdge);
                break;
        }
        if (margin == null || margin.Gg == YogaUnit.UNDEFINED) {
            return 0.0f;
        }
        return margin.value;
    }

    private void bC(String str) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        qm();
        if (bD(str)) {
            qn();
        }
        if (bF(str)) {
            qo();
            if (bE(str) && this.aaf != null && qx()) {
                this.aaf.setIsLongpressEnabled(true);
                return;
            }
            return;
        }
        if (bG(str)) {
            qj();
        }
    }

    private void qj() {
        if (this.aal) {
            return;
        }
        getView().setOnClickListener(new AnonymousClass5());
        this.aal = true;
    }

    /* renamed from: com.tk.core.component.e$5, reason: invalid class name */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (e.this.qf()) {
                e.this.a("tap", new AnonymousClass1());
            }
        }

        /* renamed from: com.tk.core.component.e$5$1, reason: invalid class name */
        final class AnonymousClass1 implements b.a {
            AnonymousClass1() {
            }

            @Override // com.tk.core.e.b.a
            public final void a(com.tk.core.e.a.b bVar) {
                if (bVar instanceof l) {
                    l lVar = (l) bVar;
                    lVar.bX("tap");
                    if (e.this.aah != null) {
                        final PointF pointFJ = e.this.j(e.this.aah);
                        lVar.n(new HashMap<String, Object>() { // from class: com.tk.core.component.TKBaseView$5$1$1
                            {
                                put("x", Float.valueOf(o.R(e.this.aah.getX())));
                                put("y", Float.valueOf(o.R(e.this.aah.getY())));
                                put("rawX", Float.valueOf(o.R(e.this.aah.getRawX())));
                                put("rawY", Float.valueOf(o.R(e.this.aah.getRawY())));
                                PointF pointF = pointFJ;
                                if (pointF != null) {
                                    put("rootX", Float.valueOf(o.R(pointF.x)));
                                    put("rootY", Float.valueOf(o.R(pointFJ.y)));
                                } else {
                                    put("rootX", Float.valueOf(0.0f));
                                    put("rootY", Float.valueOf(0.0f));
                                }
                            }
                        });
                        lVar.setState(com.tk.core.e.a.a.m(e.this.aah));
                    } else {
                        lVar.n(new HashMap<String, Object>() { // from class: com.tk.core.component.TKBaseView$5$1$2
                            {
                                Float fValueOf = Float.valueOf(0.0f);
                                put("x", fValueOf);
                                put("y", fValueOf);
                                put("rawX", fValueOf);
                                put("rawY", fValueOf);
                                put("rootX", fValueOf);
                                put("rootY", fValueOf);
                            }
                        });
                        lVar.setState(com.tk.core.e.a.a.m(null));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dC(int i) {
        if ((this instanceof q) && ((q) this).agq && this.aah != null && (getView() instanceof TextView)) {
            TextView textView = (TextView) getView();
            MotionEvent motionEvent = this.aah;
            CharSequence text = textView.getText();
            if (!(text instanceof Spanned)) {
                return false;
            }
            Spanned spanned = (Spanned) text;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int totalPaddingLeft = x - textView.getTotalPaddingLeft();
            int totalPaddingTop = y - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            ClickableSpan[] clickableSpanArr = null;
            try {
                int lineForVertical = layout.getLineForVertical(scrollY);
                float lineRight = layout.getLineRight(lineForVertical);
                float lineBottom = layout.getLineBottom(lineForVertical);
                float f = scrollX;
                if (f <= lineRight && scrollY <= lineBottom) {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
                    int i2 = f > layout.getPrimaryHorizontal(offsetForHorizontal) ? offsetForHorizontal + 1 : offsetForHorizontal - 1;
                    clickableSpanArr = (ClickableSpan[]) spanned.getSpans(i2, i2, ClickableSpan.class);
                }
                if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                    if (i == 1) {
                        clickableSpanArr[0].onClick(textView);
                    }
                    return true;
                }
            } catch (Throwable th) {
                com.tk.core.i.a.a("TKBaseView", "movementConsume exception", th);
            }
        }
        return false;
    }

    private PointF qk() {
        if (this.aab == null) {
            this.aab = new PointF();
        }
        return this.aab;
    }

    private static int[] ql() {
        if (aaa == null) {
            aaa = new int[2];
        }
        return aaa;
    }

    public final PointF j(MotionEvent motionEvent) {
        TKView tKViewPt;
        if (motionEvent == null || (tKViewPt = pO().pt()) == null) {
            return null;
        }
        int[] iArrQl = ql();
        tKViewPt.getView().getLocationOnScreen(iArrQl);
        int i = iArrQl[0];
        int i2 = iArrQl[1];
        getView().getLocationOnScreen(iArrQl);
        int i3 = iArrQl[0];
        int i4 = iArrQl[1];
        PointF pointFQk = qk();
        pointFQk.x = (i3 - i) + motionEvent.getX();
        pointFQk.y = (i4 - i2) + motionEvent.getY();
        return pointFQk;
    }

    private static boolean bD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("pinch");
    }

    private static boolean bE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("longPress");
    }

    private boolean bF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return qx() ? str.equals("pan") || str.equals("longPress") || str.equals("down") || str.equals("up") || str.equals("pinch") || str.equals("swipe") : str.equals("pan") || str.equals("swipe") || str.equals("down") || str.equals("up") || str.equals("longPress");
    }

    private static boolean bG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("tap");
    }

    protected final void qm() {
        if (this.aai) {
            return;
        }
        this.aai = true;
        getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.tk.core.component.e.6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                e.this.aah = motionEvent;
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 1 || actionMasked == 3) {
                    if (actionMasked == 1 && e.this.qf()) {
                        e.this.aah = MotionEvent.obtain(motionEvent);
                    }
                    if (e.this.dz(64)) {
                        e.this.a("up", new AnonymousClass1(motionEvent));
                    }
                }
                if (e.this.aag != null && e.this.dz(4)) {
                    e.this.aag.onTouchEvent(motionEvent);
                }
                if (e.this.aaf != null && e.this.qe()) {
                    e.this.aaf.onTouchEvent(motionEvent);
                }
                if (actionMasked == 0 || actionMasked == 1) {
                    if (e.this.aas) {
                        e.this.aas = false;
                    } else {
                        e eVar = e.this;
                        eVar.aat = eVar.dC(actionMasked);
                    }
                }
                return e.this.qg();
            }

            /* renamed from: com.tk.core.component.e$6$1, reason: invalid class name */
            final class AnonymousClass1 implements b.a {
                final /* synthetic */ MotionEvent abf;

                AnonymousClass1(MotionEvent motionEvent) {
                    this.abf = motionEvent;
                }

                @Override // com.tk.core.e.b.a
                public final void a(com.tk.core.e.a.b bVar) {
                    bVar.bX("up");
                    bVar.setState(com.tk.core.e.a.a.m(this.abf));
                    bVar.n(new HashMap<String, Object>() { // from class: com.tk.core.component.TKBaseView$6$1$1
                        {
                            put("x", Float.valueOf(o.R(this.this$2.abf.getX())));
                            put("y", Float.valueOf(o.R(this.this$2.abf.getY())));
                            put("rawX", Float.valueOf(o.R(this.this$2.abf.getRawX())));
                            put("rawY", Float.valueOf(o.R(this.this$2.abf.getRawY())));
                        }
                    });
                }
            }
        });
    }

    private void qn() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (this.aag != null) {
            return;
        }
        this.aag = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.tk.core.component.e.7

            /* renamed from: com.tk.core.component.e$7$1, reason: invalid class name */
            final class AnonymousClass1 implements b.a {
                final /* synthetic */ float abh;

                AnonymousClass1(float f) {
                    this.abh = f;
                }

                @Override // com.tk.core.e.b.a
                public final void a(com.tk.core.e.a.b bVar) {
                    bVar.bX("pinch");
                    bVar.setState(com.tk.core.e.a.a.m(e.this.aah));
                    bVar.n(new HashMap<String, Object>() { // from class: com.tk.core.component.TKBaseView$7$1$1
                        {
                            put("scale", Float.valueOf(this.this$2.abh));
                        }
                    });
                }
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                e.this.a("pinch", new AnonymousClass1(scaleGestureDetector.getScaleFactor()));
                return true;
            }
        });
        try {
            Field declaredField = this.aag.getClass().getDeclaredField("mMinSpan");
            declaredField.setAccessible(true);
            declaredField.set(this.aag, 20);
        } catch (Exception e) {
            com.tk.core.i.a.a("TKBaseView", e.getMessage(), null);
        }
    }

    private void qo() {
        if (getView() != null && this.aaf == null) {
            this.aaf = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: com.tk.core.component.e.8
                @Override // android.view.GestureDetector.OnGestureListener
                public final void onShowPress(MotionEvent motionEvent) {
                }

                /* renamed from: com.tk.core.component.e$8$1, reason: invalid class name */
                final class AnonymousClass1 implements b.a {
                    final /* synthetic */ MotionEvent abj;

                    AnonymousClass1(MotionEvent motionEvent) {
                        this.abj = motionEvent;
                    }

                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        bVar.bX("down");
                        bVar.setState(com.tk.core.e.a.a.m(this.abj));
                        bVar.n(new HashMap<String, Object>() { // from class: com.tk.core.component.TKBaseView$8$1$1
                            {
                                put("x", Float.valueOf(o.R(this.this$2.abj.getX())));
                                put("y", Float.valueOf(o.R(this.this$2.abj.getY())));
                                put("rawX", Float.valueOf(o.R(this.this$2.abj.getRawX())));
                                put("rawY", Float.valueOf(o.R(this.this$2.abj.getRawY())));
                            }
                        });
                    }
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onDown(MotionEvent motionEvent) {
                    if (!e.this.dz(32)) {
                        return true;
                    }
                    e.this.a("down", new AnonymousClass1(motionEvent));
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onSingleTapUp(MotionEvent motionEvent) {
                    if (e.this.dz(2)) {
                        if (e.this.aat) {
                            e.this.aat = false;
                            return false;
                        }
                        e.this.a("tap", new AnonymousClass2(motionEvent));
                    }
                    return false;
                }

                /* renamed from: com.tk.core.component.e$8$2, reason: invalid class name */
                final class AnonymousClass2 implements b.a {
                    final /* synthetic */ MotionEvent abj;

                    AnonymousClass2(MotionEvent motionEvent) {
                        this.abj = motionEvent;
                    }

                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        bVar.bX("tap");
                        bVar.setState(com.tk.core.e.a.a.m(this.abj));
                        final PointF pointFJ = e.this.j(this.abj);
                        bVar.n(new HashMap<String, Object>() { // from class: com.tk.core.component.TKBaseView$8$2$1
                            {
                                put("x", Float.valueOf(o.R(this.this$2.abj.getX())));
                                put("y", Float.valueOf(o.R(this.this$2.abj.getY())));
                                put("rawX", Float.valueOf(o.R(this.this$2.abj.getRawX())));
                                put("rawY", Float.valueOf(o.R(this.this$2.abj.getRawY())));
                                PointF pointF = pointFJ;
                                if (pointF != null) {
                                    put("rootX", Float.valueOf(o.R(pointF.x)));
                                    put("rootY", Float.valueOf(o.R(pointFJ.y)));
                                } else {
                                    put("rootX", Float.valueOf(0.0f));
                                    put("rootY", Float.valueOf(0.0f));
                                }
                            }
                        });
                    }
                }

                /* renamed from: com.tk.core.component.e$8$3, reason: invalid class name */
                final class AnonymousClass3 implements b.a {
                    final /* synthetic */ MotionEvent abl;
                    final /* synthetic */ MotionEvent abm;
                    final /* synthetic */ float abn;
                    final /* synthetic */ float abo;

                    AnonymousClass3(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                        this.abl = motionEvent;
                        this.abm = motionEvent2;
                        this.abn = f;
                        this.abo = f2;
                    }

                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (this.abl == null || this.abm == null) {
                            return;
                        }
                        bVar.bX("pan");
                        MotionEvent motionEvent = this.abl;
                        if (motionEvent == null) {
                            com.tk.core.bridge.b bVarPO = e.this.pO();
                            StringBuilder sb = new StringBuilder("Down event is null and e2 action = ");
                            MotionEvent motionEvent2 = this.abm;
                            sb.append(motionEvent2 == null ? "unknown" : Integer.valueOf(motionEvent2.getAction()));
                            com.tk.core.exception.a.a(bVarPO, new IllegalArgumentException(sb.toString()));
                        } else if (motionEvent.getAction() == 0) {
                            bVar.setState(1);
                        }
                        if (this.abm.getAction() == 1) {
                            bVar.setState(3);
                        } else if (this.abm.getAction() == 3) {
                            bVar.setState(4);
                        }
                        bVar.n(new HashMap<String, Object>() { // from class: com.tk.core.component.TKBaseView$8$3$1
                            {
                                put("deltaX", Integer.valueOf(o.Q(-this.this$2.abn)));
                                put("deltaY", Integer.valueOf(o.Q(-this.this$2.abo)));
                                put("rawX", Float.valueOf(o.R(this.this$2.abm.getRawX())));
                                put("rawY", Float.valueOf(o.R(this.this$2.abm.getRawY())));
                            }
                        });
                    }
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (!e.this.dz(8)) {
                        return true;
                    }
                    e.this.a("pan", new AnonymousClass3(motionEvent, motionEvent2, f, f2));
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final void onLongPress(MotionEvent motionEvent) {
                    if (e.this.dz(1)) {
                        e.this.aas = true;
                        e.this.qt();
                        e.this.a("longPress", new AnonymousClass4(motionEvent));
                    }
                }

                /* renamed from: com.tk.core.component.e$8$4, reason: invalid class name */
                final class AnonymousClass4 implements b.a {
                    final /* synthetic */ MotionEvent abj;

                    AnonymousClass4(MotionEvent motionEvent) {
                        this.abj = motionEvent;
                    }

                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        bVar.bX("longPress");
                        bVar.setState(com.tk.core.e.a.a.m(this.abj));
                        final PointF pointFJ = e.this.j(this.abj);
                        bVar.n(new HashMap<String, Object>() { // from class: com.tk.core.component.TKBaseView$8$4$1
                            {
                                put("x", Float.valueOf(o.R(this.this$2.abj.getX())));
                                put("y", Float.valueOf(o.R(this.this$2.abj.getY())));
                                put("rawX", Float.valueOf(o.R(this.this$2.abj.getRawX())));
                                put("rawY", Float.valueOf(o.R(this.this$2.abj.getRawY())));
                                PointF pointF = pointFJ;
                                if (pointF != null) {
                                    put("rootX", Float.valueOf(o.R(pointF.x)));
                                    put("rootY", Float.valueOf(o.R(pointFJ.y)));
                                } else {
                                    put("rootX", Float.valueOf(0.0f));
                                    put("rootY", Float.valueOf(0.0f));
                                }
                            }
                        });
                    }
                }

                /* renamed from: com.tk.core.component.e$8$5, reason: invalid class name */
                final class AnonymousClass5 implements b.a {
                    final /* synthetic */ MotionEvent abl;
                    final /* synthetic */ MotionEvent abm;
                    final /* synthetic */ float abp;
                    final /* synthetic */ float abq;

                    AnonymousClass5(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                        this.abl = motionEvent;
                        this.abm = motionEvent2;
                        this.abp = f;
                        this.abq = f2;
                    }

                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (this.abl == null || this.abm == null) {
                            return;
                        }
                        bVar.bX("swipe");
                        bVar.setState(2);
                        if (this.abl.getAction() == 0) {
                            bVar.setState(1);
                        }
                        if (this.abm.getAction() == 1) {
                            bVar.setState(3);
                        } else if (this.abm.getAction() == 3) {
                            bVar.setState(4);
                        }
                        bVar.n(new HashMap<String, Object>() { // from class: com.tk.core.component.TKBaseView$8$5$1
                            {
                                put("beginX", Float.valueOf(o.R(this.this$2.abl.getX())));
                                put("beginY", Float.valueOf(o.R(this.this$2.abl.getY())));
                                put("endX", Float.valueOf(o.R(this.this$2.abm.getX())));
                                put("endY", Float.valueOf(o.R(this.this$2.abm.getY())));
                                put("velocityX", Float.valueOf(o.R(this.this$2.abp)));
                                put("velocityY", Float.valueOf(o.R(this.this$2.abq)));
                            }
                        });
                    }
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (!e.this.dz(16)) {
                        return false;
                    }
                    e.this.a("swipe", new AnonymousClass5(motionEvent, motionEvent2, f, f2));
                    return false;
                }
            });
            if (qx()) {
                this.aaf.setIsLongpressEnabled(dz(1));
            }
        }
    }

    private void aO(View view) {
        while (view != null) {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            view = (View) parent;
            Object tag = view.getTag(a.b.tk_node);
            if (tag instanceof e) {
                this.aap = (e) tag;
            }
        }
    }

    private void a(HashMap map, String str) {
        if (map == null || map.isEmpty() || com.tk.core.a.oP().oV().a(str, this, map) <= 0) {
            return;
        }
        this.aaF++;
    }

    private static int b(HashMap map, String str) {
        if (map != null && !TextUtils.isEmpty(str)) {
            try {
                if (map.containsKey(str)) {
                    return o.eb(((Number) map.get(str)).intValue());
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private void qp() {
        TKView tKView;
        if (!this.aaO || (tKView = this.aao) == null) {
            return;
        }
        f view = tKView.getView();
        if (view instanceof ViewGroup) {
            f fVar = view;
            fVar.setClipChildren(false);
            fVar.setClipToPadding(false);
        }
    }

    public final void a(a aVar) {
        this.aaV = aVar;
    }

    public final void d(String str, String str2, V8Function v8Function) {
        e(str, str2, v8Function);
    }

    public final Object e(String str, String str2, V8Function v8Function) {
        b.a.C0817a c0817aPv;
        if (this.aaV == null && (c0817aPv = pO().ps().pv()) != null) {
            this.aaV = c0817aPv.Zp;
        }
        if (this.aaV == null) {
            if (this.aap == null) {
                aO(getView());
            }
            e eVar = this.aap;
            if (eVar != null) {
                this.aaV = eVar.aaV;
            }
        }
        a aVar = this.aaV;
        if (aVar != null) {
            return aVar.onJSInvokeNativeWithJSONString(str, str2, v8Function);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r6, java.lang.String r7, com.tkruntime.v8.JavaCallback r8) {
        /*
            r5 = this;
            com.tkruntime.v8.V8Object r0 = r5.pL()
            boolean r1 = com.tk.core.o.ad.isV8Valid(r0)
            r2 = 0
            if (r1 != 0) goto Lc
            return r2
        Lc:
            if (r8 == 0) goto L1f
            com.tkruntime.v8.V8Function r1 = new com.tkruntime.v8.V8Function     // Catch: java.lang.Throwable -> L1c
            com.tk.core.bridge.a r3 = r5.pP()     // Catch: java.lang.Throwable -> L1c
            com.tkruntime.v8.V8 r3 = r3.pi()     // Catch: java.lang.Throwable -> L1c
            r1.<init>(r3, r8)     // Catch: java.lang.Throwable -> L1c
            goto L20
        L1c:
            r7 = move-exception
            r1 = r2
            goto L53
        L1f:
            r1 = r2
        L20:
            r8 = 0
            r3 = 1
            if (r1 == 0) goto L30
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L52
            r4[r8] = r7     // Catch: java.lang.Throwable -> L52
            r4[r3] = r1     // Catch: java.lang.Throwable -> L52
            java.lang.Object r7 = r0.executeFunction(r6, r4)     // Catch: java.lang.Throwable -> L52
            goto L38
        L30:
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L52
            r3[r8] = r7     // Catch: java.lang.Throwable -> L52
            java.lang.Object r7 = r0.executeFunction(r6, r3)     // Catch: java.lang.Throwable -> L52
        L38:
            boolean r8 = r7 instanceof com.tkruntime.v8.V8JSONProxy     // Catch: java.lang.Throwable -> L52
            if (r8 == 0) goto L48
            com.tkruntime.v8.V8JSONProxy r7 = (com.tkruntime.v8.V8JSONProxy) r7     // Catch: java.lang.Throwable -> L52
            java.lang.Object r6 = r7.getNativeObject()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L47
            r1.setWeak()
        L47:
            return r6
        L48:
            java.lang.Object r6 = com.tkruntime.v8.utils.V8ObjectUtilsQuick.getValue(r7)     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L51
            r1.setWeak()
        L51:
            return r6
        L52:
            r7 = move-exception
        L53:
            com.tk.core.bridge.b r8 = r5.pO()     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = "invokeJSFunctionWithJSONString fail，function name is "
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L8d
            r0.append(r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L8d
            com.tk.core.exception.a.a(r8, r7, r0)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r8 = "TKBaseView"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = "invokeJSFunctionWithJSONString exception: "
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L8d
            r0.append(r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = ", "
            r0.append(r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = android.util.Log.getStackTraceString(r7)     // Catch: java.lang.Throwable -> L8d
            r0.append(r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L8d
            com.tk.core.i.a.z(r8, r6)     // Catch: java.lang.Throwable -> L8d
            if (r1 == 0) goto L8c
            r1.setWeak()
        L8c:
            return r2
        L8d:
            r6 = move-exception
            if (r1 == 0) goto L93
            r1.setWeak()
        L93:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.e.a(java.lang.String, java.lang.String, com.tkruntime.v8.JavaCallback):java.lang.Object");
    }

    public final e qq() {
        return this.aao;
    }

    public boolean bH(String str) {
        if (str.length() == 15) {
            if (this.aam && com.baidu.mobads.container.n.f.T.equals(str)) {
                return true;
            }
            if (!this.aam && "gradientBgColor".equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tkruntime.v8.DomExecutor
    public boolean isAttachedToRoot() {
        return this.aaW;
    }

    public void attachToRoot() {
        this.aaW = true;
    }

    public void detachToRoot() {
        this.aaW = false;
    }

    @Override // com.tkruntime.v8.DomExecutor
    public void addCmdRunner(V8.CommandRunner commandRunner) {
        commandRunner.exec(pP().pi());
    }

    public final void A(float f) {
        g.p(getView(), Math.round(f));
        ViewParent parent = getView().getParent();
        if (parent instanceof d) {
            ((d) parent).pK();
        }
    }

    private com.tk.core.component.a qs() {
        if (this.aaA == null) {
            this.aaA = new com.tk.core.component.a(pO(), qa());
        }
        return this.aaA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt() {
        if ((this instanceof q) && ((q) this).agu && (getView() instanceof TextView)) {
            ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("copyText", ((TextView) getView()).getText()));
            Toast toastMakeText = Toast.makeText(getContext(), (CharSequence) null, 0);
            toastMakeText.setText("复制成功");
            toastMakeText.setGravity(17, 0, 0);
            toastMakeText.show();
        }
    }

    public final MotionEvent qu() {
        return this.aah;
    }

    public static boolean qv() {
        if (ZY == null && com.tk.core.a.oP().getTKSwitch() != null) {
            ZY = Boolean.valueOf(com.tk.core.a.oP().getTKSwitch().oY());
            com.tk.core.i.a.z("TKBaseView", "isOpenComponentSwitch " + ZY);
        }
        return ZY != null && ZY.booleanValue();
    }

    protected final boolean qw() {
        Object globalNativeObject = pO().getGlobalNativeObject("KDSFeature");
        if (globalNativeObject instanceof com.tk.core.f.a) {
            return ((com.tk.core.f.a) globalNativeObject).cz("borderWidthFactor");
        }
        return false;
    }

    private static boolean qx() {
        if (aac == null && com.tk.core.a.oP().getTKSwitch() != null) {
            aac = Boolean.valueOf(com.tk.core.a.oP().getTKSwitch().oY());
        }
        Boolean bool = aac;
        return bool == null || bool.booleanValue();
    }
}
