import java.util.ArrayList;
import java.util.List;

class Event {
    protected int eventId;
    protected String eventName;
    protected String date;
    protected String venue;

    public Event(int eventId, String eventName, String date, String venue) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
    }

    public void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
    }
}

interface Registrable {
    void registerParticipant(String name);
    void showParticipants();
}

class CodingEvent extends Event implements Registrable {
    private int maxTeamSize;
    private List<String> participants = new ArrayList<>();

    public CodingEvent(int eventId, String eventName, String date, String venue, int maxTeamSize) {
        super(eventId, eventName, date, venue);
        this.maxTeamSize = maxTeamSize;
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Max Team Size: " + maxTeamSize);
    }

    @Override
    public void registerParticipant(String name) {
        if (participants.size() < maxTeamSize) {
            participants.add(name);
            System.out.println(name + " registered for Coding Event!");
        } else {
            System.out.println("Team is full! Cannot register " + name);
        }
    }

    @Override
    public void showParticipants() {
        System.out.println("Participants in Coding Event: " + participants);
    }
}

class RoboticsEvent extends Event implements Registrable {
    private String theme;
    private List<String> participants = new ArrayList<>();

    public RoboticsEvent(int eventId, String eventName, String date, String venue, String theme) {
        super(eventId, eventName, date, venue);
        this.theme = theme;
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Theme: " + theme);
    }

    @Override
    public void registerParticipant(String name) {
        participants.add(name);
        System.out.println(name + " registered for Robotics Event!");
    }

    @Override
    public void showParticipants() {
        System.out.println("Participants in Robotics Event: " + participants);
    }
}

class HackathonEvent extends Event implements Registrable {
    private int durationHours;
    private List<String> participants = new ArrayList<>();

    public HackathonEvent(int eventId, String eventName, String date, String venue, int durationHours) {
        super(eventId, eventName, date, venue);
        this.durationHours = durationHours;
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Duration (hours): " + durationHours);
    }

    @Override
    public void registerParticipant(String name) {
        participants.add(name);
        System.out.println(name + " registered for Hackathon!");
    }

    @Override
    public void showParticipants() {
        System.out.println("Participants in Hackathon Event: " + participants);
    }
}

public class TechFest {
    public static void main(String[] args) {
        Event e1 = new CodingEvent(1937, "C-Quest", "12-Oct-2025", "Lab A", 5);
        Event e2 = new RoboticsEvent(2737, "RoboFest", "13-Oct-2025", "Lab B", "AI Bots");
        Event e3 = new HackathonEvent(858, "Hackout 2025", "14-Oct-2025", "Hall Opera", 48);
        Event e4 = new HackathonEvent(6879, "MaxZone", "20-Oct-2025", "Hall C", 24);

        System.out.println("=== Event Details ===");
        e1.displayEventDetails();
        System.out.println();
        e2.displayEventDetails();
        System.out.println();
        e3.displayEventDetails();
        System.out.println();
        e4.displayEventDetails();
        System.out.println();

        Registrable r1 = (Registrable) e1;
        r1.registerParticipant("Urval");
        r1.showParticipants();
        System.out.println();

        Registrable r2 = (Registrable) e2;
        r2.registerParticipant("Heet");
        r2.showParticipants();
        System.out.println();

        Registrable r3 = (Registrable) e3;
        r3.registerParticipant("Rahul");
        r3.showParticipants();

        Registrable r4 = (Registrable) e4;
        r4.registerParticipant("Krish");
        r4.showParticipants();
    }
}
