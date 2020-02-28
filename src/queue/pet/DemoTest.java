package queue.pet;

import java.util.LinkedList;
import java.util.Queue;

public class DemoTest {

    private Queue<PetEnter> dog;
    private Queue<PetEnter> cat;
    private long count;

    public DemoTest() {
        this.dog = new LinkedList<>();
        this.cat = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dog.add(new PetEnter(pet, count++));
        } else if (pet.getType().equals("cat")) {
            this.cat.add(new PetEnter(pet, count++));
        } else {
            return;
        }
    }

    public Pet pollAll() {
        if (!this.dog.isEmpty() && !this.cat.isEmpty()) {
            if (this.dog.peek().getCount() < this.cat.peek().getCount()) {
                return this.dog.poll().getPet();
            } else {
                return this.cat.poll().getPet();
            }
        } else if (!this.dog.isEmpty()) {
            return this.dog.poll().getPet();
        } else if (!this.cat.isEmpty()) {
            return this.cat.poll().getPet();
        } else {
            throw new RuntimeException("Kong");
        }
    }

    public Dog pollDog() {
        if (!this.isDogQueueEmpty()) {
            return (Dog) this.dog.poll().getPet();
        } else {
            throw new RuntimeException("Dog Kong");
        }
    }

    private boolean isDogQueueEmpty() {
        return this.dog.isEmpty();
    }

    public Cat pollCat() {
        if (!this.isCatQueueEmpty()) {
            return (Cat) this.cat.poll().getPet();
        } else {
            throw new RuntimeException("Cat Kong");
        }
    }

    private boolean isCatQueueEmpty() {
        return this.cat.isEmpty();
    }

    public boolean isEmpty() {
        return this.dog.isEmpty() && this.cat.isEmpty();
    }

    public static void main(String[] args) {

    }

}
