import java.util.*;

public class Main {


    public static void main(String[] args) {

//        String path = "DUUUUDDDDDUUUUDDD";
//        int steps = 17;
//
//        int currentLevel = 0;
//        int valleysTraversed = 0;

//        for(int i = 0; i < steps; i++){
//            char currentStep = path.charAt(i);
//            if(currentStep == 'D'){
//                if(currentLevel == 0){
//                    valleysTraversed++;
//                }
//                currentLevel--;
//            }
//
//            if(path.charAt(i) == 'U'){
//                currentLevel++;
//            }
//        }
//        System.out.println(valleysTraversed);

//        String s = "a";
//        String initialS = s;
////        String s = "abaabaabaa";
//        long n = 1000000000000l;
//        int count = 0;
//
//
//        while (s.toCharArray().length != n){
//            if (s.toCharArray().length < n){
//                s = s+initialS;
//            } else if (s.toCharArray().length > n){
//                s = s.substring(0, s.length() - 1);
//            } else {
//                break;
//            }
//
//        }
//
//        for(int i = 0; i < n; i++) {
//
//            if (s.toCharArray()[i] == 'a') {
//                count++;
//            }
//        }
//
//        System.out.println(count);

//        List<Integer> q = new ArrayList<>();
//        q.add(5);
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(7);
//        q.add(8);
//        q.add(6);
//        q.add(4);
//
//        int i =q.size();
//        int swapCounter=0;
//        while(i>0){
//            if(q.get(i-1)==i){
//                i--;
//                continue;
//            }else if(q.get(i-2)==i){
//                Collections.swap(q,i-2,i-1);
//                swapCounter++;
//            }else if(q.get(i-3)==i){
//                Collections.swap(q,i-3,i-2);
//                swapCounter++;
//                Collections.swap(q,i-2,i-1);
//                swapCounter++;
//            }else{
//                System.out.println("Too chaotic");
//                break;
//            }
//            i--;
//        }
//        if(i==0){
//            System.out.println(swapCounter);
//        }

//        List<String> magazine = new ArrayList<>();
//        magazine.add("two");
//        magazine.add("times");
//        magazine.add("three");
//        magazine.add("is");
//        magazine.add("not");
//        magazine.add("four");
//        List<String> note = new ArrayList<>();
//        note.add("two");
//        note.add("times");
//        note.add("two");
//        note.add("is");
//        note.add("four");
//
//        boolean canCompleteNote = true;
//        for(String currentWord : note){
//            if(magazine.contains(currentWord)){
//                magazine.remove(currentWord);
//                continue;
//            } else {
//                System.out.print("No");
//                canCompleteNote = false;
//                break;
//            }
//
//        }
//
//        if(canCompleteNote)
//            System.out.print("Yes");

//        String s1 = "hello";
//        String s2 = "world";
//
//        String stringToLoop;
//        String stringToCheck;
//        if(s1.length() >= s2.length()){
//            stringToLoop = s1;
//            stringToCheck = s2;
//        } else {
//            stringToLoop = s2;
//            stringToCheck = s1;
//        }
//
//        for(char currentChar : stringToLoop.toCharArray()){
//            if(stringToCheck.indexOf(currentChar) != -1){
//                System.out.println("Yes");
//                return;
//            }
//        }
//
//        System.out.println("No");

//        Map<Character, Boolean> mp = new HashMap<>();
//
//        for (int i = s1.length(); i > 0 ; i--) {
//            s1.indexOf(i);
//        }
//
//        for(char currentChar : s1.toCharArray()){
//            mp.put(currentChar, true);
//        }
//
//        for (char currentChar : s2.toCharArray()){
//            if (mp.get(currentChar) != null)
//                return "YES";
//        }
//
//        return "NO";

//        String a = "Hi my name is andre";
//        String reverse = "";
//        for (int i = a.length()-1; i >= 0; i--) {
//            reverse = reverse + a.charAt(i);
//        }

//        for (int i = 1; i < a.length()+1; i++) {
//            reverse = reverse + a.charAt(a.length()-i);
//        }

//        System.out.println(reverse);

//        int[] arr1 = new int[]{ 0,3,4,31};
//        int[] arr2 = new int[]{ 4,6,30};
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//
//        for(Integer i : arr1){
//            arrayList.add(i);
//        }
//
//        for(Integer i : arr2){
//            arrayList.add(i);
//        }
//
//        Collections.sort(arrayList);
//
//        System.out.println(arrayList);

//        int[] nums = new int[]{ 2,7,11,15};
//        int target = 9;
////
////        int[] returnIntArray;
////        ArrayList<Integer> arrayList = new ArrayList<>();
////
////        for(int i = 0; i < nums.length; i++){
////            arrayList.add(nums[i]);
////        }
//
////        if(nums==null || nums.length<2)
////            return new int[]{0,0};
//
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int i=0; i<nums.length; i++){
//            if(map.containsKey(nums[i])){
//                return new int[]{map.get(nums[i]), i};
//            }else{
//                map.put(target-nums[i], i);
//            }
//        }
//        return new int[]{0,0};

//        int[] nums = new int[]{ 2,7,11,2,11,15};
//        Map<Integer, Integer> indexAtMap = new HashMap<>();
//
//        for (Integer currentInt : nums){
//            System.out.println(nums.);
//        }

//        sherlockAndAnagrams("ifailuhkqq");


//        System.out.println(twoSum());


//        HashMap<Integer, Integer> numsMap = new HashMap<>();
//        int[] nums = new int[]{numsMap.get(target - nums[i]), i}
//
//        for(int i = 0; i < nums.length i++){
//            numsMap.put(nums[i], i);
//        }
//
//        for(int i = 0; i < nums.lenght; i++){
//
//            if(numsMap.get(target - nums[i]) != -1){
//                return new int[]{numsMap.get(target - nums[i]), i};
//            }
//
//        }



    }

//    public int[] twoSum(int[] nums, int target) {
//
//
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i+1; j < nums.length; j++){
//                if(nums[i] == nums[j-target]){
//                    return new int[]{j, i};
//                }
//            }
//        }
//
//    }

    public static int sherlockAndAnagrams(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j + i <= len; j++) {
                for (int k = j + 1; k + i <= len; k++) {
                    if (isAnagram(s.substring(j, j + i), s.substring(k, k + i))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static boolean isAnagram(String str1, String str2) {
        int[] flag = new int['z' + 1];
        for (int i = 0; i < str1.length(); i++) {
            flag[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char letter = str2.charAt(i);
            if (flag[letter] <= 0) {
                return false;
            }

            flag[letter]--;
        }
        return true;
    }
}
