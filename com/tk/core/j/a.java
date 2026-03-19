package com.tk.core.j;

import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.a.d;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule implements d {
    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    private d su() {
        return pO().pm();
    }

    public final void f(String str, String str2, V8Function v8Function) {
        invoke(str, str2, v8Function);
    }

    @Override // com.tk.core.a.d
    public final Object invoke(String str, String str2, V8Function v8Function) {
        return su().invoke(str, str2, v8Function);
    }

    public final void c(String str, String str2, String str3, V8Function v8Function) {
        invokeM(str, str2, str3, v8Function);
    }

    @Override // com.tk.core.a.d
    public final Object invokeM(String str, String str2, String str3, V8Function v8Function) {
        return su().invokeM(str, str2, str3, v8Function);
    }
}
