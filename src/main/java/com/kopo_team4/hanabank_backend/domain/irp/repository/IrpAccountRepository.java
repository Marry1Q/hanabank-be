package com.kopo_team4.hanabank_backend.domain.irp.repository;

import com.kopo_team4.hanabank_backend.domain.irp.entity.IrpAccount;
import com.kopo_team4.hanabank_backend.domain.irp.entity.IrpInvestmentProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IrpAccountRepository extends JpaRepository<IrpAccount, Long> {
    List<IrpAccount> findByIrpType(String irpType);
    Optional<IrpAccount> findByIrpId(Long irpId);
    List<IrpAccount> findByAccountId(String accountId);

}