import java.util.ArrayList;
import edu.duke.FileResource;
public class CharacterInPlay {
    private ArrayList<String> myWords;
    private  ArrayList<Integer>  myFreqs;

    /**
     * this is constructor of CharacterInPlay which intializes the Arraylist myWords and myFreqs
     */
    public CharacterInPlay(){
        myWords= new ArrayList<String>();
        myFreqs= new ArrayList<Integer>();

    }
    /**
     * Write a void method called findAllCharacters that opens a file, and reads the file line-by-line.
     * For each line, if there is a period on the line, extract the possible name of the speaking part,
     * and call update to count it as an occurrence for this person. Make sure you clear the appropriate
     * instance variables before each new file.
     */
    void findAllCharacters() {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();

        for (String line : fr.lines()) {
            int indexOfPeriod = line.indexOf('.');
            if (indexOfPeriod != -1) {
                update(line.substring(0, indexOfPeriod));
            }
        }
    }
    /**
     * Write a void method named update that has one String parameter named person. This method should update the two ArrayLists,
     * adding the character’s name if it is not already there, and counting this line as one speaking part for this person.
     * @param person
     */
   public void update(String person) {
        int index = myWords.indexOf(person);
        if (index == -1)
        {
            myWords.add(person);
            myFreqs.add(1);
        } else
            {
            int value = myFreqs.get(index);
            myFreqs.set(index, value + 1);
        }
    }

    /**
     * Write a void method called charactersWithNumParts that has two int parameters named num1 and num2,
     * where you can assume num1 should be less than or equal to num2. This method should print out the names of all those characters
     * that have exactly number speaking parts, where number is greater than or equal to num1 and less than or equal to num2.
     * Add code in tester to test this method out.
     * @param num1
     * @param num2
     */
     public void charactersWithNumParts(int num1,int num2){

        for(int i=0;i<myFreqs.size();i++){
            if(myFreqs.get(i)>num1 && myFreqs.get(i)<=num2){
                System.out.println(myWords.get(i) + ":" + myFreqs.get(i));
            }
        }

    }

    /**
     * Write a void method called tester that has no parameters. This method should call findAllCharacters, and then for each main character,
     * print out the main character, followed by the number of speaking parts that character has.
     * A main character is one who has more speaking parts than most people. You’ll have to estimate what that number should be.
     */
   public  void tester() {
        findAllCharacters();
        System.out.println("The following are the characters in given play with number of times they are being played");
        for (int i = 0; i < myWords.size(); i++) {
            System.out.println(myWords.get(i) + ":" + myFreqs.get(i));
        }
        int num1=1;
        int num2=4;
        System.out.println("Characters are with minimum of "+num1+" times and maximum of "+num2+" played in a play");
        charactersWithNumParts(1,10);
    }
    public static void main(String [] args)
    {
        CharacterInPlay CIP= new CharacterInPlay();
        CIP.tester();
    }
}
