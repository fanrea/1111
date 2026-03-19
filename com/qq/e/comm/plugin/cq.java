package com.qq.e.comm.plugin;

import android.widget.BaseAdapter;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cq implements ADListener {
    private static final JSONObject g = new jn("{\"bindData\":\"{\\\"dlInfo\\\":{\\\"adLogoVis\\\":2}}\"}").a();
    private final mq a;
    private final ADListener b;
    private final BaseAdapter c;
    private final int d;
    private int e = 0;
    private boolean f = true;

    public cq(mq mqVar, ADListener aDListener, BaseAdapter baseAdapter, int i) {
        this.a = mqVar;
        this.b = aDListener;
        this.c = baseAdapter;
        this.d = i;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        int type = aDEvent.getType();
        if (type != 103) {
            if (type != 105 && type != 303) {
                if (type == 109) {
                    NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                    if (nativeExpressADView instanceof jq) {
                        ((jq) nativeExpressADView).a(g);
                    }
                    this.c.notifyDataSetChanged();
                    if (a()) {
                        this.b.onADEvent(new ADEvent(109, this.a));
                    }
                    this.e = -1;
                    return;
                }
                if (type != 110) {
                    return;
                }
                NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView2 != null) {
                    this.a.a(nativeExpressADView2);
                    this.c.notifyDataSetChanged();
                }
                if (a()) {
                    int i = this.e + 1;
                    this.e = i;
                    if (i == this.d) {
                        this.b.onADEvent(new ADEvent(110, this.a));
                        return;
                    }
                    return;
                }
                return;
            }
        } else if (this.f) {
            this.f = false;
            b();
        }
        this.b.onADEvent(aDEvent);
    }

    private boolean a() {
        return this.e >= 0;
    }

    private void b() {
        b10.a(1430004, this.a.p(), Integer.valueOf(this.c.getCount()), Integer.valueOf(this.a.a()), null);
        b10.a(1430005, this.a.p(), Integer.valueOf(this.a.getECPM()), null, null);
    }
}
