package com.bytedance.sdk.djx.core;

import com.bytedance.sdk.djx.IDJXWidget;
import com.bytedance.sdk.djx.IDJXWidgetFactory;
import com.bytedance.sdk.djx.base.dynamic.DynamicChecker;
import com.bytedance.sdk.djx.core.business.budrama.card.DramaCardPresenter;
import com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment;
import com.bytedance.sdk.djx.core.business.budrama.draw.DJXDrawBoxFragment;
import com.bytedance.sdk.djx.core.business.budrama.home.DJXDramaHomeFragment;
import com.bytedance.sdk.djx.core.business.widgetprovider.UserProfilePageProvider;
import com.bytedance.sdk.djx.core.business.widgetprovider.interfaces.WidgetProvider;
import com.bytedance.sdk.djx.core.util.ParamsChecker;
import com.bytedance.sdk.djx.params.DJXWidgetDramaCardParams;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHistoryParam;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHomeParams;
import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.params.DJXWidgetParam;
import com.bytedance.sdk.djx.utils.LG;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXWidgetFactoryProxy implements IDJXWidgetFactory {
    private static final String TAG = "DJXWidgetFactoryProxy";
    private static final HashMap<Class<?>, WidgetProvider<? extends DJXWidgetParam>> sIDJXWidgetMap;

    public static DJXWidgetFactoryProxy getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final DJXWidgetFactoryProxy instance = new DJXWidgetFactoryProxy();

        private InnerHolder() {
        }
    }

    static {
        HashMap<Class<?>, WidgetProvider<? extends DJXWidgetParam>> map = new HashMap<>();
        sIDJXWidgetMap = map;
        map.put(DJXWidgetDramaHistoryParam.class, new UserProfilePageProvider());
    }

    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public IDJXWidget createDraw(DJXWidgetDrawParams dJXWidgetDrawParams) {
        LG.d(TAG, "create draw params: " + (dJXWidgetDrawParams != null));
        if (dJXWidgetDrawParams == null) {
            dJXWidgetDrawParams = DJXWidgetDrawParams.obtain();
        }
        DynamicChecker.checkDraw(dJXWidgetDrawParams);
        LG.d(TAG, "create draw params: " + dJXWidgetDrawParams);
        if (!ParamsChecker.checkDraw(dJXWidgetDrawParams)) {
            return null;
        }
        DJXDrawBoxFragment dJXDrawBoxFragment = new DJXDrawBoxFragment();
        dJXDrawBoxFragment.setWidgetParams(dJXWidgetDrawParams);
        return dJXDrawBoxFragment;
    }

    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public IDJXWidget createDramaHome(DJXWidgetDramaHomeParams dJXWidgetDramaHomeParams) {
        LG.d(TAG, "create drama home, params: " + dJXWidgetDramaHomeParams);
        return new DJXDramaHomeFragment(dJXWidgetDramaHomeParams);
    }

    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public IDJXWidget createDramaDetail(DJXWidgetDramaDetailParams dJXWidgetDramaDetailParams) {
        LG.d(TAG, "create drama detail, params: " + dJXWidgetDramaDetailParams);
        return DJXDramaDetailFragment.obtain(dJXWidgetDramaDetailParams);
    }

    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public <Param extends DJXWidgetParam> IDJXWidget create(Param param) {
        LG.d(TAG, "create params: " + param);
        WidgetProvider<? extends DJXWidgetParam> widgetProvider = sIDJXWidgetMap.get(param.getClass());
        if (widgetProvider == null) {
            throw new RuntimeException("create called, but invalid type: " + param);
        }
        return widgetProvider.get(param);
    }

    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public void loadDramaCard(DJXWidgetDramaCardParams dJXWidgetDramaCardParams, int i, IDJXWidgetFactory.Callback callback) {
        LG.d(TAG, "load drama card params: " + (dJXWidgetDramaCardParams != null));
        if (dJXWidgetDramaCardParams == null) {
            dJXWidgetDramaCardParams = DJXWidgetDramaCardParams.obtain();
        }
        if (callback == null) {
            LG.e(TAG, "callback is null");
        } else {
            new DramaCardPresenter(dJXWidgetDramaCardParams).loadPreviewDrama(i, callback);
        }
    }
}
