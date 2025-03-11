import java.util.*;

class Solution {
    public int shortestMatchingSubstring(String s, String p) {
        // 1) Split p into p1, p2, p3 by the two stars
        int firstStar = p.indexOf('*');
        int secondStar = p.indexOf('*', firstStar + 1);

        String p1 = p.substring(0, firstStar);
        String p2 = p.substring(firstStar + 1, secondStar);
        String p3 = p.substring(secondStar + 1);

        // If p is just "**", return 0 (empty substring matches)
        if (p1.isEmpty() && p2.isEmpty() && p3.isEmpty()) {
            return 0;
        }

        // 2) Find all occurrences of p1, p2, p3 using KMP
        List<Integer> startsP1 = findAllOccurrencesKMP(s, p1);
        List<Integer> startsP2 = findAllOccurrencesKMP(s, p2);
        List<Integer> startsP3 = findAllOccurrencesKMP(s, p3);

        // If any non-empty part doesn't appear at all, no valid match
        if ((!p1.isEmpty() && startsP1.isEmpty())
                || (!p2.isEmpty() && startsP2.isEmpty())
                || (!p3.isEmpty() && startsP3.isEmpty())) {
            return -1;
        }

        // Sort them (they should already be sorted from the KMP approach, but just to be safe)
        Collections.sort(startsP1);
        Collections.sort(startsP2);
        Collections.sort(startsP3);

        // 3) Merge to find the minimal coverage
        int minLen = Integer.MAX_VALUE;

        // We'll keep pointers into startsP2 and startsP3
        int idxP2 = 0, idxP3 = 0;
        for (int i1 : startsP1) {
            int endP1 = i1 + p1.length(); // earliest position for p2

            // Advance idxP2 while startsP2[idxP2] < endP1
            while (idxP2 < startsP2.size() && startsP2.get(idxP2) < endP1) {
                idxP2++;
            }
            if (idxP2 == startsP2.size()) break;

            int i2 = startsP2.get(idxP2);
            if (i2 < endP1) continue; // not valid, move on

            int endP2 = i2 + p2.length(); // earliest position for p3

            // Advance idxP3 while startsP3[idxP3] < endP2
            while (idxP3 < startsP3.size() && startsP3.get(idxP3) < endP2) {
                idxP3++;
            }
            if (idxP3 == startsP3.size()) break;

            int i3 = startsP3.get(idxP3);
            if (i3 < endP2) continue;

            // We have a valid triple (i1, i2, i3)
            int endIndex = i3 + p3.length() - 1;
            int length = endIndex - i1 + 1;
            minLen = Math.min(minLen, length);
        }

        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }

    /**
     * Find all occurrences of 'pattern' in 'text' using the KMP algorithm.
     * Returns a sorted list of start indices.
     */
    private List<Integer> findAllOccurrencesKMP(String text, String pattern) {
        List<Integer> result = new ArrayList<>();

        // If pattern is empty, match "occurs" at every index from 0..text.length()
        if (pattern.isEmpty()) {
            for (int i = 0; i <= text.length(); i++) {
                result.add(i);
            }
            return result;
        }

        // 1) Build LPS (longest proper prefix-suffix) table for the pattern
        int[] lps = buildLPS(pattern);

        // 2) Scan the text with the pattern
        int i = 0; // index for text
        int j = 0; // index for pattern
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    // A match found, record the start index (i - j)
                    result.add(i - j);
                    // Continue to find next match
                    j = lps[j - 1];
                }
            } else {
                // mismatch
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    /**
     * Build the LPS array for KMP:
     * lps[k] = the longest proper prefix of pattern[0..k]
     *          which is also a suffix of pattern[0..k].
     */
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;

        // lps[0] = 0 by definition
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // mismatch
                if (len > 0) {
                    // Try the previous longest prefix
                    len = lps[len - 1];
                } else {
                    // No prefix matched
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
