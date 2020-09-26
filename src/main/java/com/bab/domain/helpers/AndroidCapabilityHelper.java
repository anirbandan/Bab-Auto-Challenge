package com.bab.domain.helpers;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidCapabilityHelper {

    public static DesiredCapabilities getDesiredCapability() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"device");
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60");
        capabilities.setCapability(MobileCapabilityType.APP,"src/test/resources/apps/app-debug.apk");
        return capabilities;
    }
}
