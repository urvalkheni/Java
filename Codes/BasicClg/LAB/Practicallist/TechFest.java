import java.util.ArrayList;
import java.util.List;

class Event {
    protected int eventId;
    protected String eventName;
    protected String date;
    protected String venue;
    protected int maxTeamSize;
    protected int durationHours;
    protected String theme;

    public Event(int eventId, String eventName, String date, String venue, int maxTeamSize, int durationHours, String theme) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
        this.maxTeamSize = maxTeamSize;
        this.durationHours = durationHours;
        this.theme = theme;
    }

    public void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
        System.out.println("Max Team Size: " + maxTeamSize);
        System.out.println("Duration (hours): " + durationHours);
        System.out.println("Theme: " + theme);
    }
}

interface Registrable {
    void registerParticipant(String name);
    void showParticipants();
}

class CodingEvent extends Event implements Registrable {
    private List<String> participants = new ArrayList<>();

    public CodingEvent(int eventId, String eventName, String date, String venue, int maxTeamSize, int durationHours, String theme) {
        super(eventId, eventName, date, venue, maxTeamSize, durationHours, theme);
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
    private List<String> participants = new ArrayList<>();

    public RoboticsEvent(int eventId, String eventName, String date, String venue, int maxTeamSize, int durationHours, String theme) {
        super(eventId, eventName, date, venue, maxTeamSize, durationHours, theme);
    }

    @Override
    public void registerParticipant(String name) {
        if (participants.size() < maxTeamSize) {
            participants.add(name);
            System.out.println(name + " registered for Robotics Event!");
        } else {
            System.out.println("Team is full! Cannot register " + name);
        }
    }

    @Override
    public void showParticipants() {
        System.out.println("Participants in Robotics Event: " + participants);
    }
}

class HackathonEvent extends Event implements Registrable {
    private List<String> participants = new ArrayList<>();

    public HackathonEvent(int eventId, String eventName, String date, String venue, int maxTeamSize, int durationHours, String theme) {
        super(eventId, eventName, date, venue, maxTeamSize, durationHours, theme);
    }

    @Override
    public void registerParticipant(String name) {
        if (participants.size() < maxTeamSize) {
            participants.add(name);
            System.out.println(name + " registered for Hackathon!");
        } else {
            System.out.println("Team is full! Cannot register " + name);
        }
    }

    @Override
    public void showParticipants() {
        System.out.println("Participants in Hackathon Event: " + participants);
    }
}

public class TechFest {
    public static void main(String[] args) {
        Event e1 = new CodingEvent(1937, "C-Quest", "12-Oct-2025", "Lab A", 5, 3, "Competitive Coding");
        Event e2 = new RoboticsEvent(2737, "RoboFest", "13-Oct-2025", "Lab B", 4, 6, "AI Bots");
        Event e3 = new HackathonEvent(858, "Hackout 2025", "14-Oct-2025", "Hall Opera", 6, 48, "Innovation & Startups");
        Event e4 = new HackathonEvent(6879, "MaxZone", "20-Oct-2025", "Hall C", 8, 24, "Smart City Solutions");

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
