package io.github.nazarovctrl.service;

public interface PaymentService {
    void receive(String id);

    boolean canRefund(String id);

    void refund(String id);
}
