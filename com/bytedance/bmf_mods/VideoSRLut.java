package com.bytedance.bmf_mods;

import android.opengl.GLES20;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.GLUtils;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.VideoSRLutAPI;
import com.google.gson.JsonObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoSRLut implements VideoSRLutAPI {
    private int algType;
    private int currHeight;
    private int currOutputTexture;
    private int currWidth;
    private JsonObject srOption = new JsonObject();
    private ModuleInfo srModuleInfo = null;
    private ModuleFunctor srFunc = null;
    private int oes_flag = 0;
    private int SR_R_TYPE = 0;
    private int SR_R15_TYPE = 4;

    public VideoSRLut() {
        Logging.d("New VideoSRLut");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public boolean Init(int i) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        if (i == this.SR_R_TYPE) {
            this.srOption.addProperty("scale", Double.valueOf(2.0d));
            this.srOption.addProperty("data_type", (Number) 1);
            this.srModuleInfo = new ModuleInfo("SR_LUT_Module", "c++", "libbmf_hydra.so", "");
            Class[] clsArr = {JsonObject.class};
            Class[] clsArr2 = {JsonObject.class};
            try {
                Logging.d("VideoSRLut: load SRLut Module");
                this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
                Logging.d("VideoSRLut: load SRLut Module success");
                return true;
            } catch (Exception e) {
                Logging.d("VideoSRLut: load video sr lut Module failed," + e.toString());
                return false;
            }
        }
        Logging.d("VideoSRLut: unsupported algoType=" + i);
        return false;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public boolean Init(String str, int i, boolean z, int i2, int i3) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        if (z) {
            this.oes_flag = 1;
        }
        if (i == this.SR_R_TYPE) {
            this.srOption.addProperty("scale", Double.valueOf(2.0d));
            this.srModuleInfo = new ModuleInfo("SR_LUT_Module", "c++", "libbmf_hydra.so", "");
            Class[] clsArr = {JsonObject.class};
            Class[] clsArr2 = {JsonObject.class};
            try {
                Logging.d("VideoSRLut: load SRLut Module");
                this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
                Logging.d("VideoSRLut: load SRLut Module success");
                return true;
            } catch (Exception e) {
                Logging.d("VideoSRLut: load video sr lut Module failed," + e.toString());
                return false;
            }
        }
        Logging.d("VideoSRLut: unsupported algoType=" + i);
        return false;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public boolean Init(String str, int i, boolean z, int i2, int i3, String str2) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        if (z) {
            this.oes_flag = 1;
        }
        if (i != this.SR_R_TYPE) {
            Logging.d(String.format("VideoSRLut: unsupported algoType=%d", Integer.valueOf(i)));
            return false;
        }
        this.srOption.addProperty("scale", Double.valueOf(2.0d));
        this.srOption.addProperty("license_module_name", str2);
        this.srModuleInfo = new ModuleInfo("SR_LUT_Module", "c++", "libbmf_hydra.so", "");
        Class[] clsArr = {JsonObject.class};
        Class[] clsArr2 = {JsonObject.class};
        try {
            Logging.d("VideoSRLut: load SRLut Module");
            this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
            Logging.d("VideoSRLut: load SRLut Module success");
            return true;
        } catch (Exception e) {
            Logging.d(String.format("VideoSRLut: load video sr lut Module failed, %s", e.toString()));
            return false;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public boolean GlSrInit(String str, int i, boolean z, int i2, int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        if (z) {
            this.oes_flag = 1;
        }
        if (i != 0) {
            Logging.d(String.format("VideoSRLut: unsupported algoType=%d", Integer.valueOf(i)));
            return false;
        }
        this.srOption.addProperty("scale", Double.valueOf(2.0d));
        this.srOption.addProperty("gl_sr", (Number) 1);
        this.srModuleInfo = new ModuleInfo("SR_LUT_Module", "c++", "libbmf_hydra.so", "");
        Class[] clsArr = {JsonObject.class};
        Class[] clsArr2 = {JsonObject.class};
        try {
            Logging.d("VideoSRLut: load VRSR Module");
            this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
            Logging.d("VideoSRLut: load VRSR Module success");
            Logging.d(String.format("BMF_gl_sr proces time:%d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
            return true;
        } catch (Exception e) {
            Logging.d(String.format("VideoSRLut: load video sr lut Module failed, %s", e.toString()));
            return false;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int Process(int i, int i2, int i3, int i4, boolean z) {
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
            Logging.d("VideoSRLut: call SRLut module failed, " + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int Process(long j, long j2, long j3, int i, int i2, int i3, int i4) {
        if (!SoLoader.getInstance().isSoInitialized() || this.srFunc == null) {
            return -1;
        }
        if (i3 != this.currWidth || i4 != this.currHeight) {
            GLUtils.deleteTexture(this.currOutputTexture);
            this.currWidth = i3;
            this.currHeight = i4;
            double d = this.algType == 0 ? 2.0d : 1.5d;
            int i5 = (int) (i3 * d);
            int i6 = (int) (d * i4);
            int iGenTexture = GLUtils.genTexture(3553);
            this.currOutputTexture = iGenTexture;
            GLES20.glBindTexture(3553, iGenTexture);
            GLES20.glTexImage2D(3553, 0, 6408, i5, i6, 0, 6408, 5121, null);
            GLES20.glBindTexture(3553, 0);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("y_ptr", Long.valueOf(j));
        jsonObject.addProperty("u_ptr", Long.valueOf(j2));
        jsonObject.addProperty("v_ptr", Long.valueOf(j3));
        jsonObject.addProperty("color_space", Integer.valueOf(i));
        jsonObject.addProperty("color_range", Integer.valueOf(i2));
        jsonObject.addProperty("output_texture", Integer.valueOf(this.currOutputTexture));
        jsonObject.addProperty("width", Integer.valueOf(i3));
        jsonObject.addProperty("height", Integer.valueOf(i4));
        try {
            return this.currOutputTexture;
        } catch (Exception e) {
            Logging.d("VideoSRLut: call SRLut module failed, " + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int AsyncProcess(int i, int i2, int i3, int i4, boolean z) {
        if (this.srFunc == null) {
            return -1;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("input_texture", Integer.valueOf(i));
        jsonObject.addProperty("output_texture", Integer.valueOf(i2));
        jsonObject.addProperty("width", Integer.valueOf(i3));
        jsonObject.addProperty("height", Integer.valueOf(i4));
        jsonObject.addProperty("async", (Number) 1);
        try {
            Logging.d("VideoSRLut: async call");
            Object[] objArrCall = this.srFunc.call(jsonObject);
            Logging.d("VideoSRLut: async call end");
            return i2;
        } catch (Exception e) {
            Logging.d("VideoSRLut: async call VRSR module failed, " + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int AsyncWait() {
        if (this.srFunc == null) {
            return -1;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("async_wait", (Number) 1);
        try {
            Logging.d("VideoSRLut: async process, wait.");
            Object[] objArrCall = this.srFunc.call(jsonObject);
            Logging.d("VideoSRLut: async wait finish.");
            return 0;
        } catch (Exception e) {
            Logging.d("VideoSRLut: call VRSR module failed, %s" + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int ClearClBuffer() {
        if (this.srFunc == null) {
            return -1;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("clear_cl_buffer", (Number) 1);
        try {
            Logging.d("VideoSRLut: clear opencl buffer start.");
            Object[] objArrCall = this.srFunc.call(jsonObject);
            Logging.d("VideoSRLut: clear opencl buffer finish.");
            return 0;
        } catch (Exception e) {
            Logging.d("VideoSRLut: clear opencl buffer failed," + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public void Free() {
        ModuleFunctor moduleFunctor = this.srFunc;
        if (moduleFunctor != null) {
            moduleFunctor.free();
        }
    }
}
