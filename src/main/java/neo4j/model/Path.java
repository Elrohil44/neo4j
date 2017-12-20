package neo4j.model;
import org.neo4j.ogm.model.Result;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<Object> relationships;

    public Path(Result path) {
        if (path.queryResults().iterator().hasNext())
            relationships = (List<Object>) path.queryResults().iterator().next().getOrDefault("relationships", new ArrayList<Object>());
        else
            relationships = new ArrayList<>();
    }

    public Path() {
        relationships = new ArrayList<>();
    }

    public String describe(){
        StringBuilder builder = new StringBuilder();
        relationships.forEach(relation -> builder
                .append(relation)
                .append('\n'));
        return builder.toString();
    }
}
