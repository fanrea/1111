package com.kwad.components.ct.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EntryLinearView extends a {
    private com.kwad.sdk.lib.widget.b<CtAdTemplate> aDP;
    private EntryPhotoView aDQ;
    private EntryPhotoView aDR;
    private List<CtAdTemplate> aDS;

    public EntryLinearView(Context context) {
        super(context);
        this.aDP = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
    }

    public EntryLinearView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDP = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
    }

    public void setRealShowItem(List<CtAdTemplate> list) {
        this.aDS = list;
    }

    @Override // com.kwad.components.ct.entry.view.a
    protected final boolean El() {
        this.aDP.clear();
        List<CtAdTemplate> list = this.aCR.aVj;
        this.aDS = list;
        for (CtAdTemplate ctAdTemplate : list) {
            if (!ctAdTemplate.needHide) {
                this.aDP.add(ctAdTemplate);
            }
            if (this.aDP.size() >= 2) {
                break;
            }
        }
        if (this.aDP.size() > 1) {
            a(this.aDQ, 0, this.aDP.get(0));
            a(this.aDR, 1, this.aDP.get(1));
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }

    private void a(EntryPhotoView entryPhotoView, int i, CtAdTemplate ctAdTemplate) {
        entryPhotoView.s(i, this.aCR.entryId);
        entryPhotoView.setOnEntryClickListener(n(i, ctAdTemplate));
        entryPhotoView.a(ctAdTemplate, this.aCR);
        entryPhotoView.setLikeViewPos(this.aCR.aVd);
        entryPhotoView.setAdShowStyle(1);
    }

    @Override // com.kwad.components.ct.entry.view.a
    protected List<CtAdTemplate> getRealShowData() {
        return this.aDP;
    }

    @Override // com.kwad.components.ct.entry.view.a, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.aDQ = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoleft);
        this.aDR = (EntryPhotoView) findViewById(R.id.ksad_entry2_photoright);
        a(this.aDQ);
        a(this.aDR);
    }

    private static void a(EntryPhotoView entryPhotoView) {
        entryPhotoView.setRatio(1.33f);
        entryPhotoView.p(true, true);
    }
}
