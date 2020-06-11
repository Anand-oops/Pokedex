package PokeDetails;

import com.google.gson.annotations.SerializedName;

public class Stat {
    @SerializedName("base_stat")
    private Integer baseStat;
    @SerializedName("effort")
    private Integer effort;
    @SerializedName("stat")
    private StatEntry stat;

    public Integer getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public StatEntry getStat() {
        return stat;
    }

    public void setStat(StatEntry stat) {
        this.stat = stat;
    }

    class StatEntry {
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
