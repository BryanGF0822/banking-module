package model.QueueModule;

import model.User;
import model.QueueModule.PriorityQueue.PriorityQueueHeap;
import model.QueueModule.QueueLibrary.*;

public class QueueModule {

    public IQueue<User> simpleQueue;
    private PriorityQueueHeap priorityQueue;
    private User current, next;

    public QueueModule() {
        simpleQueue = new Queue<User>();
        priorityQueue = new PriorityQueueHeap(100);
    }

    public boolean receivePerson(User u) {

        if (u.getSpecialCondition() != 0) {
            priorityQueue.enqueue(u);
        } else {

            simpleQueue.enqueue(u);

            if (simpleQueue.getLast().getV() == u) {
                return true;
            } else {
                return false;
            }

        }

        return true;
    }

    public String[] returnQueue() {
        String msgSimpleQueue = "";
        String msgPriorityQueue = "";
        for (int i = 0; i < simpleQueue.getSize(); i++) {
            if (simpleQueue.getLast().getV().isGender()) {
                // Mujer
                msgSimpleQueue = "\uD83D\uDEB6\u200D\u2640\uFE0F";
        
            } else {
                 // Hombre
                 msgSimpleQueue = "\uD83D\uDC71\u200D\u2642\uFE0F";
            }
        }
        for (int i = 1; i <= priorityQueue.lastIndex; i++) {

            switch (priorityQueue.getHeap()[i].getSpecialCondition()) {

                case 1:
                    msgPriorityQueue += "\uD83D\uDC68\u200D\uD83E\uDDAF";
                    break;
                case 2:
                    msgPriorityQueue += "\uD83D\uDC68\u200D\uD83E\uDDBD";
                    break;
                case 3:
                    msgPriorityQueue += "\uD83D\uDC69\u200D\uD83C\uDF7C";
                    break;

            }

        }
        String[] arreglo = new String[2];
        arreglo[0] = msgSimpleQueue;
        arreglo[1] = msgPriorityQueue;
        return arreglo;
    }

    public IQueue<User> getSimpleQueue() {
        return simpleQueue;
    }

    public void setSimpleQueue(IQueue<User> simpleQueue) {
        this.simpleQueue = simpleQueue;
    }

    public User getCurrent() {
        return current;
    }

    public void setCurrent(User current) {
        this.current = current;
    }

    public User getNext() {
        return next;
    }

    public void setNext(User next) {
        this.next = next;
    }

}