package com.sigmob.sdk.splash;

import android.content.Context;
import android.widget.RelativeLayout;
import com.sigmob.sdk.base.common.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class b extends RelativeLayout {
    protected int a;

    public b(Context context) {
        super(context);
    }

    public static b a(Context context, BaseAdUnit adUnit) {
        MaterialMeta material;
        if (context == null || adUnit == null || (material = adUnit.getMaterial()) == null || material.creative_type == null) {
            return null;
        }
        return material.creative_type.intValue() == l.CreativeTypeSplashVideo.a() ? new f(context, adUnit) : new c(context);
    }

    public void a() {
        setVisibility(0);
    }

    public boolean a(BaseAdUnit adUnit) {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public int getDuration() {
        return this.a;
    }

    public void setAspectRatio(float aspectRatio) {
    }
}
