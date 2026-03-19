package com.tk.component.imageview.model;

import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    public static int UNSET = -1;
    public String QJ;
    public String QN;
    public int QT;
    public int RU;
    public V8Function RV;
    private JsValueRef<V8Function> RW;
    public String RX;
    public String RY;
    public boolean RZ;
    public C0813a Rk;
    public int Rl;
    public double Rm;
    public String Rn;
    public String Rs;
    public String Rt;
    public String Rv;
    public int Rw;
    public boolean Sa;
    public int Sb;
    public HashMap Sc;
    public int Sd;
    public int Se;
    public String Sf;
    private boolean Sg;

    /* renamed from: com.tk.component.imageview.model.a$a, reason: collision with other inner class name */
    public static class C0813a {
        public volatile long QG;
        public b Sh;
        public volatile boolean Si = false;
        public String Sj = null;
    }

    public interface b {
    }

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.RU = 0;
        this.RZ = true;
        this.Sb = 1;
        int i = UNSET;
        this.Rl = i;
        this.Rm = i;
        this.Sg = false;
        this.Sf = pn();
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.RW);
    }

    public final void aR(String str) {
        this.Rs = str;
        this.RU = 1;
    }

    public final void at(String str) {
        this.QJ = str;
        this.RU = 0;
    }

    public final void y(Object obj) {
        if (obj instanceof V8Function) {
            JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue((V8Function) obj, this);
            ad.unRetainJsValue(this.RW);
            this.RW = jsValueRefRetainJsValue;
            JsValueRef<V8Function> jsValueRef = this.RW;
            if (jsValueRef != null) {
                this.RV = jsValueRef.get();
            }
        }
    }

    public final void aI(String str) {
        this.Rv = str;
        this.RU = 2;
    }

    public final void cN(int i) {
        this.Rw = i;
    }

    public final void as(String str) {
        this.RX = str;
    }

    public final void aH(String str) {
        this.QN = str;
    }

    public final void setTintColor(String str) {
        this.Rt = str;
    }

    public final void aA(String str) {
        this.RY = str;
    }

    public final void cM(int i) {
        this.QT = i;
    }

    public final void setFadeEnabled(boolean z) {
        this.RZ = z;
    }

    public final void aa(boolean z) {
        this.Sa = z;
    }

    public final void cO(int i) {
        this.Sb = i;
    }

    public final void b(HashMap map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        Object obj = map.get("width");
        if (obj instanceof Number) {
            this.Se = o.eb(((Number) obj).intValue());
        }
        Object obj2 = map.get("height");
        if (obj2 instanceof Number) {
            this.Sd = o.eb(((Number) obj2).intValue());
        }
    }

    public final void ab(boolean z) {
        this.Sg = true;
    }
}
