package com.bytedance.sdk.djx.model.ev;

import android.graphics.Bitmap;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.utils.bus.BusEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BEThumbCome extends BusEvent {
    public Bitmap bitmap;
    public long id;
    public int index;

    public BEThumbCome(long j, int i, Bitmap bitmap) {
        this.id = j;
        this.index = i;
        this.bitmap = bitmap;
    }

    public boolean checkOK(DramaDetail dramaDetail) {
        return dramaDetail != null && dramaDetail.getDrama() != null && dramaDetail.getDrama().id == this.id && dramaDetail.getIndex() == this.index;
    }

    public boolean checkOK(Drama drama) {
        return drama != null && drama.id == this.id && drama.index == this.index;
    }
}
