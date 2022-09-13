package stream;

import logparser.model.ActionState;
import logparser.model.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApp {

    public static void main(String[] args) {

        String[] stringArray = {"apple", "orange", "banana", "grape", "pineapple"};
        long withoutApple = Arrays.stream(stringArray).filter(element -> !element.contains("apple")).count();
        System.out.println(withoutApple + " words without apple");

        int[] intArray = {1, 5, 8, 10, 15, 7, 4, 5, 15, 8};
        int[] ints = Arrays.stream(intArray).distinct().toArray();
        System.out.println(Arrays.toString(ints) + " without double numbers");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(5);
        integerList.add(7);
        integerList.add(5);
        integerList.add(3);
        integerList.add(1);
        long count = integerList.stream().filter(value -> value >= 5).count();
        System.out.println(count + " values greater or equal to 5");

        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");
        stringList.add("grape");
        stringList.add("pineapple");
        List<String> collectFruits = stringList.stream().filter(word -> word.contains("a"))
                .filter(word -> !word.contains("g"))
                .filter(word -> word.endsWith("e")).collect(Collectors.toList());
        System.out.println(collectFruits);

        Event eventOne = new Event("192.8.33.5", "netflix.com", ActionState.valueOf("OK"));
        Event eventTwo = new Event("127.3.56.1", "netflix.com", ActionState.valueOf("FAIL"));
        Event eventThree = new Event("188.8.44.2", "instagram.com", ActionState.valueOf("PAUSE"));
        Event eventFour = new Event("88.4.15.4", "ebay.de", ActionState.valueOf("OK"));
        List<Event> eventList = new ArrayList<>();
        eventList.add(eventOne);
        eventList.add(eventTwo);
        eventList.add(eventThree);
        eventList.add(eventFour);
        List<Event> eventListWithoutDoubles = eventList.stream().distinct().toList();
        System.out.println(eventListWithoutDoubles);

        Integer[] array = {4, 1, 4, 6, 8, 9, 0, 3, 1, 5, 4, 6, 2, 3};

        StreamApp streamApp = new StreamApp();
        List integerListFromArray = streamApp.getIntegerList(array, 5);
        System.out.println(integerListFromArray);
        List integerListFromArrayByStream = streamApp.getIntegerListByStream(array, 5);
        System.out.println(integerListFromArrayByStream);

    }

    private List getIntegerList(Integer[] array, int value) {
        List integerList = new ArrayList<>();
        for (int i : array) {
            if (i < value) {
                integerList.add(i);
            }
        }
        return integerList;
        //method adds values from array to list if value(from array) is smaller than "value"
    }

    private List getIntegerListByStream(Integer[] array, int value) {
        List<Integer> collect = Arrays.stream(array).filter(element -> element < value).collect(Collectors.toList());
        return collect;
    }
}
