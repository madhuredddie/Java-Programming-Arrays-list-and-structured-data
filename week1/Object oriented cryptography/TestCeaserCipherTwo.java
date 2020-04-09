import edu.duke.FileResource;

public class TestCeaserCipherTwo {
    /**
     * This method calculates number of occurences of each character in the string encrypted and
     * stores them in an array.
     * @param encrypted
     * @return
     */

    public int[] countLetters(String encrypted){

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
     * This method returns the index that has maximum value of occurences in the array counts.
     *
     * @param counts
     * @return
     */
    public int indexOfMax(int[] counts){

        int maxValue = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > counts[maxValue]) {

                maxValue = i;
            }
        }
        return maxValue;
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

    public String breakCaesarCipher(String encrypted){

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
        CeaserCipherTwo cc=new CeaserCipherTwo(26-newString1dKey,26-newString2dKey);
        System.out.println(" The dcryption  Key2 for "+newstring2+" is "+newString2dKey);
        return cc.encrypt(encrypted);

    }

    /**
     * This is void method simpleTests that has no parameters. This method should read in a file as a String,
     * create a CaesarCipher object with key 18, encrypt the String read in using the CaesarCipher object, print the encrypted String,
     * and decrypt the encrypted String using the decrypt method.
     */
    public void simpleTests(){

        FileResource fr=new FileResource();
        String message=fr.asString();

        CeaserCipherTwo cc=new CeaserCipherTwo (17,3);
        String encrypted=cc.encrypt(message);

        String decrypted = cc.decrypt(encrypted);

        System.out.println("Encrytped Message is "+encrypted);
        System.out.println("Decrypted Message is "+decrypted);

        decrypted=breakCaesarCipher(encrypted);
        System.out.println("Decrypted Message of encrypted message using Break Caeser Cipher Method:"+decrypted);
    }
    public static void main(String[] args)
    {
        TestCeaserCipherTwo TT= new TestCeaserCipherTwo();
        TT.simpleTests();
    }

}
