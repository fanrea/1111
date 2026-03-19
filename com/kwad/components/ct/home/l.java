package com.kwad.components.ct.home;

import com.kwad.sdk.api.KsContentPage;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l {
    private final List<m> aHu = new ArrayList();
    private KsContentPage.KsPageLeaveClickListener aHv;

    public final boolean Fu() {
        for (m mVar : this.aHu) {
            if (mVar != null && mVar.Fu()) {
                return true;
            }
        }
        return false;
    }

    public final void a(m mVar) {
        List<m> list = this.aHu;
        if (list != null) {
            list.add(mVar);
        }
    }

    public final void b(m mVar) {
        if (mVar != null) {
            this.aHu.remove(mVar);
        }
    }

    public final void clear() {
        this.aHu.clear();
    }

    public final void a(KsContentPage.KsPageLeaveClickListener ksPageLeaveClickListener) {
        this.aHv = ksPageLeaveClickListener;
    }

    public final void Fv() {
        KsContentPage.KsPageLeaveClickListener ksPageLeaveClickListener = this.aHv;
        if (ksPageLeaveClickListener != null) {
            ksPageLeaveClickListener.onPageLeaveClick();
        }
    }
}
