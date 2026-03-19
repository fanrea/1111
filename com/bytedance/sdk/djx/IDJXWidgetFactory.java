package com.bytedance.sdk.djx;

import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.params.DJXWidgetDramaCardParams;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHomeParams;
import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.params.DJXWidgetParam;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IDJXWidgetFactory {

    public interface Callback {
        void onError(DJXError dJXError);

        void onSuccess(IDJXElement iDJXElement);
    }

    @Deprecated
    <Param extends DJXWidgetParam> IDJXWidget create(Param param);

    IDJXWidget createDramaDetail(DJXWidgetDramaDetailParams dJXWidgetDramaDetailParams);

    IDJXWidget createDramaHome(DJXWidgetDramaHomeParams dJXWidgetDramaHomeParams);

    IDJXWidget createDraw(DJXWidgetDrawParams dJXWidgetDrawParams);

    void loadDramaCard(DJXWidgetDramaCardParams dJXWidgetDramaCardParams, int i, Callback callback);
}
