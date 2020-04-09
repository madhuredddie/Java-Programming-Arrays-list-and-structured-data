import edu.duke.FileResource;


public class TestCeaserCipher {

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
     * This is void method simpleTests that has no parameters. This method should read in a file as a String,
     * create a CaesarCipher object with key 18, encrypt the String read in using the CaesarCipher object, print the encrypted String,
     * and decrypt the encrypted String using the decrypt method.
     */
   public void simpleTests(){

        FileResource fr=new FileResource();
        String message=fr.asString();

        CeaserCipher cc=new CeaserCipher (18);
        String encrypted=cc.encrypt(message);

        String decrypted = cc.decrypt(encrypted);

        System.out.println("Encrytped Message is "+encrypted);
        System.out.println("Decrypted Message is "+decrypted);

        decrypted=breakCaeserCipher(encrypted);
        System.out.println("Decrypted Message of encrypted message using Break Caeser Cipher Method:"+decrypted);
    }

    /**
     * This  the method breakCaesarCipher that has one String parameter named input.
     * This method should figure out which key was used to encrypt this message (in a similar manner as the previous lesson),
     * then create a CaesarCipher object with that key and decrypt the message.
     * In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt
     * it automatically by determining the key, and print the decrypted String.
     * @param input
     * @return
     */
   public String breakCaeserCipher(String input){
        int[] counts=countLetters(input);

        int maxIndex=indexOfMax(counts);

        int decryptKey=maxIndex-4;
        if(maxIndex<4) {
            decryptKey = 26 - (4 - maxIndex);

        }
        CeaserCipher cc=new CeaserCipher(decryptKey);
        return cc.decrypt(input);

    }

    public static void main(String args[]){


        TestCeaserCipher tcc=new TestCeaserCipher();
        tcc.simpleTests();

    }



}
