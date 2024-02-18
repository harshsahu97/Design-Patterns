import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

interface Observable {
    void add(Observer observer);

    void remove(Observer observer);

    void set(String vid);

    void notifyO();
}

public class ObserverDP {
    public static void main(String[] args) {
        Subscriber s1 = new Subscriber("Abh");
        Subscriber s2 = new Subscriber("Har");
        Subscriber s3 = new Subscriber("Sam");


        Channel channel = new Channel();
        s1.setChannel(channel);

        channel.add(s1);
        channel.add(s2);
        channel.add(s3);

        channel.set("PYGAMES");
    }
}

class Subscriber implements Observer {

    String name;
    Channel channel = new Channel();

    public Subscriber(String name) {
        this.name = name;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println(this.name + " are got a new vid " + channel.getData());
    }


}

class Channel implements Observable {
    List<Observer> list = new ArrayList<>();
    String vid;

    @Override
    public void add(Observer subscriber) {
        list.add(subscriber);
    }

    @Override
    public void remove(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void set(String vid) {
        this.vid = vid;
        notifyO();
    }

    @Override
    public void notifyO() {
        for (Observer ob : list) {
            ob.update();
        }
    }

    public String getData() {
        return vid;
    }
}
