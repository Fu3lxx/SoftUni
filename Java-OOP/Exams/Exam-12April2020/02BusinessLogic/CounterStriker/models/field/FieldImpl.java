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
        int aliveTerrorists = terrorists.size();
        int aliveCounterTerrorists = counterTerrorists.size();
        boolean terroristWin = false;
        boolean counterTerroristWin = false;

        while (!terroristWin && !counterTerroristWin){
           for (Player terrorist:terrorists){
               if (terrorist.isAlive()){
                   for (Player counterTerrorist:counterTerrorists){
                       if (counterTerrorist.isAlive()){
                           counterTerrorist.takeDamage(terrorist.getGun().fire());
                           boolean someAlive = false;
                           for (Player player : counterTerrorists) {
                               if (player.isAlive()){
                                   someAlive = true;
                               }
                           }
                           if (!someAlive){
                               terroristWin = true;
                               break;
                           }
                       }
                   }
               }
           }
           
           for (Player counterTerrorist:counterTerrorists){
               if (counterTerrorist.isAlive()){
                   for (Player terrorist:terrorists){
                       if (terrorist.isAlive()){
                           terrorist.takeDamage(counterTerrorist.getGun().fire());
                           boolean someAlive = false;
                           for (var player:terrorists){
                               if (player.isAlive()){
                                   someAlive = true;
                               }
                           }
                           if (!someAlive){
                               counterTerroristWin = true;
                               break;
                           }
                       }
                   }
               }
           }
        }

       if (terroristWin){
           return TERRORIST_WINS;
       }else {
           return COUNTER_TERRORIST_WINS;
       }

    }
}
