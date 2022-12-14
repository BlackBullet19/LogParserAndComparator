package logparser.model;

import java.util.Objects;

public class Event {

    private String source;
    private String date;
    private String destination;
    private Action action;
    private ActionState state;

    public Event(String source, String destination, ActionState state) {
        this.source = source;
        this.destination = destination;
        this.state = state;
    }

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "source='" + source + '\'' +
                ", date='" + date + '\'' +
                ", destination='" + destination + '\'' +
                ", action=" + action +
                ", state=" + state +
                '}';
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public ActionState getState() {
        return state;
    }

    public void setState(ActionState state) {
        this.state = state;
    }

    public int getDestinationLength() {
        return destination.length();
    }

    public int getSourceIntValueSum() {
        String tmp = source.substring(0, 2);
        int value = tmp.charAt(0) - '0' + tmp.charAt(1) - '0';//+ tmp.charAt(2)-'0';
                return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(destination, event.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }
}
