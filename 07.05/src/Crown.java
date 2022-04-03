import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Crown {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());

        sb.append("@").append(new String(new char[n - 2]).replace("\0", " "))
                .append("@").append(new String(new char[n - 2]).replace("\0", " ")).append("@").append("\n");

        sb.append("**")
                .append(new String(new char[n - 3]).replace("\0", " "))
                .append("*").append(new String(new char[n - 3]).replace("\0", " ")).append("**").append("\n");

        int j = 1;

        for (int i = 1; i < (n / 2); i++) {
            if( i == (n / 2) - 1){
                sb.append("*").append(new String(new char[i]).replace("\0", ".")).append("*")
                         .append(new String(new char[j]).replace("\0", ".")).append("*")
                       .append(new String(new char[i]).replace("\0", ".")).append("*").append("\n");
            } else {
                sb.append("*").append(new String(new char[i]).replace("\0", ".")).append("*")
                        .append(new String(new char[(2*n-6-2*i-j)/2]).replace("\0", " "))
                        .append("*").append(new String(new char[j]).replace("\0", ".")).append("*")
                        .append(new String(new char[(2*n-6-2*i-j)/2]).replace("\0", " "))
                        .append("*").append(new String(new char[i]).replace("\0", ".")).append("*").append("\n");
            }
            j+=2;
        }


        sb.append("*")
                .append(new String(new char[n / 2]).replace("\0", "."))
                .append(new String(new char[(2*n -3 -n)/2]).replace("\0", "*"))
                .append(".").append(new String(new char[(2*n -3 -n)/2]).replace("\0", "*"))
                .append(new String(new char[n/2]).replace("\0", ".")).append("*").append("\n");

        sb.append(new String(new char[2*n - 1]).replace("\0", "*")).append("\n")
                .append(new String(new char[2*n - 1]).replace("\0", "*"));
        System.out.println(sb.toString());
    }
}
