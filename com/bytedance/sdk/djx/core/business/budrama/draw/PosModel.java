package com.bytedance.sdk.djx.core.business.budrama.draw;

import com.bytedance.sdk.djx.model.Feed;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class PosModel {
    private Object mData;
    private int mPosition = -1;
    private int mType;

    PosModel() {
    }

    public static PosModel createAd(int i) {
        PosModel posModel = new PosModel();
        posModel.setPosition(i);
        posModel.setAdType();
        return posModel;
    }

    public static PosModel createDrama(int i) {
        PosModel posModel = new PosModel();
        posModel.setPosition(i);
        posModel.setDramaType();
        return posModel;
    }

    public boolean isValid() {
        return this.mPosition > -1;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public int getType() {
        return this.mType;
    }

    public void setAdType() {
        this.mType = Feed.CELL_TYPE_AD;
    }

    public void setDramaType() {
        this.mType = 3202;
    }

    public Object getData() {
        return this.mData;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }
}
