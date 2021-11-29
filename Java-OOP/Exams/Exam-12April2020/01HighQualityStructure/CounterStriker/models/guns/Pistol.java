package CounterStriker.models.guns;

public class Pistol extends GunImpl{
    private static final int BULLET_PER_FIRE = 1;
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
        super.setBulletPerShot(BULLET_PER_FIRE);
    }
}
