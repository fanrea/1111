package com.kwai.middleware.azeroth.network;

import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class EmptyResponse implements JsonAdapter<EmptyResponse>, Serializable {
    private static final long serialVersionUID = -5933275131239983085L;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public EmptyResponse fromJson(String str) {
        return new EmptyResponse();
    }

    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public JSONObject toJson() {
        return new JSONObject();
    }
}
