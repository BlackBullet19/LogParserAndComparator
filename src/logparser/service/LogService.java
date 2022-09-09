package logparser.service;

import logparser.model.Event;
import logparser.model.User;

import java.util.List;
import java.util.Map;

public interface LogService{

    Map<User, Map<String, List<Event>>> prepareStructure();
}
