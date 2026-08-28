class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.isEmpty()) {
            return "Neither";
        }

        if (isValidIPv4(queryIP)) {
            return "IPv4";
        }
        
        if (isValidIPv6(queryIP)) {
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isValidIPv4(String ip) {
        
        String[] tokens = ip.split("\\.", -1);
        if (tokens.length != 4) {
            return false;
        }

        for (String token : tokens) {
            if (token.length() < 1 || token.length() > 3) {
                return false;
            }

            if (token.length() > 1 && token.charAt(0) == '0') {
                return false;
            }

           
            int value = 0;
            for (char c : token.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
                value = value * 10 + (c - '0');
            }

            if (value < 0 || value > 255) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidIPv6(String ip) {
        String[] tokens = ip.split(":", -1);
        if (tokens.length != 8) {
            return false;
        }

        for (String token : tokens) {
           
            if (token.length() < 1 || token.length() > 4) {
                return false;
            }

            
            for (char c : token.toCharArray()) {
                boolean isDigit = c >= '0' && c <= '9';
                boolean isUpperHex = c >= 'A' && c <= 'F';
                boolean isLowerHex = c >= 'a' && c <= 'f';

                if (!isDigit && !isUpperHex && !isLowerHex) {
                    return false;
                }
            }
        }

        return true;
    }
}