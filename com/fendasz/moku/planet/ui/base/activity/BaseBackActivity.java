package com.fendasz.moku.planet.ui.base.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alipay.sdk.m.u.i;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.PhoneInfo;
import com.fendasz.moku.planet.helper.AliyunHelper;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.observer.DirectoryObserver;
import com.fendasz.moku.planet.source.bean.AlipayConfigData;
import com.fendasz.moku.planet.source.bean.BaiduConfigData;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.utils.BDUtil;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.google.gson.Gson;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class BaseBackActivity extends BaseActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 10010;
    private static final int NOT_NOTICE = 10086;
    private static String[] PERMISSIONS_LOCATION = {"android.permission.ACCESS_FINE_LOCATION", g.h};
    private static final int REQUEST_CODE_LOCATION_SERVICE = 10011;
    private static final String TAG = "Moku_Base_A=>";
    private CustomBuildDialog customBuildDialog;
    private TreeMap<String, DirectoryObserver> directoryObserverMap;
    private LocationListener locationListener = new LocationListener() { // from class: com.fendasz.moku.planet.ui.base.activity.BaseBackActivity.4
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) throws NoSuchMethodException, SecurityException {
            Log.d(BaseBackActivity.TAG, "LocationListener_onLocationChanged");
            BaseBackActivity.this.locationResult(1, location);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            LogUtils.logD(BaseBackActivity.TAG, "LocationListener_onProviderEnabled:" + str);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            LogUtils.logD(BaseBackActivity.TAG, "LocationListener_onProviderDisabled:" + str);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            LogUtils.logD(BaseBackActivity.TAG, "LocationListener_onStatusChanged:" + str);
        }
    };

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView) {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitleCenterLayout(RelativeLayout relativeLayout) {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.base.activity.BaseBackActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseBackActivity.this.finish();
            }
        });
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.customBuildDialog = new CustomBuildDialog.DialogBuilder(this).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("为方便更好的完成任务，还须开启定位权限，谢谢配合").setRightBtn(getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.base.activity.BaseBackActivity.2
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                customBuildDialog.dismiss();
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", BaseBackActivity.this.getPackageName(), null));
                BaseBackActivity.this.startActivityForResult(intent, 10086);
            }
        }).setCancelable(false).create();
        initBdconfig();
        if (AliyunHelper.getInstance().needGetKey()) {
            getAliyunKey();
        }
    }

    public Integer queryLocationInfo() throws NoSuchMethodException, SecurityException {
        LocationManager locationManager = (LocationManager) getSystemService("location");
        if (locationManager == null) {
            locationResult(2, null);
            return 2;
        }
        boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
        boolean zIsProviderEnabled2 = locationManager.isProviderEnabled(PointCategory.NETWORK);
        if (!zIsProviderEnabled && !zIsProviderEnabled2) {
            locationResult(3, null);
            return 3;
        }
        if (!PermissionUtils.hasLocationPermissions(this)) {
            locationResult(4, null);
            requetLocationPermission();
            return 4;
        }
        Location lastKnownLocation = getLastKnownLocation(this);
        if (lastKnownLocation != null && lastKnownLocation.getLongitude() > 0.0d && lastKnownLocation.getLatitude() > 0.0d) {
            locationResult(1, lastKnownLocation);
            return 1;
        }
        if (zIsProviderEnabled) {
            locationManager.requestLocationUpdates("gps", 5000L, 10.0f, this.locationListener);
        } else {
            locationManager.requestLocationUpdates(PointCategory.NETWORK, 5000L, 10.0f, this.locationListener);
        }
        return 1;
    }

    private Location getLastKnownLocation(Context context) {
        LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
        Iterator<String> it = locationManager.getProviders(true).iterator();
        Location location = null;
        while (it.hasNext()) {
            Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
            if (lastKnownLocation != null && (location == null || lastKnownLocation.getAccuracy() < location.getAccuracy())) {
                location = lastKnownLocation;
            }
        }
        return location;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) throws NoSuchMethodException, SecurityException {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (10010 == i) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (iArr[i2] == 0) {
                    queryLocationInfo();
                } else if (!ActivityCompat.shouldShowRequestPermissionRationale(this, strArr[i2])) {
                    shouldShowLocationDialog();
                } else {
                    shouldShowLocationDialog();
                }
            }
        }
    }

    public void locationResult(int i, Location location) throws NoSuchMethodException, SecurityException {
        LogUtils.logI(TAG, "locationResult_code:" + i);
        if (i == 1 && location != null) {
            LogUtils.logI(TAG, "location result success");
            LogUtils.logD(TAG, "locationResult_code:" + i + ",location:" + new Gson().toJson(location));
            PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(this);
            LogUtils.log(TAG, "location_longitude==> " + location.getLongitude());
            LogUtils.log(TAG, "location_latit==> " + location.getLatitude());
            phoneInfo.setLocation(location.getLongitude() + i.b + location.getLatitude());
            MokuConfigure.getInstance().updateLocation(this, String.valueOf(location.getLongitude()), String.valueOf(location.getLatitude()));
            return;
        }
        LogUtils.logI(TAG, "location result error");
        if (3 == i) {
            LogUtils.logD(TAG, "no location service");
            CustomBuildDialog.DialogBuilder dialogBuilder = new CustomBuildDialog.DialogBuilder(this);
            dialogBuilder.setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("请开启定位服务，感谢配合").setCancelable(false);
            dialogBuilder.setRightBtn(getApplication().getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.base.activity.BaseBackActivity.3
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    BaseBackActivity.this.requestLocationService();
                }
            });
            dialogBuilder.create().show();
        }
    }

    protected void requestLocationService() {
        startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 10011);
    }

    private void requetLocationPermission() throws NoSuchMethodException, SecurityException {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 || ActivityCompat.checkSelfPermission(this, g.h) != 0) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_LOCATION, 10010);
        } else {
            queryLocationInfo();
        }
    }

    private void shouldShowLocationDialog() {
        CustomBuildDialog customBuildDialog = this.customBuildDialog;
        if (customBuildDialog == null || customBuildDialog.isShowing()) {
            return;
        }
        this.customBuildDialog.show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.locationListener != null) {
            LogUtils.logD(TAG, "onStop,remove locationListener");
            ((LocationManager) getSystemService("location")).removeUpdates(this.locationListener);
        }
    }

    private void initBdconfig() {
        ApiDataHelper.getApiDataHelper().bdConfig(this, new ApiDataCallBack<BaiduConfigData>() { // from class: com.fendasz.moku.planet.ui.base.activity.BaseBackActivity.5
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, BaiduConfigData baiduConfigData) throws Exception {
                Log.d(BaseBackActivity.TAG, "initBdconfig success");
                BDUtil.getInstance().putConfig(BaseBackActivity.this, baiduConfigData);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                Log.d(BaseBackActivity.TAG, "initBdconfig error,msg:" + str);
                BDUtil.getInstance().setUnable(BaseBackActivity.this);
            }
        });
    }

    private void getAliyunKey() {
        Log.d(TAG, "getAliyunKey start");
        ApiDataHelper.getApiDataHelper().alipayKey(this, new ApiDataCallBack<AlipayConfigData>() { // from class: com.fendasz.moku.planet.ui.base.activity.BaseBackActivity.6
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, AlipayConfigData alipayConfigData) throws Exception {
                LogUtils.logD(BaseBackActivity.TAG, "get aliyun success");
                AliyunHelper.getInstance().init(0, null);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logD(BaseBackActivity.TAG, "get aliyun error,code:" + i + ",message:" + str);
                AliyunHelper.getInstance().init(Integer.valueOf(i), str);
            }
        });
    }
}
