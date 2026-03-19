package com.tk.core.component.text;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Object;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class p implements com.tk.core.manager.a.a<o> {
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
        return "addSpan";
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
        return "4#addSpan#0";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ o b(NativeModuleInitParams nativeModuleInitParams) {
        return ap(nativeModuleInitParams);
    }

    private static o ap(NativeModuleInitParams nativeModuleInitParams) {
        return new o(nativeModuleInitParams);
    }

    @Override // com.tk.core.manager.a.a
    public final int h(String str) {
        return ((str.hashCode() == -1148605557 && str.equals("addSpan")) ? (char) 0 : (char) 65535) != 0 ? 0 : 1;
    }

    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str, Object[] objArr) {
        o oVar = (o) obj;
        if (((str.hashCode() == -1148605557 && str.equals("addSpan")) ? (char) 0 : (char) 65535) == 0) {
            oVar.A((V8Object) com.tk.core.o.a.b(objArr, 0));
            return null;
        }
        if (t.isDebug()) {
            Log.e("TKSpan", "can't find method ---> " + str);
        }
        return null;
    }
}
