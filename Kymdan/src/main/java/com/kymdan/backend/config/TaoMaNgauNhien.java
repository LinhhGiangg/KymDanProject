package com.kymdan.backend.config;

import java.util.Random;

public class TaoMaNgauNhien {
    private static Random taoMa = new Random();
//    private static final String chuThuong = "abcdefghijklmnopqrstuvwxyz";
//    private static final String chuHoa = chuThuong.toUpperCase();
    private static final String daySo = "0123456789";
//    private static final String dayKiTu = chuThuong + chuHoa + daySo;

    public static String tao(int soLuongKiTu) {
        StringBuilder ma = new StringBuilder();
        for (int i = 0; i < soLuongKiTu; i++) {
            int so = soNgauNhien(0, daySo.length() - 1);
            char kiTu = daySo.charAt(so);
            ma.append(kiTu);
        }
        return ma.toString();
    }

    public static int soNgauNhien(int min, int max) {
        return taoMa.nextInt((max - min) + 1) + min;
    }
}
