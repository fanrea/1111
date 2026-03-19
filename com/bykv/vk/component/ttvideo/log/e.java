package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum e {
    instance;

    private VideoEventEngineUploader a;
    private Context b;

    private void a(JSONObject jSONObject) {
        if (((TTVideoEngineLog.LogNotifyLevel >> 2) & 1) == 1 || ((TTVideoEngineLog.LogTurnOn >> 2) & 1) == 1) {
            TTVideoEngineLog.i("VideoEventManager", jSONObject.toString());
        }
        if (((TTVideoEngineLog.LogTurnOn >> 1) & 1) == 1) {
            Context context = this.b;
            String string = context != null ? Settings.Global.getString(context.getContentResolver(), "engine.debug") : "";
            if (string != null) {
                for (String str : string.split(",", -1)) {
                    if (jSONObject.opt(str) != null) {
                        TTVideoEngineLog.i("VideoEventManager", str + ":" + jSONObject.opt(str));
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.b = context.getApplicationContext();
    }

    public synchronized void a(VideoEventEngineUploader videoEventEngineUploader) {
        this.a = videoEventEngineUploader;
    }

    protected void a(boolean z, JSONObject jSONObject) {
        synchronized (e.class) {
            if (jSONObject == null) {
                return;
            }
            a(jSONObject);
            VideoEventEngineUploader videoEventEngineUploader = this.a;
            if (videoEventEngineUploader != null) {
                videoEventEngineUploader.onEvent("video_playq", jSONObject);
            }
        }
    }
}
