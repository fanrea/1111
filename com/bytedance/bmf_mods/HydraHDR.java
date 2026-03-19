package com.bytedance.bmf_mods;

import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.HydraHDRAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class HydraHDR implements HydraHDRAPI {
    private JsonObject srOption = new JsonObject();
    private ModuleInfo srModuleInfo = null;
    private ModuleFunctor srFunc = null;

    public HydraHDR() {
        Logging.d("New HydraHDR");
    }

    @Override // com.bytedance.bmf_mods_api.HydraHDRAPI
    public boolean Init(boolean z, float f, boolean z2, int i) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        this.srOption.addProperty("enable_profile", Boolean.valueOf(z));
        this.srOption.addProperty("blend_alpha", Float.valueOf(f));
        this.srOption.addProperty("fast_mode", Boolean.valueOf(z2));
        this.srOption.addProperty("input_texture_type", Integer.valueOf(i));
        this.srModuleInfo = new ModuleInfo("HydraHDRModule", "c++", "libbmf_hydra.so", "");
        Class[] clsArr = {JsonObject.class};
        Class[] clsArr2 = {JsonObject.class};
        try {
            Logging.d("HydraHDR: load HDR Module");
            this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
            Logging.d("HydraHDR: load HDR Module success");
            return true;
        } catch (Exception e) {
            Logging.d("HydraHDR: load HDR Module failed," + e.toString());
            return false;
        }
    }

    @Override // com.bytedance.bmf_mods_api.HydraHDRAPI
    public int Process(int i, int i2, int i3, int i4) {
        return Process(i, i2, i3, i4, false);
    }

    @Override // com.bytedance.bmf_mods_api.HydraHDRAPI
    public int Process(int i, int i2, int i3, int i4, boolean z) {
        if (!SoLoader.getInstance().isSoInitialized() || this.srFunc == null) {
            return -1;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("input_texture", Integer.valueOf(i));
        jsonObject.addProperty("output_texture", Integer.valueOf(i2));
        jsonObject.addProperty("width", Integer.valueOf(i3));
        jsonObject.addProperty("height", Integer.valueOf(i4));
        jsonObject.addProperty("first_frame", Boolean.valueOf(z));
        try {
            return i2;
        } catch (Exception e) {
            Logging.d("HydraHDR: call HDR module failed," + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.HydraHDRAPI
    public int oesProcess(int i, int i2, int i3, int i4, float[] fArr) {
        if (!SoLoader.getInstance().isSoInitialized() || this.srFunc == null) {
            return -1;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("input_texture", Integer.valueOf(i));
        jsonObject.addProperty("output_texture", Integer.valueOf(i2));
        jsonObject.addProperty("width", Integer.valueOf(i3));
        jsonObject.addProperty("height", Integer.valueOf(i4));
        JsonArray jsonArray = new JsonArray();
        for (float f : fArr) {
            jsonArray.add(Float.valueOf(f));
        }
        jsonObject.add("matrix", jsonArray);
        try {
            return i2;
        } catch (Exception e) {
            Logging.d("HydraHDR: call HDR module failed," + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.HydraHDRAPI
    public void Free() {
        ModuleFunctor moduleFunctor = this.srFunc;
        if (moduleFunctor != null) {
            moduleFunctor.free();
        }
    }
}
