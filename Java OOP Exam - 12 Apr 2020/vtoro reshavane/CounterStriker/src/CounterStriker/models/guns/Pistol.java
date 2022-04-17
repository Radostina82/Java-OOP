package CounterStriker.models.guns;

public class Pistol extends GunImpl{
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int decreaseBullet = super.getBulletsCount() -1;
        if (super.getBulletsCount() < 1){
            return 0;
        }else {
            super.setBulletsCount(super.getBulletsCount() -1);
            return 1;
        }

    }
}
