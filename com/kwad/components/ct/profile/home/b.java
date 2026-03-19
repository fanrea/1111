package com.kwad.components.ct.profile.home;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.profile.home.model.ProfileResultData;
import com.kwad.components.ct.profile.home.model.UserProfile;
import com.kwad.components.ct.request.r;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private a aRc;
    private ImpInfo amX;
    private long mAuthorId;
    private l<r, ProfileResultData> mNetworking;
    private boolean aIZ = false;
    private Handler aeI = new Handler(Looper.getMainLooper());

    public interface a {
        void by(int i);

        void c(UserProfile userProfile);

        void onStartLoading();
    }

    public b(ImpInfo impInfo, long j, a aVar) {
        this.amX = impInfo;
        this.mAuthorId = j;
        this.aRc = aVar;
    }

    public final void startRequest() {
        if (this.aIZ) {
            return;
        }
        Jg();
        l<r, ProfileResultData> lVar = new l<r, ProfileResultData>() { // from class: com.kwad.components.ct.profile.home.b.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bB(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: Cn, reason: merged with bridge method [inline-methods] */
            public r createRequest() {
                return new r(b.this.amX, b.this.mAuthorId);
            }

            private static ProfileResultData bB(String str) {
                JSONObject jSONObject = new JSONObject(str);
                ProfileResultData profileResultData = new ProfileResultData();
                profileResultData.parseJson(jSONObject);
                return profileResultData;
            }
        };
        this.mNetworking = lVar;
        lVar.request(new o<r, ProfileResultData>() { // from class: com.kwad.components.ct.profile.home.b.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                z(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                a((ProfileResultData) baseResultData);
            }

            private void a(final ProfileResultData profileResultData) {
                b.this.aeI.post(new bh() { // from class: com.kwad.components.ct.profile.home.b.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        b.this.b(profileResultData);
                    }
                });
            }

            private void z(final int i, final String str) {
                b.this.aeI.post(new bh() { // from class: com.kwad.components.ct.profile.home.b.2.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        b.this.y(i, str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ProfileResultData profileResultData) {
        b(profileResultData.userProfile);
        this.aIZ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, String str) {
        com.kwad.sdk.core.d.c.w("DataFetcherProfile", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
        u(i, str);
        this.aIZ = false;
    }

    public final void release() {
        l<r, ProfileResultData> lVar = this.mNetworking;
        if (lVar != null) {
            lVar.cancel();
        }
        this.aRc = null;
        this.aeI.removeCallbacksAndMessages(null);
    }

    private void Jg() {
        a aVar = this.aRc;
        if (aVar != null) {
            aVar.onStartLoading();
        }
    }

    private void b(UserProfile userProfile) {
        a aVar = this.aRc;
        if (aVar != null) {
            aVar.c(userProfile);
        }
    }

    private void u(int i, String str) {
        a aVar = this.aRc;
        if (aVar != null) {
            aVar.by(i);
        }
    }
}
