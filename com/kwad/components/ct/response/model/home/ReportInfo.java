package com.kwad.components.ct.response.model.home;

import com.kwad.sdk.core.response.a.a;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ReportInfo extends a implements Serializable {
    private static final long serialVersionUID = 6025862320437448216L;
    public String content;
    public int reportId;

    public ReportInfo() {
    }

    public ReportInfo(int i, String str) {
        this.reportId = i;
        this.content = str;
    }
}
