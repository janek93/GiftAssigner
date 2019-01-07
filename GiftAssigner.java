import java.util.*;


final class GiftAssigner {

    private List<String> buyers;
    private List<String> participants;
    private Random random = new Random();

    GiftAssigner(List<String> buyers, List<String> participants) {
        this.buyers = buyers;
        this.participants = participants;
    }

    Map<String, List<String>> draw () {
        Map<String, List<String>> result;
        do {
            result = assign();
        }
        while (result == null);
        return result;
    }

    private Map<String, List<String>> assign () {
        Map<String, List<String>> assigned = new HashMap<>();
        List<String> participantsClone = new ArrayList<>(participants);
        for (int i=0; i<participants.size(); i++){
            String buyer = getBuyer(i);
            int randomParticipant = random.nextInt(participantsClone.size());
            List<String> drawedParticipants = getDrawedParticipants(assigned, buyer);
            drawedParticipants.add(participantsClone.get(randomParticipant));
            participantsClone.remove(randomParticipant);
            if (!drawedParticipants.contains(buyer)){
                assigned.put(buyer, drawedParticipants);
            }
        }
        return isValid(assigned) ? assigned : assign();
    }

    private List<String> getDrawedParticipants(Map<String, List<String>> assigned, String buyer) {
        return assigned.containsKey(buyer)
                ? assigned.get(buyer)
                : new ArrayList<>();
    }

    private String getBuyer(int i) {
        return buyers.get(i%buyers.size());
    }

    private boolean isValid (Map<String, List<String>> assigned){
        for (Map.Entry<String, List<String>> entry : assigned.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value.contains(key)) {
                return false;
            }
        }
        return true;
    }

}