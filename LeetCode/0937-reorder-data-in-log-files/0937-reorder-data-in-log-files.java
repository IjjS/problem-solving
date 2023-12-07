class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
        String[] firstLog = s1.split(" ", 2);
        String[] secondLog = s2.split(" ", 2);
        boolean isFirstLetter = Character.isLetter(firstLog[1].charAt(0));
        boolean isSecondLetter = Character.isLetter(secondLog[1].charAt(0));

        if (isFirstLetter && !isSecondLetter)
            return -1;
        if (!isFirstLetter && isSecondLetter)
            return 1;
        if (!isFirstLetter)
            return 0;

        int cntCmp = firstLog[1].compareTo(secondLog[1]);
        
        return cntCmp == 0 ? firstLog[0].compareTo(secondLog[0]) : cntCmp;
    });
        return logs;
    }
}