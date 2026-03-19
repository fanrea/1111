package com.kwad.components.ct.widget.a.a;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.lib.widget.a.a.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e<CtAdTemplate> {
    @Override // com.kwad.sdk.lib.widget.a.a.e
    public final /* synthetic */ boolean areContentsTheSame(CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2) {
        return e(ctAdTemplate, ctAdTemplate2);
    }

    @Override // com.kwad.sdk.lib.widget.a.a.e
    public final /* synthetic */ boolean areItemsTheSame(CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2) {
        return d(ctAdTemplate, ctAdTemplate2);
    }

    private static boolean d(CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2) {
        if (ctAdTemplate != null && ctAdTemplate2 != null) {
            if (com.kwad.components.ct.response.a.a.aq(ctAdTemplate)) {
                return com.kwad.components.ct.response.a.a.aq(ctAdTemplate2) && com.kwad.components.ct.response.model.live.a.a(com.kwad.components.ct.response.a.a.aS(ctAdTemplate)) == com.kwad.components.ct.response.model.live.a.a(com.kwad.components.ct.response.a.a.aS(ctAdTemplate2));
            }
            if (com.kwad.components.ct.response.a.a.bg(ctAdTemplate) == com.kwad.components.ct.response.a.a.bg(ctAdTemplate2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean e(CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2) {
        if (ctAdTemplate == null && ctAdTemplate2 == null) {
            return true;
        }
        return ctAdTemplate != null && ctAdTemplate.equals(ctAdTemplate2);
    }
}
