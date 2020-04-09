public class CeaserCipherTwo {


    private String alphabet;
    private String shiftedAlphabet1;
    private  String shiftedAlphabet2;
    private  int mainKey1;
    private int mainKey2;
    public CeaserCipherTwo(int key1,int key2){

        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
        mainKey1=key1;
        mainKey2=key2;

    }

    /**
     * Write an encrypt method that has one String parameter named input.
     * This method returns a String that is the input encrypted using the two shifted alphabets.
     * @param input
     * @return
     */

    public String encrypt(String input){

        String encrypted="";

        CeaserCipher c1=new CeaserCipher(mainKey1);
        CeaserCipher c2=new CeaserCipher(mainKey2);

        for(int i=0;i<input.length();i++){

            if(i%2==0){
                String s=Character.toString(input.charAt(i));
                encrypted=encrypted+c1.encrypt(s);
            }
            else{
                String s=Character.toString(input.charAt(i));
                encrypted=encrypted+c2.encrypt(s);
            }
        }
        return encrypted;
    }

    /**
     * This is  a decrypt method that has one String parameter named input. This method returns a String that is the encrypted String decrypted using the key1 and key2
     * associated with this CaesarCipherTwo object. You might want to add more private fields to the class.
     * @param encrypted
     * @return
     */

     public String decrypt(String encrypted){
        String decrypted="";
        CeaserCipher c1=new CeaserCipher(mainKey1);
        CeaserCipher c2=new CeaserCipher(mainKey2);

        for(int i=0;i<encrypted.length();i++){

            if(i%2==0){
                String s=Character.toString(encrypted.charAt(i));
                decrypted=decrypted+c1.decrypt(s);
            }
            else{
                String s=Character.toString(encrypted.charAt(i));
                decrypted=decrypted+c2.decrypt(s);
            }
        }
        return decrypted;
    }
    public static void main(String args[]) {


        CeaserCipherTwo cc = new CeaserCipherTwo(23, 17);
        String s = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encrypted=cc.encrypt(s);
        System.out.println(("Encrypted Message for string is "+s+" is" +cc.encrypt(s)));
        String decrypted = cc.decrypt(encrypted);
        System.out.println(("Decrypted Message  of string "+decrypted+ "is " + decrypted));
    }




}
