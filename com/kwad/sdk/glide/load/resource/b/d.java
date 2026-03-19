package com.kwad.sdk.glide.load.resource.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.f;
import com.kwad.sdk.glide.load.g;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d implements g<Uri, Drawable> {
    private final Context dR;

    @Override // com.kwad.sdk.glide.load.g
    public final /* synthetic */ s<Drawable> a(Uri uri, int i, int i2, f fVar) {
        return m(uri);
    }

    @Override // com.kwad.sdk.glide.load.g
    public final /* synthetic */ boolean a(Uri uri, f fVar) {
        return l(uri);
    }

    public d(Context context) {
        this.dR = context.getApplicationContext();
    }

    private static boolean l(Uri uri) {
        return uri.getScheme().equals("android.resource");
    }

    public final s<Drawable> m(Uri uri) {
        Context contextA = a(uri, uri.getAuthority());
        return c.b(a.a(this.dR, contextA, c(contextA, uri)));
    }

    private Context a(Uri uri, String str) {
        if (str.equals(this.dR.getPackageName())) {
            return this.dR;
        }
        try {
            return this.dR.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.dR.getPackageName())) {
                return this.dR;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    private int c(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return d(context, uri);
        }
        if (pathSegments.size() == 1) {
            return n(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    private static int d(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private static int n(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }
}
