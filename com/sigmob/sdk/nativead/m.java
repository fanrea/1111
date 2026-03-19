package com.sigmob.sdk.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.views.CircleImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class m extends RelativeLayout {
    private TextView a;
    private TextView b;
    private ViewGroup c;
    private CircleImageView d;

    public m(Context context) {
        super(context);
        View.inflate(context, getLayoutId(), this);
        this.a = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_name"));
        this.b = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_cta"));
        this.c = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_app_icon"));
        CircleImageView circleImageView = new CircleImageView(context);
        this.d = circleImageView;
        circleImageView.setCircle(false);
        this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.c.addView(this.d, new ViewGroup.LayoutParams(-1, -1));
    }

    private int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_app_layout");
    }

    public void a(String iconUrl, String name, String cta) {
        this.a.setText(name);
        this.b.setText(cta);
        Context contextE = com.sigmob.sdk.b.e();
        if (contextE == null) {
            return;
        }
        ImageManager.with(contextE).load(iconUrl).into(this.d);
    }

    public View getCtaView() {
        return this.b;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.b.setOnClickListener(l);
    }
}
