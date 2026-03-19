package com.bytedance.sdk.djx.net.img;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.net.img.RequestHandler;
import com.sigmob.sdk.base.n;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class AssetRequestHandler extends RequestHandler {
    protected static final String ANDROID_ASSET = "android_asset";
    private static final int ASSET_PREFIX_LENGTH = 22;
    private final AssetManager assetManager;

    public AssetRequestHandler(Context context) {
        this.assetManager = context.getAssets();
    }

    @Override // com.bytedance.sdk.djx.net.img.RequestHandler
    public boolean canHandleRequest(Request request) {
        Uri uri = request.uri;
        return n.z.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && ANDROID_ASSET.equals(uri.getPathSegments().get(0));
    }

    @Override // com.bytedance.sdk.djx.net.img.RequestHandler
    public RequestHandler.Result load(Request request, int i) throws IOException {
        return new RequestHandler.Result(this.assetManager.open(getFilePath(request)), Picasso.LoadedFrom.DISK);
    }

    static String getFilePath(Request request) {
        return request.uri.toString().substring(ASSET_PREFIX_LENGTH);
    }
}
