package com.bytedance.sdk.djx.core.business.budrama.history;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.rsp.DramaRsp;
import com.bytedance.sdk.djx.core.business.base.BaseViewModel;
import com.bytedance.sdk.djx.core.business.budrama.DramaManager;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaHistoryViewModel extends BaseViewModel {
    public MutableLiveData<BaseViewModel.DataWrapper<List<Drama>>> mDramaHistoryData = new MutableLiveData<>();
    private boolean mIsLoadingDramaHistory;

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadCover(List<String> list) {
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    Picasso.with(InnerManager.getContext()).load(str).fetch();
                }
            }
        }
    }

    public void loadAllDramaHistory(boolean z) {
        if (this.mIsLoadingDramaHistory) {
            return;
        }
        this.mIsLoadingDramaHistory = true;
        if (z) {
            setValueInUIThread(this.mUiData, new BaseViewModel.DataWrapper(BaseViewModel.UIEvent.SHOW_PROGRESS));
        }
        ApiManager.loadAllDramaHistory(new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.history.DJXDramaHistoryViewModel.1
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaRsp dramaRsp) throws JSONException {
                List<Drama> data;
                DJXDramaHistoryViewModel.this.mIsLoadingDramaHistory = false;
                if (dramaRsp != null && (data = dramaRsp.getData()) != null && !data.isEmpty()) {
                    DramaManager.getInstance().saveLocalHistory(dramaRsp.getData());
                    DJXDramaHistoryViewModel dJXDramaHistoryViewModel = DJXDramaHistoryViewModel.this;
                    dJXDramaHistoryViewModel.setValueInUIThread(dJXDramaHistoryViewModel.mDramaHistoryData, new BaseViewModel.DataWrapper(data).setExtra(Boolean.valueOf(dramaRsp.isHasMore())));
                    ArrayList arrayList = new ArrayList();
                    Iterator<Drama> it = data.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().coverImage);
                    }
                    DJXDramaHistoryViewModel.this.preloadCover(arrayList);
                } else {
                    DJXDramaHistoryViewModel dJXDramaHistoryViewModel2 = DJXDramaHistoryViewModel.this;
                    dJXDramaHistoryViewModel2.setValueInUIThread(dJXDramaHistoryViewModel2.mDramaHistoryData, new BaseViewModel.DataWrapper(null).setResult(BaseViewModel.NetworkResult.SUCCESS));
                }
                DJXDramaHistoryViewModel dJXDramaHistoryViewModel3 = DJXDramaHistoryViewModel.this;
                dJXDramaHistoryViewModel3.setValueInUIThread(dJXDramaHistoryViewModel3.mUiData, new BaseViewModel.DataWrapper(BaseViewModel.UIEvent.DISMISS_PROGRESS));
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                DJXDramaHistoryViewModel.this.mIsLoadingDramaHistory = false;
                DJXDramaHistoryViewModel dJXDramaHistoryViewModel = DJXDramaHistoryViewModel.this;
                dJXDramaHistoryViewModel.setValueInUIThread(dJXDramaHistoryViewModel.mDramaHistoryData, new BaseViewModel.DataWrapper(null).setResult(BaseViewModel.NetworkResult.FAILED));
                DJXDramaHistoryViewModel dJXDramaHistoryViewModel2 = DJXDramaHistoryViewModel.this;
                dJXDramaHistoryViewModel2.setValueInUIThread(dJXDramaHistoryViewModel2.mUiData, new BaseViewModel.DataWrapper(BaseViewModel.UIEvent.DISMISS_PROGRESS));
                DJXDramaHistoryViewModel dJXDramaHistoryViewModel3 = DJXDramaHistoryViewModel.this;
                dJXDramaHistoryViewModel3.setValueInUIThread(dJXDramaHistoryViewModel3.mUiData, new BaseViewModel.DataWrapper(BaseViewModel.UIEvent.SHOW_TOAST).setExtra(InnerManager.getContext().getResources().getString(R.string.djx_request_fail_tip)));
            }
        });
    }
}
