package androidx.camera.core.impl;

import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface Config {

    public interface OptionMatcher {
        boolean onOptionMatched(Option<?> option);
    }

    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        REQUIRED,
        OPTIONAL
    }

    boolean containsOption(Option<?> option);

    void findOptions(String str, OptionMatcher optionMatcher);

    OptionPriority getOptionPriority(Option<?> option);

    Set<OptionPriority> getPriorities(Option<?> option);

    Set<Option<?>> listOptions();

    <ValueT> ValueT retrieveOption(Option<ValueT> option);

    <ValueT> ValueT retrieveOption(Option<ValueT> option, ValueT valuet);

    <ValueT> ValueT retrieveOptionWithPriority(Option<ValueT> option, OptionPriority optionPriority);

    public static abstract class Option<T> {
        public abstract String getId();

        public abstract Object getToken();

        public abstract Class<T> getValueClass();

        Option() {
        }

        public static <T> Option<T> create(String str, Class<?> cls) {
            return create(str, cls, null);
        }

        public static <T> Option<T> create(String str, Class<?> cls, Object obj) {
            return new AutoValue_Config_Option(str, cls, obj);
        }
    }

    static boolean hasConflict(OptionPriority optionPriority, OptionPriority optionPriority2) {
        if (optionPriority == OptionPriority.ALWAYS_OVERRIDE && optionPriority2 == OptionPriority.ALWAYS_OVERRIDE) {
            return true;
        }
        return optionPriority == OptionPriority.REQUIRED && optionPriority2 == OptionPriority.REQUIRED;
    }

    static Config mergeConfigs(Config config, Config config2) {
        MutableOptionsBundle mutableOptionsBundleCreate;
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        if (config2 != null) {
            mutableOptionsBundleCreate = MutableOptionsBundle.from(config2);
        } else {
            mutableOptionsBundleCreate = MutableOptionsBundle.create();
        }
        if (config != null) {
            for (Option<?> option : config.listOptions()) {
                mutableOptionsBundleCreate.insertOption(option, config.getOptionPriority(option), config.retrieveOption(option));
            }
        }
        return OptionsBundle.from(mutableOptionsBundleCreate);
    }
}
