package part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class StringLengthSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}

//class ReverseIterator<T> implements Iterator {
//    public boolean hasNext() {
//        return true;
//    }
//
//    public T next() {
//        return null;
//    }
//}

class Reversed<T> implements Iterable<T> {
    private final List<T> list;

    public Reversed(List<T> list) {
        this.list = list;
    }

    public Iterator<T> iterator() {
        final ListIterator<T> i = list.listIterator(list.size());

        return new Iterator<>() {
            public boolean hasNext() {
                return i.hasPrevious();
            }

            public T next() {
                return i.previous();
            }

            public void remove() {
                i.remove();
            }
        };
    }

    public static <T> Reversed<T> reversed(List<T> list) {
        return new Reversed<>(list);
    }
}

public class Text {

    static String fileName = "D:/WEB/Sberbank-Java-School/HW2/text.txt";

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private static List<String> convertTextToWordsList(String text) {
        text = text.toLowerCase().replace("\r\n", " ");
        return Arrays.asList(text.split(" "));
    }

    private static List<String> convertTextToStringsList(String text) {
        return Arrays.asList(text.split("\r\n"));
    }

    private static void countUniqueWords(List<String> wordsList) {
        Map<String, Integer> wordsCountMap = new HashMap<>();
        for (String word : wordsList) {
            if (wordsCountMap.containsKey(word)) {
                Integer count = wordsCountMap.get(word);
                count = ++count;
                wordsCountMap.put(word, count);
            } else {
                wordsCountMap.put(word, 1);
            }
        }
        System.out.println("Количество различных слов в файле:");
        System.out.println(wordsCountMap.size());
        System.out.println("Сколько раз каждое слово встречается в файле:");
        wordsCountMap.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    private static void sortByLengthAndName(List<String> wordsList) {
        Comparator<String> stringLengthSort = new StringLengthSort();
        Set<String> wordsSet = new TreeSet<>(stringLengthSort);
        wordsSet.addAll(wordsList);
        for (String word : wordsSet) {
            System.out.println(word);
        }
    }

    private static void getStringsByNumber(List<String> stringsList, Integer[] stringsNumbers) {
        for (Integer num : stringsNumbers) {
            if (num < stringsList.size() + 1 ) {
                System.out.println(stringsList.get(num - 1));
            } else {
                throw new IllegalArgumentException("Нет строки с таким номером");
            }
        }
    }

    public static void main(String[] args) {
        try {
            String contents = readUsingFiles(fileName);
            List<String> wordsList = convertTextToWordsList(contents);
            List<String> stringsList = convertTextToStringsList(contents);
            sortByLengthAndName(wordsList);
            countUniqueWords(wordsList);

            for (int i = stringsList.size() - 1; i >= 0; i--) {
                System.out.println(stringsList.get(i));
            }
            for (String word : Reversed.reversed(wordsList)) {
                System.out.println(word);
            }
            Integer[] stringsNumbers = {10, 1 , 5, 11};
            getStringsByNumber(stringsList, stringsNumbers);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
