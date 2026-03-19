package com.bytedance.bmf;

import com.bytedance.hmp.ChannelFormat;
import com.bytedance.hmp.DeviceType;
import com.bytedance.hmp.EnumUtil;
import com.bytedance.hmp.Frame;
import com.bytedance.hmp.Image;
import com.bytedance.hmp.PixelInfo;
import com.bytedance.hmp.Ptr;
import com.bytedance.hmp.ScalarType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoFrame extends Ptr {
    public static VideoFrame wrap(long p, boolean own) {
        return new VideoFrame(p, own);
    }

    VideoFrame(long p, boolean own) {
        this.ptr = p;
        this.own = own;
    }

    public VideoFrame(Image image) {
        this.ptr = API.bmf_vf_from_image(image.getPtr());
        this.own = true;
    }

    public VideoFrame(Frame frame) {
        this.ptr = API.bmf_vf_from_frame(frame.getPtr());
        this.own = true;
    }

    public VideoFrame(int width, int height, int channels, ChannelFormat cformat, ScalarType dtype, String device, boolean pinned_memory) {
        this.ptr = API.bmf_vf_make_image(width, height, channels, cformat.getValue(), dtype.getValue(), device, pinned_memory);
        this.own = true;
    }

    public VideoFrame(int width, int height, PixelInfo pixelInfo, String device) {
        this.ptr = API.bmf_vf_make_frame(width, height, pixelInfo.getPtr(), device);
        this.own = true;
    }

    public void free() {
        if (this.own) {
            API.bmf_vf_free(this.ptr);
        }
    }

    public boolean defined() {
        return API.bmf_vf_defined(this.ptr);
    }

    public int width() {
        return API.bmf_vf_width(this.ptr);
    }

    public int height() {
        return API.bmf_vf_height(this.ptr);
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(API.bmf_vf_dtype(this.ptr)));
    }

    public boolean isImage() {
        return API.bmf_vf_is_image(this.ptr);
    }

    public Image image() {
        return Image.wrap(API.bmf_vf_image(this.ptr), false);
    }

    public Frame frame() {
        return Frame.wrap(API.bmf_vf_frame(this.ptr), false);
    }

    public VideoFrame toImage(ChannelFormat channelFormat, boolean contiguous) {
        return wrap(API.bmf_vf_to_image(this.ptr, channelFormat.getValue(), contiguous), true);
    }

    public VideoFrame toFrame(PixelInfo pixelInfo) {
        return wrap(API.bmf_vf_to_frame(this.ptr, pixelInfo.getPtr()), true);
    }

    public DeviceType deviceType() {
        int iBmf_vf_device_type = API.bmf_vf_device_type(this.ptr);
        DeviceType deviceType = DeviceType.kCPU;
        if (iBmf_vf_device_type == 0) {
            return DeviceType.kCPU;
        }
        return iBmf_vf_device_type == 1 ? DeviceType.kCUDA : deviceType;
    }

    public int deviceIndex() {
        return API.bmf_vf_device_index(this.ptr);
    }

    public void copyFrom(VideoFrame from) {
        API.bmf_vf_copy_from(this.ptr, from.getPtr());
    }

    public VideoFrame to(String device, boolean non_blocking) {
        return wrap(API.bmf_vf_to_device(this.ptr, device, non_blocking), true);
    }

    public VideoFrame to(ScalarType scalarType) {
        return wrap(API.bmf_vf_to_dtype(this.ptr, scalarType.getValue()), true);
    }

    public void copyProps(VideoFrame from) {
        API.bmf_vf_copy_props(this.ptr, from.ptr);
    }

    public void privateMerge(VideoFrame from) {
        API.bmf_vf_private_merge(this.ptr, from.ptr);
    }

    /* renamed from: com.bytedance.bmf.VideoFrame$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmf$OpaqueDataKey;

        static {
            int[] iArr = new int[OpaqueDataKey.values().length];
            $SwitchMap$com$bytedance$bmf$OpaqueDataKey = iArr;
            try {
                iArr[OpaqueDataKey.kJsonParam.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public Object privateGet(OpaqueDataKey opaqueDataKey) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[opaqueDataKey.ordinal()] == 1) {
            return new Gson().fromJson(API.bmf_json_param_dump(API.bmf_vf_private_get_json_param(this.ptr)), JsonObject.class);
        }
        throw new IllegalArgumentException("Unknown opaque data key in PrivateGet");
    }

    public void privateAttach(OpaqueDataKey opaqueDataKey, Object option) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[opaqueDataKey.ordinal()] == 1) {
            API.bmf_vf_private_attach_json_param(this.ptr, API.bmf_json_param_parse(((JsonObject) option).toString()));
            return;
        }
        throw new IllegalArgumentException("Unknown opaque data key in PrivateAttach");
    }

    public void setPts(long pts) {
        API.bmf_vf_set_pts(this.ptr, pts);
    }

    public long pts() {
        return API.bmf_vf_pts(this.ptr);
    }

    public void setTimeBase(Rational rational) {
        API.bmf_vf_set_time_base(this.ptr, rational.num, rational.den);
    }

    public Rational timeBase() {
        int[] iArrBmf_vf_time_base = API.bmf_vf_time_base(this.ptr);
        return new Rational(iArrBmf_vf_time_base[0], iArrBmf_vf_time_base[1]);
    }

    public boolean ready() {
        return API.bmf_vf_ready(this.ptr);
    }

    public void record(boolean use_current) {
        API.bmf_vf_record(this.ptr, use_current);
    }

    public void synchronize() {
        API.bmf_vf_synchronize(this.ptr);
    }
}
