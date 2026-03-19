package com.bytedance.sdk.djx.core.business.view.like;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface OnLikeListener {
    void liked(DJXLikeButton dJXLikeButton);

    boolean onIntercept(DJXLikeButton dJXLikeButton);

    void unLiked(DJXLikeButton dJXLikeButton);
}
