package Donut;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DonutService {
    private final DonutRepository donutRepository;

    @Autowired
    public DonutService(DonutRepository donutRepository) {
        this.donutRepository = donutRepository;
    }

    public List<Donut> getDonuts(){
        return donutRepository.findAll();
    }

    public void addNewDonut(Donut donut) {

        Optional<Donut> donutoptional =
                donutRepository.findById(donut.getId());
        if (donutoptional.isPresent()) {
            throw new IllegalStateException("id taken");
        }
        System.out.println((donut));
        donutRepository.save(donut);
    }

    public void deleteDonut(Long donutId) {
        boolean exists = donutRepository.existsById(donutId);
        if (!exists) {
            throw  new IllegalStateException("donut with Id " + donutId + " does not exist");
        }
        else {
            donutRepository.deleteById(donutId);
        }

    }

    @Transactional
    public void updateDonut(Long donutId,
                            Float price) {
        Donut donut = donutRepository.findById(donutId)
                .orElseThrow(() -> new IllegalStateException(
                        "donut with id " + donutId + " doesn' t exist "
                ));

        if(price != null && price!=0 && !Objects.equals(donut.getPrice(), price)){
            donut.setPrice(price);
        }
    }

}
