public class Solution {
    public int strStr(String haystack, String needle) {
        // Handle edge cases
        if (needle.isEmpty()) {
            return 0;
        }
        int lenH = haystack.length();
        int lenN = needle.length();
        if (lenN > lenH) {
            return -1;
        }

        // Hash parameters
        int base = 256; // Base for hashing (ASCII character set size)
        long M = 1000000007L; // Large prime modulus
        long h = 1; // Precompute base^(lenN-1) for rolling hash
        for (int i = 0; i < lenN - 1; i++) {
            h = (h * base) % M;
        }

        // Compute hash value of needle
        long hashNeedle = 0;
        for (int i = 0; i < lenN; i++) {
            hashNeedle = (hashNeedle * base + needle.charAt(i)) % M;
        }

        // Compute hash value of the first window of haystack
        long hashHay = 0;
        for (int i = 0; i < lenN; i++) {
            hashHay = (hashHay * base + haystack.charAt(i)) % M;
        }

        // Check the first window
        if (hashHay == hashNeedle && haystack.substring(0, lenN).equals(needle)) {
            return 0;
        }

        // Slide the window over haystack
        for (int i = 0; i < lenH - lenN; i++) {
            // Update hashHay for the next window: haystack[i+1:i+1+lenN]
            // Step 1: Subtract the contribution of the outgoing character
            hashHay = (hashHay - (haystack.charAt(i) * h) % M + M) % M;
            // Step 2: Shift left by multiplying by base
            hashHay = (hashHay * base) % M;
            // Step 3: Add the contribution of the incoming character
            hashHay = (hashHay + haystack.charAt(i + lenN)) % M;

            // Check if hashes match, then verify with string comparison
            if (hashHay == hashNeedle) {
                if (haystack.substring(i + 1, i + 1 + lenN).equals(needle)) {
                    return i + 1;
                }
            }
        }

        // No match found
        return -1;
    }

    // Test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "hello";
        String needle = "ll";
        int result = solution.strStr(haystack, needle);
        System.out.println("Index: " + result); // Expected output: 2

        haystack = "aaaaa";
        needle = "bba";
        result = solution.strStr(haystack, needle);
        System.out.println("Index: " + result); // Expected output: -1
    }
}