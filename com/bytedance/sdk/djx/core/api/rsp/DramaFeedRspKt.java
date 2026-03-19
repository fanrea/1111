package com.bytedance.sdk.djx.core.api.rsp;

import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.DramaFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DramaFeedRsp.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0005"}, d2 = {"getFirstDramaDetail", "Lcom/bytedance/sdk/djx/model/DramaDetail;", "", "Lcom/bytedance/sdk/djx/model/DramaFeed;", "getLastDramaDetail", "sdk_core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DramaFeedRspKt {
    public static final DramaDetail getFirstDramaDetail(List<? extends DramaFeed> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof DramaDetail) {
                arrayList.add(obj);
            }
        }
        return (DramaDetail) CollectionsKt.firstOrNull(arrayList);
    }

    public static final DramaDetail getLastDramaDetail(List<? extends DramaFeed> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof DramaDetail) {
                arrayList.add(obj);
            }
        }
        return (DramaDetail) CollectionsKt.lastOrNull(arrayList);
    }
}
