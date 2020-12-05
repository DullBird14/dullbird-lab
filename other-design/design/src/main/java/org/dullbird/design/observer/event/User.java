package org.dullbird.design.observer.event;

public class User {
    private BusEvent busEvent;

    public User() {
        busEvent  = new BusEvent();
        busEvent.register(this);
    }

    public void doUserSomeThing(Long userId) {
        System.out.println("do my self thing!==============");
        try {
            busEvent.post(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void doActionOne(Long id) {
        System.out.println("you are in action one,param=" + id);
    }

    @Subscribe
    public void doActionTwo(Long id) {
        System.out.println("you are in action two,param=" + id);
    }

    public static void main(String[] args) {
        User user = new User();
        user.doUserSomeThing(14l);
    }
}
