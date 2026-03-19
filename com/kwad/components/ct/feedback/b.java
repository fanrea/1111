package com.kwad.components.ct.feedback;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    private static AtomicBoolean aGi = new AtomicBoolean(false);

    public static class a {
        public String aGn;
        public String amZ;
        public String content;
    }

    /* renamed from: com.kwad.components.ct.feedback.b$b, reason: collision with other inner class name */
    public interface InterfaceC0518b {
        void Fh();

        void xK();

        void zH();
    }

    public static void a(final a aVar, final InterfaceC0518b interfaceC0518b) {
        if (aGi.get()) {
            return;
        }
        aGi.set(true);
        new l<com.kwad.components.ct.feedback.a, FeedbackResponse>() { // from class: com.kwad.components.ct.feedback.b.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bM(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: Fg, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.feedback.a createRequest() {
                return new com.kwad.components.ct.feedback.a(aVar);
            }

            private static FeedbackResponse bM(String str) {
                JSONObject jSONObject = new JSONObject(str);
                FeedbackResponse feedbackResponse = new FeedbackResponse();
                feedbackResponse.parseJson(jSONObject);
                return feedbackResponse;
            }
        }.request(new o<com.kwad.components.ct.feedback.a, FeedbackResponse>() { // from class: com.kwad.components.ct.feedback.b.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                t(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                a((FeedbackResponse) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(com.kwad.components.ct.feedback.a aVar2) {
                super.onStartRequest(aVar2);
                b.mHandler.post(new bh() { // from class: com.kwad.components.ct.feedback.b.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        interfaceC0518b.xK();
                    }
                });
            }

            private void a(final FeedbackResponse feedbackResponse) {
                b.mHandler.post(new bh() { // from class: com.kwad.components.ct.feedback.b.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        interfaceC0518b.Fh();
                    }
                });
                b.aGi.set(false);
            }

            private void t(final int i, final String str) {
                b.mHandler.post(new bh() { // from class: com.kwad.components.ct.feedback.b.2.3
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.e("FeedbackRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        interfaceC0518b.zH();
                    }
                });
                b.aGi.set(false);
            }
        });
    }
}
