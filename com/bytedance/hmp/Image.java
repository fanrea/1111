package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Image extends Ptr {
    public static Image wrap(long ptr, boolean own) {
        return new Image(ptr, own);
    }

    private Image(long ptr_, boolean own_) {
        this.ptr = ptr_;
        this.own = own_;
    }

    public Image(int width, int height, int channels, ChannelFormat cformat, ScalarType dtype, String device, boolean pinnedMemory) {
        this.ptr = Api.image_make(width, height, channels, cformat.getValue(), dtype.getValue(), device, pinnedMemory);
        this.own = true;
    }

    public Image(Tensor data, ChannelFormat cformat) {
        this.ptr = Api.image_make(data.getPtr(), cformat.getValue());
        this.own = true;
    }

    public Image(Tensor data, ChannelFormat cformat, ColorModel cm) {
        this.ptr = Api.image_make(data.getPtr(), cformat.getValue(), cm.getPtr());
        this.own = true;
    }

    public void free() {
        if (this.own) {
            Api.image_free(this.ptr);
        }
    }

    public boolean defined() {
        return Api.image_defined(this.ptr);
    }

    public void setColorModel(ColorModel cm) {
        Api.image_set_color_model(this.ptr, cm.getPtr());
    }

    public ColorModel colorModel() {
        return ColorModel.wrap(Api.image_color_model(this.ptr), false);
    }

    public int wdim() {
        return Api.image_wdim(this.ptr);
    }

    public int hdim() {
        return Api.image_hdim(this.ptr);
    }

    public int cdim() {
        return Api.image_cdim(this.ptr);
    }

    public int width() {
        return Api.image_width(this.ptr);
    }

    public int height() {
        return Api.image_height(this.ptr);
    }

    public int nchannels() {
        return Api.image_nchannels(this.ptr);
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(Api.image_dtype(this.ptr)));
    }

    public DeviceType deviceType() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.image_device_type(this.ptr)));
    }

    public int deviceIndex() {
        return Api.image_device_index(this.ptr);
    }

    public Tensor data() {
        return Tensor.wrap(Api.image_data(this.ptr), false);
    }

    public Image to(String device, boolean nonBlocking) {
        return wrap(Api.image_to_device(this.ptr, device, nonBlocking), true);
    }

    public Image to(Device device, boolean nonBlocking) {
        return to(device.toString(), nonBlocking);
    }

    public void copyFrom(Image from) {
        Api.image_copy_from(this.ptr, from.getPtr());
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Image m349clone() {
        return wrap(Api.image_clone(this.ptr), true);
    }

    public Image crop(int left, int top, int width, int height) {
        return wrap(Api.image_crop(this.ptr, left, top, width, height), true);
    }

    public String toString() {
        return Api.image_stringfy(this.ptr);
    }
}
