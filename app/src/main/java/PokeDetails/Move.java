package PokeDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Move {
    @SerializedName("move")
    @Expose
    private MoveEntry move;

    public MoveEntry getMove() {
        return move;
    }

    public void setMove(MoveEntry move) {
        this.move = move;
    }

    class MoveEntry {
        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }
}
