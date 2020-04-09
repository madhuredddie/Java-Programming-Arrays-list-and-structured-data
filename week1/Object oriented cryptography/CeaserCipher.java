public class CeaserCipher
    {

        private String alphabet;
        private String shiftedAlphabet;
        private int mainKey;

        /**
         * This is constructor which takes key as parameter
         * @param key
         */
    public CeaserCipher(int key){
         mainKey=key;
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        mainKey=key;
    }

        /**
         *  This is encrypt method that has one String parameter named input.
         *  This method returns a String that is the input encrypted using shiftedAlphabet.
         * @param input
         * @return
         */

        public String encrypt(String input){
            StringBuilder sb= new StringBuilder(input);
            char currentchar,tempchar;
            for(int i=0;i<sb.length();i++)
            {
                currentchar=sb.charAt(i);
                tempchar=Character.toUpperCase(currentchar);
                int index= alphabet.indexOf(tempchar);
                if(index!=-1) {
                    if(Character.isLowerCase(currentchar))
                    {
                        sb.setCharAt(i,Character.toLowerCase(shiftedAlphabet.charAt(index)));
                    }
                    else
                    {
                        sb.setCharAt(i,shiftedAlphabet.charAt(index));
                    }
                }

            }
            return sb.toString();
    }
        /**
         * This is a decrypt method that has one String parameter named input. This method returns a String that is the
         * encrypted String decrypted using the key associated with this CaesarCipher object.
         * One way to do this is to create another private field mainKey, which is initialized to be the value of key.
         * @param encrypted
         * @return
         */

        public String decrypt(String encrypted){
        CeaserCipher cc=new CeaserCipher(26-mainKey);
        String decrypted=cc.encrypt(encrypted);

        return decrypted;
    }
    public  void testEncrypt(){
        String s="At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println(" the string "+s+" with key value "+mainKey+" using ceaser cipher  algorithm is "+encrypt(s));
        s="FIRST LEGION ATTACK EAST FLANK";
        System.out.println(" the string "+s+" with key value "+mainKey+" using ceaser cipher  algorithm is "+encrypt(s));
    }
     public void testdecryprt()
     {
       String s="Xq kllk yb fk qeb zlkcbobkzb ollj tfqe vlro exq lk clo x promofpb mxoqv. VBII ILRA!";
      System.out.println( " the decrypted text of "+s+" is "+decrypt(s));
     }

        public static void main(String args[]){

        CeaserCipher cc=new CeaserCipher(23);
        cc.testEncrypt();
        cc.testdecryprt();


    }


    }
