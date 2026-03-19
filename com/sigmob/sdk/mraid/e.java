package com.sigmob.sdk.mraid;

import android.os.Bundle;
import android.text.TextUtils;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.common.w;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e extends w {
    protected e(n.b customEventInterstitialListener) {
        super(customEventInterstitialListener);
    }

    protected static boolean a(MaterialMeta material) {
        return material.creative_type.intValue() == com.sigmob.sdk.base.common.l.CreativeTypeMRAID.a() && (!TextUtils.isEmpty(material.html_url) || (material.html_snippet != null && material.html_snippet.size() > 10));
    }

    public static boolean d(BaseAdUnit adUnit) {
        return (adUnit == null || adUnit.getMaterial() == null || TextUtils.isEmpty(adUnit.getCrid())) ? false : true;
    }

    @Override // com.sigmob.sdk.base.common.w
    protected void a(n.b customEventInterstitialListener) {
        this.a = customEventInterstitialListener;
    }

    @Override // com.sigmob.sdk.base.common.w
    public void a(BaseAdUnit adUnit, Bundle option) {
        List<BaseAdUnit> listE;
        if (adUnit.getCreativeType() == com.sigmob.sdk.base.common.l.CreativeTypeMRAIDTWO.a() && (listE = com.sigmob.sdk.base.common.g.e(adUnit.getUuid())) == null) {
            com.sigmob.sdk.mraid2.b.a().a(adUnit.getUuid(), new com.sigmob.sdk.mraid2.d(com.sigmob.sdk.b.e(), listE));
        }
        super.a(adUnit, option);
    }

    @Override // com.sigmob.sdk.base.common.w
    public boolean a(BaseAdUnit adUnit) {
        return d(adUnit);
    }

    @Override // com.sigmob.sdk.base.common.w
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
    }
}
