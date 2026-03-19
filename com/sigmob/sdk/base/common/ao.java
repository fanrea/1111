package com.sigmob.sdk.base.common;

import android.os.Bundle;
import android.text.TextUtils;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class ao extends com.sigmob.sdk.mraid.e {
    protected ao(n.b customEventInterstitialListener) {
        super(customEventInterstitialListener);
    }

    private static boolean b(MaterialMeta material) {
        return (material.creative_type.intValue() != l.CreativeTypeVideo_Tar.a() || TextUtils.isEmpty(material.endcard_md5) || TextUtils.isEmpty(material.endcard_url) || TextUtils.isEmpty(material.video_url)) ? false : true;
    }

    public static boolean c(BaseAdUnit baseAdUnit) {
        boolean zD = d(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return zD && (baseAdUnit.getCreativeType() == l.CreativeTypeMRAID.a() ? a(material) : b(material) || c(material) || d(material));
    }

    private static boolean c(MaterialMeta material) {
        return (material.creative_type.intValue() == l.CreativeTypeVideo_Html_Snippet.a() || material.creative_type.intValue() == l.CreativeTypeVideo_transparent_html.a()) && material.html_snippet != null && material.html_snippet.size() > 10 && !TextUtils.isEmpty(material.video_url);
    }

    private static boolean d(MaterialMeta material) {
        return (material.creative_type.intValue() != l.CreativeTypeVideo_EndCardURL.a() || TextUtils.isEmpty(material.html_url) || TextUtils.isEmpty(material.video_url)) ? false : true;
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    protected void a(n.b customEventInterstitialListener) {
        super.a(customEventInterstitialListener);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    public void a(BaseAdUnit baseAdUnit, Bundle option) {
        g.a(baseAdUnit);
        super.a(baseAdUnit, option);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    public boolean a(BaseAdUnit baseAdUnit) {
        boolean zA = super.a(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return zA && (baseAdUnit.getCreativeType() == l.CreativeTypeMRAID.a() ? a(material) : baseAdUnit.getCreativeType() == l.CreativeTypeMRAIDTWO.a() || b(material) || c(material) || d(material));
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    public void b(BaseAdUnit baseAdUnit) {
        g.b(baseAdUnit);
        super.b(baseAdUnit);
    }
}
