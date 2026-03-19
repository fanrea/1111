package com.kwad.tachikoma.b;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str) {
        return null;
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        if (i != 0) {
            return null;
        }
        return "setSrc";
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final boolean g(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "4#setSrc#0";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return h(nativeModuleInitParams);
    }

    private static a h(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    @Override // com.tk.core.manager.a.a
    public final int h(String str) {
        return ((str.hashCode() == -905800158 && str.equals("setSrc")) ? (char) 0 : (char) 65535) != 0 ? 0 : 1;
    }

    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str, Object[] objArr) {
        a aVar = (a) obj;
        if (((str.hashCode() == -905800158 && str.equals("setSrc")) ? (char) 0 : (char) 65535) == 0) {
            aVar.a((String) com.tk.core.o.a.b(objArr, 0), (V8Function) com.tk.core.o.a.b(objArr, 1));
            return null;
        }
        if (t.isDebug()) {
            Log.e("TKBitmap", "can't find method ---> " + str);
        }
        return null;
    }
}
