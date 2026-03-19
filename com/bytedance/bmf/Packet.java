package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;
import com.google.gson.Gson;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Packet extends Ptr {
    public static Packet wrap(long p, boolean own) {
        return new Packet(p, own);
    }

    Packet(long p, boolean own) {
        this.ptr = p;
        this.own = own;
    }

    static Packet generateEosPacket() {
        return wrap(API.bmf_packet_generate_eos_packet(), true);
    }

    static Packet generateEofPacket() {
        return wrap(API.bmf_packet_generate_eof_packet(), true);
    }

    public Packet(Object data) {
        if (data == null) {
            this.ptr = 0L;
            this.own = false;
            return;
        }
        Class<?> cls = data.getClass();
        if (cls == VideoFrame.class) {
            this.ptr = API.bmf_packet_from_videoframe(((VideoFrame) data).getPtr());
            this.own = true;
        } else if (cls == Packet.class) {
            this.ptr = ((Packet) data).getPtr();
            this.own = false;
        } else if (cls == JsonParam.class) {
            this.ptr = API.bmf_packet_from_json_param(((JsonParam) data).getPtr());
            this.own = true;
        } else {
            this.ptr = API.bmf_packet_from_json_str(new Gson().toJson(data));
            this.own = true;
        }
    }

    public void free() {
        if (this.own) {
            API.bmf_packet_free(this.ptr);
        }
    }

    public long timestamp() {
        return API.bmf_packet_timestamp(this.ptr);
    }

    public void setTimestamp(long ts) {
        API.bmf_packet_set_timestamp(this.ptr, ts);
    }

    public boolean defined() {
        return API.bmf_packet_defined(this.ptr) != 0;
    }

    public boolean is(Class clz) {
        if (clz == VideoFrame.class) {
            return API.bmf_packet_is_videoframe(this.ptr);
        }
        return API.bmf_packet_is_json_param(this.ptr);
    }

    public Object get(Class clz) throws ClassCastException {
        if (clz == VideoFrame.class) {
            return VideoFrame.wrap(API.bmf_packet_get_videoframe(this.ptr), true);
        }
        if (clz == JsonParam.class) {
            return JsonParam.wrap(API.bmf_packet_get_json_param(this.ptr), true);
        }
        if (API.bmf_packet_is_json_param(this.ptr)) {
            return new Gson().fromJson(API.bmf_packet_to_json_str(this.ptr), clz);
        }
        throw new ClassCastException(clz.getName());
    }
}
