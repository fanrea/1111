package com.bytedance.sdk.djx;

import com.bytedance.sdk.djx.model.DJXCombo;
import com.bytedance.sdk.djx.model.DJXDrama;
import com.bytedance.sdk.djx.model.DJXEpisodeStatus;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXLock;
import com.bytedance.sdk.djx.model.DJXOrder;
import com.bytedance.sdk.djx.model.DJXOthers;
import com.bytedance.sdk.djx.model.DJXProtocol;
import com.bytedance.sdk.djx.model.DJXRenewal;
import com.bytedance.sdk.djx.model.DJXUser;
import com.bytedance.sdk.djx.model.DJXVip;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IDJXService {

    public interface IDJXCallback<T> {
        void onError(DJXError dJXError);

        void onSuccess(T t, DJXOthers dJXOthers);
    }

    void cancelRenewal(long j, long j2, IDJXCallback<DJXRenewal> iDJXCallback);

    void clearDramaHistory(IDJXCallback<List<? extends DJXDrama>> iDJXCallback);

    void customizationCapability(Map<String, String> map, IDJXCallback<JSONObject> iDJXCallback);

    void favorDrama(long j, int i, boolean z, IDJXCallback<Object> iDJXCallback);

    void getCombos(String str, int i, IDJXCallback<List<DJXCombo>> iDJXCallback);

    void getDramaHistory(int i, int i2, IDJXCallback<List<? extends DJXDrama>> iDJXCallback);

    void getEpisodesStatus(long j, int i, IDJXCallback<List<DJXEpisodeStatus>> iDJXCallback);

    void getFavorList(int i, int i2, IDJXCallback<List<? extends DJXDrama>> iDJXCallback);

    void getPayProtocol(List<Integer> list, IDJXCallback<List<DJXProtocol>> iDJXCallback);

    String getSignString(String str, String str2, long j, Map<String, String> map);

    boolean isLogin();

    void likeEpisode(long j, int i, boolean z, IDJXCallback<Object> iDJXCallback);

    void login(String str, IDJXCallback<DJXUser> iDJXCallback);

    void logout(IDJXCallback<DJXUser> iDJXCallback);

    void pay(String str, IDJXCallback<DJXOrder> iDJXCallback);

    void queryPayDramas(int i, IDJXCallback<List<DJXDrama>> iDJXCallback);

    void queryPayOrders(int i, IDJXCallback<List<DJXOrder>> iDJXCallback);

    void queryPayVips(IDJXCallback<DJXVip> iDJXCallback);

    void requestAllDrama(int i, int i2, boolean z, IDJXCallback<List<? extends DJXDrama>> iDJXCallback);

    void requestAllDramaByRecommend(int i, int i2, IDJXCallback<List<? extends DJXDrama>> iDJXCallback);

    void requestDrama(List<Long> list, IDJXCallback<List<? extends DJXDrama>> iDJXCallback);

    void requestDramaByCategory(String str, int i, int i2, int i3, IDJXCallback<List<? extends DJXDrama>> iDJXCallback);

    void requestDramaCategoryList(IDJXCallback<List<String>> iDJXCallback);

    void searchDrama(String str, boolean z, int i, int i2, IDJXCallback<List<? extends DJXDrama>> iDJXCallback);

    void setGlobalSpeedPlay(float f);

    void signedPayProtocol(List<String> list, IDJXCallback<Boolean> iDJXCallback);

    void uploadDramaHomeLog(DJXDramaLog dJXDramaLog);

    void verifyDramaParams(int i, int i2, int i3, IDJXCallback<DJXLock> iDJXCallback);
}
