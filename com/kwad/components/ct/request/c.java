package com.kwad.components.ct.request;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.utils.bh;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    private static volatile boolean aIu = false;

    public interface a {
        void E(CtAdTemplate ctAdTemplate);

        void zH();
    }

    public static void a(final long j, final ImpInfo impInfo, final a aVar) {
        if (aIu) {
            return;
        }
        new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.request.c.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: oC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* renamed from: bz, reason: merged with bridge method [inline-methods] */
            public CtAdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CtAdResultData ctAdResultData = new CtAdResultData(impInfo.adScene);
                ctAdResultData.parseJson(jSONObject);
                if (ctAdResultData.getCtAdTemplateList().size() > 0) {
                    Iterator<CtAdTemplate> it = ctAdResultData.getCtAdTemplateList().iterator();
                    while (it.hasNext()) {
                        it.next().mIsFromContent = true;
                    }
                }
                return ctAdResultData;
            }
        }.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.request.c.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str) {
                k(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.components.core.request.a aVar2) {
                super.onStartRequest(aVar2);
                com.kwad.sdk.core.d.c.d("BannerAdRequestManager", "onStartRequest");
                boolean unused = c.aIu = true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.request.a aVar2, final CtAdResultData ctAdResultData) {
                com.kwad.sdk.core.d.c.d("BannerAdRequestManager", "onSuccess");
                boolean unused = c.aIu = false;
                if (!ctAdResultData.isAdResultDataEmpty()) {
                    c.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.c.2.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            aVar.E(ctAdResultData.getCtAdTemplateList().get(0));
                        }
                    });
                } else {
                    k(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(ctAdResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : ctAdResultData.testErrorMsg);
                }
            }

            private void k(final int i, final String str) {
                com.kwad.sdk.core.d.c.d("BannerAdRequestManager", "onError");
                boolean unused = c.aIu = false;
                c.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.c.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.w("BannerAdRequestManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        aVar.zH();
                    }
                });
            }
        });
    }
}
