package neo4j.commands;

import neo4j.Input;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public interface Command {
    Input scanner = new Input(System.in);

    void execute();
}
