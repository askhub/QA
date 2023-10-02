package aero.s7.jl.autotest.common;

public enum DriverType {
        CHROME("webDriver.chrome.driver", "../resources/chromedriver.exe"),
        FIREFOX("webDriver.firefox.driver", "../resources/geckodriver.exe");

        public final String key;
        public final String value;

        DriverType (String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
