package com.bytedance.sdk.djx.core.business.budrama.detail;

import com.bytedance.sdk.djx.core.business.base.BaseContract;
import com.bytedance.sdk.djx.model.Drama;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
interface DramaDetailContract {

    public interface Presenter extends BaseContract.BasePresenter<View> {
        boolean getDramaLoadMoreEnable();

        boolean getDramaPullDownEnable();

        void loadDramaAfter(boolean z);

        void loadDramaBefore();

        void loadDramaInit(int i);
    }

    public interface View extends BaseContract.BaseView {
        int getAdapterCount();

        void onLoadDrama(int i, boolean z, boolean z2, List list, boolean z3, Drama drama, long j, boolean z4);

        void onUnlockDrama(int i, int i2, List<Integer> list);

        void setLoadCacheTask(DramaDetailLoadFromCacheTask dramaDetailLoadFromCacheTask);

        void setLoadMoreEnable(boolean z);

        void setRefreshingEnable(boolean z);
    }
}
