package com.bytedance.sdk.djx.core;

import com.bytedance.sdk.djx.IDJXWidget;
import com.bytedance.sdk.djx.IDJXWidgetFactory;
import com.bytedance.sdk.djx.params.DJXWidgetDramaCardParams;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHomeParams;
import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.params.DJXWidgetParam;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DefaultDJXWidgetFactory implements IDJXWidgetFactory {
    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public <Param extends DJXWidgetParam> IDJXWidget create(Param param) {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public IDJXWidget createDramaDetail(DJXWidgetDramaDetailParams dJXWidgetDramaDetailParams) {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public IDJXWidget createDramaHome(DJXWidgetDramaHomeParams dJXWidgetDramaHomeParams) {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public IDJXWidget createDraw(DJXWidgetDrawParams dJXWidgetDrawParams) {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IDJXWidgetFactory
    public void loadDramaCard(DJXWidgetDramaCardParams dJXWidgetDramaCardParams, int i, IDJXWidgetFactory.Callback callback) {
    }

    public static DefaultDJXWidgetFactory getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final DefaultDJXWidgetFactory instance = new DefaultDJXWidgetFactory();

        private InnerHolder() {
        }
    }
}
