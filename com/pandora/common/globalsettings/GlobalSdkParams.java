package com.pandora.common.globalsettings;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GlobalSdkParams {
    private CopyOnWriteArrayList<GlobalSdkParamsListener> arrayListener;
    private JSONObject settings;

    private GlobalSdkParams() {
        this.arrayListener = new CopyOnWriteArrayList<>();
    }

    private static class GlobalSdkParamsHolder {
        private static final GlobalSdkParams INSTANCE = new GlobalSdkParams();

        private GlobalSdkParamsHolder() {
        }
    }

    public static GlobalSdkParams getInstance() {
        return GlobalSdkParamsHolder.INSTANCE;
    }

    public void addListener(GlobalSdkParamsListener listener) {
        this.arrayListener.add(listener);
    }

    public synchronized boolean setSettings(JSONObject settings) {
        if (this.settings == null) {
            try {
                this.settings = new JSONObject(settings.toString());
                onUpdate();
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private void onUpdate() {
        Iterator<GlobalSdkParamsListener> it = this.arrayListener.iterator();
        while (it.hasNext()) {
            it.next().onNotify(0);
        }
    }

    public JSONObject getSettings() {
        if (this.settings == null) {
            return null;
        }
        try {
            return new JSONObject(this.settings.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
