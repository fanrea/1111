package com.kwad.components.ct.detail.photo.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.home.ReportInfo;
import com.kwad.components.ec.api.EcLiveComponents;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.be;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f extends LinearLayout {
    private List<a> apV;
    protected g asK;
    private com.kwad.components.ct.detail.photo.e.c asO;
    public LinearLayout atb;
    public LinearLayout atc;
    public Button atd;
    public int ate;
    protected int atf;
    public com.kwad.components.ct.detail.photo.a.a atg;
    protected Presenter mPresenter;

    public interface a {
        void b(com.kwad.components.ct.detail.photo.e.d dVar);

        void onCancel();
    }

    public f(Context context) {
        super(context);
        this.atb = null;
        this.atc = null;
        this.atd = null;
        this.apV = new ArrayList();
        this.asO = new com.kwad.components.ct.detail.photo.e.c() { // from class: com.kwad.components.ct.detail.photo.d.f.1
            @Override // com.kwad.components.ct.detail.photo.e.c
            public final void b(com.kwad.components.ct.detail.photo.e.d dVar) {
                try {
                    f.this.a(dVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        initView();
    }

    protected void initView() {
        this.ate = R.layout.ksad_content_alliance_bottom_panel_2;
        LayoutInflater.from(getContext()).inflate(this.ate, (ViewGroup) this, true);
        this.atg = ((com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class)).zj();
        this.atb = (LinearLayout) findViewById(R.id.ksad_content_alliance_bottom_panel_layout);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_photo_bottom_panel_buttons_layout);
        this.atc = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.f.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        Button button = (Button) findViewById(R.id.ksad_photo_bottom_panel_cancel_button);
        this.atd = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.f.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    f.this.Aj();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.f.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    f.this.Aj();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        View viewFindViewById = findViewById(R.id.ksad_space);
        if (viewFindViewById == null || !com.kwad.sdk.core.config.e.XN()) {
            return;
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.f.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.atf++;
                if (f.this.atf > 10) {
                    com.kwad.sdk.utils.o.a(f.this.getContext(), "ksad_debug_deviceId_and_gid", "did:" + be.getDeviceId() + "——————egid:" + ag.aoE());
                    ac.ae(f.this.getContext(), "hello");
                    f.this.atf = 0;
                }
            }
        });
    }

    public final void b(h hVar) {
        d(hVar);
        this.asK = c(hVar);
        if (this.mPresenter == null) {
            Presenter presenterA = a(hVar);
            this.mPresenter = presenterA;
            presenterA.ak(this.atc);
        }
        this.mPresenter.K(this.asK);
    }

    private g c(h hVar) {
        g gVar = new g();
        gVar.ati = hVar;
        gVar.asO = this.asO;
        return gVar;
    }

    protected Presenter a(h hVar) {
        List<ReportInfo> listYV;
        Presenter presenter = new Presenter();
        CtAdTemplate ctAdTemplate = hVar.mAdTemplate;
        if (hVar.atl && (listYV = com.kwad.components.ct.detail.a.b.yV()) != null && !listYV.isEmpty()) {
            presenter.d(new j());
        }
        if (hVar.atk) {
            if (com.kwad.components.ct.response.a.a.aq(ctAdTemplate) || com.kwad.components.ct.response.a.a.ar(ctAdTemplate)) {
                EcLiveComponents ecLiveComponents = (EcLiveComponents) com.kwad.sdk.components.d.g(EcLiveComponents.class);
                if (ecLiveComponents != null) {
                    presenter.d(ecLiveComponents.LM());
                }
            } else if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
                if (com.kwad.components.ct.response.a.a.ba(ctAdTemplate) && !TextUtils.isEmpty(com.kwad.components.ct.response.a.a.bb((AdTemplate) ctAdTemplate))) {
                    presenter.d(new c());
                } else {
                    presenter.d(new n());
                }
            }
        }
        if (hVar.atj && com.kwad.components.ct.detail.a.b.za() && com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
            presenter.d(new e());
        }
        if (hVar.atm && com.kwad.components.ct.detail.a.b.zg()) {
            presenter.d(new b());
        }
        return presenter;
    }

    private void d(h hVar) {
        com.kwad.components.ct.detail.photo.a.a aVarZj;
        com.kwad.components.ct.detail.photo.a.b bVar = (com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class);
        if (hVar.atn) {
            aVarZj = bVar.zk();
        } else {
            aVarZj = bVar.zj();
        }
        com.kwad.components.ct.f.g.r(this.atb, aVarZj.aqv);
        com.kwad.components.ct.f.g.c(this.atd, aVarZj.aqx);
        com.kwad.components.ct.f.g.a(this.atd, aVarZj.aqw);
    }

    public final void destroy() {
        this.mPresenter.destroy();
    }

    public final void a(a aVar) {
        this.apV.add(aVar);
    }

    public final void b(a aVar) {
        this.apV.remove(aVar);
    }

    public final void a(com.kwad.components.ct.detail.photo.e.d dVar) {
        Iterator<a> it = this.apV.iterator();
        while (it.hasNext()) {
            it.next().b(dVar);
        }
    }

    protected final void Aj() {
        this.atf = 0;
        Iterator<a> it = this.apV.iterator();
        while (it.hasNext()) {
            it.next().onCancel();
        }
    }
}
