package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class aj {
    private String a;
    private String b;
    private String c;
    private String d;
    private WindAdRequest e;
    private LoadAdRequest f;
    private ac.a g;
    private BaseAdUnit h;

    private aj() {
    }

    public static aj a(String category) {
        aj ajVar = new aj();
        ajVar.a = category;
        return ajVar;
    }

    public aj a(ac.a onPointEntityExtraInfo) {
        this.g = onPointEntityExtraInfo;
        return this;
    }

    public aj a(BaseAdUnit adUnit) {
        this.h = adUnit;
        return this;
    }

    public aj a(LoadAdRequest loadAdRequest) {
        this.f = loadAdRequest;
        return this;
    }

    public aj a(WindAdRequest windAdRequest) {
        this.e = windAdRequest;
        return this;
    }

    public void a() {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type("5");
        pointEntitySigmob.setCategory(this.a);
        pointEntitySigmob.setSub_category(this.b);
        if (com.sigmob.sdk.base.utils.m.b(this.c)) {
            pointEntitySigmob.setAdtype(this.c);
        }
        ac.a(this.a, this.b, pointEntitySigmob, this.e);
        ac.a(this.a, this.b, pointEntitySigmob, this.f);
        ac.a(this.a, this.b, this.h, pointEntitySigmob);
        if (com.sigmob.sdk.base.utils.n.b(this.g)) {
            this.g.onAddExtra(pointEntitySigmob);
        }
        ac.a(pointEntitySigmob);
        pointEntitySigmob.commit();
    }

    public aj b(String ad_type) {
        this.c = ad_type;
        return this;
    }

    public aj c(String sub_category) {
        this.b = sub_category;
        return this;
    }

    public aj d(String placementId) {
        this.d = placementId;
        return this;
    }
}
