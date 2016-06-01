package xyz.stg.util.crypto;

import xyz.stg.util.common.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shitiangao on 16/5/31.
 */
public class DES {

    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "DES";

    private static final String DEFAULT_CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    /**
     * 初始化密钥
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] initSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(56);
        //生成一个密钥
        SecretKey key = keyGenerator.generateKey();
        return key.getEncoded();
    }

    /**
     * 转换密钥
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static Key toKey(byte[] key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generateSecret(dks);
    }

    /**
     * 加密
     *
     * @param data 待加密数据
     * @param key  加密密钥
     * @return
     * @throws Exception
     */
    public static byte[] encrypto(byte[] data, Key key) throws Exception {
        return encrypto(data, key, DEFAULT_CIPHER_ALGORITHM);
    }

    /**
     * 加密
     *
     * @param data 字符串数据,待加密数据
     * @param key  字符串参数,加密密钥
     * @return
     * @throws Exception
     */
    public static byte[] encrypto(String data, String key) throws Exception {
        return encrypto(data.getBytes(), toKey(key.getBytes()), DEFAULT_CIPHER_ALGORITHM
        );
    }

    /**
     * 解密
     *
     * @param data 待解密数据
     * @param key  二进制密钥
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        return decrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }

    /**
     * 解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, Key key) throws Exception {
        return decrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }

    /**
     * 解密
     *
     * @param data            待解密数据
     * @param key             二进制密钥
     * @param cipherAlgorithm 加密算法/工作模式/填充方式
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key, String cipherAlgorithm) throws Exception {
        //还原密钥
        Key k = toKey(key);
        return decrypt(data, k, cipherAlgorithm);
    }

    /**
     * 执行加密
     *
     * @param data
     * @param key
     * @param cipherAlgorithm
     * @return
     * @throws Exception
     */
    private static byte[] encrypto(byte[] data, Key key, String cipherAlgorithm)
            throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }

    /**
     * 执行解密
     *
     * @param data
     * @param key
     * @param cipherAlgorithm
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, Key key, String cipherAlgorithm) throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }

    public static void main(String[] args) {
        String data = "exception";

        try {
            String key = Hex.encode(initSecretKey());
            System.out.print(" 密钥:");
            System.out.println(key);
            byte[] mtext = encrypto(data, key);
            System.out.println("加密后:");
            System.out.println(Hex.encode(mtext));
            System.out.println("解密后");
            byte[] res = decrypt(mtext, toKey(key.getBytes()));
            System.out.println(new String(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
