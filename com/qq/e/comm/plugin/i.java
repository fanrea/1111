package com.qq.e.comm.plugin;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.j30;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i implements ADListener {
    private static final String e = "i";
    private final ADListener a;
    private final j30 b;
    private j30.s c;
    private String d;

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        xo.a((Runnable) new a(aDEvent));
    }

    i(j30 j30Var, ADListener aDListener, String str, j30.s sVar) {
        this.b = j30Var;
        this.a = aDListener;
        this.c = sVar;
        this.d = str;
    }

    /* compiled from: A */
    class a extends xx {
        final /* synthetic */ ADEvent b;

        a(ADEvent aDEvent) {
            this.b = aDEvent;
        }

        @Override // com.qq.e.comm.plugin.xx
        public void b() {
            String unused = i.e;
            this.b.getType();
            int type = this.b.getType();
            if (type == 100) {
                a(this.b);
                return;
            }
            if (type == 101) {
                if (i.this.c != null) {
                    i.this.c.a(false);
                }
                i.this.a.onADEvent(this.b);
                return;
            }
            if (type == 103) {
                i.this.a.onADEvent(this.b);
                if (i.this.c != null) {
                    i.this.c.a(false);
                    return;
                }
                return;
            }
            if (type != 110) {
                if (type != 303 && type != 1007) {
                    switch (type) {
                        case 1002:
                        case 1004:
                            break;
                        case 1003:
                            break;
                        default:
                            i.this.a.onADEvent(this.b);
                            break;
                    }
                    return;
                }
                if (m30.a(i.this.d)) {
                    i.this.b.close();
                    return;
                }
                return;
            }
            i.this.b.close();
            i.this.a.onADEvent(this.b);
        }

        private void a(ADEvent aDEvent) {
            if (i.this.c != null) {
                i.this.c.a(true);
            }
            b5.d(i.this.d, i.this.b);
            i.this.a.onADEvent(aDEvent);
        }
    }
}
