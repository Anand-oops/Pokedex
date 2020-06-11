package PokeDetails;

import com.google.gson.annotations.SerializedName;

public class Type {
    @SerializedName("slot")
    private Integer slot;
    @SerializedName("type")
    private TypeEntry type;

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public TypeEntry getType() {
        return type;
    }

    public void setType(TypeEntry type) {
        this.type = type;
    }

    class TypeEntry {
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
