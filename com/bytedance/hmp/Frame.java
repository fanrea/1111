package com.bytedance.hmp;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Frame extends Ptr {
    public static Frame wrap(long ptr, boolean own) {
        return new Frame(ptr, own);
    }

    private Frame(long ptr_, boolean own_) {
        this.ptr = ptr_;
        this.own = own_;
    }

    public Frame(int width, int height, PixelInfo pix_info, String device) {
        this.ptr = Api.frame_make(width, height, pix_info.getPtr(), device);
        this.own = true;
    }

    public Frame(int width, int height, PixelInfo pix_info, Device device) {
        this.ptr = Api.frame_make(width, height, pix_info.getPtr(), device.toString());
        this.own = true;
    }

    public Frame(Tensor[] data, PixelInfo pix_info) {
        long[] jArr = new long[data.length];
        for (int i = 0; i < data.length; i++) {
            jArr[i] = data[i].getPtr();
        }
        this.ptr = Api.frame_make(jArr, pix_info.getPtr());
        this.own = true;
    }

    public Frame(Bitmap bitmap) {
        this.ptr = Api.frame_make(bitmap);
        this.own = true;
    }

    public void unlock(Bitmap bitmap) {
        Api.frame_unlock(bitmap);
    }

    public Frame(Tensor[] data, int width, int height, PixelInfo pix_info) {
        long[] jArr = new long[data.length];
        for (int i = 0; i < data.length; i++) {
            jArr[i] = data[i].getPtr();
        }
        this.ptr = Api.frame_make(jArr, width, height, pix_info.getPtr());
        this.own = true;
    }

    public void free() {
        if (this.own) {
            Api.frame_free(this.ptr);
        }
    }

    public boolean defined() {
        return Api.frame_defined(this.ptr);
    }

    public PixelInfo pixInfo() {
        return PixelInfo.wrap(Api.frame_pix_info(this.ptr), false);
    }

    public PixelFormat format() {
        return (PixelFormat) EnumUtil.fromValue(PixelFormat.class, Integer.valueOf(Api.frame_format(this.ptr)));
    }

    public int width() {
        return Api.frame_width(this.ptr);
    }

    public int height() {
        return Api.frame_height(this.ptr);
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(Api.frame_dtype(this.ptr)));
    }

    public DeviceType deviceType() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.frame_device_type(this.ptr)));
    }

    public int deviceIndex() {
        return Api.frame_device_index(this.ptr);
    }

    public int nplanes() {
        return Api.frame_nplanes(this.ptr);
    }

    public Tensor plane(int p) {
        return Tensor.wrap(Api.frame_plane(this.ptr, p), false);
    }

    public Frame to(String device, boolean nonBlocking) {
        return wrap(Api.frame_to_device(this.ptr, device, nonBlocking), true);
    }

    public Frame to(Device device, boolean nonBlocking) {
        return to(device.toString(), nonBlocking);
    }

    public void copyFrom(Frame from) {
        Api.frame_copy_from(this.ptr, from.getPtr());
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Frame m348clone() {
        return wrap(Api.frame_clone(this.ptr), true);
    }

    public Frame crop(int left, int top, int width, int height) {
        return wrap(Api.frame_crop(this.ptr, left, top, width, height), true);
    }

    public Image toImage(ChannelFormat cformat) {
        return Image.wrap(Api.frame_to_image(this.ptr, cformat.getValue()), true);
    }

    public String toString() {
        return Api.frame_stringfy(this.ptr);
    }

    public static Frame fromImage(Image image, PixelInfo pixInfo) {
        return wrap(Api.frame_from_image(image.getPtr(), pixInfo.getPtr()), true);
    }
}
