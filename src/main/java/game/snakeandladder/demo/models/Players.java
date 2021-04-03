package game.snakeandladder.demo.models;

public class Players {
    private String name;
    private int position;
    private boolean status;
    private String winner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", status=" + status +
                ", winner='" + winner + '\'' +
                ']';
    }
}
