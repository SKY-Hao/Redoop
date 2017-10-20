package com.redoop.modules.admin.license.utils;


import org.apache.xerces.impl.dv.util.Base64;

/**
 * 说明：对字符串加密
 * 包名：cn.itweet.modules.admin.license.utils
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/16.
 */
public class DESUtils {
    /*
	 * 对信息加密
	 */
    public static String encryption(String message) {
        message = stringToBase64(message);
        char[] messageCode = message.toCharArray();
        for(int i = 0; i < messageCode.length; i++){
            messageCode[i] = (char)(messageCode[i] ^ 'T'^'g');
        }
        String code = stringToBase64(new String(messageCode));
        StringBuilder sb = new StringBuilder(code);
        for(int i=4;i<code.length();i+=4){
            sb.insert(i, "-");
        }
        return sb.toString();
    }

    /*
     * 把加密的信息Base64
     */
    private static String stringToBase64(String encryptionCode){
        return Base64.encode(encryptionCode.getBytes());

    }


    /*
	 * 对信息解密
	 */
    public static String decrypt(String encryptionCode) throws Exception {
        encryptionCode = encryptionCode.replace("-", "");

        encryptionCode = base64ToString(encryptionCode);
        char[] messageCode = encryptionCode.toCharArray();

        for (int i = 0; i < messageCode.length; i++) {
            messageCode[i] = (char) (messageCode[i] ^ 'g' ^ 'T');
        }
        return base64ToString(new String(messageCode));
    }

    /*
     * 对base64信息解密
     */
    private static String base64ToString(String base64Code) throws Exception {
        return new String(Base64.decode(base64Code));
    }
}
