package com.sigmob.sdk.videoAd;

import com.sigmob.sdk.base.common.ao;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g extends ao {
    private RewardVideoAdBroadcastReceiver c;
    private final boolean d;

    public interface a extends n.b {
        void c(BaseAdUnit adUnit, String message);

        void o(BaseAdUnit adUnit);

        void p(BaseAdUnit adUnit);

        void q(BaseAdUnit adUnit);

        void r(BaseAdUnit adUnit);
    }

    public g(n.b customEventInterstitialListener, boolean isHalfInterstitial) {
        super(customEventInterstitialListener);
        this.d = isHalfInterstitial;
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    @Override // com.sigmob.sdk.base.common.ao, com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.sigmob.sdk.base.models.BaseAdUnit r11, android.os.Bundle r12) {
        /*
            r10 = this;
            super.a(r11, r12)
            com.sigmob.sdk.base.common.n$b r0 = r10.a
            boolean r0 = r0 instanceof com.sigmob.sdk.videoAd.g.a
            if (r0 == 0) goto L1b
            com.sigmob.sdk.videoAd.RewardVideoAdBroadcastReceiver r0 = new com.sigmob.sdk.videoAd.RewardVideoAdBroadcastReceiver
            com.sigmob.sdk.base.common.n$b r1 = r10.a
            com.sigmob.sdk.videoAd.g$a r1 = (com.sigmob.sdk.videoAd.g.a) r1
            java.lang.String r2 = r11.getUuid()
            r0.<init>(r11, r1, r2)
            r10.c = r0
            r0.a(r0)
        L1b:
            int r0 = r11.getAd_type()
            r1 = 4
            r2 = 1
            if (r0 == r2) goto L29
            int r0 = r11.getAd_type()
            if (r0 != r1) goto L47
        L29:
            int r0 = r11.getCreativeType()
            com.sigmob.sdk.base.common.l r3 = com.sigmob.sdk.base.common.l.CreativeTypeMRAID
            int r3 = r3.a()
            if (r0 != r3) goto L38
            java.lang.String r0 = "mraid"
            goto L49
        L38:
            int r0 = r11.getCreativeType()
            com.sigmob.sdk.base.common.l r3 = com.sigmob.sdk.base.common.l.CreativeTypeMRAIDTWO
            int r3 = r3.a()
            if (r0 != r3) goto L47
            java.lang.String r0 = "mraid_two"
            goto L49
        L47:
            java.lang.String r0 = "reward"
        L49:
            if (r12 == 0) goto L52
            boolean r3 = r10.d
            java.lang.String r4 = "isHalfInterstitial"
            r12.putBoolean(r4, r3)
        L52:
            java.lang.String r3 = r11.getAdslot_id()
            r5 = 0
            r7 = 0
            r8 = 0
            com.sigmob.sdk.videoAd.g$$ExternalSyntheticLambda0 r9 = new com.sigmob.sdk.videoAd.g$$ExternalSyntheticLambda0
            r9.<init>()
            java.lang.String r4 = "vopen"
            r6 = r11
            com.sigmob.sdk.base.common.ac.a(r4, r5, r6, r7, r8, r9)
            int r3 = r11.getAd_type()
            if (r3 != r1) goto L7b
            com.sigmob.sdk.base.models.rtb.MaterialMeta r1 = r11.getMaterial()
            java.lang.Integer r1 = r1.theme_data
            int r1 = r1.intValue()
            if (r1 == r2) goto L99
            boolean r1 = r10.d
            if (r1 != 0) goto L99
        L7b:
            int r1 = r11.getCreativeType()
            com.sigmob.sdk.base.common.l r3 = com.sigmob.sdk.base.common.l.CreativeTypeMRAIDTWO
            int r3 = r3.a()
            if (r1 != r3) goto L9c
            com.sigmob.sdk.base.models.rtb.MaterialMeta r1 = r11.getMaterial()
            java.lang.Integer r1 = r1.theme_data
            int r1 = r1.intValue()
            if (r1 == r2) goto L99
            int r1 = r11.getTemplateType()
            if (r1 != r2) goto L9c
        L99:
            java.lang.Class<com.sigmob.sdk.base.common.TransparentAdActivity> r1 = com.sigmob.sdk.base.common.TransparentAdActivity.class
            goto L9e
        L9c:
            java.lang.Class<com.sigmob.sdk.base.common.AdActivity> r1 = com.sigmob.sdk.base.common.AdActivity.class
        L9e:
            android.content.Context r2 = com.sigmob.sdk.b.e()
            java.lang.String r11 = r11.getUuid()
            com.sigmob.sdk.base.common.AdActivity.a(r2, r1, r11, r12, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.g.a(com.sigmob.sdk.base.models.BaseAdUnit, android.os.Bundle):void");
    }

    @Override // com.sigmob.sdk.base.common.ao, com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.w
    public void b(BaseAdUnit baseAdUnit) {
        RewardVideoAdBroadcastReceiver rewardVideoAdBroadcastReceiver = this.c;
        if (rewardVideoAdBroadcastReceiver != null) {
            rewardVideoAdBroadcastReceiver.b(rewardVideoAdBroadcastReceiver);
            this.c = null;
        }
        super.b(baseAdUnit);
    }
}
