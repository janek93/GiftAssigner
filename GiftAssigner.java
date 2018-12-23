import java.util.*;


public class GiftAssigner {

    private List<String> buyers;
    private List<String> participants;

    public GiftAssigner(List<String> buyers, List<String> participants) {
        this.buyers = buyers;
        this.participants = participants;
    }

    public Map<String, List<String>> assign () {
        Map<String, List<String>> assigned = new HashMap<>();
        GiftAssigner giftAssigner = new GiftAssigner(buyers, participants);
        Random random = new Random();

        int numberOfBuyers = buyers.size();
        int numberOfParticipants = participants.size();
        int j=0;

        for (int i=0; i<numberOfParticipants; i++){
            String buyer = "";
            List<String> randomParticipants = new ArrayList<>();
            int randomParticipant = random.nextInt(numberOfParticipants);
            if (i>=numberOfBuyers){
                buyer = giftAssigner.buyers.get(j);
                j++;
                assigned.values();
            }
            else {
                buyer = giftAssigner.buyers.get(i);
            }
            randomParticipants.add(participants.get(randomParticipant));
            assigned.put(buyer, randomParticipants);
        }
        return assigned;
    }
}

//wylosować i przypisać osoby
//zwalidować poprawność przypisania
//jeżeli poprawne, to zwrócić wynik
//jeżeli niepoprawne, to powtórzyć przypisanie
//walidator zwaraca true lub false