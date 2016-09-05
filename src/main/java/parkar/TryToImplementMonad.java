package parkar;

/**
 * Created by Abdhesh.Kumar on 01-09-2016.
 */
public class TryToImplementMonad {
    String name;

    public String getName() {
        String tempName = null;
        if (name == null) tempName = "Default Name";
        else tempName = name;
        return tempName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
