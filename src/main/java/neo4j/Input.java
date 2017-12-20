package neo4j;

import java.io.InputStream;
import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input(InputStream r) {
        this.scanner = new Scanner(r);
    }

    public String nextLine(){
        while(!scanner.hasNextLine());
        return scanner.nextLine();
    }
}
