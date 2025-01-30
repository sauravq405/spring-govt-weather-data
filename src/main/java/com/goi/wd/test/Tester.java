package com.goi.wd.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Tester {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("city.imd.gov.in");
            System.out.println("DNS resolved to: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Failed to resolve host: " + e.getMessage());
        }
    }
}
