package com.sigmob.sdk.base.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class x extends LinearLayout {
    private ImageView a;
    private View b;
    private View c;
    private TextView d;

    public x(Context context) {
        super(context);
        a(context);
    }

    public x(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
    }

    public x(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context);
    }

    private void a(Context context) {
        View viewInflate = inflate(context, ResourceUtil.getLayoutId(context, "sig_ad_privacy_new_layout"), this);
        this.a = (ImageView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_logo"));
        this.b = viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_view"));
        this.c = viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ll"));
        this.d = (TextView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_text"));
    }

    public void a(String logoUrl, boolean isShow) {
        if (!TextUtils.isEmpty(logoUrl)) {
            com.sigmob.sdk.base.common.g.a().load(logoUrl).into(this.a);
        }
        this.b.setVisibility(isShow ? 0 : 8);
    }

    public TextView getPrivacyAdText() {
        return this.d;
    }

    public View getPrivacyLl() {
        return this.c;
    }
}
