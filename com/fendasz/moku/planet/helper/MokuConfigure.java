package com.fendasz.moku.planet.helper;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.baidu.mobads.container.adrequest.g;
import com.dhylive.app.utils.JumpParam;
import com.fendasz.moku.planet.BuildConfig;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.entity.PhoneInfo;
import com.fendasz.moku.planet.entity.UserDeviceInfo;
import com.fendasz.moku.planet.utils.GetInfoUtil;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.MoniterUtil;
import com.fendasz.moku.planet.utils.OSUtil;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.PhoneInfoUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StorageManagerUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.thirdparty.baidu.util.DeviceId;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuConfigure {
    private static final String TAG = "MokuConfigure";
    private static MokuConfigure sMokuConfigure;
    private MokuOptions mMokuOptions;
    private PhoneInfo mPhoneInfo;
    private UserDeviceInfo userDeviceInfo;

    private MokuConfigure() {
    }

    public static MokuConfigure getInstance() {
        if (sMokuConfigure == null) {
            sMokuConfigure = new MokuConfigure();
        }
        return sMokuConfigure;
    }

    public PhoneInfo getPhoneInfo(Context context) {
        if (this.mPhoneInfo == null) {
            PhoneInfo phoneInfo = new PhoneInfo();
            this.mPhoneInfo = phoneInfo;
            initPhoneInfo(context, phoneInfo);
        }
        return this.mPhoneInfo;
    }

    public UserDeviceInfo getUserDeviceInfo(Context context) throws NoSuchMethodException, SecurityException {
        if (this.userDeviceInfo == null) {
            UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
            this.userDeviceInfo = userDeviceInfo;
            initUserDeviceInfo(context, userDeviceInfo);
        }
        return this.userDeviceInfo;
    }

    private void initPhoneInfo(Context context, PhoneInfo phoneInfo) {
        String str = TAG;
        LogUtils.log(str, "initPhoneInfo");
        MokuOptions mokuOptions = getMokuOptions(context);
        phoneInfo.setSdkAppUserId(mokuOptions.getString(JumpParam.USER_ID, ""));
        phoneInfo.setAppId(mokuOptions.getString("appId", ""));
        phoneInfo.setAppSecret(mokuOptions.getString("appSecret", ""));
        PhoneInfoUtils phoneInfoUtils = PhoneInfoUtils.getInstance();
        phoneInfo.setAndroidVersion(phoneInfoUtils.getAndroidVersion());
        phoneInfo.setMobileBrandName(phoneInfoUtils.getMobileBrandName());
        phoneInfo.setMobileBrandModel(phoneInfoUtils.getMobileBrandModel());
        phoneInfo.setLocation("location");
        phoneInfo.setVersionCode(15);
        phoneInfo.setVersionName(BuildConfig.VERSION_NAME);
        phoneInfo.setDeviceId(phoneInfoUtils.getDeviceId(context));
        phoneInfo.setAndroidId(phoneInfoUtils.getAndroidId(context));
        phoneInfo.setMobileOperators(phoneInfoUtils.getPhoneUseMobileType(context));
        phoneInfo.setMobileNetwork(phoneInfoUtils.getNetType(context));
        phoneInfo.setIp(phoneInfoUtils.getLocalIpAddress(context));
        String string = mokuOptions.getString("oaid", "");
        phoneInfo.setOaid(string);
        String string2 = mokuOptions.getString(g.z, "");
        if (!TextUtils.isEmpty(string2)) {
            phoneInfo.setImei(string2);
        } else {
            phoneInfo.setImei(string);
        }
        String string3 = mokuOptions.getString(g.A, "");
        if (!TextUtils.isEmpty(string3)) {
            phoneInfo.setImei2(string3);
        }
        String phoneImsiNum = phoneInfoUtils.getPhoneImsiNum(context);
        if (!TextUtils.isEmpty(phoneImsiNum)) {
            phoneInfo.setImsi(phoneImsiNum);
        } else {
            phoneInfo.setImsi(string);
        }
        LogUtils.log(str, "PhoneInfo >> " + JSON.toJSONString(phoneInfo));
    }

    private void initUserDeviceInfo(Context context, UserDeviceInfo userDeviceInfo) throws NoSuchMethodException, SecurityException {
        String imei2;
        MokuOptions mokuOptions = getMokuOptions(context);
        PhoneInfoUtils phoneInfoUtils = PhoneInfoUtils.getInstance();
        userDeviceInfo.setDeviceId(DeviceId.getDeviceID(context));
        userDeviceInfo.setImei1(PhoneInfoUtils.getInstance().getPhoneImeiNum(context));
        if (Build.VERSION.SDK_INT >= 21 && PermissionUtils.isGranted(context, "android.permission.READ_PHONE_STATE") && (imei2 = PhoneInfoUtils.getInstance().getImei2(context)) != null && !StringUtils.isEmpty(imei2)) {
            userDeviceInfo.setImei2(imei2);
        }
        userDeviceInfo.setOaid(mokuOptions.getString("oaid", ""));
        userDeviceInfo.setImsi(phoneInfoUtils.getPhoneImsiNum(context));
        String str = TAG;
        Log.d(str, "initUserDeviceInfo_time1=>" + System.currentTimeMillis());
        userDeviceInfo.setAndroidVersion(phoneInfoUtils.getAndroidVersion());
        userDeviceInfo.setOperatingSystem(OSUtil.getCustomOS(OSUtil.getBrandName()));
        userDeviceInfo.setMobileBrandName(phoneInfoUtils.getMobileBrandName());
        userDeviceInfo.setMobileBrandType(phoneInfoUtils.getMobileBrandModel());
        userDeviceInfo.setMobileOperators(phoneInfoUtils.getPhoneUseMobileType(context));
        userDeviceInfo.setMobileNetwork(phoneInfoUtils.getNetType(context));
        userDeviceInfo.setIp(phoneInfoUtils.getLocalIpAddress(context));
        userDeviceInfo.setBaseband(Integer.valueOf(GetInfoUtil.getBasebandInfo()));
        Map<String, String> mapReceiverBatteryOhterInfo = GetInfoUtil.receiverBatteryOhterInfo(context);
        userDeviceInfo.setVoltage(mapReceiverBatteryOhterInfo.get("voltage"));
        userDeviceInfo.setCurrentCapacity(mapReceiverBatteryOhterInfo.get("level"));
        userDeviceInfo.setTemperature(mapReceiverBatteryOhterInfo.get("temperature"));
        Map<String, String> blockSize = StorageManagerUtils.getBlockSize(context);
        if (blockSize != null && !blockSize.isEmpty()) {
            userDeviceInfo.setTotalDisk(blockSize.get("totalSpace"));
            userDeviceInfo.setRemainDisk(blockSize.get("freeSpace"));
        }
        userDeviceInfo.setIsRooted(Integer.valueOf(GetInfoUtil.hasRootPrivilege()));
        userDeviceInfo.setIsDevmode(Integer.valueOf(GetInfoUtil.isOpenDevelopmentSetting(context)));
        userDeviceInfo.setCpuArchitecture(GetInfoUtil.getCpuSchemaName());
        userDeviceInfo.setCpuCurrentFreq(GetInfoUtil.getCpuCurrentFreq());
        userDeviceInfo.setCpuMinFreq(GetInfoUtil.getCpuMinFreq());
        userDeviceInfo.setWifiFreq(GetInfoUtil.getWifiFreq(context));
        userDeviceInfo.setResolution(GetInfoUtil.getPixels(context));
        userDeviceInfo.setHaveWechat(Integer.valueOf(GetInfoUtil.isWeixinAvilible(context)));
        userDeviceInfo.setHaveAlipay(Integer.valueOf(GetInfoUtil.isAliPayInstalled(context)));
        userDeviceInfo.setTotalCapacity(GetInfoUtil.getBatteryCapacity(context));
        userDeviceInfo.setSerialNum(GetInfoUtil.getSerialNum());
        userDeviceInfo.setAccessibleMode(Integer.valueOf(GetInfoUtil.getAccessibilityModel(context)));
        Map<String, String> currentTime = GetInfoUtil.getCurrentTime();
        userDeviceInfo.setElapsedRealtime(currentTime.get("elapsedRealtime"));
        userDeviceInfo.setUptimeMillis(currentTime.get("uptimeMillis"));
        userDeviceInfo.setStartupTime(GetInfoUtil.getStartupTime());
        LogUtils.longLogD(str, "device init=>" + JSON.toJSONString(userDeviceInfo));
    }

    void setMokuOptions(Context context, MokuOptions mokuOptions) {
        this.mMokuOptions = mokuOptions;
        SharedPreferencesUtils.getInstance(context).putObject(context.getString(R.string.moku_sp_moku_options), mokuOptions);
        PhoneInfo phoneInfo = new PhoneInfo();
        this.mPhoneInfo = phoneInfo;
        initPhoneInfo(context, phoneInfo);
    }

    public MokuOptions getMokuOptions(Context context) {
        if (this.mMokuOptions == null) {
            this.mMokuOptions = getMokuOptionsFromSp(context);
        }
        if (this.mMokuOptions == null) {
            this.mMokuOptions = new MokuOptions();
        }
        return this.mMokuOptions;
    }

    private MokuOptions getMokuOptionsFromSp(Context context) {
        return (MokuOptions) SharedPreferencesUtils.getInstance(context).getObject(context.getString(R.string.moku_sp_moku_options), MokuOptions.class);
    }

    public void updateOptical(Context context, String str) throws NoSuchMethodException, SecurityException {
        if (this.userDeviceInfo == null) {
            UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
            this.userDeviceInfo = userDeviceInfo;
            initUserDeviceInfo(context, userDeviceInfo);
        }
        this.userDeviceInfo.setOptical(str);
    }

    public void updateLocation(Context context, String str, String str2) throws NoSuchMethodException, SecurityException {
        if (this.userDeviceInfo == null) {
            UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
            this.userDeviceInfo = userDeviceInfo;
            initUserDeviceInfo(context, userDeviceInfo);
        }
        BigDecimal scale = new BigDecimal(str).setScale(6, 5);
        BigDecimal scale2 = new BigDecimal(str2).setScale(6, 5);
        this.userDeviceInfo.setLongitude(scale);
        this.userDeviceInfo.setLatitude(scale2);
    }

    public void updateUserType(Context context, int i) throws NoSuchMethodException, SecurityException {
        if (this.userDeviceInfo == null) {
            UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
            this.userDeviceInfo = userDeviceInfo;
            initUserDeviceInfo(context, userDeviceInfo);
        }
        this.userDeviceInfo.setTrigger(Integer.valueOf(i));
    }

    public void updateSubmitTaskDataId(Context context, Integer num) throws NoSuchMethodException, SecurityException {
        if (this.userDeviceInfo == null) {
            UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
            this.userDeviceInfo = userDeviceInfo;
            initUserDeviceInfo(context, userDeviceInfo);
        }
        this.userDeviceInfo.setTaskDataId(num);
    }

    public void updateApkFileInfo(Context context, int i, boolean z, boolean z2, boolean z3) throws NoSuchMethodException, SecurityException {
        if (this.userDeviceInfo == null) {
            UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
            this.userDeviceInfo = userDeviceInfo;
            initUserDeviceInfo(context, userDeviceInfo);
        }
        this.userDeviceInfo.setQqPackageExist(Integer.valueOf(i));
        this.userDeviceInfo.setWechatPackageExist(booleanToInt(z));
        this.userDeviceInfo.setAppShopFileCreate(booleanToInt(z2));
        this.userDeviceInfo.setAppShopFileVisit(booleanToInt(z3));
    }

    public void updateOaid(Context context, String str) throws NoSuchMethodException, SecurityException {
        if (this.userDeviceInfo == null) {
            UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
            this.userDeviceInfo = userDeviceInfo;
            initUserDeviceInfo(context, userDeviceInfo);
        }
        this.userDeviceInfo.setOaid(str);
    }

    public void refreshSectionUserDeviceInfo(Context context) throws NoSuchMethodException, SecurityException {
        if (this.userDeviceInfo == null) {
            UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
            this.userDeviceInfo = userDeviceInfo;
            initUserDeviceInfo(context, userDeviceInfo);
        } else {
            Map<String, String> mapReceiverBatteryOhterInfo = GetInfoUtil.receiverBatteryOhterInfo(context);
            this.userDeviceInfo.setVoltage(mapReceiverBatteryOhterInfo.get("voltage"));
            this.userDeviceInfo.setCurrentCapacity(mapReceiverBatteryOhterInfo.get("level"));
            this.userDeviceInfo.setTemperature(mapReceiverBatteryOhterInfo.get("temperature"));
            this.userDeviceInfo.setWifiFreq(GetInfoUtil.getWifiFreq(context));
            Map<String, String> blockSize = StorageManagerUtils.getBlockSize(context);
            if (blockSize != null && !blockSize.isEmpty()) {
                this.userDeviceInfo.setTotalDisk(blockSize.get("totalSpace"));
                this.userDeviceInfo.setRemainDisk(blockSize.get("freeSpace"));
            }
            this.userDeviceInfo.setSerialNum(GetInfoUtil.getSerialNum());
            Map<String, String> currentTime = GetInfoUtil.getCurrentTime();
            this.userDeviceInfo.setElapsedRealtime(currentTime.get("elapsedRealtime"));
            this.userDeviceInfo.setUptimeMillis(currentTime.get("uptimeMillis"));
            this.userDeviceInfo.setStartupTime(GetInfoUtil.getStartupTime());
            this.userDeviceInfo.setIp(PhoneInfoUtils.getInstance().getLocalIpAddress(context));
            this.userDeviceInfo.setIsRooted(Integer.valueOf(GetInfoUtil.hasRootPrivilege()));
        }
        MoniterUtil moniterUtil = MoniterUtil.getInstance();
        this.userDeviceInfo.setGenemytion(booleanToInt(moniterUtil.hasGenemytion()));
        this.userDeviceInfo.setQemuPipeline(booleanToInt(moniterUtil.hasQEMUPipes()));
        this.userDeviceInfo.setQemuFile(booleanToInt(moniterUtil.hasQEMUPipes()));
        this.userDeviceInfo.setQemuDrive(booleanToInt(moniterUtil.hasQEMUPipes()));
        this.userDeviceInfo.setDebugger(booleanToInt(moniterUtil.isBeingDebugged()));
        this.userDeviceInfo.setScript(Boolean.valueOf(moniterUtil.isUserAMonkey()));
        this.userDeviceInfo.setIsDevmode(Integer.valueOf(GetInfoUtil.isOpenDevelopmentSetting(context)));
        this.userDeviceInfo.setAccessibleMode(Integer.valueOf(GetInfoUtil.getAccessibilityModel(context)));
        try {
            this.userDeviceInfo.setAdb(booleanToInt(MoniterUtil.getInstance().hasAdbInEmulator()));
            this.userDeviceInfo.setTracerPid(Integer.valueOf(moniterUtil.hasTracerPid()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogUtils.longLogD(TAG, "device init=>" + JSON.toJSONString(this.userDeviceInfo));
    }

    public void setBaseStationInfo(Context context, String str) throws NoSuchMethodException, SecurityException {
        if (this.userDeviceInfo == null) {
            UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
            this.userDeviceInfo = userDeviceInfo;
            initUserDeviceInfo(context, userDeviceInfo);
        }
        this.userDeviceInfo.setBaseStationInfo(str);
    }

    private Integer booleanToInt(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
