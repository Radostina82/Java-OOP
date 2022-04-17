package CounterStriker.models.guns;

public class Rifle extends GunImpl{
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }


        @Override
        public int fire() {
            int decreaseBullet = super.getBulletsCount() -10;
            if (getBulletsCount() < 10){
                return 0;
            }else {
                super.setBulletsCount(super.getBulletsCount() -10);
                return 10;
            }

        }
}
