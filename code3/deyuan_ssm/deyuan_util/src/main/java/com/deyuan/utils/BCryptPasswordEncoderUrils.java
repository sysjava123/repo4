package com.deyuan.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUrils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String passwordEncoder(String password){
        return  bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String s = BCryptPasswordEncoderUrils.passwordEncoder("admin");
        //$2a$10$WuY1YWyMUKKMBgmuFF75iOLjQewD20h2mFMN3pxBDpD4tpkYwSlOm
        //$2a$10$zQP7mwdI78hcF2CH42mP.eOacfpDJgcP..WNW0MgYVU/QDmSFHs6O
        System.out.println(s);
    }
}
