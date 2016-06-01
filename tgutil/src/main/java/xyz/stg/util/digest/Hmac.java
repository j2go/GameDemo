package xyz.stg.util.digest;

import xyz.stg.util.common.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shitiangao on 16/6/1.
 */
public class Hmac {
    final static String hmacMD5 = "HmacMD5";
    private static final String hmacSHA1 = "HmacSHA1";
    private static final String hmacSHA256 = "HmacSHA256";
    private static final String hmacSHA384 = "HmacSHA384";
    private static final String hmacSHA512 = "HmacSHA512";

    /**
     * 根据给定密钥生成算法创建密钥
     *
     * @param algorithm 密钥算法
     * @return 密钥
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    private static SecretKey getHmacKey(String algorithm) throws NoSuchAlgorithmException {
        //初始化KeyGenerator
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);

        return keyGenerator.generateKey();
    }

    /**
     * 获取 HmaMD5的密钥
     *
     * @return HmaMD5的密钥
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    public static SecretKey getHmaMD5key() throws NoSuchAlgorithmException {
        return getHmacKey(hmacMD5);
    }

    /**
     * 获取 HmaSHA的密钥
     *
     * @return HmaSHA的密钥
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    public static SecretKey getHmaSHAkey() throws NoSuchAlgorithmException {
        return getHmacKey(hmacSHA1);
    }

    /**
     * 获取 HmaSHA256的密钥
     *
     * @return HmaSHA256的密钥
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    public static SecretKey getHmaSHA256key() throws NoSuchAlgorithmException {
        return getHmacKey(hmacSHA256);
    }

    /**
     * 获取 HmaSHA384的密钥
     *
     * @return HmaSHA384的密钥
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    public static SecretKey getHmaSHA384key() throws NoSuchAlgorithmException {
        return getHmacKey(hmacSHA384);
    }

    /**
     * 获取 HmaSHA512的密钥
     *
     * @return HmaSHA384的密钥
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    public static SecretKey getHmaSHA512key() throws NoSuchAlgorithmException {
        return getHmacKey(hmacSHA512);
    }

    /**
     * 转换密钥
     *
     * @param key       二进制密钥
     * @param algorithm 密钥算法
     * @return 密钥
     */
    private static Key toKey(byte[] key, String algorithm) {
        //生成密钥
        return new SecretKeySpec(key, algorithm);
    }

    /**
     * 使用HmacMD5消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacMD5(byte[] data, Key key) throws InvalidKeyException, NoSuchAlgorithmException {
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);

        return mac.doFinal(data);
    }

    /**
     * 使用HmacMD5消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacMD5(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {
        Key k = toKey(key, "HmacMD5");
        return encodeHmacMD5(data, k);
    }

    /**
     * 使用HmacSHA消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacSHA(byte[] data, Key key) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(hmacSHA1);
        mac.init(key);

        return mac.doFinal(data);
    }

    /**
     * 使用HmacSHA消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacSHA(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException {
        Key k = toKey(key, hmacSHA1);
        return encodeHmacSHA(data, k);
    }

    /**
     * 使用HmacSHA256消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacSHA256(byte[] data, Key key) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        return mac.doFinal(data);
    }

    /**
     * 使用HmacSHA256消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacSHA256(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException {
        Key k = toKey(key, "HmacSHA256");
        return encodeHmacSHA256(data, k);
    }


    /**
     * 使用HmacSHA384消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacSHA384(byte[] data, Key key) {
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA384");
            mac.init(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return new byte[0];
        }
        return mac.doFinal(data);
    }

    /**
     * 使用HmacSHA384消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacSHA384(byte[] data, byte[] key) {
        Key k = toKey(key, "HmacSHA384");
        return encodeHmacSHA384(data, k);
    }


    /**
     * 使用HmacSHA512消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacSHA512(byte[] data, Key key) {
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA512");
            mac.init(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return new byte[0];
        }
        return mac.doFinal(data);
    }

    /**
     * 使用HmacSHA512消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] encodeHmacSHA512(byte[] data, byte[] key) {
        Key k = toKey(key, "HmacSHA512");
        return encodeHmacSHA512(data, k);
    }

    public static void main(String[] args) {
//      byte[] key = getHmaMD5key();
//      byte[] key = getHmaSHAkey();
//      byte[] key = getHmaSHA256key();
//      byte[] key = getHmaSHA384key();
        SecretKey key = null;
        try {
            key = getHmaSHA512key();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        System.out.println("加密密钥: " + Hex.encode(key.getEncoded()));

        String data = "Mac数据";
        System.out.println("加密前数据string: " + data);
        System.out.println("加密前数据: " + Hex.encode(data.getBytes()));
        System.out.println();
//      byte[] encodeData = encodeHmacMD5(data.getBytes(), key);
//      byte[] encodeData = encodeHmacSHA(data.getBytes(), key);
//      byte[] encodeData = encodeHmacSHA256(data.getBytes(), key);
//      byte[] encodeData = encodeHmacSHA384(data.getBytes(), key);
        byte[] encodeData = encodeHmacSHA512(data.getBytes(), key);

        System.out.println("加密后数据hexStr:" + Hex.encode(encodeData));
        System.out.println();
    }
}
