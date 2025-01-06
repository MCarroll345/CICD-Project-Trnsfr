package ie.atu.bam;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {


    List<Object> findByAccountIBAN1(int IBAN);

}
