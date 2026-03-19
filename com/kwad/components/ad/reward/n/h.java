package com.kwad.components.ad.reward.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class h extends s implements View.OnClickListener {
    protected KsConvertButton DN;
    protected TextView DO;
    protected TextView DP;
    protected TextView DQ;
    protected a DR;
    protected int DS = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean DT = true;
    protected ImageView Ds;
    protected KsAppTagsView Dw;
    protected KsLogoView mLogoView;

    public interface a {
        void jo();

        void jp();

        void jq();

        void jr();

        void js();

        void jt();
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, jn(), li());
        g(this.xM);
        if (this.xM != null) {
            this.xM.setOnClickListener(this);
            this.DN.setOnClickListener(this);
            this.Ds.setOnClickListener(this);
            this.DO.setOnClickListener(this);
            TextView textView = this.DP;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.DQ;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.Dw;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    protected int jn() {
        return R.id.ksad_common_app_card_stub;
    }

    private static int li() {
        return R.id.ksad_common_app_card_root;
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_common_app_logo);
        this.Ds = (ImageView) viewGroup.findViewById(R.id.ksad_common_app_icon);
        this.DO = (TextView) viewGroup.findViewById(R.id.ksad_common_app_name);
        this.Dw = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_common_app_tags);
        this.DP = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc);
        this.DQ = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc2);
        this.DN = (KsConvertButton) viewGroup.findViewById(R.id.ksad_common_app_action);
    }

    public final void a(a aVar) {
        this.DR = aVar;
    }

    public final void show() {
        if (this.xM != null) {
            this.xM.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.DT));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.components.ad.reward.model.a r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r6.iq()
            r5.ag(r0)
            com.kwad.components.core.widget.KsLogoView r0 = r5.mLogoView
            if (r0 == 0) goto L15
            com.kwad.sdk.core.response.model.AdTemplate r1 = r6.im()
            r0.aQ(r1)
        L15:
            android.widget.TextView r0 = r5.DO
            java.lang.String r1 = r6.getTitle()
            r0.setText(r1)
            android.widget.TextView r0 = r5.DP
            if (r0 == 0) goto L29
            java.lang.String r1 = r6.ht()
            r0.setText(r1)
        L29:
            android.widget.TextView r0 = r5.DQ
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L59
            java.lang.String r3 = r6.ht()
            r0.setText(r3)
            java.lang.String r0 = r6.ht()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L44
            r0 = r2
            r3 = r0
            goto L4f
        L44:
            boolean r0 = r6.ip()
            if (r0 == 0) goto L4d
            r3 = r1
            r0 = r2
            goto L4f
        L4d:
            r0 = r1
            r3 = r2
        L4f:
            android.widget.TextView r4 = r5.DP
            if (r4 == 0) goto L56
            r4.setVisibility(r0)
        L56:
            android.widget.TextView r0 = r5.DQ
            goto L6a
        L59:
            android.widget.TextView r0 = r5.DP
            if (r0 == 0) goto L6d
            java.lang.String r3 = r6.ht()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L69
            r3 = r2
            goto L6a
        L69:
            r3 = r1
        L6a:
            r0.setVisibility(r3)
        L6d:
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.Dw
            if (r0 == 0) goto L86
            java.util.List r3 = r6.io()
            int r4 = r5.DS
            r0.a(r3, r4)
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.Dw
            boolean r3 = r6.ip()
            if (r3 == 0) goto L83
            r1 = r2
        L83:
            r0.setVisibility(r1)
        L86:
            com.kwad.components.core.widget.KsConvertButton r0 = r5.DN
            if (r0 == 0) goto L95
            com.kwad.components.core.e.d.c r1 = r6.in()
            com.kwad.sdk.core.response.model.AdTemplate r2 = r6.im()
            r0.a(r1, r2)
        L95:
            android.widget.ImageView r0 = r5.Ds
            java.lang.String r1 = r6.hs()
            com.kwad.sdk.core.response.model.AdTemplate r6 = r6.im()
            r2 = 12
            com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, r1, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.n.h.a(com.kwad.components.ad.reward.model.a):void");
    }

    private void ag(int i) {
        KsConvertButton ksConvertButton = this.DN;
        if (ksConvertButton == null) {
            return;
        }
        if (i == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i == 2) {
            ksConvertButton.getCornerConf().dM(false).dP(false).dO(true).dN(true);
        }
        this.DN.postInvalidate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.DN)) {
            a aVar2 = this.DR;
            if (aVar2 != null) {
                aVar2.jo();
                return;
            }
            return;
        }
        if (view.equals(this.Ds)) {
            a aVar3 = this.DR;
            if (aVar3 != null) {
                aVar3.jp();
                return;
            }
            return;
        }
        if (view.equals(this.DO)) {
            a aVar4 = this.DR;
            if (aVar4 != null) {
                aVar4.jq();
                return;
            }
            return;
        }
        if (view.equals(this.DP) || view.equals(this.DQ)) {
            a aVar5 = this.DR;
            if (aVar5 != null) {
                aVar5.jr();
                return;
            }
            return;
        }
        if (view.equals(this.Dw)) {
            a aVar6 = this.DR;
            if (aVar6 != null) {
                aVar6.js();
                return;
            }
            return;
        }
        if (!view.equals(this.xM) || (aVar = this.DR) == null) {
            return;
        }
        aVar.jt();
    }
}
