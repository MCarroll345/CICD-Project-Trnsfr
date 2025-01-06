package ie.atu.bam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {


    List<Object> findByAccountIBAN1(int IBAN);

}
