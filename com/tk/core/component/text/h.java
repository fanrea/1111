package com.tk.core.component.text;

import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h extends TKBaseNativeModule {
    public String KS;
    public int Vo;
    public String aei;
    public boolean afA;
    public String afB;
    public int afC;
    public int afD;
    public float afE;
    public float afF;
    public float afG;
    public String afH;
    public String afz;
    public int end;
    public String imageUrl;
    public int index;
    public JsValueRef<V8Function> mV8FunctionRef;
    public int size;
    public int start;
    public String url;

    public h(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void aS(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.mV8FunctionRef);
        this.mV8FunctionRef = jsValueRefRetainJsValue;
    }

    public final void aj(String str) {
        this.aei = str;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        ad.unRetainJsValue(this.mV8FunctionRef);
    }
}
