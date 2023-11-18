package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.data.OpleidingRepository;
import nl.hu.inno.humc.student.domain.Opleiding;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OpleidingService {

    private final OpleidingRepository opleidingRepo;
    public OpleidingService(OpleidingRepository opleidingRepo) {
        this.opleidingRepo = opleidingRepo;
    }

    public Opleiding getOpleidingById(String id) {
        return opleidingRepo.findById(id).orElseThrow();
    }
}
