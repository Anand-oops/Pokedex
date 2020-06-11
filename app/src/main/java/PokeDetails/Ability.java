package PokeDetails;

import com.google.gson.annotations.SerializedName;

public class Ability {
    @SerializedName("ability")
    private AbilityEntry ability;

    public AbilityEntry getAbility() {
        return ability;
    }

    public void setAbility(AbilityEntry ability) {
        this.ability = ability;
    }

    class AbilityEntry {
        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
