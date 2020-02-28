package queue.pet;

public class PetEnter {
    private Pet pet;
    private long count;

    public PetEnter(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType() {
        return this.pet.getType();
    }
}
