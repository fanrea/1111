package com.kwad.components.ct.detail.photo.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ct.detail.photo.d.m;
import com.kwad.components.ct.detail.photo.widget.FlowLayout;
import com.kwad.components.ct.response.model.home.ReportInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k extends LinearLayout {
    private List<m.a> apV;
    private LinearLayout atb;
    private com.kwad.components.ct.detail.photo.a.a atg;
    private FlowLayout att;
    private TextView atu;
    private View atv;
    private ImageView atw;
    private l atx;
    private o aty;
    private TextView atz;

    public k(Context context) {
        super(context);
        this.atb = null;
        this.apV = new ArrayList();
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_more_report_dislike_panel, (ViewGroup) this, true);
        this.atg = ((com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class)).zj();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_more_report_dislike_panel_layout);
        this.atb = linearLayout;
        com.kwad.components.ct.f.g.r(linearLayout, this.atg.aqv);
        TextView textView = (TextView) findViewById(R.id.ksad_more_report_dislike_panel_tilte);
        this.atz = textView;
        com.kwad.components.ct.f.g.a(textView, this.atg.aqy);
        this.att = (FlowLayout) findViewById(R.id.ksad_more_report_dislike_content_layout);
        View viewFindViewById = findViewById(R.id.ksad_more_report_dislike_title_layout);
        this.atv = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.k.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        o oVar = new o(getContext(), com.kwad.components.ct.detail.a.b.yV());
        this.aty = oVar;
        oVar.a(new FlowLayout.a.InterfaceC0510a() { // from class: com.kwad.components.ct.detail.photo.d.k.2
            @Override // com.kwad.components.ct.detail.photo.widget.FlowLayout.a.InterfaceC0510a
            public final void onChanged() {
                if (k.this.aty.An() != null) {
                    k.this.atu.setText("确认提交");
                } else {
                    k.this.atu.setText("取消");
                }
            }
        });
        this.att.setAdapter(this.aty);
        this.att.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.k.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.ksad_more_report_dislike_commit_btn);
        this.atu = textView2;
        com.kwad.components.ct.f.g.c(textView2, this.atg.aqx);
        com.kwad.components.ct.f.g.a(this.atu, this.atg.aqw);
        this.atu.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.k.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportInfo reportInfoAn = k.this.aty.An();
                if (reportInfoAn != null && k.this.atx != null && k.this.atx.zR() != null) {
                    com.kwad.components.ct.e.b.JK().p(k.this.atx.zR(), reportInfoAn.reportId);
                    ac.ae(k.this.getContext(), "举报成功，我们将在24小时内处理");
                }
                k.this.Am();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.ksad_more_report_dislike_close_btn);
        this.atw = imageView;
        com.kwad.components.ct.f.g.a(imageView, this.atg.aqE);
        this.atw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.k.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.Am();
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.k.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.Am();
            }
        });
    }

    public final void a(m.a aVar) {
        this.apV.add(aVar);
    }

    public final void b(m.a aVar) {
        this.apV.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Am() {
        Iterator<m.a> it = this.apV.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
        }
    }

    public final void destroy() {
        this.apV.clear();
        this.aty.clear();
    }

    public final void a(l lVar) {
        this.atx = lVar;
    }
}
