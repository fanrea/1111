package com.bytedance.sdk.djx.log;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import org.json.JSONArray;

/* compiled from: ILazyReporter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/djx/log/ILazyReporter;", "", "clear", "", NotificationCompat.CATEGORY_EVENT, "", "getEventParams", "Lorg/json/JSONArray;", "saveLocalData", "key", "data", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ILazyReporter {
    void clear(String event);

    JSONArray getEventParams(String event);

    void saveLocalData(String key, String data);
}
