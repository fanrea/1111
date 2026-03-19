package com.tk.core.component.g;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        if (i == 0) {
            return "content";
        }
        if (i != 1) {
            return null;
        }
        return "show";
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#content#0,4#show#1";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return ar(nativeModuleInitParams);
    }

    private static a ar(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    @Override // com.tk.core.manager.a.a
    public final boolean g(String str) {
        return ((str.hashCode() == 951530617 && str.equals("content")) ? (char) 0 : (char) 65535) == 0;
    }

    @Override // com.tk.core.manager.a.a
    public final int h(String str) {
        return ((str.hashCode() == 3529469 && str.equals("show")) ? (char) 0 : (char) 65535) != 0 ? 0 : 1;
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        char c = 65535;
        try {
            if (str.hashCode() == 951530617 && str.equals("content")) {
                c = 0;
            }
            if (c == 0) {
                aVar.content = (String) obj2;
                return true;
            }
            if (!t.isDebug()) {
                return false;
            }
            Log.e("TKToast", "call applyProp() with unsupported prop: " + str);
            return false;
        } catch (Exception e) {
            throw new RuntimeException("TKToast apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str) {
        a aVar = (a) obj;
        if (((str.hashCode() == 951530617 && str.equals("content")) ? (char) 0 : (char) 65535) == 0) {
            return aVar.content;
        }
        if (!t.isDebug()) {
            return null;
        }
        Log.e("TKToast", "call getProp() with unsupported prop: " + str);
        return null;
    }

    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str, Object[] objArr) {
        a aVar = (a) obj;
        if (((str.hashCode() == 3529469 && str.equals("show")) ? (char) 0 : (char) 65535) == 0) {
            aVar.show();
            return null;
        }
        if (t.isDebug()) {
            Log.e("TKToast", "can't find method ---> " + str);
        }
        return null;
    }
}
