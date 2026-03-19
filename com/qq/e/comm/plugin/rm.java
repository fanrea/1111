package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.IAFD;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class rm implements IAFD {
    private final Context a;
    private final String b;
    private final ADListener c;
    private ADListener d;
    private Map<String, String> e;
    private final dh g;
    private final d20 k;
    private int f = -1;
    private final AtomicBoolean h = new AtomicBoolean(false);
    private List<NativeExpressADView> i = new ArrayList();
    private final String j = String.valueOf(ks.a());

    public int c() {
        return r1.d().f().a("iafcii", this.b, 30);
    }

    public int d() {
        return r1.d().f().a("iafmrac", this.b, 5);
    }

    public int f() {
        return r1.d().f().a("iaflt", this.b, 10);
    }

    @Override // com.qq.e.comm.pi.IAFD
    public String getOperationInfo() {
        return r1.d().f().a("iafoi", this.b, "{\"1_1\":\"https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/im_op_1_1.png\",\"16_9\":\"https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/im_op_16_9.png\",\"9_16\":\"https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/im_op_9_16.png\",\"txt\":\"点击畅享 精彩短剧\"}");
    }

    public List<NativeExpressADView> b() {
        ArrayList arrayList = new ArrayList(this.i);
        this.i.clear();
        return arrayList;
    }

    public rm(Context context, String str, String str2, String str3, ADListener aDListener, Map<String, String> map) {
        this.a = context;
        this.b = str2;
        this.c = aDListener;
        this.e = map;
        this.k = new d20(r1.d().f().a("iaflln", str2, 10));
        dh dhVar = new dh(context, new ADSize(-1, -2), str, str2, str3, new a());
        this.g = dhVar;
        dhVar.setVideoOption(new VideoOption.Builder().setNeedProgressBar(false).build());
    }

    /* compiled from: A */
    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                List list = (List) aDEvent.getParam(List.class);
                if (list != null) {
                    if (rm.this.d != null) {
                        rm.this.d.onADEvent(aDEvent);
                        return;
                    }
                    rm.this.i = list;
                    if (rm.this.c != null) {
                        rm.this.c.onADEvent(new ADEvent(100, new Object[0]));
                        return;
                    }
                    return;
                }
                return;
            }
            if (type == 101) {
                if (rm.this.d != null) {
                    rm.this.d.onADEvent(aDEvent);
                }
                if (rm.this.c != null) {
                    rm.this.c.onADEvent(aDEvent);
                    return;
                }
                return;
            }
            if (type == 103) {
                if (rm.this.d != null) {
                    rm.this.d.onADEvent(aDEvent);
                }
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView == null || rm.this.c == null || nativeExpressADView.getExtraInfo() == null) {
                    return;
                }
                rm.this.c.onADEvent(new ADEvent(103, nativeExpressADView.getExtraInfo().get("request_id")));
                return;
            }
            if (type != 105) {
                if ((type == 109 || type == 110) && rm.this.d != null) {
                    rm.this.d.onADEvent(aDEvent);
                    return;
                }
                return;
            }
            if (rm.this.d != null) {
                rm.this.d.onADEvent(aDEvent);
            }
            NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
            if (nativeExpressADView2 == null || rm.this.c == null || nativeExpressADView2.getExtraInfo() == null) {
                return;
            }
            rm.this.c.onADEvent(new ADEvent(105, nativeExpressADView2.getExtraInfo().get("request_id")));
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rm.this.c.onADEvent(new ADEvent(101, 6000));
        }
    }

    @Override // com.qq.e.comm.pi.IAFD
    public void preloadImmersiveADFlow() {
        if (!a() && this.c != null) {
            xo.d(new b());
            return;
        }
        if (!this.h.get() && !this.k.b()) {
            g();
        } else if (this.k.b()) {
            GDTLogger.e("请求超限");
        }
    }

    public int e() {
        return xc.a("iaflft", this.b, 2);
    }

    public void g() {
        if (this.f < 0) {
            this.f = xc.a("iaflc", this.b, 8);
        }
        dh dhVar = this.g;
        if (dhVar != null) {
            dhVar.c(this.f);
            this.g.loadAd(this.f);
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rm.this.c.onADEvent(new ADEvent(101, 6000));
        }
    }

    @Override // com.qq.e.comm.pi.IAFD
    public void showImmersiveADFlow() {
        if (!a() && this.c != null) {
            xo.d(new c());
            return;
        }
        if (this.h.compareAndSet(false, true)) {
            Intent intent = new Intent();
            intent.setClassName(this.a, wx.d());
            intent.putExtra(ACTD.DELEGATE_NAME_KEY, wm.IMMERSIVE_AD_FLOW_ACTIVITY);
            intent.putExtra("appid", r1.d().b().a());
            intent.addFlags(268435456);
            intent.putExtra("objectId", this.j);
            ((sm) zm.a(this.j, sm.class)).a(this);
            try {
                this.a.startActivity(intent);
                ADListener aDListener = this.c;
                if (aDListener != null) {
                    aDListener.onADEvent(new ADEvent(102, new Object[0]));
                }
            } catch (Exception unused) {
                a(false);
            }
        }
    }

    @Override // com.qq.e.comm.pi.IAFD
    public void setVideoOption(VideoOption videoOption) {
        if (this.g == null || videoOption == null) {
            return;
        }
        this.g.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(videoOption.getAutoPlayPolicy()).setAutoPlayMuted(videoOption.getAutoPlayMuted()).setDetailPageMuted(videoOption.isDetailPageMuted()).setNeedProgressBar(false).build());
    }

    public void a(ADListener aDListener) {
        this.d = aDListener;
    }

    public void a(boolean z) {
        ADListener aDListener;
        if (this.h.get() && !z && (aDListener = this.c) != null) {
            aDListener.onADEvent(new ADEvent(106, new Object[0]));
        }
        this.h.set(z);
    }

    private boolean a() {
        return lv.a() && !t10.d();
    }
}
