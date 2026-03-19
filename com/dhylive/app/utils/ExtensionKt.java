package com.dhylive.app.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mobads.container.util.animation.j;
import com.blankj.utilcode.util.SpanUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.dhylive.app.BaseUrls;
import com.dhylive.app.R;
import com.dhylive.app.base.activity.BaseActivity;
import com.dhylive.app.base.dialog.PermissionsDialog;
import com.dhylive.app.net.HashMapNonNull;
import com.dhylive.app.v.common.activity.ProtocolActivity;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallback;
import com.permissionx.guolindev.callback.RequestCallback;
import com.permissionx.guolindev.request.ExplainScope;
import com.sigmob.sdk.base.mta.PointCategory;
import com.zxy.tiny.Tiny;
import com.zxy.tiny.callback.FileWithBitmapBatchCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Extension.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a;\u0010\u0004\u001a\u00020\u00052.\u0010\u0006\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\u0007\"\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\u0010\u000b\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0012\u0010\u0010\u001a\u00020\r*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a/\u0010\u0014\u001a\u00020\r*\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\r*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a0\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u001a0\u0010!\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u001a2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\t0#j\b\u0012\u0004\u0012\u00020\t`$2\b\u0010\u001f\u001a\u0004\u0018\u00010 \u001a\u0014\u0010%\u001a\u00020\r*\u00020\u000f2\b\b\u0001\u0010&\u001a\u00020\u001d\u001a\u0014\u0010'\u001a\u00020\r*\u00020\u000f2\b\b\u0001\u0010&\u001a\u00020\u001d\u001a\u001e\u0010(\u001a\u00020\r*\u00020\u000f2\b\b\u0001\u0010)\u001a\u00020\u001d2\b\b\u0001\u0010*\u001a\u00020\u001d\u001a\u0014\u0010+\u001a\u00020\r*\u00020\u000f2\b\b\u0001\u0010&\u001a\u00020\u001d\u001a\u0014\u0010,\u001a\u00020\r*\u00020\u000f2\b\b\u0001\u0010&\u001a\u00020\u001d\u001a\u001e\u0010-\u001a\u00020\r*\u00020\u000f2\b\b\u0001\u0010.\u001a\u00020\u001d2\b\b\u0001\u0010/\u001a\u00020\u001d\u001a\u0014\u00100\u001a\u00020\r*\u0002012\b\b\u0002\u00100\u001a\u00020\u0001\u001a\n\u00102\u001a\u00020\r*\u000201\u001a$\u00103\u001a\u00020\r*\u0002042\b\u00105\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020807\u001a.\u00109\u001a\u00020\r*\u0002042\b\b\u0001\u0010:\u001a\u00020\u001d2\b\b\u0002\u0010;\u001a\u00020\u001d2\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020807\u001a.\u00109\u001a\u00020\r*\u0002042\b\u00105\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010;\u001a\u00020\u001d2\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020807\u001a\u0012\u0010<\u001a\u00020\r*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030=\u001a\u0012\u0010>\u001a\u00020\r*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030=\u001a\u0012\u0010?\u001a\u00020\r*\u00020@2\u0006\u0010A\u001a\u00020B\u001a\u0012\u0010?\u001a\u00020\r*\u00020C2\u0006\u0010A\u001a\u00020B\u001a\u0014\u0010D\u001a\u00020\r*\u0002012\b\b\u0002\u0010D\u001a\u00020\u0001¨\u0006E"}, d2 = {"isDeveloperModeEnabled", "", "context", "Landroid/content/Context;", "nonNullMapOf", "Lcom/dhylive/app/net/HashMapNonNull;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Lcom/dhylive/app/net/HashMapNonNull;", "showPrivacyContent", "", "textView", "Landroid/widget/TextView;", "applyCameraReadWritePermissions", "Landroidx/fragment/app/FragmentActivity;", "onGrantedPermissionListener", "Lcom/dhylive/app/utils/OnGrantedPermissionListener;", "applyPermission", "permissions", "permissionName", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;Ljava/lang/String;Lcom/dhylive/app/utils/OnGrantedPermissionListener;)V", "applyReadWritePermissions", "chooseLocalPic", "Lcom/dhylive/app/base/activity/BaseActivity;", "isShowCamera", "maxCount", "", "isCompress", "onGetLocalPicListener", "Lcom/dhylive/app/utils/OnGetLocalPicListener;", "compressFile", "pathList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "drawableBottom", "drawableId", "drawableEnd", "drawableHorizontal", "start", PointCategory.END, "drawableStart", "drawableTop", "drawableVertical", j.f, j.g, "gone", "Landroid/view/View;", "invisible", "loadAvatar", "Landroid/widget/ImageView;", "url", "requestOption", "Lkotlin/Function0;", "Lcom/bumptech/glide/request/RequestOptions;", "loadImage", "resourceId", "radius", "showEmptyView", "Lcom/chad/library/adapter4/BaseQuickAdapter;", "showErrorView", "toastShort", "Landroid/app/Activity;", "content", "", "Landroidx/fragment/app/Fragment;", "visible", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ExtensionKt {
    public static final void showEmptyView(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<this>");
        baseQuickAdapter.setStateViewEnable(true);
        baseQuickAdapter.submitList(CollectionsKt.emptyList());
        AppCompatImageView appCompatImageView = new AppCompatImageView(baseQuickAdapter.getContext());
        appCompatImageView.setImageResource(R.drawable.ic_public_load_empty);
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER);
        appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        baseQuickAdapter.setStateView(appCompatImageView);
    }

    public static final void showErrorView(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<this>");
        baseQuickAdapter.setStateViewEnable(true);
        AppCompatImageView appCompatImageView = new AppCompatImageView(baseQuickAdapter.getContext());
        appCompatImageView.setImageResource(R.drawable.ic_public_load_error);
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER);
        appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        baseQuickAdapter.setStateView(appCompatImageView);
    }

    public static /* synthetic */ void visible$default(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        visible(view, z);
    }

    public static final void visible(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 4);
    }

    public static /* synthetic */ void gone$default(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        gone(view, z);
    }

    public static final void gone(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 8 : 0);
    }

    public static final void invisible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(4);
    }

    public static final void toastShort(Activity activity, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "content");
        Toast.makeText(activity, charSequence, 0).show();
    }

    public static final void toastShort(Fragment fragment, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "content");
        Toast.makeText(fragment.requireActivity(), charSequence, 0).show();
    }

    public static /* synthetic */ void loadAvatar$default(ImageView imageView, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<RequestOptions>() { // from class: com.dhylive.app.utils.ExtensionKt.loadAvatar.1
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final RequestOptions m380invoke() {
                    RequestOptions requestOptionsError = RequestOptions.bitmapTransform(new CircleCrop()).placeholder(R.drawable.ic_public_avatar_error).error(R.drawable.ic_public_avatar_error);
                    Intrinsics.checkNotNullExpressionValue(requestOptionsError, "error(...)");
                    return requestOptionsError;
                }
            };
        }
        loadAvatar(imageView, str, function0);
    }

    public static final void loadAvatar(ImageView imageView, String str, Function0<? extends RequestOptions> function0) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(function0, "requestOption");
        Glide.with(imageView.getContext()).load(str).apply((BaseRequestOptions<?>) function0.invoke()).into(imageView);
    }

    public static /* synthetic */ void loadImage$default(ImageView imageView, String str, final int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            function0 = new Function0<RequestOptions>() { // from class: com.dhylive.app.utils.ExtensionKt.loadImage.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final RequestOptions m381invoke() {
                    RequestOptions requestOptionsError = RequestOptions.bitmapTransform(new RoundedCornersTransformation(i, 0, RoundedCornersTransformation.CornerType.ALL)).placeholder(R.drawable.ic_public_image_error).error(R.drawable.ic_public_image_error);
                    Intrinsics.checkNotNullExpressionValue(requestOptionsError, "error(...)");
                    return requestOptionsError;
                }
            };
        }
        loadImage(imageView, str, i, (Function0<? extends RequestOptions>) function0);
    }

    public static final void loadImage(ImageView imageView, String str, int i, Function0<? extends RequestOptions> function0) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(function0, "requestOption");
        Glide.with(imageView.getContext()).load(str).apply((BaseRequestOptions<?>) function0.invoke()).into(imageView);
    }

    public static /* synthetic */ void loadImage$default(ImageView imageView, int i, final int i2, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            function0 = new Function0<RequestOptions>() { // from class: com.dhylive.app.utils.ExtensionKt.loadImage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final RequestOptions m382invoke() {
                    RequestOptions requestOptionsError = RequestOptions.bitmapTransform(new RoundedCornersTransformation(i2, 0, RoundedCornersTransformation.CornerType.ALL)).placeholder(R.drawable.ic_public_image_error).error(R.drawable.ic_public_image_error);
                    Intrinsics.checkNotNullExpressionValue(requestOptionsError, "error(...)");
                    return requestOptionsError;
                }
            };
        }
        loadImage(imageView, i, i2, (Function0<? extends RequestOptions>) function0);
    }

    public static final void loadImage(ImageView imageView, int i, int i2, Function0<? extends RequestOptions> function0) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(function0, "requestOption");
        Glide.with(imageView.getContext()).load(Integer.valueOf(i)).apply((BaseRequestOptions<?>) function0.invoke()).into(imageView);
    }

    public static final void drawableStart(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public static final void drawableTop(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setCompoundDrawablesWithIntrinsicBounds(0, i, 0, 0);
    }

    public static final void drawableEnd(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
    }

    public static final void drawableBottom(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, i);
    }

    public static final void drawableHorizontal(TextView textView, int i, int i2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, i2, 0);
    }

    public static final void drawableVertical(TextView textView, int i, int i2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setCompoundDrawablesWithIntrinsicBounds(0, i, 0, i2);
    }

    public static final HashMapNonNull nonNullMapOf(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        HashMapNonNull hashMapNonNull = new HashMapNonNull();
        for (Pair<String, ? extends Object> pair : pairArr) {
            hashMapNonNull.put((String) pair.getFirst(), pair.getSecond());
        }
        return hashMapNonNull;
    }

    public static final boolean isDeveloperModeEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
    }

    public static final void compressFile(final BaseActivity<?> baseActivity, final ArrayList<String> arrayList, final OnGetLocalPicListener onGetLocalPicListener) {
        Intrinsics.checkNotNullParameter(baseActivity, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, "pathList");
        Tiny.FileCompressOptions fileCompressOptions = new Tiny.FileCompressOptions();
        fileCompressOptions.size = 80.0f;
        fileCompressOptions.quality = 50;
        fileCompressOptions.isKeepSampling = false;
        Tiny.getInstance().source((String[]) arrayList.toArray(new String[0])).batchAsFile().withOptions(fileCompressOptions).batchCompress(new FileWithBitmapBatchCallback() { // from class: com.dhylive.app.utils.ExtensionKt$$ExternalSyntheticLambda0
            public final void callback(boolean z, Bitmap[] bitmapArr, String[] strArr, Throwable th) {
                ExtensionKt.compressFile$lambda$4(baseActivity, arrayList, onGetLocalPicListener, z, bitmapArr, strArr, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void compressFile$lambda$4(BaseActivity baseActivity, ArrayList arrayList, OnGetLocalPicListener onGetLocalPicListener, boolean z, Bitmap[] bitmapArr, String[] strArr, Throwable th) {
        Intrinsics.checkNotNullParameter(baseActivity, "$this_compressFile");
        Intrinsics.checkNotNullParameter(arrayList, "$pathList");
        baseActivity.dismissLoadingDialog();
        if (z && strArr != null && strArr.length == arrayList.size()) {
            if (onGetLocalPicListener != null) {
                onGetLocalPicListener.getLocalPic(new ArrayList<>(ArraysKt.toList(strArr)));
            }
        } else if (onGetLocalPicListener != null) {
            onGetLocalPicListener.getLocalPic(arrayList);
        }
    }

    public static final void chooseLocalPic(final BaseActivity<?> baseActivity, boolean z, int i, final boolean z2, final OnGetLocalPicListener onGetLocalPicListener) {
        Intrinsics.checkNotNullParameter(baseActivity, "<this>");
        PictureSelector.create((AppCompatActivity) baseActivity).openGallery(SelectMimeType.ofImage()).isDisplayCamera(z).setMaxSelectNum(i).isPageStrategy(true).setImageEngine(GlideEngine.createGlideEngine()).forResult(new OnResultCallbackListener<LocalMedia>() { // from class: com.dhylive.app.utils.ExtensionKt.chooseLocalPic.1
            @Override // com.luck.picture.lib.interfaces.OnResultCallbackListener
            public void onCancel() {
            }

            @Override // com.luck.picture.lib.interfaces.OnResultCallbackListener
            public void onResult(ArrayList<LocalMedia> result) {
                String realPath;
                Intrinsics.checkNotNullParameter(result, "result");
                ArrayList<String> arrayList = new ArrayList<>();
                for (LocalMedia localMedia : result) {
                    if (localMedia != null && (realPath = localMedia.getRealPath()) != null) {
                        Intrinsics.checkNotNull(realPath);
                        arrayList.add(realPath);
                    }
                }
                if (z2) {
                    BaseActivity.showLoadingDialog$default(baseActivity, null, 1, null);
                    ExtensionKt.compressFile(baseActivity, arrayList, onGetLocalPicListener);
                } else {
                    OnGetLocalPicListener onGetLocalPicListener2 = onGetLocalPicListener;
                    if (onGetLocalPicListener2 != null) {
                        onGetLocalPicListener2.getLocalPic(arrayList);
                    }
                }
            }
        });
    }

    public static final void applyPermission(final FragmentActivity fragmentActivity, String[] strArr, final String str, final OnGrantedPermissionListener onGrantedPermissionListener) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(str, "permissionName");
        PermissionX.init(fragmentActivity).permissions((String[]) Arrays.copyOf(strArr, strArr.length)).onExplainRequestReason(new ExplainReasonCallback() { // from class: com.dhylive.app.utils.ExtensionKt$$ExternalSyntheticLambda1
            @Override // com.permissionx.guolindev.callback.ExplainReasonCallback
            public final void onExplainReason(ExplainScope explainScope, List list) {
                ExtensionKt.applyPermission$lambda$5(explainScope, list);
            }
        }).request(new RequestCallback() { // from class: com.dhylive.app.utils.ExtensionKt$$ExternalSyntheticLambda2
            @Override // com.permissionx.guolindev.callback.RequestCallback
            public final void onResult(boolean z, List list, List list2) {
                ExtensionKt.applyPermission$lambda$6(onGrantedPermissionListener, fragmentActivity, str, z, list, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyPermission$lambda$5(ExplainScope explainScope, List list) {
        Intrinsics.checkNotNullParameter(explainScope, "scope");
        Intrinsics.checkNotNullParameter(list, "deniedList");
        explainScope.showRequestReasonDialog(list, "APP需要您同意以下权限", "确定", "取消");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyPermission$lambda$6(OnGrantedPermissionListener onGrantedPermissionListener, FragmentActivity fragmentActivity, String str, boolean z, List list, List list2) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$this_applyPermission");
        Intrinsics.checkNotNullParameter(str, "$permissionName");
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        if (!z) {
            new PermissionsDialog(fragmentActivity).setContent(str).show();
        } else if (onGrantedPermissionListener != null) {
            onGrantedPermissionListener.onGrantedPermission();
        }
    }

    public static final void applyReadWritePermissions(FragmentActivity fragmentActivity, OnGrantedPermissionListener onGrantedPermissionListener) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(onGrantedPermissionListener, "onGrantedPermissionListener");
        if (Build.VERSION.SDK_INT > 32) {
            strArr = new String[]{"android.permission.READ_MEDIA_IMAGES", PermissionConfig.READ_MEDIA_AUDIO, "android.permission.READ_MEDIA_VIDEO"};
        } else {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        applyPermission(fragmentActivity, strArr, "存储", onGrantedPermissionListener);
    }

    public static final void applyCameraReadWritePermissions(FragmentActivity fragmentActivity, OnGrantedPermissionListener onGrantedPermissionListener) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(onGrantedPermissionListener, "onGrantedPermissionListener");
        if (Build.VERSION.SDK_INT > 32) {
            strArr = new String[]{PermissionUtils.PERMISSION_CAMERA, "android.permission.READ_MEDIA_IMAGES", PermissionConfig.READ_MEDIA_AUDIO, "android.permission.READ_MEDIA_VIDEO", PermissionUtils.PERMISSION_RECORD_AUDIO};
        } else {
            strArr = new String[]{PermissionUtils.PERMISSION_CAMERA, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", PermissionUtils.PERMISSION_RECORD_AUDIO};
        }
        applyPermission(fragmentActivity, strArr, "相机,存储", onGrantedPermissionListener);
    }

    public static final void showPrivacyContent(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        final Context context = textView.getContext();
        SpanUtils.with(textView).append(context.getResources().getString(R.string.login_read_and_agree)).append((char) 12298 + context.getString(R.string.dialog_user_agreement_title) + (char) 12299).setForegroundColor(context.getColor(R.color.main_color)).setClickSpan(new ClickableSpan() { // from class: com.dhylive.app.utils.ExtensionKt.showPrivacyContent.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                ProtocolActivity.Companion companion = ProtocolActivity.Companion;
                Context context2 = context;
                Intrinsics.checkNotNullExpressionValue(context2, "$context");
                String string = context.getString(R.string.dialog_user_agreement_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.start(context2, string, BaseUrls.BASE_USER_AGREEMENT_URL);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                ds.bgColor = 0;
            }
        }).append("和").append((char) 12298 + context.getString(R.string.dialog_privacy_agreement_title) + (char) 12299).setForegroundColor(context.getColor(R.color.main_color)).setClickSpan(new ClickableSpan() { // from class: com.dhylive.app.utils.ExtensionKt.showPrivacyContent.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                ProtocolActivity.Companion companion = ProtocolActivity.Companion;
                Context context2 = context;
                Intrinsics.checkNotNullExpressionValue(context2, "$context");
                String string = context.getString(R.string.dialog_privacy_agreement_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.start(context2, string, BaseUrls.BASE_PRIVACY_AGREEMENT_URL);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                ds.bgColor = 0;
            }
        }).create();
    }
}
