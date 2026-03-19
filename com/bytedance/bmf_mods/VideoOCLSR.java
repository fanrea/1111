package com.bytedance.bmf_mods;

import android.graphics.Bitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf.VideoFrame;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.VideoOCLSRAPI;
import com.bytedance.hmp.Frame;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kwai.video.player.KsMediaMeta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoOCLSR implements VideoOCLSRAPI {
    private JsonObject srOption = new JsonObject();
    private ModuleInfo srModuleInfo = null;
    private ModuleFunctor srFunc = null;
    private int oes_flag = 0;

    public VideoOCLSR() {
        Logging.d("New VideoOCLSR");
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public boolean Init(String str, int i, boolean z, int i2, int i3) {
        return Init(str, i, z, i2, i3, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public boolean Init(String str, int i, boolean z, int i2, int i3, int i4) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        if (z) {
            this.oes_flag = 1;
        }
        this.srOption.addProperty("config_path", str);
        if (i == 0) {
            this.srOption.addProperty("scale", Double.valueOf(2.0d));
        } else if (i == 4) {
            this.srOption.addProperty("scale", Double.valueOf(1.5d));
        } else {
            Logging.d("VideoOCLSR: unsupported algoType=%d" + i);
            return false;
        }
        this.srOption.addProperty("max_input_width", Integer.valueOf(i2));
        this.srOption.addProperty("max_input_height", Integer.valueOf(i3));
        this.srOption.addProperty("filter_path", "");
        this.srOption.addProperty(KsMediaMeta.KSM_KEY_FORMAT, Integer.valueOf(i4));
        this.srOption.addProperty(TypedValues.Custom.S_COLOR, (Number) 1);
        this.srOption.addProperty("power", (Number) 4);
        this.srOption.addProperty("backend", (Number) 2);
        this.srOption.addProperty("pipeline", (Number) 1);
        this.srOption.addProperty("oes_flag", Integer.valueOf(this.oes_flag));
        this.srModuleInfo = new ModuleInfo("VRSR_Module", "c++", "libvrsr.so", "");
        Class[] clsArr = {JsonObject.class};
        Class[] clsArr2 = {JsonObject.class};
        if (i4 == 1) {
            clsArr[0] = VideoFrame.class;
            clsArr2[0] = VideoFrame.class;
        }
        try {
            Logging.d("VideoOCLSR: load VRSR Module");
            this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
            Logging.d("VideoOCLSR: load VRSR Module success");
            return true;
        } catch (Exception e) {
            Logging.d("VideoOCLSR: load VRSR Module failed," + e.toString());
            return false;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
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
            Logging.d("VideoOCLSR: call VRSR module failed, %s" + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public int OesProcess(int i, int i2, int i3, int i4, float[] fArr, boolean z) {
        if (!SoLoader.getInstance().isSoInitialized() || this.srFunc == null) {
            return -1;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("input_texture", Integer.valueOf(i));
        jsonObject.addProperty("output_texture", Integer.valueOf(i2));
        jsonObject.addProperty("width", Integer.valueOf(i3));
        jsonObject.addProperty("height", Integer.valueOf(i4));
        if (this.oes_flag == 1) {
            JsonArray jsonArray = new JsonArray();
            for (float f : fArr) {
                jsonArray.add(Float.valueOf(f));
            }
            jsonObject.add("matrix", jsonArray);
        }
        try {
            return i2;
        } catch (Exception e) {
            Logging.d("VideoOCLSR: call VRSR module failed," + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public Bitmap Process(Bitmap bitmap, int i, int i2, boolean z) {
        if (!SoLoader.getInstance().isSoInitialized() || this.srFunc == null) {
            return null;
        }
        VideoFrame videoFrame = new VideoFrame(new Frame(bitmap));
        try {
            VideoFrame videoFrame2 = (VideoFrame) this.srFunc.call(videoFrame)[0];
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(videoFrame2.width(), videoFrame2.height(), Bitmap.Config.ARGB_8888);
            VideoFrame videoFrame3 = new VideoFrame(new Frame(bitmapCreateBitmap));
            videoFrame3.copyFrom(videoFrame2);
            videoFrame.free();
            videoFrame2.free();
            videoFrame3.free();
            return bitmapCreateBitmap;
        } catch (Exception e) {
            videoFrame.free();
            Logging.d("VideoOCLSR: call VRSR module failed," + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public void Free() {
        ModuleFunctor moduleFunctor = this.srFunc;
        if (moduleFunctor != null) {
            moduleFunctor.free();
        }
    }
}
