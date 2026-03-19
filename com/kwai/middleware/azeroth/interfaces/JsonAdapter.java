package com.kwai.middleware.azeroth.interfaces;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface JsonAdapter<T> {
    T fromJson(String str);

    JSONObject toJson();
}
