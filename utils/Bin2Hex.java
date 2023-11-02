package utils;

public class Bin2Hex {
    public String bin2hex(String bin) {
        String hex = "";
        int len = bin.length();
        int i = 0;
        while (i < len) {
            String bin8 = bin.substring(i, i + 8);
            int dec = Integer.parseInt(bin8, 2);
            String hex8 = Integer.toHexString(dec);
            hex += hex8;
            i += 8;
        }
        return hex;
    }
}
