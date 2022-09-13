package comparatorApp;

import logparser.model.ActionState;
import logparser.model.Event;

import java.util.*;

public class ComparatorApp {


    public static void main(String[] args) {

        Event eventOne = new Event("192.8.33.5", "netflix.com", ActionState.valueOf("OK"));
        Event eventTwo = new Event("127.3.56.1", "facebook.com", ActionState.valueOf("FAIL"));
        Event eventThree = new Event("188.8.44.2", "instagram.com", ActionState.valueOf("PAUSE"));
        Event eventFour = new Event("88.4.15.4", "ebay.de", ActionState.valueOf("OK"));

        Event[] events = {eventOne, eventTwo, eventThree, eventFour};

        Comparator<Event> compareActionState = new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.getState().compareTo(o2.getState());
            }
        };

        Comparator<Event> compareDestination = new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return Integer.compare(o1.getDestinationLength(), o2.getDestinationLength());
            }
        };

        Comparator<Event> compareSource = new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return Integer.compare(o1.getSourceIntValueSum(), o2.getSourceIntValueSum());
            }
        };

        ComparatorApp comparatorApp = new ComparatorApp();
        Map<Event, List<Event>> sortedEventsMap = comparatorApp.getSortedEventsMap(events, compareActionState);

    }


    private Map<Event, List<Event>> getSortedEventsMap(Event[] events, Comparator comparator) {
        Map<Event, List<Event>> listMap = new TreeMap<>(comparator);
        for (Event event : events) {
            List<Event> eventList = new ArrayList<>();
            for (Event eventFromArray : events) {
                if (eventFromArray != event) {
                    eventList.add(eventFromArray);
                }
            }
            eventList.sort(comparator.reversed());
            listMap.put(event, eventList);
        }
        return listMap;
    }
}
