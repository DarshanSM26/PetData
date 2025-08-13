package com.Group3tatastrive.VetPawtner.Service;

import com.Group3tatastrive.VetPawtner.Entity.Dashboard;
import com.Group3tatastrive.VetPawtner.Repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public List<Dashboard> getAllDashboards() {
        return dashboardRepository.findAll();
    }

    public Dashboard saveDashboard(Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    public Dashboard updateDashboard(Integer id, Dashboard dashboard) {
        Dashboard dashboard1 = dashboardRepository.findById(id).orElse(null);
            dashboard1.setUser(dashboard.getUser());
            dashboard1.setTotalPets(dashboard.getTotalPets());
            dashboard1.setTotalOrders(dashboard.getTotalOrders());
            return dashboardRepository.save(dashboard1);
    }



    public Dashboard deleteDashboard(Integer id) {
        Dashboard dashboard = dashboardRepository.findById(id).orElse(null);
        if (dashboard != null) {
            dashboardRepository.delete(dashboard);
        }
        return dashboard;
    }
}
