package com.bytedance.bmf_mods;

import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.VideoSRLutDspAPI;
import com.google.gson.JsonObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoSRLutDsp implements VideoSRLutDspAPI {
    private int currHeight;
    private int currWidth;
    private JsonObject srOption = new JsonObject();
    private ModuleInfo srModuleInfo = null;
    private ModuleFunctor srFunc = null;
    private int currInputTexture = -1;
    private int currOutputTexture = -1;

    public VideoSRLutDsp() {
        Logging.d("New VideoSRLutDsp.");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutDspAPI
    public boolean Init(int i, int i2, String str) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        this.srModuleInfo = new ModuleInfo("SrLutDspModule", "c++", "libbmf_hydra.so", "");
        Class[] clsArr = {JsonObject.class};
        Class[] clsArr2 = {JsonObject.class};
        this.srOption.addProperty("width", Integer.valueOf(i));
        this.srOption.addProperty("height", Integer.valueOf(i2));
        this.currWidth = i;
        this.currHeight = i2;
        if (str != null && str != "") {
            this.srOption.addProperty("dsp_so_path", str);
        }
        try {
            Logging.d("VideoSRLutDsp init: load VRSR Module");
            this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
            Logging.d("VideoSRLut initDsp: load VRSR Module success");
            return true;
        } catch (Exception e) {
            Logging.d("VideoSRLutDsp init: load video sr lut Module failed," + e.toString());
            return false;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutDspAPI
    public int[] GetTextures() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("get_textures", (Number) 1);
        int[] iArr = {-1, -1};
        if (this.srFunc == null) {
            return iArr;
        }
        try {
            Logging.d("VideoSRLutDsp: call GetTextures.");
            Object[] objArrCall = this.srFunc.call(jsonObject);
            Logging.d("VideoSRLutDsp: GetTextures end.");
            JsonObject jsonObject2 = (JsonObject) objArrCall[0];
            iArr[0] = jsonObject2.get("input_texture").getAsInt();
            int asInt = jsonObject2.get("output_texture").getAsInt();
            iArr[1] = asInt;
            this.currInputTexture = iArr[0];
            this.currOutputTexture = asInt;
        } catch (Exception e) {
            Logging.d(String.format("VideoSRLut: call VRSR module failed, %s", e.toString()));
            e.printStackTrace();
        }
        return iArr;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutDspAPI
    public int Process() {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        JsonObject jsonObject = new JsonObject();
        if (this.srFunc == null) {
            return -1;
        }
        try {
            Logging.d("VideoSRLutDsp: call dsp process");
            Object[] objArrCall = this.srFunc.call(jsonObject);
            Logging.d("VideoSRLutDsp: dsp process end");
            return 0;
        } catch (Exception e) {
            Logging.d(String.format("VideoSRLutDsp: call VRSR module failed, %s", e.toString()));
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutDspAPI
    public void Free() {
        ModuleFunctor moduleFunctor = this.srFunc;
        if (moduleFunctor != null) {
            moduleFunctor.free();
        }
    }
}
