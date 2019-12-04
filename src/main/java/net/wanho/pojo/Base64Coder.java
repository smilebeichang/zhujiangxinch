package net.wanho.pojo;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * Created by songb on 2019/10/7.
 */
public class Base64Coder {
    public static String key = "LmMGStGtOpF4xNyvYt54EQ==";
    protected static final Logger log = Logger.getLogger(Base64Coder.class);

    public Base64Coder() {
    }


}

