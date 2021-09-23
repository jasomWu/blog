package com.example.utils;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author sunwu
 * @since 2021-09-23-22:01
 */
public class MD5Util {
    /**
     * 通过md5加密技术进行密码
     *
     * @param resource 输入需要加密的字符串
     * @return 返回一个加密好的字符串
     */
    public static String md5(String resource) {
        // 判断resouce是否是空串，是就直接抛出异常
        if (resource == null || resource.length() == 0) {
            throw new RuntimeException("字符串不能为空！");
        }
        String algorithm = "md5";
        // resource不是空串
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            // 获取字节数组
            byte[] bytes = resource.getBytes();
            // 执行加密
            byte[] digest = messageDigest.digest(bytes);
            // 将执行结果放入BigInteger里面
            // 1表示正數存入
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, digest);
            // 按16进制将BigInteger的数据转化为String
            int radix = 16;
            String encode = bigInteger.toString(radix).toUpperCase();
            return encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


}
