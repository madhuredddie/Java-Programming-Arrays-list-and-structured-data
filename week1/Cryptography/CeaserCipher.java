import java.lang.StringBuilder;
public class CeaserCipher
{
    /**
     * Write the method encrypt that has two parameters, a String named input and an int named key.
     * This method returns a String that has been encrypted using the Caesar Cipher algorithm.
     * @param input
     * @param key
     * @return
     */
   public String encyrpt(String input ,int key)
   {
       key=key%26;
       StringBuilder sb= new StringBuilder(input);
       char currentchar,tempchar;
       String originalCharacter="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String Shiftedcharcters=originalCharacter.substring(key)+originalCharacter.substring(0,key);
       for(int i=0;i<sb.length();i++)
       {
           currentchar=sb.charAt(i);
           tempchar=Character.toUpperCase(currentchar);
           int index= originalCharacter.indexOf(tempchar);
           if(index!=-1) {
                 if(Character.isLowerCase(currentchar))
                 {
                     sb.setCharAt(i,Character.toLowerCase(Shiftedcharcters.charAt(index)));
                 }
                 else
                 {
                     sb.setCharAt(i,Shiftedcharcters.charAt(index));
                 }
           }

       }
       return sb.toString();
   }

    /**
     * Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2.
     * This method returns a String that has been encrypted using the following algorithm.
     * Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm,
     * starting with the first character, and key2 is used to encrypt every other character, starting with the second character.
     * For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”.
     * Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17,
     * @param input
     * @param key1
     * @param key2
     * @return
     */
   public String encyrptTwoKeys(String input,int key1,int key2)
   {
       String ecryptedstring = " ";
       for(int i=0;i<input.length();i++)
       {
       if(i%2==0) {
           String s = Character.toString(input.charAt(i));
           ecryptedstring = ecryptedstring + encyrpt(s, key1);
       }
       else {
           String s = Character.toString(input.charAt(i));
           ecryptedstring = ecryptedstring + encyrpt(s, key2);
       }
       }
       return ecryptedstring;
   }

    /**
     * this method tests the encrypt method
     */
   public void testEncrypt()
   {
       String s="At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
       int key=15;
       System.out.println(" the string "+s+" with key value "+key+" using ceaser cipher  algorithm is "+encyrpt(s,key));
       s="FIRST LEGION ATTACK EAST FLANK";
       key=23;
       System.out.println(" the string "+s+" with key value "+key+" using ceaser cipher  algorithm is "+encyrpt(s,key));
   }
    /**
     * this method tests the encryptTwoKeys method
     */
   public void testEncryptTwoKeys()
   {
       String s="At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
       int key1=8;
       int key2= 21;
       System.out.println(" the string "+s+" with key values "+key1+"," +key2+" using two encrypt  algorithm is "+encyrptTwoKeys(s,key1,key2));
       s="First Legion";
        key1=23;
        key2= 17;
       System.out.println(" the string "+s+" with key values "+key1+"," +key2+" using two encrypt  algorithm is "+encyrptTwoKeys(s,key1,key2));

   }
   public  void tester()
    {
         testEncrypt();
         testEncryptTwoKeys();
    }

   public static void main(String[] args)
   {
       CeaserCipher cc= new CeaserCipher();
      cc.tester();
      return ;
   }
}
