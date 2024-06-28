package tobyspring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new WebApiExRatePaymentService(); //이 곳만 바꾸면 환율 정책을 바꿀 수 있음
        //하지만 매번 클래스 이름을 바꿔야함...!

        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
