import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VLogger {
    private static Map<String,Set<String>> followers = new HashMap<>();
    private static Map<String,Set<String>> followings = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while (!line.equals("Statistics")){
            String[] lineTokens = line.split(" ");
            switch (lineTokens[1]){
                case "joined":
                    joinLogs(lineTokens[0]); break;
                case "followed":
                    if (!lineTokens[0].equals(lineTokens[2])) {
                        follow(lineTokens[0], lineTokens[2]);
                        break;
                    }
            }
            line = reader.readLine();
        }

        Map<String, Set<String>> sortedVloggers = new LinkedHashMap<>();
        followers.entrySet().stream()
                .sorted((v1, v2) -> {
                    if(v1.getValue().size() == v2.getValue().size()){
                        return followings.get(v1.getKey()).size() - followings.get(v2.getKey()).size();
                    }
                    return v2.getValue().size() - v1.getValue().size();
                })
                .forEachOrdered(x -> sortedVloggers.put(x.getKey(), x.getValue()));


        System.out.println("The V-Logger has a total of " + followers.size() + " vloggers in its logs.");
        int i = 1;
        for(Map.Entry<String, Set<String>> vlogger : sortedVloggers.entrySet() ){
            System.out.printf("%d. %s : %d followers, %d following%n", i, vlogger.getKey(), vlogger.getValue().size(), followings.get(vlogger.getKey()).size() );
            if(i == 1){
                for( String follower : vlogger.getValue()){
                    System.out.println("*  " + follower);
                }
            }
            i++;
        }
    }

    private static void follow(String follower, String followed) {
        try {
            followers.get(followed).add(follower);
            followings.get(follower).add(followed);
        } catch (Exception ignored){}
    }

    private static void joinLogs(String vlogger) {
        followers.putIfAbsent(vlogger, new TreeSet<>());
        followings.putIfAbsent(vlogger, new HashSet<>());
    }
}
