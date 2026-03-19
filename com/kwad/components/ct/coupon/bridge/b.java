package com.kwad.components.ct.coupon.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.ct.feedback.FeedbackParams;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private Context amY;
    private String mFromPageName;

    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String amZ;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "gotoFeedback";
    }

    public b(Context context) {
        this(context, null);
    }

    private b(Context context, String str) {
        this.amY = context;
        this.mFromPageName = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.amY != null) {
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
            }
            FeedbackParams feedbackParams = new FeedbackParams();
            if (TextUtils.isEmpty(aVar.amZ)) {
                feedbackParams.mFromPageName = this.mFromPageName;
            } else {
                feedbackParams.mFromPageName = aVar.amZ;
            }
            Context context = this.amY;
            if (context != null) {
                com.kwad.components.ct.feedback.c.a(context, feedbackParams);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.amY = null;
    }
}
