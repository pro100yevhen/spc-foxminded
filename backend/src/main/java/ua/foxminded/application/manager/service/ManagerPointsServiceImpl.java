package ua.foxminded.application.manager.service;

import org.springframework.stereotype.Service;
import ua.foxminded.domain.manager.model.entity.ManagerPoints;
import ua.foxminded.domain.manager.repository.ManagerPointsRepository;
import ua.foxminded.domain.manager.service.ManagerPointsService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ManagerPointsServiceImpl implements ManagerPointsService {

    private final ManagerPointsRepository managerPointsRepository;

    public ManagerPointsServiceImpl(final ManagerPointsRepository managerPointsRepository) {
        this.managerPointsRepository = managerPointsRepository;
    }

    @Override
    public ManagerPoints save(final ManagerPoints managerPoints) {
        return managerPointsRepository.save(managerPoints);
    }

    @Override
    public List<ManagerPoints> findByManagerId(final Long managerId) {
        return managerPointsRepository.findByManagerIdAndDate(managerId, LocalDate.now());
    }

    @Override
    public List<ManagerPoints> findAllByDateBetween(final LocalDate startDate, final LocalDate endDate) {
        return managerPointsRepository.findAllByDateBetween(startDate, endDate);
    }

    @Override
    public List<ManagerPoints> findAllByDateBetweenAndManagerId(final LocalDate startDate, final LocalDate endDate, final Long managerId) {
        return managerPointsRepository.findAllByDateBetweenAndManagerId(startDate, endDate, managerId);
    }

    @Override
    public List<ManagerPoints> findAllForToday() {
        return managerPointsRepository.findByDate(LocalDate.now());
    }
}