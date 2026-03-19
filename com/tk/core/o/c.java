package com.tk.core.o;

import com.baidu.mobads.sdk.internal.ca;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Object;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends TKBaseNativeModule {
    private boolean aiH;

    public c(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.aiH = com.tk.core.a.oP().getCommonParams().hT();
    }

    private static String cM(String str) {
        return "Tachikoma-JS[" + str + "]";
    }

    public final void c(Object... objArr) {
        String strI = i(objArr);
        if (this.aiH) {
            if (com.tk.core.a.oP().oS() != null) {
                com.tk.core.a.oP().oS().i(cM("LOG"), strI);
                return;
            }
            if (t.isDebug()) {
                System.out.println(cM("LOG") + strI);
            }
        }
    }

    public final void d(Object... objArr) {
        String strI = i(objArr);
        if (this.aiH) {
            if (com.tk.core.a.oP().oS() != null) {
                com.tk.core.a.oP().oS().i(cM("INFO"), strI);
                return;
            }
            if (t.isDebug()) {
                System.out.println(cM("INFO") + strI);
            }
        }
    }

    public final void e(Object... objArr) {
        String strI = i(objArr);
        if (this.aiH) {
            if (com.tk.core.a.oP().oS() != null) {
                com.tk.core.a.oP().oS().w(cM("WARN"), strI);
                return;
            }
            if (t.isDebug()) {
                System.out.println(cM("WARN") + strI);
            }
        }
    }

    public final void f(Object... objArr) {
        String strI = i(objArr);
        if (this.aiH) {
            if (com.tk.core.a.oP().oS() != null) {
                com.tk.core.a.oP().oS().e(cM("DEBUG"), strI);
                return;
            }
            if (t.isDebug()) {
                System.out.println(cM("DEBUG") + strI);
            }
        }
    }

    public final void g(Object... objArr) {
        String strI = i(objArr);
        if (this.aiH) {
            if (com.tk.core.a.oP().oS() != null) {
                com.tk.core.a.oP().oS().e(cM(LogUtils.EVENT_TYPE_TRACE), strI);
                return;
            }
            if (t.isDebug()) {
                System.out.println(cM(LogUtils.EVENT_TYPE_TRACE) + strI);
            }
        }
    }

    public final void h(Object... objArr) {
        String strI = i(objArr);
        if (this.aiH) {
            if (com.tk.core.a.oP().oS() != null) {
                com.tk.core.a.oP().oS().e(cM(ca.l), strI);
                return;
            }
            if (t.isDebug()) {
                System.out.println(cM(ca.l) + strI);
            }
        }
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
    }

    private String i(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return ILogConst.CACHE_PLAY_REASON_NULL;
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            sb.append(L(objArr[i]));
        }
        return sb.toString();
    }

    private static String L(Object obj) {
        if (obj == null) {
            return ILogConst.CACHE_PLAY_REASON_NULL;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof V8Array) {
            return "[" + obj.toString() + "]";
        }
        if (obj instanceof V8Object) {
            Map all = ((V8Object) obj).getAll();
            return all == null ? ILogConst.CACHE_PLAY_REASON_NULL : all.toString();
        }
        return obj.toString();
    }
}
