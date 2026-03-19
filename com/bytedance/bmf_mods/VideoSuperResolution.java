package com.bytedance.bmf_mods;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.bytedance.bmf.JsonParam;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.BmfUtils;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.BmfException;
import com.bytedance.bmf_mods_api.VideoSuperResolutionAPI;
import com.bytedance.hmp.ChannelFormat;
import com.bytedance.hmp.Frame;
import com.bytedance.hmp.Image;
import com.bytedance.hmp.PixelFormat;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.google.gson.JsonObject;
import com.ss.texturerender.TextureRenderKeys;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoSuperResolution implements VideoSuperResolutionAPI {
    private JsonObject srOption = new JsonObject();
    private ModuleInfo srModuleInfo = null;
    private ModuleFunctor srFunc = null;
    private int scaleType = 0;
    private int algType_ = -1;
    private int mBackend = 0;
    private long mNativePtr = 0;

    private native long nativeCreateSuperResolution();

    private native int nativeInitSuperResolution(long j, int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, String str3, int i7);

    private native void nativeReleaseSuperResolution(long j);

    private native int nativeSuperResolutionGetQueuingTaskNum(long j);

    private native int nativeSuperResolutionGetResultTexture(long j);

    private native int nativeSuperResolutionOesProcess(long j, int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2);

    private native int nativeSuperResolutionOesProcessMultiScale(long j, int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, int i10);

    private native int nativeSuperResolutionOesYuvProcess(long j, int i, int i2, int i3, float[] fArr, float[] fArr2, float[] fArr3, boolean z);

    private native int nativeSuperResolutionProcess(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2);

    private native int nativeSuperResolutionProcessBitmap(long j, Bitmap bitmap, Bitmap bitmap2);

    private native int nativeSuperResolutionProcessBitmapMultiScale(long j, Bitmap bitmap, Bitmap bitmap2, int i, int i2);

    private native int nativeSuperResolutionProcessMultiScale(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, int i10);

    private native int nativeSuperResolutionProcessYuv(long j, long j2, long j3, long j4, int i, int i2, int i3, int i4);

    public VideoSuperResolution() {
        Logging.d("New VideoSuperResolution");
    }

    public VideoSuperResolution(Context context) {
        Logging.d("New VideoSuperResolution with context");
        SoLoader.getInstance().setContext(context);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    @Deprecated
    public int Init(int i, int i2, int i3, int i4, String str, String str2) {
        return Init(i, i2, i3, i4, str, str2, "");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    @Deprecated
    public int Init(int i, int i2, int i3, int i4, String str, String str2, String str3) {
        return Init(i, i2, i3, i4, str, str2, str3, 0, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int Init(int i, int i2, int i3, int i4, String str, String str2, String str3, int i5, int i6) {
        return Init(i, i2, i3, i4, str, str2, str3, i5, i6, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int Init(int i, int i2, int i3, int i4, String str, String str2, String str3, int i5, int i6, int i7) throws IOException {
        int i8 = i4;
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        this.scaleType = i3;
        this.algType_ = i;
        this.mBackend = i2;
        if (i < 0 || i > 12 || i2 < 0 || i2 > 4) {
            Logging.d("VideoSuperResolution: alg_type or backend is not support. check input param  alg_type:" + i + " backend:" + i2 + " scale_type:" + i3 + " pool_size:" + i8 + " libpath:" + str + " licenseModuleName:" + str2 + " programCacheDir:" + str3 + " max_width:" + i5 + " max_height:" + i6);
            return -1;
        }
        if (i <= 2) {
            if (i3 == 2) {
                this.scaleType = 0;
            }
            this.srOption.addProperty("backend", Integer.valueOf(i2));
            this.srOption.addProperty(TextureRenderKeys.KEY_IS_BMF_SHARPEN_ALG_TYPE, Integer.valueOf(i));
            this.srOption.addProperty(TextureRenderKeys.KEY_BMF_SCALE_TYPE, Integer.valueOf(this.scaleType));
            if (i8 <= 0) {
                Logging.d("VideoSuperResolution: pool size should be more than 0, change to 6 for default");
                i8 = 6;
            }
            this.srOption.addProperty("pool_size", Integer.valueOf(i8));
            this.srOption.addProperty("license_module_name", str2);
            this.srOption.addProperty(TextureRenderKeys.KEY_IS_BMF_SHARPEN_PROGRAME_CACHE_DIR, str3);
            if (i5 > 0 && i6 > 0) {
                this.srOption.addProperty(TextureRenderKeys.KEY_IS_MAX_WIDTH, Integer.valueOf(i5));
                this.srOption.addProperty(TextureRenderKeys.KEY_IS_MAX_HEIGHT, Integer.valueOf(i6));
            }
            this.srModuleInfo = new ModuleInfo("SuperResolutionModule", "c++", "libbmf_hydra.so", "");
            Class[] clsArr = {JsonParam.class};
            Class[] clsArr2 = {JsonParam.class};
            try {
                Logging.d("VideoSuperResolution: load VideoSuperResolution Module");
                this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, clsArr, clsArr2);
                Logging.d("VideoSuperResolution: load VideoSuperResolution Module success");
                return 0;
            } catch (Exception e) {
                Logging.d(String.format("VideoSuperResolution: load VideoSuperResolution Module failed, %s", e.toString()));
                return -1;
            }
        }
        if (i2 == 4) {
            File file = new File(str, "libhexagonAlg_skel.so");
            if (!file.exists() || !file.isFile() || file.length() <= 0 || !BmfUtils.fileMd5(file).equalsIgnoreCase(BuildConfig.hexagonAlgSkelMd5)) {
                if (SoLoader.getInstance().getAppContext() == null) {
                    return -1;
                }
                AssetManager assets = SoLoader.getInstance().getAppContext().getAssets();
                File file2 = new File(str);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                try {
                    InputStream inputStreamOpen = assets.open("libhexagonAlg_skel.so");
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i9 = inputStreamOpen.read(bArr);
                                if (i9 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i9);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            if (inputStreamOpen != null) {
                                inputStreamOpen.close();
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception e2) {
                    Logging.d("VideoSuperResolution: get dsp so failed, " + e2.toString());
                    e2.printStackTrace();
                    return -1;
                }
            }
        }
        long jNativeCreateSuperResolution = nativeCreateSuperResolution();
        this.mNativePtr = jNativeCreateSuperResolution;
        if (jNativeCreateSuperResolution == 0) {
            return -1;
        }
        int i10 = i - 3;
        if (i10 < 4 && this.scaleType == 2) {
            this.scaleType = 0;
        }
        return nativeInitSuperResolution(jNativeCreateSuperResolution, i10, i2, this.scaleType, i4, i5, i6, str == null ? "" : str, str2 == null ? "" : str2, str3 != null ? str3 : "", i7);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessTexture(int i, int i2, int i3) {
        return ProcessTexture(i, i2, i3, 0, 0, 0, 0, 0, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x010f  */
    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int ProcessTexture(int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bmf_mods.VideoSuperResolution.ProcessTexture(int, int, int, int, int, int, int, int, long):int");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessOesTexture(int i, int i2, int i3, float[] fArr) {
        return ProcessOesTexture(i, i2, i3, fArr, 0, 0, 0, 0, 0, 0L);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessOesTexture(int i, int i2, int i3, float[] fArr, float[] fArr2, float[] fArr3, boolean z) {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        long j = this.mNativePtr;
        if (j == 0 || this.algType_ <= 2 || nativeSuperResolutionOesYuvProcess(j, i, i2, i3, fArr, fArr2, fArr3, z) != 0) {
            return -1;
        }
        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int ProcessOesTexture(int r18, int r19, int r20, float[] r21, int r22, int r23, int r24, int r25, int r26, long r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bmf_mods.VideoSuperResolution.ProcessOesTexture(int, int, int, float[], int, int, int, int, int, long):int");
    }

    public int ProcessMultiScaleTexture(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, int i9, int i10) throws Throwable {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long j2;
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        int i16 = this.algType_;
        if (i16 > 2) {
            long j3 = this.mNativePtr;
            if (j3 == 0) {
                return -1;
            }
            if (i16 >= 7 || !((i11 = this.scaleType) == i10 || (i11 == 0 && i10 == 2))) {
                if (i16 >= 7) {
                    if (nativeSuperResolutionProcessMultiScale(j3, i, i2, i3, i4, i5, i6, i7, i8, j, i9, i10) == 0) {
                        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
                    }
                }
                return -1;
            }
            if (nativeSuperResolutionProcess(j3, i, i2, i3, i4, i5, i6, i7, i8, j) == 0) {
                return nativeSuperResolutionGetResultTexture(this.mNativePtr);
            }
            return -1;
        }
        if (i4 < 0 || i5 < 0 || i4 + i6 > i2 || i5 + i7 > i3 || (!(i8 == 0 || i8 == 1) || j < 0 || (j >> 32) > 0)) {
            Logging.d("VideoSuperResolution: ROI param incorrect");
            return -1;
        }
        if (i8 == 0) {
            j2 = 0;
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 0;
        } else {
            i12 = i4;
            i13 = i5;
            i14 = i6;
            i15 = i7;
            j2 = j;
        }
        if (((i16 != 0 && i16 != 2) || (i10 != 0 && i10 != 1 && i10 != 2)) && (i16 != 1 || (i10 != 0 && i10 != 2))) {
            return -1;
        }
        JsonParam jsonParam = new JsonParam();
        JsonParam jsonParam2 = null;
        try {
            try {
                jsonParam.set(ILogConst.Keys.KEY_MODE, 0);
                jsonParam.set("input_data_type", 0);
                jsonParam.set("input_texture", Integer.valueOf(i));
                jsonParam.set("width", Integer.valueOf(i2));
                jsonParam.set("height", Integer.valueOf(i3));
                jsonParam.set("in_roi_w_start", Integer.valueOf(i12));
                jsonParam.set("in_roi_h_start", Integer.valueOf(i13));
                jsonParam.set("in_roi_w", Integer.valueOf(i14));
                jsonParam.set("in_roi_h", Integer.valueOf(i15));
                jsonParam.set(TextureRenderKeys.KEY_IS_ROI_MODE, Integer.valueOf(i8));
                jsonParam.set("roiBackground", Long.valueOf(j2));
                JsonParam jsonParam3 = (JsonParam) this.srFunc.call(jsonParam)[0];
                try {
                    int i17 = jsonParam3.getInt("output_texture");
                    jsonParam.free();
                    if (jsonParam3 != null) {
                        jsonParam3.free();
                    }
                    return i17;
                } catch (Exception e) {
                    e = e;
                    jsonParam2 = jsonParam3;
                    Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());
                    e.printStackTrace();
                    jsonParam.free();
                    if (jsonParam2 != null) {
                        jsonParam2.free();
                    }
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    jsonParam2 = jsonParam3;
                    jsonParam.free();
                    if (jsonParam2 != null) {
                        jsonParam2.free();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int ProcessMultiScaleOesTexture(int r19, int r20, int r21, float[] r22, int r23, int r24, int r25, int r26, int r27, long r28, int r30, int r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bmf_mods.VideoSuperResolution.ProcessMultiScaleOesTexture(int, int, int, float[], int, int, int, int, int, long, int, int):int");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessYuv420p(long j, long j2, long j3, int i, int i2, int i3, int i4) throws Throwable {
        if (!SoLoader.getInstance().isSoInitialized()) {
            return -1;
        }
        if (this.algType_ <= 2) {
            if (this.srFunc == null) {
                return -1;
            }
            JsonParam jsonParam = new JsonParam();
            JsonParam jsonParam2 = null;
            try {
                try {
                    jsonParam.set(ILogConst.Keys.KEY_MODE, 0);
                    jsonParam.set("input_data_type", 3);
                    jsonParam.set("y_ptr", Long.valueOf(j));
                    jsonParam.set("u_ptr", Long.valueOf(j2));
                    jsonParam.set("v_ptr", Long.valueOf(j3));
                    jsonParam.set("color_space", Integer.valueOf(i));
                    jsonParam.set("color_range", Integer.valueOf(i2));
                    jsonParam.set("width", Integer.valueOf(i3));
                    jsonParam.set("height", Integer.valueOf(i4));
                    JsonParam jsonParam3 = (JsonParam) this.srFunc.call(jsonParam)[0];
                    try {
                        int i5 = jsonParam3.getInt("output_texture");
                        jsonParam.free();
                        if (jsonParam3 != null) {
                            jsonParam3.free();
                        }
                        return i5;
                    } catch (Exception e) {
                        e = e;
                        jsonParam2 = jsonParam3;
                        Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());
                        e.printStackTrace();
                        jsonParam.free();
                        if (jsonParam2 != null) {
                            jsonParam2.free();
                        }
                        return -1;
                    } catch (Throwable th) {
                        th = th;
                        jsonParam2 = jsonParam3;
                        jsonParam.free();
                        if (jsonParam2 != null) {
                            jsonParam2.free();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            long j4 = this.mNativePtr;
            if (j4 != 0 && nativeSuperResolutionProcessYuv(j4, j, j2, j3, i3, i4, i, i2) == 0) {
                return nativeSuperResolutionGetResultTexture(this.mNativePtr);
            }
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public Bitmap ProcessBitmap(Bitmap bitmap, int i, int i2) throws Throwable {
        int i3;
        int i4;
        int i5;
        int i6;
        Frame frame;
        Bitmap bitmap2;
        if (!SoLoader.getInstance().isSoInitialized()) {
            return null;
        }
        if (this.algType_ > 2) {
            if (bitmap == null) {
                throw new BmfException(BmfException.INPUT_PARAM_INVALID, "Input bitmap is null");
            }
            if (this.mNativePtr == 0) {
                throw new BmfException(-100010, "VideoSuperResolution not initialized");
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i7 = this.scaleType;
            if (i7 == 0) {
                i3 = width * 2;
                i4 = height * 2;
            } else if (i7 == 1) {
                i3 = (width * 3) / 2;
                i4 = (height * 3) / 2;
            } else {
                Logging.d("VideoSuperResolution: scaleType is neither 0 nor 1");
                throw new BmfException(BmfException.INPUT_PARAM_INVALID, "ScaleType not valid");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            int iNativeSuperResolutionProcessBitmap = nativeSuperResolutionProcessBitmap(this.mNativePtr, bitmap, bitmapCreateBitmap);
            if (iNativeSuperResolutionProcessBitmap >= 0) {
                return bitmapCreateBitmap;
            }
            bitmapCreateBitmap.recycle();
            throw new BmfException(iNativeSuperResolutionProcessBitmap, "Process Bitmap failed, error code: " + iNativeSuperResolutionProcessBitmap);
        }
        if (this.srFunc == null) {
            return null;
        }
        if (bitmap == null) {
            Logging.d("VideoSuperResolution: srcBmp is null");
            return null;
        }
        Frame frame2 = new Frame(bitmap);
        Image image = frame2.format() == PixelFormat.PF_RGBA32 ? frame2.toImage(ChannelFormat.kNHWC) : null;
        if (image == null) {
            Logging.d("VideoSuperResolution: srcImage is null");
            return null;
        }
        int iWidth = image.width();
        int iHeight = image.height();
        long jDataPtr = image.data().dataPtr();
        int i8 = this.scaleType;
        if (i8 == 0) {
            i5 = iWidth * 2;
            i6 = iHeight * 2;
        } else if (i8 == 1) {
            i5 = (iWidth * 3) / 2;
            i6 = (iHeight * 3) / 2;
        } else {
            Logging.d("VideoSuperResolution: scaleType is neither 0 nor 1");
            return null;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        Frame frame3 = new Frame(bitmapCreateBitmap2);
        Image image2 = frame3.format() == PixelFormat.PF_RGBA32 ? frame3.toImage(ChannelFormat.kNHWC) : null;
        if (image2 == null) {
            Logging.d("VideoSuperResolution: dstImage is null");
            return null;
        }
        long jDataPtr2 = image2.data().dataPtr();
        int rowBytes = bitmap.getRowBytes();
        int rowBytes2 = bitmapCreateBitmap2.getRowBytes();
        if (rowBytes < iWidth || rowBytes2 < i5) {
            Logging.d("VideoSuperResolution: bitmap stride is smaller than bitmap width");
            return null;
        }
        JsonParam jsonParam = new JsonParam();
        Image image3 = image2;
        try {
            jsonParam.set(ILogConst.Keys.KEY_MODE, 0);
            jsonParam.set("input_data_type", 4);
            jsonParam.set("width", Integer.valueOf(iWidth));
            jsonParam.set("height", Integer.valueOf(iHeight));
            jsonParam.set("input_stride", Integer.valueOf(rowBytes));
            jsonParam.set("output_stride", Integer.valueOf(rowBytes2));
            jsonParam.set("input_dataPtr", Long.valueOf(jDataPtr));
            jsonParam.set("output_dataPtr", Long.valueOf(jDataPtr2));
            Object[] objArrCall = this.srFunc.call(jsonParam);
            if (objArrCall == null || ((JsonParam) objArrCall[0]).getInt("output_texture") == -1) {
                bitmapCreateBitmap2.recycle();
                bitmap2 = null;
            } else {
                bitmap2 = bitmapCreateBitmap2;
            }
            jsonParam.free();
            frame2.free();
            frame2.unlock(bitmap);
            image.free();
            frame3.free();
            frame3.unlock(bitmap2);
            image3.free();
            return bitmap2;
        } catch (Exception e) {
            frame = frame3;
            try {
                Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());
                e.printStackTrace();
                jsonParam.free();
                frame2.free();
                frame2.unlock(bitmap);
                image.free();
                frame.free();
                frame.unlock(bitmapCreateBitmap2);
                image3.free();
                return null;
            } catch (Throwable th) {
                th = th;
                jsonParam.free();
                frame2.free();
                frame2.unlock(bitmap);
                image.free();
                frame.free();
                frame.unlock(bitmapCreateBitmap2);
                image3.free();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            frame = frame3;
            jsonParam.free();
            frame2.free();
            frame2.unlock(bitmap);
            image.free();
            frame.free();
            frame.unlock(bitmapCreateBitmap2);
            image3.free();
            throw th;
        }
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int GetQueuingTaskNum() {
        if (SoLoader.getInstance().isSoInitialized() && this.algType_ == 7 && this.mBackend == 3) {
            return nativeSuperResolutionGetQueuingTaskNum(this.mNativePtr);
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x021f  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap ProcessMultiScaleBitmap(android.graphics.Bitmap r20, int r21, int r22) throws com.bytedance.bmf_mods_api.BmfException {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bmf_mods.VideoSuperResolution.ProcessMultiScaleBitmap(android.graphics.Bitmap, int, int):android.graphics.Bitmap");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public void Free() {
        ModuleFunctor moduleFunctor = this.srFunc;
        if (moduleFunctor != null) {
            moduleFunctor.free();
        }
        long j = this.mNativePtr;
        if (j != 0) {
            nativeReleaseSuperResolution(j);
        }
    }
}
