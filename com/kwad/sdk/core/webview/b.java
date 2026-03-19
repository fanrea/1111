package com.kwad.sdk.core.webview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    public WebView UO;
    public ViewGroup Vu;
    public i bLv;
    public an bLw;
    private AdResultData mAdResultData;
    public JSONObject mReportExtData;
    public int mScreenOrientation;
    public boolean bLx = true;
    public boolean bLy = true;
    private List<AdTemplate> aIT = null;

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
    }

    public final AdResultData iy() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData;
        }
        if (this.aIT == null) {
            return null;
        }
        AdResultData adResultData2 = new AdResultData();
        adResultData2.setAdTemplateList(this.aIT);
        return adResultData2;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.aIT = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.aIT = arrayList;
    }

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.aIT;
        if (list != null && list.size() > 0) {
            return this.aIT.get(0);
        }
        return com.kwad.sdk.core.response.b.c.s(this.mAdResultData);
    }

    public final List<AdTemplate> xc() {
        List<AdTemplate> list = this.aIT;
        if (list != null && list.size() > 0) {
            return this.aIT;
        }
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.getAdTemplateList();
        }
        return null;
    }

    public final AdTemplate eA(String str) {
        if (TextUtils.isEmpty(str)) {
            return getAdTemplate();
        }
        List<AdTemplate> listXc = xc();
        if (listXc == null) {
            return null;
        }
        for (AdTemplate adTemplate : listXc) {
            if (bq.isEquals(str, String.valueOf(com.kwad.sdk.core.response.b.e.eV(adTemplate)))) {
                return adTemplate;
            }
        }
        return null;
    }

    public final boolean adx() {
        return xc() == null || xc().size() == 0;
    }

    public final Context getContext() {
        WebView webView = this.UO;
        if (webView == null) {
            return null;
        }
        return webView.getContext();
    }
}
