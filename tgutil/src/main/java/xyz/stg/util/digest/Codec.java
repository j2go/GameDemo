package xyz.stg.util.digest;

import xyz.stg.util.common.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shitiangao on 16/6/1.
 */
public class Codec {
    /**
     * 获取 MD5 消息摘要实例
     *
     * @return MD5 消息摘要实例
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    private static MessageDigest getMd5Digest() throws NoSuchAlgorithmException {
        return  MessageDigest.getInstance("MD5");
    }

    /**
     * 获取 SHA-1 消息摘要实例
     *
     * @return SHA-1 消息摘要实例
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    private static MessageDigest getShaDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA");
    }

    /**
     * 获取 SHA-256 消息摘要实例
     *
     * @return SHA-256 消息摘要实例
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    private static MessageDigest getSha256Digest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256");
    }

    /**
     * 获取 SHA-384 消息摘要实例
     *
     * @return SHA-384 消息摘要实例
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    private static MessageDigest getSha384Digest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-384");
    }

    /**
     * 获取 SHA-512 消息摘要实例
     *
     * @return SHA-512 消息摘要实例
     * @throws RuntimeException 当 {@link java.security.NoSuchAlgorithmException} 发生时
     */
    private static MessageDigest getSha512Digest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-512");
    }

    /**
     * 使用MD5消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return 消息摘要（长度为16的字节数组）
     */
    public static byte[] md5(byte[] data) throws NoSuchAlgorithmException {
        return getMd5Digest().digest(data);
    }

    /**
     * 使用MD5消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return 消息摘要（长度为32的十六进制字符串）
     */
    public static String md5ToHex(byte[] data) throws NoSuchAlgorithmException {
        return Hex.encode(md5(data));
    }

    /**
     * 使用SHA-1消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return SHA-1消息摘要（长度为20的字节数组）
     */
    public static byte[] sha1(byte[] data) throws NoSuchAlgorithmException {
        return getShaDigest().digest(data);
    }

    /**
     * 使用SHA-1消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return SHA-1消息摘要（长度为40的十六进制字符串）
     */
    public static String shaToHex(byte[] data) throws NoSuchAlgorithmException {
        return Hex.encode(getShaDigest().digest(data));
    }

    /**
     * 使用SHA-256消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return SHA-256消息摘要（长度为32的字节数组）
     */
    public static byte[] sha256(byte[] data) throws NoSuchAlgorithmException {
        return getSha256Digest().digest(data);
    }

    /**
     * 使用SHA-256消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return SHA-256消息摘要（长度为64的十六进制字符串）
     */
    public static String sha256ToHex(byte[] data) throws NoSuchAlgorithmException {
        return Hex.encode(sha256(data));
    }

    /**
     * 使用SHA-384消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return SHA-384消息摘要（长度为43的字节数组）
     */
    public static byte[] sha384(byte[] data) throws NoSuchAlgorithmException {
        return getSha384Digest().digest(data);
    }

    /**
     * 使用SHA-384消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return SHA-384消息摘要（长度为86的十六进制字符串）
     */
    public static String sha384ToHex(byte[] data) throws NoSuchAlgorithmException {
        return Hex.encode(sha384(data));
    }

    /**
     * 使用SHA-512消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return SHA-512消息摘要（长度为64的字节数组）
     */
    public static byte[] sha512(byte[] data) throws NoSuchAlgorithmException {
        return getSha512Digest().digest(data);
    }

    /**
     * 使用SHA-512消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @return SHA-512消息摘要（长度为128的十六进制字符串）
     */
    public static String sha512ToHex(byte[] data) throws NoSuchAlgorithmException {
        return Hex.encode(sha512(data));
    }

}
