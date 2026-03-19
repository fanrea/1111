package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Stream extends Ptr {

    public class Guard extends Ptr {
        public Guard() {
            this.ptr = Api.stream_guard_create(Stream.this.ptr);
            this.own = true;
        }

        public void free() {
            if (this.own) {
                Api.stream_guard_free(this.ptr);
            }
        }
    }

    public static Stream wrap(long ptr, boolean own) {
        return new Stream(ptr, own);
    }

    Stream(long ptr_, boolean own_) {
        this.ptr = ptr_;
        this.own = own_;
    }

    public Stream(DeviceType device_type, long flags) {
        this.ptr = Api.stream_make(device_type.getValue(), flags);
        this.own = true;
    }

    public void free() {
        if (this.own) {
            Api.stream_free(this.ptr);
        }
    }

    public boolean query() {
        return Api.stream_query(this.ptr);
    }

    public void synchronize() {
        Api.stream_synchronize(this.ptr);
    }

    public long handle() {
        return Api.stream_handle(this.ptr);
    }

    public DeviceType deviceType() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.stream_device_type(this.ptr)));
    }

    public int deviceIndex() {
        return Api.stream_device_index(this.ptr);
    }

    public static void setCurrent(Stream stream) {
        Api.stream_set_current(stream.ptr);
    }

    public static Stream current(DeviceType deviceType) {
        return wrap(Api.stream_current(deviceType.getValue()), true);
    }
}
