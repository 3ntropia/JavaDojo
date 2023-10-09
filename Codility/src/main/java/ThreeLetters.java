/**
 *

 Write a function solution that, given two integers A and B, returns a string containing exactly A letters 'a' and exactly B letters 'b' with no three consecutive letters being the same (in other words, neither "aaa" nor "bbb" may occur in the returned string).

 Examples:

 1. Given A = 5 and B = 3, your function may return "aabaabab". Note that "abaabbaa" would also be a correct answer. Your function may return any correct answer.

 2. Given A = 3 and B = 3, your function should return "ababab", "aababb", "abaabb" or any of several other strings.

 3. Given A = 1 and B = 4, your function should return "bbabb", which is the only correct answer in this case.

 Assume that:

 A and B are integers within the range [0..100];
 at least one solution exists for the given A and B.

 In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

 */
public class ThreeLetters {


    public static String solution(int A, int B) {
        // Implement your solution here
        int max = A+B;
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<max; i++){
            boolean forceA = false;
            int len = stringBuilder.length();
            if(A>=B){
                forceA = true;
            }else if(len >= 2 && stringBuilder.charAt(len - 1) == stringBuilder.charAt(len - 2)){
                if(stringBuilder.charAt(len - 1) == 'b'){
                    forceA = true;
                }
            }

            if(forceA){
                stringBuilder.append("a");
                A--;
            }else{
                stringBuilder.append("b");
                B--;
            }
        }
        return stringBuilder.toString();
    }

    public static String chatGPT(int A, int B){
        StringBuilder result = new StringBuilder();
        while (A > 0 || B > 0) {
            boolean writeA = false;
            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == result.charAt(len - 2)) {
                if (result.charAt(len - 1) == 'b') {
                    writeA = true;
                }
            } else {
                if (A >= B) {
                    writeA = true;
                }
            }

            if (writeA) {
                if (A > 0) {
                    result.append('a');
                    A--;
                } else {
                    return "";
                }
            } else {
                if (B > 0) {
                    result.append('b');
                    B--;
                } else {
                    return "";
                }
            }
        }
        return result.toString();
    }

}
