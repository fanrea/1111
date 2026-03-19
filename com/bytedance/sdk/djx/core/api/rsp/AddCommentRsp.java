package com.bytedance.sdk.djx.core.api.rsp;

import com.bytedance.sdk.djx.net.api.BaseDjxRsp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AddCommentRsp extends BaseDjxRsp<Object> {
    private String comment_id;
    private String comment_text;
    private Long create_time;

    public String getComment_id() {
        return this.comment_id;
    }

    public void setComment_id(String str) {
        this.comment_id = str;
    }

    public String getComment_text() {
        return this.comment_text;
    }

    public void setComment_text(String str) {
        this.comment_text = str;
    }

    public Long getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(Long l) {
        this.create_time = l;
    }
}
