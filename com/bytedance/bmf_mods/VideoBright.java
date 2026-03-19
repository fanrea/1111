package com.bytedance.bmf_mods;

import com.alipay.sdk.m.t.a;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.VideoBrightAPI;
import com.bytedance.bmf_mods_api.VideoBrightCallbackAPI;
import com.google.gson.JsonObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoBright implements VideoBrightAPI {
    private JsonObject srOption = new JsonObject();
    private ModuleInfo srModuleInfo = null;
    private ModuleFunctor srFunc = null;
    private int oes_flag = 0;
    private int bright_status = 0;
    private int status_change = 0;
    private VideoBrightCallbackAPI sCallback = null;

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public int GetStatus() {
        return -1;
    }

    public VideoBright() {
        Logging.d("New VideoBright");
    }

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public boolean Init(int i, int i2, int i3, int i4) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        this.srOption.addProperty("init_fps", Integer.valueOf(i));
        this.srOption.addProperty("normal_fps", Integer.valueOf(i2));
        this.srOption.addProperty("long_sw", Integer.valueOf(i3));
        this.srOption.addProperty("lum_thre", Integer.valueOf(i4));
        this.srModuleInfo = new ModuleInfo("Brighten_Module", "c++", "libbmf_hydra.so", "");
        Class[] clsArr = {JsonObject.class};
        Class[] clsArr2 = {JsonObject.class};
        try {
            Logging.d("Brighten_Module: load bright Module");
            this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
            Logging.d("Brighten_Module: load bright Module success");
            return true;
        } catch (Exception e) {
            Logging.d("Brighten_Module: load bright Module failed," + e.toString());
            return false;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public void SetCallback(VideoBrightCallbackAPI videoBrightCallbackAPI) {
        this.sCallback = videoBrightCallbackAPI;
    }

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public int Process(int i, int i2, int i3, int i4, long j) {
        if (!SoLoader.getInstance().isSoInitialized() || this.srFunc == null) {
            return -1;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("input_texture", Integer.valueOf(i));
        jsonObject.addProperty("output_texture", Integer.valueOf(i2));
        jsonObject.addProperty("width", Integer.valueOf(i3));
        jsonObject.addProperty("height", Integer.valueOf(i4));
        jsonObject.addProperty(a.k, Long.valueOf(j));
        try {
            JsonObject jsonObject2 = (JsonObject) this.srFunc.call(jsonObject)[0];
            int asInt = jsonObject2.get("output_texture").getAsInt();
            int asInt2 = jsonObject2.get("status").getAsInt();
            if (asInt2 == 2) {
                float asFloat = jsonObject2.get("process_time").getAsFloat();
                float asFloat2 = jsonObject2.get("input_texture_brightness").getAsFloat();
                float asFloat3 = jsonObject2.get("output_texture_brightness").getAsFloat();
                VideoBrightCallbackAPI videoBrightCallbackAPI = this.sCallback;
                if (videoBrightCallbackAPI != null) {
                    videoBrightCallbackAPI.callback(asInt2, asFloat, asFloat2, asFloat3);
                }
            }
            return asInt;
        } catch (Exception e) {
            Logging.d("Brighten_Module: call bright module failed," + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public void Free() {
        ModuleFunctor moduleFunctor = this.srFunc;
        if (moduleFunctor != null) {
            moduleFunctor.free();
        }
    }
}
