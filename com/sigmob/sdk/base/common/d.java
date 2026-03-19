package com.sigmob.sdk.base.common;

import android.text.TextUtils;
import android.util.Log;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.windad.WindAdRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements g.b {
    private final List<BaseAdUnit> b;
    private final g.b c;
    private final LoadAdRequest d;
    private final String a = "AdListCacheManger";
    private final List<BaseAdUnit> e = new ArrayList();

    public d(List<BaseAdUnit> adUnits, g.b listener, LoadAdRequest loadAdRequest) {
        this.b = adUnits;
        this.c = listener;
        this.d = loadAdRequest;
    }

    @Override // com.sigmob.sdk.base.common.g.b
    public void a(BaseAdUnit adUnit) {
        g.b bVar = this.c;
        if (bVar != null) {
            bVar.a(adUnit);
        }
    }

    @Override // com.sigmob.sdk.base.common.g.b
    public void a(BaseAdUnit adUnit, String message) {
        if (com.sigmob.sdk.base.utils.e.a(this.b)) {
            return;
        }
        BaseAdUnit baseAdUnit = this.b.get(0);
        if (adUnit != baseAdUnit) {
            com.sigmob.sdk.base.network.g.a(adUnit, TextUtils.isEmpty(message) ? a.B : a.C);
            ac.a(PointCategory.LOADEND, TextUtils.isEmpty(message) ? "1" : "0", adUnit, (WindAdRequest) null, this.d, (ac.a) null);
        } else {
            g.b bVar = this.c;
            if (bVar != null) {
                bVar.a(baseAdUnit, message);
            }
            Log.d("AdListCacheManger", "loadEnd: size = " + this.e.size());
        }
    }

    public boolean a(boolean showAd) {
        if (com.sigmob.sdk.base.utils.e.b(this.b)) {
            if (showAd) {
                BaseAdUnit baseAdUnit = this.b.get(0);
                if (baseAdUnit.getPlayMode() == 2) {
                    this.e.add(baseAdUnit);
                    g.g().a(baseAdUnit, this);
                }
            } else {
                for (int i = 0; i < this.b.size(); i++) {
                    BaseAdUnit baseAdUnit2 = this.b.get(i);
                    if (baseAdUnit2.getPlayMode() != 2) {
                        this.e.add(baseAdUnit2);
                        baseAdUnit2.setCatchVideo(true);
                        g.g().a(baseAdUnit2, this);
                    }
                }
            }
            Log.d("AdListCacheManger", "cacheList: size = " + this.e.size());
        }
        return !this.e.isEmpty();
    }
}
