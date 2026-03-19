package com.kwad.components.ct.request;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.ct.request.live.a;
import com.kwad.components.ct.response.model.home.PhotoShareInfo;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public interface a {
        void a(PhotoShareInfo photoShareInfo);

        void onError(int i, String str);
    }

    public final void a(final long j, final int i, final a aVar) {
        new com.kwad.sdk.core.network.l<m, PhotoShareInfo>() { // from class: com.kwad.components.ct.request.n.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return cc(str);
            }

            private static PhotoShareInfo cc(String str) {
                PhotoShareInfo photoShareInfo = new PhotoShareInfo();
                photoShareInfo.parseJson(new JSONObject(str));
                return photoShareInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: JZ, reason: merged with bridge method [inline-methods] */
            public m createRequest() {
                return new m(j, i);
            }
        }.request(new com.kwad.sdk.core.network.o<m, PhotoShareInfo>() { // from class: com.kwad.components.ct.request.n.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i2, String str) {
                C(i2, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                b((PhotoShareInfo) baseResultData);
            }

            private void b(final PhotoShareInfo photoShareInfo) {
                n.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.n.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        aVar.a(photoShareInfo);
                    }
                });
            }

            private void C(final int i2, final String str) {
                n.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.n.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.e("PhotoShareUrlRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        aVar.onError(i2, str);
                    }
                });
            }
        });
    }

    public final void a(final a.C0534a c0534a, final a aVar) {
        new com.kwad.sdk.core.network.l<com.kwad.components.ct.request.live.a, PhotoShareInfo>() { // from class: com.kwad.components.ct.request.n.3
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return cc(str);
            }

            private static PhotoShareInfo cc(String str) {
                PhotoShareInfo photoShareInfo = new PhotoShareInfo();
                photoShareInfo.parseJson(new JSONObject(str));
                return photoShareInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: Ka, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ct.request.live.a createRequest() {
                return new com.kwad.components.ct.request.live.a(c0534a);
            }
        }.request(new com.kwad.sdk.core.network.o<com.kwad.components.ct.request.live.a, PhotoShareInfo>() { // from class: com.kwad.components.ct.request.n.4
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str) {
                D(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                c((PhotoShareInfo) baseResultData);
            }

            private void c(final PhotoShareInfo photoShareInfo) {
                n.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.n.4.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        aVar.a(photoShareInfo);
                    }
                });
            }

            private void D(final int i, final String str) {
                n.mHandler.post(new bh() { // from class: com.kwad.components.ct.request.n.4.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.e("PhotoShareUrlRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        aVar.onError(i, str);
                    }
                });
            }
        });
    }
}
