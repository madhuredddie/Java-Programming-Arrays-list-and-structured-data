public class CeaserBreaker {
    /**
     * This method calculates number of occurences of each character in the string encrypted and
     * stores them in an array.
     * @param encrypted
     * @return
     */

    int[] countLetters(String encrypted){

        int[] counts=new int[26];
        String alpha="abcdefghijklmnopqrstuvwxyz";
        String tempEncrypted=encrypted.toLowerCase();

        for(int i=0;i<encrypted.length();i++){

            int index=alpha.indexOf(tempEncrypted.charAt(i));
            if(index!=-1){
                counts[index]++;
            }
        }
        return counts;
    }

    /**
     * This method returns the index that has maximum value of occurences of alpahbhets of string in the array counts.
     *
     * @param counts
     * @return
     */
    int indexOfMax(int[] counts){

        int maximumValue = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > counts[maximumValue]) {
                maximumValue = i;
            }
        }
        return maximumValue;
    }

    /**
     * Complete the decryption method shown in the lesson by creating a CaesarBreaker class with the methods
     * countLetters, maxIndex, and decrypt. Recall that the decrypt method
     * creates a CaesarCipher object in order to use the encrypt method you wrote for the last lesson.
     * @param encrpyted
     * @return
     */

    String decrypt(String encrpyted){
        CeaserCipher cc=new CeaserCipher();
        int[] counts=countLetters(encrpyted);
        int maxIndex=indexOfMax(counts);
        int dKey=maxIndex-4;
        if(maxIndex<4) {
            dKey = 26 - (4 - maxIndex);
        }
            return cc.encyrpt(encrpyted,26-dKey);

    }



    /**
     * This  method halfOfString in the CaesarBreaker class that has two parameters, a String parameter named message and an int parameter named start.
     * This method should return a new String that is every other character from message starting with the start position.
     * For example, the call halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1)
     * returns the String “bmZi”. Be sure to test this method with a small example.
     * @param message
     * @param start
     * @return
     */

   public  String  halfOfString(String message,int start){

        String newString="";
        while(start<message.length()){

            newString=newString+message.charAt(start);
            start+=2;
        }
        return newString;

    }

    /**
     * this method getMaxindex in the CaesarBreaker class that has one parameter, a String s. This method should
     * call countLetters to get an array of the letter frequencies in String s and then use maxIndex to calculate
     * the index of the largest letter frequency, which is the location of the encrypted letter ‘e’, which leads to the key,
     * which is returned.
     *
     * @param s
     * @return
     */
    int getMaxindex(String s){
        int[] counts=new int[26];

        counts=countLetters(s);

        int maxIndex=indexOfMax(counts);

        return maxIndex;
    }

    /**
     * Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter, a String parameter named encrypted
     * that represents a String that was encrypted with the two key algorithm discussed in the previous lesson. This method attempts to determine the two keys
     * used to encrypt the message, prints the two keys, and then returns the decrypted String with those two keys.
     *
     * @param encrypted
     * @return
     */

   public String decryptTwoKeys(String encrypted){

        CeaserCipher cc=new CeaserCipher();
        String newstring1=halfOfString(encrypted,0);
        String newstring2=halfOfString(encrypted,1);


        int s1MaxIndex=getMaxindex(newstring1);
        int s2MaxIndex=getMaxindex(newstring2);

        int newString1dKey=s1MaxIndex-4;
        if(s1MaxIndex<4) {
            newString1dKey = 26 - (4 - s1MaxIndex);
        }
        System.out.println(" The decryption Key1 for string  "+newstring1+" is "+newString1dKey);

        int newString2dKey=s2MaxIndex-4;
            if(s2MaxIndex<4) {
                newString2dKey = 26 - (4 - s2MaxIndex);
            }
        System.out.println(" The dcryption  Key2 for "+newstring2+" is "+newString2dKey);
        return cc.encyrptTwoKeys(encrypted,26-newString1dKey,26-newString2dKey);

    }

    /**
     * Write a testDecrypt method in the CaesarBreaker class that prints the decrypted message,
     * and make sure it works for encrypted messages that were encrypted with one key.
     */
    void testDecrypt() {
        String encrpyted = "Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!";

        System.out.println("Decrypted Message for String " + encrpyted + " is " + decrypt(encrpyted));
      }

    /**
     * This method tests the halfstring method
     */
    public void testHalfStrings() {
       String s = "Qbkm Zgis";
       System.out.println("half string of string " + s + " with start position 0 is" + halfOfString(s, 0));
       System.out.println("half string of string " + s + " with start position 1 is" + halfOfString(s, 1));
   }
    /**
     * This method tests the DecryptTwokeys method
     */
       public void testDecryptTwoKeys(){
           String s="Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        System.out.println("The decrypted message for message  "+s+" is " +decryptTwoKeys(s)); }

        public void tester()
        {
            testHalfStrings();
            testDecrypt();
            testDecryptTwoKeys();
        }
    public  static void main(String args[]){

        CeaserBreaker CB=new CeaserBreaker();
        CB.tester();
    }
}
