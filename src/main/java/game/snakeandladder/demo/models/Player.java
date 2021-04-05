package game.snakeandladder.demo.models;

public class Player {
    private String name;
    private int position;
    private boolean doRollOfDie;
    private boolean winner;

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

    public boolean isDoRollOfDie() {
        return doRollOfDie;
    }

    public void setDoRollOfDie(boolean doRollOfDie) {
        this.doRollOfDie = doRollOfDie;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", status=" + doRollOfDie +
                ", winner='" + winner + '\'' +
                ']';
    }
}
