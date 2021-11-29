package CounterStriker.models.guns;

public class Rifle extends GunImpl{
    private static final int BULLETS_PER_FIRE = 10;
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
        super.setBulletPerShot(BULLETS_PER_FIRE);
    }
}
