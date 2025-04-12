public class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int circularTour(PetrolPump[] pumps) {
        int totalPetrol = 0;
        int currentPetrol = 0;
        int start = 0;

        for (int i = 0; i < pumps.length; i++) {
            totalPetrol += pumps[i].petrol - pumps[i].distance;
            currentPetrol += pumps[i].petrol - pumps[i].distance;

            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }

        return totalPetrol >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        int startPoint = circularTour(pumps);
        System.out.println("The tour can be completed starting at pump: " + startPoint);
    }
}
