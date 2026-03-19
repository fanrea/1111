package com.bytedance.bmf_mods;

import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.ColorShiftAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ColorShift implements ColorShiftAPI {
    private JsonObject srOption = new JsonObject();
    private ModuleInfo srModuleInfo = null;
    private ModuleFunctor srFunc = null;

    public ColorShift() {
        Logging.d("New ColorShift");
    }

    @Override // com.bytedance.bmf_mods_api.ColorShiftAPI
    public boolean Init(boolean z, float f, float f2, float[] fArr, float[] fArr2, int i) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        this.srOption.addProperty("enable_profile", Boolean.valueOf(z));
        this.srOption.addProperty("bright", Float.valueOf(f));
        this.srOption.addProperty("saturation", Float.valueOf(f2));
        this.srOption.addProperty("input_texture_type", Integer.valueOf(i));
        JsonArray jsonArray = new JsonArray();
        for (float f3 : fArr) {
            jsonArray.add(Float.valueOf(f3));
        }
        this.srOption.add("shift_positive", jsonArray);
        JsonArray jsonArray2 = new JsonArray();
        for (float f4 : fArr2) {
            jsonArray2.add(Float.valueOf(f4));
        }
        this.srOption.add("shift_negative", jsonArray2);
        this.srModuleInfo = new ModuleInfo("ColorShiftModule", "c++", "libbmf_hydra.so", "");
        Class[] clsArr = {JsonObject.class};
        Class[] clsArr2 = {JsonObject.class};
        try {
            Logging.d("ColorShift: load ColorShift Module");
            this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
            Logging.d("ColorShift: load ColorShift Module success");
            return true;
        } catch (Exception e) {
            Logging.d("ColorShift: load ColorShift Module failed," + e.toString());
            return false;
        }
    }

    @Override // com.bytedance.bmf_mods_api.ColorShiftAPI
    public int Process(int i, int i2, int i3, int i4) {
        if (!SoLoader.getInstance().isSoInitialized() || this.srFunc == null) {
            return -1;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("input_texture", Integer.valueOf(i));
        jsonObject.addProperty("output_texture", Integer.valueOf(i2));
        jsonObject.addProperty("width", Integer.valueOf(i3));
        jsonObject.addProperty("height", Integer.valueOf(i4));
        try {
            return i2;
        } catch (Exception e) {
            Logging.d("ColorShift: call ColorShift module failed," + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.ColorShiftAPI
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
            Logging.d("ColorShift: call ColorShift module failed," + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.ColorShiftAPI
    public void Free() {
        ModuleFunctor moduleFunctor = this.srFunc;
        if (moduleFunctor != null) {
            moduleFunctor.free();
        }
    }
}
