package logparser;

import logparser.model.Event;
import logparser.model.User;
import logparser.service.*;

import java.util.List;
import java.util.Map;


public class ParserApp {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        EventService eventService = new EventServiceImpl();
        LogService logService = new LogServiceImpl(userService, eventService);
        Map<User, Map<String, List<Event>>> userMapMap = logService.prepareStructure();
        logService.compareEventsWithComparator();

    }
}
