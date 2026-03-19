package com.sigmob.sdk.videoAd;

import android.content.Context;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.wire.Wire;
import com.kuaishou.socket.nano.SocketMessages;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.config.SigmobDialogSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.views.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends com.sigmob.sdk.base.common.h implements Serializable {
    private static final long serialVersionUID = 2;
    private int s;
    private int v;
    private boolean w;
    protected float m = 1.0f;
    protected int n = -1000;
    protected int o = 100;
    protected boolean p = false;
    private int r = -1;
    private boolean t = false;
    private c u = null;
    private final List<d> q = new ArrayList();
    protected boolean l = false;

    private a() {
    }

    private void c(final boolean isRewardedVideo) {
        this.l = isRewardedVideo;
    }

    public static a f(BaseAdUnit adUnit) {
        a aVar = new a();
        aVar.c(adUnit.getAd_type() == 1);
        aVar.d(adUnit.getMaterial().video_reciprocal_millisecond.intValue());
        aVar.b(adUnit.getMaterial().creative_type.intValue() != com.sigmob.sdk.base.common.l.CreativeTypeVideo_transparent_html.a());
        RvAdSetting rvAdSetting = adUnit.getRvAdSetting();
        SigmobDialogSetting sigmobDialogSettingY = o.a().y();
        aVar.a(sigmobDialogSettingY != null ? new c((String) Wire.get(sigmobDialogSettingY.title, ""), (String) Wire.get(sigmobDialogSettingY.body_text, ""), (String) Wire.get(sigmobDialogSettingY.cancel_button_text, ""), (String) Wire.get(sigmobDialogSettingY.close_button_text, "")) : new c(com.sigmob.sdk.base.k.l(), com.sigmob.sdk.base.k.k(), com.sigmob.sdk.base.k.n(), com.sigmob.sdk.base.k.m()));
        if (rvAdSetting != null) {
            aVar.a(rvAdSetting.enable_exit_on_video_close.booleanValue());
            aVar.a(rvAdSetting.finished.floatValue());
            aVar.c(rvAdSetting.end_time.intValue());
        }
        aVar.b(adUnit);
        return aVar;
    }

    public static f g(final BaseAdUnit adUnit) {
        if (adUnit == null) {
            return null;
        }
        MaterialMeta material = adUnit.getMaterial();
        return new f(SocketMessages.PayloadType.SC_LIVE_PK_KO_MODE, 1024, adUnit.getInteractionType(), material.landing_page, material.deeplink_url, new n(adUnit.resourcePath(), adUnit.getCreativeResourceType(), material.click_type.intValue() == 2 ? n.a.IMAGE : n.a.JAVASCRIPT, 720, 1024));
    }

    public void a(float videoFinish) {
        this.m = videoFinish;
    }

    public void a(final Context context, int contentPlayHead) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(Context context, int currentPostion, int duration, final BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(c mDialogConfig) {
        this.u = mDialogConfig;
    }

    @Override // com.sigmob.sdk.base.common.h
    public void a(final String dspCreativeId) {
        this.i = dspCreativeId;
    }

    public void a(boolean enableExitOnVideoClose) {
        this.t = enableExitOnVideoClose;
    }

    public void a(boolean isShowForce, int currentPosition, int duration, BaseAdUnit adUnit) {
    }

    public int b(int duration) {
        int i = this.v;
        return (i == 0 || i * 1000 > duration) ? duration : i * 1000;
    }

    @Override // com.sigmob.sdk.base.common.h
    public String b() {
        return this.i;
    }

    public void b(final Context context, int contentPlayHead) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void b(Context context, int currentPostion, int duration, final BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.h
    public void b(final Context context, final int contentPlayHead, final BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void b(boolean mIsAutoRemoveVideoView) {
        this.p = mIsAutoRemoveVideoView;
    }

    public void c(int end_time) {
        this.v = end_time;
    }

    public void c(Context context, int currentPostion, int duration, final BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.h
    public void c(final String customCtaText) {
        if (customCtaText == null) {
            return;
        }
        this.f = customCtaText;
    }

    @Override // com.sigmob.sdk.base.common.h
    public String d() {
        return this.f;
    }

    public void d(int seekPostion) {
        if (seekPostion == 0) {
            return;
        }
        this.n = seekPostion;
    }

    @Override // com.sigmob.sdk.base.common.h
    public void d(final String customSkipText) {
        if (customSkipText == null) {
            return;
        }
        this.g = customSkipText;
    }

    public int e(final int videoDuration) {
        return (int) (videoDuration * (this.o / 100.0f));
    }

    @Override // com.sigmob.sdk.base.common.h
    public String e() {
        return this.g;
    }

    @Override // com.sigmob.sdk.base.common.h
    public void e(final String customCloseIconUrl) {
        if (customCloseIconUrl == null) {
            return;
        }
        this.h = customCloseIconUrl;
    }

    @Override // com.sigmob.sdk.base.common.h
    public String f() {
        return this.h;
    }

    public void f(int mSkipSeconds) {
        this.r = mSkipSeconds;
    }

    public int l() {
        return this.v;
    }

    public boolean m() {
        return this.t;
    }

    public float n() {
        return this.m;
    }

    public int o() {
        return this.n;
    }

    public boolean p() {
        return this.p;
    }

    public c q() {
        return this.u;
    }

    public int r() {
        return 0;
    }

    public boolean s() {
        return this.l;
    }

    public int t() {
        return this.r;
    }
}
