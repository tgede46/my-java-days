package test.java.ma.enset.myapp.service;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import ma.enset.myapp.service.*;



public class MyServiceTest {
    @Test
    public void testCompute(){   
    MyService service = new MyService();
    double a = 12;
    double b =8 ;
    double expected = 20;
    double result=service.compute(a, b);
    assertEquals(result,expected,0.001);
}
}