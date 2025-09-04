package com.Group3tatastrive.VetPawtner.Controller;

import com.Group3tatastrive.VetPawtner.Entity.Dashboard;
import com.Group3tatastrive.VetPawtner.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/dashboard")
@CrossOrigin(origins = "http://localhost:5500")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("Feteching")
    public ResponseEntity<List<Dashboard>> getalldetailsofDashboard(){
        return ResponseEntity.ok(dashboardService.getAllDashboards());
    }

    @PostMapping
    public ResponseEntity<Dashboard> insertalldetailsofDashboard(@RequestBody Dashboard dashboard){
        return ResponseEntity.ok(dashboardService.saveDashboard(dashboard));
    }

    @PutMapping("{id}")
    public ResponseEntity<Dashboard> Updatealldetails(@PathVariable Integer id, @RequestBody Dashboard dashboard){
        return ResponseEntity.ok(dashboardService.updateDashboard(id, dashboard));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Dashboard> deletealldetails(@PathVariable Integer id){
        return ResponseEntity.ok(dashboardService.deleteDashboard(id));
    }
}
