package com.luck.picture.lib.entity;

import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MediaData {
    public ArrayList<LocalMedia> data;
    public boolean isHasNextMore;

    public MediaData() {
    }

    public MediaData(boolean z, ArrayList<LocalMedia> arrayList) {
        this.isHasNextMore = z;
        this.data = arrayList;
    }
}
