package logparser.service;

import logparser.model.Event;

public class EventServiceImpl implements EventService {
    @Override
    public Event createEvent() {
        return new Event();
    }
}
