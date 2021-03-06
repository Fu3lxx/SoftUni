package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player{
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    public PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.isAlive = true;
        this.setGun(gun);
    }
    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }
    public void setHealth(int health) {
        if (health < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }
    public void setArmor(int armor) {
        if (armor < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }
    public void setGun(Gun gun) {
        if (gun == null){
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (armor >= points){
            this.armor -= points;
        }else {
            int health = (getHealth() + getArmor()) - points;
            if (health > 0){
                this.health = health;
                this.armor = 0;
            }
            else {
                this.health = 0;
                this.armor = 0;
                this.isAlive = false;
            }
        }
    }
}
