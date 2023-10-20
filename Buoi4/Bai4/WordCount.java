import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class WordCount {
    String word;
    int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public boolean equals(Object o) {
        if (o instanceof WordCount) {
            WordCount wc = (WordCount) o;
            return wc.word.equals(this.word);
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleArrayList<WordCount> wordList = new SimpleArrayList<>();
        // hoặc: SimpleLinkedList<WordCount> wordList = new SimpleLinkedList<>();

        String filename = "input.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String token = st.nextToken().toLowerCase();
                    WordCount wc = new WordCount(token, 1);
                    boolean exist = wordList.isContain(wc);
                    int i = 0;
                    if (exist == true) {
                        WordCount existingWC = wordList.get(i++);
                        existingWC.count++;
                    } else {
                        wordList.add(wc);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (WordCount wc : wordList) {
            System.out.println(wc.word + ": " + wc.count);
        }
    }
}
