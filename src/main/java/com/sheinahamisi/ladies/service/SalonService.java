package com.sheinahamisi.ladies.service;

import com.sheinahamisi.ladies.dtos.SalonDto;
import com.sheinahamisi.ladies.entity.Salon;

import java.util.List;

public interface SalonService {
    void addSalon(SalonDto salonDto);

    List<Salon> allSalons();

    Salon findSalon(Long salonId);

    void updateSalon(Long salonId, SalonDto salonDto);

    void deleteSalon(Long salonId);
}
