package com.bytedance.sdk.djx.core.business.budrama;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.req.DramaApi;
import com.bytedance.sdk.djx.core.api.rsp.DramaActionRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaRsp;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.ev.BETokenUpdate;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.SP;
import com.bytedance.sdk.djx.utils.SPUtils;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaManager {
    private static final String KEY_DRAMA_HISTORY_LOCAL = "drama_history_local";
    private static final String TAG = "DramaManager";
    private static final AtomicBoolean sHistoryStranded = new AtomicBoolean(false);
    private final LinkedHashMap<Long, Drama> dramaLocalMap;
    private final IBusListener mBusListener;
    private final SPUtils mSPUtils;

    private interface UploadCallback {
        void onUpload();
    }

    private DramaManager() {
        this.mSPUtils = SP.drama();
        this.dramaLocalMap = new LinkedHashMap<>();
        IBusListener iBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.DramaManager.1
            public void onBusEvent(BusEvent busEvent) throws JSONException {
                if (busEvent instanceof BETokenUpdate) {
                    DramaManager.this.refreshLocalHistory();
                }
            }
        };
        this.mBusListener = iBusListener;
        DJXBus.getInstance().addListener(iBusListener);
        readLocalData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshLocalHistory() throws JSONException {
        clearAllHistory();
        ApiManager.loadAllDramaHistory(new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.DramaManager.2
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaRsp dramaRsp) throws JSONException {
                DramaManager.getInstance().saveLocalHistory(dramaRsp.getData());
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                LG.e(DramaManager.TAG, "loadDramaHistory onApiFailure: msg = " + dJXError);
            }
        });
    }

    private void readLocalData() {
        LG.d(TAG, "read local drama data start");
        String string = this.mSPUtils.getString(KEY_DRAMA_HISTORY_LOCAL);
        LG.d(TAG, "historyLocalJson = " + string);
        this.dramaLocalMap.clear();
        try {
            JSONArray jSONArrayBuildArr = JSON.buildArr(string);
            if (jSONArrayBuildArr != null) {
                for (int i = 0; i < jSONArrayBuildArr.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayBuildArr.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        Drama drama = DramaApi.parseDrama(jSONObjectOptJSONObject);
                        this.dramaLocalMap.put(Long.valueOf(drama.id), drama);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void historyStranded() {
        sHistoryStranded.set(true);
    }

    public void saveLocalHistory(Drama drama) {
        if (drama == null || drama.id <= 0 || isOldHistory(drama)) {
            return;
        }
        this.dramaLocalMap.remove(Long.valueOf(drama.id));
        this.dramaLocalMap.put(Long.valueOf(drama.id), drama);
        updateHistorySp(this.dramaLocalMap, KEY_DRAMA_HISTORY_LOCAL);
    }

    public void saveLocalHistory(List<Drama> list) throws JSONException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Drama drama : list) {
            if (drama.id <= 0 || isOldHistory(drama)) {
                break;
            } else {
                this.dramaLocalMap.put(Long.valueOf(drama.id), drama);
            }
        }
        sort(this.dramaLocalMap);
        updateHistorySp(this.dramaLocalMap, KEY_DRAMA_HISTORY_LOCAL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void sort(LinkedHashMap<Long, Drama> linkedHashMap) {
        if (linkedHashMap == 0) {
            return;
        }
        ArrayList<Map.Entry> arrayList = new ArrayList(linkedHashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<Long, Drama>>() { // from class: com.bytedance.sdk.djx.core.business.budrama.DramaManager.3
            @Override // java.util.Comparator
            public int compare(Map.Entry<Long, Drama> entry, Map.Entry<Long, Drama> entry2) {
                return (int) (entry.getValue().actionTime - entry2.getValue().actionTime);
            }
        });
        linkedHashMap.clear();
        for (Map.Entry entry : arrayList) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
    }

    public Drama getHistoryDrama(long j) {
        return this.dramaLocalMap.get(Long.valueOf(j));
    }

    public int getHistoryIndex(long j) {
        Drama drama = this.dramaLocalMap.get(Long.valueOf(j));
        if (drama == null) {
            return 1;
        }
        return drama.index;
    }

    public List<Drama> getLatestHistory(int i) {
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = new ArrayList(this.dramaLocalMap.entrySet()).listIterator(this.dramaLocalMap.size());
        while (listIterator.hasPrevious()) {
            Drama drama = (Drama) ((Map.Entry) listIterator.previous()).getValue();
            if (drama != null && (!DevInfo.getPrivacyController().isOnlyICPNumber() || !TextUtils.isEmpty(drama.icpNumber))) {
                arrayList.add(drama);
                if (arrayList.size() == i) {
                    break;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHistorySp(LinkedHashMap<Long, Drama> linkedHashMap, String str) throws JSONException {
        JSONArray jSONArrayBuildArr = JSON.buildArr();
        Iterator<Map.Entry<Long, Drama>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            JSONObject jsonObject = it.next().getValue().toJsonObject();
            if (jsonObject != null) {
                jSONArrayBuildArr.put(jsonObject);
            }
        }
        this.mSPUtils.put(str, jSONArrayBuildArr.toString());
        LG.d(TAG, "Drama history has been updated, key = " + str + ", map = " + linkedHashMap);
    }

    public void uploadLocalHistory() {
        if (this.dramaLocalMap.isEmpty() || !sHistoryStranded.get()) {
            return;
        }
        uploadHistory(this.dramaLocalMap, KEY_DRAMA_HISTORY_LOCAL, new UploadCallback() { // from class: com.bytedance.sdk.djx.core.business.budrama.DramaManager.4
            @Override // com.bytedance.sdk.djx.core.business.budrama.DramaManager.UploadCallback
            public void onUpload() {
                DramaManager.sHistoryStranded.set(false);
            }
        });
    }

    private void uploadHistory(final LinkedHashMap<Long, Drama> linkedHashMap, final String str, final UploadCallback uploadCallback) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, Drama>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        DramaApi.postDramaPlayAction(arrayList, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.DramaManager.5
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaActionRsp dramaActionRsp) throws JSONException {
                linkedHashMap.clear();
                DramaManager.this.updateHistorySp(linkedHashMap, str);
                LG.d(DramaManager.TAG, str + " has been uploaded");
                UploadCallback uploadCallback2 = uploadCallback;
                if (uploadCallback2 != null) {
                    uploadCallback2.onUpload();
                }
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaActionRsp dramaActionRsp) {
                LG.w(DramaManager.TAG, str + " upload failed: " + dJXError);
            }
        });
    }

    public void clearAllHistory() throws JSONException {
        this.dramaLocalMap.clear();
        updateHistorySp(this.dramaLocalMap, KEY_DRAMA_HISTORY_LOCAL);
    }

    public static DramaManager getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final DramaManager instance = new DramaManager();

        private InnerHolder() {
        }
    }

    private boolean isOldHistory(Drama drama) {
        Drama historyDrama = getHistoryDrama(drama.id);
        return historyDrama != null && historyDrama.actionTime >= drama.actionTime;
    }
}
