package com.bytedance.sdk.djx.net.img;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface Cache {
    public static final Cache NONE = new Cache() { // from class: com.bytedance.sdk.djx.net.img.Cache.1
        @Override // com.bytedance.sdk.djx.net.img.Cache
        public void clear() {
        }

        @Override // com.bytedance.sdk.djx.net.img.Cache
        public void clearKeyUri(String str) {
        }

        @Override // com.bytedance.sdk.djx.net.img.Cache
        public Bitmap get(String str) {
            return null;
        }

        @Override // com.bytedance.sdk.djx.net.img.Cache
        public int maxSize() {
            return 0;
        }

        @Override // com.bytedance.sdk.djx.net.img.Cache
        public void set(String str, Bitmap bitmap) {
        }

        @Override // com.bytedance.sdk.djx.net.img.Cache
        public int size() {
            return 0;
        }
    };

    void clear();

    void clearKeyUri(String str);

    Bitmap get(String str);

    int maxSize();

    void set(String str, Bitmap bitmap);

    int size();
}
