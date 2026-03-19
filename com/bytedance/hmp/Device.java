package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Device extends Ptr {

    public class Guard extends Ptr {
        public Guard() {
            this.ptr = Api.device_guard_make(Device.this.ptr);
            this.own = true;
        }

        public void free() {
            if (this.own) {
                Api.device_guard_free(this.ptr);
            }
        }
    }

    public static Device wrap(long ptr, boolean own) {
        return new Device(ptr, own);
    }

    private Device(long ptr_, boolean own_) {
        this.ptr = ptr_;
        this.own = own_;
    }

    public Device() {
        this.ptr = Api.device_make("");
        this.own = true;
    }

    public Device(String device) {
        this.ptr = Api.device_make(device);
        this.own = true;
    }

    public Device(DeviceType device, int index) {
        this.ptr = Api.device_make(device.getValue(), index);
        this.own = true;
    }

    public void free() {
        if (this.own) {
            Api.device_free(this.ptr);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Device)) {
            return false;
        }
        Device device = (Device) other;
        return type() == device.type() && index() == device.index();
    }

    public DeviceType type() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.device_type(this.ptr)));
    }

    public int index() {
        return Api.device_index(this.ptr);
    }

    public String toString() {
        return Api.device_stringfy(this.ptr);
    }

    public static int count(DeviceType deviceType) {
        return Api.device_count(deviceType.getValue());
    }

    public static boolean hasCuda() {
        return count(DeviceType.kCUDA) > 0;
    }
}
