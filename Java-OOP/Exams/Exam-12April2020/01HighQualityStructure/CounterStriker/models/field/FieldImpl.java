package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field{

    public FieldImpl() {
    }

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players.stream().filter(player -> player.getClass().getSimpleName().equals("Terrorist")).collect(Collectors.toList());
        List<Player> counterTerrorists = players.stream().filter(player -> player.getClass().getSimpleName().equals("CounterTerrorist")).collect(Collectors.toList());

        while (terrorists.size() > 0 && counterTerrorists.size() > 0){
            for (var terrorPlayer:terrorists){
                for (var counterPlayer:counterTerrorists){
                    counterPlayer.takeDamage(terrorPlayer.getGun().fire());
                    if (!counterPlayer.isAlive()){
                        counterTerrorists.remove(counterPlayer);
                    }
                }
            }
            for (var counterPlayer:counterTerrorists){
                for (var terrorPlayer:terrorists){
                    terrorPlayer.takeDamage(counterPlayer.getGun().fire());
                    if (!terrorPlayer.isAlive()){
                        terrorists.remove(terrorPlayer);
                    }
                }
            }
        }
        if (terrorists.size() == 0){
            return COUNTER_TERRORIST_WINS;
        }else {
            return TERRORIST_WINS;
        }

    }
}
