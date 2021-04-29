import java.util.*;


public enum Task1Impl implements IStringRowsListSorter{
    INSTANCE;

    @Override
    public void sort(List<String[]> rows, int columnIndex) {
        if (rows==null){
            throw new IllegalArgumentException("rows is null");
        }
        if (rows.size()==1||rows.isEmpty()){
            throw new IllegalArgumentException("nothing to sort");
        }
        boolean everyRowValid = rows.stream()
                .allMatch(arr->arr!=null&&arr.length>=columnIndex);
        if (!everyRowValid) {
            throw new IllegalArgumentException("one of the rows null or short of column index");
        }
        try {
            sort0(rows, columnIndex);
        }catch (UnsupportedOperationException ex){
            throw new IllegalArgumentException("list is immutable");
        }
    }

    private void sort0(List<String[]> rows, int columnIndex){
        rows.sort((row1, row2) -> {
            String str1 = row1[columnIndex];
            String str2 = row2[columnIndex];
            Integer nullsAndBlanks = checkNullsAndBlanks(str1, str2);
            return nullsAndBlanks == null
                    ? mainCompare(str1, str2)
                    : nullsAndBlanks;
        });
    }

    private Integer checkNullsAndBlanks(String str1, String str2) {
        if (str1 == null && str2 == null) return 0;
        if (str1 == null) return -1;
        if (str2 == null) return 1;
        if (str1.isBlank() && str2.isBlank()) return 0;
        if (str1.isBlank()) return -1;
        if (str2.isBlank()) return 1;
        return null;
    }

    private Integer mainCompare(String str1,String str2){
        if (StringUtils.allStrIsNumbers(str1,str2)) {
            int i1 = Integer.parseInt(str1);
            int i2 = Integer.parseInt(str2);
            if (i2==i1)return 0;
            return i1 > i2 ? 1 : -1;
        }else{
            List<String> str1Fragments = splitDifferentTypesOfChar(str1);
            List<String> str2Fragments = splitDifferentTypesOfChar(str2);
            int smallestFragmentsArrSize = Math.min(str1Fragments.size(),str2Fragments.size());
            for (int i = 0; i < smallestFragmentsArrSize; i++) {
                String str1Fragment = str1Fragments.get(i);
                String str2Fragment = str2Fragments.get(i);
                if (str1Fragment.equals(str2Fragment))continue;
                return tryCompareIntOrCompareString(str1Fragment, str2Fragment);
            }
            if (str1Fragments.size()==str2Fragments.size())return 0;
            return str1Fragments.size() > str2Fragments.size() ? 1 : -1;
        }
    }

    private int tryCompareIntOrCompareString(String str1, String str2) {
        if (StringUtils.allStrIsNumbers(str1, str2)) {
            int i1 = Integer.parseInt(str1);
            int i2 = Integer.parseInt(str2);
            if (i2==i1)return 0;
            return i1 > i2 ? 1 : -1;
        }else {
            return str1.compareTo(str2);
        }
    }

    private List<String> splitDifferentTypesOfChar(String str){
        List<String> fragments = new ArrayList<>();
        int lastSplitIndex = 0;
        for (int i = 0; i < str.length()-1; i++) {
            int ipp = 1 + i;
            char char1 = str.charAt(i);
            char char2 = str.charAt(ipp);
            if (Character.getType(char1)!=Character.getType(char2)){
                fragments.add(str.substring(lastSplitIndex, ipp));
                lastSplitIndex = ipp;
            }
        }
        fragments.add(str.substring(lastSplitIndex));
        return fragments;
    }

}
