package com.kwad.components.ct.hotspot.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.hotspot.b.b;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a.a;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.glide.c;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HotspotListItemView extends KSFrameLayout {
    private TextView aQf;
    private TextView aQo;
    private ImageView aQp;
    private RoundAngleImageView aQq;
    private TextView aQr;
    private TextView aQs;
    private ImageView aQt;
    private boolean aQu;
    private final ColorDrawable aQv;
    private final ColorDrawable aQw;
    private m awn;

    public HotspotListItemView(Context context) {
        super(context);
        this.aQv = new ColorDrawable(Color.parseColor("#f0f0f0"));
        this.aQw = new ColorDrawable(Color.parseColor("#2B2B2F"));
    }

    public HotspotListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQv = new ColorDrawable(Color.parseColor("#f0f0f0"));
        this.aQw = new ColorDrawable(Color.parseColor("#2B2B2F"));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.m
    public final void E(View view) {
        super.E(view);
        m mVar = this.awn;
        if (mVar != null) {
            mVar.E(this);
        }
    }

    private void initView() {
        this.aQo = (TextView) findViewById(R.id.ksad_hot_list_item_rank);
        this.aQp = (ImageView) findViewById(R.id.ksad_hot_list_item_rank_label);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_hot_list_item_cover_img);
        this.aQq = roundAngleImageView;
        roundAngleImageView.setRadius(a.a(getContext(), 4.0f));
        this.aQf = (TextView) findViewById(R.id.ksad_hot_list_item_title);
        this.aQr = (TextView) findViewById(R.id.ksad_hot_list_item_video_count);
        this.aQs = (TextView) findViewById(R.id.ksad_hot_list_item_view_count);
        this.aQt = (ImageView) findViewById(R.id.ksad_hot_list_item_icon);
    }

    public void setVisibleListener(m mVar) {
        this.awn = mVar;
    }

    public final void a(HotspotInfo hotspotInfo, boolean z) {
        if (z) {
            setBackgroundColor(234881023);
        } else {
            setBackgroundColor(16777215);
        }
        if (hotspotInfo.rank == 1) {
            this.aQp.setVisibility(0);
            this.aQp.setImageResource(R.drawable.ksad_trend_list_logo_1);
            this.aQo.setVisibility(8);
        } else if (hotspotInfo.rank == 2) {
            this.aQp.setVisibility(0);
            this.aQp.setImageResource(R.drawable.ksad_trend_list_logo_2);
            this.aQo.setVisibility(8);
        } else if (hotspotInfo.rank == 3) {
            this.aQp.setVisibility(0);
            this.aQp.setImageResource(R.drawable.ksad_trend_list_logo_3);
            this.aQo.setVisibility(8);
        } else {
            this.aQo.setText(String.valueOf(hotspotInfo.rank));
            this.aQo.setVisibility(0);
            this.aQp.setVisibility(8);
        }
        c.cy(getContext()).hh(hotspotInfo.coverUrl).d(getColoDrawable()).f(getColoDrawable()).b(this.aQq);
        this.aQf.setText(hotspotInfo.name);
        this.aQr.setText(String.format(getContext().getString(R.string.ksad_trend_list_item_photo_count_format), Integer.valueOf(hotspotInfo.photoCount)));
        if (TextUtils.isEmpty(hotspotInfo.iconUrl)) {
            this.aQt.setVisibility(8);
        } else {
            this.aQt.setVisibility(0);
            c.cy(getContext()).hh(hotspotInfo.iconUrl).b(this.aQt);
        }
        this.aQs.setText(String.format(getContext().getString(R.string.ksad_photo_hot_enter_watch_count_format), bq.bD(hotspotInfo.viewCount)));
    }

    public final void ca(boolean z) {
        this.aQu = z;
        if (z) {
            IV();
        } else {
            IW();
        }
    }

    private void IV() {
        com.kwad.components.ct.hotspot.b.a aVarIS = ((b) d.Kb().a(b.class)).IS();
        g.a(this.aQo, aVarIS.aQk);
        g.a(this.aQf, aVarIS.aQl);
        g.a(this.aQr, aVarIS.aQm);
        g.a(this.aQs, aVarIS.aQn);
    }

    private ColorDrawable getColoDrawable() {
        if (this.aQu && d.Kb().wR() == 0) {
            return this.aQv;
        }
        return this.aQw;
    }

    private void IW() {
        d.Kb().a(b.class);
        com.kwad.components.ct.hotspot.b.a aVarIU = b.IU();
        g.a(this.aQo, aVarIU.aQk);
        g.a(this.aQf, aVarIU.aQl);
        g.a(this.aQr, aVarIU.aQm);
        g.a(this.aQs, aVarIU.aQn);
    }
}
