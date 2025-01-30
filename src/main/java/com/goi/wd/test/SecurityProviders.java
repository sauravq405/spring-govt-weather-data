package com.goi.wd.test;

import java.security.Security;
import java.security.Provider;

public class SecurityProviders {
    public static void main(String[] args) {
        for (Provider provider : Security.getProviders()) {
            System.out.println("Provider: " + provider.getName());
            for (String key : provider.stringPropertyNames())
                System.out.println("  " + key + ": " + provider.getProperty(key));
        }
    }
}