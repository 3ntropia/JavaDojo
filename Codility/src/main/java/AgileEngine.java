import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AgileEngine {

    static Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> usersCount = new HashMap<>();
        if(visits == null){
            return usersCount;
        }
        for(Map<String, UserStats> mapa: visits){
            for(Map.Entry<String, UserStats> entry: mapa.entrySet()){
                Long key = isLong(entry.getKey());
                Optional<UserStats> opValue = Optional.ofNullable(entry.getValue());
                Long value = 0L;
                if (!key.equals(0L)){
                    if(opValue.isPresent() && opValue.get().getVisitCount().isPresent()){
                        if(usersCount.containsKey(key)){
                            usersCount.put(key, usersCount.get(key) + opValue.get().getVisitCount().get());
                        }else{
                            usersCount.put(key, opValue.get().getVisitCount().get());
                        }
                    }else {
                        usersCount.put(key, value);
                    }
                }
            }
        }

        return usersCount;
    }

    private static Long isLong(String longValue){
        try {
            return Long.valueOf(longValue);
        }catch (NumberFormatException e){
            return 0L;
        }
    }

    public static class UserStats {
        Optional<Long> visitCount;

        public UserStats(Long visitCount) {
            this.visitCount = Optional.ofNullable(visitCount);
        }

        public Optional<Long> getVisitCount() {
            return visitCount;
        }

        public void setVisitCount(Long visitCount) {
            this.visitCount = Optional.ofNullable(visitCount);
        }
    }

}
