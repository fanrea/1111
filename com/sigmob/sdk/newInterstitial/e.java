package com.sigmob.sdk.newInterstitial;

import android.os.Bundle;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.TransparentAdActivity;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.l;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e extends com.sigmob.sdk.mraid.e {
    private NewInterstitialAdBroadcastReceiver c;

    public interface a extends n.b {
        void c(BaseAdUnit adUnit, String message);

        void o(BaseAdUnit adUnit);

        void p(BaseAdUnit adUnit);

        void q(BaseAdUnit adUnit);
    }

    protected e(n.b customEventInterstitialListener) {
        super(customEventInterstitialListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        Map options;
        if (!(obj instanceof PointEntitySigmob) || (options = ((PointEntitySigmob) obj).getOptions()) == null) {
            return;
        }
        options.put("show_count", String.valueOf(com.sigmob.sdk.base.common.g.h(str)));
        com.sigmob.sdk.base.common.g.g(str);
    }

    private static boolean b(MaterialMeta material) {
        return material.creative_type.intValue() == l.CreativeTypeMRAIDTWO.a();
    }

    public static boolean c(BaseAdUnit baseAdUnit) {
        boolean zD = d(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return zD && (b(material) || c(material));
    }

    private static boolean c(MaterialMeta material) {
        return material.creative_type.intValue() == l.CreativeTypeNewInterstitial.a() && material.template_id.intValue() != 0;
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    protected void a(n.b customEventInterstitialListener) {
        super.a(customEventInterstitialListener);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    public void a(BaseAdUnit baseAdUnit, Bundle option) {
        com.sigmob.sdk.base.common.g.a(baseAdUnit);
        super.a(baseAdUnit, option);
        if (this.a instanceof a) {
            NewInterstitialAdBroadcastReceiver newInterstitialAdBroadcastReceiver = new NewInterstitialAdBroadcastReceiver(baseAdUnit, (a) this.a, baseAdUnit.getUuid());
            this.c = newInterstitialAdBroadcastReceiver;
            newInterstitialAdBroadcastReceiver.a(newInterstitialAdBroadcastReceiver);
        }
        int ad_type = baseAdUnit.getAd_type();
        String str = BaseAdActivity.j;
        if (ad_type == 6) {
            if (baseAdUnit.getCreativeType() == l.CreativeTypeMRAIDTWO.a()) {
                str = BaseAdActivity.d;
            } else {
                baseAdUnit.getCreativeType();
                l.CreativeTypeNewInterstitial.a();
            }
        }
        final String adslot_id = baseAdUnit.getAdslot_id();
        ac.a(PointCategory.VOPEN, (String) null, baseAdUnit, (WindAdRequest) null, (LoadAdRequest) null, new ac.a() { // from class: com.sigmob.sdk.newInterstitial.e$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                e.a(adslot_id, obj);
            }
        });
        AdActivity.a(com.sigmob.sdk.b.e(), (baseAdUnit.getMaterial().theme_data.intValue() == 1 || baseAdUnit.getTemplateType() == 1) ? TransparentAdActivity.class : AdActivity.class, baseAdUnit.getUuid(), option, str);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    public boolean a(BaseAdUnit baseAdUnit) {
        boolean zA = super.a(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return zA && (b(material) || c(material));
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    public void b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.g.b(baseAdUnit);
        super.b(baseAdUnit);
    }
}
