package com.sheinahamisi.ladies.service;

import com.sheinahamisi.ladies.dtos.SalonDto;
import com.sheinahamisi.ladies.entity.Salon;
import com.sheinahamisi.ladies.error.SalonNotFoundException;
import com.sheinahamisi.ladies.repository.SalonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {
    private final SalonRepository salonRepository;

    @Transactional
    @Override
    public void addSalon(SalonDto salonDto) {
        Salon salon = new Salon();
        if (!salonDto.getName().equals("")) {
            salon.setName(salonDto.getName());
        }
        if (!salonDto.getImage().equals("")) {
            salon.setImage(salonDto.getImage());
        }
        if (!salonDto.getLocation().equals("")) {
            salon.setLocation(salonDto.getLocation());
        }
        if (!salonDto.getPhone().equals("")) {
            salon.setPhone(salonDto.getPhone());
        }
        if (salonDto.getRatings() != null) {
            salon.setRatings(salonDto.getRatings());
        }
        if (!salonDto.getWorkingHours().equals("")) {
            salon.setWorkingHours(salonDto.getWorkingHours());
        }

        salonRepository.save(salon);
    }

    @Override
    public List<Salon> allSalons() {
        List<Salon> salons = salonRepository.findAll();
        if (salons.isEmpty()) {
            salons.add(
                    Salon.builder()
                            .name("SALON NOT FOUND")
                            .build()
            );
        }
        return salons;
    }

    @Override
    public Salon findSalon(Long salonId) {
        Optional<Salon> salon = salonRepository.findById(salonId);
        salon.orElseThrow(() -> new SalonNotFoundException("NO_SALON_FOUND_WITH_ID: " + salonId));
        return salon.get();
    }

    @Transactional
    @Override
    public void updateSalon(Long salonId, SalonDto salonDto) {
        Optional<Salon> salon = salonRepository.findById(salonId);
        salon.orElseThrow(() -> new SalonNotFoundException("NO_SALON_FOUND_WITH_ID: " + salonId));
        if (!salonDto.getName().equals("")) {
            salon.get().setName(salonDto.getName());
        }
        if (!salonDto.getImage().equals("")) {
            salon.get().setImage(salonDto.getImage());
        }
        if (!salonDto.getLocation().equals("")) {
            salon.get().setLocation(salonDto.getLocation());
        }
        if (!salonDto.getPhone().equals("")) {
            salon.get().setPhone(salonDto.getPhone());
        }
        if (salonDto.getRatings() != null) {
            salon.get().setRatings(salonDto.getRatings());
        }
        if (!salonDto.getWorkingHours().equals("")) {
            salon.get().setWorkingHours(salonDto.getWorkingHours());
        }

        salonRepository.save(salon.get());
    }

    @Transactional
    @Override
    public void deleteSalon(Long salonId) {
        Optional<Salon> salon = salonRepository.findById(salonId);
        salon.orElseThrow(() -> new SalonNotFoundException("NO_SALON_FOUND_WITH_ID: " + salonId));
        salonRepository.deleteById(salonId);
    }
}
