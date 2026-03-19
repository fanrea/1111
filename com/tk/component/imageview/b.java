package com.tk.component.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import com.kuaishou.tk.api.export.sdk.Callback;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.framework.tachikoma.a;
import com.kwad.yoga.YogaEdge;
import com.tk.component.imageview.model.TKCDNUrl;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tk.core.o.p;
import com.tk.core.o.y;
import com.tk.core.o.z;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends com.tk.core.component.e<ImageView> implements Handler.Callback {
    public boolean GH;
    private JsValueRef<V8Function> QA;
    private JsValueRef<V8Function> QB;
    private JsValueRef<V8Function> QC;
    private JsValueRef<V8Function> QD;
    private JsValueRef<V8Function> QE;
    private int QF;
    private long QG;
    private boolean QH;

    @Deprecated
    public String QI;
    public String QJ;
    private String QK;
    private JSONArray QL;
    private String QM;
    private String QN;
    private List<BitmapDrawable> Qs;
    private int Qt;
    private int Qu;
    private long Qv;
    private int Qw;
    private int Qx;
    private boolean Qy;
    public boolean Qz;
    private Handler mHandler;

    public static void preload() {
    }

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return true;
    }

    static /* synthetic */ com.tk.component.imageview.a.a c(b bVar) {
        return mT();
    }

    public b(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Qx = -1;
        this.Qz = true;
        this.GH = false;
        this.QF = 2;
        this.QG = 0L;
        this.QH = false;
    }

    public b(NativeModuleInitParams nativeModuleInitParams, boolean z) {
        super(nativeModuleInitParams, true);
        this.Qx = -1;
        this.Qz = true;
        this.GH = false;
        this.QF = 2;
        this.QG = 0L;
        this.QH = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public ImageView n(Context context) {
        return mT().nq();
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            mN();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.imageview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.mN();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.QB);
        ad.unRetainJsValue(this.QA);
        ad.unRetainJsValue(this.QC);
        ad.unRetainJsValue(this.QD);
        ad.unRetainJsValue(this.QE);
    }

    public final void ar(String str) {
        this.QI = str;
        if (this.QI.startsWith("//")) {
            this.QI = "https:" + this.QI;
        }
        if (!this.QH) {
            mT();
            getView();
        }
        mT();
        getView();
        pn();
        pO();
    }

    private static com.tk.component.imageview.a.a mT() {
        return g.ng().mT();
    }

    public final void as(String str) {
        this.QM = str;
    }

    public final void at(String str) {
        if (str == null || !str.equals(this.QJ)) {
            this.QJ = str;
            X(this.Qz);
            o((Drawable) null);
            try {
                int i = (int) pR().getYogaNode().getHeight().value;
                int i2 = (int) pR().getYogaNode().getWidth().value;
                if (str != null && (str.startsWith(UriUtils.BASE64_PREFIX) || str.startsWith(UriUtils.BASE64_PREFIX2))) {
                    mU();
                } else {
                    c(this.QM, i2, i);
                }
            } catch (Throwable th) {
                com.tk.core.i.a.a("TKAnimatedImage", "setUri Exception", th);
            }
        }
    }

    private void mU() {
        Bitmap bitmapCR = com.tk.core.o.b.cR(this.QJ);
        if (bitmapCR == null) {
            return;
        }
        o(new BitmapDrawable(bitmapCR));
    }

    public final void au(String str) {
        this.QJ = str;
        X(this.Qz);
        o((Drawable) null);
        try {
            int i = (int) pR().getYogaNode().getHeight().value;
            c(this.QM, (int) pR().getYogaNode().getWidth().value, i);
        } catch (Throwable th) {
            com.tk.core.i.a.a("TKAnimatedImage", "setUriWith Exception", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String av(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf(58);
        char c = 65535;
        if (iIndexOf == -1) {
            return aw(str);
        }
        String str2 = str.substring(0, iIndexOf) + "://";
        switch (str2.hashCode()) {
            case -855037794:
                if (str2.equals(UriUtils.FILE_PREFIX)) {
                    c = 0;
                    break;
                }
                break;
            case -373240150:
                if (str2.equals(UriUtils.ASSET_PREFIX)) {
                    c = 1;
                    break;
                }
                break;
            case -132207921:
                if (str2.equals("https://")) {
                    c = 3;
                    break;
                }
                break;
            case 1242606098:
                if (str2.equals("http://")) {
                    c = 2;
                    break;
                }
                break;
        }
        if (c == 0) {
            return ax(str);
        }
        if (c != 1) {
            return (c == 2 || c == 3) ? str : aw(str);
        }
        return ay(str);
    }

    private String aw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strConcat = pn().concat(y.getMappedPath(str, UriUtils.BUNDLE_PREFIX));
        if (com.tk.core.o.f.cS(strConcat)) {
            return strConcat;
        }
        com.tk.core.i.a.a("TKAnimatedImage", "showBundleImage", new Exception(str + " not exist"));
        return null;
    }

    private static String ax(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String mappedPath = y.getMappedPath(str, UriUtils.FILE_PREFIX);
        if (com.tk.core.o.f.cS(mappedPath)) {
            return mappedPath;
        }
        com.tk.core.i.a.a("TKAnimatedImage", "showFileImage", new Exception(str + " not exist"));
        return null;
    }

    private String ay(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String resName = y.getResName(str);
        if (z.b(resName, "drawable", null) != 0) {
            return resName;
        }
        com.tk.core.i.a.a("TKAnimatedImage", "showAssetImage", new Exception(this.QJ + " not exist"));
        return null;
    }

    public final void cK(int i) {
        this.Qx = i;
    }

    public final void p(String str, String str2) {
        X(this.Qz);
        this.QI = str;
        if (this.QI.startsWith("//")) {
            this.QI = "https:" + this.QI;
        }
        try {
            pR().getYogaNode().getHeight();
            pR().getYogaNode().getWidth();
            mT();
            getView();
            pn();
            pO();
        } catch (Throwable th) {
            com.tk.core.i.a.a("TKAnimatedImage", "setUrlAndPlaceHolder", th);
            com.tk.core.exception.a.a(th, pO().hashCode());
        }
    }

    public final void a(String str, int i, int i2) {
        if (com.tachikoma.component.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            this.QK = str;
        }
        b(str, i, i2);
    }

    private void b(String str, int i, int i2) {
        long j = this.QG + 1;
        this.QG = j;
        mT();
        getView();
        pO();
        TKCDNUrl.fromJsonString(str);
        if (j == this.QG) {
            mT();
            getView();
            pO();
        }
    }

    private void c(String str, final int i, final int i2) {
        if (!this.QH) {
            mT();
            getView();
        }
        if (TextUtils.isEmpty(str)) {
            mT();
            getView();
            av(this.QJ);
            av(this.QN);
            pO();
            return;
        }
        com.tk.core.o.h.b(getContext(), str, pO().pq(), pn(), i, i2, new Callback<BitmapDrawable>() { // from class: com.tk.component.imageview.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kuaishou.tk.api.export.sdk.Callback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void callback(BitmapDrawable bitmapDrawable) {
                b.c(b.this);
                b.this.getView();
                b bVar = b.this;
                bVar.av(bVar.QJ);
                b bVar2 = b.this;
                bVar2.av(bVar2.QN);
                b.this.pO();
            }

            @Override // com.kuaishou.tk.api.export.sdk.Callback
            public final void error(Throwable th) {
                b.c(b.this);
                b.this.getView();
                b bVar = b.this;
                bVar.av(bVar.QJ);
                b bVar2 = b.this;
                bVar2.av(bVar2.QN);
                b.this.pO();
            }
        });
    }

    public final void a(String str, int i, int i2, String str2, String str3) {
        try {
            az(str2);
            TKCDNUrl.fromJsonString(str);
            mT();
            getView();
            av(str3);
            pO();
        } catch (Throwable th) {
            com.tk.core.i.a.b("TKAnimatedImage setCDNUrls occurs exception", th);
        }
    }

    private void az(String str) {
        if (TextUtils.isEmpty(str)) {
            o((Drawable) null);
        } else {
            at(str);
        }
    }

    public final void aA(String str) {
        if (getView() == null) {
            return;
        }
        this.QH = true;
        mT();
        getView();
    }

    @Override // com.tk.core.component.e
    public final void a(double d) {
        if (qw()) {
            pR().getYogaNode().setBorder(YogaEdge.ALL, o.P((float) d));
        }
        mT();
        getView();
    }

    @Override // com.tk.core.component.e
    public final void aB(String str) {
        mT();
        getView();
    }

    @Override // com.tk.core.component.e
    public final void bY(int i) {
        mT();
        getView();
    }

    public final void a(V8Array v8Array, final int i, final int i2) {
        JsValueRef<V8Function> jsValueRef;
        this.QF = 1;
        if (this.GH && (jsValueRef = this.QA) != null) {
            W(jsValueRef.get());
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
        }
        final ArrayList arrayList = new ArrayList();
        try {
        } catch (Throwable th) {
            com.tk.core.i.a.a("TKAnimatedImage", "TKAnimatedImage", th);
            if (arrayList.size() <= 0) {
                JsValueRef<V8Function> jsValueRef2 = this.QC;
                if (jsValueRef2 != null) {
                    W(jsValueRef2.get());
                    return;
                }
                return;
            }
        }
        if (v8Array == null || i <= 0) {
            com.tk.core.i.a.x("TKAnimatedImage", "setAnimationsImages params illegal -- 1");
            if (this.QC != null) {
                W(this.QC.get());
                return;
            }
            return;
        }
        List list = v8Array.getList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            if (com.tachikoma.component.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
                this.QL = new JSONArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.QL.put((String) it.next());
                }
            }
            p.execute(new Runnable() { // from class: com.tk.component.imageview.b.3
                /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
                /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r8 = this;
                        java.util.List r0 = r2
                        java.lang.String r1 = "TKAnimatedImage"
                        if (r0 == 0) goto La2
                        int r0 = r0.size()
                        if (r0 <= 0) goto La2
                        int r0 = r3
                        if (r0 > 0) goto L12
                        goto La2
                    L12:
                        java.util.List r0 = r2
                        r2 = 0
                        java.lang.Object r0 = r0.get(r2)
                        java.lang.String r0 = (java.lang.String) r0
                        r3 = 58
                        int r3 = r0.indexOf(r3)
                        r4 = -1
                        if (r3 == r4) goto L7f
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                        r5.<init>()
                        java.lang.String r0 = r0.substring(r2, r3)
                        r5.append(r0)
                        java.lang.String r0 = "://"
                        r5.append(r0)
                        java.lang.String r0 = r5.toString()
                        int r3 = r0.hashCode()
                        r5 = -132207921(0xfffffffff81eaacf, float:-1.2872614E34)
                        r6 = 1
                        if (r3 == r5) goto L52
                        r5 = 1242606098(0x4a10aa12, float:2370180.5)
                        if (r3 == r5) goto L49
                        goto L5c
                    L49:
                        java.lang.String r3 = "http://"
                        boolean r0 = r0.equals(r3)
                        if (r0 == 0) goto L5c
                        goto L5d
                    L52:
                        java.lang.String r2 = "https://"
                        boolean r0 = r0.equals(r2)
                        if (r0 == 0) goto L5c
                        r2 = 1
                        goto L5d
                    L5c:
                        r2 = -1
                    L5d:
                        if (r2 == 0) goto L62
                        if (r2 == r6) goto L62
                        goto L7f
                    L62:
                        java.lang.String r0 = "setAnimationsImages params illegal -- 4"
                        com.tk.core.i.a.x(r1, r0)
                        com.tk.component.imageview.b r0 = com.tk.component.imageview.b.this
                        com.tkruntime.v8.JsValueRef r0 = com.tk.component.imageview.b.d(r0)
                        if (r0 == 0) goto L7e
                        com.tk.component.imageview.b r0 = com.tk.component.imageview.b.this
                        com.tkruntime.v8.JsValueRef r1 = com.tk.component.imageview.b.d(r0)
                        java.lang.Object r1 = r1.get()
                        com.tkruntime.v8.V8Function r1 = (com.tkruntime.v8.V8Function) r1
                        com.tk.component.imageview.b.a(r0, r1)
                    L7e:
                        return
                    L7f:
                        com.tk.component.imageview.b r0 = com.tk.component.imageview.b.this
                        android.content.Context r1 = r0.getContext()
                        java.util.List r2 = r2
                        com.tk.component.imageview.b r0 = com.tk.component.imageview.b.this
                        com.tk.core.bridge.b r0 = r0.pO()
                        java.lang.String r3 = r0.pq()
                        com.tk.component.imageview.b r0 = com.tk.component.imageview.b.this
                        java.lang.String r4 = r0.pn()
                        r5 = 0
                        r6 = 0
                        com.tk.component.imageview.b$3$1 r7 = new com.tk.component.imageview.b$3$1
                        r7.<init>()
                        com.tk.core.o.h.a(r1, r2, r3, r4, r5, r6, r7)
                        return
                    La2:
                        java.lang.String r0 = "setAnimationsImages params illegal -- 2"
                        com.tk.core.i.a.x(r1, r0)
                        com.tk.component.imageview.b r0 = com.tk.component.imageview.b.this
                        com.tkruntime.v8.JsValueRef r0 = com.tk.component.imageview.b.d(r0)
                        if (r0 == 0) goto Lbe
                        com.tk.component.imageview.b r0 = com.tk.component.imageview.b.this
                        com.tkruntime.v8.JsValueRef r1 = com.tk.component.imageview.b.d(r0)
                        java.lang.Object r1 = r1.get()
                        com.tkruntime.v8.V8Function r1 = (com.tkruntime.v8.V8Function) r1
                        com.tk.component.imageview.b.a(r0, r1)
                    Lbe:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.b.AnonymousClass3.run():void");
                }
            });
            return;
        }
        if (this.QC != null) {
            W(this.QC.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV() {
        List<BitmapDrawable> list = this.Qs;
        if (list == null || list.size() <= 0) {
            com.tk.core.i.a.x("setAnimationImages", "frame list is empty!!!");
            JsValueRef<V8Function> jsValueRef = this.QC;
            if (jsValueRef != null) {
                W(jsValueRef.get());
                return;
            }
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler(this);
        }
        this.Qt = 0;
        this.Qw = 0;
        this.Qy = false;
        this.GH = true;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mHandler.sendEmptyMessage(1);
        JsValueRef<V8Function> jsValueRef2 = this.QB;
        if (jsValueRef2 != null) {
            W(jsValueRef2.get());
        }
    }

    public final void cL(int i) {
        this.Qu = i;
        if (2 == this.QF) {
            getView().setTag(a.b.animated_repeat_count, Integer.valueOf(this.Qu));
        }
    }

    public final void W(boolean z) {
        this.Qz = z;
    }

    public final boolean mW() {
        return this.GH;
    }

    private void X(boolean z) {
        if (2 != this.QF) {
            return;
        }
        int id = getView().getId();
        if (id == -1) {
            id = a.b.animated_image;
            getView().setId(id);
        }
        getView().setTag(id, Boolean.valueOf(z));
    }

    public final void mX() {
        int i = this.QF;
        if (1 == i) {
            mY();
        } else if (2 == i) {
            mZ();
        }
    }

    private void mY() {
        List<BitmapDrawable> list = this.Qs;
        if (list == null || list.size() <= 0) {
            com.tk.core.i.a.a("TKAnimatedImage", "startImageAnimation", new RuntimeException("please set params first"));
        }
        mV();
    }

    private void mZ() {
        mT();
        getView();
    }

    public final void na() {
        int i = this.QF;
        if (1 == i) {
            nb();
        } else if (2 == i) {
            nc();
        }
    }

    private void nb() {
        Handler handler;
        this.Qy = true;
        this.GH = false;
        if ((getView().getDrawable() instanceof AnimationDrawable) && (handler = this.mHandler) != null) {
            handler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
        }
    }

    private void nc() {
        mT();
        getView();
    }

    public final void R(V8Function v8Function) {
        if (com.tachikoma.component.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue() && v8Function != null) {
            v8Function.setFunctionName("TKAnimatedImage_onAnimationDidRepeat");
        }
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.QE);
        this.QE = jsValueRefRetainJsValue;
    }

    public final void S(V8Function v8Function) {
        if (com.tachikoma.component.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue() && v8Function != null) {
            v8Function.setFunctionName("TKAnimatedImage_onAnimationDidStop");
        }
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.QA);
        this.QA = jsValueRefRetainJsValue;
    }

    public final void T(V8Function v8Function) {
        if (com.tachikoma.component.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue() && v8Function != null) {
            v8Function.setFunctionName("TKAnimatedImage_onAnimationDidStart");
        }
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.QB);
        this.QB = jsValueRefRetainJsValue;
    }

    public final void U(V8Function v8Function) {
        if (com.tachikoma.component.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue() && v8Function != null) {
            v8Function.setFunctionName("TKAnimatedImage_onAnimationDidException");
        }
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.QC);
        this.QC = jsValueRefRetainJsValue;
    }

    public final void V(V8Function v8Function) {
        if (com.tachikoma.component.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue() && v8Function != null) {
            v8Function.setFunctionName("TKAnimatedImage_onAnimationImagesDidLoaded");
        }
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.QD);
        this.QD = jsValueRefRetainJsValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(V8Function v8Function) {
        if (v8Function == null || v8Function.isReleased()) {
            return;
        }
        if (com.tachikoma.component.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            v8Function.setFunctionName("TKAnimatedImage_executeFrameAnimationCallback");
        }
        if (ad.isV8Valid(v8Function)) {
            try {
                v8Function.call(null, new Object[0]);
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        JsValueRef<V8Function> jsValueRef;
        List<BitmapDrawable> list = this.Qs;
        if (list != null && list.size() > 0) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    JsValueRef<V8Function> jsValueRef2 = this.QA;
                    if (jsValueRef2 != null) {
                        W(jsValueRef2.get());
                    }
                    ne();
                    this.GH = false;
                } else if (i == 3 && (jsValueRef = this.QE) != null) {
                    W(jsValueRef.get());
                }
            } else {
                if (this.Qy) {
                    JsValueRef<V8Function> jsValueRef3 = this.QA;
                    if (jsValueRef3 != null) {
                        W(jsValueRef3.get());
                    }
                    return true;
                }
                nd();
            }
        }
        return true;
    }

    private void nd() {
        int size = this.Qs.size();
        int i = this.Qw % size;
        if (i == this.Qs.size() - 1) {
            this.Qt++;
            int i2 = this.Qt;
            int i3 = this.Qu;
            if (i2 >= i3 && i3 != 0) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendEmptyMessageDelayed(2, this.Qv);
            } else {
                this.mHandler.sendEmptyMessageDelayed(3, this.Qv);
                this.mHandler.sendEmptyMessageDelayed(1, this.Qv);
            }
        } else {
            this.mHandler.sendEmptyMessageDelayed(1, this.Qv);
        }
        this.Qw++;
        if (i < 0 || i >= size) {
            com.tk.core.i.a.a("TKAnimatedImage", "updateFrameAnimation", new IndexOutOfBoundsException("updateFrameAnimation"));
        } else {
            o(this.Qs.get(i));
        }
    }

    private void ne() {
        if (this.Qx < 0) {
            return;
        }
        int size = this.Qx % this.Qs.size();
        this.Qw = size;
        o(this.Qs.get(size));
    }

    private void o(Drawable drawable) {
        try {
            getView().setImageDrawable(drawable);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(th, pO().hashCode());
        }
    }
}
