package com.permissionx.guolindev.dialog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.container.util.cm;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.R;
import com.permissionx.guolindev.databinding.PermissionxDefaultDialogLayoutBinding;
import com.permissionx.guolindev.databinding.PermissionxPermissionItemBinding;
import com.permissionx.guolindev.request.RequestBackgroundLocationPermission;
import com.permissionx.guolindev.request.RequestBodySensorsBackgroundPermission;
import com.permissionx.guolindev.request.RequestInstallPackagesPermission;
import com.permissionx.guolindev.request.RequestManageExternalStoragePermission;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultDialog.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\r\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0019J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/permissionx/guolindev/dialog/DefaultDialog;", "Lcom/permissionx/guolindev/dialog/RationaleDialog;", "context", "Landroid/content/Context;", "permissions", "", "", cm.V, "positiveText", "negativeText", "lightColor", "", "darkColor", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "binding", "Lcom/permissionx/guolindev/databinding/PermissionxDefaultDialogLayoutBinding;", "buildPermissionsLayout", "", "getNegativeButton", "Landroid/view/View;", "getPermissionsToRequest", "getPositiveButton", "isDarkTheme", "", "isPermissionLayoutEmpty", "isPermissionLayoutEmpty$permissionx_release", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupText", "setupWindow", "permissionx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class DefaultDialog extends RationaleDialog {
    private PermissionxDefaultDialogLayoutBinding binding;
    private final int darkColor;
    private final int lightColor;
    private final String message;
    private final String negativeText;
    private final List<String> permissions;
    private final String positiveText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDialog(Context context, List<String> list, String str, String str2, String str3, int i, int i2) {
        super(context, R.style.PermissionXDefaultDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "permissions");
        Intrinsics.checkNotNullParameter(str, cm.V);
        Intrinsics.checkNotNullParameter(str2, "positiveText");
        this.permissions = list;
        this.message = str;
        this.positiveText = str2;
        this.negativeText = str3;
        this.lightColor = i;
        this.darkColor = i2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBindingInflate = PermissionxDefaultDialogLayoutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(permissionxDefaultDialogLayoutBindingInflate, "inflate(layoutInflater)");
        this.binding = permissionxDefaultDialogLayoutBindingInflate;
        if (permissionxDefaultDialogLayoutBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            permissionxDefaultDialogLayoutBindingInflate = null;
        }
        setContentView(permissionxDefaultDialogLayoutBindingInflate.getRoot());
        setupText();
        buildPermissionsLayout();
        setupWindow();
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public View getPositiveButton() {
        PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding = this.binding;
        if (permissionxDefaultDialogLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            permissionxDefaultDialogLayoutBinding = null;
        }
        Button button = permissionxDefaultDialogLayoutBinding.positiveBtn;
        Intrinsics.checkNotNullExpressionValue(button, "binding.positiveBtn");
        return button;
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public View getNegativeButton() {
        PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding = null;
        if (this.negativeText == null) {
            return null;
        }
        PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding2 = this.binding;
        if (permissionxDefaultDialogLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            permissionxDefaultDialogLayoutBinding = permissionxDefaultDialogLayoutBinding2;
        }
        return permissionxDefaultDialogLayoutBinding.negativeBtn;
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public List<String> getPermissionsToRequest() {
        return this.permissions;
    }

    public final boolean isPermissionLayoutEmpty$permissionx_release() {
        PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding = this.binding;
        if (permissionxDefaultDialogLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            permissionxDefaultDialogLayoutBinding = null;
        }
        return permissionxDefaultDialogLayoutBinding.permissionsLayout.getChildCount() == 0;
    }

    private final void setupText() {
        PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding = this.binding;
        PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding2 = null;
        if (permissionxDefaultDialogLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            permissionxDefaultDialogLayoutBinding = null;
        }
        permissionxDefaultDialogLayoutBinding.messageText.setText(this.message);
        PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding3 = this.binding;
        if (permissionxDefaultDialogLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            permissionxDefaultDialogLayoutBinding3 = null;
        }
        permissionxDefaultDialogLayoutBinding3.positiveBtn.setText(this.positiveText);
        if (this.negativeText != null) {
            PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding4 = this.binding;
            if (permissionxDefaultDialogLayoutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                permissionxDefaultDialogLayoutBinding4 = null;
            }
            permissionxDefaultDialogLayoutBinding4.negativeLayout.setVisibility(0);
            PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding5 = this.binding;
            if (permissionxDefaultDialogLayoutBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                permissionxDefaultDialogLayoutBinding5 = null;
            }
            permissionxDefaultDialogLayoutBinding5.negativeBtn.setText(this.negativeText);
        } else {
            PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding6 = this.binding;
            if (permissionxDefaultDialogLayoutBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                permissionxDefaultDialogLayoutBinding6 = null;
            }
            permissionxDefaultDialogLayoutBinding6.negativeLayout.setVisibility(8);
        }
        if (isDarkTheme()) {
            if (this.darkColor != -1) {
                PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding7 = this.binding;
                if (permissionxDefaultDialogLayoutBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    permissionxDefaultDialogLayoutBinding7 = null;
                }
                permissionxDefaultDialogLayoutBinding7.positiveBtn.setTextColor(this.darkColor);
                PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding8 = this.binding;
                if (permissionxDefaultDialogLayoutBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    permissionxDefaultDialogLayoutBinding2 = permissionxDefaultDialogLayoutBinding8;
                }
                permissionxDefaultDialogLayoutBinding2.negativeBtn.setTextColor(this.darkColor);
                return;
            }
            return;
        }
        if (this.lightColor != -1) {
            PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding9 = this.binding;
            if (permissionxDefaultDialogLayoutBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                permissionxDefaultDialogLayoutBinding9 = null;
            }
            permissionxDefaultDialogLayoutBinding9.positiveBtn.setTextColor(this.lightColor);
            PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding10 = this.binding;
            if (permissionxDefaultDialogLayoutBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                permissionxDefaultDialogLayoutBinding2 = permissionxDefaultDialogLayoutBinding10;
            }
            permissionxDefaultDialogLayoutBinding2.negativeBtn.setTextColor(this.lightColor);
        }
    }

    private final void buildPermissionsLayout() {
        String str;
        HashSet hashSet = new HashSet();
        int i = Build.VERSION.SDK_INT;
        for (String str2 : this.permissions) {
            PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding = null;
            if (i < 29) {
                try {
                    str = getContext().getPackageManager().getPermissionInfo(str2, 0).group;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    str = null;
                }
            } else if (i == 29) {
                str = PermissionMapKt.getPermissionMapOnQ().get(str2);
            } else if (i == 30) {
                str = PermissionMapKt.getPermissionMapOnR().get(str2);
            } else if (i == 31) {
                str = PermissionMapKt.getPermissionMapOnS().get(str2);
            } else if (i == 33) {
                str = PermissionMapKt.getPermissionMapOnT().get(str2);
            } else {
                str = PermissionMapKt.getPermissionMapOnT().get(str2);
            }
            if ((PermissionMapKt.getAllSpecialPermissions().contains(str2) && !hashSet.contains(str2)) || (str != null && !hashSet.contains(str))) {
                LayoutInflater layoutInflater = getLayoutInflater();
                PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding2 = this.binding;
                if (permissionxDefaultDialogLayoutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    permissionxDefaultDialogLayoutBinding2 = null;
                }
                PermissionxPermissionItemBinding permissionxPermissionItemBindingInflate = PermissionxPermissionItemBinding.inflate(layoutInflater, permissionxDefaultDialogLayoutBinding2.permissionsLayout, false);
                Intrinsics.checkNotNullExpressionValue(permissionxPermissionItemBindingInflate, "inflate(layoutInflater, …permissionsLayout, false)");
                if (Intrinsics.areEqual(str2, RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION)) {
                    permissionxPermissionItemBindingInflate.permissionText.setText(getContext().getString(R.string.permissionx_access_background_location));
                    ImageView imageView = permissionxPermissionItemBindingInflate.permissionIcon;
                    PackageManager packageManager = getContext().getPackageManager();
                    Intrinsics.checkNotNull(str);
                    imageView.setImageResource(packageManager.getPermissionGroupInfo(str, 0).icon);
                } else if (Intrinsics.areEqual(str2, "android.permission.SYSTEM_ALERT_WINDOW")) {
                    permissionxPermissionItemBindingInflate.permissionText.setText(getContext().getString(R.string.permissionx_system_alert_window));
                    permissionxPermissionItemBindingInflate.permissionIcon.setImageResource(R.drawable.permissionx_ic_alert);
                } else if (Intrinsics.areEqual(str2, "android.permission.WRITE_SETTINGS")) {
                    permissionxPermissionItemBindingInflate.permissionText.setText(getContext().getString(R.string.permissionx_write_settings));
                    permissionxPermissionItemBindingInflate.permissionIcon.setImageResource(R.drawable.permissionx_ic_setting);
                } else if (Intrinsics.areEqual(str2, RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE)) {
                    permissionxPermissionItemBindingInflate.permissionText.setText(getContext().getString(R.string.permissionx_manage_external_storage));
                    ImageView imageView2 = permissionxPermissionItemBindingInflate.permissionIcon;
                    PackageManager packageManager2 = getContext().getPackageManager();
                    Intrinsics.checkNotNull(str);
                    imageView2.setImageResource(packageManager2.getPermissionGroupInfo(str, 0).icon);
                } else if (Intrinsics.areEqual(str2, RequestInstallPackagesPermission.REQUEST_INSTALL_PACKAGES)) {
                    permissionxPermissionItemBindingInflate.permissionText.setText(getContext().getString(R.string.permissionx_request_install_packages));
                    permissionxPermissionItemBindingInflate.permissionIcon.setImageResource(R.drawable.permissionx_ic_install);
                } else if (Intrinsics.areEqual(str2, PermissionX.permission.POST_NOTIFICATIONS) && Build.VERSION.SDK_INT < 33) {
                    permissionxPermissionItemBindingInflate.permissionText.setText(getContext().getString(R.string.permissionx_post_notification));
                    permissionxPermissionItemBindingInflate.permissionIcon.setImageResource(R.drawable.permissionx_ic_notification);
                } else if (Intrinsics.areEqual(str2, RequestBodySensorsBackgroundPermission.BODY_SENSORS_BACKGROUND)) {
                    permissionxPermissionItemBindingInflate.permissionText.setText(getContext().getString(R.string.permissionx_body_sensor_background));
                    ImageView imageView3 = permissionxPermissionItemBindingInflate.permissionIcon;
                    PackageManager packageManager3 = getContext().getPackageManager();
                    Intrinsics.checkNotNull(str);
                    imageView3.setImageResource(packageManager3.getPermissionGroupInfo(str, 0).icon);
                } else {
                    TextView textView = permissionxPermissionItemBindingInflate.permissionText;
                    Context context = getContext();
                    PackageManager packageManager4 = getContext().getPackageManager();
                    Intrinsics.checkNotNull(str);
                    textView.setText(context.getString(packageManager4.getPermissionGroupInfo(str, 0).labelRes));
                    permissionxPermissionItemBindingInflate.permissionIcon.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                }
                if (isDarkTheme()) {
                    if (this.darkColor != -1) {
                        permissionxPermissionItemBindingInflate.permissionIcon.setColorFilter(this.darkColor, PorterDuff.Mode.SRC_ATOP);
                    }
                } else if (this.lightColor != -1) {
                    permissionxPermissionItemBindingInflate.permissionIcon.setColorFilter(this.lightColor, PorterDuff.Mode.SRC_ATOP);
                }
                PermissionxDefaultDialogLayoutBinding permissionxDefaultDialogLayoutBinding3 = this.binding;
                if (permissionxDefaultDialogLayoutBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    permissionxDefaultDialogLayoutBinding = permissionxDefaultDialogLayoutBinding3;
                }
                permissionxDefaultDialogLayoutBinding.permissionsLayout.addView(permissionxPermissionItemBindingInflate.getRoot());
                if (str != null) {
                    str2 = str;
                }
                hashSet.add(str2);
            }
        }
    }

    private final void setupWindow() {
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        if (i < getContext().getResources().getDisplayMetrics().heightPixels) {
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                window.setGravity(17);
                attributes.width = (int) (i * 0.86d);
                window.setAttributes(attributes);
                return;
            }
            return;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            WindowManager.LayoutParams attributes2 = window2.getAttributes();
            window2.setGravity(17);
            attributes2.width = (int) (i * 0.6d);
            window2.setAttributes(attributes2);
        }
    }

    private final boolean isDarkTheme() {
        return (getContext().getResources().getConfiguration().uiMode & 48) == 32;
    }
}
