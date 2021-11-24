package WorkingWithAbstractionExercise.cardsWithPower;

public class Card {
    private RankPowers rankPower;
    private SuitPowers suitPower;

    public Card(RankPowers rankPower,SuitPowers suitPower){
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    public RankPowers getRankPower() {
        return rankPower;
    }

    public SuitPowers getSuitPower() {
        return suitPower;
    }

    public int getPower (){
        return rankPower.getPower() + suitPower.getPower();
    }
}
