public class WordPlay {
    /**
     * This method isVowel that has one Char parameter named ch. This method returns true
     * if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise.
     * You should write a tester method to see if this method works correctly. For example, isVowel(‘F’)
     * should return false,and isVowel(‘a’) should return true.
     *
     * @param ch
     * @return
     */

   public boolean isVowel(char ch){
        ch=Character.toUpperCase(ch);

        if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return true;
        }
        return false;
    }

    /**
     * This  method replaceVowels that has two parameters, a String named phrase and a Char named ch.
     * This method should return a String that is the string phrase with all the vowels (uppercase or lowercase)
     * replaced by ch. For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”.
     * Be sure to call the method isVowel that you wrote and also test this method.
     * @param phrase
     * @param ch
     * @return
     */

    public String replaceVowels(String phrase,char ch){
        StringBuilder givenPhrase=new StringBuilder(phrase);
        for(int i=0;i<givenPhrase.length();i++){
            if(isVowel(givenPhrase.charAt(i))){
                givenPhrase.setCharAt(i,ch);
            }
        }
        return givenPhrase.toString();
    }
    /**
     * Write a method emphasize with two parameters, a String named phrase and a character named ch.
     * This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by
     * ‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or
     * ‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).
     * @param phrase
     * @param ch
     * @return
     */

    public String emphasize(String phrase,char ch){
        StringBuilder sb =new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            if(Character.toUpperCase(phrase.charAt(i))==ch || Character.toLowerCase(phrase.charAt(i))==ch ) {
                if (i % 2 == 0) {
                    sb.setCharAt(i, '*');
                } else if (i % 2 == 1) {
                    sb.setCharAt(i, '+');
                }
            }
        }
        return sb.toString();


    }

    /**
     * this method tests the two methods
     */
    void testIsVowel() {
        char ch = 'I';
        if (isVowel(ch)) {
            System.out.println("Given Character " + ch + " is a Vowel");
        } else {
            System.out.println("Given Character  " + ch + " is not a Vowel");
        }
    }

    /**
     * this method tests the Replacevowels method with no parameter
     */
       void testReplaceVowels() {

           String phrase = "madhu sudhan";
           char ch = '*';
           String sb = replaceVowels(phrase, ch);
           System.out.println("The vowels in the string " + phrase + " is Replaced with " + ch + " and the replacement string is " + sb);
       }

    /**
     * this method tests the Emphasize method
     */
    void testEmphasized(){
        String phrase="dna ctgaaactga";
        char ch='a';
        System.out.println("The emphasized String of "+phrase+"with char "+ch+" is "+emphasize(phrase,ch));
    }

    /**
     * this method is used to call all the test methods
     */
    void tester(){
        testIsVowel();
        testReplaceVowels();
        testEmphasized();
    }
    public static void main(String args[]){

        WordPlay Wp=new WordPlay();
        Wp.tester();

    }




}
