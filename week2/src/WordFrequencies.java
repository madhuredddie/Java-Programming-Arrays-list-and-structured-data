import java.util.ArrayList;
import edu.duke.FileResource;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        myWords=new ArrayList<String>();
        myFreqs=new ArrayList<Integer>();
    }
    /**
     * This is void method findUnique that has no parameters. This method should first clear both myWords and myFreqs, using the .clear() method.
     * Then it selects a file and then iterates over every word in the file, putting the unique words found into myWords.
     * For each word in the kth position of myWords, it puts the count of how many times that word occurs from the selected file
     * into the kth position of myFreqs, as was demonstrated in the lesson.
     */
     public void findUnique() {
        myFreqs.clear();
        myWords.clear();

        FileResource fr = new FileResource();
        for (String s : fr.words()) {
            s=s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            }
            else
            {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }

        }
    }
    /**
     * Write a void tester method that has no parameters. This method should call findUnique.
     * Then print out the number of unique words, and for each unique word, print the frequency of each word and the word
     *
     * */
     public void tester() {
        findUnique();
        System.out.println("Number of unique words in the file "+myWords.size());
        for(int i=0;i<myWords.size();i++) {

            System.out.println(myWords.get(i)+":"+myFreqs.get(i));
        }
        int maxIndex=findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "+myWords.get(maxIndex)+" "+myFreqs.get(maxIndex));

    }
    /**
     *  the method findIndexOfMax that has no parameters. This method returns an int
     * that is the index location of the largest value in myFreqs. If there is a tie, then return the first such value.
     * @return
     */
     public int findIndexOfMax(){
        int maxindex=0;
        for(int i=0;i<myFreqs.size();i++){

            if(myFreqs.get(maxindex)<myFreqs.get(i)){
                maxindex=i;
            }
        }
        return  maxindex;
    }
    public static void main(String[] args)
    {
        WordFrequencies wf= new WordFrequencies();
        wf.tester();
    }

}
