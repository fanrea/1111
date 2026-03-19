package aegon.chrome.base;

import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.component.a.g.b;
import java.util.ArrayList;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class LocaleUtils {
    private LocaleUtils() {
    }

    public static String getUpdatedLanguageForChromium(String str) {
        str.hashCode();
        switch (str) {
            case "in":
                return "id";
            case "iw":
                return Config.HEADER_PART;
            case "ji":
                return "yi";
            case "tl":
                return "fil";
            default:
                return str;
        }
    }

    public static Locale getUpdatedLocaleForChromium(Locale locale) {
        String language = locale.getLanguage();
        String updatedLanguageForChromium = getUpdatedLanguageForChromium(language);
        return updatedLanguageForChromium.equals(language) ? locale : new Locale.Builder().setLocale(locale).setLanguage(updatedLanguageForChromium).build();
    }

    public static String getUpdatedLanguageForAndroid(String str) {
        str.hashCode();
        return !str.equals("fil") ? !str.equals("und") ? str : "" : "tl";
    }

    public static Locale getUpdatedLocaleForAndroid(Locale locale) {
        String language = locale.getLanguage();
        String updatedLanguageForAndroid = getUpdatedLanguageForAndroid(language);
        return updatedLanguageForAndroid.equals(language) ? locale : new Locale.Builder().setLocale(locale).setLanguage(updatedLanguageForAndroid).build();
    }

    public static Locale forLanguageTagCompat(String str) {
        String[] strArrSplit = str.split("-");
        if (strArrSplit.length == 0) {
            return new Locale("");
        }
        String updatedLanguageForAndroid = getUpdatedLanguageForAndroid(strArrSplit[0]);
        if (updatedLanguageForAndroid.length() != 2 && updatedLanguageForAndroid.length() != 3) {
            return new Locale("");
        }
        if (strArrSplit.length == 1) {
            return new Locale(updatedLanguageForAndroid);
        }
        String str2 = strArrSplit[1];
        if (str2.length() != 2 && str2.length() != 3) {
            return new Locale(updatedLanguageForAndroid);
        }
        return new Locale(updatedLanguageForAndroid, str2);
    }

    public static Locale forLanguageTag(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getUpdatedLocaleForAndroid(Locale.forLanguageTag(str));
        }
        return forLanguageTagCompat(str);
    }

    public static String toLanguageTag(Locale locale) {
        String updatedLanguageForChromium = getUpdatedLanguageForChromium(locale.getLanguage());
        String country = locale.getCountry();
        return (updatedLanguageForChromium.equals(b.t) && country.equals("NO") && locale.getVariant().equals("NY")) ? "nn-NO" : country.isEmpty() ? updatedLanguageForChromium : updatedLanguageForChromium + "-" + country;
    }

    public static String toLanguageTags(LocaleList localeList) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < localeList.size(); i++) {
            arrayList.add(toLanguageTag(getUpdatedLocaleForChromium(localeList.get(i))));
        }
        return TextUtils.join(",", arrayList);
    }

    public static String toLanguage(String str) {
        int iIndexOf = str.indexOf(45);
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
    }

    public static String getDefaultLocaleString() {
        return toLanguageTag(Locale.getDefault());
    }

    public static String getDefaultLocaleListString() {
        if (Build.VERSION.SDK_INT >= 24) {
            return toLanguageTags(LocaleList.getDefault());
        }
        return getDefaultLocaleString();
    }

    private static String getDefaultCountryCode() {
        CommandLine commandLine = CommandLine.getInstance();
        if (commandLine.hasSwitch(BaseSwitches.DEFAULT_COUNTRY_CODE_AT_INSTALL)) {
            return commandLine.getSwitchValue(BaseSwitches.DEFAULT_COUNTRY_CODE_AT_INSTALL);
        }
        return Locale.getDefault().getCountry();
    }
}
