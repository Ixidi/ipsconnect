package pl.ixidi.ipsconnect.utils;

import org.apache.commons.codec.digest.DigestUtils;

public final class HashUtils {

    public static String password(String password, String salt) {
        if (salt.length() == 22) {
            return BCrypt.hashpw(password, "$2a$13$" + salt);
        } else {
            password = password.replace("&", "&amp;");
            password = password.replace("<!--", "&#60;&#33;--");
            password = password.replace("-->", "--&#62;");
            password = password.replace("<script", "&#60;script");
            password = password.replace(">", "&gt;");
            password = password.replace("<", "&lt;");
            password = password.replace("\"", "&quot;");
            password = password.replace("\n", "<br />");
            password = password.replace("$", "&#036;");
            password = password.replace("!", "&#33;");
            password = password.replace("'", "&#39;");
            password = password.replace("\\", "&#092;");
            return DigestUtils.md5Hex(DigestUtils.md5Hex(salt) + DigestUtils.md5Hex(password));
        }
    }

    private HashUtils() {}

}
