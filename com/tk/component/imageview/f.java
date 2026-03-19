package com.tk.component.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.component.imageview.a.c;
import com.tk.component.imageview.model.TKCDNUrl;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tk.core.o.p;
import com.tk.core.o.r;
import com.tk.core.o.y;
import com.tk.core.o.z;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.io.File;
import java.util.List;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class f extends com.tk.core.component.e<a> {

    @Deprecated
    public String QI;
    public String QJ;
    public String QM;
    public String QN;
    public int QT;
    private JsValueRef<V8Function> QU;

    public static void preload() {
    }

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return true;
    }

    @Override // com.tk.core.component.e
    public final /* synthetic */ View n(Context context) {
        return A(context);
    }

    static /* synthetic */ com.tk.component.imageview.a.c b(f fVar) {
        return nf();
    }

    public final void X(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.QU);
        this.QU = jsValueRefRetainJsValue;
    }

    public f(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public f(NativeModuleInitParams nativeModuleInitParams, boolean z) {
        super(nativeModuleInitParams, true);
    }

    private static a A(Context context) {
        return new a(context);
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            mN();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.imageview.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.mN();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN() {
        getView().onDestroy();
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.QU);
    }

    public final void as(String str) {
        this.QM = str;
    }

    public final void q(String str, String str2) {
        a(str, false, str2);
    }

    public final void at(String str) {
        this.QJ = str;
        a(str, true, (String) null);
    }

    private void a(String str, boolean z, String str2) {
        if (z) {
            try {
                getView().setImageDrawable(null);
            } catch (Throwable th) {
                com.tk.core.i.a.a("TKImage", "showImageWithUri Exception", th);
                com.tk.core.exception.a.a(th, pP().pg());
                return;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            getView().setTintColor(str2);
        }
        if (!TextUtils.isEmpty(str) && (str.startsWith(UriUtils.BASE64_PREFIX) || str.startsWith(UriUtils.BASE64_PREFIX2))) {
            mU();
            return;
        }
        int i = (int) pR().getYogaNode().getHeight().value;
        nf().a(getView(), av(str), av(this.QM), av(this.QN), this.QT, (int) pR().getYogaNode().getWidth().value, i, new c.a() { // from class: com.tk.component.imageview.f.5
            @Override // com.tk.component.imageview.a.c.a
            public final void a(BitmapDrawable bitmapDrawable) throws Throwable {
                f.this.a(bitmapDrawable);
            }
        });
    }

    private static com.tk.component.imageview.a.c nf() {
        return g.ng().nf();
    }

    public final void a(String str, String str2, String str3) {
        this.QJ = str;
        getView().setImageDrawable(null);
        try {
            int i = (int) pR().getYogaNode().getHeight().value;
            nf().a(getView(), av(str), av(str2), av(str3), this.QT, (int) pR().getYogaNode().getWidth().value, i, new c.a() { // from class: com.tk.component.imageview.f.6
                @Override // com.tk.component.imageview.a.c.a
                public final void a(BitmapDrawable bitmapDrawable) throws Throwable {
                    f.this.a(bitmapDrawable);
                }
            });
        } catch (Throwable th) {
            com.tk.core.i.a.a("TKImage", "setUriWith Exception", th);
        }
    }

    public final void c(String str, String str2, V8Function v8Function) {
        final JsValueRef jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        if (jsValueRefRetainJsValue == null) {
            return;
        }
        final V8Function v8Function2 = (V8Function) jsValueRefRetainJsValue.get();
        this.QJ = str;
        getView().setImageDrawable(null);
        try {
            int i = (int) pR().getYogaNode().getHeight().value;
            int i2 = (int) pR().getYogaNode().getWidth().value;
            if (TextUtils.isEmpty(str2)) {
                str2 = this.QM;
            }
            nf().a(getView(), av(str), av(str2), av(this.QN), this.QT, i2, i, new c.a() { // from class: com.tk.component.imageview.f.7
                @Override // com.tk.component.imageview.a.c.a
                public final void a(BitmapDrawable bitmapDrawable) {
                    String str3;
                    int intrinsicHeight;
                    int intrinsicWidth;
                    if (ad.isV8Valid(v8Function2)) {
                        if (bitmapDrawable != null) {
                            intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
                            intrinsicHeight = bitmapDrawable.getIntrinsicHeight();
                            str3 = "";
                        } else {
                            str3 = "image load failed";
                            intrinsicHeight = 0;
                            intrinsicWidth = 0;
                        }
                        try {
                            try {
                                v8Function2.call(null, Integer.valueOf(intrinsicWidth), Integer.valueOf(intrinsicHeight), str3);
                            } catch (Exception e) {
                                com.tk.core.exception.a.b(e, f.this.pP().pg());
                            }
                        } finally {
                            ad.unRetainJsValue(jsValueRefRetainJsValue);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            com.tk.core.i.a.a("TKImage", "setImageUri Exception", th);
            com.tk.core.exception.a.a(th, pP().pg());
        }
    }

    private void mU() {
        Bitmap bitmapCR = com.tk.core.o.b.cR(this.QJ);
        if (bitmapCR == null) {
            return;
        }
        getView().setImageBitmap(bitmapCR);
    }

    private String av(String str) {
        return y.A(str, pn());
    }

    @Deprecated
    public final void ar(String str) {
        this.QI = str;
        if (this.QI.startsWith("//")) {
            this.QI = "https:" + this.QI;
        }
        getView().setImageDrawable(null);
        if (this.QI.startsWith(com.alipay.sdk.m.l.a.r)) {
            if (TextUtils.isEmpty(this.QM)) {
                nf().a(this.QI, getView(), this.QT, new c.a() { // from class: com.tk.component.imageview.f.8
                    @Override // com.tk.component.imageview.a.c.a
                    public final void a(BitmapDrawable bitmapDrawable) throws Throwable {
                        f.this.a(bitmapDrawable);
                    }
                });
                return;
            }
            String strConcat = pn().concat(this.QM);
            if (new File(strConcat).exists()) {
                p.execute(new AnonymousClass9(strConcat));
                return;
            } else {
                nf().a(getView(), this.QI, null, this.QT, new c.a() { // from class: com.tk.component.imageview.f.10
                    @Override // com.tk.component.imageview.a.c.a
                    public final void a(BitmapDrawable bitmapDrawable) throws Throwable {
                        f.this.a(bitmapDrawable);
                    }
                });
                return;
            }
        }
        final String strConcat2 = pn().concat(this.QI);
        if (new File(strConcat2).exists()) {
            p.execute(new Runnable() { // from class: com.tk.component.imageview.f.11
                @Override // java.lang.Runnable
                public final void run() {
                    String str2 = strConcat2;
                    final Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str2, f.this.aD(str2));
                    ac.runOnUiThread(new Runnable() { // from class: com.tk.component.imageview.f.11.1
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            f.this.getView().setImageBitmap(bitmapDecodeFile);
                            try {
                                f.this.a(new BitmapDrawable(bitmapDecodeFile));
                            } catch (Exception e) {
                                com.tk.core.i.a.a("TKImage", "onCompletion::", e);
                            }
                        }
                    });
                }
            });
        } else {
            getView().setImageResource(z.b(this.QI, "drawable", null));
        }
    }

    /* renamed from: com.tk.component.imageview.f$9, reason: invalid class name */
    final class AnonymousClass9 implements Runnable {
        final /* synthetic */ String QW;

        AnonymousClass9(String str) {
            this.QW = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str = this.QW;
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeFile(str, f.this.aD(str)));
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.imageview.f.9.1
                @Override // java.lang.Runnable
                public final void run() {
                    f.b(f.this).a(f.this.getView(), f.this.QI, bitmapDrawable, f.this.QT, new c.a() { // from class: com.tk.component.imageview.f.9.1.1
                        @Override // com.tk.component.imageview.a.c.a
                        public final void a(BitmapDrawable bitmapDrawable2) throws Throwable {
                            f.this.a(bitmapDrawable2);
                        }
                    });
                }
            });
        }
    }

    public final void a(String str, String str2, int i, final V8Function v8Function) {
        nf();
        getView();
        new Object() { // from class: com.tk.component.imageview.f.12
        };
    }

    public final void aC(String str) {
        this.QI = str;
        if (this.QI.startsWith("//")) {
            this.QI = "https:" + this.QI;
        }
        if (this.QI.startsWith(com.alipay.sdk.m.l.a.r)) {
            return;
        }
        String strConcat = pn().concat(this.QI);
        if (new File(strConcat).exists()) {
            getView().setImageBitmap(BitmapFactory.decodeFile(strConcat, aD(strConcat)));
        }
    }

    public final void cM(int i) {
        this.QT = i;
    }

    public final void a(String str, int i, int i2) {
        getView().setImageDrawable(null);
        b(str, i, i2);
    }

    public final void a(String str, int i, int i2, String str2, String str3) {
        getView().setImageDrawable(null);
        az(str2);
        nf().a(getView(), TKCDNUrl.fromJsonString(str), (String) null, av(str3), this.QT, i, i2);
    }

    private void az(String str) {
        if (TextUtils.isEmpty(str)) {
            getView().setImageDrawable(null);
        } else {
            at(str);
        }
    }

    private void b(String str, int i, int i2) {
        b((List<TKCDNUrl>) null, i, i2);
        b(TKCDNUrl.fromJsonString(str), i, i2);
    }

    private void b(final List<TKCDNUrl> list, final int i, final int i2) {
        if (list == null || list.isEmpty()) {
            nf().a("", getView(), 0, new c.a() { // from class: com.tk.component.imageview.f.2
                @Override // com.tk.component.imageview.a.c.a
                public final void a(BitmapDrawable bitmapDrawable) throws Throwable {
                    f.this.a(bitmapDrawable);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(this.QM)) {
            nf().a(getView(), list, i, i2, this.QT, new c.a() { // from class: com.tk.component.imageview.f.3
                @Override // com.tk.component.imageview.a.c.a
                public final void a(BitmapDrawable bitmapDrawable) throws Throwable {
                    f.this.a(bitmapDrawable);
                }
            });
            return;
        }
        final String strConcat = pn().concat(this.QM);
        if (new File(strConcat).exists()) {
            p.execute(new Runnable() { // from class: com.tk.component.imageview.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    String str = strConcat;
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeFile(str, f.this.aD(str)));
                    ac.runOnUiThread(new Runnable() { // from class: com.tk.component.imageview.f.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.b(f.this).a(f.this.getView(), list, i, i2, bitmapDrawable, f.this.QT, (c.a) null);
                        }
                    });
                }
            });
        } else {
            nf().a(getView(), list, i, i2, (Drawable) null, this.QT, (c.a) null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void aA(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1881872635: goto L29;
                case -1008619738: goto L1f;
                case 94852023: goto L15;
                case 951526612: goto Lb;
                default: goto La;
            }
        La:
            goto L33
        Lb:
            java.lang.String r0 = "contain"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L33
            r5 = 1
            goto L34
        L15:
            java.lang.String r0 = "cover"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L33
            r5 = 2
            goto L34
        L1f:
            java.lang.String r0 = "origin"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L33
            r5 = 0
            goto L34
        L29:
            java.lang.String r0 = "stretch"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L33
            r5 = 3
            goto L34
        L33:
            r5 = -1
        L34:
            if (r5 == 0) goto L61
            if (r5 == r3) goto L55
            if (r5 == r2) goto L49
            if (r5 == r1) goto L3d
            goto L48
        L3d:
            android.view.View r5 = r4.getView()
            com.tk.component.imageview.a r5 = (com.tk.component.imageview.a) r5
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_XY
            r5.setScaleType(r0)
        L48:
            return
        L49:
            android.view.View r5 = r4.getView()
            com.tk.component.imageview.a r5 = (com.tk.component.imageview.a) r5
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER_CROP
            r5.setScaleType(r0)
            return
        L55:
            android.view.View r5 = r4.getView()
            com.tk.component.imageview.a r5 = (com.tk.component.imageview.a) r5
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_CENTER
            r5.setScaleType(r0)
            return
        L61:
            android.view.View r5 = r4.getView()
            com.tk.component.imageview.a r5 = (com.tk.component.imageview.a) r5
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER
            r5.setScaleType(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.f.aA(java.lang.String):void");
    }

    @Override // com.tk.core.component.e
    public final void a(double d) {
        super.a(d);
        getView().setBorderWidth(o.P((float) d));
    }

    @Override // com.tk.core.component.e
    public final void aB(String str) {
        super.aB(str);
        Integer numValueOf = Integer.valueOf(r.a(str, pP()));
        if (numValueOf != null) {
            getView().setBorderColor(numValueOf.intValue());
        }
    }

    @Override // com.tk.core.component.e
    public final void bY(int i) {
        super.bY(i);
        getView().setBorderRadius(i);
    }

    @Override // com.tk.core.component.e
    public final void bZ(int i) {
        super.bZ(i);
        getView().setTopLeftRoundRadius(o.eb(i));
    }

    @Override // com.tk.core.component.e
    public final void ca(int i) {
        super.ca(i);
        getView().setTopRightRoundRadius(o.eb(i));
    }

    @Override // com.tk.core.component.e
    public final void cc(int i) {
        super.cc(i);
        getView().setBottomRightRoundRadius(o.eb(i));
    }

    @Override // com.tk.core.component.e
    public final void cb(int i) {
        super.cb(i);
        getView().setBottomLeftRoundRadius(o.eb(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BitmapFactory.Options aD(String str) {
        BitmapFactory.Options optionsAE = aE(str);
        optionsAE.inJustDecodeBounds = false;
        try {
            optionsAE.inSampleSize = a(optionsAE, (int) pR().getYogaNode().getWidth().value, (int) pR().getYogaNode().getHeight().value);
        } catch (Throwable th) {
            com.tk.core.i.a.a("TKImage", "getSampleSizeOptions", th);
        }
        return optionsAE;
    }

    private static BitmapFactory.Options aE(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    private static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i4 > i2 || i5 > i) {
                int i6 = i4 / 2;
                int i7 = i5 / 2;
                while (i6 / i3 > i2 && i7 / i3 > i) {
                    i3 *= 2;
                }
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BitmapDrawable bitmapDrawable) throws Throwable {
        JsValueRef<V8Function> jsValueRef = this.QU;
        if (jsValueRef != null && ad.isV8Valid(jsValueRef.get())) {
            try {
                V8Function v8Function = this.QU.get();
                boolean z = true;
                Object[] objArr = new Object[1];
                if (bitmapDrawable == null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                v8Function.call(null, objArr);
            } catch (Exception e) {
                com.tk.core.exception.a.b(e, pO().hashCode());
            }
        }
    }
}
