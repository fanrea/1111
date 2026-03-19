package com.bytedance.sdk.djx.net.img;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.net.img.RequestHandler;
import com.sigmob.sdk.base.n;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class FileRequestHandler extends ContentStreamRequestHandler {
    FileRequestHandler(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.djx.net.img.ContentStreamRequestHandler, com.bytedance.sdk.djx.net.img.RequestHandler
    public boolean canHandleRequest(Request request) {
        return n.z.equals(request.uri.getScheme());
    }

    @Override // com.bytedance.sdk.djx.net.img.ContentStreamRequestHandler, com.bytedance.sdk.djx.net.img.RequestHandler
    public RequestHandler.Result load(Request request, int i) throws IOException {
        return new RequestHandler.Result(null, getInputStream(request), Picasso.LoadedFrom.DISK, getFileExifRotation(request.uri));
    }

    static int getFileExifRotation(Uri uri) throws IOException {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }
}
