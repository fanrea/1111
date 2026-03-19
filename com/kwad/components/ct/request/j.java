package com.kwad.components.ct.request;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.ct.response.model.home.CommentResponse;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public interface a {
        void by(int i);

        void c(CommentResponse commentResponse);
    }

    public final void a(final long j, final a aVar) {
        new com.kwad.sdk.core.network.l<d, CommentResponse>() { // from class: com.kwad.components.ct.request.j.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return cb(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: JY, reason: merged with bridge method [inline-methods] */
            public d createRequest() {
                return new d(j);
            }

            private static CommentResponse cb(String str) throws JSONException {
                JSONObject jSONObject = new JSONObject(str);
                CommentResponse commentResponse = new CommentResponse();
                commentResponse.parseJson(jSONObject);
                return commentResponse;
            }
        }.request(new com.kwad.sdk.core.network.o<d, CommentResponse>() { // from class: com.kwad.components.ct.request.j.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str) {
                B(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                d((CommentResponse) baseResultData);
            }

            private void d(final CommentResponse commentResponse) {
                j.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.j.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        aVar.c(commentResponse);
                    }
                });
            }

            private void B(final int i, final String str) {
                j.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.j.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        aVar.by(i);
                    }
                });
            }
        });
    }
}
