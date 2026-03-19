package com.tk.core.manager;

import com.tk.core.component.timer.TKTimer;
import com.tkruntime.v8.JavaCallback;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f {
    private static final f aiw = new f();
    private TKTimer aix = null;

    static /* synthetic */ int a(f fVar, Object obj) {
        return K(obj);
    }

    private f() {
    }

    public static f st() {
        return aiw;
    }

    public final void preLoad() {
        if (this.aix == null) {
            this.aix = new TKTimer();
        }
    }

    public final void a(com.tk.core.bridge.a aVar, com.tk.core.bridge.b bVar, V8 v8) {
        v8.registerInternalFunction(1L, a("setInterval", aVar, bVar));
        v8.registerInternalFunction(2L, a("clearInterval", aVar, bVar));
        v8.registerInternalFunction(3L, a("setTimeout", aVar, bVar));
        v8.registerInternalFunction(4L, a("clearTimeout", aVar, bVar));
    }

    private JavaCallback a(final String str, final com.tk.core.bridge.a aVar, final com.tk.core.bridge.b bVar) {
        return new JavaCallback() { // from class: com.tk.core.manager.f.1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // com.tkruntime.v8.JavaCallback
            public final Object invoke(V8Object v8Object, Object[] objArr) {
                char c;
                if (f.this.aix == null) {
                    f.this.aix = new TKTimer();
                }
                try {
                    String str2 = str;
                    c = 65535;
                    switch (str2.hashCode()) {
                        case -1735228601:
                            if (str2.equals("setInterval")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1337725356:
                            if (str2.equals("clearTimeout")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -167812558:
                            if (str2.equals("clearInterval")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1659754143:
                            if (str2.equals("setTimeout")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                } catch (Exception e) {
                    com.tk.core.exception.a.a(bVar, new RuntimeException(str + " error: " + e.getLocalizedMessage() + "\nparams: " + com.tk.core.bridge.b.getParametersString(objArr), e));
                }
                if (c == 0) {
                    return Integer.valueOf(f.this.aix.setInterval((V8Function) objArr[0], f.a(f.this, objArr[1]), aVar.ph(), bVar.pq()));
                }
                if (c == 1) {
                    return Integer.valueOf(f.this.aix.setTimeout((V8Function) objArr[0], f.a(f.this, objArr[1]), aVar.ph(), bVar.pq()));
                }
                if (c == 2) {
                    f.this.aix.clearInterval(f.a(f.this, objArr[0]));
                } else if (c == 3) {
                    f.this.aix.clearTimeout(f.a(f.this, objArr[0]));
                }
                return null;
            }
        };
    }

    private static int K(Object obj) {
        if (obj == null || "undefined".equals(obj)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    public final void destroy(String str) {
        TKTimer tKTimer = this.aix;
        if (tKTimer != null) {
            tKTimer.destroy(str);
        }
    }
}
