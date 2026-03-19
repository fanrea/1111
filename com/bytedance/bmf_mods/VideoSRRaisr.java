package com.bytedance.bmf_mods;

import android.graphics.Bitmap;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.VideoSRRaisrAPI;
import com.bytedance.hmp.ChannelFormat;
import com.bytedance.hmp.Frame;
import com.bytedance.hmp.Image;
import com.bytedance.hmp.PixelFormat;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.texturerender.TextureRenderKeys;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoSRRaisr implements VideoSRRaisrAPI {
    private int scale_type;
    private JsonObject srOption = new JsonObject();
    private ModuleInfo srModuleInfo = null;
    private ModuleFunctor srFunc = null;
    private int data_type = 0;
    private final int SR_R_TYPE = 0;
    private final int SR_R15_TYPE = 4;

    public VideoSRRaisr() {
        Logging.d("New VideoSRRaisr");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public boolean Init(String str, int i, boolean z, int i2, int i3) {
        return Init(str, i, z, i2, i3, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public boolean Init(String str, int i, boolean z, int i2, int i3, int i4) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return false;
        }
        if (z) {
            if (i4 == 1) {
                Logging.d("SR_RAISR_Module: data type cannot transfer to OES texture");
                return false;
            }
            this.data_type = 2;
        } else if (i4 == 1) {
            this.data_type = 1;
        } else {
            this.data_type = 0;
        }
        if (i == 0) {
            this.scale_type = 1;
        } else if (i == 4) {
            this.scale_type = 0;
        } else {
            Logging.d("SR_RAISR_Module: algType param is neither 4 nor 0");
            return false;
        }
        this.srOption.addProperty(TextureRenderKeys.KEY_BMF_SCALE_TYPE, Integer.valueOf(this.scale_type));
        this.srOption.addProperty("data_type", Integer.valueOf(this.data_type));
        this.srModuleInfo = new ModuleInfo("SR_RAISR_Module", "c++", "libbmf_hydra.so", "");
        Class[] clsArr = {JsonObject.class};
        Class[] clsArr2 = {JsonObject.class};
        try {
            Logging.d("SR_RAISR_Module: load raisr Module");
            this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
            Logging.d("SR_RAISR_Module: load raisr Module success");
            return true;
        } catch (Exception e) {
            Logging.d("SR_RAISR_Module: load raisr Module failed," + e.toString());
            return false;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public int Process(int i, int i2, int i3, int i4, boolean z) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        if (this.data_type != 0) {
            Logging.d("SR_RAISR_Module: Process function only receive texture2D");
            return -1;
        }
        if (this.srFunc == null) {
            Logging.d("SR_RAISR_Module: ModuleFunctor is null");
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
            Logging.d("VideoSRRaisr: call raisr module failed," + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public int OesProcess(int i, int i2, int i3, int i4, float[] fArr, boolean z) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        if (this.data_type != 2) {
            Logging.d("SR_RAISR_Module: OesProcess function only receive oes texture");
            return -1;
        }
        if (this.srFunc == null) {
            Logging.d("SR_RAISR_Module: ModuleFunctor is null");
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
            Logging.d("VideoSRRaisr: call raisr module failed," + e.toString());
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public Bitmap Process(Bitmap bitmap, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (!SoLoader.getInstance().isSoInitialized()) {
            return null;
        }
        if (this.data_type != 1) {
            Logging.d("SR_RAISR_Module: only receive bitmap");
            return null;
        }
        if (this.srFunc == null) {
            Logging.d("SR_RAISR_Module: ModuleFunctor is null");
            return null;
        }
        Frame frame = new Frame(bitmap);
        Image image = frame.format() == PixelFormat.PF_RGBA32 ? frame.toImage(ChannelFormat.kNHWC) : null;
        if (image == null) {
            Logging.d("VideoSRRaisr: srcImage is null");
            return null;
        }
        int iWidth = image.width();
        int iHeight = image.height();
        long jDataPtr = image.data().dataPtr();
        int i5 = this.scale_type;
        if (i5 == 0) {
            i3 = (iWidth / 2) * 3;
            i4 = (iHeight / 2) * 3;
        } else {
            if (i5 != 1) {
                Logging.d("VideoSRRaisr: scale_type is neither 0 nor 1");
                return null;
            }
            i3 = iWidth * 2;
            i4 = iHeight * 2;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Frame frame2 = new Frame(bitmapCreateBitmap);
        Image image2 = frame2.format() == PixelFormat.PF_RGBA32 ? frame2.toImage(ChannelFormat.kNHWC) : null;
        if (image2 == null) {
            Logging.d("VideoSRRaisr: dstImage is null");
            return null;
        }
        long jDataPtr2 = image2.data().dataPtr();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("input_width", Integer.valueOf(iWidth));
        jsonObject.addProperty("input_height", Integer.valueOf(iHeight));
        jsonObject.addProperty("input_dataPtr", Long.valueOf(jDataPtr));
        jsonObject.addProperty("output_dataPtr", Long.valueOf(jDataPtr2));
        try {
            this.srFunc.call(jsonObject);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            Logging.d("VideoSRRaisr: call raisr module failed," + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public void Free() {
        ModuleFunctor moduleFunctor = this.srFunc;
        if (moduleFunctor != null) {
            moduleFunctor.free();
        }
    }
}
