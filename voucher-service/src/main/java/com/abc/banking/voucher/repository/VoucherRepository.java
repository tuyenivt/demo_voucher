package com.abc.banking.voucher.repository;

import java.util.List;

import com.abc.banking.voucher.model.Voucher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    List<Voucher> findByPhone(String phone);
}