package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Task extends Ptr {
    public Task(long p, boolean own) {
        this.ptr = p;
        this.own = own;
    }

    public Task(int nodeId, int[] istream_ids, int[] ostream_ids) {
        this.ptr = API.bmf_task_make(nodeId, istream_ids, ostream_ids);
        this.own = true;
    }

    public void free() {
        if (this.own) {
            API.bmf_task_free(this.ptr);
        }
    }

    public static Task wrap(long p, boolean own) {
        return new Task(p, own);
    }

    public void fillInputPacket(int streamId, Packet packet) {
        API.bmf_task_fill_input_packet(this.ptr, streamId, packet.getPtr());
    }

    public void fillOutputPacket(int streamId, Packet packet) {
        API.bmf_task_fill_output_packet(this.ptr, streamId, packet.getPtr());
    }

    public Packet popPacketFromOutputQueue(int streamId) {
        return Packet.wrap(API.bmf_task_pop_packet_from_out_queue(this.ptr, streamId), true);
    }

    public Packet popPacketFromInputQueue(int streamId) {
        return Packet.wrap(API.bmf_task_pop_packet_from_input_queue(this.ptr, streamId), true);
    }

    public long timestamp() {
        return API.bmf_task_timestamp(this.ptr);
    }

    public void setTimestamp(long ts) {
        API.bmf_task_set_timestamp(this.ptr, ts);
    }

    public int[] getInputStreamIds() {
        return API.bmf_task_get_input_stream_ids(this.ptr);
    }

    public int[] getOutputStreamIds() {
        return API.bmf_task_get_output_stream_ids(this.ptr);
    }
}
