import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InstockTest {
    private Instock instock;
    private Product product;

    @Before
    public void SetUp(){
        this.instock = new Instock();
        this.product = new Product("Test", 100.00, 10);
    }

    @Test
    public void testShouldAddProduct(){
        this.instock.add(product);
      Assert.assertTrue(this.instock.contains(product));

    }

}