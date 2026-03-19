package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f extends RelativeLayout {
    private View a;

    public f(Context context) {
        super(context);
    }

    public void a(int resId) {
        this.a = inflate(getContext(), resId, this);
    }

    public SigAdInfoView getAdInfView() {
        View view = this.a;
        if (view == null) {
            return null;
        }
        return (SigAdInfoView) view.findViewById(ResourceUtil.getId(getContext(), "sig_app_info"));
    }

    public Button getCTAButton() {
        View view = this.a;
        if (view == null) {
            return null;
        }
        return (Button) view.findViewById(ResourceUtil.getId(getContext(), "sig_cta_button"));
    }

    public NewInterstitialHeaderView getHeaderView() {
        View view = this.a;
        if (view == null) {
            return null;
        }
        return (NewInterstitialHeaderView) view.findViewById(ResourceUtil.getId(getContext(), "sig_ad_header"));
    }

    public ViewGroup getMainAdContainer() {
        View view = this.a;
        if (view == null) {
            return null;
        }
        return (ViewGroup) view.findViewById(ResourceUtil.getId(getContext(), "sig_ad_container"));
    }
}
