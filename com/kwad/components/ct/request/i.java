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
public final class i {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public interface a {
        void b(long j, CtAdTemplate ctAdTemplate);

        void zH();
    }

    public static void a(final long j, final ImpInfo impInfo, final com.kwad.components.core.request.model.c cVar, final a aVar) {
        new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.request.i.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: oC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo, cVar);
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
        }.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, CtAdResultData>() { // from class: com.kwad.components.ct.request.i.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str) {
                k(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.request.a aVar2, final CtAdResultData ctAdResultData) {
                if (!ctAdResultData.isAdResultDataEmpty()) {
                    i.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.i.2.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            aVar.b(j, ctAdResultData.getCtAdTemplateList().get(0));
                        }
                    });
                } else {
                    k(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(ctAdResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : ctAdResultData.testErrorMsg);
                }
            }

            private void k(final int i, final String str) {
                i.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.i.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.w("PatchAdRequestManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        aVar.zH();
                    }
                });
            }
        });
    }
}
