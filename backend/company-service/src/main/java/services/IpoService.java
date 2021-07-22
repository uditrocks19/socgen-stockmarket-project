package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.IPO;
import repositories.IPORepository;

@Service
public class IpoService {

    @Autowired
    IPORepository ipoRepository;


    public List<IPO> getAllIpos()
    {
        return ipoRepository.findAllByOrderByDateTimeAsc();
    }

    public IPO getIpoById(int id)
    {
        Optional<IPO> ipo = ipoRepository.findById(id);
        return ipo.orElse(null);

    }

    public IPO addIpo(IPO ipo)
    {
        return ipoRepository.save(ipo);
    }

    public Boolean deleteById(int id)
    {
        if(ipoRepository.findById(id).isPresent())
        {
            ipoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public IPO updateIpo(int id, IPO ipo) {
        Optional<IPO> ipoOptional = ipoRepository.findById(id);
        if(ipoOptional.isEmpty()) {
            return null;
        }
        ipo.setId(id);
        ipoRepository.save(ipo);
        return ipo;
    }

    public IPO getIpoByCompanyId(int companyId) {
        return ipoRepository.findByCompanyId(companyId);
    }
}