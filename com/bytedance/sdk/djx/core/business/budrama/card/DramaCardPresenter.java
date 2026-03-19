package com.bytedance.sdk.djx.core.business.budrama.card;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.IDJXWidgetFactory;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.rsp.DramaFeedRsp;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHelper;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.DramaFeed;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.params.DJXWidgetDramaCardParams;
import com.bytedance.sdk.djx.utils.LG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaCardPresenter {
    private static final String TAG = "DramaCardViewModel";
    private boolean mIsLoading = false;
    DJXWidgetDramaCardParams mWidgetParams;

    public DramaCardPresenter(DJXWidgetDramaCardParams dJXWidgetDramaCardParams) {
        this.mWidgetParams = dJXWidgetDramaCardParams;
    }

    public void loadPreviewDrama(int i, final IDJXWidgetFactory.Callback callback) {
        if (this.mIsLoading) {
            return;
        }
        this.mIsLoading = true;
        ApiManager.getInstance().dramaDetail(i, 1, 1, 1, null, new IApiCallback<DramaFeedRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.card.DramaCardPresenter.1
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaFeedRsp dramaFeedRsp) {
                DramaCardPresenter.this.mIsLoading = false;
                List<DramaFeed> data = dramaFeedRsp.getData();
                LG.d(DramaCardPresenter.TAG, "drama card response: " + data.size());
                if (data.isEmpty()) {
                    callback.onError(DJXError.build(-3, ErrCode.msg(-3)));
                    return;
                }
                for (DramaFeed dramaFeed : data) {
                    if (dramaFeed instanceof DramaDetail) {
                        callback.onSuccess(new DramaCardElement((DramaDetail) dramaFeed, DramaCardPresenter.this.mWidgetParams));
                        DramaCardPresenter.this.onResponseSuccess(dramaFeedRsp);
                        return;
                    }
                }
                callback.onError(DJXError.build(-3, ErrCode.msg(-3)));
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaFeedRsp dramaFeedRsp) {
                LG.e(DramaCardPresenter.TAG, "onApiFailure: msg = " + dJXError);
                DramaCardPresenter.this.mIsLoading = false;
                callback.onError(dJXError);
                DramaCardPresenter.this.onResponseFail(dJXError, dramaFeedRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseFail(DJXError dJXError, DramaFeedRsp dramaFeedRsp) {
        DJXWidgetDramaCardParams dJXWidgetDramaCardParams = this.mWidgetParams;
        if (dJXWidgetDramaCardParams == null || dJXWidgetDramaCardParams.mListener == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(g.o, dJXError.requestId);
        map.put("sub_code", dJXError.subCode);
        map.put("msg", dJXError.msg);
        map.put("code", Integer.valueOf(dJXError.code));
        if (dramaFeedRsp == null) {
            this.mWidgetParams.mListener.onDJXRequestFail(dJXError.code, dJXError.msg, map);
            LG.d(TAG, "onDJXRequestFail: code = " + dJXError);
        } else {
            if (TextUtils.isEmpty(dJXError.requestId)) {
                map.put(g.o, dramaFeedRsp.getRequestId());
            }
            this.mWidgetParams.mListener.onDJXRequestFail(dJXError.code, dJXError.msg, map);
            LG.d(TAG, "onDJXRequestFail: code = " + dJXError + ", map = " + map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseSuccess(DramaFeedRsp dramaFeedRsp) {
        List<DramaFeed> data;
        DJXWidgetDramaCardParams dJXWidgetDramaCardParams = this.mWidgetParams;
        if (dJXWidgetDramaCardParams == null || dJXWidgetDramaCardParams.mListener == null) {
            return;
        }
        if (dramaFeedRsp == null) {
            this.mWidgetParams.mListener.onDJXRequestFail(-3, ErrCode.msg(-3), null);
            LG.d(TAG, "onDJXRequestFail: code = -3, msg = " + ErrCode.msg(-3));
            return;
        }
        try {
            data = dramaFeedRsp.getData();
        } catch (Exception e) {
            e.printStackTrace();
            data = null;
        }
        if (data == null || data.isEmpty()) {
            this.mWidgetParams.mListener.onDJXRequestFail(-3, ErrCode.msg(-3), null);
            LG.d(TAG, "onDJXRequestFail: code = -3, msg = " + ErrCode.msg(-3));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (DramaFeed dramaFeed : data) {
            if (dramaFeed instanceof DramaDetail) {
                Map<String, Object> mapCreateParamsMap = DramaDetailHelper.createParamsMap((DramaDetail) dramaFeed, null);
                mapCreateParamsMap.put(g.o, dramaFeedRsp.getRequestId());
                arrayList.add(mapCreateParamsMap);
            }
        }
        this.mWidgetParams.mListener.onDJXRequestSuccess(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            LG.d(TAG, "onDJXRequestSuccess i = " + i + ", map = " + ((Map) arrayList.get(i)).toString());
        }
    }
}
