package com.kwad.components.ct.horizontal.news.a.b;

import android.text.TextUtils;
import android.widget.TextView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.horizontal.news.a.a.a {
    private TextView Fa;
    private TextView Pc;
    private TextView aMe;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Pc = (TextView) findViewById(R.id.ksad_news_item_title);
        this.Fa = (TextView) findViewById(R.id.ksad_news_item_author_name);
        this.aMe = (TextView) findViewById(R.id.ksad_news_item_date);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).cdM;
        String strAN = com.kwad.components.ct.response.a.a.aN(ctAdTemplate);
        if (TextUtils.isEmpty(strAN)) {
            this.Pc.setVisibility(8);
        } else {
            this.Pc.setText(strAN);
            this.Pc.setVisibility(0);
        }
        String strAL = com.kwad.components.ct.response.a.a.aL(ctAdTemplate);
        if (TextUtils.isEmpty(strAL)) {
            this.Fa.setVisibility(8);
        } else {
            this.Fa.setText(strAL);
            this.Fa.setVisibility(0);
        }
        this.aMe.setText(bq.bL(com.kwad.components.ct.response.a.a.aP(ctAdTemplate)));
    }
}
