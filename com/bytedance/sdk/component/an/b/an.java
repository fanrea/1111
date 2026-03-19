package com.bytedance.sdk.component.an.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.an.mq;
import com.bytedance.sdk.component.an.rf;
import com.bytedance.sdk.component.an.sy;
import com.bytedance.sdk.component.an.uo;
import com.bytedance.sdk.component.an.w;
import com.bytedance.sdk.component.an.yo;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private com.bytedance.sdk.component.an.c an;
    private ExecutorService gb;
    private mq h;
    private final uo hc;
    private w tt;
    private Map<String, List<b>> d = new ConcurrentHashMap();
    private Map<String, yo> b = new HashMap();
    private Map<String, rf> c = new HashMap();
    private Map<String, com.bytedance.sdk.component.an.b> u = new HashMap();

    public an(Context context, uo uoVar) {
        this.hc = (uo) gb.d(uoVar);
        com.bytedance.sdk.component.an.b.d.d.d(context, uoVar.tt());
    }

    public Collection<yo> d() {
        return this.b.values();
    }

    public Collection<rf> hc() {
        return this.c.values();
    }

    public Collection<com.bytedance.sdk.component.an.b> b() {
        return this.u.values();
    }

    public yo d(com.bytedance.sdk.component.an.hc hcVar) {
        if (hcVar == null) {
            hcVar = com.bytedance.sdk.component.an.b.d.d.tt();
        }
        String string = hcVar.u().toString();
        yo yoVar = this.b.get(string);
        if (yoVar != null) {
            return yoVar;
        }
        yo yoVarC = c(hcVar);
        this.b.put(string, yoVarC);
        return yoVarC;
    }

    private yo c(com.bytedance.sdk.component.an.hc hcVar) {
        yo yoVarU = this.hc.u();
        if (yoVarU != null) {
            return com.bytedance.sdk.component.an.b.d.hc.d.d(yoVarU);
        }
        return com.bytedance.sdk.component.an.b.d.hc.d.d(hcVar.hc());
    }

    public rf hc(com.bytedance.sdk.component.an.hc hcVar) {
        if (hcVar == null) {
            hcVar = com.bytedance.sdk.component.an.b.d.d.tt();
        }
        String string = hcVar.u().toString();
        rf rfVar = this.c.get(string);
        if (rfVar != null) {
            return rfVar;
        }
        rf rfVarU = u(hcVar);
        this.c.put(string, rfVarU);
        return rfVarU;
    }

    private rf u(com.bytedance.sdk.component.an.hc hcVar) {
        rf rfVarAn = this.hc.an();
        return rfVarAn != null ? rfVarAn : com.bytedance.sdk.component.an.b.d.hc.u.d(hcVar.gb());
    }

    public com.bytedance.sdk.component.an.b b(com.bytedance.sdk.component.an.hc hcVar) {
        if (hcVar == null) {
            hcVar = com.bytedance.sdk.component.an.b.d.d.tt();
        }
        String string = hcVar.u().toString();
        com.bytedance.sdk.component.an.b bVar = this.u.get(string);
        if (bVar != null) {
            return bVar;
        }
        com.bytedance.sdk.component.an.b bVarAn = an(hcVar);
        this.u.put(string, bVarAn);
        return bVarAn;
    }

    public com.bytedance.sdk.component.an.b d(String str) {
        return b(com.bytedance.sdk.component.an.b.d.d.d(new File(str)));
    }

    private com.bytedance.sdk.component.an.b an(com.bytedance.sdk.component.an.hc hcVar) {
        com.bytedance.sdk.component.an.b bVarH = this.hc.h();
        return bVarH != null ? bVarH : new com.bytedance.sdk.component.an.b.d.d.hc(hcVar.u(), hcVar.d(), an());
    }

    public com.bytedance.sdk.component.an.c c() {
        if (this.an == null) {
            this.an = tt();
        }
        return this.an;
    }

    private com.bytedance.sdk.component.an.c tt() {
        com.bytedance.sdk.component.an.c cVarC = this.hc.c();
        return cVarC == null ? com.bytedance.sdk.component.an.hc.hc.d() : cVarC;
    }

    public mq u() {
        if (this.h == null) {
            this.h = tc();
        }
        return this.h;
    }

    private mq tc() {
        mq mqVarD = this.hc.d();
        return mqVarD != null ? mqVarD : com.bytedance.sdk.component.an.d.hc.d();
    }

    public ExecutorService an() {
        ExecutorService executorServiceD;
        sy syVarB = this.hc.b();
        if (syVarB != null && (executorServiceD = syVarB.d()) != null) {
            return executorServiceD;
        }
        if (this.gb == null) {
            this.gb = mk();
        }
        return this.gb;
    }

    private ExecutorService mk() {
        ExecutorService executorServiceHc = this.hc.hc();
        return executorServiceHc != null ? executorServiceHc : com.bytedance.sdk.component.an.d.b.d();
    }

    public Map<String, List<b>> h() {
        return this.d;
    }

    public com.bytedance.sdk.component.an.b.hc.d d(b bVar) {
        ImageView.ScaleType scaleTypeU = bVar.u();
        if (scaleTypeU == null) {
            scaleTypeU = com.bytedance.sdk.component.an.b.hc.d.d;
        }
        ImageView.ScaleType scaleType = scaleTypeU;
        Bitmap.Config configMq = bVar.mq();
        if (configMq == null) {
            configMq = com.bytedance.sdk.component.an.b.hc.d.hc;
        }
        return new com.bytedance.sdk.component.an.b.hc.d(bVar.b(), bVar.c(), scaleType, configMq, bVar.tt(), bVar.tc());
    }

    public w gb() {
        if (this.tt == null) {
            this.tt = mq();
        }
        return this.tt;
    }

    private w mq() {
        w wVarGb = this.hc.gb();
        return wVarGb == null ? new h() : wVarGb;
    }
}
