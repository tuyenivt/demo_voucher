package com.abc.banking.voucher.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import com.abc.banking.voucher.model.Voucher;
import com.abc.banking.voucher.repository.VoucherRepository;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VoucherServiceTests {

    @Autowired
    private VoucherService service;

    @MockBean
    private VoucherRepository repository;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    @DisplayName("Test getByPhone")
    void testGetByPhone() {
        // Setup our mock
        List<Voucher> vouchers = List.of(
            new Voucher("12345", "voucher-code-1"), 
            new Voucher("12345", "voucher-code-2")
        );
        doReturn(vouchers).when(repository).findByPhone("12345");

        // Execute the service call
        List<Voucher> results = service.getByPhone("12345");

        Assertions.assertEquals(2, results.size(), "getByPhone should return 2 vouchers");
    }
}
