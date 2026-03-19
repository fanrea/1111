package com.kwad.components.ct.detail.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SlidePlayViewPager extends SlidePlayTouchViewPager {
    private b aAa;
    private com.kwad.components.ct.home.d aAb;
    private boolean aAc;
    private boolean aAd;
    private boolean aAe;
    private KsFragment alG;
    private j aol;
    private com.kwad.components.ct.api.a.a.c<CtAdTemplate> ayi;
    private com.kwad.components.ct.g.a azL;
    private int azO;
    private g azZ;
    private Presenter mPresenter;

    public SlidePlayViewPager(Context context) {
        this(context, null);
    }

    public SlidePlayViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azO = 0;
    }

    public final void a(com.kwad.components.ct.home.f fVar, com.kwad.components.ct.refreshview.e eVar) {
        this.aAb = fVar;
        this.alG = fVar.aGE;
        this.azU = eVar;
        this.ayi = fVar.ayi;
        this.azL = fVar.aGF;
        this.aol = fVar.aol;
        this.azO = 0;
        this.aAc = fVar.aAc;
        this.aAe = false;
        CV();
        this.azS = fVar.azS;
        this.azT = true;
        if (this.aAc) {
            this.aAa = new a(this.alG.getChildFragmentManager());
        } else {
            this.aAa = new c(this.alG.getChildFragmentManager());
        }
        this.aAa.b(this.azL);
        this.aAa.a(this.aol);
        this.aAa.a(this);
        Da();
        CZ();
        this.mPresenter.K(this.azZ);
        setAdapter(this.aAa);
        setCurrentItem(this.aAb.aGI);
    }

    private void CZ() {
        g gVar = new g();
        this.azZ = gVar;
        gVar.ayi = this.ayi;
        this.azZ.alG = this.alG;
        this.azZ.aok = this;
        this.azZ.azU = this.azU;
        this.azZ.aBu = this.aAb.aBu;
        this.azZ.mScene = this.aAb.mSceneImpl;
        this.azZ.aBv = this.aAb.aBv;
    }

    private void Da() {
        Presenter presenter = new Presenter();
        this.mPresenter = presenter;
        presenter.d(new com.kwad.components.ct.detail.viewpager.a.b());
        this.mPresenter.d(new com.kwad.components.ct.detail.viewpager.a.a());
        this.mPresenter.ak(this);
    }

    @Override // com.kwad.components.ct.detail.viewpager.e, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void destroy() {
        this.mPresenter.destroy();
        b bVar = this.aAa;
        if (bVar != null) {
            bVar.bF(true);
            this.aAa.CT();
        }
    }

    @Override // com.kwad.components.ct.detail.viewpager.e
    public b getAdapter() {
        return this.aAa;
    }

    public final void Db() {
        this.azS = false;
    }

    public void setReportedItemImpression(boolean z) {
        this.aAd = z;
    }

    public final boolean Dc() {
        return this.aAd;
    }

    public final void Dd() {
        this.azS = this.aAb.azS;
    }

    public final void z(List<CtAdTemplate> list) {
        this.aAa.z(list);
    }

    public final void a(CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2, int i, int i2) {
        this.aAa.a(this.ayi.xc(), ctAdTemplate, ctAdTemplate2, 1, 0);
    }

    public final void A(List<CtAdTemplate> list) {
        b bVar = this.aAa;
        if (bVar != null) {
            bVar.bF(true);
        }
        if (this.alG.getHost() == null) {
            com.kwad.sdk.core.d.c.w("SlidePlayViewPager", "mFragment mHost is null");
            return;
        }
        CV();
        if (this.aAc) {
            this.aAa = new a(this.alG.getChildFragmentManager());
        } else {
            this.aAa = new c(this.alG.getChildFragmentManager());
        }
        this.aAa.b(this.azL);
        this.aAa.a(this.aol);
        this.aAa.a(this);
        setAdapter(this.aAa);
        this.aAa.z(list);
        setCurrentItem(0);
    }

    public final void bH(boolean z) {
        int realPosition;
        if (!isEmpty() && (realPosition = getRealPosition()) >= 0 && realPosition < getAdapter().CR() - 1) {
            setCurrentItem(realPosition + 1, true);
        }
    }

    public final boolean h(int i, boolean z) {
        int iCR = getAdapter().CR();
        if (i < 0 || i >= iCR) {
            return false;
        }
        setCurrentItem(i, true);
        return true;
    }

    public final void bW(int i) {
        if (this.aAe || i == this.aAb.aGI) {
            return;
        }
        this.aAe = true;
        setCurrentItem(i, false);
    }

    public final boolean bI(boolean z) {
        int realPosition;
        if (isEmpty()) {
            return false;
        }
        if (z) {
            realPosition = De();
        } else {
            realPosition = getRealPosition() + 1;
        }
        if (realPosition < 0 || realPosition >= getAdapter().CR()) {
            return false;
        }
        setCurrentItem(realPosition, true);
        return true;
    }

    private int De() {
        List<CtAdTemplate> data = getData();
        if (data != null && !data.isEmpty()) {
            int iIndexOf = data.indexOf(getCurrentData());
            do {
                iIndexOf++;
                if (iIndexOf < data.size() - 1) {
                }
            } while (!com.kwad.components.ct.response.a.a.as(data.get(iIndexOf)));
            return iIndexOf;
        }
        return -1;
    }

    public int getRealPosition() {
        b bVar = this.aAa;
        if (bVar != null) {
            return bVar.bO(getCurrentItem());
        }
        return 0;
    }

    public final int bO(int i) {
        b bVar = this.aAa;
        if (bVar != null) {
            return bVar.bO(i);
        }
        return 0;
    }

    public final void a(CtAdTemplate ctAdTemplate, int i, boolean z) {
        this.azO = i;
        if (i == 1) {
            this.azS = false;
        } else {
            this.azS = this.aAb.azS;
        }
        this.aAa.a(this.ayi.xc(), ctAdTemplate, i, this.ayi.aX(ctAdTemplate), z);
    }

    public final void i(CtAdTemplate ctAdTemplate) {
        int iAW = this.ayi.aW(ctAdTemplate);
        if (iAW >= 0) {
            setCurrentItem(iAW, false);
        }
    }

    @Override // com.kwad.components.ct.detail.viewpager.e
    protected final void setCurrentItem(int i) {
        b bVar = this.aAa;
        if (bVar != null) {
            super.setCurrentItem(bVar.bP(i));
        }
    }

    @Override // com.kwad.components.ct.detail.viewpager.e
    public final void setCurrentItem(int i, boolean z) {
        b bVar = this.aAa;
        if (bVar != null) {
            super.setCurrentItem(bVar.bP(i), z);
        }
    }

    @Override // com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager
    protected int getFirstValidItemPosition() {
        b bVar = this.aAa;
        if (bVar != null) {
            return bVar.getFirstValidItemPosition();
        }
        return super.getFirstValidItemPosition();
    }

    @Override // com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager
    protected int getLastValidItemPosition() {
        b bVar = this.aAa;
        if (bVar != null) {
            return bVar.getLastValidItemPosition();
        }
        return super.getLastValidItemPosition();
    }

    @Override // com.kwad.components.ct.detail.viewpager.e
    public void setInitStartPosition(int i) {
        b bVar = this.aAa;
        if (bVar != null) {
            super.setInitStartPosition(bVar.bP(i));
        }
        super.setInitStartPosition(i);
    }

    public List<CtAdTemplate> getData() {
        b bVar = this.aAa;
        if (bVar != null) {
            return bVar.getData();
        }
        return null;
    }

    public CtAdTemplate getCurrentData() {
        b bVar = this.aAa;
        if (bVar != null) {
            return bVar.bR(getCurrentItem());
        }
        return null;
    }

    public final CtAdTemplate bR(int i) {
        b bVar = this.aAa;
        if (bVar != null) {
            return bVar.bR(i);
        }
        return null;
    }

    public final boolean isEmpty() {
        b bVar = this.aAa;
        return bVar == null || bVar.getData().size() == 0;
    }

    public int getSourceType() {
        return this.azO;
    }

    public final boolean hasNext() {
        int realPosition = this.azZ.aok.getRealPosition();
        return realPosition >= 0 && realPosition < this.aAa.CR() - 1;
    }
}
