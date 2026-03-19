package com.tk.component.imageview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.component.imageview.model.a;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class i extends com.tk.core.component.e<ImageView> implements a.b {
    public String QI;
    public String QM;
    public String QN;
    public JsValueRef<V8Function> RA;
    private com.tk.component.imageview.a.b Rh;
    private com.tk.component.imageview.model.a Rj;
    private a.C0813a Rk;
    private int Rl;
    private double Rm;
    private String Rn;
    public V8Function Ro;
    public JsValueRef<V8Function> Rp;
    private V8Function Rq;
    private JsValueRef<V8Function> Rr;
    public String Rs;
    public String Rt;
    public boolean Ru;
    public String Rv;
    public int Rw;
    public V8Function Rx;
    public JsValueRef<V8Function> Ry;
    public V8Function Rz;
    private int bottomLeftRadius;
    private int bottomRightRadius;
    private int topLeftRadius;
    private int topRightRadius;

    public static void preLoad() {
    }

    public i(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Rl = com.tk.component.imageview.model.a.UNSET;
        this.topLeftRadius = com.tk.component.imageview.model.a.UNSET;
        this.topRightRadius = com.tk.component.imageview.model.a.UNSET;
        this.bottomRightRadius = com.tk.component.imageview.model.a.UNSET;
        this.bottomLeftRadius = com.tk.component.imageview.model.a.UNSET;
        this.Rm = com.tk.component.imageview.model.a.UNSET;
        U(nativeModuleInitParams);
    }

    public i(NativeModuleInitParams nativeModuleInitParams, boolean z) {
        super(nativeModuleInitParams, true);
        this.Rl = com.tk.component.imageview.model.a.UNSET;
        this.topLeftRadius = com.tk.component.imageview.model.a.UNSET;
        this.topRightRadius = com.tk.component.imageview.model.a.UNSET;
        this.bottomRightRadius = com.tk.component.imageview.model.a.UNSET;
        this.bottomLeftRadius = com.tk.component.imageview.model.a.UNSET;
        this.Rm = com.tk.component.imageview.model.a.UNSET;
        U(nativeModuleInitParams);
    }

    private void U(NativeModuleInitParams nativeModuleInitParams) {
        this.Rj = new com.tk.component.imageview.model.a(nativeModuleInitParams);
        this.Rk = new a.C0813a();
        a.C0813a c0813a = this.Rk;
        c0813a.Sh = this;
        c0813a.Si = false;
        this.Rj.Rk = c0813a;
    }

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return Build.VERSION.SDK_INT <= 29;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public ImageView n(Context context) {
        return nh().nr();
    }

    private com.tk.component.imageview.a.b<ImageView> nh() {
        if (this.Rh == null) {
            this.Rh = g.ng().nh();
        }
        return this.Rh;
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            nj();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.imageview.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.nj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj() {
        this.Rk.Si = true;
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        com.tk.component.imageview.model.a aVar = this.Rj;
        if (aVar != null) {
            aVar.pM();
        }
        ad.unRetainJsValue(this.Rp);
        ad.unRetainJsValue(this.Ry);
        ad.unRetainJsValue(this.RA);
        ad.unRetainJsValue(this.Rr);
    }

    public final void t(V8Object v8Object) {
        com.tk.component.imageview.model.a aVar;
        if (v8Object == null || (aVar = (com.tk.component.imageview.model.a) getNativeModule(v8Object)) == null) {
            return;
        }
        if (this.Rj != aVar) {
            aVar.pL();
            com.tk.component.imageview.model.a aVar2 = this.Rj;
            if (aVar2 != null) {
                aVar2.pM();
            }
            int i = this.Rj.RU;
            if (i == 1) {
                TextUtils.isEmpty(this.Rj.Rs);
            } else if (i == 2) {
                if (!TextUtils.isEmpty(this.Rj.Rv)) {
                    this.Rj.Rv.equals(aVar.Rv);
                }
            } else if (!TextUtils.isEmpty(this.Rj.QJ)) {
                this.Rj.QJ.equals(aVar.QJ);
            }
            this.Rj = aVar;
        }
        if (this.Rj.Rl != com.tk.component.imageview.model.a.UNSET) {
            nh();
            getView();
        }
        if (this.Rj.Rm != com.tk.component.imageview.model.a.UNSET) {
            nh();
            getView();
        }
        if (!TextUtils.isEmpty(this.Rj.Rn)) {
            nh();
            getView();
        }
        try {
            this.Rj.Rk = this.Rk;
            nh();
            getView();
            this.Rk.QG++;
        } catch (Throwable th) {
            com.tk.core.i.a.b("TKImageView", "show", th);
        }
    }

    public final void a(String str, String str2, String str3, V8Function v8Function) {
        if (!TextUtils.isEmpty(this.Rj.QJ)) {
            this.Rj.QJ.equals(str);
        }
        com.tk.component.imageview.model.a aVar = this.Rj;
        aVar.RU = 0;
        aVar.QJ = str;
        aVar.RX = str2;
        aVar.QN = str3;
        aVar.y(v8Function);
        nh();
        getView();
        this.Rk.QG++;
    }

    public final void b(String str, String str2, String str3, V8Function v8Function) {
        TextUtils.isEmpty(this.Rj.Rs);
        com.tk.component.imageview.model.a aVar = this.Rj;
        aVar.RU = 1;
        aVar.Rs = str;
        aVar.RX = str2;
        aVar.QN = str3;
        aVar.y(v8Function);
        nh();
        getView();
        this.Rk.QG++;
    }

    public final void a(String str, int i, String str2, String str3, V8Function v8Function) {
        if (!TextUtils.isEmpty(this.Rj.Rv)) {
            this.Rj.Rv.equals(str);
        }
        com.tk.component.imageview.model.a aVar = this.Rj;
        aVar.RU = 2;
        aVar.Rv = str;
        aVar.Rw = i;
        aVar.RX = str2;
        aVar.QN = str3;
        aVar.y(v8Function);
        nh();
        getView();
        this.Rk.QG++;
    }

    public final void a(V8Array v8Array, V8Function v8Function) {
        if (v8Array == null) {
            return;
        }
        ad.unRetainJsValue(this.Rr);
        this.Rq = v8Function;
        this.Rr = ad.retainJsValue(v8Function, this);
        nh();
        v8Array.getList();
    }

    public final void aA(String str) {
        nh();
        getView();
    }

    @Override // com.tk.core.component.e
    public final void bZ(int i) {
        if (this.topLeftRadius == i) {
            return;
        }
        super.bZ(i);
        this.topLeftRadius = i;
        nh();
        getView();
    }

    @Override // com.tk.core.component.e
    public final void ca(int i) {
        if (this.topRightRadius == i) {
            return;
        }
        super.ca(i);
        this.topRightRadius = i;
        nh();
        getView();
    }

    @Override // com.tk.core.component.e
    public final void cc(int i) {
        if (this.bottomRightRadius == i) {
            return;
        }
        super.cc(i);
        this.bottomRightRadius = i;
        nh();
        getView();
    }

    @Override // com.tk.core.component.e
    public final void cb(int i) {
        if (this.bottomLeftRadius == i) {
            return;
        }
        super.cb(i);
        this.bottomLeftRadius = i;
        nh();
        getView();
    }

    @Override // com.tk.core.component.e
    public final void a(double d) {
        if (this.Rm == d) {
            return;
        }
        super.a(d);
        this.Rm = d;
        nh();
        getView();
    }

    @Override // com.tk.core.component.e
    public final void aB(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(this.Rn)) {
            super.aB(str);
            this.Rn = str;
            nh();
            getView();
        }
    }

    @Override // com.tk.core.component.e
    public final void bY(int i) {
        if (this.Rl == i) {
            return;
        }
        super.bY(i);
        this.Rl = i;
        nh();
        getView();
    }

    public final void ar(String str) {
        if (!TextUtils.isEmpty(this.Rj.QJ)) {
            this.Rj.QJ.equals(str);
        }
        com.tk.component.imageview.model.a aVar = this.Rj;
        aVar.RU = 0;
        aVar.Rk = this.Rk;
        aVar.QJ = str;
        nh();
        getView();
        this.Rk.QG++;
    }

    public final void aF(String str) {
        TextUtils.isEmpty(this.Rj.Rs);
        com.tk.component.imageview.model.a aVar = this.Rj;
        aVar.RU = 1;
        aVar.Rk = this.Rk;
        aVar.Rs = str;
        nh();
        getView();
        this.Rk.QG++;
    }

    public final void Y(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Rp);
        this.Ro = v8Function;
        this.Rp = jsValueRefRetainJsValue;
    }

    public final void setTintColor(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(this.Rt)) {
            this.Rt = str;
            this.Rj.Rt = str;
            nh();
            getView();
        }
    }

    public final void aG(String str) {
        this.Rj.RX = str;
    }

    public final void aH(String str) {
        this.Rj.QN = str;
    }

    public final void Y(boolean z) {
        this.Rj.RZ = z;
    }

    public final void aI(String str) {
        if (!TextUtils.isEmpty(this.Rj.Rv)) {
            this.Rj.Rv.equals(str);
        }
        com.tk.component.imageview.model.a aVar = this.Rj;
        aVar.RU = 2;
        aVar.Rv = str;
        nh();
        getView();
        this.Rk.QG++;
    }

    public final void cN(int i) {
        this.Rj.Rw = i;
    }

    public final void aJ(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        switch (str.hashCode()) {
            case 3143043:
                str2 = "fill";
                str.equals(str2);
                break;
            case 3387192:
                str.equals("none");
                break;
            case 94852023:
                str2 = "cover";
                str.equals(str2);
                break;
            case 951526612:
                str2 = "contain";
                str.equals(str2);
                break;
        }
        nh();
        getView();
    }

    public final void Z(V8Function v8Function) {
        this.Rx = v8Function;
        ad.unRetainJsValue(this.Ry);
        this.Ry = ad.retainJsValue(v8Function, this);
        this.Rj.ab(true);
    }

    public final void aa(V8Function v8Function) {
        this.Rz = v8Function;
        ad.unRetainJsValue(this.RA);
        this.RA = ad.retainJsValue(v8Function, this);
        this.Rj.ab(true);
    }
}
